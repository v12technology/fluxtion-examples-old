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
public class WeekdayValidator {

    public EndOfDayHandler dayHandler;
    private boolean weekDay = false;

    public WeekdayValidator(EndOfDayHandler dauHandler) {
        this.dayHandler = dauHandler;
    }

    public WeekdayValidator() {
    }
    
    @OnEvent
    public void dayChanged(){
        int dayNum = dayHandler.getDayNum();
        weekDay = !(dayNum%6==0 || dayNum%7==0);
    }

    public boolean isWeekDay() {
        return weekDay;
    }
    
}
