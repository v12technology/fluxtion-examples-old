package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.learning.utils.diamond.generated.NumericSignalHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_1 implements Wrapper<NumericSignal>{

    //source operand inputs
    public NumericSignalHandler filterSubject;
    public com.fluxtion.learning.utils.diamond.generated.NumericSignalHandler source_NumericSignalHandler_0;
    private com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan f;

    @Initialise
    public void init(){
        f = new  com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan();
    }

    @OnEvent
    public boolean onEvent(){
        return f.isGreaterThan((double)((com.fluxtion.runtime.plugin.events.NumericSignal)source_NumericSignalHandler_0.event()).value(), (double)5.0);
    }

    @Override
    public NumericSignal event() {
        return filterSubject.event();
    }

    @Override
    public Class<NumericSignal> eventClass() {
        return NumericSignal.class;
    }

}

