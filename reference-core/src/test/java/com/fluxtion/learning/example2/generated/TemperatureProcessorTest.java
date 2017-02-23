/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example2.generated;

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
         processor.handleEvent(new TemperatureEvent(26));
         processor.handleEvent(new TemperatureEvent(22));
         processor.handleEvent(new TemperatureEvent(12));
         processor.handleEvent(new TemperatureEvent(-10));
     }
}
