/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example2;

import com.fluxtion.api.node.SEPConfig;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig {{
        TemperatureHandler temphandler = addNode(new TemperatureHandler());
        AvgTemp avgTemp = addNode(new AvgTemp());
        avgTemp.tempHandler = temphandler;
    }}
