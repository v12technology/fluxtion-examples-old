/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
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
package com.fluxtion.learning.fx.example6.reconciler.helpers;

import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/**
 * In memory volatile ReconcileStatusCache implemented with ConcurrentHashMap.
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 * @param <T>
 */
public class ConcurrentHashMapReconcileCache<T extends Integer> implements ReconcileStatusCache{

    public Map<ReconcileKey, ReconcileStatus> key2Status = new ConcurrentHashMap<>();
    
    @Override
    public void reset() {
        key2Status.clear();
    }

    @Override
    public void update(String reconcilerId, ReconcileStatus reconcileStatus) {
        key2Status.put(new ReconcileKey(reconcilerId, (int) reconcileStatus.id()), reconcileStatus);
    }
    
    @Override
    public String toString() {
        return "TestReconcileCache{" + "key2Status=" + key2Status + '}';
    }

    @Override
    public void stream(BiConsumer consumer) {
        key2Status.forEach( consumer);
    }
    
}
