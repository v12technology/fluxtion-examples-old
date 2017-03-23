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
