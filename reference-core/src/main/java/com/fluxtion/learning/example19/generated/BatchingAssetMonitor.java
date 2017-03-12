package com.fluxtion.learning.example19.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example18.AssetEventHandler;
import com.fluxtion.learning.example19.BatchingBreachNotifier;
import com.fluxtion.learning.example18.AssetEvent;

public class BatchingAssetMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AssetEventHandler assetEventHandler_1 = new AssetEventHandler();
  private final AssetEventHandler assetEventHandler_3 = new AssetEventHandler();
  private final AssetEventHandler assetEventHandler_5 = new AssetEventHandler();
  public final BatchingBreachNotifier notifier = new BatchingBreachNotifier();
  //Dirty flags
  private boolean isDirty_assetEventHandler_1 = false;
  private boolean isDirty_assetEventHandler_3 = false;
  private boolean isDirty_assetEventHandler_5 = false;
  //Filter constants

  public BatchingAssetMonitor() {
    //assetEventHandler_1
    assetEventHandler_1.portfolioName = "FX";
    //assetEventHandler_3
    assetEventHandler_3.portfolioName = "Equities";
    //assetEventHandler_5
    assetEventHandler_5.portfolioName = "Commodities";
    //notifier
    notifier.assets = new AssetEventHandler[3];
    notifier.assets[0] = assetEventHandler_1;
    notifier.assets[1] = assetEventHandler_3;
    notifier.assets[2] = assetEventHandler_5;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example18.AssetEvent"):
        {
          AssetEvent typedEvent = (AssetEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(AssetEvent typedEvent) {
    switch (typedEvent.filterString()) {
      case ("Commodities"):
        isDirty_assetEventHandler_5 = assetEventHandler_5.handleValuation(typedEvent);
        if (isDirty_assetEventHandler_5) {
          notifier.assetBreached(assetEventHandler_5);
        }
        if (isDirty_assetEventHandler_3
            || isDirty_assetEventHandler_1
            || isDirty_assetEventHandler_5) {
          notifier.onEvent();
        }
        afterEvent();
        return;
      case ("Equities"):
        isDirty_assetEventHandler_3 = assetEventHandler_3.handleValuation(typedEvent);
        if (isDirty_assetEventHandler_3) {
          notifier.assetBreached(assetEventHandler_3);
        }
        if (isDirty_assetEventHandler_3
            || isDirty_assetEventHandler_1
            || isDirty_assetEventHandler_5) {
          notifier.onEvent();
        }
        afterEvent();
        return;
      case ("FX"):
        isDirty_assetEventHandler_1 = assetEventHandler_1.handleValuation(typedEvent);
        if (isDirty_assetEventHandler_1) {
          notifier.assetBreached(assetEventHandler_1);
        }
        if (isDirty_assetEventHandler_3
            || isDirty_assetEventHandler_1
            || isDirty_assetEventHandler_5) {
          notifier.onEvent();
        }
        afterEvent();
        return;
    }
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_assetEventHandler_1 = false;
    isDirty_assetEventHandler_3 = false;
    isDirty_assetEventHandler_5 = false;
  }

  @Override
  public void init() {
    notifier.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {
    notifier.endOfBatch();
  }
}
