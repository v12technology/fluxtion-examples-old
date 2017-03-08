/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.functional.example1;

import com.fluxtion.api.node.SEPConfig;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.Log;
import com.fluxtion.learning.functional.TemperatureEvent;

/**
 * Log to console the temperature reading on receipt of a temperature event.
 * 
 * The user declares the desired behaviour and functional plugins create an
 * implementation to meet the requirements.
 * 
 * The static helper methods Log and select generate helper classes, 
 * create instances, set references and register instances with Fluxtion.
 * 
 * @author greg
 */
public class TempHandlerBuilder extends SEPConfig {{
        Log("-> received temp: {}degC", TemperatureEvent.class, TemperatureEvent::getTemperature);
}}
