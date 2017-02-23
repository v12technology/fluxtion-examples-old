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
package com.fluxtion.learning;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class EndOfDayEvent extends Event{
    
    private int dayNumber;

    public EndOfDayEvent(int dayNumber) {
        this.dayNumber = dayNumber;
    }
    

    /**
     * Get the value of dayNumber
     *
     * @return the value of dayNumber
     */
    public int getDayNumber() {
        return dayNumber;
    }

    /**
     * Set the value of dayNumber
     *
     * @param dayNumber new value of dayNumber
     */
    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

}
