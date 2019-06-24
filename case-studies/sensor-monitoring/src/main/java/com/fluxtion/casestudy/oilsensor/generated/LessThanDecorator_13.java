package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.casestudy.oilsensor.events.WellPressure;
import com.fluxtion.casestudy.oilsensor.generated.WellPressureHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.LessThan
 * target method : isLessThan
 * 
 * @author Greg Higgins
 */
public class LessThanDecorator_13 implements Wrapper<WellPressure>{

    //source operand inputs
    public WellPressureHandler filterSubject;
    public com.fluxtion.casestudy.oilsensor.generated.WellPressureHandler source_WellPressureHandler_12;
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
        result = f.isLessThan((double)((com.fluxtion.casestudy.oilsensor.events.WellPressure)source_WellPressureHandler_12.event()).value(), (double)400);
        //updated = (oldValue != result) & result;
        return (!oldValue) & result;
    }

    @Override
    public WellPressure event() {
        return filterSubject.event();
    }

    @Override
    public Class<WellPressure> eventClass() {
        return WellPressure.class;
    }

}

