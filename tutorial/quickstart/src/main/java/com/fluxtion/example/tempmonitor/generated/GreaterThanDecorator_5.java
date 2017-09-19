package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.Test;

/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_5 implements Test{

    //source operand inputs
    public com.fluxtion.example.tempmonitor.generated.TempEventHandler source_TempEventHandler_4;
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
        result = f.isGreaterThan((double)((com.fluxtion.example.tempmonitor.TempHandler.TempEvent)source_TempEventHandler_4.event()).getTemp(), (double)25);
        //updated = (oldValue != result) & result;
        return (!oldValue) & result;
    }

}

