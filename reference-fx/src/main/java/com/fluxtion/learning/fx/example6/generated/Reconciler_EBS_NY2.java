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
package com.fluxtion.learning.fx.example6.generated;

import java.util.ArrayDeque;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import java.util.ArrayList;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;

/**
 * Fluxtion generated TradeReconciler id:EBS_NY2
 * Acknowledgements must be received from all monitored venues for a 
 * trade to have RECONCILED status.
 *
 * Acknowledging venues: "NY_2", "MiddleOffice_NY2"
 *
 * @author greg higgins (greg.higgins@v12technology.com)
 */
public class  Reconciler_EBS_NY2 extends TradeReconciler<Reconciler_EBS_NY2.ReconcileRecord>{

    @OnParentUpdate
    public void expireTimedOutReconciles(TimedNotifier TimedNotifier) {
        //reomve reconcilerecords if acks are too late
    }

    @EventHandler(filterString = "NY_2")
    public void tradeAckFrom_NY_2 (TradeAcknowledgement acknowledgement){
        currentRecord = getRecord(acknowledgement);
        currentRecord.received_NY_2 = true;
        if (currentRecord.matched()) {
            id2Reconcile.remove(currentRecord.id());
            freeList.addLast(currentRecord);  
        }
    }

    @EventHandler(filterString = "MiddleOffice_NY2")
    public void tradeAckFrom_MiddleOffice_NY2 (TradeAcknowledgement acknowledgement){
        currentRecord = getRecord(acknowledgement);
        currentRecord.received_MiddleOffice_NY2 = true;
        if (currentRecord.matched()) {
            id2Reconcile.remove(currentRecord.id());
            freeList.addLast(currentRecord);  
        }
    }


    private ReconcileRecord getRecord(TradeAcknowledgement acknowledgement) {
        ReconcileRecord record = id2Reconcile.get(acknowledgement.tradeId);
        if (record == null) {
            record = freeList.pollLast();
            if (record == null) {
                record = new ReconcileRecord();
            }
            record.firstReceivedTime = acknowledgement.time;
            record.tradeId = acknowledgement.tradeId;
            id2Reconcile.put(acknowledgement.tradeId, record);
        }
        return record;
    }

    @Initialise
    public void init(){
        id2Reconcile = new Int2ObjectOpenHashMap<>();
        freeList = new ArrayDeque<>();
        for (int i = 0; i < 50; i++) {
            freeList.add(new ReconcileRecord());
        }
    }

    @AfterEvent
    public void removeMatched(){
        if (currentRecord != null) {
            currentRecord.reset();
            currentRecord = null;
        } 
    }

    public static class ReconcileRecord implements ReconcileStatus<Integer>{

        private static final String[] VENUES = new String[]{"NY_2", "MiddleOffice_NY2"};
        int tradeId;
        long firstReceivedTime;
        boolean received_NY_2;
        boolean received_MiddleOffice_NY2;
        long time_NY_2;
        long time_MiddleOffice_NY2;

        @Override
        public boolean matched(){
            return received_NY_2 & received_MiddleOffice_NY2;
        }

        @Override
        public Integer id() {
            return tradeId;
        }

        public String[] venues(){
            return VENUES;
        }

        void reset(){
            received_NY_2 = false;
            received_MiddleOffice_NY2 = false;
            time_NY_2 = 0;
            time_MiddleOffice_NY2 = 0;
        }

        @Override
        public Status status(){
            //TODO add implementation
            return null;
        }
    }
}
