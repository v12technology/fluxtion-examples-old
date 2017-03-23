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

import com.fluxtion.extension.statemachine.api.State;
import com.fluxtion.extension.statemachine.api.StateMachineEvent;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.DoorsClosed;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.DoorsOpened;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.ElevatorContext;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.ElevatorStates.DoorsOpen;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.ElevatorStates.DoorsShut;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.RequestDoorsClose;
import com.fluxtion.learning.statemachine.example1.ElevatorStateDefinition.RequestDoorsOpen;
import com.fluxtion.learning.statemachine.example1.generated.ElevatorStateMachine;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author V12 Technology Limited
 */
public class ElevatorTest {
    
    @Test
    public void testElevSm(){
        ElevatorStateMachine elevatorStateMachine = new ElevatorStateMachine();
        elevatorStateMachine.init( new ElevatorContext("HILTON 1"));
        
        StateMachineEvent requestOpenDoors = new RequestDoorsOpen();
        StateMachineEvent requestCloseDoors = new RequestDoorsClose();
        StateMachineEvent doorsClosed = new DoorsClosed();
        StateMachineEvent doorsOpen = new DoorsOpened();

        elevatorStateMachine.onEvent(requestOpenDoors);
        elevatorStateMachine.onEvent(requestOpenDoors);
        elevatorStateMachine.onEvent(requestCloseDoors);
        elevatorStateMachine.onEvent(doorsClosed);

        //
        Class<? extends State> currState = elevatorStateMachine.getCurrentState();
        assertEquals(DoorsShut.class, currState);

        elevatorStateMachine.onEvent(requestOpenDoors);
        elevatorStateMachine.onEvent(doorsOpen);
        //
        currState = elevatorStateMachine.getCurrentState();
        assertEquals(DoorsOpen.class, currState);
    }


}
