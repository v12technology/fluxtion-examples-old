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
package com.fluxtion.casestudy.musicroyalty.volatility;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Inject;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.runtime.plugin.events.TimingPulseEvent;
import java.util.Objects;

/**
 *
 * @author greg
 */
public class VolatilityCalc {
    
    @Inject
    private final CreditRisk creditRisk;
    
    @Inject
    private final MarketSentiment marketSentiment;
    
    private double volatilityMultiplier = 2;

    public VolatilityCalc(CreditRisk creditRisk, MarketSentiment marketSentiment) {
        this.creditRisk = creditRisk;
        this.marketSentiment = marketSentiment;
        volatilityMultiplier = 2;
    }

    public double volatilityMultiplier() {
        return volatilityMultiplier;
    }
    
    @EventHandler
    public void timePulse(TimingPulseEvent timeUpdae){
        
    }
    
    @OnEvent
    public boolean calcVolatility(){
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.creditRisk);
        hash = 73 * hash + Objects.hashCode(this.marketSentiment);
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
        final VolatilityCalc other = (VolatilityCalc) obj;
        if (!Objects.equals(this.creditRisk, other.creditRisk)) {
            return false;
        }
        if (!Objects.equals(this.marketSentiment, other.marketSentiment)) {
            return false;
        }
        return true;
    }

}
