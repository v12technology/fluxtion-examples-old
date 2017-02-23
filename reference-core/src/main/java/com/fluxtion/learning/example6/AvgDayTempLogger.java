/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example6;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.learning.TemperatureHandler;

/**
 *
 * @author greg
 */
public class AvgDayTempLogger {
    public ResetEodHandler eodHandler;
    public TemperatureHandler tempHandler;

    public AvgDayTempLogger(ResetEodHandler eodHandler, TemperatureHandler tempHandler) {
        this.eodHandler = eodHandler;
        this.tempHandler = tempHandler;
    }

    public AvgDayTempLogger() {
    }
    
    private int count;
    private int sum;
    
    @OnEvent
    public void updated(){
        if(eodHandler.isEod()){
            System.out.println("EOD avg temp:" + sum/count + " readings:" + count);
            sum = 0;
            count = 0;
        }else{
            count++;
            sum += tempHandler.getCurrentTempReading();
        }
    }
}
