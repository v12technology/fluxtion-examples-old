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
package com.fluxtion.learning.statemachine.example1;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterType;
import com.fluxtion.extension.statemachine.api.AbstractState;
import com.fluxtion.extension.statemachine.api.StateHandler;
import com.fluxtion.extension.statemachine.api.StateMachineEvent;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.ElevatorStates.ErrorWithDoors;
import com.fluxtion.runtime.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author V12 Technology Limited
 */
public class ElevatorStateDefinition {

    public static class DoorsOpened extends StateMachineEvent {
    }

    public static class DoorsClosed extends StateMachineEvent {
    }

    public static class RequestDoorsClose extends StateMachineEvent {
    }

    public static class RequestDoorsOpen extends StateMachineEvent {
    }

    public static class LiftFailed extends StateMachineEvent {
    }

    public static class ElevatorContext {

        public String name;

        public ElevatorContext() {
        }

        public ElevatorContext(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Elevator:{" + name + '}';
        }

    }

    public static abstract class DefaultElevatorStates extends AbstractState<ElevatorContext> {

        protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

        @EventHandler
        public void handleDoorsClosed(DoorsClosed e) {
            logErrorTransiton(e);
        }

        @EventHandler
        public void handleDoorsOpen(DoorsOpened e) {
            logErrorTransiton(e);
        }

        @EventHandler
        public void handleRequestDoorsOpen(RequestDoorsOpen e) {
            //do nothing 
        }

        @EventHandler
        public void handleRequestDoorsClose(RequestDoorsClose e) {
            //do nothing
        }

        @EventHandler(FilterType.unmatched)
        public void handleAnyEvent(StateMachineEvent event) {

        }

        private void logErrorTransiton(Event e) {
            LOGGER.error("unexpected event {} moving to error state", e.getClass().getCanonicalName());
            machineContext.nextState(ErrorWithDoors.class);
        }

    }

    public static class ElevatorStates {

        @StateHandler
        public static class DoorsClosing extends DefaultElevatorStates {

            @Override
            @EventHandler
            public void handleDoorsClosed(DoorsClosed e) {
                LOGGER.info(userContext + "doors shut");
                machineContext.nextState(DoorsShut.class);
            }

        }

        @StateHandler(initialState = true)
        public static class DoorsOpen extends DefaultElevatorStates {

            @Override
            @EventHandler
            public void handleRequestDoorsClose(RequestDoorsClose e) {
                LOGGER.info(userContext + "request doors close");
                machineContext.nextState(DoorsClosing.class);
            }

        }

        @StateHandler
        public static class DoorsOpening extends DefaultElevatorStates {

            @Override
            @EventHandler
            public void handleDoorsOpen(DoorsOpened e) {
                LOGGER.info(userContext + "doors open");
                machineContext.nextState(DoorsOpen.class);
            }

        }

        @StateHandler
        public static class DoorsShut extends DefaultElevatorStates {

            @Override
            @EventHandler
            public void handleRequestDoorsOpen(RequestDoorsOpen e) {
                LOGGER.info(userContext + "request doors open");
                machineContext.nextState(DoorsOpening.class);
            }

        }

        @StateHandler
        public static class ErrorWithDoors extends DefaultElevatorStates {

        }

    }

}
