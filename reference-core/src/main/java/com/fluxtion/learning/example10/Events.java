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
package com.fluxtion.learning.example10;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class Events {
    
    public static class AccelEvent extends Event{
        public int x,y,z;
        public void settAccel(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static class ShowTimeAction extends Event{}
    
    public static class ShowActivityAction extends Event{}
    
    public static class Tick extends Event{}
    
}
