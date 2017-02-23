/* 
 * Copyright (C) 2016 Greg Higgins (greg.higgins@v12technology.com)
 *
 * This file is part of Fluxtion.
 *
 * Fluxtion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example15;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import java.util.function.BiFunction;

/**
 *
 * @author Greg Higgins
 */
public class CalcEngine {

    public CalcInput input;
    private double register1;
    private double register2;
    private BiFunction<Double, Double, Double> function;
    private Double ans;

    @EventHandler(filterId = '=')
    public void onCalculate(CharEvent event) {
        loadRegister2();
        ans = function.apply(register1, register2);
    }
    
    @EventHandler(filterId = 'r')
    public void onReset(CharEvent event) {
        register1 = register2 = 0;
        ans = Double.valueOf(0);
    }
    
    @EventHandler(filterId = '+')
    public void onFunctionAdd(CharEvent event) {
        loadRegister1();
        function = (r1, r2) -> r1+r2;
    }
    
    @EventHandler(filterId = '-')
    public void onFunctionMinus(CharEvent event) {
        loadRegister1();
        function = (r1, r2) -> r1-r2;
    }
    
    @EventHandler(filterId = '/')
    public void onFunctionDivide(CharEvent event) {
        loadRegister1();
        function = (r1, r2) -> r1/r2;
    }
    
    @EventHandler(filterId = '*')
    public void onFunctionMultiply(CharEvent event) {
        loadRegister1();
        function = (r1, r2) -> r1*r2;
    }
    
    @Initialise
    public void init(){
        ans = Double.valueOf(0);
    }
    
    private void loadRegister1(){
        register1 = input.getInput();
        input.clear();
    }
    
    private void loadRegister2(){
        register2 = input.getInput();
        input.clear();
    }

    public Double getAns() {
        return ans;
    }
    
}
