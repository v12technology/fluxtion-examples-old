package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.declarative.ext.example1.generated.FxTradeHandlerStringFilter;
import com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_1;
import com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_3;
import com.fluxtion.learning.declarative.ext.example1.generated.SubtractInvoker_6;
import com.fluxtion.learning.declarative.ext.example1.generated.AbsInvoker_14;
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
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.learning.declarative.ext.helpers.FxTrade;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class FxTradeMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_5 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_8 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_11 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_14 =
      new FxTradeHandlerStringFilter();
  private final CumSumInvoker_1 cumSumInvoker_1_17 = new CumSumInvoker_1();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_20 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_23 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_26 =
      new FxTradeHandlerStringFilter();
  private final FxTradeHandlerStringFilter fxTradeHandlerStringFilter_29 =
      new FxTradeHandlerStringFilter();
  private final CumSumInvoker_3 cumSumInvoker_3_32 = new CumSumInvoker_3();
  public final SubtractInvoker_6 eurNetPos = new SubtractInvoker_6();
  private final AbsInvoker_14 absInvoker_14_47 = new AbsInvoker_14();
  private final FxTradeHandler fxTradeHandler_2 = new FxTradeHandler();
  private final GreaterThanDecorator_16 greaterThanDecorator_16_50 = new GreaterThanDecorator_16();
  private final GreaterThanDecorator_24 greaterThanDecorator_24_62 = new GreaterThanDecorator_24();
  private final LessThanDecorator_20 lessThanDecorator_20_56 = new LessThanDecorator_20();
  private final LessThanDecorator_28 lessThanDecorator_28_68 = new LessThanDecorator_28();
  private final MsgBuilder8 msgBuilder8_38 = new MsgBuilder8();
  private final MsgBuilder12 msgBuilder12_44 = new MsgBuilder12();
  private final MsgBuilder18 msgBuilder18_53 = new MsgBuilder18();
  private final MsgBuilder22 msgBuilder22_59 = new MsgBuilder22();
  private final MsgBuilder26 msgBuilder26_65 = new MsgBuilder26();
  private final MsgBuilder30 msgBuilder30_71 = new MsgBuilder30();
  private final AsciiConsoleLogger asciiConsoleLogger_41 = new AsciiConsoleLogger();
  //Dirty flags
  private boolean isDirty_lessThanDecorator_28_68 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_11 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_5 = false;
  private boolean isDirty_msgBuilder12_44 = false;
  private boolean isDirty_cumSumInvoker_1_17 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_23 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_29 = false;
  private boolean isDirty_msgBuilder22_59 = false;
  private boolean isDirty_msgBuilder30_71 = false;
  private boolean isDirty_eurNetPos = false;
  private boolean isDirty_fxTradeHandler_2 = false;
  private boolean isDirty_greaterThanDecorator_24_62 = false;
  private boolean isDirty_msgBuilder8_38 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_14 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_8 = false;
  private boolean isDirty_msgBuilder18_53 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_20 = false;
  private boolean isDirty_fxTradeHandlerStringFilter_26 = false;
  private boolean isDirty_cumSumInvoker_3_32 = false;
  private boolean isDirty_msgBuilder26_65 = false;
  private boolean isDirty_absInvoker_14_47 = false;
  private boolean isDirty_greaterThanDecorator_16_50 = false;
  private boolean isDirty_lessThanDecorator_20_56 = false;
  //Filter constants

  public FxTradeMonitor() {
    fxTradeHandlerStringFilter_5.filter = "EU";
    fxTradeHandlerStringFilter_8.filter = "EC";
    fxTradeHandlerStringFilter_11.filter = "EG";
    fxTradeHandlerStringFilter_14.filter = "EY";
    cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0 =
        new FxTradeHandlerStringFilter[4];
    cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0[0] = fxTradeHandlerStringFilter_5;
    cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0[1] = fxTradeHandlerStringFilter_8;
    cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0[2] =
        fxTradeHandlerStringFilter_11;
    cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0[3] =
        fxTradeHandlerStringFilter_14;
    fxTradeHandlerStringFilter_20.filter = "UE";
    fxTradeHandlerStringFilter_23.filter = "CE";
    fxTradeHandlerStringFilter_26.filter = "GE";
    fxTradeHandlerStringFilter_29.filter = "YE";
    cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2 =
        new FxTradeHandlerStringFilter[4];
    cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2[0] =
        fxTradeHandlerStringFilter_20;
    cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2[1] =
        fxTradeHandlerStringFilter_23;
    cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2[2] =
        fxTradeHandlerStringFilter_26;
    cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2[3] =
        fxTradeHandlerStringFilter_29;
    eurNetPos.source_CumSumInvoker_3_5 = cumSumInvoker_3_32;
    eurNetPos.source_CumSumInvoker_1_4 = cumSumInvoker_1_17;
    absInvoker_14_47.source_SubtractInvoker_6_13 = eurNetPos;
    greaterThanDecorator_16_50.source_AbsInvoker_14_15 = absInvoker_14_47;
    greaterThanDecorator_24_62.source_AbsInvoker_14_23 = absInvoker_14_47;
    lessThanDecorator_20_56.source_AbsInvoker_14_19 = absInvoker_14_47;
    lessThanDecorator_28_68.source_AbsInvoker_14_27 = absInvoker_14_47;
    msgBuilder8_38.source_FxTradeHandler_7 = fxTradeHandler_2;
    msgBuilder8_38.logLevel = (int) 3;
    msgBuilder8_38.initCapacity = (int) 256;
    msgBuilder12_44.source_CumSumInvoker_3_11 = cumSumInvoker_3_32;
    msgBuilder12_44.source_SubtractInvoker_6_9 = eurNetPos;
    msgBuilder12_44.source_CumSumInvoker_1_10 = cumSumInvoker_1_17;
    msgBuilder12_44.logNotifier = fxTradeHandler_2;
    msgBuilder12_44.logLevel = (int) 3;
    msgBuilder12_44.initCapacity = (int) 256;
    msgBuilder18_53.source_SubtractInvoker_6_17 = eurNetPos;
    msgBuilder18_53.logNotifier = greaterThanDecorator_16_50;
    msgBuilder18_53.logLevel = (int) 2;
    msgBuilder18_53.initCapacity = (int) 256;
    msgBuilder22_59.source_SubtractInvoker_6_21 = eurNetPos;
    msgBuilder22_59.logNotifier = lessThanDecorator_20_56;
    msgBuilder22_59.logLevel = (int) 2;
    msgBuilder22_59.initCapacity = (int) 256;
    msgBuilder26_65.source_SubtractInvoker_6_25 = eurNetPos;
    msgBuilder26_65.logNotifier = greaterThanDecorator_24_62;
    msgBuilder26_65.logLevel = (int) 1;
    msgBuilder26_65.initCapacity = (int) 256;
    msgBuilder30_71.source_SubtractInvoker_6_29 = eurNetPos;
    msgBuilder30_71.logNotifier = lessThanDecorator_28_68;
    msgBuilder30_71.logLevel = (int) 1;
    msgBuilder30_71.initCapacity = (int) 256;
    asciiConsoleLogger_41.initCapacity = (int) 512;
    asciiConsoleLogger_41.msgBuilders = new MsgBuilder[6];
    asciiConsoleLogger_41.msgBuilders[0] = msgBuilder8_38;
    asciiConsoleLogger_41.msgBuilders[1] = msgBuilder12_44;
    asciiConsoleLogger_41.msgBuilders[2] = msgBuilder18_53;
    asciiConsoleLogger_41.msgBuilders[3] = msgBuilder22_59;
    asciiConsoleLogger_41.msgBuilders[4] = msgBuilder26_65;
    asciiConsoleLogger_41.msgBuilders[5] = msgBuilder30_71;
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
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
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
    isDirty_msgBuilder8_38 = msgBuilder8_38.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder12_44 = msgBuilder12_44.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder18_53 = msgBuilder18_53.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder22_59 = msgBuilder22_59.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder26_65 = msgBuilder26_65.controlLogIdFilter(typedEvent);
    isDirty_msgBuilder30_71 = msgBuilder30_71.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    isDirty_msgBuilder8_38 = msgBuilder8_38.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder12_44 = msgBuilder12_44.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder18_53 = msgBuilder18_53.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder22_59 = msgBuilder22_59.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder26_65 = msgBuilder26_65.controlLogLevelFilter(typedEvent);
    isDirty_msgBuilder30_71 = msgBuilder30_71.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_41.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_41.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    asciiConsoleLogger_41.controlTimeLogging(typedEvent);
  }

  private void handle_FxTrade_CE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_23 = fxTradeHandlerStringFilter_23.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_23) {
      cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_23);
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
      if (isDirty_cumSumInvoker_3_32) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      cumSumInvoker_3_32.afterCalculate();
    }
  }

  private void handle_FxTrade_EC(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_8 = fxTradeHandlerStringFilter_8.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_8) {
      cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_8);
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
      if (isDirty_cumSumInvoker_1_17) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      cumSumInvoker_1_17.afterCalculate();
    }
  }

  private void handle_FxTrade_EG(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_11 = fxTradeHandlerStringFilter_11.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_11) {
      cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_11);
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
      if (isDirty_cumSumInvoker_1_17) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      cumSumInvoker_1_17.afterCalculate();
    }
  }

  private void handle_FxTrade_EU(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_5 = fxTradeHandlerStringFilter_5.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_5) {
      cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_5);
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
      if (isDirty_cumSumInvoker_1_17) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      cumSumInvoker_1_17.afterCalculate();
    }
  }

  private void handle_FxTrade_EY(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_14 = fxTradeHandlerStringFilter_14.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_14) {
      cumSumInvoker_1_17.sourceUpdated_FxTradeHandlerStringFilter_0(fxTradeHandlerStringFilter_14);
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      isDirty_cumSumInvoker_1_17 = cumSumInvoker_1_17.onEvent();
      if (isDirty_cumSumInvoker_1_17) {
        eurNetPos.sourceChange_source_CumSumInvoker_1_4(cumSumInvoker_1_17);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_5
        | isDirty_fxTradeHandlerStringFilter_8
        | isDirty_fxTradeHandlerStringFilter_11
        | isDirty_fxTradeHandlerStringFilter_14) {
      cumSumInvoker_1_17.afterCalculate();
    }
  }

  private void handle_FxTrade_GE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_26 = fxTradeHandlerStringFilter_26.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_26) {
      cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_26);
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
      if (isDirty_cumSumInvoker_3_32) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      cumSumInvoker_3_32.afterCalculate();
    }
  }

  private void handle_FxTrade_UE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_20 = fxTradeHandlerStringFilter_20.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_20) {
      cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_20);
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
      if (isDirty_cumSumInvoker_3_32) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      cumSumInvoker_3_32.afterCalculate();
    }
  }

  private void handle_FxTrade_YE(com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandlerStringFilter_29 = fxTradeHandlerStringFilter_29.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandlerStringFilter_29) {
      cumSumInvoker_3_32.sourceUpdated_FxTradeHandlerStringFilter_2(fxTradeHandlerStringFilter_29);
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      isDirty_cumSumInvoker_3_32 = cumSumInvoker_3_32.onEvent();
      if (isDirty_cumSumInvoker_3_32) {
        eurNetPos.sourceChange_source_CumSumInvoker_3_5(cumSumInvoker_3_32);
      }
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      isDirty_eurNetPos = eurNetPos.onEvent();
      if (isDirty_eurNetPos) {
        absInvoker_14_47.sourceChange_source_SubtractInvoker_6_13(eurNetPos);
      }
    }
    if (isDirty_eurNetPos) {
      isDirty_absInvoker_14_47 = absInvoker_14_47.onEvent();
    }
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_16_50 = greaterThanDecorator_16_50.onEvent();
      if (isDirty_greaterThanDecorator_16_50) {
        msgBuilder18_53.postLog(greaterThanDecorator_16_50);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_greaterThanDecorator_24_62 = greaterThanDecorator_24_62.onEvent();
      if (isDirty_greaterThanDecorator_24_62) {
        msgBuilder26_65.postLog(greaterThanDecorator_24_62);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_20_56 = lessThanDecorator_20_56.onEvent();
      if (isDirty_lessThanDecorator_20_56) {
        msgBuilder22_59.postLog(lessThanDecorator_20_56);
      }
    }
    if (isDirty_absInvoker_14_47) {
      isDirty_lessThanDecorator_28_68 = lessThanDecorator_28_68.onEvent();
      if (isDirty_lessThanDecorator_28_68) {
        msgBuilder30_71.postLog(lessThanDecorator_28_68);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    if (isDirty_greaterThanDecorator_16_50) {
      isDirty_msgBuilder18_53 = msgBuilder18_53.buildMessage();
      if (isDirty_msgBuilder18_53) {
        asciiConsoleLogger_41.publishMessage(msgBuilder18_53);
      }
    }
    if (isDirty_lessThanDecorator_20_56) {
      isDirty_msgBuilder22_59 = msgBuilder22_59.buildMessage();
      if (isDirty_msgBuilder22_59) {
        asciiConsoleLogger_41.publishMessage(msgBuilder22_59);
      }
    }
    if (isDirty_greaterThanDecorator_24_62) {
      isDirty_msgBuilder26_65 = msgBuilder26_65.buildMessage();
      if (isDirty_msgBuilder26_65) {
        asciiConsoleLogger_41.publishMessage(msgBuilder26_65);
      }
    }
    if (isDirty_lessThanDecorator_28_68) {
      isDirty_msgBuilder30_71 = msgBuilder30_71.buildMessage();
      if (isDirty_msgBuilder30_71) {
        asciiConsoleLogger_41.publishMessage(msgBuilder30_71);
      }
    }
    //event stack unwind callbacks
    if (isDirty_eurNetPos) {
      absInvoker_14_47.afterCalculate();
    }
    if (isDirty_cumSumInvoker_1_17 | isDirty_cumSumInvoker_3_32) {
      eurNetPos.afterCalculate();
    }
    if (isDirty_fxTradeHandlerStringFilter_20
        | isDirty_fxTradeHandlerStringFilter_23
        | isDirty_fxTradeHandlerStringFilter_26
        | isDirty_fxTradeHandlerStringFilter_29) {
      cumSumInvoker_3_32.afterCalculate();
    }
  }

  private void handle_FxTrade_NoFilter(
      com.fluxtion.learning.declarative.ext.helpers.FxTrade typedEvent) {
    //method body - invoke call tree
    isDirty_fxTradeHandler_2 = fxTradeHandler_2.handleFxTrade(typedEvent);
    if (isDirty_fxTradeHandler_2) {
      msgBuilder12_44.postLog(fxTradeHandler_2);
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder8_38 = msgBuilder8_38.buildMessage();
      if (isDirty_msgBuilder8_38) {
        asciiConsoleLogger_41.publishMessage(msgBuilder8_38);
      }
    }
    if (isDirty_fxTradeHandler_2) {
      isDirty_msgBuilder12_44 = msgBuilder12_44.buildMessage();
      if (isDirty_msgBuilder12_44) {
        asciiConsoleLogger_41.publishMessage(msgBuilder12_44);
      }
    }
    //event stack unwind callbacks
  }

  @Override
  public void afterEvent() {
    msgBuilder30_71.afterEvent();
    msgBuilder26_65.afterEvent();
    msgBuilder22_59.afterEvent();
    msgBuilder18_53.afterEvent();
    msgBuilder12_44.afterEvent();
    msgBuilder8_38.afterEvent();
    isDirty_lessThanDecorator_28_68 = false;
    isDirty_fxTradeHandlerStringFilter_11 = false;
    isDirty_fxTradeHandlerStringFilter_5 = false;
    isDirty_msgBuilder12_44 = false;
    isDirty_cumSumInvoker_1_17 = false;
    isDirty_fxTradeHandlerStringFilter_23 = false;
    isDirty_fxTradeHandlerStringFilter_29 = false;
    isDirty_msgBuilder22_59 = false;
    isDirty_msgBuilder30_71 = false;
    isDirty_eurNetPos = false;
    isDirty_fxTradeHandler_2 = false;
    isDirty_greaterThanDecorator_24_62 = false;
    isDirty_msgBuilder8_38 = false;
    isDirty_fxTradeHandlerStringFilter_14 = false;
    isDirty_fxTradeHandlerStringFilter_8 = false;
    isDirty_msgBuilder18_53 = false;
    isDirty_fxTradeHandlerStringFilter_20 = false;
    isDirty_fxTradeHandlerStringFilter_26 = false;
    isDirty_cumSumInvoker_3_32 = false;
    isDirty_msgBuilder26_65 = false;
    isDirty_absInvoker_14_47 = false;
    isDirty_greaterThanDecorator_16_50 = false;
    isDirty_lessThanDecorator_20_56 = false;
  }

  @Override
  public void init() {
    cumSumInvoker_1_17.init();
    cumSumInvoker_3_32.init();
    eurNetPos.init();
    absInvoker_14_47.init();
    greaterThanDecorator_16_50.init();
    greaterThanDecorator_24_62.init();
    lessThanDecorator_20_56.init();
    lessThanDecorator_28_68.init();
    msgBuilder8_38.init();
    msgBuilder12_44.init();
    msgBuilder18_53.init();
    msgBuilder22_59.init();
    msgBuilder26_65.init();
    msgBuilder30_71.init();
    asciiConsoleLogger_41.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
