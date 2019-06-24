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
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.events.ControlSignal;
import com.fluxtion.learning.fx.example6.reconciler.events.ControlSignals;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import static com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus.Status.EXPIRED_RECONCILE;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 
 * Base class for reconciling TradeAcknowledgements  from a a set of monitored venues. 
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 * @param <T>
 */
public abstract class TradeReconciler<T extends ReconcileStatus<Integer>> {

    public TimedNotifier alarmReapExpired;
    public String id;
    public TradeAcknowledgementAuditor auditor;
    public int reconcileTimeout;

    protected Int2ObjectOpenHashMap<T> id2Reconcile;
    public T currentRecord;
    protected ArrayList<T> expiredList;
    protected ArrayDeque<T> freeList;

    protected int reconciled;
    protected int reconciling;
    protected int reconcile_expired;

    protected void matchedRecord(T record) {
        currentRecord = record;
        id2Reconcile.remove(record.id());
    }

    public int getReconciled() {
        return reconciled;
    }

    public int getReconciling() {
        return reconciling;
    }

    public int getReconcile_expired() {
        return reconcile_expired;
    }
    
    @OnParentUpdate
    public void expireTimedOutReconciles(TimedNotifier timedNotifier) {
        long timeInSeconds = timedNotifier.timeInSeconds();
        Int2ObjectMap.FastEntrySet<T> int2ObjectEntrySet = id2Reconcile.int2ObjectEntrySet();
        ObjectIterator<Int2ObjectMap.Entry<T>> fastIterator = int2ObjectEntrySet.fastIterator();
        while(fastIterator.hasNext()){
            Int2ObjectMap.Entry<T> next = fastIterator.next();
            T record = next.getValue();
            if(record.expired(timeInSeconds*1000, reconcileTimeout*1000)){
                record.setStatus(EXPIRED_RECONCILE);
                fastIterator.remove();
                expiredList.add(record);
                reconcile_expired++;
                reconciling--;
            }
        }
    }

    @EventHandler(filterString = ControlSignals.CLEAR_RECONCILE_STATE, propogate = false)
    public void clearReconcileState(ControlSignal publishSignal) {
        init();
    }

    @Initialise
    public void init() {
        id2Reconcile = new Int2ObjectOpenHashMap<>();
        expiredList = new ArrayList<>();
        reconciled = 0;
        reconciling = 0;
        reconcile_expired = 0;
    }
    
    @AfterEvent
    public void resetAfterUpdate(){
        currentRecord = null;
        expiredList.clear();
    }
    
}
