/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example3;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class EndOfDayHandler {
    
    private int dayNum;
    
    @EventHandler
    public void endOfDay(EndOfDayEvent eod){
        dayNum = eod.getDayNumber();
    }

    public int getDayNum() {
        return dayNum;
    }
    
}
