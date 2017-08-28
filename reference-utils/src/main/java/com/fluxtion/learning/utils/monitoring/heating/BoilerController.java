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
package com.fluxtion.learning.utils.monitoring.heating;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.runtime.plugin.events.BooleanSignal;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.nodes.EventLogNode;

/**
 *
 * @author V12 Technology Limited
 */
public class BoilerController extends EventLogNode {
    
    private final TimerController heatingSignal;
    private double flowTemperature;
    private double returnTemperature;
    private boolean lphwFlowing;
    private boolean fireBoiler;

    public BoilerController(TimerController heatingSignal) {
        this.heatingSignal = heatingSignal;
    }
    
    @EventHandler(filterString = "flowSignal", propagate = false)
    public void waterFlowSensor(BooleanSignal flowSignal){
        lphwFlowing = flowSignal.value();
        changedState();
    }
    
    @EventHandler(filterString = "flowTemperature", propagate = false)
    public void waterFlowTemperatureSensor(NumericSignal flowSignal){
        flowTemperature = flowSignal.value();
        log.info("flowTemperature", flowTemperature);
        log.info("returnTemperature", returnTemperature);
    }
    
    @EventHandler(filterString = "returnTemperature", propagate = false)
    public void waterReturnTemperatureSensor(NumericSignal flowSignal){
        returnTemperature = flowSignal.value();
        log.info("flowTemperature", flowTemperature);
        log.info("returnTemperature", returnTemperature);
    }
    
    @OnEvent
    public boolean changedState(){
        boolean prevBoilerFire = fireBoiler;
        fireBoiler = heatingSignal.isRunning() & lphwFlowing;
        log.info("enable", heatingSignal.isRunning());
        log.info("lphwFlowing", lphwFlowing);
        log.info("fireBoiler", fireBoiler);
        return prevBoilerFire;
    }

    public double getFlowTemperature() {
        return flowTemperature;
    }

    public double getReturnTemperature() {
        return returnTemperature;
    }

    public boolean isFireBoiler() {
        return fireBoiler;
    }
    
    @Initialise
    public void init(){
        flowTemperature = Double.NaN;
        returnTemperature = Double.NaN;
        lphwFlowing = false;
        fireBoiler = false;
    }
    
}
