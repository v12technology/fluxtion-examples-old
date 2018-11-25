package com.fluxtion.sample.wordfrequency.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.extension.declarative.funclib.api.ascii.ByteBufferDelimiter;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.extension.declarative.funclib.api.event.EofEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class WordFrequencyProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_5 = new AsciiAnyCharMatcher_0();
  private final ByteBufferDelimiter byteBufferDelimiter_0 =
      new ByteBufferDelimiter(" \n", ",.;-_:[]{}()?|&*'\\\"\r");
  private final EofEventHandler eofEventHandler_2 = new EofEventHandler();
  public final GroupBy_2 frequency = new GroupBy_2();
  private final MsgBuilder4 msgBuilder4_3 = new MsgBuilder4();
  private final AsciiConsoleLogger asciiConsoleLogger_4 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_byteBufferDelimiter_0 = false;
  private boolean isDirty_msgBuilder4_3 = false;
  private boolean isDirty_asciiAnyCharMatcher_0_5 = false;
  private boolean isDirty_eofEventHandler_2 = false;
  //Filter constants

  public WordFrequencyProcessor() {
    byteBufferDelimiter_0.delimiterNotifier = asciiAnyCharMatcher_0_5;
    frequency.byteBufferDelimiter0 = byteBufferDelimiter_0;
    msgBuilder4_3.source_GroupBy_2_3 = frequency;
    msgBuilder4_3.logNotifier = eofEventHandler_2;
    msgBuilder4_3.logLevel = (int) 3;
    msgBuilder4_3.initCapacity = (int) 256;
    asciiConsoleLogger_4.initCapacity = (int) 512;
    asciiConsoleLogger_4.msgBuilders = new MsgBuilder[1];
    asciiConsoleLogger_4.msgBuilders[0] = msgBuilder4_3;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (CharEvent.ID):
        {
          CharEvent typedEvent = (CharEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case (EofEvent.ID):
        {
          EofEvent typedEvent = (EofEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
    switch (event.getClass().getName()) {
      case ("com.fluxtion.extension.declarative.api.log.LogControlEvent"):
        {
          LogControlEvent typedEvent = (LogControlEvent) event;
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

  public void handleEvent(CharEvent typedEvent) {
    FilteredHandlerInvoker invoker = dispatchIntMapCharEvent.get(typedEvent.filterId());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    //Default, no filter methods
    isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.appendToBuffer(typedEvent);
    if (isDirty_byteBufferDelimiter_0) {
      frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
    }
    if (isDirty_asciiAnyCharMatcher_0_5) {
      isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.onEvent();
      if (isDirty_byteBufferDelimiter_0) {
        frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_5) {
      byteBufferDelimiter_0.onEventComplete();
    }
    afterEvent();
  }

  public void handleEvent(EofEvent typedEvent) {
    //Default, no filter methods
    isDirty_eofEventHandler_2 = eofEventHandler_2.handleEofEvent(typedEvent);
    if (isDirty_eofEventHandler_2) {
      msgBuilder4_3.postLog(eofEventHandler_2);
    }
    if (isDirty_eofEventHandler_2) {
      isDirty_msgBuilder4_3 = msgBuilder4_3.buildMessage();
      if (isDirty_msgBuilder4_3) {
        asciiConsoleLogger_4.publishMessage(msgBuilder4_3);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }
  //int filter maps
  private final Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchIntMapCharEvent =
      initdispatchIntMapCharEvent();

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

  private Int2ObjectOpenHashMap<FilteredHandlerInvoker> initdispatchIntMapCharEvent() {
    Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchMap = new Int2ObjectOpenHashMap<>();
    dispatchMap.put(
        10,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_10(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        32,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_32(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        0,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_NoFilter(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_LogControlEvent_CHANGE_FILTER(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder4_3 = msgBuilder4_3.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder4_3 = msgBuilder4_3.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_4.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_4.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_4.controlTimeLogging(typedEvent);
  }

  private void handle_CharEvent_10(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_0_5 = asciiAnyCharMatcher_0_5.onChar_newLine(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_5) {
      byteBufferDelimiter_0.onDelimiter(asciiAnyCharMatcher_0_5);
    }
    isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.appendToBuffer(typedEvent);
    if (isDirty_byteBufferDelimiter_0) {
      frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
    }
    if (isDirty_asciiAnyCharMatcher_0_5) {
      isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.onEvent();
      if (isDirty_byteBufferDelimiter_0) {
        frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_5) {
      byteBufferDelimiter_0.onEventComplete();
    }
  }

  private void handle_CharEvent_32(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_0_5 = asciiAnyCharMatcher_0_5.onChar_space(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_5) {
      byteBufferDelimiter_0.onDelimiter(asciiAnyCharMatcher_0_5);
    }
    isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.appendToBuffer(typedEvent);
    if (isDirty_byteBufferDelimiter_0) {
      frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
    }
    if (isDirty_asciiAnyCharMatcher_0_5) {
      isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.onEvent();
      if (isDirty_byteBufferDelimiter_0) {
        frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_5) {
      byteBufferDelimiter_0.onEventComplete();
    }
  }

  private void handle_CharEvent_NoFilter(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.appendToBuffer(typedEvent);
    if (isDirty_byteBufferDelimiter_0) {
      frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
    }
    if (isDirty_asciiAnyCharMatcher_0_5) {
      isDirty_byteBufferDelimiter_0 = byteBufferDelimiter_0.onEvent();
      if (isDirty_byteBufferDelimiter_0) {
        frequency.updatebyteBufferDelimiter0(byteBufferDelimiter_0);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_5) {
      byteBufferDelimiter_0.onEventComplete();
    }
  }

  @Override
  public void afterEvent() {
    msgBuilder4_3.afterEvent();
    isDirty_byteBufferDelimiter_0 = false;
    isDirty_msgBuilder4_3 = false;
    isDirty_asciiAnyCharMatcher_0_5 = false;
    isDirty_eofEventHandler_2 = false;
  }

  @Override
  public void init() {
    byteBufferDelimiter_0.init();
    frequency.init();
    msgBuilder4_3.init();
    asciiConsoleLogger_4.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
