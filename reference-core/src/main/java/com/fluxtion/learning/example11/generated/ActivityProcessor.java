package com.fluxtion.learning.example11.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example11.Handlers.ShowActivityHandler;
import com.fluxtion.learning.example11.Handlers.ShowTimeHandler;
import com.fluxtion.learning.example11.Handlers.StairHandler;
import com.fluxtion.learning.example11.Handlers.StepHandler;
import com.fluxtion.learning.example11.ActivityMonitor;
import com.fluxtion.learning.example11.Events.AccelEvent;
import com.fluxtion.learning.example11.Events.ShowActivityAction;
import com.fluxtion.learning.example11.Events.ShowTimeAction;
import com.fluxtion.learning.example11.Events.Tick;

public class ActivityProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final ShowActivityHandler showActivityHandler_7 = new ShowActivityHandler();
  private final ShowTimeHandler showTimeHandler_5 = new ShowTimeHandler();
  private final StairHandler stairHandler_3 = new StairHandler();
  private final StepHandler stepHandler_1 = new StepHandler();
  private final ActivityMonitor activityMonitor_9 = new ActivityMonitor();
  //Dirty flags

  //Filter constants

  public ActivityProcessor() {
    activityMonitor_9.stepHandler = stepHandler_1;
    activityMonitor_9.stairHandler = stairHandler_3;
    activityMonitor_9.showTimeHandler = showTimeHandler_5;
    activityMonitor_9.showActivityHandler = showActivityHandler_7;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example11.Events$AccelEvent"):
        {
          AccelEvent typedEvent = (AccelEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.example11.Events$ShowActivityAction"):
        {
          ShowActivityAction typedEvent = (ShowActivityAction) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.example11.Events$ShowTimeAction"):
        {
          ShowTimeAction typedEvent = (ShowTimeAction) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.example11.Events$Tick"):
        {
          Tick typedEvent = (Tick) event;
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

  public void handleEvent(ShowActivityAction typedEvent) {
    //Default, no filter methods
    showActivityHandler_7.showActivityRequest(typedEvent);
    activityMonitor_9.showActivityRequest(showActivityHandler_7);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(ShowTimeAction typedEvent) {
    //Default, no filter methods
    showTimeHandler_5.showTimeRequest(typedEvent);
    activityMonitor_9.showTimeRequest(showTimeHandler_5);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(Tick typedEvent) {
    //Default, no filter methods
    activityMonitor_9.timeTick(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {
    activityMonitor_9.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
