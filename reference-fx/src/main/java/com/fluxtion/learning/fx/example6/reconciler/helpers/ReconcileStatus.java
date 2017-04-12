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
package com.fluxtion.learning.fx.example6.reconciler.helpers;

/**
 * An interface defining the current reconcile status for a Trade. A trade may
 * require multiple venues to acknowledge it before the reconcile status is
 * RECONCILED.
 *
 * The states a ReconcileStatus can hold are defined in the enum,
 * ReconcileStatus.Status:
 *
 * RECONCILIG, RECONCILED, EXPIRED_RECONCILE, RECONCILED_AFTER_EXPIRY;
 *
 * @param <T> The key type for the TradeAcknoweledgement
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public interface ReconcileStatus<T> {

    /**
     * The venues that must acknowledge the trade for it to be RECONCILED
     *
     * @return reconciling venues
     */
    String[] venues();

    /**
     * A boolean flag indicating whether all venues have acknowledged the trade.
     * @return is reconciled
     */
    boolean matched();

    /**
     * The id of trade acknowledgement.
     * 
     * @return id of trade acknowledgement
     */
    T id();

    /**
     * current reconcile status as an enum.
     * 
     * @return reconcile status
     */
    Status status();

    public enum Status {
        RECONCILIG, RECONCILED, EXPIRED_RECONCILE, RECONCILED_AFTER_EXPIRY;
    }
}
