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
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.casestudy.flightdelay.FlightDetailsSink;
import com.fluxtion.extension.declarative.api.Wrapper;
import static com.fluxtion.extension.declarative.funclib.builder.csv.CsvMarshallerBuilder.csvMarshaller;

/**
 * Inspired by
 * https://blog.redelastic.com/diving-into-akka-streams-2770b3aeabb0#.lt2w5bntb
 *
 * Process CSV flight data from the
 * http://stat-computing.org/dataexpo/2009/the-data.html
 *
 * Calculate summary delay statistics for each carrier that has a fightdetails
 * record in the CVS source., the summary should:
 *
 * <ul>
 * <li>Group the carriers by name, column 8
 * <li>Delay is column 14
 * <li>Cumulative sum of total delay
 * <li>Total number of delayed flights
 * <li>Average delay for a flight if it is late
 * </li>
 *
 * FlightDetails contains the carrier name and the delay if any on arrival. A
 * negative delay is an early arrival and a positive value is the number of
 * minutes late the plane landed. The solution demonstrates the use of GroupBy
 * with aggregate functions to calculate, averages, counts and sums, fed by CSV
 * data.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class FlightDelayCsv2BinaryCfg extends SEPConfig {

    {
        //add csv parser
        Wrapper<FlightDetails> flightDetails = csvMarshaller(FlightDetails.class, 1).map(14, FlightDetails::setDelay).mapString(8, FlightDetails::setCarrier).build();
        addPublicNode(new FlightDetailsSink(flightDetails), "chronicleSink");
    }



}
