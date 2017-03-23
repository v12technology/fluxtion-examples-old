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
package com.fluxtion.learning.example9;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.TearDown;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author greg
 */
public class NewsAnalyser {

    //public properties srialised to the SEP 
    public String[] positieImpactMatch;
    public String[] negativeImpactMatch;
    public String subject;
    public int[] weights;
    public int barrier;

    //transient fields are not serialised to the SEP
    public transient int positiveWeight;
    public transient int negativeWeight;
    
    private Set<String> positiveSet;
    private Set<String> negativeSet;
    private int semanticRating;

    @EventHandler
    public void processWord(WordEvent wordEvent) {
        if (positiveSet.contains(wordEvent.getWord())) {
            semanticRating += positiveWeight;
        } else if (negativeSet.contains(wordEvent.getWord())) {
            semanticRating -= negativeWeight;
        }
    }

    @Initialise
    public void initMatchSets() {
        //any serialised properties will be assigned before initialise method
        positiveSet = Collections.EMPTY_SET;
        negativeSet = Collections.EMPTY_SET;
        positiveWeight = weights[0];
        negativeWeight = weights[1];
        if (positieImpactMatch != null) {
            positiveSet = new HashSet<>(Arrays.asList(positieImpactMatch));
        }
        if (negativeImpactMatch != null) {
            negativeSet = new HashSet<>(Arrays.asList(negativeImpactMatch));
        }
        semanticRating = 0;
    }

    @TearDown
    public void outputSemanticRating() {
        System.out.println("Semantic score:" + semanticRating);
        if(semanticRating > barrier){
            System.out.println("matches subject:'" + subject + "'");
        }else{
            System.out.println("no subject match:'" + subject + "'");
        }
    }

}
