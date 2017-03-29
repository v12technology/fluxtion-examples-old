/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.fx.example1;

import com.fluxtion.fx.event.CustomerOrder;
import com.fluxtion.fx.event.CustomerOrderAccept;
import com.fluxtion.fx.event.CustomerOrderReject;
import com.fluxtion.fx.event.FxPrice;
import com.fluxtion.fx.event.TimingPulseEvent;
import com.fluxtion.fx.EventAuditor;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ConsoleAuditor implements EventAuditor {

    @Override
    public void handleEvent(CustomerOrder customerOrder) {
        System.out.println("recvd -> customerOrder");
    }

    @Override
    public void handleEvent(CustomerOrderAccept orderAccept) {
        System.out.println("recvd -> orderAccept");
    }

    @Override
    public void handleEvent(CustomerOrderReject orderReject) {
        System.out.println("recvd -> orderReject");
    }

    @Override
    public void handleEvent(FxPrice fxPrice) {
        System.out.println("recvd -> fxPrice");
    }

    @Override
    public void handleEvent(TimingPulseEvent timingPulse) {
        System.out.println("recvd -> timingPulse");
    }

}
