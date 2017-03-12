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
  private final AsciiConsoleLogger asciiConsoleLogger_8 = new AsciiConsoleLogger();
  private final MsgBuilder1 msgBuilder1_5 = new MsgBuilder1();
  private final TemperatureEventHandler temperatureEventHandler_2 = new TemperatureEventHandler();
  //Dirty flags
  private boolean isDirty_msgBuilder1_5 = false;
  private boolean isDirty_temperatureEventHandler_2 = false;
  //Filter constants

  public TemperatureProcessor() {
    //asciiConsoleLogger_8
    asciiConsoleLogger_8.initCapacity = (int) 512;
    asciiConsoleLogger_8.msgBuilders = new MsgBuilder[1];
    asciiConsoleLogger_8.msgBuilders[0] = msgBuilder1_5;
    //msgBuilder1_5
    msgBuilder1_5.source_TemperatureEventHandler_0 = temperatureEventHandler_2;
    msgBuilder1_5.logLevel = (int) 3;
    msgBuilder1_5.initCapacity = (int) 256;
    //temperatureEventHandler_2
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
        isDirty_msgBuilder1_5 = msgBuilder1_5.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder1_5) {
          asciiConsoleLogger_8.publishMessage(msgBuilder1_5);
        }
        afterEvent();
        return;
      case ("CHANGE LEVEL"):
        isDirty_msgBuilder1_5 = msgBuilder1_5.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder1_5) {
          asciiConsoleLogger_8.publishMessage(msgBuilder1_5);
        }
        afterEvent();
        return;
      case ("RECORD LEVEL"):
        asciiConsoleLogger_8.controlLevelLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD NAME"):
        asciiConsoleLogger_8.controlIdLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD TIME"):
        asciiConsoleLogger_8.controlTimeLogging(typedEvent);
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
