/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
