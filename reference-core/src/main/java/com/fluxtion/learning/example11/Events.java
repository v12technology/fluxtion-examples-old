package com.fluxtion.learning.example11;

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
