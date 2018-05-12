package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.casestudy.oilsensor.events.SoilPressure;

/**
 * Generated EventHandler for SoilPressure
 * @author Greg Higgins
 */
public class SoilPressureHandler implements EventWrapper<SoilPressure>{

    private SoilPressure event;

    @EventHandler
    public boolean handleSoilPressure(SoilPressure event){
        this.event = event;
        return true;
    }

    @Override
    public SoilPressure event() {
        return event;
    }

    @Override
    public Class<SoilPressure> eventClass() {
        return SoilPressure.class;
    }

}
