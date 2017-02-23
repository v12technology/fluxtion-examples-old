package com.fluxtion.learning.example3;

import com.fluxtion.learning.example2.*;
import com.fluxtion.learning.example1.*;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.TemperatureEvent;

/**
 *
 * @author greg higgins
 */
public class TemperatureHandler {
    
    private int currentTempReading;
    
    @EventHandler
    public void tempChange(TemperatureEvent tempReading){
        currentTempReading = tempReading.getTemperature();
    }

    public int getCurrentTempReading() {
        return currentTempReading;
    }
    
}
