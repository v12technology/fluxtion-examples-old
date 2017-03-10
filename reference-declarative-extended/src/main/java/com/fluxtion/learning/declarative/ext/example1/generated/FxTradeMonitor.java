/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.declarative.ext.example1.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.learning.declarative.ext.example1.generated.AbsInvoker_14;
import com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_1;
import com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_3;
import com.fluxtion.learning.declarative.ext.example1.generated.FxTradeHandlerStringFilter;
import com.fluxtion.learning.declarative.ext.example1.generated.FxTradeHandler;
import com.fluxtion.learning.declarative.ext.example1.generated.GreaterThanDecorator_16;
import com.fluxtion.learning.declarative.ext.example1.generated.GreaterThanDecorator_24;
import com.fluxtion.learning.declarative.ext.example1.generated.LessThanDecorator_20;
import com.fluxtion.learning.declarative.ext.example1.generated.LessThanDecorator_28;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder8;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder12;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder18;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder22;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder26;
import com.fluxtion.learning.declarative.ext.example1.generated.MsgBuilder30;
import com.fluxtion.learning.declarative.ext.example1.generated.SubtractInvoker_6;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.learning.declarative.ext.helpers.FxTrade;

public class FxTradeMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AsciiConsoleLogger asciiConsoleLogger_27 = new AsciiConsoleLogger();
  private final AbsInvoker_14 absInvoker_14_31 = new AbsInvoker_14();
  private final CumSumInvoker_1 cumSumInvoker_1_11 = new CumSumInvoker_1();
  private final CumSumInvoker_3 cumSumInvoker_3_21 = new CumSumInvoker_3();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_3 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_5 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_7 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_9 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_13 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_15 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_17 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_19 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandler fxTradeHandler_1 = new FxTradeHandler();
  private final GreaterThanDecorator_16 greaterThanDecorator_16_33 = new GreaterThanDecorator_16();
  private final GreaterThanDecorator_24 greaterThanDecorator_24_41 = new GreaterThanDecorator_24();
  private final LessThanDecorator_20 lessThanDecorator_20_37 = new LessThanDecorator_20();
  private final LessThanDecorator_28 lessThanDecorator_28_45 = new LessThanDecorator_28();
  private final MsgBuilder8 msgBuilder8_25 = new MsgBuilder8();
  private final MsgBuilder12 msgBuilder12_29 = new MsgBuilder12();
  private final MsgBuilder18 msgBuilder18_35 = new MsgBuilder18();
  private final MsgBuilder22 msgBuilder22_39 = new MsgBuilder22();
  private final MsgBuilder26 msgBuilder26_43 = new MsgBuilder26();
  private final MsgBuilder30 msgBuilder30_47 = new MsgBuilder30();
  public final SubtractInvoker_6 eurNetPos = new SubtractInvoker_6();
  //Dirty flags
  private boolean isDirty_lessThanDecorator_20_37 = false;
  private boolean isDirty_absInvoker_14_31 = false;
  private boolean isDirty_cumSumInvoker_3_21 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_3 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_7 = false;
  private boolean isDirty_msgBuilder22_39 = false;
  private boolean isDirty_msgBuilder30_47 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_13 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_17 = false;
  private boolean isDirty_fxTradeHandler_1 = false;
  private boolean isDirty_lessThanDecorator_28_45 = false;
  private boolean isDirty_eurNetPos = false;
  private boolean isDirty_msgBuilder18_35 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_9 = false;
  private boolean isDirty_cumSumInvoker_1_11 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_5 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_15 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_19 = false;
  private boolean isDirty_greaterThanDecorator_16_33 = false;
  private boolean isDirty_greaterThanDecorator_24_41 = false;
  private boolean isDirty_msgBuilder26_43 = false;
  private boolean isDirty_msgBuilder8_25 = false;
  private boolean isDirty_msgBuilder12_29 = false;
  //Filter constants

  public FxTradeMonitor() {
    //asciiConsoleLogger_27
    asciiConsoleLogger_27.initCapacity = (int) 512;
    asciiConsoleLogger_27.msgBuilders = new MsgBuilder[6];
    asciiConsoleLogger_27.msgBuilders[0] = msgBuilder8_25;
    asciiConsoleLogger_27.msgBuilders[1] = msgBuilder12_29;
    asciiConsoleLogger_27.msgBuilders[2] = msgBuilder18_35;
    asciiConsoleLogger_27.msgBuilders[3] = msgBuilder22_39;
    asciiConsoleLogger_27.msgBuilders[4] = msgBuilder26_43;
    asciiConsoleLogger_27.msgBuilders[5] = msgBuilder30_47;
    //absInvoker_14_31
    absInvoker_14_31.source_SubtractInvoker_6_13 = eurNetPos;
    //cumSumInvoker_1_11
    cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0 =
        new FxTradeHandlerStringFilter[4];
    cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0[0] = fxTradeHandlerStringFilter_3;
    cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0[1] = fxTradeHandlerStringFilter_5;
    cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0[2] = fxTradeHandlerStringFilter_7;
    cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0[3] = fxTradeHandlerStringFilter_9;
    //cumSumInvoker_3_21
    cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2 =
        new FxTradeHandlerStringFilter[4];
    cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2[0] =
        fxTradeHandlerStringFilter_13;
    cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2[1] =
        fxTradeHandlerStringFilter_15;
    cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2[2] =
        fxTradeHandlerStringFilter_17;
    cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2[3] =
        fxTradeHandlerStringFilter_19;
    //fxTradeHandlerStringFilter_3
    fxTradeHandlerStringFilter_3.filter = "EU";
    //fxTradeHandlerStringFilter_5
    fxTradeHandlerStringFilter_5.filter = "EC";
    //fxTradeHandlerStringFilter_7
    fxTradeHandlerStringFilter_7.filter = "EG";
    //fxTradeHandlerStringFilter_9
    fxTradeHandlerStringFilter_9.filter = "EY";
    //fxTradeHandlerStringFilter_13
    fxTradeHandlerStringFilter_13.filter = "UE";
    //fxTradeHandlerStringFilter_15
    fxTradeHandlerStringFilter_15.filter = "CE";
    //fxTradeHandlerStringFilter_17
    fxTradeHandlerStringFilter_17.filter = "GE";
    //fxTradeHandlerStringFilter_19
    fxTradeHandlerStringFilter_19.filter = "YE";
    //fxTradeHandler_1
    //greaterThanDecorator_16_33
    greaterThanDecorator_16_33.source_AbsInvoker_14_15 = absInvoker_14_31;
    //greaterThanDecorator_24_41
    greaterThanDecorator_24_41.source_AbsInvoker_14_23 = absInvoker_14_31;
    //lessThanDecorator_20_37
    lessThanDecorator_20_37.source_AbsInvoker_14_19 = absInvoker_14_31;
    //lessThanDecorator_28_45
    lessThanDecorator_28_45.source_AbsInvoker_14_27 = absInvoker_14_31;
    //msgBuilder8_25
    msgBuilder8_25.source_FxTradeHandler_7 = fxTradeHandler_1;
    msgBuilder8_25.logLevel = (int) 3;
    msgBuilder8_25.initCapacity = (int) 256;
    //msgBuilder12_29
    msgBuilder12_29.source_CumSumInvoker_3_11 = cumSumInvoker_3_21;
    msgBuilder12_29.source_CumSumInvoker_1_10 = cumSumInvoker_1_11;
    msgBuilder12_29.source_SubtractInvoker_6_9 = eurNetPos;
    msgBuilder12_29.logNotifier = fxTradeHandler_1;
    msgBuilder12_29.logLevel = (int) 3;
    msgBuilder12_29.initCapacity = (int) 256;
    //msgBuilder18_35
    msgBuilder18_35.source_SubtractInvoker_6_17 = eurNetPos;
    msgBuilder18_35.logNotifier = greaterThanDecorator_16_33;
    msgBuilder18_35.logLevel = (int) 2;
    msgBuilder18_35.initCapacity = (int) 256;
    //msgBuilder22_39
    msgBuilder22_39.source_SubtractInvoker_6_21 = eurNetPos;
    msgBuilder22_39.logNotifier = lessThanDecorator_20_37;
    msgBuilder22_39.logLevel = (int) 2;
    msgBuilder22_39.initCapacity = (int) 256;
    //msgBuilder26_43
    msgBuilder26_43.source_SubtractInvoker_6_25 = eurNetPos;
    msgBuilder26_43.logNotifier = greaterThanDecorator_24_41;
    msgBuilder26_43.logLevel = (int) 1;
    msgBuilder26_43.initCapacity = (int) 256;
    //msgBuilder30_47
    msgBuilder30_47.source_SubtractInvoker_6_29 = eurNetPos;
    msgBuilder30_47.logNotifier = lessThanDecorator_28_45;
    msgBuilder30_47.logLevel = (int) 1;
    msgBuilder30_47.initCapacity = (int) 256;
    //eurNetPos
    eurNetPos.source_CumSumInvoker_3_5 = cumSumInvoker_3_21;
    eurNetPos.source_CumSumInvoker_1_4 = cumSumInvoker_1_11;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (FxTrade.ID):
        {
          FxTrade typedEvent = (FxTrade) event;
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
        isDirty_msgBuilder8_25 = msgBuilder8_25.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder8_25) {
          asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
        }
        isDirty_msgBuilder12_29 = msgBuilder12_29.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder12_29) {
          asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
        }
        isDirty_msgBuilder18_35 = msgBuilder18_35.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder18_35) {
          asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
        }
        isDirty_msgBuilder22_39 = msgBuilder22_39.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder22_39) {
          asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
        }
        isDirty_msgBuilder26_43 = msgBuilder26_43.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder26_43) {
          asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
        }
        isDirty_msgBuilder30_47 = msgBuilder30_47.controlLogIdFilter(typedEvent);
        if (isDirty_msgBuilder30_47) {
          asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
        }
        afterEvent();
        return;
      case ("CHANGE LEVEL"):
        isDirty_msgBuilder8_25 = msgBuilder8_25.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder8_25) {
          asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
        }
        isDirty_msgBuilder12_29 = msgBuilder12_29.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder12_29) {
          asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
        }
        isDirty_msgBuilder18_35 = msgBuilder18_35.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder18_35) {
          asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
        }
        isDirty_msgBuilder22_39 = msgBuilder22_39.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder22_39) {
          asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
        }
        isDirty_msgBuilder26_43 = msgBuilder26_43.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder26_43) {
          asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
        }
        isDirty_msgBuilder30_47 = msgBuilder30_47.controlLogLevelFilter(typedEvent);
        if (isDirty_msgBuilder30_47) {
          asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
        }
        afterEvent();
        return;
      case ("RECORD LEVEL"):
        asciiConsoleLogger_27.controlLevelLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD NAME"):
        asciiConsoleLogger_27.controlIdLogging(typedEvent);
        afterEvent();
        return;
      case ("RECORD TIME"):
        asciiConsoleLogger_27.controlTimeLogging(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(FxTrade typedEvent) {
    switch (typedEvent.filterString()) {
      case ("CE"):
        isDirty_fxTradeHandlerStringFilter_15 =
            fxTradeHandlerStringFilter_15.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_15) {
          cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2(
              fxTradeHandlerStringFilter_15);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          isDirty_cumSumInvoker_3_21 = cumSumInvoker_3_21.onEvent();
          if (isDirty_cumSumInvoker_3_21) {
            eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_21);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          cumSumInvoker_3_21.afterCalculate();
        }
        afterEvent();
        return;
      case ("EC"):
        isDirty_fxTradeHandlerStringFilter_5 =
            fxTradeHandlerStringFilter_5.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_5) {
          cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0(
              fxTradeHandlerStringFilter_5);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          isDirty_cumSumInvoker_1_11 = cumSumInvoker_1_11.onEvent();
          if (isDirty_cumSumInvoker_1_11) {
            eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_11);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          cumSumInvoker_1_11.afterCalculate();
        }
        afterEvent();
        return;
      case ("EG"):
        isDirty_fxTradeHandlerStringFilter_7 =
            fxTradeHandlerStringFilter_7.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_7) {
          cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0(
              fxTradeHandlerStringFilter_7);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          isDirty_cumSumInvoker_1_11 = cumSumInvoker_1_11.onEvent();
          if (isDirty_cumSumInvoker_1_11) {
            eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_11);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          cumSumInvoker_1_11.afterCalculate();
        }
        afterEvent();
        return;
      case ("EU"):
        isDirty_fxTradeHandlerStringFilter_3 =
            fxTradeHandlerStringFilter_3.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_3) {
          cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0(
              fxTradeHandlerStringFilter_3);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          isDirty_cumSumInvoker_1_11 = cumSumInvoker_1_11.onEvent();
          if (isDirty_cumSumInvoker_1_11) {
            eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_11);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          cumSumInvoker_1_11.afterCalculate();
        }
        afterEvent();
        return;
      case ("EY"):
        isDirty_fxTradeHandlerStringFilter_9 =
            fxTradeHandlerStringFilter_9.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_9) {
          cumSumInvoker_1_11.sourceUpdated_FxTradeHandlerStringFilter_0(
              fxTradeHandlerStringFilter_9);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          isDirty_cumSumInvoker_1_11 = cumSumInvoker_1_11.onEvent();
          if (isDirty_cumSumInvoker_1_11) {
            eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_11);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_3
            || isDirty_fxTradeHandlerStringFilter_7
            || isDirty_fxTradeHandlerStringFilter_5
            || isDirty_fxTradeHandlerStringFilter_9) {
          cumSumInvoker_1_11.afterCalculate();
        }
        afterEvent();
        return;
      case ("GE"):
        isDirty_fxTradeHandlerStringFilter_17 =
            fxTradeHandlerStringFilter_17.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_17) {
          cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2(
              fxTradeHandlerStringFilter_17);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          isDirty_cumSumInvoker_3_21 = cumSumInvoker_3_21.onEvent();
          if (isDirty_cumSumInvoker_3_21) {
            eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_21);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          cumSumInvoker_3_21.afterCalculate();
        }
        afterEvent();
        return;
      case ("UE"):
        isDirty_fxTradeHandlerStringFilter_13 =
            fxTradeHandlerStringFilter_13.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_13) {
          cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2(
              fxTradeHandlerStringFilter_13);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          isDirty_cumSumInvoker_3_21 = cumSumInvoker_3_21.onEvent();
          if (isDirty_cumSumInvoker_3_21) {
            eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_21);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          cumSumInvoker_3_21.afterCalculate();
        }
        afterEvent();
        return;
      case ("YE"):
        isDirty_fxTradeHandlerStringFilter_19 =
            fxTradeHandlerStringFilter_19.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandlerStringFilter_19) {
          cumSumInvoker_3_21.sourceUpdated_FxTradeHandlerStringFilter_2(
              fxTradeHandlerStringFilter_19);
        }
        isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
        if (isDirty_fxTradeHandler_1) {
          msgBuilder12_29.postLog(fxTradeHandler_1);
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          isDirty_cumSumInvoker_3_21 = cumSumInvoker_3_21.onEvent();
          if (isDirty_cumSumInvoker_3_21) {
            eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_21);
          }
        }
        if (isDirty_fxTradeHandler_1) {
          isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
          if (isDirty_msgBuilder8_25) {
            asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
          }
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          isDirty_eurNetPos = eurNetPos.onEvent();
          if (isDirty_eurNetPos) {
            absInvoker_14_31.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
          }
        }
        if (isDirty_fxTradeHandler_1
            || isDirty_cumSumInvoker_1_11
            || isDirty_cumSumInvoker_3_21
            || isDirty_eurNetPos) {
          isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
          if (isDirty_msgBuilder12_29) {
            asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
          }
        }
        if (isDirty_eurNetPos) {
          isDirty_absInvoker_14_31 = absInvoker_14_31.onEvent();
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_16_33 = greaterThanDecorator_16_33.onEvent();
          if (isDirty_greaterThanDecorator_16_33) {
            msgBuilder18_35.postLog(greaterThanDecorator_16_33);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_20_37 = lessThanDecorator_20_37.onEvent();
          if (isDirty_lessThanDecorator_20_37) {
            msgBuilder22_39.postLog(lessThanDecorator_20_37);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_greaterThanDecorator_24_41 = greaterThanDecorator_24_41.onEvent();
          if (isDirty_greaterThanDecorator_24_41) {
            msgBuilder26_43.postLog(greaterThanDecorator_24_41);
          }
        }
        if (isDirty_absInvoker_14_31) {
          isDirty_lessThanDecorator_28_45 = lessThanDecorator_28_45.onEvent();
          if (isDirty_lessThanDecorator_28_45) {
            msgBuilder30_47.postLog(lessThanDecorator_28_45);
          }
        }
        if (isDirty_eurNetPos || isDirty_greaterThanDecorator_16_33) {
          isDirty_msgBuilder18_35 = msgBuilder18_35.buildMessage();
          if (isDirty_msgBuilder18_35) {
            asciiConsoleLogger_27.publishMessage(msgBuilder18_35);
          }
        }
        if (isDirty_eurNetPos || isDirty_lessThanDecorator_20_37) {
          isDirty_msgBuilder22_39 = msgBuilder22_39.buildMessage();
          if (isDirty_msgBuilder22_39) {
            asciiConsoleLogger_27.publishMessage(msgBuilder22_39);
          }
        }
        if (isDirty_greaterThanDecorator_24_41 || isDirty_eurNetPos) {
          isDirty_msgBuilder26_43 = msgBuilder26_43.buildMessage();
          if (isDirty_msgBuilder26_43) {
            asciiConsoleLogger_27.publishMessage(msgBuilder26_43);
          }
        }
        if (isDirty_lessThanDecorator_28_45 || isDirty_eurNetPos) {
          isDirty_msgBuilder30_47 = msgBuilder30_47.buildMessage();
          if (isDirty_msgBuilder30_47) {
            asciiConsoleLogger_27.publishMessage(msgBuilder30_47);
          }
        }
        //event stack unwind callbacks
        if (isDirty_eurNetPos) {
          absInvoker_14_31.afterCalculate();
        }
        if (isDirty_cumSumInvoker_1_11 || isDirty_cumSumInvoker_3_21) {
          eurNetPos.afterCalculate();
        }
        if (isDirty_fxTradeHandlerStringFilter_13
            || isDirty_fxTradeHandlerStringFilter_17
            || isDirty_fxTradeHandlerStringFilter_15
            || isDirty_fxTradeHandlerStringFilter_19) {
          cumSumInvoker_3_21.afterCalculate();
        }
        afterEvent();
        return;
    }
    //Default, no filter methods
    isDirty_fxTradeHandler_1 = fxTradeHandler_1.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_1) {
      msgBuilder12_29.postLog(fxTradeHandler_1);
    }
    if (isDirty_fxTradeHandler_1) {
      isDirty_msgBuilder8_25 = msgBuilder8_25.buildMessage();
      if (isDirty_msgBuilder8_25) {
        asciiConsoleLogger_27.publishMessage(msgBuilder8_25);
      }
    }
    if (isDirty_fxTradeHandler_1
        || isDirty_cumSumInvoker_1_11
        || isDirty_cumSumInvoker_3_21
        || isDirty_eurNetPos) {
      isDirty_msgBuilder12_29 = msgBuilder12_29.buildMessage();
      if (isDirty_msgBuilder12_29) {
        asciiConsoleLogger_27.publishMessage(msgBuilder12_29);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    msgBuilder30_47.afterEvent();
    msgBuilder26_43.afterEvent();
    msgBuilder22_39.afterEvent();
    msgBuilder18_35.afterEvent();
    msgBuilder12_29.afterEvent();
    msgBuilder8_25.afterEvent();
    isDirty_lessThanDecorator_20_37 = false;
    isDirty_absInvoker_14_31 = false;
    isDirty_cumSumInvoker_3_21 = false;
    isDirty_fxTradeHandlerStringFilter_3 = false;
    isDirty_fxTradeHandlerStringFilter_7 = false;
    isDirty_msgBuilder22_39 = false;
    isDirty_msgBuilder30_47 = false;
    isDirty_fxTradeHandlerStringFilter_13 = false;
    isDirty_fxTradeHandlerStringFilter_17 = false;
    isDirty_fxTradeHandler_1 = false;
    isDirty_lessThanDecorator_28_45 = false;
    isDirty_eurNetPos = false;
    isDirty_msgBuilder18_35 = false;
    isDirty_fxTradeHandlerStringFilter_9 = false;
    isDirty_cumSumInvoker_1_11 = false;
    isDirty_fxTradeHandlerStringFilter_5 = false;
    isDirty_fxTradeHandlerStringFilter_15 = false;
    isDirty_fxTradeHandlerStringFilter_19 = false;
    isDirty_greaterThanDecorator_16_33 = false;
    isDirty_greaterThanDecorator_24_41 = false;
    isDirty_msgBuilder26_43 = false;
    isDirty_msgBuilder8_25 = false;
    isDirty_msgBuilder12_29 = false;
  }

  @Override
  public void init() {
    cumSumInvoker_1_11.init();
    cumSumInvoker_3_21.init();
    msgBuilder8_25.init();
    eurNetPos.init();
    msgBuilder12_29.init();
    absInvoker_14_31.init();
    greaterThanDecorator_16_33.init();
    lessThanDecorator_20_37.init();
    greaterThanDecorator_24_41.init();
    lessThanDecorator_28_45.init();
    msgBuilder18_35.init();
    msgBuilder22_39.init();
    msgBuilder26_43.init();
    msgBuilder30_47.init();
    asciiConsoleLogger_27.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
