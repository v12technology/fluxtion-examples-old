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
package com.fluxtion.learning.declarative.ext.music;

import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import com.fluxtion.learning.declarative.ext.music.csv.CsvTrackMarshaller;
import com.fluxtion.learning.declarative.ext.music.indicators.TrackProcessor;
import com.fluxtion.learning.declarative.ext.music.util.OrderedPublisher;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author gregp
 */
public class TrackStreamAnalyser {

    private CsvTrackMarshaller marshaller;
    private OrderedPublisher publisher;

    public TrackStreamAnalyser() {
        marshaller = new CsvTrackMarshaller();
        publisher = new OrderedPublisher();
    }

    public void run(File csvFile) throws IOException {
        marshaller.tracks.addEventHandler(publisher);
        publisher.setHandler(new TrackProcessor());
        streamFromFile(csvFile, marshaller, true);
        publisher.publish();
    }

}
