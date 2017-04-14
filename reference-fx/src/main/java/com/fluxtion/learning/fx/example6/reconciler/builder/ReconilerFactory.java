/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
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
package com.fluxtion.learning.fx.example6.reconciler.builder;

import com.fluxtion.api.node.NodeFactory;
import com.fluxtion.api.node.NodeRegistry;
import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Process a yaml configuration and generate a TradeReconciler SEP.
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconilerFactory extends SEPConfig implements NodeFactory<TradeReconciler>   {

    @Override
    public TradeReconciler createNode(Map config, NodeRegistry registry) {
        nodeList = new ArrayList();
        Map<?, ?> reconcilerMap = (Map) config.get("reconilers");
        for (Map.Entry object : reconcilerMap.entrySet()) {
            String reconcilerId = (String) object.getKey();
            Map value = (Map) object.getValue();
            int timeout = (int) (value).get("timeout");
            List<String> venues = (List) ((Map) value).get("venues");
            String[] venuesAsArray = venues.toArray(new String[venues.size()]);
            ReconcilerBuilder builder = new ReconcilerBuilder(reconcilerId, timeout);
            builder.setMandatorySource(venuesAsArray);
            builder.build(nodeList);
        }
        for (Object object : nodeList) {
            registry.registerNode(object, null);
        }
        return null;
    }
}

