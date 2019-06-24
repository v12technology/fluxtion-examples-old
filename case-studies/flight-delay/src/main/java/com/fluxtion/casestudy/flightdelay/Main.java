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

import com.fluxtion.casestudy.flightdelay.generated.map.CsvToBinaryFlightData;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author greg
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("");
        switch (args.length) {
            case 0:
                System.out.println("required arguments:\n"
                        + "\t[csvfile]                       for csv calc\n"
                        + "\t[chronicle directory]           for chronicle calc\n"
                        + "\t[csvfile] [chronicle directory] convert CSV to chronicle data\n"
                );
                break;
            case 1:
                processData(args[0]);
                break;
            case 2:
                csv2Chronicle(args[0], args[1]);
                break;
            default:
                break;
        }
    }

    static void csv2Chronicle(String csvPath, String outDir) throws IOException {
        File queuePath = new File(outDir);
        if (queuePath.exists()) {
            FileUtils.cleanDirectory(queuePath);
        }
        CsvToBinaryFlightData flightMonitor = new CsvToBinaryFlightData();
        flightMonitor.chronicleSink.setOutDir(outDir);
        flightMonitor.chronicleSink.setOutFile(Paths.get(outDir).getParent().resolve("flightdelays.bin").toString());
        File csvFile = new File(csvPath);
        streamFromFile(csvFile, flightMonitor, true);
    }

    static void processData(String dataPathString) {
        DelayStatsCalculator calc = new DelayStatsCalculator();
        File dataFile = Paths.get(dataPathString).toFile();
        if (dataFile.isDirectory()) {
            //chronicle
            System.out.println(calc.renderFromChronicle(dataFile));
        } else if (dataFile.exists() && dataFile.toString().toLowerCase().endsWith("csv")) {
            System.out.println(calc.renderFromCsv(dataFile));
        } else if (dataFile.exists() && dataFile.toString().toLowerCase().endsWith("bin")) {
            System.out.println(calc.renderFromBinary(dataFile));
        } else {
            System.out.printf("neither directory or real file supplied:'%s'%n", dataPathString);
        }
    }

}
