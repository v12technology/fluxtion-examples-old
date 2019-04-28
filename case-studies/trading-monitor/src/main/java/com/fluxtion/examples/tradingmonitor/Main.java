/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.examples.tradingmonitor;

import com.fluxtion.api.partition.Partitioner;
import com.fluxtion.examples.tradingmonitor.fluxCsvAssetPrice.Csv2AssetPrice;
import com.fluxtion.examples.tradingmonitor.fluxCsvDeal.Csv2Deal;
import com.fluxtion.examples.tradingmonitor.generated.symbol.SymbolTradeMonitor;
import com.fluxtion.ext.text.api.event.EofEvent;
import com.fluxtion.ext.text.api.util.CharStreamer;
import com.fluxtion.ext.text.api.util.marshaller.DispatchingCsvMarshaller;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Greg Higgins greg.higgins@v12technology.com
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("starting");
        long now = System.nanoTime();
        //partiioning strategy - by asset symbol
        AssetPartitioner strat = new AssetPartitioner();
        Partitioner<SymbolTradeMonitor> partitioner = new Partitioner<>(SymbolTradeMonitor::new, strat::initMonitor);
        partitioner.keyPartitioner(strat::keyGen);
        //read file, register parsers and dispatch
        CharStreamer.stream(new File("src/main/resources/generated-data.csv"), new DispatchingCsvMarshaller()
//        CharStreamer.stream(new File("src/test/resources/test-1.csv"), new DispatchingCsvMarshaller()
                .addMarshaller(AssetPrice.class, new Csv2AssetPrice())
                .addMarshaller(Deal.class, new Csv2Deal())
                .addSink(partitioner)
        ).noInit().sync().stream();
        //teardown logic
        strat.getPortfolio().onEvent(EofEvent.EOF);
        strat.getPortfolio().tearDown();
        System.out.println("millis:" + ((System.nanoTime() - now)/1_000_000));
    }
}
