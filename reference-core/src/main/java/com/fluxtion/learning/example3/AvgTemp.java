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
package com.fluxtion.learning.example3;

import com.fluxtion.learning.example2.*;
import com.fluxtion.api.annotations.OnEvent;

/**
 *
 * @author greg
 */
public class AvgTemp {

    private int count;
    private int sum;
    private int dayCount;
    public TemperatureHandler tempHandler;
    public EndOfDayHandler dayHandler;
    private double avg;
    private int readingCount;

    public AvgTemp(com.fluxtion.learning.example3.TemperatureHandler tempHandler, EndOfDayHandler dayHandler) {
        this.tempHandler = tempHandler;
        this.dayHandler = dayHandler;
    }

    public AvgTemp() {
    }

    @OnEvent
    public void calculateAverageTemp() {
        int newDayCount = dayHandler.getDayNum();
        if (newDayCount != dayCount) {
            System.out.println("calculating avg - end of day");
            if (count == 0) {
                avg = Double.NaN;
            } else {
                avg = sum / count;
            }
            readingCount = count;
            count = 0;
            sum = 0;
        } else {
            count++;
            sum += tempHandler.getCurrentTempReading();
        }
        dayCount = newDayCount;
    }

    public double getAvg() {
        return avg;
    }

    public int getReadingCount() {
        return readingCount;
    }
}
