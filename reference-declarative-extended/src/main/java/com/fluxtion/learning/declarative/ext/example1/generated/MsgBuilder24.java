package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnParentUpdate;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder24 extends MsgBuilder{

    //source operand inputs
    @NoEventReference
    public com.fluxtion.learning.declarative.ext.example1.generated.SubtractInvoker_6 source_SubtractInvoker_6_23;
    public Object logNotifier;
    private boolean notificationToLog;
    
    @OnParentUpdate(value = "logNotifier")
    public void postLog(Object logNotifier){
        notificationToLog = true;
    }

    @OnEvent
    public boolean buildMessage() {
        if(notificationToLog & isGoodToLog()){
            msgSink.append("NEW 3 <- ** POS CRITICAL ** create   : -> EUR position:'");
            msgSink.append(source_SubtractInvoker_6_23.intValue());
            msgSink.append("' breached critical limit of 1000");
            msgSink.append('\n');
            notificationToLog = false;
            return true;
        }
        notificationToLog = false;
        return false;
    }
}

