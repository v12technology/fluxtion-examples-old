package com.fluxtion.learning.example22.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example21.HistogramBucket;
import com.fluxtion.learning.example21.Histogram;
import com.fluxtion.learning.example22.TradeDistributionAnalyser;
import com.fluxtion.learning.example21.IntValueEvent;

public class HistogramProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final HistogramBucket bucket_0 = new HistogramBucket();
  private final HistogramBucket bucket_1 = new HistogramBucket();
  private final HistogramBucket bucket_2 = new HistogramBucket();
  private final HistogramBucket bucket_3 = new HistogramBucket();
  private final HistogramBucket bucket_4 = new HistogramBucket();
  private final HistogramBucket bucket_5 = new HistogramBucket();
  private final HistogramBucket bucket_6 = new HistogramBucket();
  private final HistogramBucket bucket_7 = new HistogramBucket();
  private final HistogramBucket bucket_8 = new HistogramBucket();
  private final HistogramBucket bucket_9 = new HistogramBucket();
  private final HistogramBucket bucket_10 = new HistogramBucket();
  private final HistogramBucket bucket_11 = new HistogramBucket();
  private final HistogramBucket bucket_12 = new HistogramBucket();
  private final Histogram histogram_0 = new Histogram();
  private final Histogram histogram_1 = new Histogram();
  public final TradeDistributionAnalyser tradeAnalyser = new TradeDistributionAnalyser();
  //Dirty flags

  //Filter constants

  public HistogramProcessor() {
    //bucket_0
    bucket_0.filter = "orders";
    bucket_0.min = (int) 16;
    bucket_0.max = (int) 26;
    //bucket_1
    bucket_1.filter = "orders";
    bucket_1.min = (int) 26;
    bucket_1.max = (int) 36;
    //bucket_2
    bucket_2.filter = "orders";
    bucket_2.min = (int) 36;
    bucket_2.max = (int) 47;
    //bucket_3
    bucket_3.filter = "orders";
    bucket_3.min = (int) 47;
    bucket_3.max = (int) 57;
    //bucket_4
    bucket_4.filter = "orders";
    bucket_4.min = (int) 57;
    bucket_4.max = (int) 68;
    //bucket_5
    bucket_5.filter = "orders";
    bucket_5.min = (int) 68;
    bucket_5.max = (int) 78;
    //bucket_6
    bucket_6.filter = "orders";
    bucket_6.min = (int) 78;
    bucket_6.max = (int) 88;
    //bucket_7
    bucket_7.filter = "orders";
    bucket_7.min = (int) 88;
    bucket_7.max = (int) 99;
    //bucket_8
    bucket_8.filter = "orders";
    bucket_8.min = (int) 99;
    bucket_8.max = (int) 109;
    //bucket_9
    bucket_9.filter = "orders";
    bucket_9.min = (int) 109;
    bucket_9.max = (int) 120;
    //bucket_10
    bucket_10.filter = "trades";
    bucket_10.min = (int) 30;
    bucket_10.max = (int) 43;
    //bucket_11
    bucket_11.filter = "trades";
    bucket_11.min = (int) 43;
    bucket_11.max = (int) 56;
    //bucket_12
    bucket_12.filter = "trades";
    bucket_12.min = (int) 56;
    bucket_12.max = (int) 70;
    //histogram_0
    histogram_0.filter = "orders";
    histogram_0.buckets = new HistogramBucket[10];
    histogram_0.buckets[0] = bucket_0;
    histogram_0.buckets[1] = bucket_1;
    histogram_0.buckets[2] = bucket_2;
    histogram_0.buckets[3] = bucket_3;
    histogram_0.buckets[4] = bucket_4;
    histogram_0.buckets[5] = bucket_5;
    histogram_0.buckets[6] = bucket_6;
    histogram_0.buckets[7] = bucket_7;
    histogram_0.buckets[8] = bucket_8;
    histogram_0.buckets[9] = bucket_9;
    histogram_0.min = (int) 16;
    histogram_0.max = (int) 120;
    //histogram_1
    histogram_1.filter = "trades";
    histogram_1.buckets = new HistogramBucket[3];
    histogram_1.buckets[0] = bucket_10;
    histogram_1.buckets[1] = bucket_11;
    histogram_1.buckets[2] = bucket_12;
    histogram_1.min = (int) 30;
    histogram_1.max = (int) 70;
    //tradeAnalyser
    tradeAnalyser.tradeDistribution = histogram_1;
    tradeAnalyser.orderDistribution = histogram_0;
    tradeAnalyser.orderDistributionMinBucket = "16";
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example21.IntValueEvent"):
        {
          IntValueEvent typedEvent = (IntValueEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(IntValueEvent typedEvent) {
    switch (typedEvent.filterString()) {
      case ("orders"):
        bucket_0.processValue(typedEvent);
        bucket_1.processValue(typedEvent);
        bucket_2.processValue(typedEvent);
        bucket_3.processValue(typedEvent);
        bucket_4.processValue(typedEvent);
        bucket_5.processValue(typedEvent);
        bucket_6.processValue(typedEvent);
        bucket_7.processValue(typedEvent);
        bucket_8.processValue(typedEvent);
        bucket_9.processValue(typedEvent);
        histogram_0.processValue(typedEvent);
        afterEvent();
        return;
      case ("trades"):
        bucket_10.processValue(typedEvent);
        bucket_11.processValue(typedEvent);
        bucket_12.processValue(typedEvent);
        histogram_1.processValue(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {
    bucket_0.init();
    bucket_1.init();
    bucket_2.init();
    bucket_3.init();
    bucket_4.init();
    bucket_5.init();
    bucket_6.init();
    bucket_7.init();
    bucket_8.init();
    bucket_9.init();
    bucket_10.init();
    bucket_11.init();
    bucket_12.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
