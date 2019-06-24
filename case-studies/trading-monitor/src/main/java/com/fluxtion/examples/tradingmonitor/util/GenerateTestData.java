/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.examples.tradingmonitor.util;

import java.util.Random;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Greg Higgins greg.higgins@v12technology.com
 */
public class GenerateTestData {

    private static Logger logger = LogManager.getLogger();
    private static Logger testDataLog = LogManager.getLogger("testdatalog");
    private static String[] assets = new String[]{"MSFT", "ORCL", "GOOG", "AMZN", "APPL", "FORD", "BTMN"};

    public static void main(String[] args) {
        logger.info("info message");
        logHeaders();
        for (int i = 0; i < 4_000_000; i++) {
            String asset = assets[(int) (Math.random() * (assets.length))];
            double price = (5 + Math.random()) * 3;
            price = Math.round(price * 10000)/10000.0;
            int size = (int) ((10 * Math.random()) - 5);
            if (Math.random() > 0.9) {
                logTrade(asset, size, price);
            } else {
                logPrice(asset, price);
            }
        }
    }

    private static void logTrade(String symbol, int size, double price) {
        if (size != 0) {
            testDataLog.info("Deal,{},{},{}", symbol, size, price);
        }
    }

    private static void logPrice(String symbol, double price) {
        testDataLog.info("AssetPrice,{},{}", symbol, price);
    }

    private static void logHeaders() {
        testDataLog.info("Deal,symbol,size,price");
        testDataLog.info("AssetPrice,symbol,price");

    }
    
}
