/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
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
package com.fluxtion.learning.fx.example1;

import com.fluxtion.api.annotations.Config;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.Inject;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.numeric.BufferValue;
import com.fluxtion.extension.declarative.funclib.api.filter.AnyCharMatchFilter;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class CsvMultiTypeMarshaller {

    //read the first column
    public BufferValue type;

    public Wrapper[] csvMarshallers;
    private Map<String, Wrapper> type2Wrapper;
    private boolean eol;

    @Inject
    @Config(key = AnyCharMatchFilter.KEY_FILTER_ARRAY, value = "\n")
    public AnyCharMatchFilter eolNotifier;

    @OnParentUpdate("eolNotifier")
    public boolean onEol(AnyCharMatchFilter terminatorNotifier) {
        eol = true;
        return false;
    }

    @OnEvent
    public boolean onEvent() {
        if (eol) {
            Wrapper instance = type2Wrapper.get(type.asString());
            System.out.println("unmarshalled:" + instance.eventClass() + " ->" + instance.event().toString());
            eol = false;
            return true;
        }
        return false;
    }

    public void addMarshaller(Wrapper marshaller) {
        if (csvMarshallers == null) {
            csvMarshallers = new Wrapper[0];
        }
        Wrapper[] tmpArr = new Wrapper[csvMarshallers.length + 1];
        for (int i = 0; i < csvMarshallers.length; i++) {
            Wrapper csvMarshaller = csvMarshallers[i];
            tmpArr[i] = csvMarshaller;
        }
        tmpArr[tmpArr.length - 1] = marshaller;
        csvMarshallers = tmpArr;
    }

    @Initialise
    public void init() {
        type2Wrapper = new HashMap<>();
        for (Wrapper csvMarshaller : csvMarshallers) {
            type2Wrapper.put(csvMarshaller.eventClass().getSimpleName(), csvMarshaller);
        }
    }
}
