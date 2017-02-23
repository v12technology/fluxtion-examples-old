/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example12.generated;

import com.fluxtion.learning.example12.Events;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class ActionProcessorTest {

    @Test
    public void testNodeIdentificationInArray() {
        ActionProcessor processor = new ActionProcessor();
        processor.onEvent(new Events.ShowTimeAction());
        processor.onEvent(new Events.ShowActivityAction());
        processor.onEvent(new Events.Tick());
    }
}
