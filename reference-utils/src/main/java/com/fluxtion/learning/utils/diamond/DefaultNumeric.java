/*
 * Copyright (C) 2018 greg
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
package com.fluxtion.learning.utils.diamond;

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.generation.GenerationContext;
import com.fluxtion.extension.declarative.api.numeric.MutableNumericValue;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;

/**
 *
 * @author greg
 */
public class DefaultNumeric extends MutableNumericValue{
    private final double defaultValue;
    private final NumericValue parentValue;

    public static DefaultNumeric defaultNumber(NumericValue d){
        DefaultNumeric def = new DefaultNumeric(d);
        GenerationContext.SINGLETON.getNodeList().add(def);
        return def;
    }
    
    public DefaultNumeric(NumericValue parent) {
        this(0, parent);
    }

    public DefaultNumeric(double value, NumericValue parent) {
        this.defaultValue = value;
        this.parentValue = parent;
        setDoubleValue(defaultValue);
    }
    
    @OnEvent
    public boolean update(){
        setDoubleValue(parentValue.doubleValue());
        return true;
    }
    
    @AfterEvent
    public void afterEvent(){
        setDoubleValue(defaultValue);
    }
}
