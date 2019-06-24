package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder47 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.casestudy.oilsensor.generated.LessThanDecorator_45 source_LessThanDecorator_45_46;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("critical min breached:");
        msgSink.append(((com.fluxtion.casestudy.oilsensor.events.SoilPressure)source_LessThanDecorator_45_46.event()).value());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

