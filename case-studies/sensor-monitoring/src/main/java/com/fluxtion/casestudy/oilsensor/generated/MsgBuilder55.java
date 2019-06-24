package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder55 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.casestudy.oilsensor.generated.LessThanDecorator_53 source_LessThanDecorator_53_54;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("critical min breached:");
        msgSink.append(((com.fluxtion.casestudy.oilsensor.events.SoilPressure)source_LessThanDecorator_53_54.event()).value());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

