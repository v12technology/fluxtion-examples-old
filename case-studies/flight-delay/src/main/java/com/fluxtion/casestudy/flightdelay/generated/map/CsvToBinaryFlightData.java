package com.fluxtion.casestudy.flightdelay.generated.map;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.flightdelay.generated.map.AsciiAnyCharMatcher_1;
import com.fluxtion.casestudy.flightdelay.generated.map.AsciiAnyCharMatcher_0;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.casestudy.flightdelay.generated.map.FlightDetailsCsvMarshaller2;
import com.fluxtion.casestudy.flightdelay.FlightDetailsSink;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;

public class CsvToBinaryFlightData implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiAnyCharMatcher_1 asciiAnyCharMatcher_1_7 = new AsciiAnyCharMatcher_1();
  private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_6 = new AsciiAnyCharMatcher_0();
  private final Csv2ByteBuffer csv2ByteBuffer_3 = new Csv2ByteBuffer();
  private final Csv2Double csv2Double_1 = new Csv2Double();
  private final FlightDetailsCsvMarshaller2 flightDetailsCsvMarshaller2_5 =
      new FlightDetailsCsvMarshaller2();
  public final FlightDetailsSink chronicleSink =
      new FlightDetailsSink(flightDetailsCsvMarshaller2_5);
  //Dirty flags
  private boolean isDirty_asciiAnyCharMatcher_1_7 = false;
  private boolean isDirty_asciiAnyCharMatcher_0_6 = false;
  private boolean isDirty_csv2ByteBuffer_3 = false;
  private boolean isDirty_csv2Double_1 = false;
  private boolean isDirty_flightDetailsCsvMarshaller2_5 = false;
  //Filter constants

  public CsvToBinaryFlightData() {
    csv2ByteBuffer_3.fieldNumber = (int) 8;
    csv2ByteBuffer_3.headerLines = (int) 1;
    csv2ByteBuffer_3.eolNotifier = asciiAnyCharMatcher_1_7;
    csv2ByteBuffer_3.delimiterNotifier = asciiAnyCharMatcher_0_6;
    csv2Double_1.fieldNumber = (int) 14;
    csv2Double_1.headerLines = (int) 1;
    csv2Double_1.delimiterNotifier = asciiAnyCharMatcher_0_6;
    flightDetailsCsvMarshaller2_5.csvSrc_0 = csv2Double_1;
    flightDetailsCsvMarshaller2_5.csvSrc_1 = csv2ByteBuffer_3;
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
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
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
    isDirty_asciiAnyCharMatcher_1_7 = asciiAnyCharMatcher_1_7.onChar_newLine(typedEvent);
    if (isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEol(asciiAnyCharMatcher_1_7);
    }
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.onEol(typedEvent);
    isDirty_flightDetailsCsvMarshaller2_5 = flightDetailsCsvMarshaller2_5.onEol(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_44(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_asciiAnyCharMatcher_0_6 = asciiAnyCharMatcher_0_6.onChar_44(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6) {
      csv2ByteBuffer_3.onDelimiter(asciiAnyCharMatcher_0_6);
      csv2Double_1.onDelimiter(asciiAnyCharMatcher_0_6);
    }
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_45(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.onSign(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_46(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.onDecimalPoint(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_48(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_0(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_49(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_1(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_50(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_2(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_51(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_3(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_52(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_4(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_53(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_5(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_54(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_6(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_55(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_7(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_56(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_8(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_57(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    isDirty_csv2Double_1 = csv2Double_1.on_9(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  private void handle_CharEvent_NoFilter(
      com.fluxtion.extension.declarative.funclib.api.event.CharEvent typedEvent) {
    //method body - invoke call tree
    isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      isDirty_csv2ByteBuffer_3 = csv2ByteBuffer_3.onEvent();
    }
    if (isDirty_flightDetailsCsvMarshaller2_5) {
      chronicleSink.writeFlightDetails();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_6 | isDirty_asciiAnyCharMatcher_1_7) {
      csv2ByteBuffer_3.onEventComplete();
    }
  }

  @Override
  public void afterEvent() {

    isDirty_asciiAnyCharMatcher_1_7 = false;
    isDirty_asciiAnyCharMatcher_0_6 = false;
    isDirty_csv2ByteBuffer_3 = false;
    isDirty_csv2Double_1 = false;
    isDirty_flightDetailsCsvMarshaller2_5 = false;
  }

  @Override
  public void init() {
    csv2ByteBuffer_3.init();
    csv2Double_1.init();
    flightDetailsCsvMarshaller2_5.init();
    chronicleSink.init();
  }

  @Override
  public void tearDown() {
    chronicleSink.close();
  }

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
