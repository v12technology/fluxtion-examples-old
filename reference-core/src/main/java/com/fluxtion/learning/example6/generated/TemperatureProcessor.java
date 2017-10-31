package com.fluxtion.learning.example6.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example6.ResetEodHandler;
import com.fluxtion.learning.TemperatureHandler;
import com.fluxtion.learning.example6.AvgDayTempLogger;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final ResetEodHandler resetEodHandler_3 = new ResetEodHandler();
  private final TemperatureHandler temperatureHandler_1 = new TemperatureHandler();
  private final AvgDayTempLogger avgDayTempLogger_5 = new AvgDayTempLogger();
  //Dirty flags

  //Filter constants

  public TemperatureProcessor() {
    avgDayTempLogger_5.eodHandler = resetEodHandler_3;
    avgDayTempLogger_5.tempHandler = temperatureHandler_1;
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
    resetEodHandler_3.handleEod(typedEvent);
    avgDayTempLogger_5.updated();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(TemperatureEvent typedEvent) {
    //Default, no filter methods
    temperatureHandler_1.tempChange(typedEvent);
    avgDayTempLogger_5.updated();
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    resetEodHandler_3.resetEodFlag();
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
