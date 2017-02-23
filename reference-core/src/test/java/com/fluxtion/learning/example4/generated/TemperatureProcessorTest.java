/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example4.generated;

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
         processor.handleEvent(new TemperatureEvent(15));
         processor.handleEvent(new TemperatureEvent(19));
         processor.handleEvent(new TemperatureEvent(23));
         System.out.println("pulling avg temp:" + processor.avgTemp.getAvg());
     }
}
