package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder39 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.casestudy.oilsensor.generated.LessThanDecorator_37 source_LessThanDecorator_37_38;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("critical min breached:");
        msgSink.append(((com.fluxtion.casestudy.oilsensor.events.DrillTemp)source_LessThanDecorator_37_38.event()).value());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

