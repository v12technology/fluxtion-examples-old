package com.fluxtion.sample.wordfrequency.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.extension.declarative.funclib.api.event.EofEvent;

/**
 * Generated EventHandler for EofEvent
 * @author Greg Higgins
 */
public class EofEventHandler implements EventWrapper<EofEvent>{

    private EofEvent event;

    @EventHandler
    public boolean handleEofEvent(EofEvent event){
        this.event = event;
        return true;
    }

    @Override
    public EofEvent event() {
        return event;
    }

    @Override
    public Class<EofEvent> eventClass() {
        return EofEvent.class;
    }

}
