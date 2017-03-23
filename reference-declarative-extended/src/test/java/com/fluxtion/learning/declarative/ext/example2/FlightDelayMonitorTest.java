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
package com.fluxtion.learning.declarative.ext.example2;

import com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.FlightDetails;
import com.fluxtion.learning.declarative.ext.example2.generated.FlightDelayMonitor;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class FlightDelayMonitorTest {

    @Test
    public void testCarrierDelay() {
        FlightDelayMonitor monitor2 = new FlightDelayMonitor();
        monitor2.init();
        monitor2.handleEvent(new FlightDetails("BA", 100));
        monitor2.handleEvent(new FlightDetails("BA", -24));
        monitor2.handleEvent(new FlightDetails("Virgin", 30));
        monitor2.handleEvent(new FlightDetails("BA", 0));
        monitor2.handleEvent(new FlightDetails("Virgin", -1));
        monitor2.handleEvent(new FlightDetails("BA", 15));
        monitor2.handleEvent(new FlightDetails("UA", 66));
        monitor2.handleEvent(new FlightDetails("BA", 19));
        monitor2.carrierDelayMap.getMap().values().stream().map(w -> w.event()).forEach(System.out::println);
        
        FlightDelayProcessor.CarrierDelay BA = monitor2.carrierDelayMap.getMap().get("BA").event();
        FlightDelayProcessor.CarrierDelay Virgin = monitor2.carrierDelayMap.getMap().get("Virgin").event();
        //BA
        Assert.assertEquals(134, BA.getTotalDelayMins());
        Assert.assertEquals(3, BA.getTotalFlights());
        Assert.assertEquals(44, BA.getAvgDelay());
        //Virgin
        Assert.assertEquals(30, Virgin.getTotalDelayMins());
        Assert.assertEquals(1, Virgin.getTotalFlights());
        Assert.assertEquals(30, Virgin.getAvgDelay());
    }

}
