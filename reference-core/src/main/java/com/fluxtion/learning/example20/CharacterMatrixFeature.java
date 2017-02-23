/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
