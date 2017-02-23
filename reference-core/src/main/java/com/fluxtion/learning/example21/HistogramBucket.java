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
package com.fluxtion.learning.example21;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;
import com.fluxtion.api.annotations.Initialise;

/**
 * Generic histogram bucket, filters events based
 * 
 * @author greg
 */
public class HistogramBucket {
    
    @FilterId
    public String filter;
    public int min;
    public int max;
    
    private int _min;
    private int _max;
    private int count;
    
    @EventHandler
    public void processValue(IntValueEvent event){
        int value = event.value;
        if(value > _min & value <= _max){
            count++;
        }
    }

    @Initialise
    public void init(){
        _min = min;
        _max = max;
    }
    
    public int getCount() {
        return count;
    }

}
