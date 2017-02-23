/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example16;

import com.fluxtion.api.node.SEPConfig;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig{{
        addNode(new SalesProcessor("bill murray"));
        addNode(new SalesProcessor("jennifer aniston"));
        addNode(new SalesProcessor("daniel craig"));
}}
