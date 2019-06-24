package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder15 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.casestudy.oilsensor.generated.LessThanDecorator_13 source_LessThanDecorator_13_14;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("critical min breached:");
        msgSink.append(((com.fluxtion.casestudy.oilsensor.events.WellPressure)source_LessThanDecorator_13_14.event()).value());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

