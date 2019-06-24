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

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.TearDown;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author V12 Technology Ltd.
 */
public class PortfolioTradePos {
   
    private HashMap<String, AssetTradePos> symbol2Pos;
    private ArrayList<AssetTradePos> assets;
    private double pnl;
    
    @EventHandler
    public void positionUpdate(AssetTradePos pos){
        symbol2Pos.putIfAbsent(pos.getSymbol(), pos);
        if(assets.size()!=symbol2Pos.size()){
            assets.clear();
            assets.addAll(symbol2Pos.values());
        }
        pnl = 0;
        for (int i = 0; i < assets.size(); i++) {
            pnl += assets.get(i).getPnl();
        }
        //uses streams slows the processing down by 25% and introduces gc's
//        pnl = symbol2Pos.values().stream().mapToDouble(AssetTradePos::getPnl).sum();
    }

    public double getPnl() {
        return pnl;
    }
    
    @TearDown
    public void publishReport(){
        System.out.println("Portfolio PnL:" + pnl);
        System.out.println("Assett positions:\n-----------------------------");
        symbol2Pos.forEach((s, a) -> {
            System.out.println(s + " : " + a);
        });
    }
    
    @Initialise
    public void init(){
        symbol2Pos = new HashMap<>();
        assets = new ArrayList<>();
    }
    
}
