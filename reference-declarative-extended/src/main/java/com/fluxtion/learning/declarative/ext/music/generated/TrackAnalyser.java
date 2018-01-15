package com.fluxtion.learning.declarative.ext.music.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.declarative.ext.music.generated.AsciiAnyCharMatcher_1;
import com.fluxtion.learning.declarative.ext.music.generated.AsciiAnyCharMatcher_0;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.learning.declarative.ext.music.generated.TrackStreamCsvMarshaller7;
import com.fluxtion.learning.declarative.ext.music.generated.GroupBy_11;
import com.fluxtion.learning.declarative.ext.music.generated.MsgBuilder13;
import com.fluxtion.learning.declarative.ext.music.generated.MsgBuilder15;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class TrackAnalyser implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiAnyCharMatcher_1 asciiAnyCharMatcher_1_37 = new AsciiAnyCharMatcher_1();
  private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_36 = new AsciiAnyCharMatcher_0();
  private final Csv2ByteBuffer csv2ByteBuffer_2 = new Csv2ByteBuffer();
  private final Csv2ByteBuffer csv2ByteBuffer_5 = new Csv2ByteBuffer();
  private final Csv2ByteBuffer csv2ByteBuffer_8 = new Csv2ByteBuffer();
  private final Csv2ByteBuffer csv2ByteBuffer_11 = new Csv2ByteBuffer();
  private final Csv2ByteBuffer csv2ByteBuffer_14 = new Csv2ByteBuffer();
  private final Csv2ByteBuffer csv2ByteBuffer_17 = new Csv2ByteBuffer();
  private final Csv2Double csv2Double_20 = new Csv2Double();
  private final TrackStreamCsvMarshaller7 trackStreamCsvMarshaller7_23 =
      new TrackStreamCsvMarshaller7();
  private final GroupBy_11 groupBy_11_26 = new GroupBy_11();
  private final MsgBuilder13 msgBuilder13_29 = new MsgBuilder13();
  private final MsgBuilder15 msgBuilder15_35 = new MsgBuilder15();
  private final AsciiConsoleLogger asciiConsoleLogger_32 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_asciiAnyCharMatcher_1_37 = false;
  private boolean isDirty_csv2ByteBuffer_2 = false;
  private boolean isDirty_csv2ByteBuffer_8 = false;
  private boolean isDirty_csv2Double_20 = false;
  private boolean isDirty_trackStreamCsvMarshaller7_23 = false;
  private boolean isDirty_asciiAnyCharMatcher_0_36 = false;
  private boolean isDirty_csv2ByteBuffer_5 = false;
  private boolean isDirty_csv2ByteBuffer_11 = false;
  private boolean isDirty_csv2ByteBuffer_14 = false;
  private boolean isDirty_csv2ByteBuffer_17 = false;
  private boolean isDirty_groupBy_11_26 = false;
  private boolean isDirty_msgBuilder13_29 = false;
  private boolean isDirty_msgBuilder15_35 = false;
  //Filter constants

  public TrackAnalyser() {
    csv2ByteBuffer_2.fieldNumber = (int) 0;
    csv2ByteBuffer_2.headerLines = (int) 0;
    csv2ByteBuffer_2.eolNotifier = asciiAnyCharMatcher_1_37;
    csv2ByteBuffer_2.delimiterNotifier = asciiAnyCharMatcher_0_36;
    csv2ByteBuffer_5.fieldNumber = (int) 1;
    csv2ByteBuffer_5.headerLines = (int) 0;
    csv2ByteBuffer_5.eolNotifier = asciiAnyCharMatcher_1_37;
    csv2ByteBuffer_5.delimiterNotifier = asciiAnyCharMatcher_0_36;
    csv2ByteBuffer_8.fieldNumber = (int) 2;
    csv2ByteBuffer_8.headerLines = (int) 0;
    csv2ByteBuffer_8.eolNotifier = asciiAnyCharMatcher_1_37;
    csv2ByteBuffer_8.delimiterNotifier = asciiAnyCharMatcher_0_36;
    csv2ByteBuffer_11.fieldNumber = (int) 3;
    csv2ByteBuffer_11.headerLines = (int) 0;
    csv2ByteBuffer_11.eolNotifier = asciiAnyCharMatcher_1_37;
    csv2ByteBuffer_11.delimiterNotifier = asciiAnyCharMatcher_0_36;
    csv2ByteBuffer_14.fieldNumber = (int) 4;
    csv2ByteBuffer_14.headerLines = (int) 0;
    csv2ByteBuffer_14.eolNotifier = asciiAnyCharMatcher_1_37;
    csv2ByteBuffer_14.delimiterNotifier = asciiAnyCharMatcher_0_36;
    csv2ByteBuffer_17.fieldNumber = (int) 5;
    csv2ByteBuffer_17.headerLines = (int) 0;
    csv2ByteBuffer_17.eolNotifier = asciiAnyCharMatcher_1_37;
    csv2ByteBuffer_17.delimiterNotifier = asciiAnyCharMatcher_0_36;
    csv2Double_20.fieldNumber = (int) 6;
    csv2Double_20.headerLines = (int) 0;
    csv2Double_20.delimiterNotifier = asciiAnyCharMatcher_0_36;
    trackStreamCsvMarshaller7_23.csvSrc_0 = csv2ByteBuffer_2;
    trackStreamCsvMarshaller7_23.csvSrc_1 = csv2ByteBuffer_5;
    trackStreamCsvMarshaller7_23.csvSrc_2 = csv2ByteBuffer_8;
    trackStreamCsvMarshaller7_23.csvSrc_3 = csv2ByteBuffer_11;
    trackStreamCsvMarshaller7_23.csvSrc_4 = csv2ByteBuffer_14;
    trackStreamCsvMarshaller7_23.csvSrc_5 = csv2ByteBuffer_17;
    trackStreamCsvMarshaller7_23.csvSrc_6 = csv2Double_20;
    groupBy_11_26.trackStreamCsvMarshaller70 = trackStreamCsvMarshaller7_23;
    msgBuilder13_29.source_TrackStreamCsvMarshaller7_12 = trackStreamCsvMarshaller7_23;
    msgBuilder13_29.logLevel = (int) 3;
    msgBuilder13_29.initCapacity = (int) 256;
    msgBuilder15_35.source_GroupBy_11_14 = groupBy_11_26;
    msgBuilder15_35.logLevel = (int) 3;
    msgBuilder15_35.initCapacity = (int) 256;
    asciiConsoleLogger_32.initCapacity = (int) 512;
    asciiConsoleLogger_32.msgBuilders = new MsgBuilder[2];
    asciiConsoleLogger_32.msgBuilders[0] = msgBuilder13_29;
    asciiConsoleLogger_32.msgBuilders[1] = msgBuilder15_35;
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
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
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
        44,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_44(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        45,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_45(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        46,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_46(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        48,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_48(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        49,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_49(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        50,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_50(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        51,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_51(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        52,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_52(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        53,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_53(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        54,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_54(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        55,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_55(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        56,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_56(
                (com.fluxtion.extension.declarative.funclib.api.event.CharEvent) event);
          }
        });
    dispatchMap.put(
        57,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_57(
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
    isDirty_msgBuilder13_29 = msgBuilder13_29.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder15_35 = msgBuilder15_35.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder13_29 = msgBuilder13_29.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder15_35 = msgBuilder15_35.controlLogLevelFilter(typedEvent);
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

  private void handle_CharEvent_10(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_1_37 = asciiAnyCharMatcher_1_37.onChar_newLine(typedEvent);
    if (isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEol(asciiAnyCharMatcher_1_37);
      csv2ByteBuffer_5.onEol(asciiAnyCharMatcher_1_37);
      csv2ByteBuffer_8.onEol(asciiAnyCharMatcher_1_37);
      csv2ByteBuffer_11.onEol(asciiAnyCharMatcher_1_37);
      csv2ByteBuffer_14.onEol(asciiAnyCharMatcher_1_37);
      csv2ByteBuffer_17.onEol(asciiAnyCharMatcher_1_37);
    }
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.onEol(typedEvent);
    isDirty_trackStreamCsvMarshaller7_23 = trackStreamCsvMarshaller7_23.onEol(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      groupBy_11_26.updatetrackStreamCsvMarshaller70(trackStreamCsvMarshaller7_23);
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_44(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_0_36 = asciiAnyCharMatcher_0_36.onChar_44(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36) {
      csv2ByteBuffer_2.onDelimiter(asciiAnyCharMatcher_0_36);
      csv2ByteBuffer_5.onDelimiter(asciiAnyCharMatcher_0_36);
      csv2ByteBuffer_8.onDelimiter(asciiAnyCharMatcher_0_36);
      csv2ByteBuffer_11.onDelimiter(asciiAnyCharMatcher_0_36);
      csv2ByteBuffer_14.onDelimiter(asciiAnyCharMatcher_0_36);
      csv2ByteBuffer_17.onDelimiter(asciiAnyCharMatcher_0_36);
      csv2Double_20.onDelimiter(asciiAnyCharMatcher_0_36);
    }
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_45(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.onSign(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_46(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.onDecimalPoint(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_48(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_0(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_49(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_1(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_50(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_2(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_51(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_3(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_52(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_4(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_53(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_5(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_54(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_6(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_55(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_7(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_56(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_8(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_57(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    isDirty_csv2Double_20 = csv2Double_20.on_9(typedEvent);
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_NoFilter(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_11 = csv2ByteBuffer_11.onEvent();
    }
    isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_14 = csv2ByteBuffer_14.onEvent();
    }
    isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      isDirty_csv2ByteBuffer_17 = csv2ByteBuffer_17.onEvent();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_groupBy_11_26 = groupBy_11_26.updated();
    }
    if (isDirty_trackStreamCsvMarshaller7_23) {
      isDirty_msgBuilder13_29 = msgBuilder13_29.buildMessage();
      if (isDirty_msgBuilder13_29) {
        asciiConsoleLogger_32.publishMessage(msgBuilder13_29);
      }
    }
    if (isDirty_groupBy_11_26) {
      isDirty_msgBuilder15_35 = msgBuilder15_35.buildMessage();
      if (isDirty_msgBuilder15_35) {
        asciiConsoleLogger_32.publishMessage(msgBuilder15_35);
      }
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_2.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_5.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_11.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_14.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_36 | isDirty_asciiAnyCharMatcher_1_37) {
      csv2ByteBuffer_17.onEventComplete();
    }
  }

  @Override
  public void afterEvent() {
    msgBuilder15_35.afterEvent();
    msgBuilder13_29.afterEvent();
    isDirty_asciiAnyCharMatcher_1_37 = false;
    isDirty_csv2ByteBuffer_2 = false;
    isDirty_csv2ByteBuffer_8 = false;
    isDirty_csv2Double_20 = false;
    isDirty_trackStreamCsvMarshaller7_23 = false;
    isDirty_asciiAnyCharMatcher_0_36 = false;
    isDirty_csv2ByteBuffer_5 = false;
    isDirty_csv2ByteBuffer_11 = false;
    isDirty_csv2ByteBuffer_14 = false;
    isDirty_csv2ByteBuffer_17 = false;
    isDirty_groupBy_11_26 = false;
    isDirty_msgBuilder13_29 = false;
    isDirty_msgBuilder15_35 = false;
  }

  @Override
  public void init() {
    csv2ByteBuffer_2.init();
    csv2ByteBuffer_5.init();
    csv2ByteBuffer_8.init();
    csv2ByteBuffer_11.init();
    csv2ByteBuffer_14.init();
    csv2ByteBuffer_17.init();
    csv2Double_20.init();
    trackStreamCsvMarshaller7_23.init();
    groupBy_11_26.init();
    msgBuilder13_29.init();
    msgBuilder15_35.init();
    asciiConsoleLogger_32.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
