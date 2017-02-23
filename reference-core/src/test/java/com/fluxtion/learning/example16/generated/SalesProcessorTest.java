/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.example16.generated;

import com.fluxtion.learning.example16.SaleEvent;
import org.junit.Test;

/**
 *
 * @author greg
 */
public class SalesProcessorTest {

    @Test
    public void processSales(){
        SalesProcessorSEP salesProcessor = new SalesProcessorSEP();
        salesProcessor.init();
        salesProcessor.onEvent(new SaleEvent("gordon gecko"));
        salesProcessor.onEvent(new SaleEvent("darth vader"));
        salesProcessor.onEvent(new SaleEvent("bill murray"));
        salesProcessor.onEvent(new SaleEvent("jennifer aniston"));
        salesProcessor.onEvent(new SaleEvent("bill murray"));
        salesProcessor.onEvent(new SaleEvent("bill murray"));
        salesProcessor.onEvent(new SaleEvent("jennifer aniston"));
        salesProcessor.onEvent(new SaleEvent("mike tyson"));
        salesProcessor.tearDown();
    }
}
