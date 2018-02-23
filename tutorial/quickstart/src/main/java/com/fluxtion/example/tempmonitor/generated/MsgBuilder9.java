package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder9 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.example.tempmonitor.generated.MaxInvoker_1 source_MaxInvoker_1_8;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("NEW max temp ");
        msgSink.append(source_MaxInvoker_1_8.intValue());
        msgSink.append("C");
        msgSink.append('\n');
        return true;
    }
}

