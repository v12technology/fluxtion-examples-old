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
package com.fluxtion.learning.example16;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;
import com.fluxtion.api.annotations.TearDown;

/**
 * Example demonstrating event filtering with a variable value.
 * @author greg higgins
 */
public class SalesProcessor {

    private int count;
    
    @FilterId
    public String salesPerson;

    SalesProcessor(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public SalesProcessor() {
    }

    @EventHandler
    public void handleSale(SaleEvent saleEvent){
        count++;
    }

    @TearDown
    public void complete(){
        System.out.printf("total sales for:%s [%d]\n", salesPerson, count);
    }

}
