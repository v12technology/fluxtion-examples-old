/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example14;

import com.fluxtion.runtime.event.Event;

/**
 * An event with a filtering ID of type String.
 * 
 * @author greg
 */
public class ActionEvent extends Event {
    
    public ActionEvent(String actionName){
        super(NO_ID, actionName);
    }

    public int getActionName() {
        return filterId;
    }
    
}
