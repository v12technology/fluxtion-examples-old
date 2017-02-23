/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example20;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;

/**
 *
 * @author greg
 */
public class CharClassifierConfigProcessor {

    @FilterId
    private transient int matchingChar;
    
    public CharClassifierConfigEvent configEvent;

    public CharClassifierConfigProcessor(char matchingChar) {
        this.matchingChar = matchingChar;
    }

    public CharClassifierConfigProcessor() {
    }
    
    @EventHandler
    public void configureValues(CharClassifierConfigEvent event) {
        this.configEvent = event;
    }
}
