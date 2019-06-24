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
package com.fluxtion.learning.fx.example6;

import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 * @param <T>
 */
public class TestReconcileCache<T extends Integer> implements ReconcileStatusCache{

    public Map<ReconcileKey, ReconcileStatus> key2Status = new HashMap<>();
    
    @Override
    public void reset() {
        key2Status.clear();
    }

    /**
     *
     * @param reconcilerId
     * @param reconcileStatus
     */
    @Override
    public void update(String reconcilerId, ReconcileStatus reconcileStatus) {
        key2Status.put(new ReconcileKey(reconcilerId, (int) reconcileStatus.id()), reconcileStatus);
    }
    
//    public  void stream(BiConsumer<? super ReconcileKey, ? super ReconcileStatus> consumer){
//    }

    @Override
    public String toString() {
        return "TestReconcileCache{" + "key2Status=" + key2Status + '}';
    }

    @Override
    public void stream(BiConsumer consumer) {
        key2Status.forEach( consumer);
    }
    
}
