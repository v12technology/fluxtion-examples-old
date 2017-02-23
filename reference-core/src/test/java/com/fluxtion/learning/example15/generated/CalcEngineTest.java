/* 
 * Copyright (C) 2016 Greg Higgins (greg.higgins@v12technology.com)
 *
 * This file is part of Fluxtion.
 *
 * Fluxtion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example15.generated;


import com.fluxtion.learning.example15.CharEvent;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Greg Higgins
 */
public class CalcEngineTest {

    private Calculator calc;
    private CharEvent charEvent;

    public CalcEngineTest() {
    }

    @Before
    public void beforeTestCase() {
        calc = new Calculator();
        calc.init();
        charEvent = new CharEvent('c');
    }

    @After
    public void afterTestCase() {
        calc.tearDown();
    }

    @Test
    public void testEvaluate() {
        assertAns("22 + 23 =", 45, 0.1);
        assertAns("2.56 + 2.12 =", 4.68, 0.001);
        assertAns("2.56 + 2.12 c 6/3=", 2, 0.001);
        assertAns("11.5*2=", 23, 0.001);
        assertAns("11.5-2=", 9.5, 0.001);
    }

    private void assertAns(String evalString, double expectedAns, double tolerance){
        double ans = evaluate(evalString);
        assertEquals(expectedAns, ans, tolerance);
    }
    
    private double evaluate(String calcString) {
        calcString.chars().forEach(x -> {
            charEvent.setCharacter((char) x);
            calc.onEvent(charEvent);
        });
        return calc.fpu.getAns();
    }

}
