package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.learning.declarative.ext.helpers.FxTrade;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class FxTradeMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_1 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_2 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_3 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_4 =
      new FxTradeHandlerStringFilter();
  private final CumSumInvoker_1 cumSumInvoker_1_5 = new CumSumInvoker_1();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_6 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_7 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_8 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_9 =
      new FxTradeHandlerStringFilter();
  private final CumSumInvoker_3 cumSumInvoker_3_10 = new CumSumInvoker_3();
  public final SubtractInvoker_6 eurNetPos = new SubtractInvoker_6();
  private final AbsInvoker_14 absInvoker_14_15 = new AbsInvoker_14();
  private final FxTradeHandler fxTradeHandler_0 = new FxTradeHandler();
  private final GreaterThanDecorator_16 greaterThanDecorator_16_16 = new GreaterThanDecorator_16();
  private final GreaterThanDecorator_24 greaterThanDecorator_24_20 = new GreaterThanDecorator_24();
  private final LessThanDecorator_20 lessThanDecorator_20_18 = new LessThanDecorator_20();
  private final LessThanDecorator_28 lessThanDecorator_28_22 = new LessThanDecorator_28();
  private final MsgBuilder8 msgBuilder8_12 = new MsgBuilder8();
  private final MsgBuilder12 msgBuilder12_14 = new MsgBuilder12();
  private final MsgBuilder18 msgBuilder18_17 = new MsgBuilder18();
  private final MsgBuilder22 msgBuilder22_19 = new MsgBuilder22();
  private final MsgBuilder26 msgBuilder26_21 = new MsgBuilder26();
  private final MsgBuilder30 msgBuilder30_23 = new MsgBuilder30();
  private final AsciiConsoleLogger asciiConsoleLogger_13 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_greaterThanDecorator_24_20 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_1 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_3 = false;
  private boolean isDirty_cumSumInvoker_1_5 = false;
  private boolean isDirty_msgBuilder22_19 = false;
  private boolean isDirty_msgBuilder30_23 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_7 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_9 = false;
  private boolean isDirty_eurNetPos = false;
  private boolean isDirty_fxTradeHandler_0 = false;
  private boolean isDirty_lessThanDecorator_28_22 = false;
  private boolean isDirty_msgBuilder12_14 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_2 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_4 = false;
  private boolean isDirty_msgBuilder18_17 = false;
  private boolean isDirty_msgBuilder26_21 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_6 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_8 = false;
  private boolean isDirty_cumSumInvoker_3_10 = false;
  private boolean isDirty_absInvoker_14_15 = false;
  private boolean isDirty_greaterThanDecorator_16_16 = false;
  private boolean isDirty_lessThanDecorator_20_18 = false;
  private boolean isDirty_msgBuilder8_12 = false;
  //Filter constants

  public FxTradeMonitor() {
    fxTradeHandlerStringFilter_1.filter = "EU";
    fxTradeHandlerStringFilter_2.filter = "EC";
    fxTradeHandlerStringFilter_3.filter = "EG";
    fxTradeHandlerStringFilter_4.filter = "EY";
    cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0 =
        new FxTradeHandlerStringFilter[4];
    cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0[0] = fxTradeHandlerStringFilter_1;
    cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0[1] = fxTradeHandlerStringFilter_2;
    cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0[2] = fxTradeHandlerStringFilter_3;
    cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0[3] = fxTradeHandlerStringFilter_4;
    fxTradeHandlerStringFilter_6.filter = "UE";
    fxTradeHandlerStringFilter_7.filter = "CE";
    fxTradeHandlerStringFilter_8.filter = "GE";
    fxTradeHandlerStringFilter_9.filter = "YE";
    cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2 =
        new FxTradeHandlerStringFilter[4];
    cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2[0] = fxTradeHandlerStringFilter_6;
    cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2[1] = fxTradeHandlerStringFilter_7;
    cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2[2] = fxTradeHandlerStringFilter_8;
    cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2[3] = fxTradeHandlerStringFilter_9;
    eurNetPos.source_CumSumInvoker_3_5 = cumSumInvoker_3_10;
    eurNetPos.source_CumSumInvoker_1_4 = cumSumInvoker_1_5;
    absInvoker_14_15.source_SubtractInvoker_6_13 = eurNetPos;
    greaterThanDecorator_16_16.source_AbsInvoker_14_15 = absInvoker_14_15;
    greaterThanDecorator_24_20.source_AbsInvoker_14_23 = absInvoker_14_15;
    lessThanDecorator_20_18.source_AbsInvoker_14_19 = absInvoker_14_15;
    lessThanDecorator_28_22.source_AbsInvoker_14_27 = absInvoker_14_15;
    msgBuilder8_12.source_FxTradeHandler_7 = fxTradeHandler_0;
    msgBuilder8_12.logLevel = (int) 3;
    msgBuilder8_12.initCapacity = (int) 256;
    msgBuilder12_14.source_CumSumInvoker_3_11 = cumSumInvoker_3_10;
    msgBuilder12_14.source_SubtractInvoker_6_9 = eurNetPos;
    msgBuilder12_14.source_CumSumInvoker_1_10 = cumSumInvoker_1_5;
    msgBuilder12_14.logNotifier = fxTradeHandler_0;
    msgBuilder12_14.logLevel = (int) 3;
    msgBuilder12_14.initCapacity = (int) 256;
    msgBuilder18_17.source_SubtractInvoker_6_17 = eurNetPos;
    msgBuilder18_17.logNotifier = greaterThanDecorator_16_16;
    msgBuilder18_17.logLevel = (int) 2;
    msgBuilder18_17.initCapacity = (int) 256;
    msgBuilder22_19.source_SubtractInvoker_6_21 = eurNetPos;
    msgBuilder22_19.logNotifier = lessThanDecorator_20_18;
    msgBuilder22_19.logLevel = (int) 2;
    msgBuilder22_19.initCapacity = (int) 256;
    msgBuilder26_21.source_SubtractInvoker_6_25 = eurNetPos;
    msgBuilder26_21.logNotifier = greaterThanDecorator_24_20;
    msgBuilder26_21.logLevel = (int) 1;
    msgBuilder26_21.initCapacity = (int) 256;
    msgBuilder30_23.source_SubtractInvoker_6_29 = eurNetPos;
    msgBuilder30_23.logNotifier = lessThanDecorator_28_22;
    msgBuilder30_23.logLevel = (int) 1;
    msgBuilder30_23.initCapacity = (int) 256;
    asciiConsoleLogger_13.initCapacity = (int) 512;
    asciiConsoleLogger_13.msgBuilders = new MsgBuilder[6];
    asciiConsoleLogger_13.msgBuilders[0] = msgBuilder8_12;
    asciiConsoleLogger_13.msgBuilders[1] = msgBuilder12_14;
    asciiConsoleLogger_13.msgBuilders[2] = msgBuilder18_17;
    asciiConsoleLogger_13.msgBuilders[3] = msgBuilder22_19;
    asciiConsoleLogger_13.msgBuilders[4] = msgBuilder26_21;
    asciiConsoleLogger_13.msgBuilders[5] = msgBuilder30_23;
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
    FilteredHandlerInvoker invoker =
        dispatchStringMapLogControlEvent.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  public void handleEvent(FxTrade typedEvent) {
    FilteredHandlerInvoker invoker = dispatchStringMapFxTrade.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    //Default, no filter methods
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  //int filter maps
  private final Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchIntMapFxTrade =
      initdispatchIntMapFxTrade();

  //String filter maps
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapLogControlEvent =
      initdispatchStringMapLogControlEvent();

  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapFxTrade =
      initdispatchStringMapFxTrade();

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

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapFxTrade() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "CE",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_CE((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    dispatchMap.put(
        "EC",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_EC((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    dispatchMap.put(
        "EG",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_EG((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    dispatchMap.put(
        "EU",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_EU((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    dispatchMap.put(
        "EY",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_EY((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    dispatchMap.put(
        "GE",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_GE((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    dispatchMap.put(
        "UE",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_UE((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    dispatchMap.put(
        "YE",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_YE((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    return dispatchMap;
  }

  private Int2ObjectOpenHashMap<FilteredHandlerInvoker> initdispatchIntMapFxTrade() {
    Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchMap = new Int2ObjectOpenHashMap<>();
    dispatchMap.put(
        0,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_FxTrade_NoFilter((com.fluxtion.learning.declarative.ext.helpers.FxTrade) event);
          }
        });
    return dispatchMap;
  }

  private void handle_LogControlEvent_CHANGE_FILTER(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder8_12 = msgBuilder8_12.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder12_14 = msgBuilder12_14.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder18_17 = msgBuilder18_17.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder22_19 = msgBuilder22_19.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder26_21 = msgBuilder26_21.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder30_23 = msgBuilder30_23.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder8_12 = msgBuilder8_12.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder12_14 = msgBuilder12_14.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder18_17 = msgBuilder18_17.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder22_19 = msgBuilder22_19.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder26_21 = msgBuilder26_21.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder30_23 = msgBuilder30_23.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_13.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_13.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_13.controlTimeLogging(typedEvent);
  }

  private void handle_FxTrade_CE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_7 = fxTradeHandlerStringFilter_7.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_7) {
      cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_7);
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      isDirty_cumSumInvoker_3_10 = cumSumInvoker_3_10.onEvent();
      if (isDirty_cumSumInvoker_3_10) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_10);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      cumSumInvoker_3_10.afterCalculate();
    }
  }

  private void handle_FxTrade_EC(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_2 = fxTradeHandlerStringFilter_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_2) {
      cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_2);
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      isDirty_cumSumInvoker_1_5 = cumSumInvoker_1_5.onEvent();
      if (isDirty_cumSumInvoker_1_5) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_5);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      cumSumInvoker_1_5.afterCalculate();
    }
  }

  private void handle_FxTrade_EG(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_3 = fxTradeHandlerStringFilter_3.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_3) {
      cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_3);
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      isDirty_cumSumInvoker_1_5 = cumSumInvoker_1_5.onEvent();
      if (isDirty_cumSumInvoker_1_5) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_5);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      cumSumInvoker_1_5.afterCalculate();
    }
  }

  private void handle_FxTrade_EU(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_1 = fxTradeHandlerStringFilter_1.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_1) {
      cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_1);
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      isDirty_cumSumInvoker_1_5 = cumSumInvoker_1_5.onEvent();
      if (isDirty_cumSumInvoker_1_5) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_5);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      cumSumInvoker_1_5.afterCalculate();
    }
  }

  private void handle_FxTrade_EY(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_4 = fxTradeHandlerStringFilter_4.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_4) {
      cumSumInvoker_1_5.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_4);
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      isDirty_cumSumInvoker_1_5 = cumSumInvoker_1_5.onEvent();
      if (isDirty_cumSumInvoker_1_5) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_5);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_1
        | isDirty_fxTradeHandlerStringFilter_2
        | isDirty_fxTradeHandlerStringFilter_3
        | isDirty_fxTradeHandlerStringFilter_4) {
      cumSumInvoker_1_5.afterCalculate();
    }
  }

  private void handle_FxTrade_GE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_8 = fxTradeHandlerStringFilter_8.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_8) {
      cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_8);
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      isDirty_cumSumInvoker_3_10 = cumSumInvoker_3_10.onEvent();
      if (isDirty_cumSumInvoker_3_10) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_10);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      cumSumInvoker_3_10.afterCalculate();
    }
  }

  private void handle_FxTrade_UE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_6 = fxTradeHandlerStringFilter_6.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_6) {
      cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_6);
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      isDirty_cumSumInvoker_3_10 = cumSumInvoker_3_10.onEvent();
      if (isDirty_cumSumInvoker_3_10) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_10);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      cumSumInvoker_3_10.afterCalculate();
    }
  }

  private void handle_FxTrade_YE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_9 = fxTradeHandlerStringFilter_9.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_9) {
      cumSumInvoker_3_10.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_9);
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      isDirty_cumSumInvoker_3_10 = cumSumInvoker_3_10.onEvent();
      if (isDirty_cumSumInvoker_3_10) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_10);
      }
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_15.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_15 = absInvoker_14_15.onEvent();
    }
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_16_16 = greaterThanDecorator_16_16.onEvent();
      if (isDirty_greaterThanDecorator_16_16) {
        msgBuilder18_17.postLog(greaterThanDecorator_16_16);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_greaterThanDecorator_24_20 = greaterThanDecorator_24_20.onEvent();
      if (isDirty_greaterThanDecorator_24_20) {
        msgBuilder26_21.postLog(greaterThanDecorator_24_20);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_20_18 = lessThanDecorator_20_18.onEvent();
      if (isDirty_lessThanDecorator_20_18) {
        msgBuilder22_19.postLog(lessThanDecorator_20_18);
      }
    }
    if (isDirty_absInvoker_14_15) {
      isDirty_lessThanDecorator_28_22 = lessThanDecorator_28_22.onEvent();
      if (isDirty_lessThanDecorator_28_22) {
        msgBuilder30_23.postLog(lessThanDecorator_28_22);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    if (isDirty_greaterThanDecorator_16_16) {
      isDirty_msgBuilder18_17 = msgBuilder18_17.buildMessage();
      if (isDirty_msgBuilder18_17) {
        asciiConsoleLogger_13.publishMessage(msgBuilder18_17);
      }
    }
    if (isDirty_lessThanDecorator_20_18) {
      isDirty_msgBuilder22_19 = msgBuilder22_19.buildMessage();
      if (isDirty_msgBuilder22_19) {
        asciiConsoleLogger_13.publishMessage(msgBuilder22_19);
      }
    }
    if (isDirty_greaterThanDecorator_24_20) {
      isDirty_msgBuilder26_21 = msgBuilder26_21.buildMessage();
      if (isDirty_msgBuilder26_21) {
        asciiConsoleLogger_13.publishMessage(msgBuilder26_21);
      }
    }
    if (isDirty_lessThanDecorator_28_22) {
      isDirty_msgBuilder30_23 = msgBuilder30_23.buildMessage();
      if (isDirty_msgBuilder30_23) {
        asciiConsoleLogger_13.publishMessage(msgBuilder30_23);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_15.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_5 | isDirty_cumSumInvoker_3_10) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_6
        | isDirty_fxTradeHandlerStringFilter_7
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_9) {
      cumSumInvoker_3_10.afterCalculate();
    }
  }

  private void handle_FxTrade_NoFilter(
      com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandler_0 = fxTradeHandler_0.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_0) {
      msgBuilder12_14.postLog(fxTradeHandler_0);
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder8_12 = msgBuilder8_12.buildMessage();
      if (isDirty_msgBuilder8_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder8_12);
      }
    }
    if (isDirty_fxTradeHandler_0) {
      isDirty_msgBuilder12_14 = msgBuilder12_14.buildMessage();
      if (isDirty_msgBuilder12_14) {
        asciiConsoleLogger_13.publishMessage(msgBuilder12_14);
      }
    }
    //event stack unwind callbacks
  }

  @Override
  public void afterEvent() {
    msgBuilder30_23.afterEvent();
    msgBuilder26_21.afterEvent();
    msgBuilder22_19.afterEvent();
    msgBuilder18_17.afterEvent();
    msgBuilder12_14.afterEvent();
    msgBuilder8_12.afterEvent();
    isDirty_greaterThanDecorator_24_20 = false;
    isDirty_fxTradeHandlerStringFilter_1 = false;
    isDirty_fxTradeHandlerStringFilter_3 = false;
    isDirty_cumSumInvoker_1_5 = false;
    isDirty_msgBuilder22_19 = false;
    isDirty_msgBuilder30_23 = false;
    isDirty_fxTradeHandlerStringFilter_7 = false;
    isDirty_fxTradeHandlerStringFilter_9 = false;
    isDirty_eurNetPos = false;
    isDirty_fxTradeHandler_0 = false;
    isDirty_lessThanDecorator_28_22 = false;
    isDirty_msgBuilder12_14 = false;
    isDirty_fxTradeHandlerStringFilter_2 = false;
    isDirty_fxTradeHandlerStringFilter_4 = false;
    isDirty_msgBuilder18_17 = false;
    isDirty_msgBuilder26_21 = false;
    isDirty_fxTradeHandlerStringFilter_6 = false;
    isDirty_fxTradeHandlerStringFilter_8 = false;
    isDirty_cumSumInvoker_3_10 = false;
    isDirty_absInvoker_14_15 = false;
    isDirty_greaterThanDecorator_16_16 = false;
    isDirty_lessThanDecorator_20_18 = false;
    isDirty_msgBuilder8_12 = false;
  }

  @Override
  public void init() {
    cumSumInvoker_1_5.init();
    cumSumInvoker_3_10.init();
    eurNetPos.init();
    absInvoker_14_15.init();
    greaterThanDecorator_16_16.init();
    greaterThanDecorator_24_20.init();
    lessThanDecorator_20_18.init();
    lessThanDecorator_28_22.init();
    msgBuilder8_12.init();
    msgBuilder12_14.init();
    msgBuilder18_17.init();
    msgBuilder22_19.init();
    msgBuilder26_21.init();
    msgBuilder30_23.init();
    asciiConsoleLogger_13.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
