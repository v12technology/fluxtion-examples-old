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
package com.fluxtion.learning.example6;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.learning.TemperatureHandler;

/**
 *
 * @author greg
 */
public class AvgDayTempLogger {
    public ResetEodHandler eodHandler;
    public TemperatureHandler tempHandler;

    public AvgDayTempLogger(ResetEodHandler eodHandler, TemperatureHandler tempHandler) {
        this.eodHandler = eodHandler;
        this.tempHandler = tempHandler;
    }

    public AvgDayTempLogger() {
    }
    
    private int count;
    private int sum;
    
    @OnEvent
    public void updated(){
        if(eodHandler.isEod()){
            System.out.println("EOD avg temp:" + sum/count + " readings:" + count);
            sum = 0;
            count = 0;
        }else{
            count++;
            sum += tempHandler.getCurrentTempReading();
        }
    }
}
