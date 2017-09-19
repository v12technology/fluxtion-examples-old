package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.example.tempmonitor.generated.StartOfDayHandler;
import com.fluxtion.example.tempmonitor.generated.TempEventHandler;
import com.fluxtion.example.tempmonitor.generated.EndOfDayHandler;
import com.fluxtion.example.tempmonitor.generated.MaxInvoker_1;
import com.fluxtion.example.tempmonitor.generated.AvgInvoker_3;
import com.fluxtion.example.tempmonitor.generated.GreaterThanDecorator_5;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder7;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder9;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder11;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.example.tempmonitor.TempHandler.EndOfDay;
import com.fluxtion.example.tempmonitor.TempHandler.StartOfDay;
import com.fluxtion.example.tempmonitor.TempHandler.TempEvent;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class TemperatureAlarm implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final StartOfDayHandler startOfDayHandler_1 = new StartOfDayHandler();
  private final TempEventHandler tempEventHandler_3 = new TempEventHandler();
  private final TempEventHandler tempEventHandler_9 = new TempEventHandler();
  private final StartOfDayHandler startOfDayHandler_7 = new StartOfDayHandler();
  private final TempEventHandler tempEventHandler_13 = new TempEventHandler();
  private final EndOfDayHandler endOfDayHandler_21 = new EndOfDayHandler();
  private final TempEventHandler tempEventHandler_25 = new TempEventHandler();
  private final MaxInvoker_1 maxInvoker_1_5 = new MaxInvoker_1();
  private final AvgInvoker_3 avgInvoker_3_11 = new AvgInvoker_3();
  private final GreaterThanDecorator_5 greaterThanDecorator_5_15 = new GreaterThanDecorator_5();
  private final MsgBuilder7 msgBuilder7_17 = new MsgBuilder7();
  private final MsgBuilder9 msgBuilder9_23 = new MsgBuilder9();
  private final MsgBuilder11 msgBuilder11_27 = new MsgBuilder11();
  private final AsciiConsoleLogger asciiConsoleLogger_19 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_avgInvoker_3_11 = false;
  private boolean isDirty_endOfDayHandler_21 = false;
  private boolean isDirty_greaterThanDecorator_5_15 = false;
  private boolean isDirty_maxInvoker_1_5 = false;
  private boolean isDirty_msgBuilder7_17 = false;
  private boolean isDirty_msgBuilder9_23 = false;
  private boolean isDirty_msgBuilder11_27 = false;
  private boolean isDirty_startOfDayHandler_1 = false;
  private boolean isDirty_startOfDayHandler_7 = false;
  private boolean isDirty_tempEventHandler_3 = false;
  private boolean isDirty_tempEventHandler_9 = false;
  private boolean isDirty_tempEventHandler_13 = false;
  private boolean isDirty_tempEventHandler_25 = false;
  //Filter constants

  public TemperatureAlarm() {
    avgInvoker_3_11.source_TempEventHandler_2 = tempEventHandler_9;
    avgInvoker_3_11.resetNotifier = startOfDayHandler_7;
    greaterThanDecorator_5_15.source_TempEventHandler_4 = tempEventHandler_13;
    maxInvoker_1_5.source_TempEventHandler_0 = tempEventHandler_3;
    maxInvoker_1_5.resetNotifier = startOfDayHandler_1;
    msgBuilder7_17.source_MaxInvoker_1_6 = maxInvoker_1_5;
    msgBuilder7_17.logLevel = (int) 3;
    msgBuilder7_17.initCapacity = (int) 256;
    msgBuilder9_23.source_AvgInvoker_3_8 = avgInvoker_3_11;
    msgBuilder9_23.logNotifier = endOfDayHandler_21;
    msgBuilder9_23.logLevel = (int) 4;
    msgBuilder9_23.initCapacity = (int) 256;
    msgBuilder11_27.source_TempEventHandler_10 = tempEventHandler_25;
    msgBuilder11_27.logNotifier = greaterThanDecorator_5_15;
    msgBuilder11_27.logLevel = (int) 2;
    msgBuilder11_27.initCapacity = (int) 256;
    asciiConsoleLogger_19.initCapacity = (int) 512;
    asciiConsoleLogger_19.msgBuilders = new MsgBuilder[3];
    asciiConsoleLogger_19.msgBuilders[0] = msgBuilder7_17;
    asciiConsoleLogger_19.msgBuilders[1] = msgBuilder9_23;
    asciiConsoleLogger_19.msgBuilders[2] = msgBuilder11_27;
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
    isDirty_endOfDayHandler_21 = endOfDayHandler_21.handleEndOfDay(typedEvent);
    if (isDirty_endOfDayHandler_21) {
      msgBuilder9_23.postLog(endOfDayHandler_21);
    }
    if (isDirty_endOfDayHandler_21) {
      isDirty_msgBuilder9_23 = msgBuilder9_23.buildMessage();
      if (isDirty_msgBuilder9_23) {
        asciiConsoleLogger_19.publishMessage(msgBuilder9_23);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(StartOfDay typedEvent) {
    //Default, no filter methods
    isDirty_startOfDayHandler_1 = startOfDayHandler_1.handleStartOfDay(typedEvent);
    if (isDirty_startOfDayHandler_1) {
      maxInvoker_1_5.reset(startOfDayHandler_1);
    }
    isDirty_startOfDayHandler_7 = startOfDayHandler_7.handleStartOfDay(typedEvent);
    if (isDirty_startOfDayHandler_7) {
      avgInvoker_3_11.reset(startOfDayHandler_7);
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_maxInvoker_1_5 = maxInvoker_1_5.onEvent();
    }
    if (isDirty_startOfDayHandler_7 | isDirty_tempEventHandler_9) {
      isDirty_avgInvoker_3_11 = avgInvoker_3_11.onEvent();
    }
    if (isDirty_maxInvoker_1_5) {
      isDirty_msgBuilder7_17 = msgBuilder7_17.buildMessage();
      if (isDirty_msgBuilder7_17) {
        asciiConsoleLogger_19.publishMessage(msgBuilder7_17);
      }
    }
    //event stack unwind callbacks
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      maxInvoker_1_5.afterCalculate();
    }
    if (isDirty_startOfDayHandler_7 | isDirty_tempEventHandler_9) {
      avgInvoker_3_11.afterCalculate();
    }
    afterEvent();
  }

  public void handleEvent(TempEvent typedEvent) {
    //Default, no filter methods
    isDirty_tempEventHandler_3 = tempEventHandler_3.handleTempEvent(typedEvent);
    if (isDirty_tempEventHandler_3) {
      maxInvoker_1_5.sourceChange_source_TempEventHandler_0(tempEventHandler_3);
    }
    isDirty_tempEventHandler_9 = tempEventHandler_9.handleTempEvent(typedEvent);
    if (isDirty_tempEventHandler_9) {
      avgInvoker_3_11.sourceChange_source_TempEventHandler_2(tempEventHandler_9);
    }
    isDirty_tempEventHandler_13 = tempEventHandler_13.handleTempEvent(typedEvent);
    isDirty_tempEventHandler_25 = tempEventHandler_25.handleTempEvent(typedEvent);
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_maxInvoker_1_5 = maxInvoker_1_5.onEvent();
    }
    if (isDirty_startOfDayHandler_7 | isDirty_tempEventHandler_9) {
      isDirty_avgInvoker_3_11 = avgInvoker_3_11.onEvent();
    }
    if (isDirty_tempEventHandler_13) {
      isDirty_greaterThanDecorator_5_15 = greaterThanDecorator_5_15.onEvent();
      if (isDirty_greaterThanDecorator_5_15) {
        msgBuilder11_27.postLog(greaterThanDecorator_5_15);
      }
    }
    if (isDirty_maxInvoker_1_5) {
      isDirty_msgBuilder7_17 = msgBuilder7_17.buildMessage();
      if (isDirty_msgBuilder7_17) {
        asciiConsoleLogger_19.publishMessage(msgBuilder7_17);
      }
    }
    if (isDirty_greaterThanDecorator_5_15) {
      isDirty_msgBuilder11_27 = msgBuilder11_27.buildMessage();
      if (isDirty_msgBuilder11_27) {
        asciiConsoleLogger_19.publishMessage(msgBuilder11_27);
      }
    }
    //event stack unwind callbacks
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      maxInvoker_1_5.afterCalculate();
    }
    if (isDirty_startOfDayHandler_7 | isDirty_tempEventHandler_9) {
      avgInvoker_3_11.afterCalculate();
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
    isDirty_msgBuilder7_17 = msgBuilder7_17.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder9_23 = msgBuilder9_23.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder11_27 = msgBuilder11_27.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder7_17 = msgBuilder7_17.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder9_23 = msgBuilder9_23.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder11_27 = msgBuilder11_27.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_19.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_19.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_19.controlTimeLogging(typedEvent);
  }

  @Override
  public void afterEvent() {
    msgBuilder11_27.afterEvent();
    msgBuilder9_23.afterEvent();
    msgBuilder7_17.afterEvent();
    isDirty_avgInvoker_3_11 = false;
    isDirty_endOfDayHandler_21 = false;
    isDirty_greaterThanDecorator_5_15 = false;
    isDirty_maxInvoker_1_5 = false;
    isDirty_msgBuilder7_17 = false;
    isDirty_msgBuilder9_23 = false;
    isDirty_msgBuilder11_27 = false;
    isDirty_startOfDayHandler_1 = false;
    isDirty_startOfDayHandler_7 = false;
    isDirty_tempEventHandler_3 = false;
    isDirty_tempEventHandler_9 = false;
    isDirty_tempEventHandler_13 = false;
    isDirty_tempEventHandler_25 = false;
  }

  @Override
  public void init() {
    maxInvoker_1_5.init();
    avgInvoker_3_11.init();
    greaterThanDecorator_5_15.init();
    msgBuilder7_17.init();
    msgBuilder9_23.init();
    msgBuilder11_27.init();
    asciiConsoleLogger_19.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
