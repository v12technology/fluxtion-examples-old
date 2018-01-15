package com.fluxtion.learning.declarative.ext.music.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder15 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.learning.declarative.ext.music.generated.GroupBy_11 source_GroupBy_11_14;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("summary:");
        msgSink.append(source_GroupBy_11_14.event());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

