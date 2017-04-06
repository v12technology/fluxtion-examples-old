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
package com.fluxtion.learning.declarative.ext.example5;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.generation.GenerationContext;
import com.fluxtion.extension.declarative.api.Test;

/**
 *
 * @author greg
 */
public class CountingTest implements Test {

    public Object tracked;
    private int count;
    public int notifyCountBarrier;
    private int _notifyCountBarrier;

    public static Test notifyEveryN(Object tracked, int limit) {
        CountingTest count = new CountingTest();
        count.tracked = tracked;
        count.notifyCountBarrier = limit;
        GenerationContext.SINGLETON.getNodeList().add(count);
        return count;
    }

    @OnEvent
    public boolean increment() {
        count++;
        if (count >= _notifyCountBarrier) {
            count = 0;
            return true;
        }
        return false;
    }

    @Initialise
    public void init() {
        count = 0;
        _notifyCountBarrier = notifyCountBarrier;
    }

}
