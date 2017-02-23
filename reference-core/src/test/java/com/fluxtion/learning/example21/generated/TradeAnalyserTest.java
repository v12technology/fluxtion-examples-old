/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example21.generated;

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
        processor.onEvent(new IntValueEvent(4, ""));
        processor.onEvent(new IntValueEvent(4));
        processor.onEvent(new IntValueEvent(33));
        processor.onEvent(new IntValueEvent(37));
        processor.onEvent(new IntValueEvent(37));
        processor.onEvent(new IntValueEvent(57));
        processor.onEvent(new IntValueEvent(67));
        processor.onEvent(new IntValueEvent(99));
        processor.onEvent(new IntValueEvent(199));
        processor.tradeAnalyser.tradeDistribution.printDistribution();
    }
}
