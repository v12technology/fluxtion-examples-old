package com.fluxtion.casestudy.flightdelay.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.flightdelay.generated.AsciiAnyCharMatcher_1;
import com.fluxtion.casestudy.flightdelay.generated.AsciiAnyCharMatcher_0;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.casestudy.flightdelay.generated.FlightDetailsCsvMarshaller2;
import com.fluxtion.casestudy.flightdelay.FlightDetailsSink;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;

public class CsvToBinaryFlightData implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiAnyCharMatcher_1 asciiAnyCharMatcher_1_9 = new AsciiAnyCharMatcher_1();
  private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_8 = new AsciiAnyCharMatcher_0();
  private final Csv2ByteBuffer csv2ByteBuffer_5 = new Csv2ByteBuffer();
  private final Csv2Double csv2Double_3 = new Csv2Double();
  private final FlightDetailsCsvMarshaller2 flightDetailsCsvMarshaller2_7 =
      new FlightDetailsCsvMarshaller2();
  private final FlightDetailsSink flightDetailsSink_1 =
      new FlightDetailsSink(flightDetailsCsvMarshaller2_7);
  //Dirty flags
  private boolean isDirty_asciiAnyCharMatcher_1_9 = false;
  private boolean isDirty_asciiAnyCharMatcher_0_8 = false;
  private boolean isDirty_csv2ByteBuffer_5 = false;
  private boolean isDirty_csv2Double_3 = false;
  private boolean isDirty_flightDetailsCsvMarshaller2_7 = false;
  //Filter constants

  public CsvToBinaryFlightData() {
    csv2ByteBuffer_5.fieldNumber = (int) 8;
    csv2ByteBuffer_5.headerLines = (int) 1;
    csv2ByteBuffer_5.eolNotifier = asciiAnyCharMatcher_1_9;
    csv2ByteBuffer_5.delimiterNotifier = asciiAnyCharMatcher_0_8;
    csv2Double_3.fieldNumber = (int) 14;
    csv2Double_3.headerLines = (int) 1;
    csv2Double_3.delimiterNotifier = asciiAnyCharMatcher_0_8;
    flightDetailsCsvMarshaller2_7.csvSrc_0 = csv2Double_3;
    flightDetailsCsvMarshaller2_7.csvSrc_1 = csv2ByteBuffer_5;
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
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
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
    isDirty_asciiAnyCharMatcher_1_9 = asciiAnyCharMatcher_1_9.onChar_newLine(typedEvent);
    if (isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEol(asciiAnyCharMatcher_1_9);
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.onEol(typedEvent);
    isDirty_flightDetailsCsvMarshaller2_7 = flightDetailsCsvMarshaller2_7.onEol(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_44(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_0_8 = asciiAnyCharMatcher_0_8.onChar_44(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8) {
      csv2ByteBuffer_5.onDelimiter(asciiAnyCharMatcher_0_8);
      csv2Double_3.onDelimiter(asciiAnyCharMatcher_0_8);
    }
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_45(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.onSign(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_46(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.onDecimalPoint(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_48(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_0(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_49(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_1(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_50(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_2(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_51(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_3(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_52(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_4(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_53(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_5(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_54(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_6(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_55(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_7(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_56(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_8(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_57(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    isDirty_csv2Double_3 = csv2Double_3.on_9(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  private void handle_CharEvent_NoFilter(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    if (isDirty_flightDetailsCsvMarshaller2_7) {
      flightDetailsSink_1.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_8 | isDirty_asciiAnyCharMatcher_1_9) {
      csv2ByteBuffer_5.onEventComplete();
    }
  }

  @Override
  public void afterEvent() {

    isDirty_asciiAnyCharMatcher_1_9 = false;
    isDirty_asciiAnyCharMatcher_0_8 = false;
    isDirty_csv2ByteBuffer_5 = false;
    isDirty_csv2Double_3 = false;
    isDirty_flightDetailsCsvMarshaller2_7 = false;
  }

  @Override
  public void init() {
    csv2ByteBuffer_5.init();
    csv2Double_3.init();
    flightDetailsCsvMarshaller2_7.init();
    flightDetailsSink_1.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}