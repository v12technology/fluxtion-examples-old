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
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Provides query read access into the ReconcileCache.
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public interface ReconcileCacheQuery {

    /**
     * Streams all the data in the cache to a client
     * 
     * @param consumer consumer of reconcile records
     */
    void stream(BiConsumer<? super ReconcileStatusCache.ReconcileKey, ? super ReconcileStatus> consumer);

    /**
     * Only streams reconcile records that match the reconciler Id provided.
     * 
     * @param consumer consumer of reconcile records
     * @param reconcilerId the reconciler id filter to apply
     */
    void stream(Consumer<? super ReconcileStatus> consumer, String reconcilerId);

}
