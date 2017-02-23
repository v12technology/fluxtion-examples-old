/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example27;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.TemperatureEvent;

/**
 * All members are final and assigned in non-default constructor, demonstrates 
 * the ability of Fluxtion to a generate a SEP that can use non-standard api's
 * to deal with member encapsulating classes.
 * 
 * @author greg higgins
 */
public class HighTemperatureTest {
    
    private final int highLimit;
    private transient int temperature;

    public HighTemperatureTest(int highLimit) {
        this.highLimit = highLimit;
    }
    
    @EventHandler
    public boolean processTemp(TemperatureEvent tempEvent){
        temperature = tempEvent.getTemperature();
        return tempEvent.getTemperature() > highLimit;
    }

    public int getTemperature() {
        return temperature;
    }
}
