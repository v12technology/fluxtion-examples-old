package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder13 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.example.tempmonitor.generated.MinInvoker_5 source_MinInvoker_5_12;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("NEW min temp ");
        msgSink.append(source_MinInvoker_5_12.intValue());
        msgSink.append("C");
        msgSink.append('\n');
        return true;
    }
}

