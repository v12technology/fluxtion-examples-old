/* 
 * Copyright (C) 2017 V12 Technology Limited
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
package com.fluxtion.learning.fx.example5;

import com.fluxtion.fx.EventAuditor;
import com.fluxtion.fx.event.CustomerOrder;
import com.fluxtion.fx.event.CustomerOrderAccept;
import com.fluxtion.fx.event.CustomerOrderReject;
import com.fluxtion.fx.event.FxPrice;
import com.fluxtion.fx.event.TimingPulseEvent;
import java.io.File;

/**
 * Persists incoming messages to a BiasProcessor for later retrieval, possibly
 * used for a restart. Messages are saved to a chronicle queue, and can be 
 * replayed with .....
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ChronicleAuditor implements EventAuditor {

    public int priceCount;
    public int orderCount;
    public int acceptCount;
    public int rejectCount;
    public int timePulseCount;
    public volatile boolean printToConsole = false;
    private final File chronicleFile;
    
    public ChronicleAuditor(File chronicleFile){
        this.chronicleFile = chronicleFile;
    }

    @Override
    public void handleEvent(CustomerOrder customerOrder) {
        orderCount++;
        if (printToConsole) {
            System.out.println("AUDIT -> " + customerOrder);
        }
    }

    @Override
    public void handleEvent(CustomerOrderAccept orderAccept) {
        acceptCount++;
        if (printToConsole) {
            System.out.println("AUDIT -> " + orderAccept);
        }
    }

    @Override
    public void handleEvent(CustomerOrderReject orderReject) {
        rejectCount++;
        if (printToConsole) {
            System.out.println("AUDIT -> " + orderReject);
        }
    }

    @Override
    public void handleEvent(FxPrice fxPrice) {
        priceCount++;
        if (printToConsole) {
            System.out.println("AUDIT -> " + fxPrice.toString());
        }
    }

    @Override
    public void handleEvent(TimingPulseEvent timingPulse) {
        timePulseCount++;
        if (printToConsole) {
            System.out.println("AUDIT -> " + timingPulse);
        }
    }

    public int totalEventCount() {
        return priceCount + orderCount + acceptCount + rejectCount + timePulseCount;
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
        return "ChronicleAuditor{"
                + "priceCount=" + priceCount
                + ", orderCount=" + orderCount
                + ", acceptCount=" + acceptCount
                + ", rejectCount=" + rejectCount
                + ", timePulseCount=" + timePulseCount
                + ", totalCount=" + (priceCount + orderCount + acceptCount + rejectCount + timePulseCount)
                + '}';
    }
}
