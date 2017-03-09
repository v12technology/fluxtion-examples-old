package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.Test;

/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.LessThan
 * target method : isLessThan
 * 
 * @author Greg Higgins
 */
public class LessThanDecorator_18 implements Test{

    //source operand inputs
    public com.fluxtion.learning.declarative.ext.example1.generated.SubtractInvoker_6 source_SubtractInvoker_6_17;
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
        result = f.isLessThan(source_SubtractInvoker_6_17.doubleValue(), (double)10);
        //updated = (oldValue != result) & result;
        return (!oldValue) & result;
    }

}

