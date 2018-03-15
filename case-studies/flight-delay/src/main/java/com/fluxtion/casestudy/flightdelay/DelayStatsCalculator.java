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
package com.fluxtion.casestudy.flightdelay;

import com.fluxtion.casestudy.flightdelay.generated.binary.BinaryFlightDataProcessor;
import com.fluxtion.casestudy.flightdelay.generated.csv.CsvFlightDataProcessor;
import com.fluxtion.extension.declarative.api.Wrapper;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import com.fluxtion.util.FlightDetailsReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import net.openhft.chronicle.bytes.MethodReader;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

/**
 * Calculates statistics using 3 different serialisation approaches:
 * <ul>
 * <li>CSV
 * <li>chronicle queue - method reader
 * <li>bespoke binary serialisation
 * </ul>
 * @author greg
 */
public class DelayStatsCalculator {

    public Map<String, Wrapper<CarrierDelay>> calcFromCsv(File csvFile) throws IOException {
        CsvFlightDataProcessor processor = new CsvFlightDataProcessor();
        streamFromFile(csvFile, processor, true);
        Map<?, Wrapper<CarrierDelay>> map = processor.carrierDelayMap.getMap();
        return (Map<String, Wrapper<CarrierDelay>>) map;
    }

    public Map<String, Wrapper<CarrierDelay>> calcFromBinary(File binaryFile) throws IOException {
        BinaryFlightDataProcessor processor = new BinaryFlightDataProcessor();
        processor.init();
        FlightDetailsReader binMarshaller = new FlightDetailsReader(binaryFile);
        binMarshaller.readAll(processor::onEvent);
        Map<?, Wrapper<CarrierDelay>> map = processor.carrierDelayMap.getMap();
        return (Map<String, Wrapper<CarrierDelay>>) map;
    }

    public Map<String, Wrapper<CarrierDelay>> calcFromChronicle(File queueFile) throws IOException {
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(queueFile).build();
        BinaryFlightDataProcessor processor = new BinaryFlightDataProcessor();
        processor.init();
        ExcerptTailer tailer = queue.createTailer();
        MethodReader methodReader = tailer.methodReader((FlightDetailsSink.FlightDetailsHandler) processor::handleEvent);
        while (methodReader.readOne()) {
        }
        Map<?, Wrapper<CarrierDelay>> map = processor.carrierDelayMap.getMap();
        return (Map<String, Wrapper<CarrierDelay>>) map;
    }

    public String renderStats(String message, Map<String, Wrapper<CarrierDelay>> map) {
        StringBuilder sb = new StringBuilder(message);
        map.values().stream().map(e -> e.event())
                .sorted((f1, f2) -> f1.getAvgDelay() - f2.getAvgDelay())
                .forEach((f) -> sb.append(f).append("\n"));
        sb.append("\ntotal rows processed:").append(map.values().stream().mapToInt(e -> e.event().getTotalFlights()).sum());
        return sb.toString();
    }

    public String renderFromCsv(File file) {
        return renderFromCsv(file, "\nCSV carrier delay calc\n==========================\n");
    }

    public String renderFromChronicle(File file) {
        return renderFromChronicle(file, "\nChronicle carrier delay calc\n==========================\n");
    }

    public String renderFromBinary(File file) {
        return renderFromBinaryFile(file, "\nBinary carrier delay calc\n==========================\n");
    }

    public String renderFromCsv(File file, String message) {
        try {
            long delta = System.nanoTime();
            final Map<String, Wrapper<CarrierDelay>> calcFromCsv = calcFromCsv(file);
            delta = System.nanoTime() - delta;
            double duration = (delta / 1_000_000) / 1000.0;
            final String renderStats = renderStats(message, calcFromCsv);
            return renderStats + "\nprocessing time:" + duration + " seconds";
        } catch (IOException ex) {
            return "failed to process error:" + ex.getMessage();
        }
    }

    public String renderFromChronicle(File file, String message) {
        try {
            long delta = System.nanoTime();
            final Map<String, Wrapper<CarrierDelay>> calcFromCsv = calcFromChronicle(file);
            delta = System.nanoTime() - delta;
            double duration = (delta / 1_000_000) / 1000.0;
            final String renderStats = renderStats(message, calcFromCsv);
            return renderStats + "\nprocessing time:" + duration + " seconds";
        } catch (IOException ex) {
            return "failed to process error:" + ex.getMessage();
        }
    }

    public String renderFromBinaryFile(File file, String message) {
        try {
            long delta = System.nanoTime();
            final Map<String, Wrapper<CarrierDelay>> calcFromCsv = calcFromBinary(file);
            delta = System.nanoTime() - delta;
            double duration = (delta / 1_000_000) / 1000.0;
            final String renderStats = renderStats(message, calcFromCsv);
            return renderStats + "\nprocessing time:" + duration + " seconds";
        } catch (IOException ex) {
            return "failed to process error:" + ex.getMessage();
        }
    }
}
