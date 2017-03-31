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
package com.fluxtion.learning.fx.example1;

import com.fluxtion.fx.EventAuditor;
import com.fluxtion.fx.node.biascheck.EventAuditDelegator;
import com.fluxtion.fx.node.biascheck.OrderBiasResult;
import static com.fluxtion.fx.util.CcyPair.*;
import com.fluxtion.learning.fx.utils.ConsoleAuditor;
import com.fluxtion.learning.fx.utils.Log4jAuditor;
import com.fluxtion.learning.fx.utils.PriceOrderGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class RunSampleMarket {

    private final boolean printAuditToConsole = false;

    public static void main(String[] args) throws InterruptedException {
//        new RunSampleMarket().runMarket_1();
        new RunSampleMarket().runMarket_log4j(5 * 60);
    }

    private void runMarket_1() throws InterruptedException {
        System.out.println("Running market 1 test");
        G10Monitor monitor = new G10Monitor();
        final ConsoleAuditor auditor = new ConsoleAuditor();
        auditor.printToConsole = printAuditToConsole;
        //register listeners
        monitor.registerEventAuditor(auditor);
        monitor.registerBreachNotificationHandler((breachNotification) -> {
            System.out.println("breach notification:" + breachNotification.toString());
        });
        monitor.registerResultsReceiver((long seconds, OrderBiasResult[] results) -> {
//            LOGGER.info("Current bias at:" + seconds + " seconds");
//            for (int i = 0; i < results.length; i++) {
//                LOGGER.info("\t" + results[i]);
//            }
        });
        PriceOrderGenerator orderGenerator = new PriceOrderGenerator(monitor);
        orderGenerator.init();
        orderGenerator.addCcy(EURUSD);
        orderGenerator.addCcy(GBPUSD);
        orderGenerator.addCcy(EURCHF);
        orderGenerator.addCcy(USDCHF);
        //
        System.out.println("starting order geenerator");
        orderGenerator.startMarket(1);
        Thread.sleep(5 * 1 * 1000);
        System.out.println("stopping order geenerator");
        orderGenerator.stopMarket();
        System.out.println("message stats:" + auditor.toString());

    }

    private void runMarket_log4j(int lengthOfRun) throws InterruptedException {
        final Log4jAuditor log4jAuditor = new Log4jAuditor();
        PriceOrderGenerator orderGenerator = builOrderGenerator(log4jAuditor);
        runMarketForSetPeriod(orderGenerator, lengthOfRun);
        System.out.println(log4jAuditor.toString());
    }

    private void runMarketForSetPeriod(PriceOrderGenerator orderGenerator, int seconds) throws InterruptedException {
        //
        System.out.println("starting order geenerator");
        orderGenerator.startMarket(1);
        Thread.sleep(seconds * 1000);
        System.out.println("stopping order geenerator");
        orderGenerator.stopMarket();
    }

    private PriceOrderGenerator builOrderGenerator(EventAuditor auditor) {
        G10Monitor monitor = new G10Monitor();
        //register listeners
        if (auditor != null) {
            monitor.registerEventAuditor(auditor);
        }
        PriceOrderGenerator orderGenerator = new PriceOrderGenerator(monitor);
        orderGenerator.init();
        orderGenerator.addCcy(EURUSD);
        orderGenerator.addCcy(GBPUSD);
        orderGenerator.addCcy(EURCHF);
        orderGenerator.addCcy(USDCHF);
        return orderGenerator;
    }
}
