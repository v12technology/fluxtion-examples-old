package com.fluxtion.learning.declarative.ext.example3.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.learning.declarative.ext.example3.FlightDelayProcessor.FlightDetails;
import com.fluxtion.learning.declarative.ext.example3.generated.FlightDetailsCsvMarshaller2;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_4 implements Wrapper<FlightDetails>{

    //source operand inputs
    public FlightDetailsCsvMarshaller2 filterSubject;
    public com.fluxtion.learning.declarative.ext.example3.generated.FlightDetailsCsvMarshaller2 source_FlightDetailsCsvMarshaller2_3;
    private com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan f;

    @Initialise
    public void init(){
        f = new  com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan();
    }

    @OnEvent
    public boolean onEvent(){
        return f.isGreaterThan((double)((com.fluxtion.learning.declarative.ext.example3.FlightDelayProcessor.FlightDetails)source_FlightDetailsCsvMarshaller2_3.event()).getDelay(), (double)0);
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

