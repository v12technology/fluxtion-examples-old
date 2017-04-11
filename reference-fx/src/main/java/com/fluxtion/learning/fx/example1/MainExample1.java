/* 
 * Copyright (C) 2017 V12 Technology Limited
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
package com.fluxtion.learning.fx.example1;

import com.fluxtion.fx.replay.CsvAuditReplay;
import com.fluxtion.fx.util.CcyPair;
import com.fluxtion.fx.util.ConsoleAuditor;
import static com.fluxtion.learning.fx.utils.BiasMonitorConfigurator.registerConsoleHandlers;
import com.fluxtion.learning.fx.utils.PriceOrderGenerator;
import com.fluxtion.learning.fx.utils.PriceOrderHelper;
import java.io.File;

/**
 * Two sample programs to demonstrate a BiasProcessor. In this case a monitor,
 * G10Monitor has been previously been generated and is used in these examples.
 * The two examples are
 *
 * <ul>
 * <li>logToConsoleRealtime - simulates a sample market for 5 seconds, generates
 * prices, orders, accepts and rejects. The market ticks every 100 millis. All
 * output is logged to the console</li>
 * <li>replayBreachesToConsole - sends messages programmatically to the
 * BiasProcessor that will simulate a breach condition that will be logged to
 * console</li>
 * </ul>
 *
 * The configuration for generating the G10Monitor is in the source file
 * G10MonitorBiasConfig.java and can be regenerated usin the maven profile
 * <pre>
 * mvn install -Pbuild-example1-BiasMonitor
 * </pre>
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class MainExample1 {

    private final boolean printAuditToConsole = false;

    public static void main(String[] args) throws InterruptedException {
        logToConsoleRealtime();
        replayBreachesToConsole();
    }

    private static void logToConsoleRealtime() {
        System.out.println("Demonstrate Bias processing in realtime with console logging");
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        registerConsoleHandlers(monitor);
        //market
        PriceOrderGenerator market = new PriceOrderGenerator(monitor);
        market.runMarketForPeriod(2, 250);
        System.out.println("=================================================================================================\n\n\n");

    }

    private static void replayBreachesToConsole() {
        System.out.println("Demonstrate a EURUSD bias breach at 10 minues (600 seconds), with console logging");
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        registerConsoleHandlers(monitor);
        PriceOrderHelper helper = new PriceOrderHelper(monitor);
        //send orders - within bias limit for 1 minute bucket, 
        //but breaches for 10 minute bucket
        helper.setWallClock(1 * 1000);
        helper.rejectOrderWithBias(CcyPair.EURUSD, 0.0012, true);
        helper.setWallClock(50 * 1000);
        helper.rejectOrderWithBias(CcyPair.EURUSD, 0.0014, true);
        //should be no breaches below 0.0015 for 1 minute
        helper.setWallClock(70 * 1000);
        //tick to 10 minutes + and should see a breach
        helper.setWallClock(100 + 10 * 60 * 1000);
        System.out.println("=================================================================================================");
    }


}
