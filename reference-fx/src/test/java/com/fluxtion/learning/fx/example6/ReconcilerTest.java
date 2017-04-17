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
package com.fluxtion.learning.fx.example6;

import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.event.TimingPulseEvent;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileSummaryListener;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import static com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus.Status.EXPIRED_RECONCILE;
import static com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus.Status.RECONCILED;
import static com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus.Status.RECONCILING;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileCache;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import java.lang.reflect.Field;
import static java.util.Arrays.stream;
import java.util.Map;
import net.vidageek.mirror.dsl.Mirror;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Tests for
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcilerTest {

    private EventHandler reconciler;
    private ReconcileCache cacheManager;
    private TestReconcileCache cacheTarget;
    private Map<TestReconcileCache.ReconcileKey, ReconcileStatus> key2Status;

    @Before
    public void beforeTest() throws Exception {
        reconciler = (EventHandler & Lifecycle) Class.forName("com.fluxtion.learning.fx.example6.generated.ReconcilerExample6").newInstance();
        ((Lifecycle) reconciler).init();
        Field field = new Mirror().on(reconciler.getClass()).reflect().field("reconcileCache_Global");
        field.setAccessible(true);
        cacheManager = (ReconcileCache) field.get(reconciler);
        cacheTarget = new TestReconcileCache();
        reconciler.onEvent(new ListenerRegisration(cacheTarget, ReconcileStatusCache.class));
        key2Status = cacheTarget.key2Status;
    }

    @Test
    public void testReconcilerIds() {
        assertThat(stream(cacheManager.reconcilers).map(i -> i.id).toArray(),
                arrayContainingInAnyOrder("REUTERS_DC1", "EBS_LD4", "EBS_NY2", "FXALL_NY3"));
    }

    @Test
    public void testSimpleReconcile() {
        cacheSize(0);
        reconciler.onEvent(new TradeAcknowledgement("NY_2", 200, 2000));
        cacheSize(1);
        recordStatus(RECONCILING, "EBS_NY2", 200);
        reconciler.onEvent(new TradeAcknowledgement("MiddleOffice_NY2", 200, 3000));
        recordStatus(RECONCILED, "EBS_NY2", 200);
        cacheSize(1);
    }
    
    @Test
    public void testSummaryStatistics(){
        final TimingPulseEvent timingPulseEvent = new TimingPulseEvent(1);
        timingPulseEvent.setCurrentTimeMillis(1*1000);
        reconciler.onEvent(timingPulseEvent);
        //match a trade
        reconciler.onEvent(new TradeAcknowledgement("NY_2", 200, 2000));
        cacheSize(1);
        recordStatus(RECONCILING, "EBS_NY2", 200);
        reconciler.onEvent(new TradeAcknowledgement("MiddleOffice_NY2", 200, 3000));
        recordStatus(RECONCILED, "EBS_NY2", 200);
        //expire a trade
        timingPulseEvent.setCurrentTimeMillis(10*1000);
        reconciler.onEvent(timingPulseEvent);
        reconciler.onEvent(new TradeAcknowledgement("NY_2", 11,10*1000));
        timingPulseEvent.setCurrentTimeMillis(21*1000);
        reconciler.onEvent(timingPulseEvent);
        cacheSize(2);
        recordStatus(EXPIRED_RECONCILE, "EBS_NY2", 11);
        //test summary
        TradeReconciler reconciler_EBS_NY2 = getReconcilerById("EBS_NY2");
        assertThat(reconciler_EBS_NY2.getReconcile_expired(), is(1));
        assertThat(reconciler_EBS_NY2.getReconciled(), is(1));
        assertThat(reconciler_EBS_NY2.getReconciling(), is(0));
    }
    
    @Test
    public void testSImpleTimeout(){
        final TimingPulseEvent timingPulseEvent = new TimingPulseEvent(1);
        timingPulseEvent.setCurrentTimeMillis(1*1000);
        reconciler.onEvent(timingPulseEvent);
        timingPulseEvent.setCurrentTimeMillis(10*1000);
        reconciler.onEvent(timingPulseEvent);
        reconciler.onEvent(new TradeAcknowledgement("NY_2", 200,10*1000));
        timingPulseEvent.setCurrentTimeMillis(21*1000);
        reconciler.onEvent(timingPulseEvent);
        cacheSize(1);
        recordStatus(EXPIRED_RECONCILE, "EBS_NY2", 200);
    }
    
    @Test
    public void testSummaryListener(){
        SummaryListener summaryListener = new SummaryListener();
        reconciler.onEvent(new ListenerRegisration(summaryListener, ReconcileSummaryListener.class));
        final TimingPulseEvent timingPulseEvent = new TimingPulseEvent(1);
        timingPulseEvent.setCurrentTimeMillis(1*1000);
        reconciler.onEvent(timingPulseEvent);
        //match a trade
        reconciler.onEvent(new TradeAcknowledgement("NY_2", 200, 2000));
        timingPulseEvent.setCurrentTimeMillis(2*1000);
        reconciler.onEvent(new TradeAcknowledgement("MiddleOffice_NY2", 200, 3000));
        timingPulseEvent.setCurrentTimeMillis(3*1000);
        //expire a trade
        timingPulseEvent.setCurrentTimeMillis(10*1000);
        reconciler.onEvent(timingPulseEvent);
        reconciler.onEvent(new TradeAcknowledgement("NY_2", 11,10*1000));
        timingPulseEvent.setCurrentTimeMillis(21*1000);
        reconciler.onEvent(timingPulseEvent);
    }
    

    protected void cacheSize(int expectedSise) {
        assertThat(expectedSise, is(cacheTarget.key2Status.size()));
    }

    protected void recordStatus(ReconcileStatus.Status status, String reconcilerId, int tradeId) {
        ReconcileStatus recRecord = key2Status.get(new TestReconcileCache.ReconcileKey(reconcilerId, tradeId));
        assertNotNull(recRecord);
        assertThat(recRecord.status(), is(status));
    }
    
    protected TradeReconciler getReconcilerById(String id){
        TradeReconciler reconciler = null;
        for (TradeReconciler rec : cacheManager.reconcilers) {
            if(rec.id.equals(id)){
                reconciler = rec;
                break;
            }
        }
        return reconciler;
    }
}
