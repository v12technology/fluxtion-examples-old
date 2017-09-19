package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder7 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.example.tempmonitor.generated.MaxInvoker_1 source_MaxInvoker_1_6;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("NEW max temp ");
        msgSink.append(source_MaxInvoker_1_6.intValue());
        msgSink.append("C");
        msgSink.append('\n');
        return true;
    }
}

