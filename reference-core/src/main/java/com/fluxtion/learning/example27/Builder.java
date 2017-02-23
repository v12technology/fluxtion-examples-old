/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example27;

import com.fluxtion.api.node.SEPConfig;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig{{
        addPublicNode(new TemperatureAlertLogger(
                addNode(new HighTemperatureTest(35))
        ), "alertLogger");
}}
