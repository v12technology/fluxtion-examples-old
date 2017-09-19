package com.fluxtion.learning.example23.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example18.AssetEventHandler;
import com.fluxtion.learning.example18.BreachNotifier;
import com.fluxtion.learning.example18.AssetEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class AssetMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AssetEventHandler assetHandlerFX = new AssetEventHandler();
  private final AssetEventHandler assetHandlerEquities = new AssetEventHandler();
  private final AssetEventHandler assetHandlerCommodities = new AssetEventHandler();
  public final BreachNotifier notifier = new BreachNotifier();
  //Dirty flags
  private boolean isDirty_assetHandlerCommodities = false;
  private boolean isDirty_assetHandlerEquities = false;
  private boolean isDirty_assetHandlerFX = false;
  //Filter constants

  public AssetMonitor() {
    assetHandlerCommodities.portfolioName = "Commodities";
    assetHandlerEquities.portfolioName = "Equities";
    assetHandlerFX.portfolioName = "FX";
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
    FilteredHandlerInvoker invoker = dispatchStringMapAssetEvent.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  //int filter maps
  //String filter maps
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapAssetEvent =
      initdispatchStringMapAssetEvent();

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapAssetEvent() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "Commodities",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_AssetEvent_Commodities((com.fluxtion.learning.example18.AssetEvent) event);
          }
        });
    dispatchMap.put(
        "Equities",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_AssetEvent_Equities((com.fluxtion.learning.example18.AssetEvent) event);
          }
        });
    dispatchMap.put(
        "FX",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_AssetEvent_FX((com.fluxtion.learning.example18.AssetEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_AssetEvent_Commodities(
      com.fluxtion.learning.example18.AssetEvent typedEvent) {
    //method body - invoke call tree
    isDirty_assetHandlerCommodities = assetHandlerCommodities.handleValuation(typedEvent);
    if (isDirty_assetHandlerCommodities) {
      notifier.assetBreached(assetHandlerCommodities);
    }
    if (isDirty_assetHandlerCommodities | isDirty_assetHandlerEquities | isDirty_assetHandlerFX) {
      notifier.onEvent();
    }
  }

  private void handle_AssetEvent_Equities(com.fluxtion.learning.example18.AssetEvent typedEvent) {
    //method body - invoke call tree
    isDirty_assetHandlerEquities = assetHandlerEquities.handleValuation(typedEvent);
    if (isDirty_assetHandlerEquities) {
      notifier.assetBreached(assetHandlerEquities);
    }
    if (isDirty_assetHandlerCommodities | isDirty_assetHandlerEquities | isDirty_assetHandlerFX) {
      notifier.onEvent();
    }
  }

  private void handle_AssetEvent_FX(com.fluxtion.learning.example18.AssetEvent typedEvent) {
    //method body - invoke call tree
    isDirty_assetHandlerFX = assetHandlerFX.handleValuation(typedEvent);
    if (isDirty_assetHandlerFX) {
      notifier.assetBreached(assetHandlerFX);
    }
    if (isDirty_assetHandlerCommodities | isDirty_assetHandlerEquities | isDirty_assetHandlerFX) {
      notifier.onEvent();
    }
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
