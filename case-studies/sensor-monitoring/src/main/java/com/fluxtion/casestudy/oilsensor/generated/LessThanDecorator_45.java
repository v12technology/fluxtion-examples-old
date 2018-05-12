package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.casestudy.oilsensor.events.SoilPressure;
import com.fluxtion.casestudy.oilsensor.generated.SoilPressureHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.LessThan
 * target method : isLessThan
 * 
 * @author Greg Higgins
 */
public class LessThanDecorator_45 implements Wrapper<SoilPressure>{

    //source operand inputs
    public SoilPressureHandler filterSubject;
    public com.fluxtion.casestudy.oilsensor.generated.SoilPressureHandler source_SoilPressureHandler_44;
    private com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.LessThan f;
    private boolean result;

    @Initialise
    public void init(){
        f = new  com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.LessThan();
        result = false;
    }

    @OnEvent
    public boolean onEvent(){
        boolean oldValue = result;
        result = f.isLessThan((double)((com.fluxtion.casestudy.oilsensor.events.SoilPressure)source_SoilPressureHandler_44.event()).value(), (double)200);
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

