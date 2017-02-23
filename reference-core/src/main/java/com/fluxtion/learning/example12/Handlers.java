package com.fluxtion.learning.example12;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.example12.Events.ShowActivityAction;
import com.fluxtion.learning.example12.Events.ShowTimeAction;
import com.fluxtion.learning.example12.Events.Tick;

/**
 *
 * @author greg
 */
public class Handlers {
    
    public static interface ActionHandler{}
    
    public static class ShowTimeHandler implements ActionHandler{
        @EventHandler
        public void showTimeRequest(ShowTimeAction event){}
    }
    
    public static class ShowActivityHandler implements ActionHandler{
        @EventHandler
        public void showActivityRequest(ShowActivityAction event){}
    }
    
    public static class ShowTickHandler implements ActionHandler{
        @EventHandler
        public void showActivityRequest(Tick event){}
    }
    
}
