package com.fluxtion.learning.declarative.ext.example4.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.declarative.ext.example4.generated.AsciiAnyCharMatcher_1;
import com.fluxtion.learning.declarative.ext.example4.generated.AsciiAnyCharMatcher_0;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.learning.declarative.ext.example4.generated.MatchResultCsvMarshaller4;
import com.fluxtion.learning.declarative.ext.example4.generated.GroupBy_19;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;

public class MatchResulProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiAnyCharMatcher_1 asciiAnyCharMatcher_1_19 = new AsciiAnyCharMatcher_1();
  private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_18 = new AsciiAnyCharMatcher_0();
  private final Csv2ByteBuffer csv2ByteBuffer_2 = new Csv2ByteBuffer();
  private final Csv2ByteBuffer csv2ByteBuffer_8 = new Csv2ByteBuffer();
  private final Csv2Double csv2Double_5 = new Csv2Double();
  private final Csv2Double csv2Double_11 = new Csv2Double();
  private final MatchResultCsvMarshaller4 matchResultCsvMarshaller4_14 =
      new MatchResultCsvMarshaller4();
  public final GroupBy_19 leagueSummary = new GroupBy_19();
  //Dirty flags
  private boolean isDirty_asciiAnyCharMatcher_1_19 = false;
  private boolean isDirty_asciiAnyCharMatcher_0_18 = false;
  private boolean isDirty_csv2ByteBuffer_2 = false;
  private boolean isDirty_csv2ByteBuffer_8 = false;
  private boolean isDirty_csv2Double_5 = false;
  private boolean isDirty_csv2Double_11 = false;
  private boolean isDirty_matchResultCsvMarshaller4_14 = false;
  private boolean isDirty_leagueSummary = false;
  //Filter constants

  public MatchResulProcessor() {
    csv2ByteBuffer_2.fieldNumber = (int) 0;
    csv2ByteBuffer_2.headerLines = (int) 1;
    csv2ByteBuffer_2.eolNotifier = asciiAnyCharMatcher_1_19;
    csv2ByteBuffer_2.delimiterNotifier = asciiAnyCharMatcher_0_18;
    csv2ByteBuffer_8.fieldNumber = (int) 3;
    csv2ByteBuffer_8.headerLines = (int) 1;
    csv2ByteBuffer_8.eolNotifier = asciiAnyCharMatcher_1_19;
    csv2ByteBuffer_8.delimiterNotifier = asciiAnyCharMatcher_0_18;
    csv2Double_5.fieldNumber = (int) 1;
    csv2Double_5.headerLines = (int) 1;
    csv2Double_5.delimiterNotifier = asciiAnyCharMatcher_0_18;
    csv2Double_11.fieldNumber = (int) 2;
    csv2Double_11.headerLines = (int) 1;
    csv2Double_11.delimiterNotifier = asciiAnyCharMatcher_0_18;
    matchResultCsvMarshaller4_14.csvSrc_0 = csv2ByteBuffer_2;
    matchResultCsvMarshaller4_14.csvSrc_1 = csv2Double_5;
    matchResultCsvMarshaller4_14.csvSrc_2 = csv2ByteBuffer_8;
    matchResultCsvMarshaller4_14.csvSrc_3 = csv2Double_11;
    leagueSummary.matchResultCsvMarshaller40 = matchResultCsvMarshaller4_14;
    leagueSummary.matchResultCsvMarshaller41 = matchResultCsvMarshaller4_14;
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
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    afterEvent();
  }

  //int filter maps
  private final Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchIntMapCharEvent =
      initdispatchIntMapCharEvent();

  //String filter maps
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

  private void handle_CharEvent_10(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_1_19 = asciiAnyCharMatcher_1_19.onChar_newLine(typedEvent);
    if (isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEol(asciiAnyCharMatcher_1_19);
      csv2ByteBuffer_8.onEol(asciiAnyCharMatcher_1_19);
    }
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.onEol(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.onEol(typedEvent);
    isDirty_matchResultCsvMarshaller4_14 = matchResultCsvMarshaller4_14.onEol(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      leagueSummary.updatematchResultCsvMarshaller40(matchResultCsvMarshaller4_14);
      leagueSummary.updatematchResultCsvMarshaller41(matchResultCsvMarshaller4_14);
    }
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_44(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_0_18 = asciiAnyCharMatcher_0_18.onChar_44(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18) {
      csv2ByteBuffer_2.onDelimiter(asciiAnyCharMatcher_0_18);
      csv2ByteBuffer_8.onDelimiter(asciiAnyCharMatcher_0_18);
      csv2Double_5.onDelimiter(asciiAnyCharMatcher_0_18);
      csv2Double_11.onDelimiter(asciiAnyCharMatcher_0_18);
    }
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_45(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.onSign(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.onSign(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_46(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.onDecimalPoint(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.onDecimalPoint(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_48(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_0(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_0(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_49(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_1(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_1(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_50(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_2(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_2(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_51(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_3(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_3(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_52(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_4(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_4(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_53(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_5(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_5(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_54(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_6(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_6(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_55(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_7(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_7(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_56(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_8(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_8(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_57(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    isDirty_csv2Double_5 = csv2Double_5.on_9(typedEvent);
    isDirty_csv2Double_11 = csv2Double_11.on_9(typedEvent);
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
  }

  private void handle_CharEvent_NoFilter(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 | isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
  }

  @Override
  public void afterEvent() {

    isDirty_asciiAnyCharMatcher_1_19 = false;
    isDirty_asciiAnyCharMatcher_0_18 = false;
    isDirty_csv2ByteBuffer_2 = false;
    isDirty_csv2ByteBuffer_8 = false;
    isDirty_csv2Double_5 = false;
    isDirty_csv2Double_11 = false;
    isDirty_matchResultCsvMarshaller4_14 = false;
    isDirty_leagueSummary = false;
  }

  @Override
  public void init() {
    csv2ByteBuffer_2.init();
    csv2ByteBuffer_8.init();
    csv2Double_5.init();
    csv2Double_11.init();
    matchResultCsvMarshaller4_14.init();
    leagueSummary.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
