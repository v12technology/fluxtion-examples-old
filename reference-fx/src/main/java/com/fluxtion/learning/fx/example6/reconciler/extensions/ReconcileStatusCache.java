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
package com.fluxtion.learning.fx.example6.reconciler.extensions;

import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * A ReconcileStatusCache holds a set of ReconcileStatus records, available for
 * reading. The amount of records held by the ReconcileStatusCache is dependent
 * upon the cache implementation.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 * @param <T>
 */
public interface ReconcileStatusCache<T> {

    public static final String RECONCILE_STATUS_CACHE = "com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache";

    /**
     * reset cache to initial state
     */
    void reset();

    /**
     * update or create a ReconcileStatus record in the cache.
     *
     * @param reconcilerId source reconciler identifier
     * @param reconcileStatus The record to update
     */
    public void update(String reconcilerId, ReconcileStatus<T> reconcileStatus);
    
    public  void stream(BiConsumer<? super ReconcileKey, ? super ReconcileStatus> consumer);

    public static class ReconcileKey {

        public ReconcileKey(String reconcileId, int tradeId) {
            this.reconcileId = reconcileId;
            this.tradeId = tradeId;
        }

        public ReconcileKey() {
        }

        public String reconcileId;
        public int tradeId;

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 43 * hash + Objects.hashCode(this.reconcileId);
            hash = 43 * hash + this.tradeId;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ReconcileKey other = (ReconcileKey) obj;
            if (this.tradeId != other.tradeId) {
                return false;
            }
            if (!Objects.equals(this.reconcileId, other.reconcileId)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "ReconcileKey{" + "reconcileId=" + reconcileId + ", tradeId=" + tradeId + '}';
        }

    }
}
