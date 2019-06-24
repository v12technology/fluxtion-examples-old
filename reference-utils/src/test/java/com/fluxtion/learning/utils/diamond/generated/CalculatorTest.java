/*
 * Copyright (C) 2018 greg
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
package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.runtime.plugin.auditing.ConsoleAuditor;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class CalculatorTest {

    /**
     * test merging numbers with filter. An audit logger is added dynamically to
     * record the event processing path through the generated static event
     * processor.
     *
     */
    @Test
    public void testDiamond() {
        Calculator calc = new Calculator();
        calc.init();
        //audit logging
        calc.logger.setLogSink(System.out::println);
        calc.onEvent(new AuditorRegistration(true, new ConsoleAuditor()));
        //events
        calc.onEvent(new NumericSignal("test", 10));
        Assert.assertThat(calc.merged.intValue(), is(110));
        calc.onEvent(new NumericSignal("test", 3));
        Assert.assertThat(calc.merged.intValue(), is(3));
    }
}
