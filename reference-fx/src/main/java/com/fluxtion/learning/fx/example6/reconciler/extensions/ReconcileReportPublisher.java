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
package com.fluxtion.learning.fx.example6.reconciler.extensions;

import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileCache;


/**
 * Provides reporting functionality of the current state of reconciliation. A
 ReconcileReportPublisher is invoked with publishReport when a report is required to
 be published. 
 
 The implementation is free to choose:
 <ul>
 * <li>the format of the report</li>
 * <li>whether to honour the request to publish a report</li>
 * <li>synchronous or asynchronous generation</li>
 * </ul>
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public interface ReconcileReportPublisher {

    public static final String RESULT_PUBLISHER = "com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileReportPublisher";

    /**
     * A request to publish a report
     * 
     * @param reconcileResultcCche access to the current ReconcileRecord set
     * @param reconcilerId The reconcilerId to publish the report for
     */
    void publishReport( ReconcileCache reconcileResultcCche, String reconcilerId);
    
}
