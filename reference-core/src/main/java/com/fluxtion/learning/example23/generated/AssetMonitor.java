package com.fluxtion.learning.example23.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example18.AssetEventHandler;
import com.fluxtion.learning.example18.BreachNotifier;
import com.fluxtion.learning.example18.AssetEvent;

public class AssetMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AssetEventHandler assetHandlerCommodities = new AssetEventHandler();
  private final AssetEventHandler assetHandlerEquities = new AssetEventHandler();
  private final AssetEventHandler assetHandlerFX = new AssetEventHandler();
  public final BreachNotifier notifier = new BreachNotifier();
  //Dirty flags
  private boolean isDirty_assetHandlerCommodities = false;
  private boolean isDirty_assetHandlerEquities = false;
  private boolean isDirty_assetHandlerFX = false;
  //Filter constants

  public AssetMonitor() {
    //assetHandlerCommodities
    assetHandlerCommodities.portfolioName = "Commodities";
    //assetHandlerEquities
    assetHandlerEquities.portfolioName = "Equities";
    //assetHandlerFX
    assetHandlerFX.portfolioName = "FX";
    //notifier
    notifier.assets = new AssetEventHandler[3];
    notifier.assets[0] = assetHandlerFX;
    notifier.assets[1] = assetHandlerEquities;
    notifier.assets[2] = assetHandlerCommodities;
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
        isDirty_assetHandlerCommodities = assetHandlerCommodities.handleValuation(typedEvent);
        if (isDirty_assetHandlerCommodities) {
          notifier.assetBreached(assetHandlerCommodities);
        }
        if (isDirty_assetHandlerFX
            || isDirty_assetHandlerCommodities
            || isDirty_assetHandlerEquities) {
          notifier.onEvent();
        }
        afterEvent();
        return;
      case ("Equities"):
        isDirty_assetHandlerEquities = assetHandlerEquities.handleValuation(typedEvent);
        if (isDirty_assetHandlerEquities) {
          notifier.assetBreached(assetHandlerEquities);
        }
        if (isDirty_assetHandlerFX
            || isDirty_assetHandlerCommodities
            || isDirty_assetHandlerEquities) {
          notifier.onEvent();
        }
        afterEvent();
        return;
      case ("FX"):
        isDirty_assetHandlerFX = assetHandlerFX.handleValuation(typedEvent);
        if (isDirty_assetHandlerFX) {
          notifier.assetBreached(assetHandlerFX);
        }
        if (isDirty_assetHandlerFX
            || isDirty_assetHandlerCommodities
            || isDirty_assetHandlerEquities) {
          notifier.onEvent();
        }
        afterEvent();
        return;
    }
    afterEvent();
  }

  @Override
  public void afterEvent() {
    notifier.afterEvent();
    isDirty_assetHandlerCommodities = false;
    isDirty_assetHandlerEquities = false;
    isDirty_assetHandlerFX = false;
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
  public void batchEnd() {}
}
