package com.fluxtion.learning.example2.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example2.AvgTemp;
import com.fluxtion.learning.example2.TemperatureHandler;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AvgTemp avgTemp_3 = new AvgTemp();
  private final TemperatureHandler temperatureHandler_1 = new TemperatureHandler();
  //Dirty flags

  //Filter constants

  public TemperatureProcessor() {
    //avgTemp_3
    avgTemp_3.tempHandler = temperatureHandler_1;
    //temperatureHandler_1
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
    temperatureHandler_1.tempChange(typedEvent);
    avgTemp_3.calculateAverageTemp();
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
