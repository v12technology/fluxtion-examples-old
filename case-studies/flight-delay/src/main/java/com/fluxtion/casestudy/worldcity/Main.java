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
package com.fluxtion.casestudy.worldcity;

import com.fluxtion.casestudy.worldcity.generated.csv.CsvWorldCityDataProcessor;
import com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import com.fluxtion.extension.declarative.funclib.builder.util.CharEventStreamer;
import com.fluxtion.runtime.lifecycle.EventHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;

/**
 *
 * @author gregp
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        for (int i = 0; i < 25; i++) {
            count = 0;
            m.run(args);
        }
//        streamer.shutDown();
    }
    static int count;

    public void run(String[] args) throws Exception {
        CharEventStreamer streamer = new CharEventStreamer();
        long delta = System.nanoTime();
        String dataPathString = "dist/worldcity/worldcitiespop.csv";
        File dataFile = Paths.get(dataPathString).toFile();
        CsvWorldCityDataProcessor processor = new CsvWorldCityDataProcessor();
        processor.dispatcher.setConsumer((t) -> count++);
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
            streamer.streamFromReader(reader, processor);
        } else {
            streamer.streamFromFile(dataFile, processor);
        }
        delta = System.nanoTime() - delta;
        double duration = (delta / 1_000_000) / 1000.0;
        System.out.println("processed file:" + dataFile.getAbsolutePath());
        System.out.println("row count:" + count + " processing time:" + duration + " seconds");

    }

}
