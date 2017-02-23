/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example4;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.TemperatureHandler;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig {{
        TemperatureHandler temphandler = addNode(new TemperatureHandler());
        AvgTemp avgTemp = addPublicNode(new AvgTemp(), "avgTemp");
        avgTemp.tempHandler = temphandler;
    }}
