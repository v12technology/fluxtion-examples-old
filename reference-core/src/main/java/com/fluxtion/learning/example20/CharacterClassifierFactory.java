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
package com.fluxtion.learning.example20;

import com.fluxtion.api.node.NodeFactory;
import com.fluxtion.api.node.NodeRegistry;
import com.fluxtion.api.node.SEPConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An example demonstrating the use of factories to create an execution graph.
 * 
 * <pre>
 * Root facttory, a CharacterClassifierFactory creates:
 *  a CharacterClassifier - directly
 *  an array of CharacterMatrixFeature for each char - via factory.
 *  an array reference from CharacterClassifier to all created CharacterMatrixFeatures.
 * 
 * The CharacterMatrixFeatureFactory creates:
 *      CharacterMatrixFeature - directly
 *      CharClassifierConfigProcessor - via factory
 *      reference from CharacterMatrixFeature to CharClassifierConfigProcessor
 * 
 * The CharClassifierConfigProcessor creates:
 *      CharClassifierConfigProcessor - driectly
 *      
 * </pre>
 * 
 * @author greg
 */
public class CharacterClassifierFactory extends SEPConfig implements NodeFactory<CharacterClassifier> {

    @Override
    public CharacterClassifier createNode(Map config, NodeRegistry registry) {
        List charList = (List) config.get("chars");
        CharacterMatrixFeature[] features = new CharacterMatrixFeature[charList.size()];
        HashMap map = new HashMap();
        for (int i = 0; i < charList.size(); i++) {
            char searchChar = charList.get(i).toString().charAt(0);
            map.clear();
            map.put("char", searchChar);
            CharacterMatrixFeature feat = registry.findOrCreateNode(CharacterMatrixFeature.class, map,  "charFeature_" + searchChar);
            features[i] = feat;
        }
        return new CharacterClassifier(features);
    }
    
    public static class CharMatrixFeatureFactory implements NodeFactory<CharacterMatrixFeature>{
        
        @Override
        public CharacterMatrixFeature createNode(Map config, NodeRegistry registry) {
            char c = (Character)config.get("char");
            CharClassifierConfigProcessor cfgProcessor = registry.findOrCreateNode(CharClassifierConfigProcessor.class, config, "configProcessor_" + c);
            final CharacterMatrixFeature characterMatrixFeature = new CharacterMatrixFeature(c);
            characterMatrixFeature.config = cfgProcessor;
            return characterMatrixFeature;
        }
        
    }
    
    public static class CharClassifierConfigProcessorFactory implements NodeFactory<CharClassifierConfigProcessor>{

        @Override
        public CharClassifierConfigProcessor createNode(Map config, NodeRegistry registry) {
            char c = (Character)config.get("char");
            return new CharClassifierConfigProcessor(c);
        }
        
    }

}
