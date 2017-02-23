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
package com.fluxtion.learning.example10.generated;

import com.fluxtion.learning.example10.generated.ActivityProcessor;
import com.fluxtion.learning.example10.Events.AccelEvent;
import com.fluxtion.learning.example10.Events.ShowActivityAction;
import com.fluxtion.learning.example10.Events.ShowTimeAction;
import com.fluxtion.learning.example10.Events.Tick;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class ActiivityMonitorTest {
    
    @Test
    public void testMonitor(){
        ActivityProcessor processor = new ActivityProcessor();
        processor.init();
        //events - obejct re-use -> no allocations during 
        final Tick tick = new Tick();
        final AccelEvent accel = new AccelEvent();
        final ShowTimeAction showTime = new ShowTimeAction();
        final ShowActivityAction showActivity = new ShowActivityAction();
        
        //processing
        processor.handleEvent(tick);
        processor.handleEvent(showTime);
        processor.handleEvent(tick);
        accel.settAccel(10, 5, 0);
        processor.handleEvent(accel);
        accel.settAccel(6, 9, 0);
        processor.handleEvent(accel);
        accel.settAccel(3, 0, 2);
        processor.handleEvent(accel);
        processor.handleEvent(tick);
        processor.handleEvent(showActivity);
        processor.handleEvent(tick);
    }
}
