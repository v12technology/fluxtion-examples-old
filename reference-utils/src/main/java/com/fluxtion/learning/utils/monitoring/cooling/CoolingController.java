/*
 * Copyright (C) 2017 greg
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
package com.fluxtion.learning.utils.monitoring.cooling;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.runtime.plugin.nodes.EventLogNode;

/**
 *
 * @author greg
 */
public class CoolingController extends EventLogNode {

    private final RackMonitor rackMonitor;
    private double airTemperature;
    private double percentageWaterCooling;
    private double percentageAirCooling;

    public CoolingController(RackMonitor rackMonitor) {
        this.rackMonitor = rackMonitor;
    }

    @EventHandler(filterString = "external")
    public void temperatureEvent(TemperatureEvent temperatureEvent) {
        this.airTemperature = temperatureEvent.getTempInC();
        rackWarningLevelChanged();
    }

    @OnEvent
    public void rackWarningLevelChanged() {
        double useAir = airTemperature < 30 ? 0 : 1;
        double percentWarning = rackMonitor.getPercentWarning();
        if (percentWarning == 0) {
            percentageAirCooling = 0;
            percentageWaterCooling = 0;
        } else if (percentWarning <= 0.25) {
            percentageAirCooling = 0.25 * useAir;
            percentageWaterCooling = useAir == 0 ? 0.25 : 0;
        } else if (percentWarning <= 0.50) {
            percentageAirCooling = 0.75 * useAir;
            percentageWaterCooling = 0.6;
        } else if (percentWarning <= 0.75) {
            percentageAirCooling = 1.0 * useAir;
            percentageWaterCooling = 0.9;
        } else {
            percentageWaterCooling = 1.0;
            percentageAirCooling = 1.0 * useAir;
        }
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public double getPercentageWaterCooling() {
        return percentageWaterCooling;
    }

    public double getPercentageAirCooling() {
        return percentageAirCooling;
    }

}
