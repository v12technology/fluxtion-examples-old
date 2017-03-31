/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.fx.example1;

import com.fluxtion.fx.util.CcyPair;
import com.fluxtion.runtime.event.Event;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class FxPrice extends Event {

    private double bid;
    private double offer;
    public CcyPair pair;

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public void setPair(String pair) {
        this.pair = CcyPair.valueOf(pair);
    }
    
    @Override
    public String toString() {
        return "FxPrice{" + "bid=" + bid + ", offer=" + offer + '}';
    }

}
