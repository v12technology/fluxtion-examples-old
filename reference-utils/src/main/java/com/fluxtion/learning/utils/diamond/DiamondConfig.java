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

import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;
import static com.fluxtion.extension.declarative.builder.event.EventSelect.select;
import com.fluxtion.extension.declarative.builder.log.LogBuilder;
import static com.fluxtion.extension.declarative.funclib.builder.math.AddFunctions.add;
import static com.fluxtion.extension.declarative.funclib.builder.math.MultiplyFunctions.multiply;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanFilter;
import static com.fluxtion.learning.utils.diamond.DefaultNumeric.defaultNumber;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.sep.AuditedSep;

/**
 * Processing a diamond style calculation. There are two branches and a merge,
 * that adds the output of the branches. One of the branches is filtered, the
 * merge will only add the filtered branch if it is valid. If the filter is
 * invalid then a default value (0) will be merged with the input number.
 *
 * A log is added to print to console processing stages at filtered branch
 * result and the merged result.
 *
 * @author greg
 */
public class DiamondConfig extends AuditedSep {

    @Override
    public void buildConfig() {
        try {
            //input signal event handler
            EventWrapper<NumericSignal> signal = select(NumericSignal.class);
            //filtered branch
            Wrapper<NumericSignal> greaterThan5 = greaterThanFilter(signal, NumericSignal::value, 5.0);
            NumericValue answer = multiply(10, greaterThan5, NumericSignal::value);
            DefaultNumeric defaultNumeric = defaultNumber(answer);
            //merge filtered branch and input signal value
            NumericValue merge = addPublicNode(add(signal, NumericSignal::value, defaultNumeric), "merged");
            //logging
            LogBuilder.Log("multiply={}", defaultNumeric, NumericValue::doubleValue);
            LogBuilder.Log("merge={}", merge, NumericValue::doubleValue);
        } catch (Exception ex) {
        }
    }

}
