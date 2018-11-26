package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.numeric.NumericValuePush;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;
import com.fluxtion.extension.declarative.funclib.api.math.BinaryFunctions.Multiply;
/**
 * generated NumericFunction wrapper.
 * Wraps a numeric function for invocation.
 * target class  : Multiply
 * target method : multiply
 * 
 * @author Greg Higgins
 */
public class MultiplyInvoker_3 extends Number implements NumericValue{

    //source operand inputs
    public GreaterThanDecorator_1 source_GreaterThanDecorator_1_2;
    private Multiply f = new  Multiply();
    private double result;
    private boolean updated;



    @OnParentUpdate("source_GreaterThanDecorator_1_2")
    public void sourceChange_source_GreaterThanDecorator_1_2(GreaterThanDecorator_1 updated){
        calculate();
    }

    public void calculate(){
        double oldValue = result;
        result = f.multiply((double)10, ((com.fluxtion.runtime.plugin.events.NumericSignal)source_GreaterThanDecorator_1_2.event()).value());
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

