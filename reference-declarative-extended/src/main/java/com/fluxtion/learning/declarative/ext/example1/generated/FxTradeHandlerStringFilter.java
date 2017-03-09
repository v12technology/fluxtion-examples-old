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
package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.learning.declarative.ext.helpers.FxTrade;

/**
 * Generated EventHandler for FxTrade
 * @author Greg Higgins
 */
public class FxTradeHandlerStringFilter implements EventWrapper<FxTrade>{

    private FxTrade event;

    @FilterId
    public String filter;

    @EventHandler
    public boolean handleFxTrade(FxTrade event){
        this.event = event;
        return true;
    }

//    @EventHandler
//    public void handleFxTrade(FxTrade event){
//        this.event = event;
//    }
//    
    @Override
    public FxTrade event() {
        return event;
    }

    @Override
    public Class<FxTrade> eventClass() {
        return FxTrade.class;
    }

}
