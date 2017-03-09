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
public class MsgBuilder12 extends MsgBuilder{

    //source operand inputs
    @NoEventReference
    public com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_1 source_CumSumInvoker_1_10;
    @NoEventReference
    public com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_3 source_CumSumInvoker_3_11;
    @NoEventReference
    public com.fluxtion.learning.declarative.ext.example1.generated.SubtractInvoker_6 source_SubtractInvoker_6_9;
    public Object logNotifier;
    private boolean notificationToLog;
    
    @OnParentUpdate(value = "logNotifier")
    public void postLog(Object logNotifier){
        notificationToLog = true;
    }

    @OnEvent
    public boolean buildMessage() {
        if(notificationToLog & isGoodToLog()){
            msgSink.append("<- Position update: EUR net:");
            msgSink.append(source_SubtractInvoker_6_9.intValue());
            msgSink.append(" dealt:");
            msgSink.append(source_CumSumInvoker_1_10.intValue());
            msgSink.append(" contra:");
            msgSink.append(source_CumSumInvoker_3_11.intValue());
            msgSink.append("");
            msgSink.append('\n');
            notificationToLog = false;
            return true;
        }
        notificationToLog = false;
        return false;
    }
}

