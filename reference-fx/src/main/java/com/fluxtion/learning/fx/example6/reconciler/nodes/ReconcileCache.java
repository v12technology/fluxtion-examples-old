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

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.event.ControlSignal;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.events.ControlSignals;
import static com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache.RECONCILE_STATUS_CACHE;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache;

/**
 * A ReconcileStatusCache holds a set of ReconcileStatus records ready for
 * inspection. The amount of records held by the ReconcileStatusCache will be
 * dependent upon the implementation of the cache registered. The cache is
 * updated when TradeReconciler indicates a change in status to a
 * ReconcileStatus record.
 *
 * Child nodes can query this class to access the current status of the
 * ReconcileRecords.
 *
 * A ReconcileStatusCache registers with the ReconcileCache using a
 * ListenerRegisration event and pushing the event to the generated SEP.
 * Currently only one registered ReconcileStatusCache is supported.
 *
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcileCache {

    public TradeReconciler[] reconcilers;
    private ReconcileStatusCache cache;

    @EventHandler(filterString = RECONCILE_STATUS_CACHE, propogate = false)
    public void registerReconcileCache(ListenerRegisration<ReconcileStatusCache> registration) {
        this.cache = registration.getListener();
    }

    @EventHandler(filterString = ControlSignals.CLEAR_RECONCILE_STATE)
    public void clearCache(ControlSignal publishSignal) {
        cache.reset();
    }

    @OnParentUpdate
    public void updateReconcileCache(TradeReconciler reconciler) {
        //TODO extract delta update from the TradeReconciler and pussh to cache
    }
    
    public void addReconciler(TradeReconciler reconcilier){
        if(reconcilers==null){
            reconcilers = new TradeReconciler[]{reconcilier};
        }else{
            TradeReconciler[] tmp = new TradeReconciler[reconcilers.length + 1];
            for (int i = 0; i < reconcilers.length; i++) {
                tmp[i] = reconcilers[i];
            }
            tmp[reconcilers.length] = reconcilier;
            reconcilers = tmp;
        }
    }
    
}
