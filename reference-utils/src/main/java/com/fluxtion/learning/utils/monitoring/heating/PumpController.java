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
import com.fluxtion.runtime.plugin.nodes.EventLogNode;

/**
 *
 * @author V12 Technology Limited
 */
public class PumpController extends EventLogNode {

    private final TimerController heatingSignal;
    private boolean pumpRunning;

    public PumpController(TimerController heatingSignal) {
        this.heatingSignal = heatingSignal;
    }

    @EventHandler(filterString = "burnerSignal")
    public void burnerSensor(BooleanSignal burnerSensorSignal) {

    }

    @OnEvent
    public boolean changedState() {
        boolean prevPumpRunning = pumpRunning;
        pumpRunning =  heatingSignal.isRunning();
        log.info("pumpRunning", pumpRunning);
        return prevPumpRunning!=pumpRunning;
    }
    
    @Initialise
    public void init(){
        pumpRunning = false;
    }
}
