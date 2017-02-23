/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example12;

import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.learning.example12.Handlers.ActionHandler;

/**
 *
 * @author greg
 */
public class ActionArrayMonitor {
    public ActionHandler[] handlers;

    public ActionArrayMonitor(ActionHandler[] handlers) {
        this.handlers = handlers;
    }

    public ActionArrayMonitor() {
    }
    
    @OnParentUpdate
    public void handlerUpdated(ActionHandler handler){
        System.out.println("handler type:" + handler.getClass().getSimpleName());
    }
}
