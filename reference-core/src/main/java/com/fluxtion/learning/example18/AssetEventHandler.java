/* 
 * Copyright (C) 2016 Greg Higgins (greg.higgins@v12technology.com)
 *
 * This file is part of Fluxtion.
 *
 * Fluxtion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example18;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;

/**
 *
 * @author Greg Higgins
 */
public class AssetEventHandler {

    @FilterId
    public String portfolioName;

    private int valuation = Integer.MIN_VALUE;

    public AssetEventHandler(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public AssetEventHandler() {
    }

    public int getValuation() {
        return valuation;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    @EventHandler
    public boolean handleValuation(AssetEvent assetEvent) {
        //calculate %change if greater than 10% the notify
        boolean breach = false;
        if (valuation != Integer.MIN_VALUE) {
            double delta = Math.abs(valuation - assetEvent.getValuation()) / (double) valuation;
            System.out.println("delta[" + portfolioName + "] = " + delta);
            breach = delta > 0.1;
        }
        valuation = assetEvent.getValuation();
        return breach;
    }

    @Override
    public String toString() {
        return "AssetEventHandler{" + "portfolioName=" + portfolioName + ", val=" + valuation + '}';
    }

}
