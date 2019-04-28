/*
 * Copyright (C) 2019 V12 Technology Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Server Side License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program.  If not, see 
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */
package com.fluxtion.examples.tradingmonitor;

import com.fluxtion.api.event.EventPublsher;
import com.fluxtion.builder.annotation.SepBuilder;
import com.fluxtion.builder.node.SEPConfig;
import com.fluxtion.ext.streaming.api.Wrapper;
import static com.fluxtion.ext.streaming.api.stream.NumericPredicates.lt;
import static com.fluxtion.ext.streaming.api.stream.NumericPredicates.outsideBand;
import static com.fluxtion.ext.streaming.builder.event.EventSelect.select;
import static com.fluxtion.ext.streaming.builder.stream.StreamBuilder.stream;
import static com.fluxtion.ext.streaming.builder.stream.StreamFunctionsBuilder.count;
import static com.fluxtion.ext.streaming.builder.stream.StreamFunctionsBuilder.cumSum;
import static com.fluxtion.ext.streaming.builder.stream.StreamFunctionsBuilder.multiply;
import static com.fluxtion.ext.streaming.builder.stream.StreamFunctionsBuilder.subtract;
import static com.fluxtion.ext.streaming.builder.util.FunctionArg.arg;
import com.fluxtion.ext.text.api.event.EofEvent;

/**
 *
 * @author V12 Technology Ltd.
 */
public class FluxtionBuilder {

    @SepBuilder(name = "SymbolTradeMonitor", 
            packageName = "com.fluxtion.examples.tradingmonitor.generated.symbol")
    public void buildAssetAnalyser(SEPConfig cfg) {
        //entry points
        Wrapper<Deal> deals = select(Deal.class);
        Wrapper<AssetPrice> prices = select(AssetPrice.class);
        AssetTradePos results = cfg.addPublicNode(new AssetTradePos(), "assetTradePos");
        //calculate derived values
        Wrapper<Number> cost = deals
                .map(multiply(), Deal::getSize, Deal::getPrice)
                .map(cumSum());
        Wrapper<Number> pos = deals.map(cumSum(), Deal::getSize);
        Wrapper<Number> mtm = pos.map(multiply(), Number::doubleValue,
                arg(prices, AssetPrice::getPrice));
        Wrapper<Number> pnl = subtract(mtm, cost);
        //add some rules - only fires on first breach
        pnl.filter(lt(-2000))
                .notifyOnChange(true)
                .map(count())
                .push(Number::intValue, results::setPnlBreaches);
        pos.filter(outsideBand(-200, 200))
                .notifyOnChange(true)
                .map(count())
                .push(Number::intValue, results::setPositionBreaches);
        //collect into results
        cost.push(Number::doubleValue, results::setCashPos);
        pos.push(Number::doubleValue, results::setAssetPos);
        mtm.push(Number::doubleValue, results::setMtm);
        pnl.push(Number::doubleValue, results::setPnl);
        //chain eventhandler to portfolio monitor
        EventPublsher publisher = cfg.addNode(new EventPublsher());
        publisher.addEventSource(results);
        //give some human readable names to nodes - not required 
        deals.id("deals");
        prices.id("prices");
        cost.id("cost");
        pos.id("pos");
        mtm.id("mtm");
        pnl.id("pnl");
    }
    
    @SepBuilder(name = "PortfolioTradeMonitor", 
            packageName = "com.fluxtion.examples.tradingmonitor.generated.portfolio")
    public void buildPortfolioAnalyser(SEPConfig cfg) {
        PortfolioTradePos portfolio = cfg.addNode(new PortfolioTradePos());
        stream(portfolio).filter( PortfolioTradePos::getPnl, lt(-10_000))
                .map(count())
                .notifierOverride(select(EofEvent.class))
                .console("portfolio loss gt 10k count -> ");
    }
}
