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

import com.fluxtion.runtime.plugin.sep.AuditedSep;
import java.util.ArrayList;

/**
 *
 * @author greg
 */
public class CoolingSepConfig extends AuditedSep {

    @Override
    public void buildConfig() {
        ArrayList<ServerTempMonitor> serverMonitors = new ArrayList<>();
        serverMonitors.add(addPublicNode(new ServerTempMonitor("server1", 45), "server1"));
        serverMonitors.add(addPublicNode(new ServerTempMonitor("server2", 45), "server2"));
        serverMonitors.add(addPublicNode(new ServerTempMonitor("svrNy", 55), "svrNy"));
        serverMonitors.add(addPublicNode(new ServerTempMonitor("svrLD", 40), "svrLD"));
        serverMonitors.add(addPublicNode(new ServerTempMonitor("svrTky", 67), "svrTky"));
        RackMonitor rackMonitor = addPublicNode(new RackMonitor(serverMonitors), "rackMonitor");
        addPublicNode(new CoolingController(rackMonitor), "coolingContol");
    }

}
