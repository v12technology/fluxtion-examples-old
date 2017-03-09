/* 
 *  Copyright (C) 2016-2017 V12 Technology Limited
 *  
 *  This software is subject to the terms and conditions of its EULA, defined in the
 *  file "LICENCE.txt" and distributed with this software. All information contained
 *  herein is, and remains the property of V12 Technology Limited and its licensors, 
 *  if any. This source code may be protected by patents and patents pending and is 
 *  also protected by trade secret and copyright law. Dissemination or reproduction 
 *  of this material is strictly forbidden unless prior written permission is 
 *  obtained from V12 Technology Limited.  
 */
package com.fluxtion.learning.declarative.ext.helpers;

import com.fluxtion.runtime.event.Event;

/**
 * A simplified definition of an FX trade.
 * 
 * @author Greg Higgins
 */
public class FxTrade extends Event{

    public static final int ID = 1;
    private double contra;
    private double dealt;
    
    public FxTrade() {
        super(ID);
    }
    
    public FxTrade buy(String ccyPair, double dealt, double contra){
        this.filterString = ccyPair;
        this.dealt = dealt;
        this.contra = contra;
        return this;
    }
    
    public FxTrade sell(String ccyPair, double dealt, double contra){
        return buy(ccyPair, -dealt, -contra);
    }
    
    public double dealt() {
        return dealt;
    }

    public double contra() {
        return contra;
    }
    
    public String ccyPair() {
        return filterString;
    }
}
