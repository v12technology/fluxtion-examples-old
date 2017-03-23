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
package com.fluxtion.learning.example20;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnBatchEnd;
import com.fluxtion.api.annotations.OnParentUpdate;
import java.util.Arrays;

/**
 * Calculates an absolute value based upon the the elements of a matrix that are
 * set to true. Simple model for mapping a touch screen interaction to a value
 * for this character.
 *
 * @author greg
 */
public class CharacterMatrixFeature {

    public CharClassifierConfigProcessor config;
    public char matchingChar;

    private int sum;
    private byte[] matrixWeighting;
    private int defaultValue;
    private boolean configured;
    public static final byte ROWS = 6;
    public static final byte COLS = 6;

    public CharacterMatrixFeature(char matchingChar) {
        this.matchingChar = matchingChar;
    }

    public CharacterMatrixFeature() {
    }

    @EventHandler
    public void handlePixelActivated(PixelActivationEvent event) {
        int id = event.x + event.y * COLS;
        if (configured) {
            sum += matrixWeighting[id];
        }
    }

    @OnParentUpdate
    public void configUpdate(CharClassifierConfigProcessor config) {
        CharClassifierConfigEvent event = config.configEvent;
        matrixWeighting = Arrays.copyOf(event.onValues, ROWS * COLS);
        defaultValue = event.allOffValue;
        configured = true;
    }

    public boolean isConfigured() {
        return configured;
    }

    public int getSum() {
        return sum;
    }

    @OnBatchEnd
    public void endOfBatch() {
        sum = defaultValue;
    }

    @Override
    public String toString() {
        return "{" + "sum=" + sum + ", char='" + matchingChar + "'}";
    }
}
