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
package com.fluxtion.learning.example27;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.TemperatureEvent;

/**
 * All members are final and assigned in non-default constructor, demonstrates 
 * the ability of Fluxtion to a generate a SEP that can use non-standard api's
 * to deal with member encapsulating classes.
 * 
 * @author greg higgins
 */
public class HighTemperatureTest {
    
    private final int highLimit;
    private transient int temperature;

    public HighTemperatureTest(int highLimit) {
        this.highLimit = highLimit;
    }
    
    @EventHandler
    public boolean processTemp(TemperatureEvent tempEvent){
        temperature = tempEvent.getTemperature();
        return tempEvent.getTemperature() > highLimit;
    }

    public int getTemperature() {
        return temperature;
    }
}
