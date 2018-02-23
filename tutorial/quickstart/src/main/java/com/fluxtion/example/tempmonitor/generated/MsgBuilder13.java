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
public class MsgBuilder13 extends MsgBuilder{

    //source operand inputs
    @NoEventReference
    public com.fluxtion.example.tempmonitor.generated.TempEventHandler source_TempEventHandler_12;
    public Object logNotifier;
    private boolean notificationToLog;
    
    @OnParentUpdate(value = "logNotifier")
    public void postLog(Object logNotifier){
        notificationToLog = true;
    }

    @OnEvent
    public boolean buildMessage() {
        if(notificationToLog & isGoodToLog()){
            msgSink.append("Temp ");
            msgSink.append(((com.fluxtion.example.tempmonitor.TempHandler.TempEvent)source_TempEventHandler_12.event()).temp());
            msgSink.append("C has exceeded limit of 25C");
            msgSink.append('\n');
            notificationToLog = false;
            return true;
        }
        notificationToLog = false;
        return false;
    }
}

