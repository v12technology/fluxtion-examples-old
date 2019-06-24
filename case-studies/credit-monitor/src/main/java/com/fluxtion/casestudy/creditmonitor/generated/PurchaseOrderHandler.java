package com.fluxtion.casestudy.creditmonitor.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder;

/**
 * Generated EventHandler for PurchaseOrder
 * @author Greg Higgins
 */
public class PurchaseOrderHandler implements EventWrapper<PurchaseOrder>{

    private PurchaseOrder event;

    @EventHandler
    public boolean handlePurchaseOrder(PurchaseOrder event){
        this.event = event;
        return true;
    }

    @Override
    public PurchaseOrder event() {
        return event;
    }

    @Override
    public Class<PurchaseOrder> eventClass() {
        return PurchaseOrder.class;
    }

}
