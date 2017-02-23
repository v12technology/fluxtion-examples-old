/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example4;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.learning.TemperatureHandler;

/**
 *
 * @author greg
 */
public class AvgTemp {
    private int count;
    private int sum;
    public TemperatureHandler tempHandler;
    private int avg;
    
    @OnEvent
    public void calculateAverageTemp(){
        count++;
        sum += tempHandler.getCurrentTempReading();
        avg = sum/count;
    }

    public int getCount() {
        return count;
    }

    public int getAvg() {
        return avg;
    }
    
}
