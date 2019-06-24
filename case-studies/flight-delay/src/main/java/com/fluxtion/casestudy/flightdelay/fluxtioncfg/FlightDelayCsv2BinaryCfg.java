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
 * Convert CSV flight delay data into a binary form. Persist the binary form and
 * use for processing later. Extract data from the CVS source in the following
 * columns:
 *
 * <ul>
 * <li>Group the carriers by name, column 8
 * <li>Delay is column 14
 * </li>
 *
 * Original US CSV flight data from:
 * http://stat-computing.org/dataexpo/2009/the-data.html
 *
 *
 * FlightDetailsSink is informed every time a complete FlightDetails record is
 * read from the CSV source and streams a binary version to storage.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class FlightDelayCsv2BinaryCfg extends SEPConfig {

    {
        //add csv parser
        Wrapper<FlightDetails> flightDetails = csvMarshaller(FlightDetails.class, 1).map(14, FlightDetails::setDelay).map(8, FlightDetails::setCarrier).build();
        //stream FlightDetails to sink
        addPublicNode(new FlightDetailsSink(flightDetails), "chronicleSink");
    }

}
