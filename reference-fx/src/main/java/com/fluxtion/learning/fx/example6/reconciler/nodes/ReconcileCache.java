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
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.event.TimingPulseEvent;
import com.fluxtion.learning.fx.example6.reconciler.events.ControlSignal;
import com.fluxtion.learning.fx.example6.reconciler.events.ControlSignals;
import static com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache.RECONCILE_STATUS_CACHE;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileCacheQuery;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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
public class ReconcileCache implements ReconcileCacheQuery{

    public TradeReconciler[] reconcilers;
    private ReconcileStatusCache cache;
    
    @Override
    public void stream(BiConsumer<? super ReconcileStatusCache.ReconcileKey, ? super ReconcileStatus>  consumer){
        cache.stream(consumer);
    }
    
    @Override
    public void stream(Consumer<? super ReconcileStatus> consumer, String reconcilerId){
        stream((ReconcileStatusCache.ReconcileKey t, ReconcileStatus u) -> {
            if (t.reconcileId.equals(reconcilerId)) {
                consumer.accept(u);
            }
        });        
    }
    
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
        if(cache!=null && reconciler.currentRecord!=null){
            ReconcileStatus rec = reconciler.currentRecord;
            cache.update(reconciler.id, rec);
        }
    }
    
    @EventHandler(filterId = 1)
    public void cacheExpiryUpdates(TimingPulseEvent pulse) {
        for (int i = 0; i < reconcilers.length; i++) {
            TradeReconciler reconciler = reconcilers[i];
            ArrayList<ReconcileStatus> expiredList = reconciler.expiredList;
            for (int j = 0; j < expiredList.size(); j++) {
                ReconcileStatus recStatus = expiredList.get(j);
                cache.update(reconciler.id, recStatus);
            }
        }
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
