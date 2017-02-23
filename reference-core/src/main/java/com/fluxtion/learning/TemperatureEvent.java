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
package com.fluxtion.learning;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class TemperatureEvent extends Event{
    
    private int temperature;

    public TemperatureEvent(int temperature) {
        this.temperature = temperature;
    }

    public TemperatureEvent() {
    }
    

    /**
     * Get the value of temperature
     *
     * @return the value of temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Set the value of temperature
     *
     * @param temperature new value of temperature
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
