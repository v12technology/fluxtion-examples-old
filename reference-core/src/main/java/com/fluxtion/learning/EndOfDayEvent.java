/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class EndOfDayEvent extends Event{
    
    private int dayNumber;

    public EndOfDayEvent(int dayNumber) {
        this.dayNumber = dayNumber;
    }
    

    /**
     * Get the value of dayNumber
     *
     * @return the value of dayNumber
     */
    public int getDayNumber() {
        return dayNumber;
    }

    /**
     * Set the value of dayNumber
     *
     * @param dayNumber new value of dayNumber
     */
    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

}
