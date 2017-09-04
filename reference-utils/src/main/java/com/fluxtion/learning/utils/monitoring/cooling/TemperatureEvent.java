/*
 * Copyright (C) 2017 greg
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
package com.fluxtion.learning.utils.monitoring.cooling;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class TemperatureEvent extends Event{
    
    private double tempInC;

    public TemperatureEvent(String temperatureSource, double tempInC) {
        super(NO_ID, temperatureSource);
        this.tempInC = tempInC;
    }

    public double getTempInC() {
        return tempInC;
    }
    
}
