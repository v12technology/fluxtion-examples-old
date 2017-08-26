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
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.tracing.TraceRecord;
import com.fluxtion.runtime.plugin.tracing.TraceRecordListener;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;

import org.junit.Test;

/**
 *
 * @author V12 Technology Limited
 */
public class HeatingSystemTest {

    @Test
    public void testTraceWithFluentApi() {
        System.out.println("testTraceWithFluentApi");
        HeatingSystem heatingSystem = new HeatingSystem();
        heatingSystem.init();
        //add publisher and property trace fluently
        heatingSystem.propertyTracer.addConsolePublisher().addPropertyTrace("boiler", "temperature", false);
//        heatingSystem.logger.setLogSink(System.out::println);
        //request heating etc
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOn());
        //off - on - fail pump
        heatingSystem.onEvent(new HeatOff());
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOff());
    }
    
    
    @Test
    public void traceWithDelegatingAuditorConfig(){
        System.out.println("traceWithDelegatingAuditorConfig");
        HeatingSystem heatingSystem = new HeatingSystem();
        heatingSystem.init();
        //create and register a tracer with delegating auditor
        Tracer recorder = new Tracer();
        heatingSystem.handleEvent(new AuditorRegistration(true, recorder));
        //add publisher
        recorder.listenerUpdate(new ListenerRegistrationEvent<>(TraceRecordListener.class,  (p) -> {
            System.out.println(p.getInstanceName() + "." + p.getPropertyName() + ": " + p.getFormattedValue());
        }, true));
        //add property trace
        recorder.recorderControl(new TracerConfigEvent("boiler", "temperature", true, false));
        //request heating etc
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOn());
        //off - on - fail pump
        heatingSystem.onEvent(new HeatOff());
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOff());
    }
    
    
    @Test
    public void traceWithEventConfig(){
        System.out.println("traceWithEventConfig");
        HeatingSystem heatingSystem = new HeatingSystem();
        heatingSystem.init();
        //add tracer publisher 
        heatingSystem.onEvent(new ListenerRegistrationEvent<>(TraceRecordListener.class, (TraceRecordListener) (TraceRecord p) -> {
            System.out.println(p.getInstanceName() + "." + p.getPropertyName() + ": " + p.getFormattedValue());
        }, true));
        //add property trace
        heatingSystem.onEvent(new TracerConfigEvent("boiler", "temperature", true, false));
        //request heating etc
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOn());
        //off - on - fail pump
        heatingSystem.onEvent(new HeatOff());
        heatingSystem.onEvent(new HeatOn());
        heatingSystem.onEvent(new FlowSensorOff());  
    }
}
