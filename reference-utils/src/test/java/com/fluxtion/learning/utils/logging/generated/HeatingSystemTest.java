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
package com.fluxtion.learning.utils.logging.generated;

import com.fluxtion.learning.utils.logging.HeatingSystemConfig.FlowSensorOff;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.FlowSensorOn;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.HeatOff;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.HeatOn;
import org.junit.Test;

/**
 *
 * @author V12 Technology Limited
 */
public class HeatingSystemTest {
    
    @Test
    public void testHeating(){
        HeatingSystem heatingSystem = new HeatingSystem();
        heatingSystem.init();
        heatingSystem.logger.setLogSink(System.out::println);
        //request heating etc
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOn());
        //off - on - fail pump
        heatingSystem.onEvent(new HeatOff());
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOff());
        
    }
}
