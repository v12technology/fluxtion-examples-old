package com.fluxtion.learning.declarative.ext.example5.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnParentUpdate;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder0 extends MsgBuilder{

    //source operand inputs
    public Object logNotifier;
    private boolean notificationToLog;
    
    @OnParentUpdate(value = "logNotifier")
    public void postLog(Object logNotifier){
        notificationToLog = true;
    }

    @OnEvent
    public boolean buildMessage() {
        if(notificationToLog & isGoodToLog()){
            msgSink.append("PRINT MATCH RESULT ");
            msgSink.append('\n');
            notificationToLog = false;
            return true;
        }
        notificationToLog = false;
        return false;
    }
}

