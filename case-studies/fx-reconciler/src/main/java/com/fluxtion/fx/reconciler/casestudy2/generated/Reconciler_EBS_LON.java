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
package com.fluxtion.fx.reconciler.casestudy2.generated;

import java.util.ArrayList;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.api.annotations.AfterEvent;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import com.fluxtion.fx.reconciler.nodes.TradeReconciler;
import com.fluxtion.fx.reconciler.events.TradeAcknowledgement;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.fx.reconciler.nodes.TradeAcknowledgementAuditor;
import java.util.ArrayDeque;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.fx.reconciler.helpers.ReconcileStatus;
import com.fluxtion.fx.eventhandler.TimedNotifier;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import static com.fluxtion.fx.reconciler.helpers.ReconcileStatus.Status.*;

/**
 * Fluxtion generated TradeReconciler id:EBS_LON
 * Acknowledgements must be received from all monitored venues for a 
 * trade to have RECONCILED status.
 *
 * Acknowledging venues: "ebs_lon", "MiddleOffice_ebs_lon", "traiana"
 *
 * @author greg higgins (greg.higgins@v12technology.com)
 */
public class  Reconciler_EBS_LON extends TradeReconciler<Reconciler_EBS_LON.ReconcileRecord>{

    private static final String[] ALL_VENUES = new String[]{ "ebs_lon", "MiddleOffice_ebs_lon", "traiana" };
    private static final String[] VENUES = new String[]{"ebs_lon", "MiddleOffice_ebs_lon", "traiana"};
    private static final String[] VENUES_ONE_OF = new String[0];

    @Override
    public String[] allVenues(){
        return ALL_VENUES;
    }

    @Override
    public String[] mandatoryVenues(){
        return VENUES;
    }

    @Override
    public String[] oneOfVenues(){
        return VENUES_ONE_OF;
    }

    @EventHandler(filterString = "ebs_lon")
    public void tradeAckFrom_ebs_lon (TradeAcknowledgement acknowledgement){
        currentRecord = getRecord(acknowledgement);
        currentRecord.time_ebs_lon = acknowledgement.time;
        if (currentRecord.matched()) {
            id2Reconcile.remove(currentRecord.id());
            currentRecord.status = RECONCILED;
            reconciled++;
            reconciling--;
        }
    }

    @EventHandler(filterString = "MiddleOffice_ebs_lon")
    public void tradeAckFrom_MiddleOffice_ebs_lon (TradeAcknowledgement acknowledgement){
        currentRecord = getRecord(acknowledgement);
        currentRecord.time_MiddleOffice_ebs_lon = acknowledgement.time;
        if (currentRecord.matched()) {
            id2Reconcile.remove(currentRecord.id());
            currentRecord.status = RECONCILED;
            reconciled++;
            reconciling--;
        }
    }

    @EventHandler(filterString = "traiana")
    public void tradeAckFrom_traiana (TradeAcknowledgement acknowledgement){
        currentRecord = getRecord(acknowledgement);
        currentRecord.time_traiana = acknowledgement.time;
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

        Status status = RECONCILING;;
        int tradeId;
        long firstReceivedTime = -1;
        long time_ebs_lon = -1;
        long time_MiddleOffice_ebs_lon = -1;
        long time_traiana = -1;

        @Override
        public boolean matched(){
            return time_ebs_lon > 0 & time_MiddleOffice_ebs_lon > 0 & time_traiana > 0;
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
            time_ebs_lon = -1;
            time_MiddleOffice_ebs_lon = -1;
            time_traiana = -1;
        }

        @Override
        public Status status() {
            return status;
        }

        public void appendAsJson(StringBuilder builder){
            builder.append('{')
                    .append("\"tradeId\": ").append(tradeId)
                    .append(", \"status\": \"").append(status.name()).append("\"")
                    .append(", \"acks\": [")
                    .append("{")
                    .append("\"venue\": \"ebs_lon\"")
                    .append(", \"ackTime\": ").append(time_ebs_lon)
                    .append("}, ")
                    .append("{")
                    .append("\"venue\": \"MiddleOffice_ebs_lon\"")
                    .append(", \"ackTime\": ").append(time_MiddleOffice_ebs_lon)
                    .append("}, ")
                    .append("{")
                    .append("\"venue\": \"traiana\"")
                    .append(", \"ackTime\": ").append(time_traiana)
                    .append("}")
                    .append("]}");
        }

        public void appendAsJsonArray(StringBuilder builder){
            builder.append('[')
                    .append(tradeId)
                    .append(",\"")
                    .append(status.name())
                    .append("\",")
                    .append(time_ebs_lon)
                    .append(", ")
                    .append(time_MiddleOffice_ebs_lon)
                    .append(", ")
                    .append(time_traiana)
                    .append("")
                    .append("]");
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
