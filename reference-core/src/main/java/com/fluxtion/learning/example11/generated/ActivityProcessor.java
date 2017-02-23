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
package com.fluxtion.learning.example11.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example11.ActivityMonitor;
import com.fluxtion.learning.example11.Handlers.ShowActivityHandler;
import com.fluxtion.learning.example11.Handlers.ShowTimeHandler;
import com.fluxtion.learning.example11.Handlers.StairHandler;
import com.fluxtion.learning.example11.Handlers.StepHandler;
import com.fluxtion.learning.example11.Events.AccelEvent;
import com.fluxtion.learning.example11.Events.ShowActivityAction;
import com.fluxtion.learning.example11.Events.ShowTimeAction;
import com.fluxtion.learning.example11.Events.Tick;

public class ActivityProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final ActivityMonitor activityMonitor_9 = new ActivityMonitor();
  private final ShowActivityHandler showActivityHandler_7 = new ShowActivityHandler();
  private final ShowTimeHandler showTimeHandler_5 = new ShowTimeHandler();
  private final StairHandler stairHandler_3 = new StairHandler();
  private final StepHandler stepHandler_1 = new StepHandler();
  //Dirty flags

  //Filter constants

  public ActivityProcessor() {
    //activityMonitor_9
    activityMonitor_9.stepHandler = stepHandler_1;
    activityMonitor_9.stairHandler = stairHandler_3;
    activityMonitor_9.showTimeHandler = showTimeHandler_5;
    activityMonitor_9.showActivityHandler = showActivityHandler_7;
    //showActivityHandler_7
    //showTimeHandler_5
    //stairHandler_3
    //stepHandler_1
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
    stepHandler_1.onAccel(typedEvent);
    stairHandler_3.onAccel(typedEvent);
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
