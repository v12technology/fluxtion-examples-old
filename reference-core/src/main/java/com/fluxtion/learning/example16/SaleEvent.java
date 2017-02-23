/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example16;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class SaleEvent extends Event {

    public SaleEvent(String salesPerson) {
        super(NO_ID, salesPerson);
    }

    public String getSalesPerson() {
        return filterString;
    }
    
}
