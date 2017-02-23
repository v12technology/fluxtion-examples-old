/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example23;

import com.fluxtion.api.generation.NodeNameProducer;
import com.fluxtion.learning.example18.AssetEventHandler;

/**
 *
 * @author greg
 */
public class AssetsNodeNamer implements NodeNameProducer {

    @Override
    public String mappedNodeName(Object nodeToMap) {
        String name = null;
        if(nodeToMap instanceof AssetEventHandler){
            AssetEventHandler handler = (AssetEventHandler)nodeToMap;
            name = "assetHandler" + handler.portfolioName;
        }
        return name;
    }
    
}
