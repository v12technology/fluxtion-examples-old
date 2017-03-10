package com.fluxtion.learning.functional.example1.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder1 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.learning.functional.example1.generated.TemperatureEventHandler source_TemperatureEventHandler_0;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("-> received temp: ");
        msgSink.append(((com.fluxtion.learning.functional.TemperatureEvent)source_TemperatureEventHandler_0.event()).getTemperature());
        msgSink.append("degC");
        msgSink.append('\n');
        return true;
    }
}

