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
 * An interface defining the current reconcile status for a Trade. A trade
 * requires multiple venues to acknowledge the trade before the reconcile status
 * is RECONCILED.
 *
 * The states a ReconcileStatus can hold are defined in the enum,
 * ReconcileStatus.Status as follows:
 *
 * RECONCILING, RECONCILED, EXPIRED_RECONCILE, RECONCILED_AFTER_EXPIRY;
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
     * One of the these venues must acknowledge the trade for the record to be RECONCILED
     * 
     * @return the one of reconciling venues
     */
    String[] oneOfVenues();
    /**
     * A boolean flag indicating whether all venues have acknowledged the trade.
     *
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

    /**
     * query method to determine whether this record has expired
     *
     * @param currentTime the time to measure the expiry against
     * @param expiryTimeout the length of time to wait before expiring the
     * reconcile record
     * @return
     */
    boolean expired(long currentTime, int expiryTimeout);

    /**
     * Appends a json formatted string to the StringBuilder for this record.
     *
     * @param builder
     */
    void appendAsJson(StringBuilder builder);

    /**
     * set the status of the reconcile record
     *
     * @param status
     */
    void setStatus(Status status);

    public enum Status {
        RECONCILING, RECONCILED, EXPIRED_RECONCILE, RECONCILED_AFTER_EXPIRY;
    }
}
