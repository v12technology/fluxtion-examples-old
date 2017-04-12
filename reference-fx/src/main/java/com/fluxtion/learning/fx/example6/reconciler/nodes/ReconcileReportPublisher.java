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

import com.fluxtion.learning.fx.example6.reconciler.extensions.ReportPublisher;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.event.ControlSignal;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.events.ControlSignals;
import static com.fluxtion.learning.fx.example6.reconciler.extensions.ReportPublisher.RESULT_PUBLISHER;

/**
 * Publishes reports of the current reconcile status by delegating to a
 * registered ReportPublisher. Reports maybe in any format this dependent upon
 * the implementation of the registered ReportPublisher.
 *
 * The registered ReportPublisher is invoked with an instance of ResultsCache,
 * which gives access to ReconcileStatus records, regardless of the reconcile
 * status of the record. The number of ReconcileStatus records in the cache is
 * dependent upon the cache implementation.
 *
 * Generating a report maybe a lengthy process and the ReportPublisher may carry
 * out its work asynchronously depending upon the implementation registered.
 *
 * The ReconcileReportPublisher is triggered by either:
 * <ul>
 * <li>A timed alarm signal</li>
 * <li>A control signal event</li>
 * </ul>
 *
 * The generation signals maybe ignored by the ReportPublisher, dependent upon
 * the current state of the system, for example the disk maybe full, or the.
 *
 * A ReportPublisher can be registered by creating a ListenerRegisration event
 * and pushing the event to the generated SEP.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcileReportPublisher {

    public ResultsCache reconcileResultcCche;
    private ReportPublisher publisher;
    public TimedNotifier alarm;

    private void publishReport() {
        if (publisher != null) {
            publisher.publishReport(reconcileResultcCche);
        }
    }

    @OnParentUpdate
    public void publishReconcileReport(TimedNotifier TimedNotifier) {
        publishReport();
    }

    @EventHandler(filterString = RESULT_PUBLISHER, propogate = false)
    public void registerPublisher(ListenerRegisration<ReportPublisher> registration) {
        this.publisher = registration.getListener();
    }

    @EventHandler(filterString = ControlSignals.PUBLISH_RESULT, propogate = false)
    public void publisResults(ControlSignal publishSignal) {
        publishReport();
    }
}
