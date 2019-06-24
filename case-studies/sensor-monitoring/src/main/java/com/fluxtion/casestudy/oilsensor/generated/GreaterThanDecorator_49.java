package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.casestudy.oilsensor.events.SoilPressure;
import com.fluxtion.casestudy.oilsensor.generated.SoilPressureHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_49 implements Wrapper<SoilPressure>{

    //source operand inputs
    public SoilPressureHandler filterSubject;
    public com.fluxtion.casestudy.oilsensor.generated.SoilPressureHandler source_SoilPressureHandler_48;
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
        result = f.isGreaterThan((double)((com.fluxtion.casestudy.oilsensor.events.SoilPressure)source_SoilPressureHandler_48.event()).value(), (double)560);
        //updated = (oldValue != result) & result;
        return (!oldValue) & result;
    }

    @Override
    public SoilPressure event() {
        return filterSubject.event();
    }

    @Override
    public Class<SoilPressure> eventClass() {
        return SoilPressure.class;
    }

}

