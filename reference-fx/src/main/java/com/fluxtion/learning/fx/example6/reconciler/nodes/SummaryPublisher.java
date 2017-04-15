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
package com.fluxtion.learning.fx.example6.reconciler.nodes;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import static com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileSummaryListener.RECONCILE_LISTENER;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileSummaryListener;

/**
 * A SummaryPublisher publishes the change in state of the current reconcile
 * status for a set of ReconcileStatus records in the TradeReconciler. Only the
 * changed ReconcileStatus records due to processing of new TradeAcknowledgement
 * events are published to the ReconcileSummaryListener.
 *
 * A ReconcileSummaryListener registers with the SummaryPublisher using a
 * ListenerRegisration event and pushing the event to the generated SEP.
 * Currently only one registered ReconcileSummaryListener is supported.
 *
 * The responsibility for reporting on the reconcile status of all
 * ReconcileStaus records lies with the ReconcileReportPublisher.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class SummaryPublisher {

    @NoEventReference
    public TradeReconciler reconciler;
    public TimedNotifier alarm;
    private ReconcileSummaryListener reconcilerListener;

    @EventHandler(filterString = RECONCILE_LISTENER, propogate = false)
    public void registerReconcileListerner(ListenerRegisration<ReconcileSummaryListener> registration) {
        reconcilerListener = registration.getListener();
    }

    @OnParentUpdate
    public void publishReconcileDelta(TimedNotifier TimedNotifier) {
    }
    
    @OnEvent
    public void pushNotifications(){
        if (reconcilerListener != null) {
            //pushUpdates
        }        
    }

}
