/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example3;

import com.fluxtion.learning.example2.*;
import com.fluxtion.api.annotations.OnEvent;

/**
 *
 * @author greg
 */
public class AvgTemp {

    private int count;
    private int sum;
    private int dayCount;
    public TemperatureHandler tempHandler;
    public EndOfDayHandler dayHandler;
    private double avg;
    private int readingCount;

    public AvgTemp(com.fluxtion.learning.example3.TemperatureHandler tempHandler, EndOfDayHandler dayHandler) {
        this.tempHandler = tempHandler;
        this.dayHandler = dayHandler;
    }

    public AvgTemp() {
    }

    @OnEvent
    public void calculateAverageTemp() {
        int newDayCount = dayHandler.getDayNum();
        if (newDayCount != dayCount) {
            System.out.println("calculating avg - end of day");
            if (count == 0) {
                avg = Double.NaN;
            } else {
                avg = sum / count;
            }
            readingCount = count;
            count = 0;
            sum = 0;
        } else {
            count++;
            sum += tempHandler.getCurrentTempReading();
        }
        dayCount = newDayCount;
    }

    public double getAvg() {
        return avg;
    }

    public int getReadingCount() {
        return readingCount;
    }
}
