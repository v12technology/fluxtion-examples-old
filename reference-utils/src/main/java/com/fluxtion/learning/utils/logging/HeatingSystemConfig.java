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
package com.fluxtion.learning.utils.logging;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.runtime.event.Event;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.logging.EventLogSource;
import com.fluxtion.runtime.plugin.logging.EventLogger;

/**
 * Simple notional boiler system with a pump and boiler. To turn on heating:
 * 
 * <ul>
 * <li>pump: HeatOn signal
 * <li>boiler: HeatOn & FlowSensorOn signal
 * </ul>
 * 
 * @author V12 Technology Limited
 */
public class HeatingSystemConfig extends SEPConfig{
    
    public static class HeatOn extends Event{}
    public static class HeatOff extends Event{}
    public static class FlowSensorOn extends Event{}
    public static class FlowSensorOff extends Event{}

    @Override
    public void buildConfig() {
        Pump pump = addPublicNode(new Pump(), "pump");
        Boiler boiler = addPublicNode(new Boiler(pump), "boiler");
        addPublicNode(new ControlDisplay(boiler, pump), "display");
        //add logger
        addAuditor(new EventLogManager(), "logger");
    }
    
    
    
    public static class Pump implements EventLogSource {

        private EventLogger log;
        private boolean running;

        public boolean isRunning() {
            return running;
        }

        @Override
        public void setLogger(EventLogger log) {
            this.log = log;
        }

        @EventHandler
        public void heatingOn(HeatOn heatOn){
            log.info("heatingOn.request", true);
            log.info("pump.start", true);
            running = true;
        }
        
        @EventHandler
        public void heatingOff(HeatOff heatOn){
            log.info("heatingOn.request", false);
            log.info("pump.start", false);
            running = false;
        }
        
    }
    
    public static class Boiler implements EventLogSource {

        private EventLogger log;
        private final Pump pump;
        private boolean waterFlow;
        private boolean requestHeating;
        private boolean boilerRunning;

        public Boiler(Pump pump) {
            this.pump = pump;
            boilerRunning = false;
        }

        public boolean isBoilerRunning() {
            return boilerRunning;
        }
        
        @Override
        public void setLogger(EventLogger log) {
            this.log = log;
        }

        @EventHandler
        public void waterFlowOn(FlowSensorOff heatOn){
            log.info("waterFlowing", false);
            this.waterFlow = false;
            boilerControl();
        }

        @EventHandler
        public void waterFlowOn(FlowSensorOn heatOn){
            log.info("waterFlowing", true);
            this.waterFlow = true;
            boilerControl();
        }

        @EventHandler
        public void heatingOn(HeatOn heatOn){
            log.info("heatingOn.request", true);
            this.requestHeating = true;
            boilerControl();
        }
        
        @EventHandler
        public void heatingOff(HeatOff heatOn){
            log.info("heatingOff.request", true);
            this.requestHeating = false;
            boilerControl();
        }

        private void boilerControl(){
            log.info("currentBoilerRunning", boilerRunning);
            log.info("waterFlow", waterFlow);
            log.info("requestHeating", requestHeating);
            if(requestHeating & waterFlow){
                if(boilerRunning){
                    log.info("boilerChange", "leave running");
                }else{
                    log.info("boilerChange", "turn on");
                }
                boilerRunning = true;
            }else{
                if(boilerRunning){
                    log.info("boilerChange", "turn on");
                }else{
                    log.info("boilerChange", "leave off");
                }
                boilerRunning = false;
            }
            log.info("newBoilerRunningState", boilerRunning);
        }
        
    }
    
    public static class ControlDisplay implements EventLogSource {

        private EventLogger log;
        private boolean running;
        private final Boiler boiler;
        private final Pump pump;

        @Override
        public void setLogger(EventLogger log) {
            this.log = log;
        }
        

        public ControlDisplay(Boiler boiler, Pump pump) {
            this.boiler = boiler;
            this.pump = pump;
        }
        
        @OnEvent
        public void boilerUpdate(){
            running = boiler.isBoilerRunning() & pump.isRunning();
            boolean error = boiler.isBoilerRunning() & !pump.isRunning();
            if(error){
                log.info("heatingError", "boiler on no pump running");
                
            }else{
                log.info("heating", running?"on":"off");
            }
        }
        
    }
    
    
}
