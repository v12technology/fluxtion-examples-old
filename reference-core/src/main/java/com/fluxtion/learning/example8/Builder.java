/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example8;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.example5.TemperatureBucket;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig{{
    TemperatureHistogramArray histo = addNode(new TemperatureHistogramArray());
    histo.addBucket(addNode(new TemperatureBucket()));
    histo.addBucket(addNode(new TemperatureBucket()));
    histo.addBucket(addNode(new TemperatureBucket()));
    histo.addBucket(addNode(new TemperatureBucket()));
}}
