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

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.numeric.BufferValue;
import com.fluxtion.extension.declarative.funclib.builder.ascii.AsciiHelper;
import static com.fluxtion.extension.declarative.funclib.builder.csv.CsvMarshallerBuilder.csvMarshaller;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class MarshallerConfig extends SEPConfig {

    public MarshallerConfig() {

        
        CsvMultiTypeMarshaller multiType = addNode(new CsvMultiTypeMarshaller());
        multiType.type = AsciiHelper.readBytesCsv(0);
        //add marshalled types
        Wrapper<FxPrice> fxPrice = csvMarshaller(FxPrice.class, 0)
                .mapString(1, FxPrice::setPair)
                .map(2, FxPrice::setBid)
                .map(2, FxPrice::setOffer).build();
        multiType.addMarshaller(fxPrice);
        
        Wrapper<CustomerOrder> customerOrder = csvMarshaller(CustomerOrder.class, 0)
                .map(1, CustomerOrder::setOrderId).build();//
        multiType.addMarshaller(customerOrder);
    }
    
    public static class FxPriceMarshaller extends SEPConfig{
        Wrapper<FxPrice> fxPrice = csvMarshaller(FxPrice.class, 0)
                .mapString(1, FxPrice::setPair)
                .map(2, FxPrice::setBid)
                .map(2, FxPrice::setOffer).build();

        {
            addPublicNode(fxPrice, "instance");
        }
        
    }
}
