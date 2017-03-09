/* 
 * Copyright (C) 2017 V12 Technology Limited
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
package com.fluxtion.learning.declarative.ext.helpers;

import com.fluxtion.runtime.event.Event;

/**
 * A simplified definition of an FX trade.
 * 
 * @author Greg Higgins
 */
public class FxTrade extends Event{

    public static final int ID = 1;
    private double contra;
    private double dealt;
    
    public FxTrade() {
        super(ID);
    }
    
    public FxTrade buy(String ccyPair, double dealt, double contra){
        this.filterString = ccyPair;
        this.dealt = dealt;
        this.contra = contra;
        return this;
    }
    
    public FxTrade sell(String ccyPair, double dealt, double contra){
        return buy(ccyPair, -dealt, -contra);
    }
    
    public double dealt() {
        return dealt;
    }

    public double contra() {
        return contra;
    }
    
    public String ccyPair() {
        return filterString;
    }
}
