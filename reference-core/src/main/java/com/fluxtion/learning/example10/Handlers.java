package com.fluxtion.learning.example10;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.example10.Events.AccelEvent;
import com.fluxtion.learning.example10.Events.ShowActivityAction;
import com.fluxtion.learning.example10.Events.ShowTimeAction;

/**
 *
 * @author greg
 */
public class Handlers {
    
    public static class StepHandler{
        
        public transient int stepCount;
        
        @EventHandler
        public void onAccel(AccelEvent accel){
            if(accel.z==0)
                stepCount++;
        }
    }
    
    public static class StairHandler{
        
        public transient int stairCount;
        
        @EventHandler
        public void onAccel(AccelEvent accel){
            if(accel.z!=0)
                stairCount++;
        }
    }
    
    public static class ShowTimeHandler{
        @EventHandler
        public void showTimeRequest(ShowTimeAction event){}
    }
    
    public static class ShowActivityHandler{
        @EventHandler
        public void showActivityRequest(ShowActivityAction event){}
    }
    
    
}
