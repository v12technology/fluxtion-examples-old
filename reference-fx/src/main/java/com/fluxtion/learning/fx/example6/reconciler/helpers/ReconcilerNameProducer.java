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
package com.fluxtion.learning.fx.example6.reconciler.helpers;

import com.fluxtion.api.generation.NodeNameProducer;
import com.fluxtion.fx.eventhandler.TimeHandlerSeconds;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReportGenerator;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileCache;
import com.fluxtion.learning.fx.example6.reconciler.nodes.SummaryPublisher;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcilerNameProducer implements NodeNameProducer {

    static int count;
    
    @Override
    public String mappedNodeName(Object nodeToMap) {
        String name = null;
        if (nodeToMap instanceof TimedNotifier) {
            TimedNotifier handler = (TimedNotifier) nodeToMap;
            name = "alarm_" + handler.periodInSeconds + "s";
        }
        if (nodeToMap instanceof ReportGenerator) {
            ReportGenerator cache = (ReportGenerator)nodeToMap;
            name = "reportGenerator_" + cache.id;
        }
        if (nodeToMap instanceof ReconcileCache) {
            name = "reconcileCache_Global";
        }
        if (nodeToMap instanceof SummaryPublisher) {
            SummaryPublisher pub = (SummaryPublisher)nodeToMap;
            name = "summaryPublisher_" + pub.reconciler.id;
        }
        if (nodeToMap instanceof TradeAcknowledgementAuditor) {
            name = "auditor";
        }
        if (nodeToMap instanceof TimeHandlerSeconds) {
            name = "timeHandler";
        }
        if (nodeToMap instanceof TradeReconciler) {
            name = "reconciler_" + ((TradeReconciler)nodeToMap).id;
        }
        return name;
    }
}
