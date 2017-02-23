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
public class TemperatureEvent extends Event{
    
    private int temperature;

    public TemperatureEvent(int temperature) {
        this.temperature = temperature;
    }

    public TemperatureEvent() {
    }
    

    /**
     * Get the value of temperature
     *
     * @return the value of temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Set the value of temperature
     *
     * @param temperature new value of temperature
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
