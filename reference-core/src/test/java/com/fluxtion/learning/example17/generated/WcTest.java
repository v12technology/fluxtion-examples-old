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
package com.fluxtion.learning.example17.generated;

import com.fluxtion.learning.example17.CharEvent;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class WcTest {
    
    String testString = "Fluxtion is a revolutionary code robot that analyses your problem and generates\n" +
"a solution in a fraction of the time of hand written code. Fluxtion’s unique algorithms\n" +
"create optimised code that can process hundreds of millions of events per second on a\n" +
"single core. Fluxtion will have a dramatic effect on your business reducing delivery\n" +
"times, cutting resource consumption costs while increasing value by providing quicker\n" +
"esponses to complex fast moving data. Real-time analytics, wearable\n";
    
    String testString_2 = "Fluxtion is a revolutionary code robot that analyses your problem and generates\n";
    
    @Test
    public void countString(){
        CharEvent charEvent = new CharEvent(' ');
        WcSep wc = new WcSep();
        wc.init();
        for(char c : testString.toCharArray()){
            charEvent.setCharacter(c);
            wc.onEvent(charEvent);
        }
        System.out.println(wc.result);
        Assert.assertEquals(493, wc.result.charCount);
        Assert.assertEquals(75, wc.result.wordCount);
        Assert.assertEquals(6, wc.result.lineCount);
    }    
    
}
