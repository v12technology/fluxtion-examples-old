/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example25;

import com.fluxtion.api.annotations.OnEvent;

/**
 *
 * @author greg
 */
public class AvgTempLogger {
    
    public AvgDayTemp averageCalc;
    //for testing
    public int updateCount;

    public AvgTempLogger(AvgDayTemp averageCalc) {
        this.averageCalc = averageCalc;
    }

    public AvgTempLogger() {
    }
    
    @OnEvent
    public void averageUpdated(){
        updateCount++;
        System.out.println("Avg temp updated:" + averageCalc.getAverage());
    }
}
