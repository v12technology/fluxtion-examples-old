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
package com.fluxtion.learning.example15;

import com.fluxtion.api.annotations.EventHandler;

/**
 *
 * @author Greg Higgins
 */
public class CalcInput {

    private double input;
    private int pointPos, pointIncrement;

    /**
     * Handle digit input 0-9
     * @param event 
     */
    @EventHandler
    public void anyChar(CharEvent event) {
        final char character = event.getCharacter();
        if (Character.isDigit(character)) {
            input = input * 10 + (character - '0');
            pointPos += pointIncrement;
        }
    }

    /**
     * Decimal point handling
     * @param event 
     */
    @EventHandler(filterId = '.')
    public void onDecimalPoint(CharEvent event) {
        pointIncrement = 1;
    }

    /**
     * Clear the state of the input back to zero
     * @param event 
     */
    @EventHandler(filterId = 'c')
    public void onClear(CharEvent event) {
        clear();
    }

    public double getInput() {
        return input / Math.pow(10, pointPos);
    }
    
    public void clear(){
        input = 0;
        pointPos = 0;
        pointIncrement = 0;
    }

}
