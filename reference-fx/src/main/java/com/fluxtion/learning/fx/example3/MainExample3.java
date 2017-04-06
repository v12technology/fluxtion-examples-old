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
package com.fluxtion.learning.fx.example3;

import com.fluxtion.fx.marshaller.csv.Log4jAuditor;
import com.fluxtion.fx.node.biascheck.OrderBiasResult;
import com.fluxtion.fx.node.biascheck.OrderBiasResultHandler;
import com.fluxtion.learning.fx.example1.*;
import com.fluxtion.fx.replay.CsvAuditReplay;
import com.fluxtion.fx.util.CcyPair;
import com.fluxtion.fx.util.ConsoleAuditor;
import com.fluxtion.fx.util.ConsoleBreachHandler;
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
 * <li>auditRealtime - simulates a sample market for 5 seconds, generates
 * prices, orders, accepts and rejects. The market ticks every 100 millis. All
 * input is logged to a Log4jAuditor that stores the events as CSV records</li>
 * <li>replayAuditLog - sends messages programmatically to the BiasProcessor
 * that will simulate a breach condition that will be logged to console</li>
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
public class MainExample3 {

    private final boolean printAuditToConsole = false;

    public static void main(String[] args) throws InterruptedException {
        auditRealtime();
        replayAuditLog();
    }

    private static void auditRealtime() {
        System.out.println("Demonstrate Bias processing in realtime with auditing and then replays ");
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        monitor.registerBreachNotificationHandler(new ConsoleBreachHandler());
        monitor.registerResultsReceiver(new OrderBiasResultPrinter());
        monitor.registerEventAuditor(new Log4jAuditor());
        //market
        PriceOrderGenerator market = new PriceOrderGenerator(monitor);
        market.runMarketForPeriod(5, 100);
        System.out.println("=================================================================================================");
    }

    private static void replayAuditLog() {
        System.out.println("\n\nStarting replay with new instance of G10Monitor");
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        monitor.registerBreachNotificationHandler(new ConsoleBreachHandler());
        monitor.registerResultsReceiver(new OrderBiasResultPrinter());
        monitor.registerEventAuditor(new ConsoleAuditor());
        CsvAuditReplay replay = new CsvAuditReplay();
        /**
         * Disable all audit and publishing with: 
         * monitor.enableAudit(true);
         * monitor.enableResultPublication(true);
         * monitor.enableResultPublication(true);
         */
        replay.replay(monitor, new File("target\\generated-sources\\testlog\\fluxtionfx-audit.log"));
        System.out.println("=================================================================================================");

    }

    private static class OrderBiasResultPrinter implements OrderBiasResultHandler {

        public OrderBiasResultPrinter() {
        }

        @Override
        public void handleEvent(long seconds, OrderBiasResult[] results) {
            System.out.println("Bias summary at " + seconds + " seconds");
            for (OrderBiasResult result : results) {
                System.out.println("\t" + result.toString());
            }
        }
    }

}
