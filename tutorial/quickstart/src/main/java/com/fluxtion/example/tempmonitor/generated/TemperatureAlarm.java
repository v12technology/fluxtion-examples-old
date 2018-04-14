package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.example.tempmonitor.TempHandler.EndOfDay;
import com.fluxtion.example.tempmonitor.TempHandler.StartOfDay;
import com.fluxtion.example.tempmonitor.TempHandler.TempEvent;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class TemperatureAlarm implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final EndOfDayHandler endOfDayHandler_17 = new EndOfDayHandler();
  private final StartOfDayHandler startOfDayHandler_1 = new StartOfDayHandler();
  private final MsgBuilder7 msgBuilder7_11 = new MsgBuilder7();
  private final TempEventHandler tempEventHandler_3 = new TempEventHandler();
  private final AvgInvoker_3 avgInvoker_3_7 = new AvgInvoker_3();
  private final GreaterThanDecorator_5 greaterThanDecorator_5_9 = new GreaterThanDecorator_5();
  private final MaxInvoker_1 maxInvoker_1_5 = new MaxInvoker_1();
  private final MsgBuilder9 msgBuilder9_15 = new MsgBuilder9();
  private final MsgBuilder11 msgBuilder11_19 = new MsgBuilder11();
  private final MsgBuilder13 msgBuilder13_21 = new MsgBuilder13();
  private final AsciiConsoleLogger asciiConsoleLogger_13 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_startOfDayHandler_1 = false;
  private boolean isDirty_tempEventHandler_3 = false;
  private boolean isDirty_greaterThanDecorator_5_9 = false;
  private boolean isDirty_msgBuilder9_15 = false;
  private boolean isDirty_msgBuilder13_21 = false;
  private boolean isDirty_endOfDayHandler_17 = false;
  private boolean isDirty_msgBuilder7_11 = false;
  private boolean isDirty_avgInvoker_3_7 = false;
  private boolean isDirty_maxInvoker_1_5 = false;
  private boolean isDirty_msgBuilder11_19 = false;
  //Filter constants

  public TemperatureAlarm() {
    msgBuilder7_11.source_StartOfDayHandler_6 = startOfDayHandler_1;
    msgBuilder7_11.logLevel = (int) 2;
    msgBuilder7_11.initCapacity = (int) 256;
    avgInvoker_3_7.source_TempEventHandler_2 = tempEventHandler_3;
    avgInvoker_3_7.resetNotifier = startOfDayHandler_1;
    greaterThanDecorator_5_9.source_TempEventHandler_4 = tempEventHandler_3;
    maxInvoker_1_5.source_TempEventHandler_0 = tempEventHandler_3;
    maxInvoker_1_5.resetNotifier = startOfDayHandler_1;
    msgBuilder9_15.source_MaxInvoker_1_8 = maxInvoker_1_5;
    msgBuilder9_15.logLevel = (int) 3;
    msgBuilder9_15.initCapacity = (int) 256;
    msgBuilder11_19.source_AvgInvoker_3_10 = avgInvoker_3_7;
    msgBuilder11_19.logNotifier = endOfDayHandler_17;
    msgBuilder11_19.logLevel = (int) 4;
    msgBuilder11_19.initCapacity = (int) 256;
    msgBuilder13_21.source_TempEventHandler_12 = tempEventHandler_3;
    msgBuilder13_21.logNotifier = greaterThanDecorator_5_9;
    msgBuilder13_21.logLevel = (int) 2;
    msgBuilder13_21.initCapacity = (int) 256;
    asciiConsoleLogger_13.initCapacity = (int) 512;
    asciiConsoleLogger_13.msgBuilders = new MsgBuilder[4];
    asciiConsoleLogger_13.msgBuilders[0] = msgBuilder7_11;
    asciiConsoleLogger_13.msgBuilders[1] = msgBuilder9_15;
    asciiConsoleLogger_13.msgBuilders[2] = msgBuilder11_19;
    asciiConsoleLogger_13.msgBuilders[3] = msgBuilder13_21;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.example.tempmonitor.TempHandler$EndOfDay"):
        {
          EndOfDay typedEvent = (EndOfDay) event;
          handleEvent(typedEvent);
          break;
        }
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
      case ("com.fluxtion.extension.declarative.api.log.LogControlEvent"):
        {
          LogControlEvent typedEvent = (LogControlEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(EndOfDay typedEvent) {
    //Default, no filter methods
    isDirty_endOfDayHandler_17 = endOfDayHandler_17.handleEndOfDay(typedEvent);
    if (isDirty_endOfDayHandler_17) {
      msgBuilder11_19.postLog(endOfDayHandler_17);
    }
    if (isDirty_endOfDayHandler_17) {
      isDirty_msgBuilder11_19 = msgBuilder11_19.buildMessage();
      if (isDirty_msgBuilder11_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder11_19);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(StartOfDay typedEvent) {
    //Default, no filter methods
    isDirty_startOfDayHandler_1 = startOfDayHandler_1.handleStartOfDay(typedEvent);
    if (isDirty_startOfDayHandler_1) {
      avgInvoker_3_7.reset(startOfDayHandler_1);
      maxInvoker_1_5.reset(startOfDayHandler_1);
    }
    if (isDirty_startOfDayHandler_1) {
      isDirty_msgBuilder7_11 = msgBuilder7_11.buildMessage();
      if (isDirty_msgBuilder7_11) {
        asciiConsoleLogger_13.publishMessage(msgBuilder7_11);
      }
    }
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      isDirty_avgInvoker_3_7 = avgInvoker_3_7.onEvent();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_maxInvoker_1_5 = maxInvoker_1_5.onEvent();
    }
    if (isDirty_maxInvoker_1_5) {
      isDirty_msgBuilder9_15 = msgBuilder9_15.buildMessage();
      if (isDirty_msgBuilder9_15) {
        asciiConsoleLogger_13.publishMessage(msgBuilder9_15);
      }
    }
    //event stack unwind callbacks
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      avgInvoker_3_7.afterCalculate();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      maxInvoker_1_5.afterCalculate();
    }
    afterEvent();
  }

  public void handleEvent(TempEvent typedEvent) {
    //Default, no filter methods
    isDirty_tempEventHandler_3 = tempEventHandler_3.handleTempEvent(typedEvent);
    if (isDirty_tempEventHandler_3) {
      avgInvoker_3_7.sourceChange_source_TempEventHandler_2(tempEventHandler_3);
      maxInvoker_1_5.sourceChange_source_TempEventHandler_0(tempEventHandler_3);
    }
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      isDirty_avgInvoker_3_7 = avgInvoker_3_7.onEvent();
    }
    if (isDirty_tempEventHandler_3) {
      isDirty_greaterThanDecorator_5_9 = greaterThanDecorator_5_9.onEvent();
      if (isDirty_greaterThanDecorator_5_9) {
        msgBuilder13_21.postLog(greaterThanDecorator_5_9);
      }
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_maxInvoker_1_5 = maxInvoker_1_5.onEvent();
    }
    if (isDirty_maxInvoker_1_5) {
      isDirty_msgBuilder9_15 = msgBuilder9_15.buildMessage();
      if (isDirty_msgBuilder9_15) {
        asciiConsoleLogger_13.publishMessage(msgBuilder9_15);
      }
    }
    if (isDirty_greaterThanDecorator_5_9) {
      isDirty_msgBuilder13_21 = msgBuilder13_21.buildMessage();
      if (isDirty_msgBuilder13_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder13_21);
      }
    }
    //event stack unwind callbacks
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      avgInvoker_3_7.afterCalculate();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      maxInvoker_1_5.afterCalculate();
    }
    afterEvent();
  }

  public void handleEvent(LogControlEvent typedEvent) {
    FilteredHandlerInvoker invoker =
        dispatchStringMapLogControlEvent.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  //int filter maps
  //String filter maps
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapLogControlEvent =
      initdispatchStringMapLogControlEvent();

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapLogControlEvent() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "CHANGE_FILTER",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_LogControlEvent_CHANGE_FILTER(
                (com.fluxtion.extension.declarative.api.log.LogControlEvent) event);
          }
        });
    dispatchMap.put(
        "CHANGE_LEVEL",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_LogControlEvent_CHANGE_LEVEL(
                (com.fluxtion.extension.declarative.api.log.LogControlEvent) event);
          }
        });
    dispatchMap.put(
        "RECORD_LEVEL",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_LogControlEvent_RECORD_LEVEL(
                (com.fluxtion.extension.declarative.api.log.LogControlEvent) event);
          }
        });
    dispatchMap.put(
        "RECORD_NAME",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_LogControlEvent_RECORD_NAME(
                (com.fluxtion.extension.declarative.api.log.LogControlEvent) event);
          }
        });
    dispatchMap.put(
        "RECORD_TIME",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_LogControlEvent_RECORD_TIME(
                (com.fluxtion.extension.declarative.api.log.LogControlEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_LogControlEvent_CHANGE_FILTER(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder7_11 = msgBuilder7_11.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder9_15 = msgBuilder9_15.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder11_19 = msgBuilder11_19.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder13_21 = msgBuilder13_21.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder7_11 = msgBuilder7_11.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder9_15 = msgBuilder9_15.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder11_19 = msgBuilder11_19.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder13_21 = msgBuilder13_21.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_13.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_13.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_13.controlTimeLogging(typedEvent);
  }

  @Override
  public void afterEvent() {
    msgBuilder13_21.afterEvent();
    msgBuilder11_19.afterEvent();
    msgBuilder9_15.afterEvent();
    msgBuilder7_11.afterEvent();
    isDirty_startOfDayHandler_1 = false;
    isDirty_tempEventHandler_3 = false;
    isDirty_greaterThanDecorator_5_9 = false;
    isDirty_msgBuilder9_15 = false;
    isDirty_msgBuilder13_21 = false;
    isDirty_endOfDayHandler_17 = false;
    isDirty_msgBuilder7_11 = false;
    isDirty_avgInvoker_3_7 = false;
    isDirty_maxInvoker_1_5 = false;
    isDirty_msgBuilder11_19 = false;
  }

  @Override
  public void init() {
    msgBuilder7_11.init();
    avgInvoker_3_7.init();
    greaterThanDecorator_5_9.init();
    maxInvoker_1_5.init();
    msgBuilder9_15.init();
    msgBuilder11_19.init();
    msgBuilder13_21.init();
    asciiConsoleLogger_13.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
