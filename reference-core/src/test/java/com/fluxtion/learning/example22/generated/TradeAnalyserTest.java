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
