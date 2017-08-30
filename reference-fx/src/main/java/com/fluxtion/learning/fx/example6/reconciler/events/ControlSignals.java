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
package com.fluxtion.learning.fx.example6.reconciler.events;

//import com.fluxtion.fx.event.ControlSignal;

/**
 * A lookup for Filters and control signals that are consistently named.
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public interface ControlSignals {

    public static final String PUBLISH_REPORT = "com.fluxtion.fx.reconciler.publishResults";
    public static final String PUBLISH_SUMMARY = "com.fluxtion.fx.reconciler.publishSummary";
    public static final String CLEAR_RECONCILE_STATE = "com.fluxtion.fx.reconciler.clearReconcileState";

    public static final ControlSignal PUBLISH_REPORT_ACTION = new ControlSignal(PUBLISH_REPORT, true);
    public static final ControlSignal PUBLISH_SUMMARY_ACTION = new ControlSignal(PUBLISH_SUMMARY, true);
    public static final ControlSignal CLEAR_CACHE_ACTION = new ControlSignal(CLEAR_RECONCILE_STATE, true);
}
