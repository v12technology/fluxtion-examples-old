package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnParentUpdate;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder15 extends MsgBuilder{

    //source operand inputs
    @NoEventReference
    public com.fluxtion.example.tempmonitor.generated.AvgInvoker_3 source_AvgInvoker_3_14;
    public Object logNotifier;
    private boolean notificationToLog;
    
    @OnParentUpdate(value = "logNotifier")
    public void postLog(Object logNotifier){
        notificationToLog = true;
    }

    @OnEvent
    public boolean buildMessage() {
        if(notificationToLog & isGoodToLog()){
            msgSink.append("End of day - avg temp:");
            msgSink.append(source_AvgInvoker_3_14.intValue());
            msgSink.append("C");
            msgSink.append('\n');
            notificationToLog = false;
            return true;
        }
        notificationToLog = false;
        return false;
    }
}

