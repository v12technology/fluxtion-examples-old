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
package com.fluxtion.casestudy.creditmonitor.fluxtioncfg;

import com.fluxtion.casestudy.creditmonitor.CreditFailReporter;
import com.fluxtion.casestudy.creditmonitor.Rules.LocationRule;
import com.fluxtion.casestudy.creditmonitor.Rules.MaxOrderSizeRule;
import com.fluxtion.casestudy.creditmonitor.Rules.OrderRateRule;
import com.fluxtion.casestudy.creditmonitor.UserContext;
import com.fluxtion.casestudy.creditmonitor.TransactionPublisher;
import com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.builder.log.LogBuilder;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.*;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanFilter;
import com.fluxtion.runtime.plugin.sep.AuditedSep;

/**
 *
 * @author gregp
 */
public class CreditMonitorSepCfg extends AuditedSep {

    @Override
    public void buildConfig() {
        UserContext userCtx = addNode(new UserContext());
        LocationRule ruleLocation = addNode(new LocationRule(userCtx));
        MaxOrderSizeRule ruleMax = addNode(new MaxOrderSizeRule(userCtx));
        OrderRateRule ruleRate = addNode(new OrderRateRule(userCtx));
        CreditFailReporter failReporter = addNode(new CreditFailReporter(ruleLocation, ruleMax, ruleRate));
        TransactionPublisher transactionPublisher = addPublicNode(new TransactionPublisher(failReporter, userCtx), "txPublisher");
        
        //add a declarative rule
        Wrapper<PurchaseOrder> bigOrder = greaterThanFilter(PurchaseOrder.class, PurchaseOrder::getAmount, 1e6);
        Log("very big order: {} customer:{}", bigOrder, 
                PurchaseOrder::getAmount,
                PurchaseOrder::getCustomerId
        );
    }

}
