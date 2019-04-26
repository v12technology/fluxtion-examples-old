/*
 * Copyright (C) 2019 V12 Technology Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Server Side License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program.  If not, see 
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */
package com.fluxtion.examples.tradingmonitor;

import com.fluxtion.api.partition.Partitioner;
import com.fluxtion.examples.tradingmonitor.fluxCsvAssetPrice.Csv2AssetPrice;
import com.fluxtion.examples.tradingmonitor.fluxCsvDeal.Csv2Deal;
import com.fluxtion.examples.tradingmonitor.symbol.SymbolTradeMonitor;
import com.fluxtion.ext.text.api.event.EofEvent;
import com.fluxtion.ext.text.api.util.CharStreamer;
import com.fluxtion.ext.text.api.util.marshaller.DispatchingCsvMarshaller;
import java.io.File;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author V12 Technology Ltd.
 */
public class MonitorTest {
    
    @Test
    public void testAllAssetMonitor() throws IOException {

        AssetPartitioner strat = new AssetPartitioner();
        Partitioner<SymbolTradeMonitor> partitioner = new Partitioner<>(SymbolTradeMonitor::new, strat::initMonitor);
        partitioner.keyPartitioner(strat::keyGen);
        
        CharStreamer.stream(new File("src/test/resources/test-1.csv"), new DispatchingCsvMarshaller()
                .addMarshaller(AssetPrice.class, new Csv2AssetPrice())
                .addMarshaller(Deal.class, new Csv2Deal())
                .addSink(partitioner)
        ).noInit().sync().stream();
        
        strat.getPortfolio().onEvent(EofEvent.EOF);
        strat.getPortfolio().tearDown();
    }


}
