/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example14.generated;

import com.fluxtion.learning.example10.Events.AccelEvent;
import com.fluxtion.learning.example14.ActionEvent;
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
        //events - obejct re-use -> no allocations during execution
        final ActionEvent tick = new ActionEvent("tick");
        final AccelEvent accel = new AccelEvent();
        final ActionEvent showTime = new ActionEvent("showTime");
        final ActionEvent showActivity = new ActionEvent("showActivity");
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
