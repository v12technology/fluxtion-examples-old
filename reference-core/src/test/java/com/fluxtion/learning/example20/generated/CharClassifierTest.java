/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example20.generated;

import com.fluxtion.learning.example20.CharClassifierConfigEvent;
import com.fluxtion.learning.example20.CharacterMatrixFeature;
import com.fluxtion.learning.example20.PixelActivationEvent;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class CharClassifierTest {

    @Test
    public void matchChar() {
        ScreenProcessor processor = new ScreenProcessor();
        processor.init();
        //config
        char[] chars = new char[]{'a', 'b', '7', '8'};
        for (char aChar : chars) {
            CharClassifierConfigEvent event = new CharClassifierConfigEvent();
            event.setMatchChar(aChar);
            event.onValues = randArray();
            event.allOffValue = (byte) ((Math.random() * 254) - 127);
            processor.onEvent(event);
        }
        //mock screen updates
        PixelActivationEvent event = new PixelActivationEvent();
        event.x = 2;
        event.y = 2;
        processor.onEvent(event);
        event.x = 1;
        event.y = 1;
        processor.onEvent(event);
        event.x = 3;
        event.y = 5;
        processor.onEvent(event);
        event.x = 4;
        event.y = 1;
        processor.onEvent(event);
        //print result
        processor.batchEnd();
    }

    private byte[] randArray() {
        byte[] array = new byte[CharacterMatrixFeature.COLS * CharacterMatrixFeature.COLS];
        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) ((Math.random() * 254) - 127);
        }
        return array;
    }
}
