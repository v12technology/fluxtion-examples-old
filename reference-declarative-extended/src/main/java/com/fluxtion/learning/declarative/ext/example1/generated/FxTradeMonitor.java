package com.fluxtion.learning.declarative.ext.example1.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_1;
import com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_3;
import com.fluxtion.learning.declarative.ext.example1.generated.DataEventHandlerStringFilter;
import com.fluxtion.learning.declarative.ext.example1.generated.DataEventHandler;
import com.fluxtion.learning.declarative.ext.example1.generated.GreaterThanDecorator_14;
import com.fluxtion.learning.declarative.ext.example1.generated.GreaterThanDecorator_22;
import com.fluxtion.learning.declarative.ext.example1.generated.LessThanDecorator_18;
import com.fluxtion.learning.declarative.ext.example1.generated.LessThanDecorator_26;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder8;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder12;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder16;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder20;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder24;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder28;
import com.fluxtion.learning.declarative.ext.example1.generated.SubtractInvoker_6;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.learning.DataEvent;

public class FxTradeMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiConsoleLogger asciiConsoleLogger_41 = new AsciiConsoleLogger();
  private final CumSumInvoker_1 cumSumInvoker_1_17 = new CumSumInvoker_1();
  private final CumSumInvoker_3 cumSumInvoker_3_32 = new CumSumInvoker_3();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_5 =
      new DataEventHandlerStringFilter();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_8 =
      new DataEventHandlerStringFilter();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_11 =
      new DataEventHandlerStringFilter();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_14 =
      new DataEventHandlerStringFilter();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_20 =
      new DataEventHandlerStringFilter();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_23 =
      new DataEventHandlerStringFilter();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_26 =
      new DataEventHandlerStringFilter();
  private final DataEventHandlerStringFilter dataEventHandlerStringFilter_29 =
      new DataEventHandlerStringFilter();
  private final DataEventHandler dataEventHandler_2 = new DataEventHandler();
  private final GreaterThanDecorator_14 greaterThanDecorator_14_47 = new GreaterThanDecorator_14();
  private final GreaterThanDecorator_22 greaterThanDecorator_22_59 = new GreaterThanDecorator_22();
  private final LessThanDecorator_18 lessThanDecorator_18_53 = new LessThanDecorator_18();
  private final LessThanDecorator_26 lessThanDecorator_26_65 = new LessThanDecorator_26();
  private final MsgBuilder8 msgBuilder8_38 = new MsgBuilder8();
  private final MsgBuilder12 msgBuilder12_44 = new MsgBuilder12();
  private final MsgBuilder16 msgBuilder16_50 = new MsgBuilder16();
  private final MsgBuilder20 msgBuilder20_56 = new MsgBuilder20();
  private final MsgBuilder24 msgBuilder24_62 = new MsgBuilder24();
  private final MsgBuilder28 msgBuilder28_68 = new MsgBuilder28();
  private final SubtractInvoker_6 subtractInvoker_6_35 = new SubtractInvoker_6();
  //Dirty flags
  private boolean isDirty_cumSumInvoker_1_17 = false;
  private boolean isDirty_dataEventHandlerStringFilter_14 = false;
  private boolean isDirty_dataEventHandlerStringFilter_8 = false;
  private boolean isDirty_dataEventHandlerStringFilter_23 = false;
  private boolean isDirty_dataEventHandlerStringFilter_29 = false;
  private boolean isDirty_lessThanDecorator_18_53 = false;
  private boolean isDirty_lessThanDecorator_26_65 = false;
  private boolean isDirty_msgBuilder20_56 = false;
  private boolean isDirty_msgBuilder8_38 = false;
  private boolean isDirty_msgBuilder28_68 = false;
  private boolean isDirty_msgBuilder12_44 = false;
  private boolean isDirty_greaterThanDecorator_14_47 = false;
  private boolean isDirty_dataEventHandlerStringFilter_11 = false;
  private boolean isDirty_cumSumInvoker_3_32 = false;
  private boolean isDirty_dataEventHandlerStringFilter_5 = false;
  private boolean isDirty_dataEventHandlerStringFilter_20 = false;
  private boolean isDirty_dataEventHandlerStringFilter_26 = false;
  private boolean isDirty_dataEventHandler_2 = false;
  private boolean isDirty_greaterThanDecorator_22_59 = false;
  private boolean isDirty_msgBuilder16_50 = false;
  private boolean isDirty_subtractInvoker_6_35 = false;
  private boolean isDirty_msgBuilder24_62 = false;
  //Filter constants

  public FxTradeMonitor() {
    //asciiConsoleLogger_41
    asciiConsoleLogger_41.initCapacity = (int) 512;
    asciiConsoleLogger_41.msgBuilders = new MsgBuilder[6];
    asciiConsoleLogger_41.msgBuilders[0] = msgBuilder8_38;
    asciiConsoleLogger_41.msgBuilders[1] = msgBuilder12_44;
    asciiConsoleLogger_41.msgBuilders[2] = msgBuilder16_50;
    asciiConsoleLogger_41.msgBuilders[3] = msgBuilder20_56;
    asciiConsoleLogger_41.msgBuilders[4] = msgBuilder24_62;
    asciiConsoleLogger_41.msgBuilders[5] = msgBuilder28_68;
    //cumSumInvoker_1_17
    cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0 =
        new DataEventHandlerStringFilter[4];
    cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0[0] =
        dataEventHandlerStringFilter_5;
    cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0[1] =
        dataEventHandlerStringFilter_8;
    cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0[2] =
        dataEventHandlerStringFilter_11;
    cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0[3] =
        dataEventHandlerStringFilter_14;
    //cumSumInvoker_3_32
    cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2 =
        new DataEventHandlerStringFilter[4];
    cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2[0] =
        dataEventHandlerStringFilter_20;
    cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2[1] =
        dataEventHandlerStringFilter_23;
    cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2[2] =
        dataEventHandlerStringFilter_26;
    cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2[3] =
        dataEventHandlerStringFilter_29;
    //dataEventHandlerStringFilter_5
    dataEventHandlerStringFilter_5.filter = "EU";
    //dataEventHandlerStringFilter_8
    dataEventHandlerStringFilter_8.filter = "EC";
    //dataEventHandlerStringFilter_11
    dataEventHandlerStringFilter_11.filter = "EG";
    //dataEventHandlerStringFilter_14
    dataEventHandlerStringFilter_14.filter = "EY";
    //dataEventHandlerStringFilter_20
    dataEventHandlerStringFilter_20.filter = "UE";
    //dataEventHandlerStringFilter_23
    dataEventHandlerStringFilter_23.filter = "CE";
    //dataEventHandlerStringFilter_26
    dataEventHandlerStringFilter_26.filter = "GE";
    //dataEventHandlerStringFilter_29
    dataEventHandlerStringFilter_29.filter = "YE";
    //dataEventHandler_2
    //greaterThanDecorator_14_47
    greaterThanDecorator_14_47.source_SubtractInvoker_6_13 = subtractInvoker_6_35;
    //greaterThanDecorator_22_59
    greaterThanDecorator_22_59.source_SubtractInvoker_6_21 = subtractInvoker_6_35;
    //lessThanDecorator_18_53
    lessThanDecorator_18_53.source_SubtractInvoker_6_17 = subtractInvoker_6_35;
    //lessThanDecorator_26_65
    lessThanDecorator_26_65.source_SubtractInvoker_6_25 = subtractInvoker_6_35;
    //msgBuilder8_38
    msgBuilder8_38.source_DataEventHandler_7 = dataEventHandler_2;
    msgBuilder8_38.logLevel = (int) 3;
    msgBuilder8_38.initCapacity = (int) 256;
    //msgBuilder12_44
    msgBuilder12_44.source_CumSumInvoker_1_10 = cumSumInvoker_1_17;
    msgBuilder12_44.source_CumSumInvoker_3_11 = cumSumInvoker_3_32;
    msgBuilder12_44.source_SubtractInvoker_6_9 = subtractInvoker_6_35;
    msgBuilder12_44.logNotifier = dataEventHandler_2;
    msgBuilder12_44.logLevel = (int) 3;
    msgBuilder12_44.initCapacity = (int) 256;
    //msgBuilder16_50
    msgBuilder16_50.source_SubtractInvoker_6_15 = subtractInvoker_6_35;
    msgBuilder16_50.logNotifier = greaterThanDecorator_14_47;
    msgBuilder16_50.logLevel = (int) 3;
    msgBuilder16_50.initCapacity = (int) 256;
    //msgBuilder20_56
    msgBuilder20_56.source_SubtractInvoker_6_19 = subtractInvoker_6_35;
    msgBuilder20_56.logNotifier = lessThanDecorator_18_53;
    msgBuilder20_56.logLevel = (int) 3;
    msgBuilder20_56.initCapacity = (int) 256;
    //msgBuilder24_62
    msgBuilder24_62.source_SubtractInvoker_6_23 = subtractInvoker_6_35;
    msgBuilder24_62.logNotifier = greaterThanDecorator_22_59;
    msgBuilder24_62.logLevel = (int) 3;
    msgBuilder24_62.initCapacity = (int) 256;
    //msgBuilder28_68
    msgBuilder28_68.source_SubtractInvoker_6_27 = subtractInvoker_6_35;
    msgBuilder28_68.logNotifier = lessThanDecorator_26_65;
    msgBuilder28_68.logLevel = (int) 3;
    msgBuilder28_68.initCapacity = (int) 256;
    //subtractInvoker_6_35
    subtractInvoker_6_35.source_CumSumInvoker_1_4 = cumSumInvoker_1_17;
    subtractInvoker_6_35.source_CumSumInvoker_3_5 = cumSumInvoker_3_32;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (DataEvent.ID):
        {
          DataEvent typedEvent = (DataEvent) event;
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
    switch (typedEvent.filterString()) {
      case ("CHANGE FILTER"):
        isDirty_msgBuilder8_38 = msgBuilder8_38.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder8_38) {
          asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
        }
        isDirty_msgBuilder12_44 = msgBuilder12_44.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder12_44) {
          asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
        }
        isDirty_msgBuilder16_50 = msgBuilder16_50.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder16_50) {
          asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
        }
        isDirty_msgBuilder20_56 = msgBuilder20_56.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder20_56) {
          asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
        }
        isDirty_msgBuilder24_62 = msgBuilder24_62.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder24_62) {
          asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
        }
        isDirty_msgBuilder28_68 = msgBuilder28_68.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder28_68) {
          asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
        }
        afterEvent();
        return;
      case ("CHANGE LEVEL"):
        isDirty_msgBuilder8_38 = msgBuilder8_38.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder8_38) {
          asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
        }
        isDirty_msgBuilder12_44 = msgBuilder12_44.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder12_44) {
          asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
        }
        isDirty_msgBuilder16_50 = msgBuilder16_50.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder16_50) {
          asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
        }
        isDirty_msgBuilder20_56 = msgBuilder20_56.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder20_56) {
          asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
        }
        isDirty_msgBuilder24_62 = msgBuilder24_62.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder24_62) {
          asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
        }
        isDirty_msgBuilder28_68 = msgBuilder28_68.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder28_68) {
          asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
        }
        afterEvent();
        return;
      case ("RECORD LEVEL"):
        asciiConsoleLogger_41.controlLevelLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD NAME"):
        asciiConsoleLogger_41.controlIdLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD TIME"):
        asciiConsoleLogger_41.controlTimeLogging(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(DataEvent typedEvent) {
    switch (typedEvent.filterString()) {
      case ("CE"):
        isDirty_dataEventHandlerStringFilter_23 =
            dataEventHandlerStringFilter_23.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_23) {
          cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2(
              dataEventHandlerStringFilter_23);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
          if (isDirty_cumSumInvoker_3_32) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          cumSumInvoker_3_32.afterCalculate();
        }
        afterEvent();
        return;
      case ("EC"):
        isDirty_dataEventHandlerStringFilter_8 =
            dataEventHandlerStringFilter_8.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_8) {
          cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0(
              dataEventHandlerStringFilter_8);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
          if (isDirty_cumSumInvoker_1_17) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          cumSumInvoker_1_17.afterCalculate();
        }
        afterEvent();
        return;
      case ("EG"):
        isDirty_dataEventHandlerStringFilter_11 =
            dataEventHandlerStringFilter_11.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_11) {
          cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0(
              dataEventHandlerStringFilter_11);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
          if (isDirty_cumSumInvoker_1_17) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          cumSumInvoker_1_17.afterCalculate();
        }
        afterEvent();
        return;
      case ("EU"):
        isDirty_dataEventHandlerStringFilter_5 =
            dataEventHandlerStringFilter_5.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_5) {
          cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0(
              dataEventHandlerStringFilter_5);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
          if (isDirty_cumSumInvoker_1_17) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          cumSumInvoker_1_17.afterCalculate();
        }
        afterEvent();
        return;
      case ("EY"):
        isDirty_dataEventHandlerStringFilter_14 =
            dataEventHandlerStringFilter_14.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_14) {
          cumSumInvoker_1_17.sourceUpdated_DataEventHandlerStringFilter_0(
              dataEventHandlerStringFilter_14);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
          if (isDirty_cumSumInvoker_1_17) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_5
            || isDirty_dataEventHandlerStringFilter_11
            || isDirty_dataEventHandlerStringFilter_8
            || isDirty_dataEventHandlerStringFilter_14) {
          cumSumInvoker_1_17.afterCalculate();
        }
        afterEvent();
        return;
      case ("GE"):
        isDirty_dataEventHandlerStringFilter_26 =
            dataEventHandlerStringFilter_26.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_26) {
          cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2(
              dataEventHandlerStringFilter_26);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
          if (isDirty_cumSumInvoker_3_32) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          cumSumInvoker_3_32.afterCalculate();
        }
        afterEvent();
        return;
      case ("UE"):
        isDirty_dataEventHandlerStringFilter_20 =
            dataEventHandlerStringFilter_20.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_20) {
          cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2(
              dataEventHandlerStringFilter_20);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
          if (isDirty_cumSumInvoker_3_32) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          cumSumInvoker_3_32.afterCalculate();
        }
        afterEvent();
        return;
      case ("YE"):
        isDirty_dataEventHandlerStringFilter_29 =
            dataEventHandlerStringFilter_29.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandlerStringFilter_29) {
          cumSumInvoker_3_32.sourceUpdated_DataEventHandlerStringFilter_2(
              dataEventHandlerStringFilter_29);
        }
        isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
        if (isDirty_dataEventHandler_2) {
          msgBuilder12_44.postLog(dataEventHandler_2);
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
          if (isDirty_cumSumInvoker_3_32) {
            subtractInvoker_6_35.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
          }
        }
        if (isDirty_dataEventHandler_2) {
          isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
          if (isDirty_msgBuilder8_38) {
            asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
          }
        }
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          isDirty_subtractInvoker_6_35 = subtractInvoker_6_35.onEvent();
        }
        if (isDirty_dataEventHandler_2
            || isDirty_cumSumInvoker_1_17
            || isDirty_cumSumInvoker_3_32
            || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
          if (isDirty_msgBuilder12_44) {
            asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_14_47 = greaterThanDecorator_14_47.onEvent();
          if (isDirty_greaterThanDecorator_14_47) {
            msgBuilder16_50.postLog(greaterThanDecorator_14_47);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_18_53 = lessThanDecorator_18_53.onEvent();
          if (isDirty_lessThanDecorator_18_53) {
            msgBuilder20_56.postLog(lessThanDecorator_18_53);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_greaterThanDecorator_22_59 = greaterThanDecorator_22_59.onEvent();
          if (isDirty_greaterThanDecorator_22_59) {
            msgBuilder24_62.postLog(greaterThanDecorator_22_59);
          }
        }
        if (isDirty_subtractInvoker_6_35) {
          isDirty_lessThanDecorator_26_65 = lessThanDecorator_26_65.onEvent();
          if (isDirty_lessThanDecorator_26_65) {
            msgBuilder28_68.postLog(lessThanDecorator_26_65);
          }
        }
        if (isDirty_greaterThanDecorator_14_47 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder16_50 = msgBuilder16_50.buildMessage();
          if (isDirty_msgBuilder16_50) {
            asciiConsoleLogger_41.publishMessage(msgBuilder16_50);
          }
        }
        if (isDirty_subtractInvoker_6_35 || isDirty_lessThanDecorator_18_53) {
          isDirty_msgBuilder20_56 = msgBuilder20_56.buildMessage();
          if (isDirty_msgBuilder20_56) {
            asciiConsoleLogger_41.publishMessage(msgBuilder20_56);
          }
        }
        if (isDirty_greaterThanDecorator_22_59 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder24_62 = msgBuilder24_62.buildMessage();
          if (isDirty_msgBuilder24_62) {
            asciiConsoleLogger_41.publishMessage(msgBuilder24_62);
          }
        }
        if (isDirty_lessThanDecorator_26_65 || isDirty_subtractInvoker_6_35) {
          isDirty_msgBuilder28_68 = msgBuilder28_68.buildMessage();
          if (isDirty_msgBuilder28_68) {
            asciiConsoleLogger_41.publishMessage(msgBuilder28_68);
          }
        }
        //event stack unwind callbacks
        if (isDirty_cumSumInvoker_1_17 || isDirty_cumSumInvoker_3_32) {
          subtractInvoker_6_35.afterCalculate();
        }
        if (isDirty_dataEventHandlerStringFilter_20
            || isDirty_dataEventHandlerStringFilter_26
            || isDirty_dataEventHandlerStringFilter_23
            || isDirty_dataEventHandlerStringFilter_29) {
          cumSumInvoker_3_32.afterCalculate();
        }
        afterEvent();
        return;
    }
    //Default, no filter methods
    isDirty_dataEventHandler_2 = dataEventHandler_2.handleDataEvent(typedEvent);
    if (isDirty_dataEventHandler_2) {
      msgBuilder12_44.postLog(dataEventHandler_2);
    }
    if (isDirty_dataEventHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_dataEventHandler_2
        || isDirty_cumSumInvoker_1_17
        || isDirty_cumSumInvoker_3_32
        || isDirty_subtractInvoker_6_35) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    msgBuilder28_68.afterEvent();
    msgBuilder24_62.afterEvent();
    msgBuilder20_56.afterEvent();
    msgBuilder16_50.afterEvent();
    msgBuilder12_44.afterEvent();
    msgBuilder8_38.afterEvent();
    isDirty_cumSumInvoker_1_17 = false;
    isDirty_dataEventHandlerStringFilter_14 = false;
    isDirty_dataEventHandlerStringFilter_8 = false;
    isDirty_dataEventHandlerStringFilter_23 = false;
    isDirty_dataEventHandlerStringFilter_29 = false;
    isDirty_lessThanDecorator_18_53 = false;
    isDirty_lessThanDecorator_26_65 = false;
    isDirty_msgBuilder20_56 = false;
    isDirty_msgBuilder8_38 = false;
    isDirty_msgBuilder28_68 = false;
    isDirty_msgBuilder12_44 = false;
    isDirty_greaterThanDecorator_14_47 = false;
    isDirty_dataEventHandlerStringFilter_11 = false;
    isDirty_cumSumInvoker_3_32 = false;
    isDirty_dataEventHandlerStringFilter_5 = false;
    isDirty_dataEventHandlerStringFilter_20 = false;
    isDirty_dataEventHandlerStringFilter_26 = false;
    isDirty_dataEventHandler_2 = false;
    isDirty_greaterThanDecorator_22_59 = false;
    isDirty_msgBuilder16_50 = false;
    isDirty_subtractInvoker_6_35 = false;
    isDirty_msgBuilder24_62 = false;
  }

  @Override
  public void init() {
    cumSumInvoker_1_17.init();
    cumSumInvoker_3_32.init();
    msgBuilder8_38.init();
    subtractInvoker_6_35.init();
    msgBuilder12_44.init();
    greaterThanDecorator_14_47.init();
    lessThanDecorator_18_53.init();
    greaterThanDecorator_22_59.init();
    lessThanDecorator_26_65.init();
    msgBuilder16_50.init();
    msgBuilder20_56.init();
    msgBuilder24_62.init();
    msgBuilder28_68.init();
    asciiConsoleLogger_41.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
