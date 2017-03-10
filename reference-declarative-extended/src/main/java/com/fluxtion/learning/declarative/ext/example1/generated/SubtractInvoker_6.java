/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.numeric.NumericValuePush;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;

/**
 * generated NumericFunction wrapper.
 * Wraps a numeric function for invocation.
 * target class  : com.fluxtion.extension.declarative.funclib.api.math.BinaryFunctions.Subtract
 * target method : subtract
 * 
 * @author Greg Higgins
 */
public class SubtractInvoker_6 extends Number implements NumericValue{

    //source operand inputs
    public com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_3 source_CumSumInvoker_3_5;
    public com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_1 source_CumSumInvoker_1_4;
    private com.fluxtion.extension.declarative.funclib.api.math.BinaryFunctions.Subtract f = new  com.fluxtion.extension.declarative.funclib.api.math.BinaryFunctions.Subtract();
    private double result;
    private boolean updated;



    @OnParentUpdate("source_CumSumInvoker_3_5")
    public void sourceChange_source_CumSumInvoker_3_5(com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_3 updated){
        calculate();
    }
    @OnParentUpdate("source_CumSumInvoker_1_4")
    public void sourceChange_source_CumSumInvoker_1_4(com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_1 updated){
        calculate();
    }

    public void calculate(){
        double oldValue = result;
        result = f.subtract(source_CumSumInvoker_1_4.doubleValue(), source_CumSumInvoker_3_5.doubleValue());
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

