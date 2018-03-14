/*
 * Copyright (C) 2018 gregp
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
package com.fluxtion.casestudy.flightdelay;

import com.fluxtion.casestudy.flightdelay.FlightDelayProcessor.FlightDetails;
import com.fluxtion.casestudy.flightdelay.FlightDetailsSink.FlightDetailsHandler;
import com.fluxtion.casestudy.flightdelay.generated.CsvToBinaryFlightData;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import java.io.File;
import java.io.IOException;
import net.openhft.chronicle.bytes.MethodReader;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 *
 * @author gregp
 */
public class SinkTest {

    @Test
    public void testCarrierDelayFromCsvFile() throws IOException {
        File queuePath = new File("target/chronicle");
        FileUtils.cleanDirectory(queuePath); 
        CsvToBinaryFlightData flightMonitor = new CsvToBinaryFlightData();
        File csvFile = new File("src/test/resources/flightdetails.csv");
        streamFromFile(csvFile, flightMonitor, true);

        if (!queuePath.exists()) {
            queuePath.mkdirs();
        }
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(queuePath).build();

        ExcerptTailer tailer = queue.createTailer();
        MethodReader methodReader = tailer.methodReader((FlightDetailsHandler) (FlightDetails e) -> {
            System.out.println("read from chronicle:" + e);
        });
        
        
        while(methodReader.readOne()){
            
        }
    }
}
