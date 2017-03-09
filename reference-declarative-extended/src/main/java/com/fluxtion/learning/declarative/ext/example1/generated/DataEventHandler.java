package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.learning.DataEvent;

/**
 * Generated EventHandler for DataEvent
 * @author Greg Higgins
 */
public class DataEventHandler implements EventWrapper<DataEvent>{

    private DataEvent event;

    @EventHandler
    public boolean handleDataEvent(DataEvent event){
        this.event = event;
        return true;
    }

//    @EventHandler
//    public void handleDataEvent(DataEvent event){
//        this.event = event;
//    }
//    
    @Override
    public DataEvent event() {
        return event;
    }

    @Override
    public Class<DataEvent> eventClass() {
        return DataEvent.class;
    }

}
