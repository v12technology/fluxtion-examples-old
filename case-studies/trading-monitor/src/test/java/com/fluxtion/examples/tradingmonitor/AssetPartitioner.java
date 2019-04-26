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

import com.fluxtion.api.event.Event;
import com.fluxtion.api.event.RegisterEventHandler;
import com.fluxtion.examples.tradingmonitor.portfolio.PortfolioTradeMonitor;
import com.fluxtion.examples.tradingmonitor.symbol.SymbolTradeMonitor;

/**
 *
 * @author V12 Technology Ltd.
 */
public class AssetPartitioner {

    private CharSequence ret;
    private final PortfolioTradeMonitor portfolio;

    public AssetPartitioner() {
        portfolio = new PortfolioTradeMonitor();
        portfolio.init();
    }
    
    public void initMonitor(SymbolTradeMonitor monitor) {
        monitor.assetTradePos.setSymbol(ret.toString());
        monitor.handleEvent(new RegisterEventHandler(portfolio));
    }

    public CharSequence keyGen(Event event) {
        ret = null;
        if (event instanceof AssetPrice) {
            ret = ((AssetPrice) event).getSymbol();
        }
        if (event instanceof Deal) {
            ret = ((Deal) event).getSymbol();
        }
        return ret;
    }

    public PortfolioTradeMonitor getPortfolio() {
        return portfolio;
    }
    
}
