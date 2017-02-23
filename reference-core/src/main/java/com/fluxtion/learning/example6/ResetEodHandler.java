/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example6;

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.EndOfDayEvent;

/**
 *
 * @author greg
 */
public class ResetEodHandler {
    private boolean eod;
    
    @EventHandler
    public void handleEod(EndOfDayEvent eodEvent){
        eod = true;
    }
    
    @AfterEvent
    public void resetEodFlag(){
        eod = false;
    }
    
    public boolean isEod() {
        return eod;
    }
    
}
