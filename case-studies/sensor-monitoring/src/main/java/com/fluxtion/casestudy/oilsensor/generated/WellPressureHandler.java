package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.casestudy.oilsensor.events.WellPressure;

/**
 * Generated EventHandler for WellPressure
 * @author Greg Higgins
 */
public class WellPressureHandler implements EventWrapper<WellPressure>{

    private WellPressure event;

    @EventHandler
    public boolean handleWellPressure(WellPressure event){
        this.event = event;
        return true;
    }

    @Override
    public WellPressure event() {
        return event;
    }

    @Override
    public Class<WellPressure> eventClass() {
        return WellPressure.class;
    }

}
