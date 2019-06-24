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
package com.fluxtion.casestudy.flightdelay.fluxtioncfg;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.casestudy.flightdelay.CarrierDelay;
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.extension.declarative.api.Wrapper;
import static com.fluxtion.extension.declarative.builder.event.EventSelect.select;
import static com.fluxtion.extension.declarative.builder.group.Group.groupBy;
import com.fluxtion.extension.declarative.builder.group.GroupByBuilder;
import static com.fluxtion.extension.declarative.funclib.builder.math.CountFunction.count;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanFilter;

/**
 * Inspired by
 * https://blog.redelastic.com/diving-into-akka-streams-2770b3aeabb0#.lt2w5bntb
 * <p>
 *
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
 * each carrier:
 * <ul>
 * <li>Cumulative sum of minutes delayed.
 * <li>The number of delayed flights.
 * <li>The average delay for a late flight.
 * </ul>
 * FlightDetails contains the carrier name and the delay if any on arrival. A
 * negative delay is an early arrival and a positive value is the number of
 * minutes late the plane landed. Only calculate statistics for a plne that is
 * late, i.e. delay is &gt; 0
 * <p>
 * The solution demonstrates the use of GroupBy with aggregate functions to
 * calculate, averages, counts and sums.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class BinaryFlightDelayCfg extends SEPConfig {

    {
        //filter for positive delays
        Wrapper<FlightDetails> delayedFlight = greaterThanFilter(FlightDetails.class, FlightDetails::getDelay, 0);
        //group by carrier name
        GroupByBuilder<FlightDetails, CarrierDelay> carrierDelay = 
                groupBy(delayedFlight, FlightDetails::getCarrier, CarrierDelay.class);
        //init each group record with human readable name
        carrierDelay.init(FlightDetails::getCarrier, CarrierDelay::setCarrierId);
        //aggregate calculations
        carrierDelay.avg(FlightDetails::getDelay, CarrierDelay::setAvgDelay);
        carrierDelay.count(CarrierDelay::setTotalFlights);
        carrierDelay.sum(FlightDetails::getDelay, CarrierDelay::setTotalDelayMins);
        //add public node for debug and actually build the query
        addPublicNode(carrierDelay.build(), "carrierDelayMap");
        //total records processed - compound select -> count
        addPublicNode(count(select(FlightDetails.class)), "totalFlights");
    }

}
