/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example3;

import com.fluxtion.api.annotations.OnEvent;

/**
 *
 * @author greg
 */
public class DayAvgTempLogger {

    public AvgTemp avgTemp;
    public WeekdayValidator weekdayTest;
    public EndOfDayHandler dayHandler;
    private int dayCount = -1;

    public DayAvgTempLogger(AvgTemp avgTemp, WeekdayValidator weekdayTest, EndOfDayHandler dayHandler) {
        this.avgTemp = avgTemp;
        this.weekdayTest = weekdayTest;
        this.dayHandler = dayHandler;
    }

    public DayAvgTempLogger() {
    }

    @OnEvent
    public void logEodAvgTemp() {
        int newDayCount = dayHandler.getDayNum();
        if (newDayCount != dayCount && weekdayTest.isWeekDay()) {
            System.out.println("End of day:" + newDayCount + ", avg daily temp:" + avgTemp.getAvg() + ", reading count:" + avgTemp.getReadingCount());
        }else if(newDayCount != dayCount){
            System.out.println("Weekend - ignore");
        }
        dayCount = newDayCount;
    }
}
