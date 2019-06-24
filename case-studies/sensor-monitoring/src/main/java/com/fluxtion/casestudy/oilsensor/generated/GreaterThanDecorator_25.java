package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.casestudy.oilsensor.events.DrillTemp;
import com.fluxtion.casestudy.oilsensor.generated.DrillTempHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_25 implements Wrapper<DrillTemp>{

    //source operand inputs
    public DrillTempHandler filterSubject;
    public com.fluxtion.casestudy.oilsensor.generated.DrillTempHandler source_DrillTempHandler_24;
    private com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan f;
    private boolean result;

    @Initialise
    public void init(){
        f = new  com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan();
        result = false;
    }

    @OnEvent
    public boolean onEvent(){
        boolean oldValue = result;
        result = f.isGreaterThan((double)((com.fluxtion.casestudy.oilsensor.events.DrillTemp)source_DrillTempHandler_24.event()).value(), (double)150);
        //updated = (oldValue != result) & result;
        return (!oldValue) & result;
    }

    @Override
    public DrillTemp event() {
        return filterSubject.event();
    }

    @Override
    public Class<DrillTemp> eventClass() {
        return DrillTemp.class;
    }

}

