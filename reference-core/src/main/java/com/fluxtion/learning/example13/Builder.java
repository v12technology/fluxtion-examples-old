package com.fluxtion.learning.example13;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.example10.Handlers.StairHandler;
import com.fluxtion.learning.example10.Handlers.StepHandler;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig{{

        addNode(new ActivityMonitor(
                addNode(new StepHandler()), 
                addNode(new StairHandler())
                )
        );
        
}}
