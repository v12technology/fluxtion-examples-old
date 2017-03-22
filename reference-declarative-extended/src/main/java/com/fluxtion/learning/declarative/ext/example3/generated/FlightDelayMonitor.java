package com.fluxtion.learning.declarative.ext.example3.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.learning.declarative.ext.example3.generated.AsciiAnyCharMatcher_1;
import com.fluxtion.learning.declarative.ext.example3.generated.AsciiAnyCharMatcher_0;
import com.fluxtion.learning.declarative.ext.example3.generated.FlightDetailsCsvMarshaller2;
import com.fluxtion.learning.declarative.ext.example3.generated.GreaterThanDecorator_4;
import com.fluxtion.learning.declarative.ext.example3.generated.GroupBy_9;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;

public class FlightDelayMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final Csv2ByteBuffer csv2ByteBuffer_5 = new Csv2ByteBuffer();
  private final Csv2Double csv2Double_2 = new Csv2Double();
  private final AsciiAnyCharMatcher_1 asciiAnyCharMatcher_1_16 = new AsciiAnyCharMatcher_1();
  private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_15 = new AsciiAnyCharMatcher_0();
  private final FlightDetailsCsvMarshaller2 flightDetailsCsvMarshaller2_8 =
      new FlightDetailsCsvMarshaller2();
  private final GreaterThanDecorator_4 greaterThanDecorator_4_11 = new GreaterThanDecorator_4();
  public final GroupBy_9 carrierDelayMap = new GroupBy_9();
  //Dirty flags
  private boolean isDirty_csv2ByteBuffer_5 = false;
  private boolean isDirty_csv2Double_2 = false;
  private boolean isDirty_asciiAnyCharMatcher_1_16 = false;
  private boolean isDirty_asciiAnyCharMatcher_0_15 = false;
  private boolean isDirty_flightDetailsCsvMarshaller2_8 = false;
  private boolean isDirty_greaterThanDecorator_4_11 = false;
  private boolean isDirty_carrierDelayMap = false;
  //Filter constants

  public FlightDelayMonitor() {
    //csv2ByteBuffer_5
    csv2ByteBuffer_5.fieldNumber = (int) 8;
    csv2ByteBuffer_5.headerLines = (int) 1;
    csv2ByteBuffer_5.eolNotifier = asciiAnyCharMatcher_1_16;
    csv2ByteBuffer_5.delimiterNotifier = asciiAnyCharMatcher_0_15;
    //csv2Double_2
    csv2Double_2.fieldNumber = (int) 14;
    csv2Double_2.headerLines = (int) 1;
    csv2Double_2.delimiterNotifier = asciiAnyCharMatcher_0_15;
    //asciiAnyCharMatcher_1_16
    //asciiAnyCharMatcher_0_15
    //flightDetailsCsvMarshaller2_8
    flightDetailsCsvMarshaller2_8.csvSrc_0 = csv2Double_2;
    flightDetailsCsvMarshaller2_8.csvSrc_1 = csv2ByteBuffer_5;
    //greaterThanDecorator_4_11
    greaterThanDecorator_4_11.filterSubject = flightDetailsCsvMarshaller2_8;
    greaterThanDecorator_4_11.source_FlightDetailsCsvMarshaller2_3 = flightDetailsCsvMarshaller2_8;
    //carrierDelayMap
    carrierDelayMap.greaterThanDecorator_40 = greaterThanDecorator_4_11;
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
    switch (typedEvent.filterId()) {
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[10]
      case (10):
        isDirty_asciiAnyCharMatcher_1_16 = asciiAnyCharMatcher_1_16.onChar_newLine(typedEvent);
        if (isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEol(asciiAnyCharMatcher_1_16);
        }
        isDirty_csv2Double_2 = csv2Double_2.onEol(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        isDirty_flightDetailsCsvMarshaller2_8 = flightDetailsCsvMarshaller2_8.onEol(typedEvent);
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[44]
      case (44):
        isDirty_asciiAnyCharMatcher_0_15 = asciiAnyCharMatcher_0_15.onChar_44(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15) {
          csv2Double_2.onDelimiter(asciiAnyCharMatcher_0_15);
          csv2ByteBuffer_5.onDelimiter(asciiAnyCharMatcher_0_15);
        }
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[45]
      case (45):
        isDirty_csv2Double_2 = csv2Double_2.onSign(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[46]
      case (46):
        isDirty_csv2Double_2 = csv2Double_2.onDecimalPoint(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[48]
      case (48):
        isDirty_csv2Double_2 = csv2Double_2.on_0(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[49]
      case (49):
        isDirty_csv2Double_2 = csv2Double_2.on_1(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[50]
      case (50):
        isDirty_csv2Double_2 = csv2Double_2.on_2(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[51]
      case (51):
        isDirty_csv2Double_2 = csv2Double_2.on_3(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[52]
      case (52):
        isDirty_csv2Double_2 = csv2Double_2.on_4(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[53]
      case (53):
        isDirty_csv2Double_2 = csv2Double_2.on_5(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[54]
      case (54):
        isDirty_csv2Double_2 = csv2Double_2.on_6(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[55]
      case (55):
        isDirty_csv2Double_2 = csv2Double_2.on_7(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[56]
      case (56):
        isDirty_csv2Double_2 = csv2Double_2.on_8(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[57]
      case (57):
        isDirty_csv2Double_2 = csv2Double_2.on_9(typedEvent);
        isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
        }
        if (isDirty_flightDetailsCsvMarshaller2_8) {
          isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
          if (isDirty_greaterThanDecorator_4_11) {
            carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
          }
        }
        if (isDirty_greaterThanDecorator_4_11) {
          isDirty_carrierDelayMap = carrierDelayMap.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
          csv2ByteBuffer_5.onEventComplete();
        }
        afterEvent();
        return;
    }
    //Default, no filter methods
    isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
      isDirty_csv2ByteBuffer_5 = csv2ByteBuffer_5.onEvent();
    }
    if (isDirty_flightDetailsCsvMarshaller2_8) {
      isDirty_greaterThanDecorator_4_11 = greaterThanDecorator_4_11.onEvent();
      if (isDirty_greaterThanDecorator_4_11) {
        carrierDelayMap.updategreaterThanDecorator_40(greaterThanDecorator_4_11);
      }
    }
    if (isDirty_greaterThanDecorator_4_11) {
      isDirty_carrierDelayMap = carrierDelayMap.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_15 || isDirty_asciiAnyCharMatcher_1_16) {
      csv2ByteBuffer_5.onEventComplete();
    }
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_csv2ByteBuffer_5 = false;
    isDirty_csv2Double_2 = false;
    isDirty_asciiAnyCharMatcher_1_16 = false;
    isDirty_asciiAnyCharMatcher_0_15 = false;
    isDirty_flightDetailsCsvMarshaller2_8 = false;
    isDirty_greaterThanDecorator_4_11 = false;
    isDirty_carrierDelayMap = false;
  }

  @Override
  public void init() {
    csv2Double_2.init();
    csv2ByteBuffer_5.init();
    flightDetailsCsvMarshaller2_8.init();
    greaterThanDecorator_4_11.init();
    carrierDelayMap.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
