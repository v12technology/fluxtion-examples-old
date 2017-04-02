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
package com.fluxtion.learning.fx.example4;

import com.fluxtion.fx.marshaller.csv.Log4jAuditor;
import com.fluxtion.fx.node.biascheck.OrderBiasResult;
import com.fluxtion.fx.node.biascheck.OrderBiasResultHandler;
import com.fluxtion.learning.fx.example1.*;
import com.fluxtion.fx.replay.CsvAuditReplay;
import com.fluxtion.fx.util.ConsoleAuditor;
import com.fluxtion.fx.util.ConsoleBreachHandler;
import com.fluxtion.learning.fx.utils.PriceOrderGenerator;
import java.io.File;

/**
 * A sample program to demonstrate the performance of a 
 *
 * <ul>
 * <li>auditRealtime - simulates a sample market for 5 seconds, generates
 * prices, orders, accepts and rejects. The market ticks every 100 millis. All
 * input is logged to a Log4jAuditor that stores the events as CSV records</li>
 * <li>replayAuditLog - sends messages programmatically to the
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
public class MainExample4 {


    public static void main(String[] args) throws InterruptedException {
        noAuditor();
        log4jAuditor();
        replayAuditLog();
    }

    private static void log4jAuditor() {
        System.out.println("Demonstrate Bias processing in realtime with auditing using log4j2");
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        final Log4jAuditor log4jAuditor = new Log4jAuditor();
        monitor.registerEventAuditor(log4jAuditor);
        //market
        PriceOrderGenerator market = new PriceOrderGenerator(monitor);
        long now = System.nanoTime();
        market.runMarketForPeriod(5, -1);
        now = (System.nanoTime() - now)/1_000_000;
        System.out.println(log4jAuditor.toString());
        System.out.printf("process time:%,d millis, event rate:%,d events per second\n", now, (int)(log4jAuditor.totalEventCount()/(0.001 *now)));
        System.out.println("=================================================================================================\n\n\n");
    }

    private static void noAuditor() {
        System.out.println("Demonstrate Bias processing in realtime with no auditing ");
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        final ConsoleAuditor consoleAuditor = new ConsoleAuditor();
        consoleAuditor.printToConsole = false;
        monitor.registerEventAuditor(consoleAuditor);
        //market
        PriceOrderGenerator market = new PriceOrderGenerator(monitor);
        long now = System.nanoTime();
        market.runMarketForPeriod(5, -1);
        now = (System.nanoTime() - now)/1_000_000;
        System.out.println(consoleAuditor.toString());
        System.out.printf("process time:%,d millis, event rate:%,d events per second\n", now, (int)(consoleAuditor.totalEventCount()/(0.001 *now)));
        System.out.println("=================================================================================================\n\n\n");
    }
    
    private static void replayAuditLog(){
        System.out.println("\n\nStarting replay with new instance of G10Monitor from src\\test\\resources\\replay\\fluxtionfx-audit-large.log");
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        final ConsoleAuditor consoleAuditor = new ConsoleAuditor();
        consoleAuditor.printToConsole = false;
        monitor.registerEventAuditor(consoleAuditor);
        CsvAuditReplay replay = new CsvAuditReplay();
        long now = System.nanoTime();
        replay.replay(monitor, new File("src\\test\\resources\\replay\\fluxtionfx-audit-large.log"));
        now = (System.nanoTime() - now)/1_000_000;
        System.out.println(consoleAuditor.toString());
        System.out.printf("process time:%,d millis, event rate:%,d events per second\n", now, (int)(consoleAuditor.totalEventCount()/(0.001 *now)));
        System.out.println("=================================================================================================");
        
    }

}
