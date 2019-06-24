/*
 * Copyright (C) 2018 greg
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
package com.fluxtion.casestudy.creditmonitor.volatility;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.casestudy.creditmonitor.volatility.events.InterestRateEvent;
import com.fluxtion.casestudy.creditmonitor.volatility.events.MarketTrades;
import java.util.Objects;

/**
 *
 * @author greg
 */
public class MarketSentiment {

    public String name;
    
    @EventHandler
    public void interestRates(InterestRateEvent interestRates) {

    }

    @EventHandler
    public void trades(MarketTrades trades) {

    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
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
        final MarketSentiment other = (MarketSentiment) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
