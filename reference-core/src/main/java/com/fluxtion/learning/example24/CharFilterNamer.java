/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example24;

import com.fluxtion.api.generation.FilterDescription;
import com.fluxtion.api.generation.FilterDescriptionProducer;
import com.fluxtion.learning.example20.CharClassifierConfigEvent;
import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class CharFilterNamer implements FilterDescriptionProducer {

    @Override
    public FilterDescription getFilterDescription(Class<? extends Event> event, int filterId) {
        FilterDescription filterName = FilterDescriptionProducer.super.getFilterDescription(event, filterId);
        if(event==CharClassifierConfigEvent.class){
            filterName.variableName = "char_" + (char)filterId;
            filterName.comment = " matching char = '" + (char)filterId + "'";
        }
        return  filterName;
    }
    
}
