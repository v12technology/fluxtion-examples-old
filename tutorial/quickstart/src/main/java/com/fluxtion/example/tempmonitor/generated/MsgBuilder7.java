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
    public com.fluxtion.example.tempmonitor.generated.StartOfDayHandler source_StartOfDayHandler_6;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("===== Start of day ");
        msgSink.append(((com.fluxtion.example.tempmonitor.TempHandler.StartOfDay)source_StartOfDayHandler_6.event()).day());
        msgSink.append(" =====");
        msgSink.append('\n');
        return true;
    }
}

