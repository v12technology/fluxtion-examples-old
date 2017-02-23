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

import com.fluxtion.api.annotations.OnEvent;

/**
 *
 * @author greg
 */
public class WeekdayValidator {

    public EndOfDayHandler dayHandler;
    private boolean weekDay = false;

    public WeekdayValidator(EndOfDayHandler dauHandler) {
        this.dayHandler = dauHandler;
    }

    public WeekdayValidator() {
    }
    
    @OnEvent
    public void dayChanged(){
        int dayNum = dayHandler.getDayNum();
        weekDay = !(dayNum%6==0 || dayNum%7==0);
    }

    public boolean isWeekDay() {
        return weekDay;
    }
    
}
