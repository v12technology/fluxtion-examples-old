package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder8 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.learning.declarative.ext.example1.generated.DataEventHandler source_DataEventHandler_7;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("-> Trade recived:'");
        msgSink.append(((com.fluxtion.learning.DataEvent)source_DataEventHandler_7.event()).getStringValue());
        msgSink.append("'@'");
        msgSink.append(((com.fluxtion.learning.DataEvent)source_DataEventHandler_7.event()).getValue());
        msgSink.append("' ");
        msgSink.append('\n');
        return true;
    }
}

