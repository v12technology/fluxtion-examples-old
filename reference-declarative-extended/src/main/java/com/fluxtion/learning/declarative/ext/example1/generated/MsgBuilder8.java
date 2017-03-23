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
    public com.fluxtion.learning.declarative.ext.example1.generated.FxTradeHandler source_FxTradeHandler_7;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("-> Trade recived:'");
        msgSink.append(((com.fluxtion.learning.declarative.ext.helpers.FxTrade)source_FxTradeHandler_7.event()).ccyPair());
        msgSink.append("'@dealt:'");
        msgSink.append(((com.fluxtion.learning.declarative.ext.helpers.FxTrade)source_FxTradeHandler_7.event()).dealt());
        msgSink.append("' contra:'");
        msgSink.append(((com.fluxtion.learning.declarative.ext.helpers.FxTrade)source_FxTradeHandler_7.event()).contra());
        msgSink.append("'");
        msgSink.append('\n');
        return true;
    }
}

