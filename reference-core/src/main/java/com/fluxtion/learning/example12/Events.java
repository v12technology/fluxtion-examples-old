package com.fluxtion.learning.example12;

import com.fluxtion.learning.example11.*;
import com.fluxtion.runtime.event.Event;

/**
 *
 * @author greg
 */
public class Events {
    
    public static class ShowTimeAction extends Event{}
    
    public static class ShowActivityAction extends Event{}
    
    public static class Tick extends Event{}
    
}
