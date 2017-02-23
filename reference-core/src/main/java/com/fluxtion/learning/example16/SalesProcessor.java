/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example16;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;
import com.fluxtion.api.annotations.TearDown;

/**
 * Example demonstrating event filtering with a variable value.
 * @author greg higgins
 */
public class SalesProcessor {

    private int count;
    
    @FilterId
    public String salsePerson;

    SalesProcessor(String salsePerson) {
        this.salsePerson = salsePerson;
    }

    public SalesProcessor() {
    }

    @EventHandler
    public void handleSale(SaleEvent saleEvent){
        count++;
    }

    @TearDown
    public void complete(){
        System.out.printf("total slaes for:%s [%d]\n", salsePerson, count);
    }

}
