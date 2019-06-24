package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.casestudy.oilsensor.events.DrillRpm;

/**
 * Generated EventHandler for DrillRpm
 * @author Greg Higgins
 */
public class DrillRpmHandler implements EventWrapper<DrillRpm>{

    private DrillRpm event;

    @EventHandler
    public boolean handleDrillRpm(DrillRpm event){
        this.event = event;
        return true;
    }

    @Override
    public DrillRpm event() {
        return event;
    }

    @Override
    public Class<DrillRpm> eventClass() {
        return DrillRpm.class;
    }

}
