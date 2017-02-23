/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
