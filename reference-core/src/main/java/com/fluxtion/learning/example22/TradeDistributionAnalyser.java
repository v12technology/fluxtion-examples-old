/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example22;

import com.fluxtion.api.annotations.Config;
import com.fluxtion.api.annotations.ConfigVariable;
import com.fluxtion.learning.example21.*;
import com.fluxtion.api.annotations.Inject;

/**
 *
 * @author greg
 */
public class TradeDistributionAnalyser {
    
    @Inject
    @Config(key = "min", value = "30")
    @Config(key = "max", value = "70")
    @Config(key = "buckets", value = "3")
    @Config(key = "filter", value = "trades")
    public Histogram tradeDistribution;    
    
    @Inject
//    @Config(key = "min", value = "10")
    @Config(key = "max", value = "120")
    @Config(key = "buckets", value = "10")
    @Config(key = "filter", value = "orders")
    public Histogram orderDistribution;    
    
    @ConfigVariable(field = "orderDistribution", key = "min")
    public String orderDistributionMinBucket;
    
}
