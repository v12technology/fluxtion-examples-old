package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.numeric.NumericValuePush;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;
import com.fluxtion.learning.declarative.ext.example1.generated.FxTradeHandlerStringFilter;
import com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.CumSum;

/**
 * generated NumericFunction wrapper.
 * Wraps a numeric function for invocation.
 * target class  : CumSum
 * target method : incSum
 * 
 * @author Greg Higgins
 */
public class CumSumInvoker_1 implements NumericValue{

    //source operand inputs
    public FxTradeHandlerStringFilter[] sourceUpdated_FxTradeHandlerStringFilter_0 = new FxTradeHandlerStringFilter[4];
    private final CumSum f = new CumSum();
    private double result;
    private double newValue;
    private boolean updated;

    @OnParentUpdate("sourceUpdated_FxTradeHandlerStringFilter_0")
    public void sourceUpdated_FxTradeHandlerStringFilter_0(FxTradeHandlerStringFilter updated){
        newValue = updated.event().dealt();
        calculate();
    }

    public void calculate(){
        double oldValue = result;
        result = f.incSum(result, newValue);
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
        f.reset();
        updated = false;
        result = 0;
    }

    @Override
    public short shortValue() {
        return (short)result;
    }

    @Override
    public byte byteValue() {
        return (byte)result;
    }

    @Override
    public float floatValue() {
        return (float)result;
    }

    @Override
    public int intValue() {
        return (int)result;
    }

    @Override
    public long longValue() {
        return (long)result;
    }

    @Override
    public double doubleValue() {
        return (double)result;
    }
    
}

