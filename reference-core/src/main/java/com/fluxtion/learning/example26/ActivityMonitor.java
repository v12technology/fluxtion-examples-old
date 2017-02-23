package com.fluxtion.learning.example26;

import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.learning.example10.Handlers.StairHandler;
import com.fluxtion.learning.example10.Handlers.StepHandler;

/**
 * A prototype activity monitor demonstrating no event references. The monitor
 * has three node dependencies:
 * <pre>
 * •	StepHandler
 * •	StairHandler
 * •	TickHandler
 *
 * The following functionality is provided:
 * •	Aggregate steps and stair count separately based on acceleration values.
 * •	Only update display when time ticks – NOT on acceleration events.
 *
 * </pre>
 *
 * On a tick the current accumulated activity will be displayed.
 *
 * The @NoEventReference filtering on node references StepHandler, StairHandler
 * means only event waves from tickHandler will pass through this class.
 * Condition-free logic correctly updating the display can be in the @OnEvent
 * method.
 *
 * @author greg
 */
public class ActivityMonitor {

    @NoEventReference
    public StepHandler stepHandler;
    @NoEventReference
    public StairHandler stairHandler;
    public TickHandler tickHandler;
    //for testing
    public int count;

    public ActivityMonitor(StepHandler stepHandler,
            StairHandler stairHandler,
            TickHandler tickHandler) {
        this.stepHandler = stepHandler;
        this.stairHandler = stairHandler;
        this.tickHandler = tickHandler;
    }

    public ActivityMonitor() {
    }

    @OnEvent
    public void updateDisplay() {
        System.out.printf("Steps:%2d, Stairs:%2d\n", stepHandler.stepCount, stairHandler.stairCount);
        count++;
    }

}
