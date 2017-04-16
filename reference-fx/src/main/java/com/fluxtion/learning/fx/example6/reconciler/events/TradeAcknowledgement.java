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

import com.fluxtion.runtime.event.Event;

/**
 * A TradeAcknowledgement event indicates a venue has acknowledged a Trade. The
 * TradeAcknowledgement is a filtered event where the filterString is the
 * venueId.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class TradeAcknowledgement extends Event {

    public int tradeId;
    public String tradeStringId;
    public long time;

    public TradeAcknowledgement() {
        super();
    }

    public TradeAcknowledgement(String venueId, int tradeId) {
        super();
        filterString = venueId;
        this.tradeId = tradeId;
    }

    public void setVenueId(String venueId) {
        filterString = venueId;
    }

    public String venueId() {
        return filterString;
    }

}
