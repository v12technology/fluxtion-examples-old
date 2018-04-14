package com.fluxtion.example.tempmonitor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.example.tempmonitor.generated.EndOfDayHandler;
import com.fluxtion.example.tempmonitor.generated.StartOfDayHandler;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder9;
import com.fluxtion.example.tempmonitor.generated.TempEventHandler;
import com.fluxtion.example.tempmonitor.generated.AvgInvoker_3;
import com.fluxtion.example.tempmonitor.generated.GreaterThanDecorator_7;
import com.fluxtion.example.tempmonitor.generated.MaxInvoker_1;
import com.fluxtion.example.tempmonitor.generated.MinInvoker_5;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder11;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder13;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder15;
import com.fluxtion.example.tempmonitor.generated.MsgBuilder17;
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
  private final EndOfDayHandler endOfDayHandler_21 = new EndOfDayHandler();
  private final StartOfDayHandler startOfDayHandler_1 = new StartOfDayHandler();
  private final MsgBuilder9 msgBuilder9_13 = new MsgBuilder9();
  private final TempEventHandler tempEventHandler_3 = new TempEventHandler();
  private final AvgInvoker_3 avgInvoker_3_7 = new AvgInvoker_3();
  private final GreaterThanDecorator_7 greaterThanDecorator_7_11 = new GreaterThanDecorator_7();
  private final MaxInvoker_1 maxInvoker_1_5 = new MaxInvoker_1();
  private final MinInvoker_5 minInvoker_5_9 = new MinInvoker_5();
  private final MsgBuilder11 msgBuilder11_17 = new MsgBuilder11();
  private final MsgBuilder13 msgBuilder13_19 = new MsgBuilder13();
  private final MsgBuilder15 msgBuilder15_23 = new MsgBuilder15();
  private final MsgBuilder17 msgBuilder17_25 = new MsgBuilder17();
  private final AsciiConsoleLogger asciiConsoleLogger_15 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_endOfDayHandler_21 = false;
  private boolean isDirty_msgBuilder9_13 = false;
  private boolean isDirty_avgInvoker_3_7 = false;
  private boolean isDirty_maxInvoker_1_5 = false;
  private boolean isDirty_msgBuilder11_17 = false;
  private boolean isDirty_msgBuilder15_23 = false;
  private boolean isDirty_startOfDayHandler_1 = false;
  private boolean isDirty_tempEventHandler_3 = false;
  private boolean isDirty_greaterThanDecorator_7_11 = false;
  private boolean isDirty_minInvoker_5_9 = false;
  private boolean isDirty_msgBuilder13_19 = false;
  private boolean isDirty_msgBuilder17_25 = false;
  //Filter constants

  public TemperatureAlarm() {
    msgBuilder9_13.source_StartOfDayHandler_8 = startOfDayHandler_1;
    msgBuilder9_13.logLevel = (int) 2;
    msgBuilder9_13.initCapacity = (int) 256;
    avgInvoker_3_7.source_TempEventHandler_2 = tempEventHandler_3;
    avgInvoker_3_7.resetNotifier = startOfDayHandler_1;
    greaterThanDecorator_7_11.source_TempEventHandler_6 = tempEventHandler_3;
    maxInvoker_1_5.source_TempEventHandler_0 = tempEventHandler_3;
    maxInvoker_1_5.resetNotifier = startOfDayHandler_1;
    minInvoker_5_9.source_TempEventHandler_4 = tempEventHandler_3;
    minInvoker_5_9.resetNotifier = startOfDayHandler_1;
    msgBuilder11_17.source_MaxInvoker_1_10 = maxInvoker_1_5;
    msgBuilder11_17.logLevel = (int) 3;
    msgBuilder11_17.initCapacity = (int) 256;
    msgBuilder13_19.source_MinInvoker_5_12 = minInvoker_5_9;
    msgBuilder13_19.logLevel = (int) 3;
    msgBuilder13_19.initCapacity = (int) 256;
    msgBuilder15_23.source_AvgInvoker_3_14 = avgInvoker_3_7;
    msgBuilder15_23.logNotifier = endOfDayHandler_21;
    msgBuilder15_23.logLevel = (int) 4;
    msgBuilder15_23.initCapacity = (int) 256;
    msgBuilder17_25.source_TempEventHandler_16 = tempEventHandler_3;
    msgBuilder17_25.logNotifier = greaterThanDecorator_7_11;
    msgBuilder17_25.logLevel = (int) 2;
    msgBuilder17_25.initCapacity = (int) 256;
    asciiConsoleLogger_15.initCapacity = (int) 512;
    asciiConsoleLogger_15.msgBuilders = new MsgBuilder[5];
    asciiConsoleLogger_15.msgBuilders[0] = msgBuilder9_13;
    asciiConsoleLogger_15.msgBuilders[1] = msgBuilder11_17;
    asciiConsoleLogger_15.msgBuilders[2] = msgBuilder13_19;
    asciiConsoleLogger_15.msgBuilders[3] = msgBuilder15_23;
    asciiConsoleLogger_15.msgBuilders[4] = msgBuilder17_25;
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
      msgBuilder15_23.postLog(endOfDayHandler_21);
    }
    if (isDirty_endOfDayHandler_21) {
      isDirty_msgBuilder15_23 = msgBuilder15_23.buildMessage();
      if (isDirty_msgBuilder15_23) {
        asciiConsoleLogger_15.publishMessage(msgBuilder15_23);
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
      minInvoker_5_9.reset(startOfDayHandler_1);
    }
    if (isDirty_startOfDayHandler_1) {
      isDirty_msgBuilder9_13 = msgBuilder9_13.buildMessage();
      if (isDirty_msgBuilder9_13) {
        asciiConsoleLogger_15.publishMessage(msgBuilder9_13);
      }
    }
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      isDirty_avgInvoker_3_7 = avgInvoker_3_7.onEvent();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_maxInvoker_1_5 = maxInvoker_1_5.onEvent();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_minInvoker_5_9 = minInvoker_5_9.onEvent();
    }
    if (isDirty_maxInvoker_1_5) {
      isDirty_msgBuilder11_17 = msgBuilder11_17.buildMessage();
      if (isDirty_msgBuilder11_17) {
        asciiConsoleLogger_15.publishMessage(msgBuilder11_17);
      }
    }
    if (isDirty_minInvoker_5_9) {
      isDirty_msgBuilder13_19 = msgBuilder13_19.buildMessage();
      if (isDirty_msgBuilder13_19) {
        asciiConsoleLogger_15.publishMessage(msgBuilder13_19);
      }
    }
    //event stack unwind callbacks
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      avgInvoker_3_7.afterCalculate();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      maxInvoker_1_5.afterCalculate();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      minInvoker_5_9.afterCalculate();
    }
    afterEvent();
  }

  public void handleEvent(TempEvent typedEvent) {
    //Default, no filter methods
    isDirty_tempEventHandler_3 = tempEventHandler_3.handleTempEvent(typedEvent);
    if (isDirty_tempEventHandler_3) {
      avgInvoker_3_7.sourceChange_source_TempEventHandler_2(tempEventHandler_3);
      maxInvoker_1_5.sourceChange_source_TempEventHandler_0(tempEventHandler_3);
      minInvoker_5_9.sourceChange_source_TempEventHandler_4(tempEventHandler_3);
    }
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      isDirty_avgInvoker_3_7 = avgInvoker_3_7.onEvent();
    }
    if (isDirty_tempEventHandler_3) {
      isDirty_greaterThanDecorator_7_11 = greaterThanDecorator_7_11.onEvent();
      if (isDirty_greaterThanDecorator_7_11) {
        msgBuilder17_25.postLog(greaterThanDecorator_7_11);
      }
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_maxInvoker_1_5 = maxInvoker_1_5.onEvent();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      isDirty_minInvoker_5_9 = minInvoker_5_9.onEvent();
    }
    if (isDirty_maxInvoker_1_5) {
      isDirty_msgBuilder11_17 = msgBuilder11_17.buildMessage();
      if (isDirty_msgBuilder11_17) {
        asciiConsoleLogger_15.publishMessage(msgBuilder11_17);
      }
    }
    if (isDirty_minInvoker_5_9) {
      isDirty_msgBuilder13_19 = msgBuilder13_19.buildMessage();
      if (isDirty_msgBuilder13_19) {
        asciiConsoleLogger_15.publishMessage(msgBuilder13_19);
      }
    }
    if (isDirty_greaterThanDecorator_7_11) {
      isDirty_msgBuilder17_25 = msgBuilder17_25.buildMessage();
      if (isDirty_msgBuilder17_25) {
        asciiConsoleLogger_15.publishMessage(msgBuilder17_25);
      }
    }
    //event stack unwind callbacks
    if (isDirty_tempEventHandler_3 | isDirty_startOfDayHandler_1) {
      avgInvoker_3_7.afterCalculate();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      maxInvoker_1_5.afterCalculate();
    }
    if (isDirty_startOfDayHandler_1 | isDirty_tempEventHandler_3) {
      minInvoker_5_9.afterCalculate();
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
    isDirty_msgBuilder9_13 = msgBuilder9_13.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder11_17 = msgBuilder11_17.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder13_19 = msgBuilder13_19.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder15_23 = msgBuilder15_23.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder17_25 = msgBuilder17_25.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder9_13 = msgBuilder9_13.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder11_17 = msgBuilder11_17.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder13_19 = msgBuilder13_19.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder15_23 = msgBuilder15_23.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder17_25 = msgBuilder17_25.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_15.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_15.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_15.controlTimeLogging(typedEvent);
  }

  @Override
  public void afterEvent() {
    msgBuilder17_25.afterEvent();
    msgBuilder15_23.afterEvent();
    msgBuilder13_19.afterEvent();
    msgBuilder11_17.afterEvent();
    msgBuilder9_13.afterEvent();
    isDirty_endOfDayHandler_21 = false;
    isDirty_msgBuilder9_13 = false;
    isDirty_avgInvoker_3_7 = false;
    isDirty_maxInvoker_1_5 = false;
    isDirty_msgBuilder11_17 = false;
    isDirty_msgBuilder15_23 = false;
    isDirty_startOfDayHandler_1 = false;
    isDirty_tempEventHandler_3 = false;
    isDirty_greaterThanDecorator_7_11 = false;
    isDirty_minInvoker_5_9 = false;
    isDirty_msgBuilder13_19 = false;
    isDirty_msgBuilder17_25 = false;
  }

  @Override
  public void init() {
    msgBuilder9_13.init();
    avgInvoker_3_7.init();
    greaterThanDecorator_7_11.init();
    maxInvoker_1_5.init();
    minInvoker_5_9.init();
    msgBuilder11_17.init();
    msgBuilder13_19.init();
    msgBuilder15_23.init();
    msgBuilder17_25.init();
    asciiConsoleLogger_15.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
