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

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.event.ControlSignal;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.events.ControlSignals;
import static com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileReportPublisher.RESULT_PUBLISHER;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileReportPublisher;

/**
 * Publishes reports of the current reconcile status by delegating to a
 * registered ReconcileReportPublisher. Reports maybe in any format, dependent
 * upon the implementation of the registered ReconcileReportPublisher.
 *
 * The registered ReconcileReportPublisher is invoked with an instance of
 * ReconcileCache, which gives access to ReconcileStatus records, regardless of
 * the reconcile status of the record. The number of ReconcileStatus records in
 * the cache is dependent upon the cache implementation.
 *
 * Generating a report maybe a lengthy process and the ReconcileReportPublisher
 * may carry out its work asynchronously depending upon the implementation
 * registered.
 *
 * The ReportGenerator is triggered by either:
 * <ul>
 * <li>A timed alarm signal</li>
 * <li>A control signal event</li>
 * </ul>
 *
 *
 * A ReconcileReportPublisher can be registered by creating a
 * ListenerRegisration event and pushing the event to the generated SEP.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReportGenerator {

    @NoEventReference
    public ReconcileCache reconcileStatusCache;
    public TimedNotifier alarm;
    public String id;
    private ReconcileReportPublisher publisher;
    private boolean publishReport;

    @OnEvent
    public void publishReport() {
        if (publisher != null & publishReport) {
            publisher.publishReport(reconcileStatusCache, id);
        }
    }

    @OnParentUpdate
    public void publishTimeout(TimedNotifier TimedNotifier) {
        publishReport = true;
    }

    @EventHandler(filterString = RESULT_PUBLISHER, propogate = false)
    public void registerPublisher(ListenerRegisration<ReconcileReportPublisher> registration) {
        this.publisher = registration.getListener();
    }

    @EventHandler(filterString = ControlSignals.PUBLISH_REPORT, propogate = false)
    public void publishResults(ControlSignal publishSignal) {
        if (publisher != null) {
            publisher.publishReport(reconcileStatusCache, id);
        }
    }

    @Initialise
    public void init() {
        publishReport = false;
    }

    @AfterEvent
    public void resetPublishFlag() {
        publishReport = false;
    }
}
