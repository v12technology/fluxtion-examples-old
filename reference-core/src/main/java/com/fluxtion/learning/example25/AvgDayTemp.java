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
package com.fluxtion.learning.example25;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.TemperatureEvent;

/**
 * A temperature averaging node, that will only notify of change to avg at end
 * of day. Processes TemperatureEvent's but propogate = false prevenrts the 
 * event wave passing to children when a TemperatureEvent is received.
 * 
 * @author greg
 */
public class AvgDayTemp {
    
    private int count;
    private int sum;
    private int average;

    @EventHandler
    public void endOfDay(EndOfDayEvent eod){
        //replace old avgerage and reset
        average = sum/count;
        sum = 0;
        count = 0;
    }
    
    @EventHandler(propogate = false)
    public void processTemp(TemperatureEvent temperatureEvent){
        count++;
        sum += temperatureEvent.getTemperature();
    }

    public int getCount() {
        return count;
    }

    public int getSum() {
        return sum;
    }

    public int getAverage() {
        return average;
    }
    
    
}
