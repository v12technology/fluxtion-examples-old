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
package com.fluxtion.learning.declarative.ext.example3;

import com.fluxtion.extension.declarative.funclib.builder.util.StringDriver;
import com.fluxtion.learning.declarative.ext.example3.FlightDelayProcessor.FlightDetails;
import com.fluxtion.learning.declarative.ext.example3.generated.FlightDelayMonitor;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class FlightDelayCsvMonitorTest {

    @Test
    public void testCarrierDelay() {
        FlightDelayMonitor monitor2 = new FlightDelayMonitor();
        monitor2.init();

        String s = "header line col_8=carrier col_14=delay\n"
                + "0,1,2,3,4,5,6,7,BA,9,10,11,12,13,100\n"
                + "0,1,2,3,4,5,6,7,BA,9,10,11,12,13,-24\n"
                + "0,1,2,3,4,5,6,7,Virgin,9,10,11,12,13,30\n"
                + "0,1,2,3,4,5,6,7,BA,9,10,11,12,13,0\n"
                + "0,1,2,3,4,5,6,7,Virgin,9,10,11,12,13,-1\n"
                + "0,1,2,3,4,5,6,7,BA,9,10,11,12,13,15\n"
                + "0,1,2,3,4,5,6,7,UA,9,10,11,12,13,66\n"
                + "0,1,2,3,4,5,6,7,BA,9,10,11,12,13,19\n"
                ;
        StringDriver.streamChars(s, monitor2, true);
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
