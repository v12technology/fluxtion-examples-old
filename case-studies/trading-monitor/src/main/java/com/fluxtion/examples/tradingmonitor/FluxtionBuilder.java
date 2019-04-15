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

import com.fluxtion.builder.annotation.Disabled;
import com.fluxtion.builder.annotation.SepBuilder;
import com.fluxtion.builder.node.SEPConfig;
import com.fluxtion.ext.streaming.api.Wrapper;
import static com.fluxtion.ext.streaming.api.stream.NumericPredicates.lt;
import static com.fluxtion.ext.streaming.api.stream.StringPredicates.isEqual;
import static com.fluxtion.ext.streaming.builder.event.EventSelect.select;
import static com.fluxtion.ext.streaming.builder.stream.StreamFunctionsBuilder.cumSum;
import static com.fluxtion.ext.streaming.builder.stream.StreamFunctionsBuilder.multiply;
import static com.fluxtion.ext.streaming.builder.stream.StreamFunctionsBuilder.subtract;
import static com.fluxtion.ext.streaming.builder.util.FunctionArg.arg;

/**
 *
 * @author V12 Technology Ltd.
 */
public class FluxtionBuilder {
    
    @SepBuilder(name = "MsftTradeMonitor", packageName = "com.fluxtion.examples.tradingmonitor.msft")
    @Disabled
    public void buildMsftAnalysis(SEPConfig cfg) {
        Wrapper<Deal> deals = select(Deal.class).filter(Deal::getSymbol, isEqual("MSFT")).console("\t");
        Wrapper<AssetPrice> prices = select(AssetPrice.class).filter(AssetPrice::getSymbol, isEqual("MSFT")).console("\t");
       
        Wrapper<Number> cost = deals.map(multiply(), Deal::getSize, Deal::getPrice).map(cumSum());
        Wrapper<Number> pos = deals.map(cumSum(), Deal::getSize).console("\tpos -> ");
        Wrapper<Number> mtm = pos.map(multiply(), Number::doubleValue, arg(prices, AssetPrice::getPrice)).console("\tmtm -> ");
         
        Wrapper<Number> pnl = subtract(mtm, cost).console("\tpnl -> ");
        //add some rules
        pnl.filter(lt(-200)).console("WARN LOSS gt 200 ").notifyOnChange(true);
        
        //give some human readable names to nodes
        deals.id("deals");
        prices.id("prices");
        cost.id("cost");
        pos.id("pos");
        mtm.id("mtm");
        pnl.id("pnl");
    }
    
    @SepBuilder(name = "AllSymbolTradeMonitor", packageName = "com.fluxtion.examples.tradingmonitor.allasset")
    public void buildAnalysis(SEPConfig cfg) {
        Wrapper<Deal> deals = select(Deal.class).console("\t");
        Wrapper<AssetPrice> prices = select(AssetPrice.class).console("\t");
       
        Wrapper<Number> cost = deals.map(multiply(), Deal::getSize, Deal::getPrice).map(cumSum());
        Wrapper<Number> pos = deals.map(cumSum(), Deal::getSize).console("\tpos -> ");
        Wrapper<Number> mtm = pos.map(multiply(), Number::doubleValue, arg(prices, AssetPrice::getPrice)).console("\tmtm -> ");
         
        Wrapper<Number> pnl = subtract(mtm, cost).console("\tpnl -> ");
        //add some rules
        pnl.filter(lt(-200)).console("WARN LOSS gt 200 ").notifyOnChange(true);
        
        //give some human readable names to nodes
        deals.id("deals");
        prices.id("prices");
        cost.id("cost");
        pos.id("pos");
        mtm.id("mtm");
        pnl.id("pnl");
    }

    
}
