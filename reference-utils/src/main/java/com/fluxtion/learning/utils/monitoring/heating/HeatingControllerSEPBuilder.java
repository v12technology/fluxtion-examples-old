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

import com.fluxtion.runtime.plugin.nodes.BetweenHoursTest;
import com.fluxtion.runtime.plugin.sep.AuditedSep;

/**
 *
 * @author V12 Technology Limited
 */
public class HeatingControllerSEPBuilder extends AuditedSep {

    @Override
    public void buildConfig() {
        TimerController heatingSignal = addNode(new TimerController(addNode(new BetweenHoursTest(7, 22))));
        addPublicNode(new BoilerController(heatingSignal), "boiler");
        addNode(new PumpController(heatingSignal));
        addPublicNode(new ControllerDisplay(heatingSignal), "display");
    }

}
