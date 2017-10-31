package com.fluxtion.learning.example14.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example10.Handlers.StairHandler;
import com.fluxtion.learning.example10.Handlers.StepHandler;
import com.fluxtion.learning.example14.ActivityMonitor;
import com.fluxtion.learning.example10.Events.AccelEvent;
import com.fluxtion.learning.example14.ActionEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class ActivityProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final StairHandler stairHandler_3 = new StairHandler();
  private final StepHandler stepHandler_1 = new StepHandler();
  private final ActivityMonitor activityMonitor_5 = new ActivityMonitor();
  //Dirty flags

  //Filter constants

  public ActivityProcessor() {
    activityMonitor_5.stepHandler = stepHandler_1;
    activityMonitor_5.stairHandler = stairHandler_3;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example10.Events$AccelEvent"):
        {
          AccelEvent typedEvent = (AccelEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.example14.ActionEvent"):
        {
          ActionEvent typedEvent = (ActionEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(AccelEvent typedEvent) {
    //Default, no filter methods
    stairHandler_3.onAccel(typedEvent);
    stepHandler_1.onAccel(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(ActionEvent typedEvent) {
    FilteredHandlerInvoker invoker = dispatchStringMapActionEvent.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  //int filter maps
  //String filter maps
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapActionEvent =
      initdispatchStringMapActionEvent();

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapActionEvent() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "showActivity",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ActionEvent_showActivity((com.fluxtion.learning.example14.ActionEvent) event);
          }
        });
    dispatchMap.put(
        "showTime",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ActionEvent_showTime((com.fluxtion.learning.example14.ActionEvent) event);
          }
        });
    dispatchMap.put(
        "tick",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ActionEvent_tick((com.fluxtion.learning.example14.ActionEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_ActionEvent_showActivity(
      com.fluxtion.learning.example14.ActionEvent typedEvent) {
    //method body - invoke call tree
    activityMonitor_5.showActivityRequest(typedEvent);
  }

  private void handle_ActionEvent_showTime(com.fluxtion.learning.example14.ActionEvent typedEvent) {
    //method body - invoke call tree
    activityMonitor_5.showTimeRequest(typedEvent);
  }

  private void handle_ActionEvent_tick(com.fluxtion.learning.example14.ActionEvent typedEvent) {
    //method body - invoke call tree
    activityMonitor_5.timeTick(typedEvent);
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {
    activityMonitor_5.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
