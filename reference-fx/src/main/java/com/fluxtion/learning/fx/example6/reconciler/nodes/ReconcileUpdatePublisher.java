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
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcilerListener;
import static com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcilerListener.RECONCILE_LISTENER;

/**
 * A ReconcileUpdatePublisher publishes the change in state of the current
 * reconcile status for a set of ReconcileStatus records in the TradeReconciler.
 * Only the changed ReconcileStatus records due to processing of new
 * TradeAcknowledgement events are published to the ReconcilerListener.
 *
 * A ReconcilerListener registers with the ReconcileUpdatePublisher using a
 * ListenerRegisration event and pushing the event to the generated SEP.
 * Currently only one registered ReconcilerListener is supported.
 *
 * The responsibility for reporting on the reconcile status of all
 * ReconcileStaus records lies with the ReconcileReportPublisher.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcileUpdatePublisher {

    public TradeReconciler reconiler;
    private ReconcilerListener reconcilerListener;

    @EventHandler(filterString = RECONCILE_LISTENER, propogate = false)
    public void registerReconcileListerner(ListenerRegisration<ReconcilerListener> registration) {
        reconcilerListener = registration.getListener();
    }

    @OnEvent
    public void publishReconcileUpdates() {
        if (reconcilerListener != null) {
            //pushUpdates
        }
    }
}
