package com.fluxtion.casestudy.creditmonitor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder;
import com.fluxtion.casestudy.creditmonitor.generated.PurchaseOrderHandler;
/**
 * generated Test wrapper.
 *
 * target class  : com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan
 * target method : isGreaterThan
 * 
 * @author Greg Higgins
 */
public class GreaterThanDecorator_1 implements Wrapper<PurchaseOrder>{

    //source operand inputs
    public PurchaseOrderHandler filterSubject;
    public com.fluxtion.casestudy.creditmonitor.generated.PurchaseOrderHandler source_PurchaseOrderHandler_0;
    private com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan f;

    @Initialise
    public void init(){
        f = new  com.fluxtion.extension.declarative.funclib.api.filter.BinaryPredicates.GreaterThan();
    }

    @OnEvent
    public boolean onEvent(){
        return f.isGreaterThan((double)((com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder)source_PurchaseOrderHandler_0.event()).getAmount(), (double)1000000.0);
    }

    @Override
    public PurchaseOrder event() {
        return filterSubject.event();
    }

    @Override
    public Class<PurchaseOrder> eventClass() {
        return PurchaseOrder.class;
    }

}

