/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.examples.tradingmonitor.util;

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
    public static void main(String[] args) {
        logger.info("info message");
        logHeaders();
        for(int i = 0; i<2_000_000; i++){
            logPrice("MSFT", 10);
            logTrade("MSFT",10,2);
        }
    }
    
    private static void logTrade(String symbol, int size, double price){
        testDataLog.info("Deal,{},{},{}", symbol, size, price);
    }
    
    private static void logPrice(String symbol, double price){
        testDataLog.info("AssetPrice,{},{}", symbol, price);
    }
    
    private static void logHeaders(){
        testDataLog.info("Deal,symbol,size,price");
        testDataLog.info("AssetPrice,symbol,price");
        
    }
    
}
