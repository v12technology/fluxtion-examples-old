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
package com.fluxtion.learning.fx.example5;

import com.fluxtion.learning.fx.example4.*;
import com.fluxtion.fx.marshaller.csv.Log4jAuditor;
import com.fluxtion.fx.node.biascheck.OrderBiasResult;
import com.fluxtion.fx.node.biascheck.OrderBiasResultHandler;
import com.fluxtion.learning.fx.example1.*;
import com.fluxtion.fx.replay.CsvAuditReplay;
import com.fluxtion.fx.util.ConsoleAuditor;
import com.fluxtion.fx.util.ConsoleBreachHandler;
import com.fluxtion.learning.fx.utils.PriceOrderGenerator;
import java.io.File;
import java.io.IOException;

/**
 * A sample program to demonstrate the performance:
 * 
 * <ul>
 * <li> using log4j2 as a csv auditor ,randomaccessfile appender with no flush</li>
 * <li> using a null auditor to compare to log4j2</li>
 * <li> Replaying events from log4j2 csv auditor</li>
 *
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class MainExample5 {

    private static final File AUDIT_FILE = new File("target\\generated-sources\\testlog\\fluxtionfx-chroncile-audit.cp4");

    public static void main(String[] args) throws InterruptedException, IOException {
        noAuditor();
        chroniclejAuditor();
        replayChronicleAuditLog();
    }

    private static void chroniclejAuditor() throws IOException {
        System.out.println("Demonstrate Bias processing in realtime with auditing using Chronicle:" + AUDIT_FILE.getCanonicalPath());
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        
        final ChronicleAuditor chroniclejAuditor = new ChronicleAuditor(AUDIT_FILE);
        monitor.registerEventAuditor(chroniclejAuditor);
        //market
        PriceOrderGenerator market = new PriceOrderGenerator(monitor);
        long now = System.nanoTime();
        market.runMarketForPeriod(5, -1);
        now = (System.nanoTime() - now)/1_000_000;
        System.out.println(chroniclejAuditor.toString());
        System.out.printf("process time:%,d millis, event rate:%,d events per second\n", now, (int)(chroniclejAuditor.totalEventCount()/(0.001 *now)));
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
    
    private static void replayChronicleAuditLog() throws IOException{
        System.out.println("\n\nStarting replay from chfroncile with new instance of G10Monitor from:" +  AUDIT_FILE.getCanonicalPath());
        System.out.println("=================================================================================================");
        G10Monitor monitor = new G10Monitor();
        final ConsoleAuditor consoleAuditor = new ConsoleAuditor();
        consoleAuditor.printToConsole = false;
        monitor.registerEventAuditor(consoleAuditor);
        ChronicleAuditReplay replay = new ChronicleAuditReplay();
        long now = System.nanoTime();
        replay.replay(monitor, AUDIT_FILE);
        now = (System.nanoTime() - now)/1_000_000;
        System.out.println(consoleAuditor.toString());
        System.out.printf("process time:%,d millis, event rate:%,d events per second\n", now, (int)(consoleAuditor.totalEventCount()/(0.001 *now)));
        System.out.println("=================================================================================================");
        
    }

}
