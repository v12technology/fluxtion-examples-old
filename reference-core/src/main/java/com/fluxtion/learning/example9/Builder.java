/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example9;

import com.fluxtion.api.node.SEPConfig;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig{{
    NewsAnalyser newsAnalyser = addNode(new NewsAnalyser());
    newsAnalyser.positieImpactMatch = new String[]{"IT", "ram", "CEP"};
    newsAnalyser.negativeImpactMatch = new String[]{"picasso", "escapoligist"};
    newsAnalyser.negativeWeight = -2;
    newsAnalyser.positiveWeight = 4;
    newsAnalyser.weights = new int[]{33,68};
    newsAnalyser.barrier = 400;
    newsAnalyser.subject = "computing";
}}
