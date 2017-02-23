/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example21;

import com.fluxtion.runtime.event.Event;

/**
 * Simple event for sending int values with an optional filter.
 * 
 * @author greg
 */
public class IntValueEvent extends Event{
    public int value;

    public IntValueEvent(int value) {
        this(value, null);
    }

    public IntValueEvent(int value, String filter) {
        this.value = value;
        this.filterString = filter;
    }
    
    
    
    public void setFilterString(String filter){
        this.filterString = filter;
    }
}
