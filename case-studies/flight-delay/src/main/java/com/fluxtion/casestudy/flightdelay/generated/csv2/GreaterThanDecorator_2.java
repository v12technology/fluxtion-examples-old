package com.fluxtion.casestudy.flightdelay.generated.csv2;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.casestudy.flightdelay.generated.csv2.FlightDetailsCsvMarshaller0;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_2 implements Wrapper<FlightDetails>{

    //source operand inputs
    public FlightDetailsCsvMarshaller0 filterSubject;
    public com.fluxtion.casestudy.flightdelay.generated.csv2.FlightDetailsCsvMarshaller0 source_FlightDetailsCsvMarshaller0_1;
    private com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan f;

    @Initialise
    public void init(){
        f = new  com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan();
    }

    @OnEvent
    public boolean onEvent(){
        return f.isGreaterThan((double)((com.fluxtion.casestudy.flightdelay.FlightDetails)source_FlightDetailsCsvMarshaller0_1.event()).getDelay(), (double)0);
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

