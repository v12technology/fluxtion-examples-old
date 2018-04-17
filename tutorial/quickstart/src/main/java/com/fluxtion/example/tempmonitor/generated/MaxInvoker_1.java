package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.numeric.NumericValuePush;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;

/**
 * generated NumericFunction wrapper.
 * Wraps a numeric function for invocation.
 * target class  : com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.Max
 * target method : max
 * 
 * @author Greg Higgins
 */
public class MaxInvoker_1 extends Number implements NumericValue{

    //source operand inputs
    public com.fluxtion.example.tempmonitor.generated.TempEventHandler source_TempEventHandler_0;
    private com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.Max f = new  com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.Max();
    private double result;
    private boolean updated;
    public Object resetNotifier;



    @OnParentUpdate("source_TempEventHandler_0")
    public void sourceChange_source_TempEventHandler_0(com.fluxtion.example.tempmonitor.generated.TempEventHandler updated){
        calculate();
    }

    public void calculate(){
        double oldValue = result;
        result = f.max(result, (double)((com.fluxtion.example.tempmonitor.TempHandler.TempEvent)source_TempEventHandler_0.event()).temp());
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

    
    @OnParentUpdate("resetNotifier")
    public void reset(Object resetNotifier){
        //double oldValue = result;
        init();
        updated = false;
        //updated = oldValue != result;
    }


    @Initialise
    public void init(){
        result = f.reset();
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

