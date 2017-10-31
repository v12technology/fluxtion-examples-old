package com.fluxtion.learning.example3.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example3.EndOfDayHandler;
import com.fluxtion.learning.example3.TemperatureHandler;
import com.fluxtion.learning.example3.AvgTemp;
import com.fluxtion.learning.example3.WeekdayValidator;
import com.fluxtion.learning.example3.DayAvgTempLogger;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final EndOfDayHandler endOfDayHandler_3 = new EndOfDayHandler();
  private final TemperatureHandler temperatureHandler_1 = new TemperatureHandler();
  private final AvgTemp avgTemp_5 = new AvgTemp();
  private final WeekdayValidator weekdayValidator_7 = new WeekdayValidator();
  private final DayAvgTempLogger dayAvgTempLogger_9 = new DayAvgTempLogger();
  //Dirty flags

  //Filter constants

  public TemperatureProcessor() {
    avgTemp_5.tempHandler = temperatureHandler_1;
    avgTemp_5.dayHandler = endOfDayHandler_3;
    weekdayValidator_7.dayHandler = endOfDayHandler_3;
    dayAvgTempLogger_9.avgTemp = avgTemp_5;
    dayAvgTempLogger_9.weekdayTest = weekdayValidator_7;
    dayAvgTempLogger_9.dayHandler = endOfDayHandler_3;
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
    endOfDayHandler_3.endOfDay(typedEvent);
    avgTemp_5.calculateAverageTemp();
    weekdayValidator_7.dayChanged();
    dayAvgTempLogger_9.logEodAvgTemp();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(TemperatureEvent typedEvent) {
    //Default, no filter methods
    temperatureHandler_1.tempChange(typedEvent);
    avgTemp_5.calculateAverageTemp();
    dayAvgTempLogger_9.logEodAvgTemp();
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
