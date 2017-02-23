package com.fluxtion.learning.example1;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.TemperatureEvent;

/**
 *
 * @author greg higgins
 */
public class TemperatureHandler {
    
    @EventHandler
    public void tempChange(TemperatureEvent tempReading){
        System.out.println("temperature:" + tempReading.getTemperature());
    }
    
    public static class Builder extends SEPConfig{{
            addNode(new TemperatureHandler());
    }}
}
