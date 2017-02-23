/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example2;

import com.fluxtion.api.annotations.OnEvent;

/**
 *
 * @author greg
 */
public class AvgTemp {
    private int count;
    private int sum;
    public TemperatureHandler tempHandler;
    
    @OnEvent
    public void calculateAverageTemp(){
        count++;
        sum += tempHandler.getCurrentTempReading();
        double avg = sum/count;
        System.out.println("Average temp:" + avg + ", count:" + count + ", sum:" + sum);
    }
}
