package com.fluxtion.learning.example25.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example25.AvgDayTemp;
import com.fluxtion.learning.example25.AvgTempLogger;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AvgDayTemp avgDayTemp_1 = new AvgDayTemp();
  private final AvgTempLogger avgTempLogger_3 = new AvgTempLogger();
  //Dirty flags

  //Filter constants

  public TemperatureProcessor() {
    //avgDayTemp_1
    //avgTempLogger_3
    avgTempLogger_3.averageCalc = avgDayTemp_1;
    avgTempLogger_3.updateCount = (int) 0;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.EndOfDayEvent"):
        {
          EndOfDayEvent typedEvent = (EndOfDayEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.TemperatureEvent"):
        {
          TemperatureEvent typedEvent = (TemperatureEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(EndOfDayEvent typedEvent) {
    //Default, no filter methods
    avgDayTemp_1.endOfDay(typedEvent);
    avgTempLogger_3.averageUpdated();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(TemperatureEvent typedEvent) {
    //Default, no filter methods
    avgDayTemp_1.processTemp(typedEvent);
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
