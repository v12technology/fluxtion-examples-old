package com.fluxtion.learning.functional.example1.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.learning.functional.example1.generated.MsgBuilder1;
import com.fluxtion.learning.functional.example1.generated.TemperatureEventHandler;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.learning.functional.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiConsoleLogger asciiConsoleLogger_5 = new AsciiConsoleLogger();
  private final MsgBuilder1 msgBuilder1_3 = new MsgBuilder1();
  private final TemperatureEventHandler temperatureEventHandler_1 = new TemperatureEventHandler();
  //Dirty flags
  private boolean isDirty_msgBuilder1_3 = false;
  private boolean isDirty_temperatureEventHandler_1 = false;
  //Filter constants

  public TemperatureProcessor() {
    //asciiConsoleLogger_5
    asciiConsoleLogger_5.initCapacity = (int) 512;
    asciiConsoleLogger_5.msgBuilders = new MsgBuilder[1];
    asciiConsoleLogger_5.msgBuilders[0] = msgBuilder1_3;
    //msgBuilder1_3
    msgBuilder1_3.source_TemperatureEventHandler_0 = temperatureEventHandler_1;
    msgBuilder1_3.logLevel = (int) 3;
    msgBuilder1_3.initCapacity = (int) 256;
    //temperatureEventHandler_1
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
    switch (typedEvent.filterString()) {
      case ("CHANGE FILTER"):
        isDirty_msgBuilder1_3 = msgBuilder1_3.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder1_3) {
          asciiConsoleLogger_5.publishMessage(msgBuilder1_3);
        }
        afterEvent();
        return;
      case ("CHANGE LEVEL"):
        isDirty_msgBuilder1_3 = msgBuilder1_3.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder1_3) {
          asciiConsoleLogger_5.publishMessage(msgBuilder1_3);
        }
        afterEvent();
        return;
      case ("RECORD LEVEL"):
        asciiConsoleLogger_5.controlLevelLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD NAME"):
        asciiConsoleLogger_5.controlIdLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD TIME"):
        asciiConsoleLogger_5.controlTimeLogging(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(TemperatureEvent typedEvent) {
    //Default, no filter methods
    isDirty_temperatureEventHandler_1 =
        temperatureEventHandler_1.handleTemperatureEvent(typedEvent);
    if (isDirty_temperatureEventHandler_1) {
      isDirty_msgBuilder1_3 = msgBuilder1_3.buildMessage();
      if (isDirty_msgBuilder1_3) {
        asciiConsoleLogger_5.publishMessage(msgBuilder1_3);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    msgBuilder1_3.afterEvent();
    isDirty_msgBuilder1_3 = false;
    isDirty_temperatureEventHandler_1 = false;
  }

  @Override
  public void init() {
    msgBuilder1_3.init();
    asciiConsoleLogger_5.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
