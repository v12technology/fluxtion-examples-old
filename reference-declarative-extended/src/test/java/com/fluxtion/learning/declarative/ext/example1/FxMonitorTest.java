/* 
 * Copyright (C) 2017 V12 Technology Limited (greg.higgins@v12technology.com)
 *
 * This file is part of Fluxtion.
 *
 * Fluxtion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.declarative.ext.example1;

import com.fluxtion.learning.declarative.ext.helpers.FxTrade;
import com.fluxtion.learning.declarative.ext.example1.generated.FxTradeMonitor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Greg Higgins
 */
public class FxMonitorTest {

    @Test
    public void simpleFilterHelperTest() throws Exception {

        FxTradeMonitor sep = new FxTradeMonitor();
        sep.init();
        Number eurNetPos = sep.eurNetPos;
        //fire some events for FX - ignored any non-Euro trades 
        FxTrade trade = new FxTrade();
        sep.onEvent(trade.buy("EU", 4e6, 4.32e6));
        sep.onEvent(trade.sell("EU", 2e6, 2.17e6));
        assertEquals(2e6, eurNetPos.intValue(), DELTA);
        
        //ignore - pos unchanged
        sep.onEvent(trade.sell("UY", 2e6, 234.45e6));
        assertEquals(2e6, eurNetPos.intValue(), DELTA);
        
        sep.onEvent(trade.buy("UE", 3e6, 2.79e6));
        //log warning
        sep.onEvent(trade.buy("UE", 30e6, 27.9e6));
        sep.onEvent(trade.sell("UE", 3e6, 2.79e6));
        assertEquals(-25.9e6, eurNetPos.doubleValue(), DELTA);
        
        sep.onEvent(trade.sell("EY", 100e6, 132.34e8));
        assertEquals(-125.9e6, eurNetPos.doubleValue(), DELTA);
        //log critical
        sep.onEvent(trade.sell("EY", 200e6, 264.76e8));
        assertEquals(-325.9e6, eurNetPos.doubleValue(), DELTA);
        
        //remove critical
        sep.onEvent(trade.buy("EC", 200e6, 232.18e6));
        //remove warning
        sep.onEvent(trade.buy("EC", 130.9e6, 152.36e6));
        assertEquals(5e6, eurNetPos.doubleValue(), DELTA);
        
        sep.onEvent(trade.buy("EU", 4e6, 4.36e6));
        //log warning
        sep.onEvent(trade.buy("EU", 4e6, 4.36e6));
        assertEquals(13e6, eurNetPos.doubleValue(), DELTA);
        //remove warning
        sep.onEvent(trade.sell("EU", 4e6, 4.36e6));
        
        
        //log critical + warning
        sep.onEvent(trade.buy("EC", 245e6, 297.46e6));
        assertEquals(254e6, eurNetPos.doubleValue(), DELTA);
    }
    private static final double DELTA = 0.0001;
}
