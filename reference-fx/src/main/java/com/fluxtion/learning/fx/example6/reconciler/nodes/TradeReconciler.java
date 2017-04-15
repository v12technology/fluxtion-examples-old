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

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.node.biascheck.TimedNotifier;

/**
 *
 * Work in progress, this is the interface the generated TradeReconciler will
 * conform to.
 *
 * Listens to TradeAcknowledgements and audits all incoming messages, if
 * required.
 *
 *
 *
 * TA is converted to a bespoke ReconcileRecord for the venue ReconcileRecords
 * are stored in a map for processing The map can be queried to generate a JSON
 * report of all trades processed today.
 *
 * Call back listener for ReconcileUpdate, for publishing summary statistics
 *
 * The JSON reports are generated at regular intervals for download
 *
 *
 *
 *
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class TradeReconciler {

    public TimedNotifier alarmReapExpired;
    public String id;
    public TradeAcknowledgementAuditor auditor;
    public int reconcileTimeout;


}
