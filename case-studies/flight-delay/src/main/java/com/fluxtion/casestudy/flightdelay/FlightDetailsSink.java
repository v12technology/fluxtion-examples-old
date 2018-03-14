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

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import java.io.File;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

/**
 *
 * @author gregp
 */
public class FlightDetailsSink {

    private final Wrapper<FlightDetails> source;
    private FlightDetailsHandler chronicleSink;
    private transient String outDir = "target/chronicle";
    
    public FlightDetailsSink(Wrapper<FlightDetails> source) {
        this.source = source;
    }

    public String getOutDir() {
        return outDir;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    @OnEvent
    public void writeFlightDetails() {
        final FlightDetails flightDetails = source.event();
        System.out.println(flightDetails);
        chronicleSink.flightDetails(flightDetails);
    }

    @Initialise
    public void init() {
        File queuePath = new File(outDir);
        if (!queuePath.exists()) {
            queuePath.mkdirs();
        }
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(queuePath).build();
        chronicleSink = queue.acquireAppender().methodWriter(FlightDetailsHandler.class);
    }
    
    public static interface FlightDetailsHandler {
        void flightDetails(FlightDetails details);
    }
}
