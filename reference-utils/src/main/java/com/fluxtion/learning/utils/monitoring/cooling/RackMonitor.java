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

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.runtime.plugin.nodes.EventLogNode;
import java.util.List;

/**
 *
 * @author greg
 */
public class RackMonitor extends EventLogNode {

    private final List<ServerTempMonitor> serverTemperatures;
    private long countWarning;
    private double percentWarning;

    public RackMonitor(List<ServerTempMonitor> serverTemperatures) {
        this.serverTemperatures = serverTemperatures;
    }

    @OnEvent
    public boolean updateWarningLevels() {
        countWarning = serverTemperatures.stream().filter(ServerTempMonitor::isTemperatureBreach).count();
        int prevPercent = (int) (percentWarning*100);
        percentWarning = countWarning / serverTemperatures.size();
        return prevPercent != (int) (percentWarning*100);
    }

    public long getCountWarning() {
        return countWarning;
    }

    public double getPercentWarning() {
        return percentWarning;
    }

    double getMaxTemperature() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
