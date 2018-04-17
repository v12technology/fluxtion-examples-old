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
package com.fluxtion.casestudy.creditmonitor;

import com.fluxtion.casestudy.creditmonitor.events.UserConfig;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder;
import com.fluxtion.runtime.plugin.events.ConfigurationEvent;
import com.fluxtion.runtime.plugin.nodes.EventLogNode;

/**
 *
 * @author gregp
 */
public class UserContext extends EventLogNode {

    PurchaseOrder currentPurchaseOrder;
    PurchaseOrder previousPurchaseOrder;
    
    @EventHandler(propagate = false)
    public void configUpdate(ConfigurationEvent<UserConfig> configUpdate) {
        log.info("updateCfg", configUpdate.value.toString());
    }
    
    @EventHandler
    public void purchseOrder(PurchaseOrder purchaseOrder){
        log.info("purchaseOrder", purchaseOrder.toString());
        currentPurchaseOrder = purchaseOrder;
    }
    
    @OnEventComplete
    public void afterEvent(){
        if(currentPurchaseOrder!=null){
            log.info("afterEvent", "updatePurcahseOrder");
            previousPurchaseOrder = currentPurchaseOrder;
        }
        currentPurchaseOrder = null;
    }
}
