/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.fx.example1;

import com.fluxtion.extension.declarative.funclib.api.util.marshaller.DispatchingCsvMarshaller;
import com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer;
import com.fluxtion.extension.declarative.funclib.builder.util.StringDriver;
import com.fluxtion.fx.marshaller.csv.customerorder.CustomerOrderCsvMarshaller;
import com.fluxtion.fx.marshaller.csv.customerorderaccept.CustomerOrderAcceptCsvMarshaller;
import com.fluxtion.fx.marshaller.csv.customerorderreject.CustomerOrderRejectCsvMarshaller;
import com.fluxtion.fx.marshaller.csv.fxprice.FxPriceCsvMarshaller;
import com.fluxtion.fx.marshaller.csv.timingpusle.TimingPulseCsvMarshaller;
import com.fluxtion.fx.replay.CsvAuditReplay;
import com.fluxtion.fx.util.ConsoleAuditor;
import com.fluxtion.runtime.event.Event;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.LongAdder;
import org.junit.Test;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class MarshallerTest {

    @Test
    public void testCsvInput() {
        final DispatchingCsvMarshaller dispatchingCsvMarshaller = new DispatchingCsvMarshaller();
        dispatchingCsvMarshaller.init();
        final FxPriceCsvMarshaller fxPriceCsvMarshaller = new FxPriceCsvMarshaller();
        final CustomerOrderCsvMarshaller orderCsvMarshaller = new CustomerOrderCsvMarshaller();
        //add marshallers
        dispatchingCsvMarshaller.addMarshaller(fxPriceCsvMarshaller.instance, fxPriceCsvMarshaller);
        dispatchingCsvMarshaller.addMarshaller(orderCsvMarshaller.instance, orderCsvMarshaller);
        //add sink
        dispatchingCsvMarshaller.addSink((Event e) -> {
            System.out.println("recvd event -> " + e);
        });
//        dispatchingCsvMarshaller.
        StringDriver.streamChars("FxPrice,EURGBP,1.123,1.126\n"
                + "FxPrice,EURJPY,112.45,112.67\n"
                + "CustomerOrder,EURGBP,32\n",
                dispatchingCsvMarshaller, false);
    }

    @Test
    public void replayAuditLog() throws IOException {
        LongAdder count = new LongAdder();
        final DispatchingCsvMarshaller dispatchingCsvMarshaller = new DispatchingCsvMarshaller();
        dispatchingCsvMarshaller.init();
        final FxPriceCsvMarshaller fxPriceCsvMarshaller = new FxPriceCsvMarshaller();
        final CustomerOrderCsvMarshaller orderCsvMarshaller = new CustomerOrderCsvMarshaller();
        final CustomerOrderRejectCsvMarshaller orderRejectMarshaller = new CustomerOrderRejectCsvMarshaller();
        final CustomerOrderAcceptCsvMarshaller orderAcceptMarshaller = new CustomerOrderAcceptCsvMarshaller();
        final TimingPulseCsvMarshaller timingPulseMarshaller = new TimingPulseCsvMarshaller();
        //add marshallers
        dispatchingCsvMarshaller.addMarshaller(fxPriceCsvMarshaller.instance, fxPriceCsvMarshaller);
        dispatchingCsvMarshaller.addMarshaller(orderCsvMarshaller.instance, orderCsvMarshaller);
        dispatchingCsvMarshaller.addMarshaller(orderRejectMarshaller.instance, orderRejectMarshaller);
        dispatchingCsvMarshaller.addMarshaller(orderAcceptMarshaller.instance, orderAcceptMarshaller);
        dispatchingCsvMarshaller.addMarshaller(timingPulseMarshaller.instance, timingPulseMarshaller);
        //add sink + auditor
        G10Monitor monitor = new G10Monitor();
        ConsoleAuditor auditor = new ConsoleAuditor();
        auditor.printToConsole = true;
        monitor.registerEventAuditor(auditor);
        dispatchingCsvMarshaller.addSink((Event e) -> {
//            System.out.println("recvd event -> " + e);
            count.increment();
//            monitor.onEvent(e);
        });
        long now = System.nanoTime();
//        AsciiCharEventFileStreamer.streamFromFile(new File("target\\generated-sources\\testlog\\fluxtionfx-audit_small.log"), dispatchingCsvMarshaller, false);
        AsciiCharEventFileStreamer.streamFromFile(new File("target\\generated-sources\\testlog\\fluxtionfx-audit.log"), dispatchingCsvMarshaller, false);
//        AsciiCharEventFileStreamer.streamFromFile(new File("src/test/resources/replay/fluxtionfx-audit.log"), dispatchingCsvMarshaller, false);
        now = (long) ((System.nanoTime() - now) * 0.000_001);
        System.out.println("processed count:" + count + " millis:" + now);
        System.out.println(auditor.toString());
//        monitor.

    }

    @Test
    public void auditReplayTest() {
        CsvAuditReplay replay = new CsvAuditReplay();
        G10Monitor monitor = new G10Monitor();
        ConsoleAuditor auditor = new ConsoleAuditor();
        auditor.printToConsole = false;
        monitor.registerEventAuditor(auditor);
        long now = System.nanoTime();
        G10Monitor g10Monitor = replay.replay(monitor, new File("target\\generated-sources\\testlog\\fluxtionfx-audit.log"));
        now = (long) ((System.nanoTime() - now) * 0.000_001);
        System.out.println("processed count" + " millis:" + now);
        System.out.println("auditor:" + auditor);
    }
}
