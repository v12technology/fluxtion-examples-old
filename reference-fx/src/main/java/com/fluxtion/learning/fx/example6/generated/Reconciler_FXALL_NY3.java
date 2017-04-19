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

import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import com.fluxtion.api.annotations.AfterEvent;
import java.util.ArrayDeque;
import static com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus.Status.*;

/**
 * Fluxtion generated TradeReconciler id:FXALL_NY3
 * Acknowledgements must be received from all monitored venues for a 
 * trade to have RECONCILED status.
 *
 * Acknowledging venues: "NY_3_FXALL", "MiddleOffice_NY3_FXALL"
 *
 * @author greg higgins (greg.higgins@v12technology.com)
 */
public class  Reconciler_FXALL_NY3 extends TradeReconciler<Reconciler_FXALL_NY3.ReconcileRecord>{

    @EventHandler(filterString = "NY_3_FXALL")
    public void tradeAckFrom_NY_3_FXALL (TradeAcknowledgement acknowledgement){
        currentRecord = getRecord(acknowledgement);
        currentRecord.time_NY_3_FXALL = acknowledgement.time;
        if (currentRecord.matched()) {
            id2Reconcile.remove(currentRecord.id());
            currentRecord.status = RECONCILED;
            reconciled++;
            reconciling--;
        }
    }

    @EventHandler(filterString = "MiddleOffice_NY3_FXALL")
    public void tradeAckFrom_MiddleOffice_NY3_FXALL (TradeAcknowledgement acknowledgement){
        currentRecord = getRecord(acknowledgement);
        currentRecord.time_MiddleOffice_NY3_FXALL = acknowledgement.time;
        if (currentRecord.matched()) {
            id2Reconcile.remove(currentRecord.id());
            currentRecord.status = RECONCILED;
            reconciled++;
            reconciling--;
        }
    }


    private ReconcileRecord getRecord(TradeAcknowledgement acknowledgement) {
        ReconcileRecord record = id2Reconcile.get(acknowledgement.tradeId);
        if (record == null) {
            record = new ReconcileRecord();
            record.firstReceivedTime = acknowledgement.time;
            record.tradeId = acknowledgement.tradeId;
            id2Reconcile.put(acknowledgement.tradeId, record);
            reconciling++;
        }
        return record;
    }

    public static class ReconcileRecord implements ReconcileStatus<Integer>{

        private static final String[] VENUES = new String[]{"NY_3_FXALL", "MiddleOffice_NY3_FXALL"};
        private static final String[] VENUES_ONE_OF = new String[0];
        Status status = RECONCILING;;
        int tradeId;
        long firstReceivedTime = -1;
        long time_NY_3_FXALL = -1;
        long time_MiddleOffice_NY3_FXALL = -1;

        @Override
        public boolean matched(){
            return time_NY_3_FXALL > 0 & time_MiddleOffice_NY3_FXALL > 0;
        }

        @Override
        public boolean expired(long currentTime, int expiryTimeout){
            return !matched()  & ((currentTime - firstReceivedTime) > expiryTimeout);
        }

        @Override
        public void setStatus(Status status){
            this.status = status;
        }

        @Override
        public Integer id() {
            return tradeId;
        }

        @Override
        public String[] venues(){
            return VENUES;
        }

        @Override
        public String[] oneOfVenues(){
            return VENUES_ONE_OF;
        }

        void reset(){
            status = RECONCILING;
            time_NY_3_FXALL = -1;
            time_MiddleOffice_NY3_FXALL = -1;
        }

        @Override
        public Status status() {
            return status;
        }

        public void appendAsJson(StringBuilder builder){
            builder.append('{')
                    .append("tradeId: ").append(tradeId)
                    .append(", status: ").append(status.name())
                    .append(", acks: [")
                    .append("{")
                    .append("venue: \"NY_3_FXALL\"")
                    .append(", ackTime: ").append(time_NY_3_FXALL)
                    .append("}, ")
                    .append("{")
                    .append("venue: \"MiddleOffice_NY3_FXALL\"")
                    .append(", ackTime: ").append(time_MiddleOffice_NY3_FXALL)
                    .append("}")
                    .append("]}");
        }

        @Override
        public String toString() {
            return "ReconcileRecord{" 
                    + "tradeId=" + tradeId 
                    + ", firstReceivedTime=" + firstReceivedTime 
                    + ", status=" + status 
                    + '}';
        }
    }
}
