package com.fluxtion.learning.declarative.ext.example4.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.learning.declarative.ext.example4.generated.AsciiAnyCharMatcher_1;
import com.fluxtion.learning.declarative.ext.example4.generated.AsciiAnyCharMatcher_0;
import com.fluxtion.learning.declarative.ext.example4.generated.GroupBy_19;
import com.fluxtion.learning.declarative.ext.example4.generated.MatchResultCsvMarshaller4;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;

public class MatchResulProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final Csv2ByteBuffer csv2ByteBuffer_2 = new Csv2ByteBuffer();
  private final Csv2ByteBuffer csv2ByteBuffer_8 = new Csv2ByteBuffer();
  private final Csv2Double csv2Double_5 = new Csv2Double();
  private final Csv2Double csv2Double_11 = new Csv2Double();
  private final AsciiAnyCharMatcher_1 asciiAnyCharMatcher_1_19 = new AsciiAnyCharMatcher_1();
  private final AsciiAnyCharMatcher_0 asciiAnyCharMatcher_0_18 = new AsciiAnyCharMatcher_0();
  public final GroupBy_19 leagueSummary = new GroupBy_19();
  private final MatchResultCsvMarshaller4 matchResultCsvMarshaller4_14 =
      new MatchResultCsvMarshaller4();
  //Dirty flags
  private boolean isDirty_csv2ByteBuffer_2 = false;
  private boolean isDirty_csv2ByteBuffer_8 = false;
  private boolean isDirty_csv2Double_5 = false;
  private boolean isDirty_csv2Double_11 = false;
  private boolean isDirty_asciiAnyCharMatcher_1_19 = false;
  private boolean isDirty_asciiAnyCharMatcher_0_18 = false;
  private boolean isDirty_leagueSummary = false;
  private boolean isDirty_matchResultCsvMarshaller4_14 = false;
  //Filter constants

  public MatchResulProcessor() {
    //csv2ByteBuffer_2
    csv2ByteBuffer_2.fieldNumber = (int) 0;
    csv2ByteBuffer_2.headerLines = (int) 1;
    csv2ByteBuffer_2.eolNotifier = asciiAnyCharMatcher_1_19;
    csv2ByteBuffer_2.delimiterNotifier = asciiAnyCharMatcher_0_18;
    //csv2ByteBuffer_8
    csv2ByteBuffer_8.fieldNumber = (int) 3;
    csv2ByteBuffer_8.headerLines = (int) 1;
    csv2ByteBuffer_8.eolNotifier = asciiAnyCharMatcher_1_19;
    csv2ByteBuffer_8.delimiterNotifier = asciiAnyCharMatcher_0_18;
    //csv2Double_5
    csv2Double_5.fieldNumber = (int) 1;
    csv2Double_5.headerLines = (int) 1;
    csv2Double_5.delimiterNotifier = asciiAnyCharMatcher_0_18;
    //csv2Double_11
    csv2Double_11.fieldNumber = (int) 2;
    csv2Double_11.headerLines = (int) 1;
    csv2Double_11.delimiterNotifier = asciiAnyCharMatcher_0_18;
    //asciiAnyCharMatcher_1_19
    //asciiAnyCharMatcher_0_18
    //leagueSummary
    leagueSummary.matchResultCsvMarshaller40 = matchResultCsvMarshaller4_14;
    leagueSummary.matchResultCsvMarshaller41 = matchResultCsvMarshaller4_14;
    //matchResultCsvMarshaller4_14
    matchResultCsvMarshaller4_14.csvSrc_0 = csv2ByteBuffer_2;
    matchResultCsvMarshaller4_14.csvSrc_1 = csv2Double_5;
    matchResultCsvMarshaller4_14.csvSrc_2 = csv2ByteBuffer_8;
    matchResultCsvMarshaller4_14.csvSrc_3 = csv2Double_11;
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
        isDirty_asciiAnyCharMatcher_1_19 = asciiAnyCharMatcher_1_19.onChar_newLine(typedEvent);
        if (isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEol(asciiAnyCharMatcher_1_19);
          csv2ByteBuffer_8.onEol(asciiAnyCharMatcher_1_19);
        }
        isDirty_csv2Double_5 = csv2Double_5.onEol(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.onEol(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        isDirty_matchResultCsvMarshaller4_14 = matchResultCsvMarshaller4_14.onEol(typedEvent);
        if (isDirty_matchResultCsvMarshaller4_14) {
          leagueSummary.updatematchResultCsvMarshaller40(matchResultCsvMarshaller4_14);
          leagueSummary.updatematchResultCsvMarshaller41(matchResultCsvMarshaller4_14);
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[44]
      case (44):
        isDirty_asciiAnyCharMatcher_0_18 = asciiAnyCharMatcher_0_18.onChar_44(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18) {
          csv2Double_5.onDelimiter(asciiAnyCharMatcher_0_18);
          csv2ByteBuffer_8.onDelimiter(asciiAnyCharMatcher_0_18);
          csv2Double_11.onDelimiter(asciiAnyCharMatcher_0_18);
          csv2ByteBuffer_2.onDelimiter(asciiAnyCharMatcher_0_18);
        }
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[45]
      case (45):
        isDirty_csv2Double_5 = csv2Double_5.onSign(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.onSign(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[46]
      case (46):
        isDirty_csv2Double_5 = csv2Double_5.onDecimalPoint(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.onDecimalPoint(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[48]
      case (48):
        isDirty_csv2Double_5 = csv2Double_5.on_0(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_0(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[49]
      case (49):
        isDirty_csv2Double_5 = csv2Double_5.on_1(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_1(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[50]
      case (50):
        isDirty_csv2Double_5 = csv2Double_5.on_2(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_2(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[51]
      case (51):
        isDirty_csv2Double_5 = csv2Double_5.on_3(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_3(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[52]
      case (52):
        isDirty_csv2Double_5 = csv2Double_5.on_4(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_4(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[53]
      case (53):
        isDirty_csv2Double_5 = csv2Double_5.on_5(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_5(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[54]
      case (54):
        isDirty_csv2Double_5 = csv2Double_5.on_6(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_6(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[55]
      case (55):
        isDirty_csv2Double_5 = csv2Double_5.on_7(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_7(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[56]
      case (56):
        isDirty_csv2Double_5 = csv2Double_5.on_8(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_8(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
        //Event Class:[com.fluxtion.extension.declarative.funclib.api.event.CharEvent] filterId:[57]
      case (57):
        isDirty_csv2Double_5 = csv2Double_5.on_9(typedEvent);
        isDirty_csv2Double_11 = csv2Double_11.on_9(typedEvent);
        isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
        }
        isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
        }
        if (isDirty_matchResultCsvMarshaller4_14) {
          isDirty_leagueSummary = leagueSummary.updated();
        }
        //event stack unwind callbacks
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_8.onEventComplete();
        }
        if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
          csv2ByteBuffer_2.onEventComplete();
        }
        afterEvent();
        return;
    }
    //Default, no filter methods
    isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_2 = csv2ByteBuffer_2.onEvent();
    }
    isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.appendToBuffer(typedEvent);
    if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
      isDirty_csv2ByteBuffer_8 = csv2ByteBuffer_8.onEvent();
    }
    if (isDirty_matchResultCsvMarshaller4_14) {
      isDirty_leagueSummary = leagueSummary.updated();
    }
    //event stack unwind callbacks
    if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_2.onEventComplete();
    }
    if (isDirty_asciiAnyCharMatcher_0_18 || isDirty_asciiAnyCharMatcher_1_19) {
      csv2ByteBuffer_8.onEventComplete();
    }
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_csv2ByteBuffer_2 = false;
    isDirty_csv2ByteBuffer_8 = false;
    isDirty_csv2Double_5 = false;
    isDirty_csv2Double_11 = false;
    isDirty_asciiAnyCharMatcher_1_19 = false;
    isDirty_asciiAnyCharMatcher_0_18 = false;
    isDirty_leagueSummary = false;
    isDirty_matchResultCsvMarshaller4_14 = false;
  }

  @Override
  public void init() {
    csv2Double_5.init();
    csv2Double_11.init();
    csv2ByteBuffer_2.init();
    csv2ByteBuffer_8.init();
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
