/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example13.generated;

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
