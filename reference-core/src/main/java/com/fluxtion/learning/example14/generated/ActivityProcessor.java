package com.fluxtion.learning.example14.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example10.Handlers.StairHandler;
import com.fluxtion.learning.example10.Handlers.StepHandler;
import com.fluxtion.learning.example14.ActivityMonitor;
import com.fluxtion.learning.example10.Events.AccelEvent;
import com.fluxtion.learning.example14.ActionEvent;

public class ActivityProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final StairHandler stairHandler_3 = new StairHandler();
  private final StepHandler stepHandler_1 = new StepHandler();
  private final ActivityMonitor activityMonitor_5 = new ActivityMonitor();
  //Dirty flags

  //Filter constants

  public ActivityProcessor() {
    //stairHandler_3
    //stepHandler_1
    //activityMonitor_5
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
    stepHandler_1.onAccel(typedEvent);
    stairHandler_3.onAccel(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(ActionEvent typedEvent) {
    switch (typedEvent.filterString()) {
      case ("showActivity"):
        activityMonitor_5.showActivityRequest(typedEvent);
        afterEvent();
        return;
      case ("showTime"):
        activityMonitor_5.showTimeRequest(typedEvent);
        afterEvent();
        return;
      case ("tick"):
        activityMonitor_5.timeTick(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
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
