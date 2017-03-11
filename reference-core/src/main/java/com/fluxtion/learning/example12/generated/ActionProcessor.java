package com.fluxtion.learning.example12.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example12.ActionArrayMonitor;
import com.fluxtion.learning.example12.Handlers.ShowActivityHandler;
import com.fluxtion.learning.example12.Handlers.ShowTickHandler;
import com.fluxtion.learning.example12.Handlers.ShowTimeHandler;
import com.fluxtion.learning.example12.Handlers.ActionHandler;
import com.fluxtion.learning.example12.Events.ShowActivityAction;
import com.fluxtion.learning.example12.Events.ShowTimeAction;
import com.fluxtion.learning.example12.Events.Tick;

public class ActionProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final ActionArrayMonitor actionArrayMonitor_7 = new ActionArrayMonitor();
  private final ShowActivityHandler showActivityHandler_5 = new ShowActivityHandler();
  private final ShowTickHandler showTickHandler_1 = new ShowTickHandler();
  private final ShowTimeHandler showTimeHandler_3 = new ShowTimeHandler();
  //Dirty flags

  //Filter constants

  public ActionProcessor() {
    //actionArrayMonitor_7
    actionArrayMonitor_7.handlers = new ActionHandler[3];
    actionArrayMonitor_7.handlers[0] = showTickHandler_1;
    actionArrayMonitor_7.handlers[1] = showTimeHandler_3;
    actionArrayMonitor_7.handlers[2] = showActivityHandler_5;
    //showActivityHandler_5
    //showTickHandler_1
    //showTimeHandler_3
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example12.Events$ShowActivityAction"):
        {
          ShowActivityAction typedEvent = (ShowActivityAction) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.example12.Events$ShowTimeAction"):
        {
          ShowTimeAction typedEvent = (ShowTimeAction) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.example12.Events$Tick"):
        {
          Tick typedEvent = (Tick) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(ShowActivityAction typedEvent) {
    //Default, no filter methods
    showActivityHandler_5.showActivityRequest(typedEvent);
    actionArrayMonitor_7.handlerUpdated(showActivityHandler_5);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(ShowTimeAction typedEvent) {
    //Default, no filter methods
    showTimeHandler_3.showTimeRequest(typedEvent);
    actionArrayMonitor_7.handlerUpdated(showTimeHandler_3);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(Tick typedEvent) {
    //Default, no filter methods
    showTickHandler_1.showActivityRequest(typedEvent);
    actionArrayMonitor_7.handlerUpdated(showTickHandler_1);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {}

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
