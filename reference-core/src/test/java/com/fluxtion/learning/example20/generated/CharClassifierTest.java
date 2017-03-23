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
