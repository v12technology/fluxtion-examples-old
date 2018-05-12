package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder11 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.casestudy.oilsensor.generated.GreaterThanDecorator_9 source_GreaterThanDecorator_9_10;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("critical max exceeded:");
        msgSink.append(((com.fluxtion.casestudy.oilsensor.events.WellPressure)source_GreaterThanDecorator_9_10.event()).value());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

