package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.example.tempmonitor.TempHandler.StartOfDay;

/**
 * Generated EventHandler for StartOfDay
 * @author Greg Higgins
 */
public class StartOfDayHandler implements EventWrapper<StartOfDay>{

    private StartOfDay event;

    @EventHandler
    public boolean handleStartOfDay(StartOfDay event){
        this.event = event;
        return true;
    }

    @Override
    public StartOfDay event() {
        return event;
    }

    @Override
    public Class<StartOfDay> eventClass() {
        return StartOfDay.class;
    }

}
