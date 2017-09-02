package com.fluxtion.learning.functional.example1.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.functional.example1.generated.TemperatureEventHandler;
import com.fluxtion.learning.functional.example1.generated.MsgBuilder1;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.learning.functional.TemperatureEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final TemperatureEventHandler temperatureEventHandler_2 = new TemperatureEventHandler();
  private final MsgBuilder1 msgBuilder1_5 = new MsgBuilder1();
  private final AsciiConsoleLogger asciiConsoleLogger_8 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_msgBuilder1_5 = false;
  private boolean isDirty_temperatureEventHandler_2 = false;
  //Filter constants

  public TemperatureProcessor() {
    asciiConsoleLogger_8.initCapacity = (int) 512;
    asciiConsoleLogger_8.msgBuilders = new MsgBuilder[1];
    asciiConsoleLogger_8.msgBuilders[0] = msgBuilder1_5;
    msgBuilder1_5.source_TemperatureEventHandler_0 = temperatureEventHandler_2;
    msgBuilder1_5.logLevel = (int) 3;
    msgBuilder1_5.initCapacity = (int) 256;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.extension.declarative.api.log.LogControlEvent"):
        {
          LogControlEvent typedEvent = (LogControlEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.functional.TemperatureEvent"):
        {
          TemperatureEvent typedEvent = (TemperatureEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
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

  public void handleEvent(TemperatureEvent typedEvent) {
    //Default, no filter methods
    isDirty_temperatureEventHandler_2 =
        temperatureEventHandler_2.handleTemperatureEvent(typedEvent);
    if (isDirty_temperatureEventHandler_2) {
      isDirty_msgBuilder1_5 = msgBuilder1_5.buildMessage();
      if (isDirty_msgBuilder1_5) {
        asciiConsoleLogger_8.publishMessage(msgBuilder1_5);
      }
    }
    //event stack unwind callbacks
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
    isDirty_msgBuilder1_5 = msgBuilder1_5.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder1_5 = msgBuilder1_5.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_8.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_8.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_8.controlTimeLogging(typedEvent);
  }

  @Override
  public void afterEvent() {
    msgBuilder1_5.afterEvent();
    isDirty_msgBuilder1_5 = false;
    isDirty_temperatureEventHandler_2 = false;
  }

  @Override
  public void init() {
    msgBuilder1_5.init();
    asciiConsoleLogger_8.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
