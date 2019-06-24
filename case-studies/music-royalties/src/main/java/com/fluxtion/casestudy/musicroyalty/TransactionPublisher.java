/*
 * Copyright (C) 2018 gregp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.casestudy.musicroyalty;

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.casestudy.musicroyalty.CreditFailReporter;
import com.fluxtion.casestudy.musicroyalty.UserContext;
import com.fluxtion.casestudy.musicroyalty.events.PurchaseOrder;
import com.fluxtion.casestudy.musicroyalty.events.RejectAll;
import com.fluxtion.runtime.plugin.nodes.EventLogNode;

/**
 *
 * @author gregp
 */
public class TransactionPublisher extends EventLogNode{
    private final CreditFailReporter failReporter;
    private final UserContext userContext;
    private boolean failed;
    private boolean rejecting;
    private PurchaseOrder purchaseOrder;

    public TransactionPublisher(CreditFailReporter failReporter, UserContext userContext) {
        this.failReporter = failReporter;
        this.userContext = userContext;
    }
    
    public TransactionPublisher(CreditFailReporter failReporter) {
        this(failReporter, null);
    }
    
    @OnParentUpdate
    public void failedCheck(CreditFailReporter failReporter){
        failed = true;
        userContext.currentPurchaseOrder = null;
    }
    
    @EventHandler
    public void purchaseOrder(PurchaseOrder po){
        this.purchaseOrder = purchaseOrder;
    }
    
    @EventHandler(propagate = false)
    public void rejectAll(RejectAll rejectAll){
        rejecting = rejectAll.rejecting;
    }
    
    @OnEvent
    public void publishTransaction(){
        if(failed){
            log.info("reject", "failedRule");
        }else if(rejecting){
            log.info("rejectingAll", "true");
        }else{
            log.info("ACCEPT_PURCHASE_ORDER", "true");
        }
        purchaseOrder = null;
        failed = false;
    }
    

}
