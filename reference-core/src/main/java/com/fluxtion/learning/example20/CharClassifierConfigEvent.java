/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example20;

import com.fluxtion.runtime.event.Event;

/**
 * A configuration event for the CharClassifier 
 * 
 * @author greg
 */
public class CharClassifierConfigEvent extends Event{
    public byte[] onValues = new byte[CharacterMatrixFeature.ROWS * CharacterMatrixFeature.COLS];
    public int allOffValue;
    
    public void setMatchChar(char matchChar){
        filterId = matchChar;
    }
    
    public char getMatchChar(){
        return (char) filterId;
    }
}
