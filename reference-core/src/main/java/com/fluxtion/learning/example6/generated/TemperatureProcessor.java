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
package com.fluxtion.learning.example6.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.TemperatureHandler;
import com.fluxtion.learning.example6.AvgDayTempLogger;
import com.fluxtion.learning.example6.ResetEodHandler;
import com.fluxtion.learning.EndOfDayEvent;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final TemperatureHandler temperatureHandler_1 = new TemperatureHandler();
  private final AvgDayTempLogger avgDayTempLogger_5 = new AvgDayTempLogger();
  private final ResetEodHandler resetEodHandler_3 = new ResetEodHandler();
  //Dirty flags

  //Filter constants

  public TemperatureProcessor() {
    //temperatureHandler_1
    //avgDayTempLogger_5
    avgDayTempLogger_5.eodHandler = resetEodHandler_3;
    avgDayTempLogger_5.tempHandler = temperatureHandler_1;
    //resetEodHandler_3
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
