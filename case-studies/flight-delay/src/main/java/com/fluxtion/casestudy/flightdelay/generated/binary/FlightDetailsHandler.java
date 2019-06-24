package com.fluxtion.casestudy.flightdelay.generated.binary;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.casestudy.flightdelay.FlightDetails;

/**
 * Generated EventHandler for FlightDetails
 * @author Greg Higgins
 */
public class FlightDetailsHandler implements EventWrapper<FlightDetails>{

    private FlightDetails event;

    @EventHandler
    public boolean handleFlightDetails(FlightDetails event){
        this.event = event;
        return true;
    }

//    @EventHandler
//    public void handleFlightDetails(FlightDetails event){
//        this.event = event;
//    }
//    
    @Override
    public FlightDetails event() {
        return event;
    }

    @Override
    public Class<FlightDetails> eventClass() {
        return FlightDetails.class;
    }

}
