package com.fluxtion.learning.declarative.ext.example5.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.learning.declarative.ext.example4.generated.MatchResulProcessor;
import com.fluxtion.learning.declarative.ext.example5.CountingTest;
import com.fluxtion.learning.declarative.ext.example5.DelegatingEventHandler;
import com.fluxtion.learning.declarative.ext.example5.generated.MsgBuilder0;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.runtime.event.Event;

public class LeaguePublisher implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiConsoleLogger asciiConsoleLogger_14 = new AsciiConsoleLogger();
  private final MatchResulProcessor matchResulProcessor_2 = new MatchResulProcessor();
  private final CountingTest countingTest_8 = new CountingTest();
  private final DelegatingEventHandler delegatingEventHandler_5 = new DelegatingEventHandler();
  private final MsgBuilder0 msgBuilder0_11 = new MsgBuilder0();
  //Dirty flags
  private boolean isDirty_countingTest_8 = false;
  private boolean isDirty_msgBuilder0_11 = false;
  //Filter constants

  public LeaguePublisher() {
    //asciiConsoleLogger_14
    asciiConsoleLogger_14.initCapacity = (int) 512;
    asciiConsoleLogger_14.msgBuilders = new MsgBuilder[1];
    asciiConsoleLogger_14.msgBuilders[0] = msgBuilder0_11;
    //matchResulProcessor_2
    //countingTest_8
    countingTest_8.tracked = matchResulProcessor_2;
    countingTest_8.notifyCountBarrier = (int) 3;
    //delegatingEventHandler_5
    delegatingEventHandler_5.delegate = matchResulProcessor_2;
    //msgBuilder0_11
    msgBuilder0_11.logNotifier = countingTest_8;
    msgBuilder0_11.logLevel = (int) 3;
    msgBuilder0_11.initCapacity = (int) 256;
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
      case ("com.fluxtion.runtime.event.Event"):
        {
          Event typedEvent = (Event) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(LogControlEvent typedEvent) {
    switch (typedEvent.filterString()) {
      case ("CHANGE FILTER"):
        isDirty_msgBuilder0_11 = msgBuilder0_11.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder0_11) {
          asciiConsoleLogger_14.publishMessage(msgBuilder0_11);
        }
        afterEvent();
        return;
      case ("CHANGE LEVEL"):
        isDirty_msgBuilder0_11 = msgBuilder0_11.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder0_11) {
          asciiConsoleLogger_14.publishMessage(msgBuilder0_11);
        }
        afterEvent();
        return;
      case ("RECORD LEVEL"):
        asciiConsoleLogger_14.controlLevelLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD NAME"):
        asciiConsoleLogger_14.controlIdLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD TIME"):
        asciiConsoleLogger_14.controlTimeLogging(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(Event typedEvent) {
    //Default, no filter methods
    delegatingEventHandler_5.onEvent(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    msgBuilder0_11.afterEvent();
    delegatingEventHandler_5.afterEvent();
    isDirty_countingTest_8 = false;
    isDirty_msgBuilder0_11 = false;
  }

  @Override
  public void init() {
    countingTest_8.init();
    msgBuilder0_11.init();
    asciiConsoleLogger_14.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
