package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.example.tempmonitor.generated.EndOfDayHandler;
import com.fluxtion.example.tempmonitor.generated.StartOfDayHandler;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder7;
import com.fluxtion.example.tempmonitor.generated.TempEventHandler;
import com.fluxtion.example.tempmonitor.generated.MaxInvoker_1;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder9;
import com.fluxtion.example.tempmonitor.generated.AvgInvoker_3;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder11;
import com.fluxtion.example.tempmonitor.generated.GreaterThanDecorator_5;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder13;
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
  private final EndOfDayHandler endOfDayHandler_38 = new EndOfDayHandler();
  private final StartOfDayHandler startOfDayHandler_2 = new StartOfDayHandler();
  private final StartOfDayHandler startOfDayHandler_11 = new StartOfDayHandler();
  private final StartOfDayHandler startOfDayHandler_26 = new StartOfDayHandler();
  private final MsgBuilder7 msgBuilder7_29 = new MsgBuilder7();
  private final TempEventHandler tempEventHandler_5 = new TempEventHandler();
  private final MaxInvoker_1 maxInvoker_1_8 = new MaxInvoker_1();
  private final MsgBuilder9 msgBuilder9_35 = new MsgBuilder9();
  private final TempEventHandler tempEventHandler_14 = new TempEventHandler();
  private final AvgInvoker_3 avgInvoker_3_17 = new AvgInvoker_3();
  private final MsgBuilder11 msgBuilder11_41 = new MsgBuilder11();
  private final TempEventHandler tempEventHandler_20 = new TempEventHandler();
  private final GreaterThanDecorator_5 greaterThanDecorator_5_23 = new GreaterThanDecorator_5();
  private final TempEventHandler tempEventHandler_44 = new TempEventHandler();
  private final MsgBuilder13 msgBuilder13_47 = new MsgBuilder13();
  private final AsciiConsoleLogger asciiConsoleLogger_32 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_msgBuilder13_47 = false;
  private boolean isDirty_startOfDayHandler_2 = false;
  private boolean isDirty_startOfDayHandler_26 = false;
  private boolean isDirty_tempEventHandler_5 = false;
  private boolean isDirty_msgBuilder9_35 = false;
  private boolean isDirty_avgInvoker_3_17 = false;
  private boolean isDirty_tempEventHandler_20 = false;
  private boolean isDirty_tempEventHandler_44 = false;
  private boolean isDirty_endOfDayHandler_38 = false;
  private boolean isDirty_startOfDayHandler_11 = false;
  private boolean isDirty_msgBuilder7_29 = false;
  private boolean isDirty_maxInvoker_1_8 = false;
  private boolean isDirty_tempEventHandler_14 = false;
  private boolean isDirty_msgBuilder11_41 = false;
  private boolean isDirty_greaterThanDecorator_5_23 = false;
  //Filter constants

  public TemperatureAlarm() {
    msgBuilder7_29.source_StartOfDayHandler_6 = startOfDayHandler_26;
    msgBuilder7_29.logLevel = (int) 2;
    msgBuilder7_29.initCapacity = (int) 256;
    maxInvoker_1_8.source_TempEventHandler_0 = tempEventHandler_5;
    maxInvoker_1_8.resetNotifier = startOfDayHandler_2;
    msgBuilder9_35.source_MaxInvoker_1_8 = maxInvoker_1_8;
    msgBuilder9_35.logLevel = (int) 3;
    msgBuilder9_35.initCapacity = (int) 256;
    avgInvoker_3_17.source_TempEventHandler_2 = tempEventHandler_14;
    avgInvoker_3_17.resetNotifier = startOfDayHandler_11;
    msgBuilder11_41.source_AvgInvoker_3_10 = avgInvoker_3_17;
    msgBuilder11_41.logNotifier = endOfDayHandler_38;
    msgBuilder11_41.logLevel = (int) 4;
    msgBuilder11_41.initCapacity = (int) 256;
    greaterThanDecorator_5_23.source_TempEventHandler_4 = tempEventHandler_20;
    msgBuilder13_47.source_TempEventHandler_12 = tempEventHandler_44;
    msgBuilder13_47.logNotifier = greaterThanDecorator_5_23;
    msgBuilder13_47.logLevel = (int) 2;
    msgBuilder13_47.initCapacity = (int) 256;
    asciiConsoleLogger_32.initCapacity = (int) 512;
    asciiConsoleLogger_32.msgBuilders = new MsgBuilder[4];
    asciiConsoleLogger_32.msgBuilders[0] = msgBuilder7_29;
    asciiConsoleLogger_32.msgBuilders[1] = msgBuilder9_35;
    asciiConsoleLogger_32.msgBuilders[2] = msgBuilder11_41;
    asciiConsoleLogger_32.msgBuilders[3] = msgBuilder13_47;
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
    isDirty_endOfDayHandler_38 = endOfDayHandler_38.handleEndOfDay(typedEvent);
    if (isDirty_endOfDayHandler_38) {
      msgBuilder11_41.postLog(endOfDayHandler_38);
    }
    if (isDirty_endOfDayHandler_38) {
      isDirty_msgBuilder11_41 = msgBuilder11_41.buildMessage();
      if (isDirty_msgBuilder11_41) {
        asciiConsoleLogger_32.publishMessage(msgBuilder11_41);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(StartOfDay typedEvent) {
    //Default, no filter methods
    isDirty_startOfDayHandler_2 = startOfDayHandler_2.handleStartOfDay(typedEvent);
    if (isDirty_startOfDayHandler_2) {
      maxInvoker_1_8.reset(startOfDayHandler_2);
    }
    isDirty_startOfDayHandler_11 = startOfDayHandler_11.handleStartOfDay(typedEvent);
    if (isDirty_startOfDayHandler_11) {
      avgInvoker_3_17.reset(startOfDayHandler_11);
    }
    isDirty_startOfDayHandler_26 = startOfDayHandler_26.handleStartOfDay(typedEvent);
    if (isDirty_startOfDayHandler_26) {
      isDirty_msgBuilder7_29 = msgBuilder7_29.buildMessage();
      if (isDirty_msgBuilder7_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder7_29);
      }
    }
    if (isDirty_startOfDayHandler_2 | isDirty_tempEventHandler_5) {
      isDirty_maxInvoker_1_8 = maxInvoker_1_8.onEvent();
    }
    if (isDirty_maxInvoker_1_8) {
      isDirty_msgBuilder9_35 = msgBuilder9_35.buildMessage();
      if (isDirty_msgBuilder9_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder9_35);
      }
    }
    if (isDirty_tempEventHandler_14 | isDirty_startOfDayHandler_11) {
      isDirty_avgInvoker_3_17 = avgInvoker_3_17.onEvent();
    }
    //event stack unwind callbacks
    if (isDirty_startOfDayHandler_2 | isDirty_tempEventHandler_5) {
      maxInvoker_1_8.afterCalculate();
    }
    if (isDirty_tempEventHandler_14 | isDirty_startOfDayHandler_11) {
      avgInvoker_3_17.afterCalculate();
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
    if (isDirty_maxInvoker_1_8) {
      isDirty_msgBuilder9_35 = msgBuilder9_35.buildMessage();
      if (isDirty_msgBuilder9_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder9_35);
      }
    }
    isDirty_tempEventHandler_14 = tempEventHandler_14.handleTempEvent(typedEvent);
    if (isDirty_tempEventHandler_14) {
      avgInvoker_3_17.sourceChange_source_TempEventHandler_2(tempEventHandler_14);
    }
    if (isDirty_tempEventHandler_14 | isDirty_startOfDayHandler_11) {
      isDirty_avgInvoker_3_17 = avgInvoker_3_17.onEvent();
    }
    isDirty_tempEventHandler_20 = tempEventHandler_20.handleTempEvent(typedEvent);
    if (isDirty_tempEventHandler_20) {
      isDirty_greaterThanDecorator_5_23 = greaterThanDecorator_5_23.onEvent();
      if (isDirty_greaterThanDecorator_5_23) {
        msgBuilder13_47.postLog(greaterThanDecorator_5_23);
      }
    }
    isDirty_tempEventHandler_44 = tempEventHandler_44.handleTempEvent(typedEvent);
    if (isDirty_greaterThanDecorator_5_23) {
      isDirty_msgBuilder13_47 = msgBuilder13_47.buildMessage();
      if (isDirty_msgBuilder13_47) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_47);
      }
    }
    //event stack unwind callbacks
    if (isDirty_startOfDayHandler_2 | isDirty_tempEventHandler_5) {
      maxInvoker_1_8.afterCalculate();
    }
    if (isDirty_tempEventHandler_14 | isDirty_startOfDayHandler_11) {
      avgInvoker_3_17.afterCalculate();
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
    isDirty_msgBuilder7_29 = msgBuilder7_29.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder9_35 = msgBuilder9_35.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder11_41 = msgBuilder11_41.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder13_47 = msgBuilder13_47.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder7_29 = msgBuilder7_29.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder9_35 = msgBuilder9_35.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder11_41 = msgBuilder11_41.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder13_47 = msgBuilder13_47.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_32.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_32.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_32.controlTimeLogging(typedEvent);
  }

  @Override
  public void afterEvent() {
    msgBuilder13_47.afterEvent();
    msgBuilder11_41.afterEvent();
    msgBuilder9_35.afterEvent();
    msgBuilder7_29.afterEvent();
    isDirty_msgBuilder13_47 = false;
    isDirty_startOfDayHandler_2 = false;
    isDirty_startOfDayHandler_26 = false;
    isDirty_tempEventHandler_5 = false;
    isDirty_msgBuilder9_35 = false;
    isDirty_avgInvoker_3_17 = false;
    isDirty_tempEventHandler_20 = false;
    isDirty_tempEventHandler_44 = false;
    isDirty_endOfDayHandler_38 = false;
    isDirty_startOfDayHandler_11 = false;
    isDirty_msgBuilder7_29 = false;
    isDirty_maxInvoker_1_8 = false;
    isDirty_tempEventHandler_14 = false;
    isDirty_msgBuilder11_41 = false;
    isDirty_greaterThanDecorator_5_23 = false;
  }

  @Override
  public void init() {
    msgBuilder7_29.init();
    maxInvoker_1_8.init();
    msgBuilder9_35.init();
    avgInvoker_3_17.init();
    msgBuilder11_41.init();
    greaterThanDecorator_5_23.init();
    msgBuilder13_47.init();
    asciiConsoleLogger_32.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
