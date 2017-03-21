package com.fluxtion.learning.declarative.ext.example3.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.learning.declarative.ext.example3.FlightDelayProcessor.FlightDetails;

/**
 * generated Test wrapper.
 *
 * target class  : FlightDetails
 * 
 * @author Greg Higgins
 */

public class FlightDetailsCsvMarshaller2 implements Wrapper<FlightDetails> {

    private FlightDetails target;
    public Csv2Double csvSrc_0;
    public Csv2ByteBuffer csvSrc_1;
    private int headerLines = 1;

    @EventHandler(filterId = '\n')
    public boolean onEol(CharEvent event) {
        target.setDelay((int) csvSrc_0.doubleValue());
        target.setCarrier((java.lang.String) csvSrc_1.asString());
    headerLines--;
    return headerLines < 0;
    }

    @Override
    public FlightDetails event() {
        return target;
    }

    @Override
    public Class<FlightDetails> eventClass() {
        return FlightDetails.class;
    }

    @Initialise
    public void init(){
        target = new FlightDetails();
    }

}


