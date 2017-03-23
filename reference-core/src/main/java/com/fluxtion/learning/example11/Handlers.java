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
package com.fluxtion.learning.example11;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.learning.example11.Events.AccelEvent;
import com.fluxtion.learning.example11.Events.ShowActivityAction;
import com.fluxtion.learning.example11.Events.ShowTimeAction;

/**
 *
 * @author greg
 */
public class Handlers {
    
    public static class StepHandler{
        
        public transient int stepCount;
        
        @EventHandler
        public void onAccel(AccelEvent accel){
            if(accel.z==0)
                stepCount++;
        }
    }
    
    public static class StairHandler{
        
        public transient int stairCount;
        
        @EventHandler
        public void onAccel(AccelEvent accel){
            if(accel.z!=0)
                stairCount++;
        }
    }
    
    public static interface ActionHandler{}
    
    public static class ShowTimeHandler implements ActionHandler{
        @EventHandler
        public void showTimeRequest(ShowTimeAction event){}
    }
    
    public static class ShowActivityHandler implements ActionHandler{
        @EventHandler
        public void showActivityRequest(ShowActivityAction event){}
    }
    
}
