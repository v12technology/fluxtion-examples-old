package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.casestudy.oilsensor.events.DrillTemp;

/**
 * Generated EventHandler for DrillTemp
 * @author Greg Higgins
 */
public class DrillTempHandler implements EventWrapper<DrillTemp>{

    private DrillTemp event;

    @EventHandler
    public boolean handleDrillTemp(DrillTemp event){
        this.event = event;
        return true;
    }

    @Override
    public DrillTemp event() {
        return event;
    }

    @Override
    public Class<DrillTemp> eventClass() {
        return DrillTemp.class;
    }

}
