package com.fluxtion.learning.example27.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example27.HighTemperatureTest;
import com.fluxtion.learning.example27.TemperatureAlertLogger;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final HighTemperatureTest highTemperatureTest_1 = new HighTemperatureTest(35);
  public final TemperatureAlertLogger alertLogger = new TemperatureAlertLogger(highTemperatureTest_1);
  //Dirty flags
  private boolean isDirty_highTemperatureTest_1 = false;
  //Filter constants

  public TemperatureProcessor() {
    //highTemperatureTest_1
    //alertLogger
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.TemperatureEvent"):
        {
          TemperatureEvent typedEvent = (TemperatureEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(TemperatureEvent typedEvent) {
    //Default, no filter methods
    isDirty_highTemperatureTest_1 = highTemperatureTest_1.processTemp(typedEvent);
    if (isDirty_highTemperatureTest_1) {
      alertLogger.tempAlert();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_highTemperatureTest_1 = false;
  }

  @Override
  public void init() {}

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
