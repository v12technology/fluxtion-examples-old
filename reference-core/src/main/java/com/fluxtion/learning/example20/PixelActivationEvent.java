/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example20;

import com.fluxtion.runtime.event.Event;

/**
 * Marks an element in a matrix as being activated.
 * @author greg
 */
public class PixelActivationEvent extends Event{
    public int x;
    public int y;
}
