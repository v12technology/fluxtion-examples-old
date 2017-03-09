package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.numeric.NumericValuePush;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;
import com.fluxtion.learning.declarative.ext.example1.generated.DataEventHandlerStringFilter;
import com.fluxtion.extension.declarative.funclib.api.math.UnaryFunctions.CumSum;

/**
 * generated NumericFunction wrapper.
 * Wraps a numeric function for invocation.
 * target class  : CumSum
 * target method : incSum
 * 
 * @author Greg Higgins
 */
public class CumSumInvoker_3 implements NumericValue{

    //source operand inputs
    public DataEventHandlerStringFilter[] sourceUpdated_DataEventHandlerStringFilter_2 = new DataEventHandlerStringFilter[4];
    private final CumSum f = new CumSum();
    private double result;
    private double newValue;
    private boolean updated;

    @OnParentUpdate("sourceUpdated_DataEventHandlerStringFilter_2")
    public void sourceUpdated_DataEventHandlerStringFilter_2(DataEventHandlerStringFilter updated){
        newValue = updated.event().getValue();
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
