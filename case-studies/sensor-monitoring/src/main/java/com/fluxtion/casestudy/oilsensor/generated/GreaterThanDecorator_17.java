package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.casestudy.oilsensor.events.DrillRpm;
import com.fluxtion.casestudy.oilsensor.generated.DrillRpmHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_17 implements Wrapper<DrillRpm>{

    //source operand inputs
    public DrillRpmHandler filterSubject;
    public com.fluxtion.casestudy.oilsensor.generated.DrillRpmHandler source_DrillRpmHandler_16;
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
        result = f.isGreaterThan((double)((com.fluxtion.casestudy.oilsensor.events.DrillRpm)source_DrillRpmHandler_16.event()).value(), (double)4000);
        //updated = (oldValue != result) & result;
        return (!oldValue) & result;
    }

    @Override
    public DrillRpm event() {
        return filterSubject.event();
    }

    @Override
    public Class<DrillRpm> eventClass() {
        return DrillRpm.class;
    }

}

