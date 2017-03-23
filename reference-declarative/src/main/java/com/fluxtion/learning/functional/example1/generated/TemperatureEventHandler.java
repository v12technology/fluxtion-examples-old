package com.fluxtion.learning.functional.example1.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.learning.functional.TemperatureEvent;

/**
 * Generated EventHandler for TemperatureEvent
 * @author Greg Higgins
 */
public class TemperatureEventHandler implements EventWrapper<TemperatureEvent>{

    private TemperatureEvent event;

    @EventHandler
    public boolean handleTemperatureEvent(TemperatureEvent event){
        this.event = event;
        return true;
    }

//    @EventHandler
//    public void handleTemperatureEvent(TemperatureEvent event){
//        this.event = event;
//    }
//    
    @Override
    public TemperatureEvent event() {
        return event;
    }

    @Override
    public Class<TemperatureEvent> eventClass() {
        return TemperatureEvent.class;
    }

}
