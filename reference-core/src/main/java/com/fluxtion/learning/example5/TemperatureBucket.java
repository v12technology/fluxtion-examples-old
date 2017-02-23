/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example5;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.TearDown;
import com.fluxtion.learning.TemperatureEvent;

/**
 *
 * @author greg
 */
public class TemperatureBucket {

    private int minTemperature;
    private int maxTemperature;
    private int count;
    private boolean rangeSet;

    @EventHandler
    public void handleTemp(TemperatureEvent tempRreading) {
        int temp = tempRreading.getTemperature();
        if (rangeSet && temp > minTemperature && temp <= maxTemperature) {
            count++;
        }
    }

    @Initialise
    public void init() {
        count = 0;
        rangeSet = false;
    }

    @TearDown
    public void dispalyBucketResult() {
        if (rangeSet) {
            System.out.printf("range %3d -> %3d count:%3d\n", minTemperature, maxTemperature, count);
        }
    }

    public void setRange(int min, int max) {
        minTemperature = min;
        maxTemperature = max;
        rangeSet = true;
    }
}
