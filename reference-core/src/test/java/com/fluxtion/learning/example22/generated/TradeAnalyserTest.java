/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example22.generated;

import com.fluxtion.learning.example21.IntValueEvent;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class TradeAnalyserTest {
    
    @Test
    public void distribution(){
        HistogramProcessor processor = new HistogramProcessor();
        processor.init();
        //trades
        processor.onEvent(new IntValueEvent(4,   "trades"));
        processor.onEvent(new IntValueEvent(4,   "trades"));
        processor.onEvent(new IntValueEvent(33,  "trades"));
        processor.onEvent(new IntValueEvent(37,  "trades"));
        processor.onEvent(new IntValueEvent(37,  "trades"));
        processor.onEvent(new IntValueEvent(57,  "trades"));
        processor.onEvent(new IntValueEvent(67,  "trades"));
        processor.onEvent(new IntValueEvent(99,  "trades"));
        processor.onEvent(new IntValueEvent(199, "trades"));
        //orders
        processor.onEvent(new IntValueEvent(21,   "orders"));
        processor.onEvent(new IntValueEvent(19,   "orders"));
        processor.onEvent(new IntValueEvent(33,  "orders"));
        processor.onEvent(new IntValueEvent(83,  "orders"));
        processor.onEvent(new IntValueEvent(3,  "orders"));
        processor.onEvent(new IntValueEvent(37,  "orders"));
        processor.onEvent(new IntValueEvent(37,  "orders"));
        processor.onEvent(new IntValueEvent(37,  "orders"));
        processor.onEvent(new IntValueEvent(77,  "orders"));
        processor.onEvent(new IntValueEvent(77,  "orders"));
        processor.onEvent(new IntValueEvent(74,  "orders"));
        processor.onEvent(new IntValueEvent(77,  "orders"));
        processor.onEvent(new IntValueEvent(6,  "orders"));
        processor.onEvent(new IntValueEvent(110,  "orders"));
        processor.onEvent(new IntValueEvent(200, "orders"));
        //pull some data
        processor.tradeAnalyser.tradeDistribution.printDistribution();
        processor.tradeAnalyser.orderDistribution.printDistribution();
    }
}
