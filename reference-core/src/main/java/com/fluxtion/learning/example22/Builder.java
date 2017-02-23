/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example22;

import com.fluxtion.api.node.SEPConfig;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig{{
        final TradeDistributionAnalyser tradeDistributionAnalyser = new TradeDistributionAnalyser();
        tradeDistributionAnalyser.orderDistributionMinBucket = "16";
        addPublicNode(tradeDistributionAnalyser, "tradeAnalyser");
}}
