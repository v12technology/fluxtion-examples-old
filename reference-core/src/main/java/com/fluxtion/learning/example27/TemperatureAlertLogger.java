/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example27;

import com.fluxtion.api.annotations.OnEvent;

/**
 * All members are final and assigned in non-default constructor, demonstrates 
 * the ability of Fluxtion to a generate a SEP that can use non-standard api's
 * to deal with member encapsulating classes.
 * 
 * @author greg
 */
public class TemperatureAlertLogger {
    private final HighTemperatureTest tempTest;
    private transient int alertCount = 0;
    
    public TemperatureAlertLogger(HighTemperatureTest tempTest) {
        this.tempTest = tempTest;
    }
    
    @OnEvent
    public void tempAlert(){
        alertCount++;
        System.out.println("High temp alert:" + tempTest.getTemperature());
    }

    public int getAlertCount() {
        return alertCount;
    }
}
