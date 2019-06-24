package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.runtime.plugin.events.NumericSignal;

/**
 * Generated EventHandler for NumericSignal
 * @author Greg Higgins
 */
public class NumericSignalHandler implements EventWrapper<NumericSignal>{

    private NumericSignal event;

    @EventHandler
    public boolean handleNumericSignal(NumericSignal event){
        this.event = event;
        return true;
    }

    @Override
    public NumericSignal event() {
        return event;
    }

    @Override
    public Class<NumericSignal> eventClass() {
        return NumericSignal.class;
    }

}
