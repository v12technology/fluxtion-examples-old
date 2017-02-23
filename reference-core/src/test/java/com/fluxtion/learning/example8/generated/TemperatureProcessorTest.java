/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example8.generated;

import com.fluxtion.learning.TemperatureEvent;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class TemperatureProcessorTest {
    
     @Test
     public void publishTemperaures() {
         TemperatureProcessor processor = new TemperatureProcessor();
         processor.init();
         processor.handleEvent(new TemperatureEvent(-25));
         processor.handleEvent(new TemperatureEvent(-15));
         processor.handleEvent(new TemperatureEvent(15));
         processor.handleEvent(new TemperatureEvent(35));
         processor.handleEvent(new TemperatureEvent(4));
         processor.handleEvent(new TemperatureEvent(15));
         processor.handleEvent(new TemperatureEvent(19));
         processor.handleEvent(new TemperatureEvent(23));
         processor.handleEvent(new TemperatureEvent(44));
         processor.handleEvent(new TemperatureEvent(5));
         processor.handleEvent(new TemperatureEvent(355));
         processor.handleEvent(new TemperatureEvent(-29));
         processor.tearDown();
     }
}
