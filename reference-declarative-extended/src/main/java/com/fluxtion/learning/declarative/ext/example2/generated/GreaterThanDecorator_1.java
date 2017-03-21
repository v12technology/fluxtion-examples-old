package com.fluxtion.learning.declarative.ext.example2.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.FlightDetails;
import com.fluxtion.learning.declarative.ext.example2.generated.FlightDetailsHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_1 implements Wrapper<FlightDetails>{

    //source operand inputs
    public FlightDetailsHandler filterSubject;
    public com.fluxtion.learning.declarative.ext.example2.generated.FlightDetailsHandler source_FlightDetailsHandler_0;
    private com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan f;

    @Initialise
    public void init(){
        f = new  com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan();
    }

    @OnEvent
    public boolean onEvent(){
        return f.isGreaterThan((double)((com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.FlightDetails)source_FlightDetailsHandler_0.event()).getDelay(), (double)0);
    }

    @Override
    public FlightDetails event() {
        return filterSubject.event();
    }

    @Override
    public Class<FlightDetails> eventClass() {
        return FlightDetails.class;
    }

}

