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
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author gregp
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        for (int i = 0; i < 25; i++) {
            count = 0;
            m.run(args);
        }
    }
    static int count;

    public void run(String[] args) throws IOException {
        long delta = System.nanoTime();

        String dataPathString = "dist/worldcity/worldcitiespop.csv";
//        String dataPathString = "dist/worldcity/test.csv";
        File dataFile = Paths.get(dataPathString).toFile();
        CsvWorldCityDataProcessor processor = new CsvWorldCityDataProcessor();
        processor.dispatcher.setConsumer((t) -> count++);
        streamFromFile(dataFile, processor, true);
        delta = System.nanoTime() - delta;
        double duration = (delta / 1_000_000) / 1000.0;
        System.out.println("processed file:" + dataFile.getAbsolutePath());
        System.out.println("row count:" + count + " processing time:" + duration + " seconds");

    }

}
