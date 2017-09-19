package com.fluxtion.learning.example21.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example21.HistogramBucket;
import com.fluxtion.learning.example21.Histogram;
import com.fluxtion.learning.example21.TradeDistributionAnalyser;
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
  private final Histogram histogram_0 = new Histogram();
  public final TradeDistributionAnalyser tradeAnalyser = new TradeDistributionAnalyser();
  //Dirty flags

  //Filter constants

  public HistogramProcessor() {
    bucket_0.min = (int) 0;
    bucket_0.max = (int) 10;
    bucket_1.min = (int) 10;
    bucket_1.max = (int) 20;
    bucket_2.min = (int) 20;
    bucket_2.max = (int) 30;
    bucket_3.min = (int) 30;
    bucket_3.max = (int) 40;
    bucket_4.min = (int) 40;
    bucket_4.max = (int) 50;
    bucket_5.min = (int) 50;
    bucket_5.max = (int) 60;
    bucket_6.min = (int) 60;
    bucket_6.max = (int) 70;
    bucket_7.min = (int) 70;
    bucket_7.max = (int) 80;
    bucket_8.min = (int) 80;
    bucket_8.max = (int) 90;
    bucket_9.min = (int) 90;
    bucket_9.max = (int) 100;
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
    histogram_0.min = (int) 0;
    histogram_0.max = (int) 100;
    tradeAnalyser.tradeDistribution = histogram_0;
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
    //Default, no filter methods
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
    //event stack unwind callbacks
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
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
