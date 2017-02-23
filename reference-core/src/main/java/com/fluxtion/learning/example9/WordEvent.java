/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example9;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class WordEvent extends Event{
    
    private final String word;

    public WordEvent(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
    
}
