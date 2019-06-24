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
package com.fluxtion.fx.reconciler.casestudy1;

import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.event.TimingPulseEvent;
import com.fluxtion.fx.reconciler.casestudy1.generated.ReconcilerCaseStudy1;
import com.fluxtion.fx.reconciler.events.TradeAcknowledgement;
import com.fluxtion.fx.reconciler.extensions.ReconcileReportPublisher;
import com.fluxtion.fx.reconciler.helpers.SynchronousJsonReportPublisher;
import com.fluxtion.fx.reconciler.webapp.SparkInitialiser;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class Main {

    public static void main(String[] args) {
        SparkInitialiser sparkInitialiser = new SparkInitialiser( RECONCILER_CASE_STUDY1);
        generateTestReconciles();
        sparkInitialiser.init();
    }

    private static final ReconcilerCaseStudy1 RECONCILER_CASE_STUDY1 = new ReconcilerCaseStudy1();
    private static final TimingPulseEvent TIMING_PULSE_EVENT = new TimingPulseEvent(1);

    private static int countId;

    private static void generateTestReconciles() {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            try {
                TIMING_PULSE_EVENT.currentTimeMillis = System.currentTimeMillis();
                if (countId < 1) {
                    RECONCILER_CASE_STUDY1.onEvent(new TradeAcknowledgement("MiddleOffice_NY3_FXALL", countId, TIMING_PULSE_EVENT.currentTimeMillis));
                }
                RECONCILER_CASE_STUDY1.onEvent(TIMING_PULSE_EVENT);
                RECONCILER_CASE_STUDY1.onEvent(new TradeAcknowledgement("NY_3_FXALL", countId, TIMING_PULSE_EVENT.currentTimeMillis));
                RECONCILER_CASE_STUDY1.onEvent(new TradeAcknowledgement("MiddleOffice_NY3_FXALL", ++countId, TIMING_PULSE_EVENT.currentTimeMillis));
            } catch (Exception e) {
                System.err.println("error:" + e.getMessage());
            }
        }, 2, 2, TimeUnit.SECONDS);
        //

    }

}
