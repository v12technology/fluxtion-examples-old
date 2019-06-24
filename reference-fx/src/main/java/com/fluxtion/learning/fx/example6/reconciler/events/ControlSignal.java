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
package com.fluxtion.learning.fx.example6.reconciler.events;

import com.fluxtion.runtime.event.Event;

/**
 * ControlSignal is an event that provides a generic method for nodes to receive
 * control signals without having to define bespoke control events for each type
 * of signal.
 *
 * The ControlSignal has a filter string, which allows the receiver to filter
 * which ControlSignals it should be informed of. A node marks a method with a
 * filtered EventHandler annotation to receive a control message:
 *
 * <pre>
 *
 * EventHandler(filterString = "filterString", propogate = false)
 * public void controlMethod(ControlSignal publishSignal){
 *
 * }
 * </pre>
 * 
 * Using the propogate=false will prevent a control signal from starting an
 * event chain for any dependent nodes.
 *
 * The ControlSignal also provides an optional enable flag the
 * receiver can inspect.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ControlSignal extends Event {

    private final boolean enabled;

    public ControlSignal(String signalName, boolean enabled) {
        super(NO_ID, signalName);
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "ControlSignal{"
                + "control.filter=" + filterString
                + "enabled=" + enabled
                + '}';
    }

}
