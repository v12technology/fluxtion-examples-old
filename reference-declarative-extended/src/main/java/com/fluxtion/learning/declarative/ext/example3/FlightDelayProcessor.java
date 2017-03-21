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
package com.fluxtion.learning.declarative.ext.example3;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.Wrapper;
import static com.fluxtion.extension.declarative.builder.group.Group.groupBy;
import com.fluxtion.extension.declarative.builder.group.GroupByBuilder;
import static com.fluxtion.extension.declarative.funclib.builder.csv.CsvMarshallerBuilder.csvMarshaller;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanFilter;
import com.fluxtion.runtime.event.Event;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class FlightDelayProcessor extends SEPConfig {

        {
            //add csv parser
            Wrapper<FlightDetails> flightDetails = csvMarshaller(FlightDetails.class, 1).map(14, FlightDetails::setDelay).mapString(8, FlightDetails::setCarrier).build();
            //filter for positive delays
            Wrapper<FlightDetails> delayedFlight = greaterThanFilter(flightDetails, FlightDetails::getDelay, 0);
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

        public int delay;

        public void setCarrier(String carrier) {
            this.filterString = carrier;
        }

        public String getCarrier() {
            return filterString;
        }

        public void setDelay(int delay) {
            this.delay = delay;
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
