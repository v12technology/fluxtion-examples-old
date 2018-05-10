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
package com.fluxtion.casestudy.musicroyalty.calcs;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.casestudy.musicroyalty.events.StreamedTrack;
import java.util.HashMap;

/**
 *
 * @author greg
 */
public class RevenueCalculation {
 
    private final RoyaltyLookup royaltyLookup;
    private final LocationRoyaltyFactor locationFactor;
    public HashMap<String, Double> revenueMap = new HashMap<>();

    public RevenueCalculation(RoyaltyLookup royaltyLookup, LocationRoyaltyFactor locationFactor) {
        this.royaltyLookup = royaltyLookup;
        this.locationFactor = locationFactor;
    }
    
    @EventHandler
    public boolean trackPlayed(StreamedTrack track){
        double revenue = royaltyLookup.royaltyMap.get(track.trackId) * track.revenue;
        revenueMap.put(track.trackId, revenue);
        return true;
    }
    
    @OnEvent
    public void calculateRoyalty(){
        
    }
}
