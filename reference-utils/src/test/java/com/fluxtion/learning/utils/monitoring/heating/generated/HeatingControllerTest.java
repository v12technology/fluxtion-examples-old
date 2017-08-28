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
package com.fluxtion.learning.utils.monitoring.heating.generated;

import com.fluxtion.runtime.plugin.events.BooleanSignal;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import org.junit.Test;

/**
 *
 * @author V12 Technology Limited
 */
public class HeatingControllerTest {
    
    @Test
    public void demoHeatingSystem(){
        HeatingSystem heatingSystem = new HeatingSystem();
        heatingSystem.init();
        heatingSystem.logger.setLogSink(System.out::println);
        heatingSystem.propertyTracer.addConsolePublisher().addPropertyTrace("boiler", "flowTemperature", false);
        heatingSystem.propertyTracer.addConsolePublisher().addPropertyTrace("boiler", "returnTemperature", false);
        
        
        //send some flow/return temps
        heatingSystem.handleEvent(new NumericSignal("flowTemperature", 57));
        heatingSystem.handleEvent(new NumericSignal("returnTemperature", 55));
        
        
        //send a heating on request
        heatingSystem.handleEvent(new BooleanSignal("heatingOn", true));
        //should be sent by pump to event queue
        heatingSystem.handleEvent(new BooleanSignal("flowSignal", true));
        //should be sent by boiler to event queue
        heatingSystem.handleEvent(new BooleanSignal("burnerSignal", true));
        
        heatingSystem.handleEvent(new NumericSignal("flowTemperature", 59));
        heatingSystem.handleEvent(new NumericSignal("flowTemperature", 61));
        heatingSystem.handleEvent(new NumericSignal("flowTemperature", 65));
        heatingSystem.handleEvent(new NumericSignal("flowTemperature", 72));
        
        //force a flowSignalOff - should close boiler down
        //should be sent by pump to event queue
        heatingSystem.handleEvent(new BooleanSignal("flowSignal", false));
        //should be sent by boiler to event queue
        heatingSystem.handleEvent(new BooleanSignal("burnerSignal", false));
    }
}
