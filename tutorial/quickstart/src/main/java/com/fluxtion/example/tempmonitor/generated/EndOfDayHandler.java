package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.example.tempmonitor.TempHandler.EndOfDay;

/**
 * Generated EventHandler for EndOfDay
 * @author Greg Higgins
 */
public class EndOfDayHandler implements EventWrapper<EndOfDay>{

    private EndOfDay event;

    @EventHandler
    public boolean handleEndOfDay(EndOfDay event){
        this.event = event;
        return true;
    }

//    @EventHandler
//    public void handleEndOfDay(EndOfDay event){
//        this.event = event;
//    }
//    
    @Override
    public EndOfDay event() {
        return event;
    }

    @Override
    public Class<EndOfDay> eventClass() {
        return EndOfDay.class;
    }

}
