package com.fluxtion.casestudy.creditmonitor.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder3 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.casestudy.creditmonitor.generated.GreaterThanDecorator_1 source_GreaterThanDecorator_1_2;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("very big order: ");
        msgSink.append(((com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder)source_GreaterThanDecorator_1_2.event()).getAmount());
        msgSink.append(" customer:");
        msgSink.append(((com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder)source_GreaterThanDecorator_1_2.event()).getCustomerId());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

