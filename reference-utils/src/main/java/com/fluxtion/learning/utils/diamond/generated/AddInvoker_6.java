package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.numeric.NumericValuePush;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;
import com.fluxtion.learning.utils.diamond.DefaultNumeric;
import com.fluxtion.extension.declarative.funclib.api.math.BinaryFunctions.Add;
/**
 * generated NumericFunction wrapper.
 * Wraps a numeric function for invocation.
 * target class  : Add
 * target method : add
 * 
 * @author Greg Higgins
 */
public class AddInvoker_6 extends Number implements NumericValue{

    //source operand inputs
    public DefaultNumeric source_DefaultNumeric_5;
    public NumericSignalHandler source_NumericSignalHandler_4;
    private Add f = new  Add();
    private double result;
    private boolean updated;



    @OnParentUpdate("source_DefaultNumeric_5")
    public void sourceChange_source_DefaultNumeric_5(DefaultNumeric updated){
        calculate();
    }
    @OnParentUpdate("source_NumericSignalHandler_4")
    public void sourceChange_source_NumericSignalHandler_4(NumericSignalHandler updated){
        calculate();
    }

    public void calculate(){
        double oldValue = result;
        result = f.add(((com.fluxtion.runtime.plugin.events.NumericSignal)source_NumericSignalHandler_4.event()).value(), source_DefaultNumeric_5.doubleValue());
        updated = oldValue != result;
    }

    @OnEvent
    public boolean onEvent(){
        return updated;
    }

    @OnEventComplete
    public void afterCalculate(){
        updated = false;
    }

    


    @Initialise
    public void init(){
        result = 0;
        updated = false;
    }

    @Override
    public short shortValue() {
        return (short) result;
    }

    @Override
    public byte byteValue() {
        return (byte) result;
    }

    @Override
    public float floatValue() {
        return (float) result;
    }

    @Override
    public int intValue() {
        return (int) result;
    }

    @Override
    public long longValue() {
        return (long) result;
    }

    @Override
    public double doubleValue() {
        return (double) result;
    }
    
}

