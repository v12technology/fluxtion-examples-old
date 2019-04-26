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

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.event.Event;

/**
 *
 * @author V12 Technology Ltd.
 */
public class AssetTradePos extends Event {

    private String symbol;
    private double pnl;
    private double assetPos;
    private double mtm;
    private double cashPos;
    private int positionBreaches;
    private int pnlBreaches;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getAssetPos() {
        return assetPos;
    }

    public void setAssetPos(double assetPos) {
        this.assetPos = assetPos;
    }

    public double getMtm() {
        return mtm;
    }

    public void setMtm(double mtm) {
        this.mtm = mtm;
    }

    public double getPnl() {
        return pnl;
    }

    public void setPnl(double pnl) {
        this.pnl = pnl;
    }

    public double getCashPos() {
        return cashPos;
    }

    public void setCashPos(double cashPos) {
        this.cashPos = cashPos;
    }

    public int getPositionBreaches() {
        return positionBreaches;
    }

    public void setPositionBreaches(int positionBreaches) {
        this.positionBreaches = positionBreaches;
    }

    public int getPnlBreaches() {
        return pnlBreaches;
    }

    public void setPnlBreaches(int pnlBreaches) {
        this.pnlBreaches = pnlBreaches;
    }

    @Override
    public String toString() {
        return "AssetTradePos{" + "symbol=" + symbol + ", pnl=" + pnl + ", assetPos=" + assetPos + ", mtm=" + mtm + ", cashPos=" + cashPos + ", positionBreaches=" + positionBreaches + ", pnlBreaches=" + pnlBreaches + '}';
    }

    @OnEvent
    public boolean updated(){
        return true;
    }
}
