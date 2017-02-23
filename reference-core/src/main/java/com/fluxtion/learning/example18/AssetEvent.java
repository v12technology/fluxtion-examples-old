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

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author Greg Higgins
 */
public class AssetEvent extends Event{

//    public static final int ID = 233;
//
//    public AssetEvent() {
//        super(ID);
//    }
//    
    private int valuation;
    
    public void setPortfolioName(String portfolioName){
        filterString = portfolioName;
    }
    
    public String getPortfolioName(){
        return filterString;
    }

    public int getValuation() {
        return valuation;
    }

    public void setValuation(int valuation) {
        this.valuation = valuation;
    }
    
}
