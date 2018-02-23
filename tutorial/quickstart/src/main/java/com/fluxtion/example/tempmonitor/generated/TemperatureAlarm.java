package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.example.tempmonitor.generated.StartOfDayHandler;
import com.fluxtion.example.tempmonitor.generated.TempEventHandler;
import com.fluxtion.example.tempmonitor.generated.MaxInvoker_1;
import com.fluxtion.example.tempmonitor.TempHandler.StartOfDay;
import com.fluxtion.example.tempmonitor.TempHandler.TempEvent;

public class TemperatureAlarm implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final StartOfDayHandler startOfDayHandler_2 = new StartOfDayHandler();
  private final TempEventHandler tempEventHandler_5 = new TempEventHandler();
  private final MaxInvoker_1 maxInvoker_1_8 = new MaxInvoker_1();
  //Dirty flags
  private boolean isDirty_startOfDayHandler_2 = false;
  private boolean isDirty_tempEventHandler_5 = false;
  private boolean isDirty_maxInvoker_1_8 = false;
  //Filter constants

  public TemperatureAlarm() {
    maxInvoker_1_8.source_TempEventHandler_0 = tempEventHandler_5;
    maxInvoker_1_8.resetNotifier = startOfDayHandler_2;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.example.tempmonitor.TempHandler$StartOfDay"):
        {
          StartOfDay typedEvent = (StartOfDay) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.example.tempmonitor.TempHandler$TempEvent"):
        {
          TempEvent typedEvent = (TempEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(StartOfDay typedEvent) {
    //Default, no filter methods
    isDirty_startOfDayHandler_2 = startOfDayHandler_2.handleStartOfDay(typedEvent);
    if (isDirty_startOfDayHandler_2) {
      maxInvoker_1_8.reset(startOfDayHandler_2);
    }
    if (isDirty_startOfDayHandler_2 | isDirty_tempEventHandler_5) {
      isDirty_maxInvoker_1_8 = maxInvoker_1_8.onEvent();
    }
    //event stack unwind callbacks
    if (isDirty_startOfDayHandler_2 | isDirty_tempEventHandler_5) {
      maxInvoker_1_8.afterCalculate();
    }
    afterEvent();
  }

  public void handleEvent(TempEvent typedEvent) {
    //Default, no filter methods
    isDirty_tempEventHandler_5 = tempEventHandler_5.handleTempEvent(typedEvent);
    if (isDirty_tempEventHandler_5) {
      maxInvoker_1_8.sourceChange_source_TempEventHandler_0(tempEventHandler_5);
    }
    if (isDirty_startOfDayHandler_2 | isDirty_tempEventHandler_5) {
      isDirty_maxInvoker_1_8 = maxInvoker_1_8.onEvent();
    }
    //event stack unwind callbacks
    if (isDirty_startOfDayHandler_2 | isDirty_tempEventHandler_5) {
      maxInvoker_1_8.afterCalculate();
    }
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_startOfDayHandler_2 = false;
    isDirty_tempEventHandler_5 = false;
    isDirty_maxInvoker_1_8 = false;
  }

  @Override
  public void init() {
    maxInvoker_1_8.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
