/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example12;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.example11.ActivityMonitor;
import com.fluxtion.learning.example12.Handlers.ActionHandler;
import com.fluxtion.learning.example12.Handlers.ShowActivityHandler;
import com.fluxtion.learning.example12.Handlers.ShowTickHandler;
import com.fluxtion.learning.example12.Handlers.ShowTimeHandler;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig {

    {
        ActionHandler[] handlers = new ActionHandler[]{
        addNode(new ShowTickHandler()),
        addNode(new ShowTimeHandler()),
        addNode(new ShowActivityHandler()),
        };
        
        addNode(new ActionArrayMonitor(handlers));
        
    }
}
