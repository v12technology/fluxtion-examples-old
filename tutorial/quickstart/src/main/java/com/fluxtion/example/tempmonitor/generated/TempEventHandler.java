package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.example.tempmonitor.TempHandler.TempEvent;

/**
 * Generated EventHandler for TempEvent
 * @author Greg Higgins
 */
public class TempEventHandler implements EventWrapper<TempEvent>{

    private TempEvent event;

    @EventHandler
    public boolean handleTempEvent(TempEvent event){
        this.event = event;
        return true;
    }

//    @EventHandler
//    public void handleTempEvent(TempEvent event){
//        this.event = event;
//    }
//    
    @Override
    public TempEvent event() {
        return event;
    }

    @Override
    public Class<TempEvent> eventClass() {
        return TempEvent.class;
    }

}
