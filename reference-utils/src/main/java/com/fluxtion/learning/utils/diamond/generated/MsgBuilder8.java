package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder8 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.learning.utils.diamond.DefaultNumeric source_DefaultNumeric_7;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("multiply=");
        msgSink.append(source_DefaultNumeric_7.doubleValue());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

