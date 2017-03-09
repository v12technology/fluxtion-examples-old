/*
 * Copyright (C) 2017 Greg Higgins
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
package com.fluxtion.learning.declarative.ext.example1;

import com.fluxtion.learning.DataEvent;
import com.fluxtion.learning.declarative.ext.example1.generated.FxTradeMonitor;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import org.junit.Test;

/**
 *
 * @author Greg Higgins
 */
public class FxMonitorTest {

    @Test
    public void simpleFilterHelperTest() throws Exception {

        EventHandler sep = new FxTradeMonitor();
        ((Lifecycle) sep).init();
        //fire some events for FX - ignored any non-Euro trades 
        DataEvent de1 = new DataEvent();
        de1.setFilterString("EU");
        de1.value = 2;
        sep.onEvent(de1);
        de1.setFilterString("EC");
        sep.onEvent(de1);
        de1.setFilterString("UE");
        sep.onEvent(de1);
        de1.value = 600;
        sep.onEvent(de1);
        de1.setFilterString("EY");
        sep.onEvent(de1);
        de1.setFilterString("CE");
        sep.onEvent(de1);
        de1.value = -1000;
        sep.onEvent(de1);
        sep.onEvent(de1);
        de1.value = 500;
        sep.onEvent(de1);
        sep.onEvent(de1);
        sep.onEvent(de1);
        sep.onEvent(de1);
        de1.value = -1500;
        sep.onEvent(de1);
    }
}
