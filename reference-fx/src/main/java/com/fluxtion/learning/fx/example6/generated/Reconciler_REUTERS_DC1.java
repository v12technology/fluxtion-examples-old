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

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import java.util.ArrayDeque;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;

/**
 * Fluxtion generated TradeReconciler id:REUTERS_DC1
 * Acknowledgements must be received from all monitored venues for a 
 * trade to have RECONCILED status.
 *
 * Acknowledging venues: "dcln_1_reuters", "MiddleOffice_reuters_dc1"
 *
 * @author greg higgins (greg.higgins@v12technology.com)
 */
public class  Reconciler_REUTERS_DC1 extends TradeReconciler{

    private Int2ObjectOpenHashMap<ReconcileRecord> id2Reconcile;
    private ArrayDeque<ReconcileRecord> freeList;

    @OnParentUpdate
    public void expireTimedOutReconciles(TimedNotifier TimedNotifier) {
        //reomve reconcilerecords if acks are too late
    }

    @EventHandler(filterString = "dcln_1_reuters")
    public void tradeAckFrom_dcln_1_reuters (TradeAcknowledgement acknowledgement){
        ReconcileRecord record = getRecord(acknowledgement);
        record.received_dcln_1_reuters = true;
        if (record.matched()) {
            matchedRecord(record);
        }
    }

    @EventHandler(filterString = "MiddleOffice_reuters_dc1")
    public void tradeAckFrom_MiddleOffice_reuters_dc1 (TradeAcknowledgement acknowledgement){
        ReconcileRecord record = getRecord(acknowledgement);
        record.received_MiddleOffice_reuters_dc1 = true;
        if (record.matched()) {
            matchedRecord(record);
        }
    }

    private void matchedRecord(ReconcileRecord record) {
        record.reset();
        id2Reconcile.remove(record.tradeId);
        freeList.addLast(record);
        //TODO notify matched listener
    }

    private ReconcileRecord getRecord(TradeAcknowledgement acknowledgement) {
        ReconcileRecord record = id2Reconcile.get(acknowledgement.tradeId);
        if (record == null) {
            record = freeList.pollLast();
            if (record == null) {
                record = new ReconcileRecord();
            }
            record.firstReceivedTime = acknowledgement.time;
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

    public static class ReconcileRecord implements ReconcileStatus<Integer>{

        private static final String[] VENUES = new String[]{"dcln_1_reuters", "MiddleOffice_reuters_dc1"};
        int tradeId;
        long firstReceivedTime;
        boolean received_dcln_1_reuters;
        boolean received_MiddleOffice_reuters_dc1;
        long time_dcln_1_reuters;
        long time_MiddleOffice_reuters_dc1;

        @Override
        public boolean matched(){
            return received_dcln_1_reuters & received_MiddleOffice_reuters_dc1;
        }

        @Override
        public Integer id() {
            return tradeId;
        }

        public String[] venues(){
            return VENUES;
        }

        void reset(){
            received_dcln_1_reuters = false;
            received_MiddleOffice_reuters_dc1 = false;
            time_dcln_1_reuters = 0;
            time_MiddleOffice_reuters_dc1 = 0;
        }

        @Override
        public Status status(){
            //TODO add implementation
            return null;
        }
    }
}
