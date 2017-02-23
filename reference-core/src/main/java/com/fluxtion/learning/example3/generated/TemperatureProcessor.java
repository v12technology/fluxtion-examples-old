/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example3.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example3.AvgTemp;
import com.fluxtion.learning.example3.DayAvgTempLogger;
import com.fluxtion.learning.example3.EndOfDayHandler;
import com.fluxtion.learning.example3.TemperatureHandler;
import com.fluxtion.learning.example3.WeekdayValidator;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AvgTemp avgTemp_5 = new AvgTemp();
  private final DayAvgTempLogger dayAvgTempLogger_9 = new DayAvgTempLogger();
  private final EndOfDayHandler endOfDayHandler_3 = new EndOfDayHandler();
  private final TemperatureHandler temperatureHandler_1 = new TemperatureHandler();
  private final WeekdayValidator weekdayValidator_7 = new WeekdayValidator();
  //Dirty flags

  //Filter constants

  public TemperatureProcessor() {
    //avgTemp_5
    avgTemp_5.tempHandler = temperatureHandler_1;
    avgTemp_5.dayHandler = endOfDayHandler_3;
    //dayAvgTempLogger_9
    dayAvgTempLogger_9.avgTemp = avgTemp_5;
    dayAvgTempLogger_9.weekdayTest = weekdayValidator_7;
    dayAvgTempLogger_9.dayHandler = endOfDayHandler_3;
    //endOfDayHandler_3
    //temperatureHandler_1
    //weekdayValidator_7
    weekdayValidator_7.dayHandler = endOfDayHandler_3;
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
    weekdayValidator_7.dayChanged();
    avgTemp_5.calculateAverageTemp();
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
