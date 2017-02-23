package com.fluxtion.learning.example11;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.example11.Handlers.ShowActivityHandler;
import com.fluxtion.learning.example11.Handlers.ShowTimeHandler;
import com.fluxtion.learning.example11.Handlers.StairHandler;
import com.fluxtion.learning.example11.Handlers.StepHandler;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig{{

        addNode(new ActivityMonitor(
                addNode(new StepHandler()), 
                addNode(new StairHandler()), 
                addNode(new ShowTimeHandler()), 
                addNode(new ShowActivityHandler()
                ))
        );
        
}}
