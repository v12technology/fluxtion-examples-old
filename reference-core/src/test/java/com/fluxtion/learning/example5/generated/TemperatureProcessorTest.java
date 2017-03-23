/* 
 * Copyright (C) 2017 V12 Technology Limited
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
package com.fluxtion.learning.example5.generated;

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
