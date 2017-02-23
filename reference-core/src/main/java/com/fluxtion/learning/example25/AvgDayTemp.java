/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example25;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.TemperatureEvent;

/**
 * A temperature averaging node, that will only notify of change to avg at end
 * of day. Processes TemperatureEvent's but propogate = false prevenrts the 
 * event wave passing to children when a TemperatureEvent is received.
 * 
 * @author greg
 */
public class AvgDayTemp {
    
    private int count;
    private int sum;
    private int average;

    @EventHandler
    public void endOfDay(EndOfDayEvent eod){
        //replace old avgerage and reset
        average = sum/count;
        sum = 0;
        count = 0;
    }
    
    @EventHandler(propogate = false)
    public void processTemp(TemperatureEvent temperatureEvent){
        count++;
        sum += temperatureEvent.getTemperature();
    }

    public int getCount() {
        return count;
    }

    public int getSum() {
        return sum;
    }

    public int getAverage() {
        return average;
    }
    
    
}
