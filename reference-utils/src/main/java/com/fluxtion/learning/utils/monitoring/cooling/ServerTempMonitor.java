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
import com.fluxtion.runtime.plugin.nodes.EventLogNode;

/**
 *
 * @author greg
 */
public class ServerTempMonitor extends EventLogNode {

    private final String name;
    private final double warningLimit;
    private double temperature;
    private boolean temperatureBreach;

    public ServerTempMonitor(String name, double warningLimit) {
        this.name = name;
        this.warningLimit = warningLimit;
    }

    @EventHandler(filterVariable = "name")
    public boolean temperatureEvent(TemperatureEvent temperatureEvent) {
        boolean prev = temperature < warningLimit;
        this.temperature = temperatureEvent.getTempInC();
        temperatureBreach = temperature < warningLimit;
        return temperatureBreach != prev;
    }

    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWarningLimit() {
        return warningLimit;
    }

    public boolean isTemperatureBreach() {
        return temperatureBreach;
    }

}
