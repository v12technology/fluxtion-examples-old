package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder10 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.learning.utils.diamond.generated.AddInvoker_6 source_AddInvoker_6_9;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("merge=");
        msgSink.append(source_AddInvoker_6_9.doubleValue());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

