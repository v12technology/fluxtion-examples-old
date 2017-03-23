package com.fluxtion.learning.example26.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example10.Handlers.StairHandler;
import com.fluxtion.learning.example10.Handlers.StepHandler;
import com.fluxtion.learning.example26.ActivityMonitor;
import com.fluxtion.learning.example26.TickHandler;
import com.fluxtion.learning.example10.Events.AccelEvent;
import com.fluxtion.learning.example12.Events.Tick;

public class ActivityProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final StairHandler stairHandler_3 = new StairHandler();
  private final StepHandler stepHandler_1 = new StepHandler();
  public final ActivityMonitor monitor = new ActivityMonitor();
  private final TickHandler tickHandler_5 = new TickHandler();
  //Dirty flags

  //Filter constants

  public ActivityProcessor() {
    //stairHandler_3
    //stepHandler_1
    //monitor
    monitor.stepHandler = stepHandler_1;
    monitor.stairHandler = stairHandler_3;
    monitor.tickHandler = tickHandler_5;
    monitor.count = (int) 0;
    //tickHandler_5
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
      case ("com.fluxtion.learning.example12.Events$Tick"):
        {
          Tick typedEvent = (Tick) event;
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

  public void handleEvent(Tick typedEvent) {
    //Default, no filter methods
    tickHandler_5.onTick(typedEvent);
    monitor.updateDisplay();
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
