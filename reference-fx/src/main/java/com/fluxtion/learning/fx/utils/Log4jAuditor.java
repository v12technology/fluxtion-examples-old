/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
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
package com.fluxtion.learning.fx.utils;

import com.fluxtion.fx.EventAuditor;
import com.fluxtion.fx.event.CustomerOrder;
import com.fluxtion.fx.event.CustomerOrderAccept;
import com.fluxtion.fx.event.CustomerOrderReject;
import com.fluxtion.fx.event.FxOrder;
import com.fluxtion.fx.event.FxPrice;
import com.fluxtion.fx.event.TimingPulseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class Log4jAuditor implements EventAuditor {

    private static final Logger LOGGER = LogManager.getLogger("fluxtionfx.audit");
    
    public int priceCount;
    public int orderCount;
    public int acceptCount;
    public int rejectCount;
    public int timePulseCount;
    public volatile boolean printToConsole = true;

    @Override
    public void handleEvent(CustomerOrder customerOrder) {
        orderCount++;
        final FxOrder order = customerOrder.getOrder();
        LOGGER.info("customerOrder,{},{},{},{}", order.pair, order.orderId, order.customerBuys?"B":"S", order.dealPrice);
    }

    @Override
    public void handleEvent(CustomerOrderAccept orderAccept) {
        acceptCount++;
        LOGGER.info("orderAccept,{}", orderAccept.getOrderId());
    }

    @Override
    public void handleEvent(CustomerOrderReject orderReject) {
        rejectCount++;
        LOGGER.info("orderReject,{}", orderReject.getOrderId());
    }

    @Override
    public void handleEvent(FxPrice fxPrice) {
        priceCount++;
        LOGGER.info("price,{},{},{}", fxPrice.pair, fxPrice.bid, fxPrice.offer);
    }

    @Override
    public void handleEvent(TimingPulseEvent timingPulse) {
        timePulseCount++;
        LOGGER.info("time,{}", timingPulse.currentTimeMillis);
    }

    public void resetCounts() {
        priceCount = 0;
        orderCount = 0;
        acceptCount = 0;
        rejectCount = 0;
        timePulseCount = 0;
    }

    @Override
    public String toString() {
        return "ConsoleAuditor{" + "priceCount=" + priceCount + ", orderCount=" + orderCount + ", acceptCount=" + acceptCount + ", rejectCount=" + rejectCount + ", timePulseCount=" + timePulseCount + '}';
    }

}
