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
 * target class  : com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.Avg
 * target method : avg
 * 
 * @author Greg Higgins
 */
public class AvgInvoker_3 extends Number implements NumericValue{

    //source operand inputs
    public com.fluxtion.example.tempmonitor.generated.TempEventHandler source_TempEventHandler_2;
    private com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.Avg f = new  com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.Avg();
    private double result;
    private boolean updated;
    public Object resetNotifier;



    @OnParentUpdate("source_TempEventHandler_2")
    public void sourceChange_source_TempEventHandler_2(com.fluxtion.example.tempmonitor.generated.TempEventHandler updated){
        calculate();
    }

    public void calculate(){
        double oldValue = result;
        result = f.avg(result, (double)((com.fluxtion.example.tempmonitor.TempHandler.TempEvent)source_TempEventHandler_2.event()).temp());
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
        double oldValue = result;
        init();
        updated = oldValue != result;
    }


    @Initialise
    public void init(){
        f.reset();
        updated = false;
        result = 0;
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

