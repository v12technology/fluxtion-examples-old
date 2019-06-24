package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder35 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.casestudy.oilsensor.generated.GreaterThanDecorator_33 source_GreaterThanDecorator_33_34;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("critical max exceeded:");
        msgSink.append(((com.fluxtion.casestudy.oilsensor.events.DrillTemp)source_GreaterThanDecorator_33_34.event()).value());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

