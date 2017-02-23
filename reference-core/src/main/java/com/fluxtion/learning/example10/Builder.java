package com.fluxtion.learning.example10;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.example10.Handlers.ShowActivityHandler;
import com.fluxtion.learning.example10.Handlers.ShowTimeHandler;
import com.fluxtion.learning.example10.Handlers.StairHandler;
import com.fluxtion.learning.example10.Handlers.StepHandler;

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
