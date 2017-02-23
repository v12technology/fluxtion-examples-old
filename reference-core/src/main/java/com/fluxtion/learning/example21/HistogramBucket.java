/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example21;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;
import com.fluxtion.api.annotations.Initialise;

/**
 * Generic histogram bucket, filters events based
 * 
 * @author greg
 */
public class HistogramBucket {
    
    @FilterId
    public String filter;
    public int min;
    public int max;
    
    private int _min;
    private int _max;
    private int count;
    
    @EventHandler
    public void processValue(IntValueEvent event){
        int value = event.value;
        if(value > _min & value <= _max){
            count++;
        }
    }

    @Initialise
    public void init(){
        _min = min;
        _max = max;
    }
    
    public int getCount() {
        return count;
    }

}
