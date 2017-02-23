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
package com.fluxtion.learning.example5;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.TearDown;
import com.fluxtion.learning.TemperatureEvent;

/**
 *
 * @author greg
 */
public class TemperatureBucket {

    private int minTemperature;
    private int maxTemperature;
    private int count;
    private boolean rangeSet;

    @EventHandler
    public void handleTemp(TemperatureEvent tempRreading) {
        int temp = tempRreading.getTemperature();
        if (rangeSet && temp > minTemperature && temp <= maxTemperature) {
            count++;
        }
    }

    @Initialise
    public void init() {
        count = 0;
        rangeSet = false;
    }

    @TearDown
    public void dispalyBucketResult() {
        if (rangeSet) {
            System.out.printf("range %3d -> %3d count:%3d\n", minTemperature, maxTemperature, count);
        }
    }

    public void setRange(int min, int max) {
        minTemperature = min;
        maxTemperature = max;
        rangeSet = true;
    }
}
