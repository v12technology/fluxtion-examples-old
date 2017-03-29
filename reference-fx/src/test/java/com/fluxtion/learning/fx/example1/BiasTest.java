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
package com.fluxtion.learning.fx.example1;

import com.fluxtion.fx.event.FxOrder;
import com.fluxtion.fx.event.FxPrice;
import com.fluxtion.fx.node.biascheck.OrderBiasResult;
import com.fluxtion.fx.util.CcyPair;
import com.fluxtion.learning.fx.utils.ConsoleAuditor;
import com.fluxtion.learning.fx.utils.PriceOrderHelper;
import java.util.concurrent.atomic.LongAdder;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class BiasTest {

    private static volatile boolean printToConcole = true;

    @Test
    public void AuditTest() {
        System.out.println("AUDIT TEST");
        G10Monitor monitor = new G10Monitor();
        final ConsoleAuditor auditor = new ConsoleAuditor();
        auditor.printToConsole = printToConcole;
        monitor.registerEventAuditor(auditor);
        PriceOrderHelper helper = new PriceOrderHelper(monitor);
        //send time
        helper.setWallClock(750);
        //check prices
        helper.sendRandomPrice(CcyPair.EURUSD);
        Assert.assertEquals(1, auditor.priceCount);
        FxPrice price = helper.sendRandomPrice(CcyPair.GBPUSD);
        assertEquals(2, auditor.priceCount);
        //place and accept
        FxOrder order = helper.sendOrder(price, true, 10);
        helper.acceptOrder(order);
        assertEquals(1, auditor.orderCount);
        assertEquals(1, auditor.acceptCount);
        //place order and reject
        order = helper.sendOrder(price, true, 10);
        helper.rejectOrder(order);
        assertEquals(2, auditor.orderCount);
        assertEquals(1, auditor.acceptCount);
        assertEquals(1, auditor.rejectCount);
        //tick
        helper.setWallClock(1050);
        assertEquals(2, auditor.timePulseCount);
    }

    @Test
    public void breachTest() {
        System.out.println("BREACH NOTIFICATION TEST");
        G10Monitor monitor = new G10Monitor();
        final LongAdder count = new LongAdder();
        monitor.registerBreachNotificationHandler((breachNotification) -> {
            if (printToConcole) {
                System.out.println("breach notification:" + breachNotification.toString());
            }
            count.increment();
        });
        PriceOrderHelper helper = new PriceOrderHelper(monitor);
        //send orders - within bias limit for 1 minute bucket, 
        //but breaches for 10 minute bucket
        helper.setWallClock(1 * 1000);
        helper.rejectOrderWithBias(CcyPair.EURUSD, 0.0012, true);
        helper.setWallClock(50 * 1000);
        helper.rejectOrderWithBias(CcyPair.EURUSD, 0.0014, true);
        //should be no breaches below 0.0015 for 1 minute
        helper.setWallClock(70 * 1000);
        assertEquals(0, count.intValue());
        //tick to 10 minutes + and should see a breach
        helper.setWallClock(100 + 10 * 60 * 1000);
        assertEquals(1, count.intValue());

        //fire out of limit for non-monitored ccys - no effect
        helper.rejectOrderWithBias(CcyPair.GBPCAD, 0.14, true);
        helper.rejectOrderWithBias(CcyPair.GBPCAD, 0.34, true);
        helper.setWallClock(100 + 11 * 60 * 1000);
        assertEquals(1, count.intValue());
        helper.setWallClock(100 + 21 * 60 * 1000);

        //lets test 1 moinute breach but no 10 minute notifications
        helper.rejectOrderWithBias(CcyPair.EURUSD, 0.0032, true);
        helper.setWallClock(100 + 22 * 60 * 1000);
        assertEquals(2, count.intValue());
    }

    @Test
    public void testSummaryResults() {
        System.out.println("SUMMARY RESULT PUBLISH TEST");
        G10Monitor monitor = new G10Monitor();
        PriceOrderHelper helper = new PriceOrderHelper(monitor);
        final LongAdder count = new LongAdder();
        final LongAdder activeResultSize = new LongAdder();
        monitor.registerResultsReceiver((seconds, results) -> {
            String res = "current bias at:" + seconds + "seconds\n";
            activeResultSize.reset();
            for (OrderBiasResult result : results) {
                res += result.toString() + "\n";
                if (result.getRejectDealCount() > 0) {
                    activeResultSize.increment();
                }
            }
            if (printToConcole) {
                System.out.println(res);
            }
            count.increment();
        });
        //reults every second, but nothing if no orders
        assertEquals(0, count.intValue());
        assertEquals(0, activeResultSize.intValue());
        helper.setWallClock(1 * 1000 - 1);
        assertEquals(0, count.intValue());
        assertEquals(0, activeResultSize.intValue());
        helper.setWallClock(2 * 1000 - 1);
        assertEquals(1, count.intValue());
        helper.setWallClock(2 * 1000);
        assertEquals(2, count.intValue());
        helper.setWallClock(2 * 1000 + 1);
        assertEquals(2, count.intValue());
        assertEquals(0, activeResultSize.intValue());
        //place order
        helper.rejectOrderWithBias(CcyPair.EURUSD, 0.0012, true);
        helper.rejectOrderWithBias(CcyPair.EURUSD, 0.0014, true);
        helper.setWallClock(3000);
        assertEquals(2, activeResultSize.intValue());
        helper.setWallClock(3001);
        helper.setWallClock(4000);
        helper.setWallClock(4001);
        assertEquals(2, activeResultSize.intValue());
        helper.setWallClock(60000);
        //tick passed 1 minute - active count shoule decrement
        helper.setWallClock(62000);
        assertEquals(1, activeResultSize.intValue());
        //tick passed 10 minute - active count shoule decrement
        helper.setWallClock(10 * 60000);
        assertEquals(1, activeResultSize.intValue());
        helper.setWallClock(10 * 60000 + 1000);
        assertEquals(0, activeResultSize.intValue());
    }
}
