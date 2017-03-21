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
package com.fluxtion.learning.declarative.ext.example2;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.Wrapper;
import static com.fluxtion.extension.declarative.builder.group.Group.groupBy;
import com.fluxtion.extension.declarative.builder.group.GroupByBuilder;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanFilter;
import com.fluxtion.runtime.event.Event;

/**
 * Process a FlightDetails event, broadcast when a plane lands to calculate for each carrier:
 * <ul>
 * <li>a cumulative sum of minutes delayed. 
 * <li>The number of delayed flights.
 * <li>The average delay for a late flight.
 * </ul>
 * FlightDetails contains the carrier name and  the delay if any on arrival. A negative delay is an early arrival and a 
 * positive value is the number of minutes late the plane landed. The solution demonstrates the use of GroupBy with
 * aggregate functions to calculate, averages, counts and sums.
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class FlightDelayProcessor extends SEPConfig {

        {
            //filter for positive delays
            Wrapper<FlightDetails> delayedFlight = greaterThanFilter(FlightDetails.class, FlightDetails::getDelay, 0);
            //group by carrier name
            GroupByBuilder<FlightDetails, CarrierDelay> carrierDelay = groupBy(delayedFlight, FlightDetails::getCarrier, CarrierDelay.class);
            //init each group record with human readable name
            carrierDelay.init(FlightDetails::getCarrier, CarrierDelay::setCarrierId);
            //aggregate calculations
            carrierDelay.avg(FlightDetails::getDelay, CarrierDelay::setAvgDelay);
            carrierDelay.count(FlightDetails::getDelay, CarrierDelay::setTotalFlights);
            carrierDelay.sum(FlightDetails::getDelay, CarrierDelay::setTotalDelayMins);
            //add public node for debug
            addPublicNode(carrierDelay.build(), "carrierDelayMap");
        }
        
    public static class FlightDetails extends Event {

        public FlightDetails() {
        }

        public FlightDetails(String filterString, int delay) {
            super();
            this.delay = delay;
            this.filterString = filterString;
        }

        public int delay;

        public String getCarrier() {
            return filterString;
        }

        public int getDelay() {
            return delay;
        }

    }
    
    public static class CarrierDelay{

        private String carrierId;
        private int avgDelay;
        private int totalFlights;
        private int totalDelayMins;

        public String getCarrierId() {
            return carrierId;
        }

        public void setCarrierId(String carrierId) {
            this.carrierId = carrierId;
        }

        public int getAvgDelay() {
            return avgDelay;
        }

        public void setAvgDelay(int avgDelay) {
            this.avgDelay = avgDelay;
        }

        public int getTotalFlights() {
            return totalFlights;
        }

        public void setTotalFlights(int totalFlights) {
            this.totalFlights = totalFlights;
        }

        public int getTotalDelayMins() {
            return totalDelayMins;
        }

        public void setTotalDelayMins(int totalDelayMins) {
            this.totalDelayMins = totalDelayMins;
        }

        @Override
        public String toString() {
            return "CarrierDelay{" + "carrierId=" + carrierId + ", avgDelay=" + avgDelay + ", totalFlights=" + totalFlights + ", totalDelayMins=" + totalDelayMins + '}';
        }
        
    }

}
