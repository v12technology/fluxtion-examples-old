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
package com.fluxtion.casestudy.flightdelay.fluxtioncfg;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.casestudy.flightdelay.CarrierDelay;
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.extension.declarative.api.Wrapper;
import static com.fluxtion.extension.declarative.builder.group.Group.groupBy;
import com.fluxtion.extension.declarative.builder.group.GroupByBuilder;
import static com.fluxtion.extension.declarative.funclib.builder.math.CountFunction.count;
import static com.fluxtion.extension.declarative.funclib.builder.csv.CsvMarshallerBuilder.csvMarshaller;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanFilter;

/**
 * 
 *
 * @see
 * <a href=https://blog.redelastic.com/diving-into-akka-streams-2770b3aeabb0#.lt2w5bntb>Inspired by: Diving
 * into Akka Streams</a>
 * <p>
 * This is the definition file used by Fluxtion stream compiler to generate a
 * static event processor. The output of generation is an implementation of an {@link com.fluxtion.runtime.lifecycle.EventHandler} -
 * {@link com.fluxtion.casestudy.flightdelay.generated.binary.FlightDetailsHandler}
 * that the application can link to. Additonal helper classes are generated as
 * determined by the Fluxtion compiler. The event handler will handle any event
 * the application posts. All dispatch, calculation logic and state management
 * are encapsulated in the generated EventHandler.
 * <p>
 *
 * We specify a publicly scoped node, <code>carrierDelayMap</code>, that the app
 * can query for results of the query processing. The carrierDelayMap node is an
 * implementation of
 * {@link com.fluxtion.extension.declarative.api.group.GroupBy} that holds
 * results of a grouping query.
 * <p>
 *
 * <h2>Application requirements</h2>
 * <p>
 * Process a FlightDetails event, broadcast when a plane lands to calculate for
 * each carrier. The yearly data is stored in CVS format @see
 * <a href="http://stat-computing.org/dataexpo/2009/the-data.html">http://stat-computing.org/dataexpo/2009/the-data.html</a>.
 * <p>
 *
 * For a full year calculate summary delay statistics for each carrier that has
 * a fight details record in the CVS source, the summary should:
 *
 * <ul>
 * <li>Group the carriers by name, column 8
 * <li>Delay is column 14
 * <li>Cumulative sum of total delay
 * <li>Total number of delayed flights
 * <li>Average delay for a flight if it is late
 * </ul>
 * <p>
 * FlightDetails contains the carrier name and the delay if any on arrival. A
 * negative delay is an early arrival and a positive value is the number of
 * minutes late the plane landed. The solution demonstrates the use of GroupBy
 * with aggregate functions to calculate, averages, counts and sums, fed by CSV
 * data.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class CsvFlightDelayCfg extends SEPConfig {

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
        //total records processed counts FlightDetails events from csvMarshaller
        addPublicNode(count(flightDetails), "totalFlights");
    }

}
