/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example9.generated;

import com.fluxtion.learning.example9.WordEvent;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class NewsAnalyserTest {
    
    @Test
    public void testNewsAnalyser(){
        NewsProcessor newsProcessor = new NewsProcessor();
        newsProcessor.init();
        newsProcessor.onEvent(new WordEvent("IT"));
        newsProcessor.onEvent(new WordEvent("ram"));
        newsProcessor.onEvent(new WordEvent("test"));
        newsProcessor.onEvent(new WordEvent("picasso"));
        newsProcessor.onEvent(new WordEvent("CEP"));
        newsProcessor.tearDown();
    }
}
