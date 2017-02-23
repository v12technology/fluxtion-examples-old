package com.fluxtion.learning.example11;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.learning.example11.Events.Tick;
import com.fluxtion.learning.example11.Handlers.StairHandler;
import com.fluxtion.learning.example11.Handlers.StepHandler;
import com.fluxtion.learning.example11.Handlers.ActionHandler;
import java.time.LocalDateTime;

/**
 * A prototype activity monitor demonstrates OnParentUpdate annotation combined
 * with a filter on the annotation that matches variable name of the parent node.
 * This is useful when several parent nodes are of the same type, but different 
 * execution paths are required depending upon the parent that has updated.
 * The monitor handles:
 * <pre>
 * •	3-axis accewleration, 
 * •	time ticks, 
 * •	request to show activity
 * •	request to show time.
 * 
 * The following functionality is provided:
 * •	Aggregate steps and stair count separately based on acceleration values.
 * •	Only update display when time ticks – NOT on acceleration events.
 * •	User action selects to display time or activity, update display on next tick.

 * </pre>
 * 
 * On a tick the either time or current accumulated activity will be displayed.
 * 
 * The OnParentUpdate filtering on node class type allows simple logic to be 
 * implemented in the time EventHandler method. If all the logic was carried out
 * in an OnEvent method it would be unclear which button had been pressed without 
 * adding additional state and reseting the state at the end of the event cycle.
 * EventPath filtering greatly simplifies the code.
 * 
 * @author greg
 */
public class ActivityMonitor {
    public StepHandler stepHandler;
    public StairHandler stairHandler;
    public ActionHandler showTimeHandler;
    public ActionHandler showActivityHandler;

    public ActivityMonitor(StepHandler stepHandler, StairHandler stairHandler, ActionHandler  showTimeHandler, ActionHandler showActivityHandler) {
        this.stepHandler = stepHandler;
        this.stairHandler = stairHandler;
        this.showTimeHandler = showTimeHandler;
        this.showActivityHandler = showActivityHandler;
    }

    public ActivityMonitor() {
    }
    
    private boolean displayActivity;
    
    @OnParentUpdate("showTimeHandler")
    public void showTimeRequest(ActionHandler timeHandler){
        displayActivity = false;
    }
    
    @OnParentUpdate("showActivityHandler")
    public void showActivityRequest(ActionHandler activityHandler){
        displayActivity = true;
    }
    
    @EventHandler
    public void timeTick(Tick tick){
        if(displayActivity){
            System.out.printf("Steps:%2d, Stairs:%2d\n", stepHandler.stepCount, stairHandler.stairCount);
        }else{
            System.out.println("current time:" + LocalDateTime.now().toLocalTime());
        }
    }
    
    @Initialise
    public void init(){
        displayActivity = true;
    }
}
