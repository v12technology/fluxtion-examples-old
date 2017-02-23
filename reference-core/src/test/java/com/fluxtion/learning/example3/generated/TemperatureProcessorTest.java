/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example3.generated;

import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.example2.generated.*;
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
         processor.handleEvent(new EndOfDayEvent(4));
         processor.handleEvent(new TemperatureEvent(26));
         processor.handleEvent(new TemperatureEvent(22));
         processor.handleEvent(new EndOfDayEvent(5));
         processor.handleEvent(new TemperatureEvent(6));
         processor.handleEvent(new TemperatureEvent(2));
         processor.handleEvent(new TemperatureEvent(12));
         processor.handleEvent(new EndOfDayEvent(6));
         processor.handleEvent(new TemperatureEvent(6));
         processor.handleEvent(new TemperatureEvent(2));
         processor.handleEvent(new TemperatureEvent(12));
         processor.handleEvent(new EndOfDayEvent(7));
         processor.handleEvent(new TemperatureEvent(16));
         processor.handleEvent(new TemperatureEvent(23));
         processor.handleEvent(new TemperatureEvent(11));
         processor.handleEvent(new EndOfDayEvent(8));
     }
}
