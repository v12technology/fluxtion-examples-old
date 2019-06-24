package com.fluxtion.casestudy.oilsensor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.casestudy.oilsensor.nodes.AlarmNotifier;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.casestudy.oilsensor.events.DrillRpm;
import com.fluxtion.casestudy.oilsensor.events.DrillTemp;
import com.fluxtion.casestudy.oilsensor.events.SoilPressure;
import com.fluxtion.casestudy.oilsensor.events.WellPressure;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class SensorProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final DrillRpmHandler drillRpmHandler_11 = new DrillRpmHandler();
  private final DrillTempHandler drillTempHandler_16 = new DrillTempHandler();
  private final GreaterThanDecorator_17 greaterThanDecorator_17_12 = new GreaterThanDecorator_17();
  private final GreaterThanDecorator_25 greaterThanDecorator_25_17 = new GreaterThanDecorator_25();
  private final GreaterThanDecorator_33 greaterThanDecorator_33_21 = new GreaterThanDecorator_33();
  private final LessThanDecorator_21 lessThanDecorator_21_14 = new LessThanDecorator_21();
  private final LessThanDecorator_29 lessThanDecorator_29_19 = new LessThanDecorator_29();
  private final LessThanDecorator_37 lessThanDecorator_37_23 = new LessThanDecorator_37();
  private final MsgBuilder19 msgBuilder19_13 = new MsgBuilder19();
  private final MsgBuilder23 msgBuilder23_15 = new MsgBuilder23();
  private final MsgBuilder27 msgBuilder27_18 = new MsgBuilder27();
  private final MsgBuilder31 msgBuilder31_20 = new MsgBuilder31();
  private final MsgBuilder35 msgBuilder35_22 = new MsgBuilder35();
  private final MsgBuilder39 msgBuilder39_24 = new MsgBuilder39();
  private final SoilPressureHandler soilPressureHandler_25 = new SoilPressureHandler();
  private final GreaterThanDecorator_41 greaterThanDecorator_41_26 = new GreaterThanDecorator_41();
  private final GreaterThanDecorator_49 greaterThanDecorator_49_30 = new GreaterThanDecorator_49();
  private final LessThanDecorator_45 lessThanDecorator_45_28 = new LessThanDecorator_45();
  private final LessThanDecorator_53 lessThanDecorator_53_32 = new LessThanDecorator_53();
  private final MsgBuilder43 msgBuilder43_27 = new MsgBuilder43();
  private final MsgBuilder47 msgBuilder47_29 = new MsgBuilder47();
  private final MsgBuilder51 msgBuilder51_31 = new MsgBuilder51();
  private final MsgBuilder55 msgBuilder55_33 = new MsgBuilder55();
  private final WellPressureHandler wellPressureHandler_1 = new WellPressureHandler();
  private final GreaterThanDecorator_1 greaterThanDecorator_1_2 = new GreaterThanDecorator_1();
  private final GreaterThanDecorator_9 greaterThanDecorator_9_7 = new GreaterThanDecorator_9();
  private final LessThanDecorator_5 lessThanDecorator_5_5 = new LessThanDecorator_5();
  private final LessThanDecorator_13 lessThanDecorator_13_9 = new LessThanDecorator_13();
  private final MsgBuilder3 msgBuilder3_3 = new MsgBuilder3();
  private final MsgBuilder7 msgBuilder7_6 = new MsgBuilder7();
  private final MsgBuilder11 msgBuilder11_8 = new MsgBuilder11();
  private final MsgBuilder15 msgBuilder15_10 = new MsgBuilder15();
  private final AsciiConsoleLogger asciiConsoleLogger_4 = new AsciiConsoleLogger();
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  public final HdrProfiler profiler = new HdrProfiler();
  public final Tracer propertyTracer = new Tracer();
  public final AlarmNotifier alarm = new AlarmNotifier();
  //Dirty flags
  private boolean isDirty_msgBuilder51_31 = false;
  private boolean isDirty_msgBuilder3_3 = false;
  private boolean isDirty_msgBuilder55_33 = false;
  private boolean isDirty_msgBuilder39_24 = false;
  private boolean isDirty_msgBuilder23_15 = false;
  private boolean isDirty_msgBuilder15_10 = false;
  private boolean isDirty_greaterThanDecorator_33_21 = false;
  private boolean isDirty_msgBuilder19_13 = false;
  private boolean isDirty_lessThanDecorator_29_19 = false;
  private boolean isDirty_soilPressureHandler_25 = false;
  private boolean isDirty_lessThanDecorator_13_9 = false;
  private boolean isDirty_greaterThanDecorator_49_30 = false;
  private boolean isDirty_greaterThanDecorator_1_2 = false;
  private boolean isDirty_drillTempHandler_16 = false;
  private boolean isDirty_msgBuilder47_29 = false;
  private boolean isDirty_msgBuilder7_6 = false;
  private boolean isDirty_lessThanDecorator_45_28 = false;
  private boolean isDirty_lessThanDecorator_37_23 = false;
  private boolean isDirty_msgBuilder43_27 = false;
  private boolean isDirty_msgBuilder27_18 = false;
  private boolean isDirty_msgBuilder35_22 = false;
  private boolean isDirty_lessThanDecorator_5_5 = false;
  private boolean isDirty_greaterThanDecorator_17_12 = false;
  private boolean isDirty_lessThanDecorator_53_32 = false;
  private boolean isDirty_wellPressureHandler_1 = false;
  private boolean isDirty_greaterThanDecorator_25_17 = false;
  private boolean isDirty_greaterThanDecorator_9_7 = false;
  private boolean isDirty_greaterThanDecorator_41_26 = false;
  private boolean isDirty_msgBuilder31_20 = false;
  private boolean isDirty_lessThanDecorator_21_14 = false;
  private boolean isDirty_msgBuilder11_8 = false;
  private boolean isDirty_drillRpmHandler_11 = false;
  //Filter constants

  public SensorProcessor() {
    greaterThanDecorator_17_12.filterSubject = drillRpmHandler_11;
    greaterThanDecorator_17_12.source_DrillRpmHandler_16 = drillRpmHandler_11;
    greaterThanDecorator_25_17.filterSubject = drillTempHandler_16;
    greaterThanDecorator_25_17.source_DrillTempHandler_24 = drillTempHandler_16;
    greaterThanDecorator_33_21.filterSubject = drillTempHandler_16;
    greaterThanDecorator_33_21.source_DrillTempHandler_32 = drillTempHandler_16;
    lessThanDecorator_21_14.filterSubject = drillRpmHandler_11;
    lessThanDecorator_21_14.source_DrillRpmHandler_20 = drillRpmHandler_11;
    lessThanDecorator_29_19.filterSubject = drillTempHandler_16;
    lessThanDecorator_29_19.source_DrillTempHandler_28 = drillTempHandler_16;
    lessThanDecorator_37_23.filterSubject = drillTempHandler_16;
    lessThanDecorator_37_23.source_DrillTempHandler_36 = drillTempHandler_16;
    msgBuilder19_13.source_GreaterThanDecorator_17_18 = greaterThanDecorator_17_12;
    msgBuilder19_13.logLevel = (int) 3;
    msgBuilder19_13.initCapacity = (int) 256;
    msgBuilder23_15.source_LessThanDecorator_21_22 = lessThanDecorator_21_14;
    msgBuilder23_15.logLevel = (int) 3;
    msgBuilder23_15.initCapacity = (int) 256;
    msgBuilder27_18.source_GreaterThanDecorator_25_26 = greaterThanDecorator_25_17;
    msgBuilder27_18.logLevel = (int) 3;
    msgBuilder27_18.initCapacity = (int) 256;
    msgBuilder31_20.source_LessThanDecorator_29_30 = lessThanDecorator_29_19;
    msgBuilder31_20.logLevel = (int) 3;
    msgBuilder31_20.initCapacity = (int) 256;
    msgBuilder35_22.source_GreaterThanDecorator_33_34 = greaterThanDecorator_33_21;
    msgBuilder35_22.logLevel = (int) 3;
    msgBuilder35_22.initCapacity = (int) 256;
    msgBuilder39_24.source_LessThanDecorator_37_38 = lessThanDecorator_37_23;
    msgBuilder39_24.logLevel = (int) 3;
    msgBuilder39_24.initCapacity = (int) 256;
    greaterThanDecorator_41_26.filterSubject = soilPressureHandler_25;
    greaterThanDecorator_41_26.source_SoilPressureHandler_40 = soilPressureHandler_25;
    greaterThanDecorator_49_30.filterSubject = soilPressureHandler_25;
    greaterThanDecorator_49_30.source_SoilPressureHandler_48 = soilPressureHandler_25;
    lessThanDecorator_45_28.filterSubject = soilPressureHandler_25;
    lessThanDecorator_45_28.source_SoilPressureHandler_44 = soilPressureHandler_25;
    lessThanDecorator_53_32.filterSubject = soilPressureHandler_25;
    lessThanDecorator_53_32.source_SoilPressureHandler_52 = soilPressureHandler_25;
    msgBuilder43_27.source_GreaterThanDecorator_41_42 = greaterThanDecorator_41_26;
    msgBuilder43_27.logLevel = (int) 3;
    msgBuilder43_27.initCapacity = (int) 256;
    msgBuilder47_29.source_LessThanDecorator_45_46 = lessThanDecorator_45_28;
    msgBuilder47_29.logLevel = (int) 3;
    msgBuilder47_29.initCapacity = (int) 256;
    msgBuilder51_31.source_GreaterThanDecorator_49_50 = greaterThanDecorator_49_30;
    msgBuilder51_31.logLevel = (int) 3;
    msgBuilder51_31.initCapacity = (int) 256;
    msgBuilder55_33.source_LessThanDecorator_53_54 = lessThanDecorator_53_32;
    msgBuilder55_33.logLevel = (int) 3;
    msgBuilder55_33.initCapacity = (int) 256;
    greaterThanDecorator_1_2.filterSubject = wellPressureHandler_1;
    greaterThanDecorator_1_2.source_WellPressureHandler_0 = wellPressureHandler_1;
    greaterThanDecorator_9_7.filterSubject = wellPressureHandler_1;
    greaterThanDecorator_9_7.source_WellPressureHandler_8 = wellPressureHandler_1;
    lessThanDecorator_5_5.filterSubject = wellPressureHandler_1;
    lessThanDecorator_5_5.source_WellPressureHandler_4 = wellPressureHandler_1;
    lessThanDecorator_13_9.filterSubject = wellPressureHandler_1;
    lessThanDecorator_13_9.source_WellPressureHandler_12 = wellPressureHandler_1;
    msgBuilder3_3.source_GreaterThanDecorator_1_2 = greaterThanDecorator_1_2;
    msgBuilder3_3.logLevel = (int) 3;
    msgBuilder3_3.initCapacity = (int) 256;
    msgBuilder7_6.source_LessThanDecorator_5_6 = lessThanDecorator_5_5;
    msgBuilder7_6.logLevel = (int) 3;
    msgBuilder7_6.initCapacity = (int) 256;
    msgBuilder11_8.source_GreaterThanDecorator_9_10 = greaterThanDecorator_9_7;
    msgBuilder11_8.logLevel = (int) 3;
    msgBuilder11_8.initCapacity = (int) 256;
    msgBuilder15_10.source_LessThanDecorator_13_14 = lessThanDecorator_13_9;
    msgBuilder15_10.logLevel = (int) 3;
    msgBuilder15_10.initCapacity = (int) 256;
    asciiConsoleLogger_4.initCapacity = (int) 512;
    asciiConsoleLogger_4.msgBuilders = new MsgBuilder[14];
    asciiConsoleLogger_4.msgBuilders[0] = msgBuilder3_3;
    asciiConsoleLogger_4.msgBuilders[1] = msgBuilder7_6;
    asciiConsoleLogger_4.msgBuilders[2] = msgBuilder11_8;
    asciiConsoleLogger_4.msgBuilders[3] = msgBuilder15_10;
    asciiConsoleLogger_4.msgBuilders[4] = msgBuilder19_13;
    asciiConsoleLogger_4.msgBuilders[5] = msgBuilder23_15;
    asciiConsoleLogger_4.msgBuilders[6] = msgBuilder27_18;
    asciiConsoleLogger_4.msgBuilders[7] = msgBuilder31_20;
    asciiConsoleLogger_4.msgBuilders[8] = msgBuilder35_22;
    asciiConsoleLogger_4.msgBuilders[9] = msgBuilder39_24;
    asciiConsoleLogger_4.msgBuilders[10] = msgBuilder43_27;
    asciiConsoleLogger_4.msgBuilders[11] = msgBuilder47_29;
    asciiConsoleLogger_4.msgBuilders[12] = msgBuilder51_31;
    asciiConsoleLogger_4.msgBuilders[13] = msgBuilder55_33;
    //node auditors
    initialiseAuditor(delegatingAuditor);
    initialiseAuditor(logger);
    initialiseAuditor(profiler);
    initialiseAuditor(propertyTracer);
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.casestudy.oilsensor.events.DrillRpm"):
        {
          DrillRpm typedEvent = (DrillRpm) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.casestudy.oilsensor.events.DrillTemp"):
        {
          DrillTemp typedEvent = (DrillTemp) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.casestudy.oilsensor.events.SoilPressure"):
        {
          SoilPressure typedEvent = (SoilPressure) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.casestudy.oilsensor.events.WellPressure"):
        {
          WellPressure typedEvent = (WellPressure) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.extension.declarative.api.log.LogControlEvent"):
        {
          LogControlEvent typedEvent = (LogControlEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.auditing.DelegatingAuditor$AuditorRegistration"):
        {
          AuditorRegistration typedEvent = (AuditorRegistration) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent"):
        {
          ListenerRegistrationEvent typedEvent = (ListenerRegistrationEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.logging.EventLogConfig"):
        {
          EventLogConfig typedEvent = (EventLogConfig) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.tracing.TraceEvents$PublishProperties"):
        {
          PublishProperties typedEvent = (PublishProperties) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.tracing.TracerConfigEvent"):
        {
          TracerConfigEvent typedEvent = (TracerConfigEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(DrillRpm typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(drillRpmHandler_11, "drillRpmHandler_11", "handleDrillRpm", typedEvent);
    isDirty_drillRpmHandler_11 = drillRpmHandler_11.handleDrillRpm(typedEvent);
    if (isDirty_drillRpmHandler_11) {
      auditInvocation(
          greaterThanDecorator_17_12, "greaterThanDecorator_17_12", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_17_12 = greaterThanDecorator_17_12.onEvent();
    }
    if (isDirty_drillRpmHandler_11) {
      auditInvocation(lessThanDecorator_21_14, "lessThanDecorator_21_14", "onEvent", typedEvent);
      isDirty_lessThanDecorator_21_14 = lessThanDecorator_21_14.onEvent();
    }
    if (isDirty_greaterThanDecorator_17_12) {
      auditInvocation(msgBuilder19_13, "msgBuilder19_13", "buildMessage", typedEvent);
      isDirty_msgBuilder19_13 = msgBuilder19_13.buildMessage();
      if (isDirty_msgBuilder19_13) {
        asciiConsoleLogger_4.publishMessage(msgBuilder19_13);
      }
    }
    if (isDirty_lessThanDecorator_21_14) {
      auditInvocation(msgBuilder23_15, "msgBuilder23_15", "buildMessage", typedEvent);
      isDirty_msgBuilder23_15 = msgBuilder23_15.buildMessage();
      if (isDirty_msgBuilder23_15) {
        asciiConsoleLogger_4.publishMessage(msgBuilder23_15);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(DrillTemp typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(drillTempHandler_16, "drillTempHandler_16", "handleDrillTemp", typedEvent);
    isDirty_drillTempHandler_16 = drillTempHandler_16.handleDrillTemp(typedEvent);
    if (isDirty_drillTempHandler_16) {
      auditInvocation(
          greaterThanDecorator_25_17, "greaterThanDecorator_25_17", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_25_17 = greaterThanDecorator_25_17.onEvent();
    }
    if (isDirty_drillTempHandler_16) {
      auditInvocation(
          greaterThanDecorator_33_21, "greaterThanDecorator_33_21", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_33_21 = greaterThanDecorator_33_21.onEvent();
    }
    if (isDirty_drillTempHandler_16) {
      auditInvocation(lessThanDecorator_29_19, "lessThanDecorator_29_19", "onEvent", typedEvent);
      isDirty_lessThanDecorator_29_19 = lessThanDecorator_29_19.onEvent();
    }
    if (isDirty_drillTempHandler_16) {
      auditInvocation(lessThanDecorator_37_23, "lessThanDecorator_37_23", "onEvent", typedEvent);
      isDirty_lessThanDecorator_37_23 = lessThanDecorator_37_23.onEvent();
    }
    if (isDirty_greaterThanDecorator_25_17) {
      auditInvocation(msgBuilder27_18, "msgBuilder27_18", "buildMessage", typedEvent);
      isDirty_msgBuilder27_18 = msgBuilder27_18.buildMessage();
      if (isDirty_msgBuilder27_18) {
        asciiConsoleLogger_4.publishMessage(msgBuilder27_18);
      }
    }
    if (isDirty_lessThanDecorator_29_19) {
      auditInvocation(msgBuilder31_20, "msgBuilder31_20", "buildMessage", typedEvent);
      isDirty_msgBuilder31_20 = msgBuilder31_20.buildMessage();
      if (isDirty_msgBuilder31_20) {
        asciiConsoleLogger_4.publishMessage(msgBuilder31_20);
      }
    }
    if (isDirty_greaterThanDecorator_33_21) {
      auditInvocation(msgBuilder35_22, "msgBuilder35_22", "buildMessage", typedEvent);
      isDirty_msgBuilder35_22 = msgBuilder35_22.buildMessage();
      if (isDirty_msgBuilder35_22) {
        asciiConsoleLogger_4.publishMessage(msgBuilder35_22);
      }
    }
    if (isDirty_lessThanDecorator_37_23) {
      auditInvocation(msgBuilder39_24, "msgBuilder39_24", "buildMessage", typedEvent);
      isDirty_msgBuilder39_24 = msgBuilder39_24.buildMessage();
      if (isDirty_msgBuilder39_24) {
        asciiConsoleLogger_4.publishMessage(msgBuilder39_24);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(SoilPressure typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(
        soilPressureHandler_25, "soilPressureHandler_25", "handleSoilPressure", typedEvent);
    isDirty_soilPressureHandler_25 = soilPressureHandler_25.handleSoilPressure(typedEvent);
    if (isDirty_soilPressureHandler_25) {
      auditInvocation(
          greaterThanDecorator_41_26, "greaterThanDecorator_41_26", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_41_26 = greaterThanDecorator_41_26.onEvent();
    }
    if (isDirty_soilPressureHandler_25) {
      auditInvocation(
          greaterThanDecorator_49_30, "greaterThanDecorator_49_30", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_49_30 = greaterThanDecorator_49_30.onEvent();
    }
    if (isDirty_soilPressureHandler_25) {
      auditInvocation(lessThanDecorator_45_28, "lessThanDecorator_45_28", "onEvent", typedEvent);
      isDirty_lessThanDecorator_45_28 = lessThanDecorator_45_28.onEvent();
    }
    if (isDirty_soilPressureHandler_25) {
      auditInvocation(lessThanDecorator_53_32, "lessThanDecorator_53_32", "onEvent", typedEvent);
      isDirty_lessThanDecorator_53_32 = lessThanDecorator_53_32.onEvent();
    }
    if (isDirty_greaterThanDecorator_41_26) {
      auditInvocation(msgBuilder43_27, "msgBuilder43_27", "buildMessage", typedEvent);
      isDirty_msgBuilder43_27 = msgBuilder43_27.buildMessage();
      if (isDirty_msgBuilder43_27) {
        asciiConsoleLogger_4.publishMessage(msgBuilder43_27);
      }
    }
    if (isDirty_lessThanDecorator_45_28) {
      auditInvocation(msgBuilder47_29, "msgBuilder47_29", "buildMessage", typedEvent);
      isDirty_msgBuilder47_29 = msgBuilder47_29.buildMessage();
      if (isDirty_msgBuilder47_29) {
        asciiConsoleLogger_4.publishMessage(msgBuilder47_29);
      }
    }
    if (isDirty_greaterThanDecorator_49_30) {
      auditInvocation(msgBuilder51_31, "msgBuilder51_31", "buildMessage", typedEvent);
      isDirty_msgBuilder51_31 = msgBuilder51_31.buildMessage();
      if (isDirty_msgBuilder51_31) {
        asciiConsoleLogger_4.publishMessage(msgBuilder51_31);
      }
    }
    if (isDirty_lessThanDecorator_53_32) {
      auditInvocation(msgBuilder55_33, "msgBuilder55_33", "buildMessage", typedEvent);
      isDirty_msgBuilder55_33 = msgBuilder55_33.buildMessage();
      if (isDirty_msgBuilder55_33) {
        asciiConsoleLogger_4.publishMessage(msgBuilder55_33);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(WellPressure typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(
        wellPressureHandler_1, "wellPressureHandler_1", "handleWellPressure", typedEvent);
    isDirty_wellPressureHandler_1 = wellPressureHandler_1.handleWellPressure(typedEvent);
    if (isDirty_wellPressureHandler_1) {
      auditInvocation(greaterThanDecorator_1_2, "greaterThanDecorator_1_2", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_1_2 = greaterThanDecorator_1_2.onEvent();
    }
    if (isDirty_wellPressureHandler_1) {
      auditInvocation(greaterThanDecorator_9_7, "greaterThanDecorator_9_7", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_9_7 = greaterThanDecorator_9_7.onEvent();
    }
    if (isDirty_wellPressureHandler_1) {
      auditInvocation(lessThanDecorator_5_5, "lessThanDecorator_5_5", "onEvent", typedEvent);
      isDirty_lessThanDecorator_5_5 = lessThanDecorator_5_5.onEvent();
    }
    if (isDirty_wellPressureHandler_1) {
      auditInvocation(lessThanDecorator_13_9, "lessThanDecorator_13_9", "onEvent", typedEvent);
      isDirty_lessThanDecorator_13_9 = lessThanDecorator_13_9.onEvent();
    }
    if (isDirty_greaterThanDecorator_1_2) {
      auditInvocation(msgBuilder3_3, "msgBuilder3_3", "buildMessage", typedEvent);
      isDirty_msgBuilder3_3 = msgBuilder3_3.buildMessage();
      if (isDirty_msgBuilder3_3) {
        asciiConsoleLogger_4.publishMessage(msgBuilder3_3);
      }
    }
    if (isDirty_lessThanDecorator_5_5) {
      auditInvocation(msgBuilder7_6, "msgBuilder7_6", "buildMessage", typedEvent);
      isDirty_msgBuilder7_6 = msgBuilder7_6.buildMessage();
      if (isDirty_msgBuilder7_6) {
        asciiConsoleLogger_4.publishMessage(msgBuilder7_6);
      }
    }
    if (isDirty_greaterThanDecorator_9_7) {
      auditInvocation(msgBuilder11_8, "msgBuilder11_8", "buildMessage", typedEvent);
      isDirty_msgBuilder11_8 = msgBuilder11_8.buildMessage();
      if (isDirty_msgBuilder11_8) {
        asciiConsoleLogger_4.publishMessage(msgBuilder11_8);
      }
    }
    if (isDirty_lessThanDecorator_13_9) {
      auditInvocation(msgBuilder15_10, "msgBuilder15_10", "buildMessage", typedEvent);
      isDirty_msgBuilder15_10 = msgBuilder15_10.buildMessage();
      if (isDirty_msgBuilder15_10) {
        asciiConsoleLogger_4.publishMessage(msgBuilder15_10);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(LogControlEvent typedEvent) {
    auditEvent(typedEvent);
    FilteredHandlerInvoker invoker =
        dispatchStringMapLogControlEvent.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  public void handleEvent(AuditorRegistration typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(delegatingAuditor, "delegatingAuditor", "auditorRegistration", typedEvent);
    delegatingAuditor.auditorRegistration(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(ListenerRegistrationEvent typedEvent) {
    auditEvent(typedEvent);
    switch (typedEvent.filterString()) {
      case ("com.fluxtion.runtime.plugin.tracing.TraceRecordListener"):
        auditInvocation(propertyTracer, "propertyTracer", "listenerUpdate", typedEvent);
        propertyTracer.listenerUpdate(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(EventLogConfig typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(logger, "logger", "calculationLogConfig", typedEvent);
    logger.calculationLogConfig(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(PublishProperties typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(propertyTracer, "propertyTracer", "publishProperties", typedEvent);
    propertyTracer.publishProperties(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(TracerConfigEvent typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(propertyTracer, "propertyTracer", "recorderControl", typedEvent);
    propertyTracer.recorderControl(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }
  //int filter maps
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

  private void handle_LogControlEvent_CHANGE_FILTER(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(msgBuilder19_13, "msgBuilder19_13", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder19_13 = msgBuilder19_13.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder23_15, "msgBuilder23_15", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder23_15 = msgBuilder23_15.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder27_18, "msgBuilder27_18", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder27_18 = msgBuilder27_18.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder31_20, "msgBuilder31_20", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder31_20 = msgBuilder31_20.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder35_22, "msgBuilder35_22", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder35_22 = msgBuilder35_22.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder39_24, "msgBuilder39_24", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder39_24 = msgBuilder39_24.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder43_27, "msgBuilder43_27", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder43_27 = msgBuilder43_27.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder47_29, "msgBuilder47_29", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder47_29 = msgBuilder47_29.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder51_31, "msgBuilder51_31", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder51_31 = msgBuilder51_31.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder55_33, "msgBuilder55_33", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder55_33 = msgBuilder55_33.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder3_3, "msgBuilder3_3", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder3_3 = msgBuilder3_3.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder7_6, "msgBuilder7_6", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder7_6 = msgBuilder7_6.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder11_8, "msgBuilder11_8", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder11_8 = msgBuilder11_8.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder15_10, "msgBuilder15_10", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder15_10 = msgBuilder15_10.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(msgBuilder19_13, "msgBuilder19_13", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder19_13 = msgBuilder19_13.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder23_15, "msgBuilder23_15", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder23_15 = msgBuilder23_15.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder27_18, "msgBuilder27_18", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder27_18 = msgBuilder27_18.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder31_20, "msgBuilder31_20", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder31_20 = msgBuilder31_20.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder35_22, "msgBuilder35_22", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder35_22 = msgBuilder35_22.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder39_24, "msgBuilder39_24", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder39_24 = msgBuilder39_24.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder43_27, "msgBuilder43_27", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder43_27 = msgBuilder43_27.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder47_29, "msgBuilder47_29", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder47_29 = msgBuilder47_29.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder51_31, "msgBuilder51_31", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder51_31 = msgBuilder51_31.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder55_33, "msgBuilder55_33", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder55_33 = msgBuilder55_33.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder3_3, "msgBuilder3_3", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder3_3 = msgBuilder3_3.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder7_6, "msgBuilder7_6", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder7_6 = msgBuilder7_6.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder11_8, "msgBuilder11_8", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder11_8 = msgBuilder11_8.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder15_10, "msgBuilder15_10", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder15_10 = msgBuilder15_10.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(
        asciiConsoleLogger_4, "asciiConsoleLogger_4", "controlLevelLogging", typedEvent);
    asciiConsoleLogger_4.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(asciiConsoleLogger_4, "asciiConsoleLogger_4", "controlIdLogging", typedEvent);
    asciiConsoleLogger_4.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(asciiConsoleLogger_4, "asciiConsoleLogger_4", "controlTimeLogging", typedEvent);
    asciiConsoleLogger_4.controlTimeLogging(typedEvent);
  }

  private void auditEvent(Object typedEvent) {
    delegatingAuditor.eventReceived(typedEvent);
    logger.eventReceived(typedEvent);
    profiler.eventReceived(typedEvent);
    propertyTracer.eventReceived(typedEvent);
  }

  private void auditInvocation(Object node, String nodeName, String methodName, Object typedEvent) {
    delegatingAuditor.nodeInvoked(node, nodeName, methodName, typedEvent);
    profiler.nodeInvoked(node, nodeName, methodName, typedEvent);
  }

  private void initialiseAuditor(Auditor auditor) {
    auditor.init();
    auditor.nodeRegistered(drillRpmHandler_11, "drillRpmHandler_11");
    auditor.nodeRegistered(drillTempHandler_16, "drillTempHandler_16");
    auditor.nodeRegistered(greaterThanDecorator_17_12, "greaterThanDecorator_17_12");
    auditor.nodeRegistered(greaterThanDecorator_25_17, "greaterThanDecorator_25_17");
    auditor.nodeRegistered(greaterThanDecorator_33_21, "greaterThanDecorator_33_21");
    auditor.nodeRegistered(lessThanDecorator_21_14, "lessThanDecorator_21_14");
    auditor.nodeRegistered(lessThanDecorator_29_19, "lessThanDecorator_29_19");
    auditor.nodeRegistered(lessThanDecorator_37_23, "lessThanDecorator_37_23");
    auditor.nodeRegistered(msgBuilder19_13, "msgBuilder19_13");
    auditor.nodeRegistered(msgBuilder23_15, "msgBuilder23_15");
    auditor.nodeRegistered(msgBuilder27_18, "msgBuilder27_18");
    auditor.nodeRegistered(msgBuilder31_20, "msgBuilder31_20");
    auditor.nodeRegistered(msgBuilder35_22, "msgBuilder35_22");
    auditor.nodeRegistered(msgBuilder39_24, "msgBuilder39_24");
    auditor.nodeRegistered(soilPressureHandler_25, "soilPressureHandler_25");
    auditor.nodeRegistered(greaterThanDecorator_41_26, "greaterThanDecorator_41_26");
    auditor.nodeRegistered(greaterThanDecorator_49_30, "greaterThanDecorator_49_30");
    auditor.nodeRegistered(lessThanDecorator_45_28, "lessThanDecorator_45_28");
    auditor.nodeRegistered(lessThanDecorator_53_32, "lessThanDecorator_53_32");
    auditor.nodeRegistered(msgBuilder43_27, "msgBuilder43_27");
    auditor.nodeRegistered(msgBuilder47_29, "msgBuilder47_29");
    auditor.nodeRegistered(msgBuilder51_31, "msgBuilder51_31");
    auditor.nodeRegistered(msgBuilder55_33, "msgBuilder55_33");
    auditor.nodeRegistered(wellPressureHandler_1, "wellPressureHandler_1");
    auditor.nodeRegistered(greaterThanDecorator_1_2, "greaterThanDecorator_1_2");
    auditor.nodeRegistered(greaterThanDecorator_9_7, "greaterThanDecorator_9_7");
    auditor.nodeRegistered(lessThanDecorator_5_5, "lessThanDecorator_5_5");
    auditor.nodeRegistered(lessThanDecorator_13_9, "lessThanDecorator_13_9");
    auditor.nodeRegistered(msgBuilder3_3, "msgBuilder3_3");
    auditor.nodeRegistered(msgBuilder7_6, "msgBuilder7_6");
    auditor.nodeRegistered(msgBuilder11_8, "msgBuilder11_8");
    auditor.nodeRegistered(msgBuilder15_10, "msgBuilder15_10");
    auditor.nodeRegistered(asciiConsoleLogger_4, "asciiConsoleLogger_4");
    auditor.nodeRegistered(alarm, "alarm");
  }

  @Override
  public void afterEvent() {
    msgBuilder15_10.afterEvent();
    msgBuilder11_8.afterEvent();
    msgBuilder7_6.afterEvent();
    msgBuilder3_3.afterEvent();
    msgBuilder55_33.afterEvent();
    msgBuilder51_31.afterEvent();
    msgBuilder47_29.afterEvent();
    msgBuilder43_27.afterEvent();
    msgBuilder39_24.afterEvent();
    msgBuilder35_22.afterEvent();
    msgBuilder31_20.afterEvent();
    msgBuilder27_18.afterEvent();
    msgBuilder23_15.afterEvent();
    msgBuilder19_13.afterEvent();
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_msgBuilder51_31 = false;
    isDirty_msgBuilder3_3 = false;
    isDirty_msgBuilder55_33 = false;
    isDirty_msgBuilder39_24 = false;
    isDirty_msgBuilder23_15 = false;
    isDirty_msgBuilder15_10 = false;
    isDirty_greaterThanDecorator_33_21 = false;
    isDirty_msgBuilder19_13 = false;
    isDirty_lessThanDecorator_29_19 = false;
    isDirty_soilPressureHandler_25 = false;
    isDirty_lessThanDecorator_13_9 = false;
    isDirty_greaterThanDecorator_49_30 = false;
    isDirty_greaterThanDecorator_1_2 = false;
    isDirty_drillTempHandler_16 = false;
    isDirty_msgBuilder47_29 = false;
    isDirty_msgBuilder7_6 = false;
    isDirty_lessThanDecorator_45_28 = false;
    isDirty_lessThanDecorator_37_23 = false;
    isDirty_msgBuilder43_27 = false;
    isDirty_msgBuilder27_18 = false;
    isDirty_msgBuilder35_22 = false;
    isDirty_lessThanDecorator_5_5 = false;
    isDirty_greaterThanDecorator_17_12 = false;
    isDirty_lessThanDecorator_53_32 = false;
    isDirty_wellPressureHandler_1 = false;
    isDirty_greaterThanDecorator_25_17 = false;
    isDirty_greaterThanDecorator_9_7 = false;
    isDirty_greaterThanDecorator_41_26 = false;
    isDirty_msgBuilder31_20 = false;
    isDirty_lessThanDecorator_21_14 = false;
    isDirty_msgBuilder11_8 = false;
    isDirty_drillRpmHandler_11 = false;
  }

  @Override
  public void init() {
    greaterThanDecorator_17_12.init();
    greaterThanDecorator_25_17.init();
    greaterThanDecorator_33_21.init();
    lessThanDecorator_21_14.init();
    lessThanDecorator_29_19.init();
    lessThanDecorator_37_23.init();
    msgBuilder19_13.init();
    msgBuilder23_15.init();
    msgBuilder27_18.init();
    msgBuilder31_20.init();
    msgBuilder35_22.init();
    msgBuilder39_24.init();
    greaterThanDecorator_41_26.init();
    greaterThanDecorator_49_30.init();
    lessThanDecorator_45_28.init();
    lessThanDecorator_53_32.init();
    msgBuilder43_27.init();
    msgBuilder47_29.init();
    msgBuilder51_31.init();
    msgBuilder55_33.init();
    greaterThanDecorator_1_2.init();
    greaterThanDecorator_9_7.init();
    lessThanDecorator_5_5.init();
    lessThanDecorator_13_9.init();
    msgBuilder3_3.init();
    msgBuilder7_6.init();
    msgBuilder11_8.init();
    msgBuilder15_10.init();
    asciiConsoleLogger_4.init();
  }

  @Override
  public void tearDown() {
    propertyTracer.tearDown();
    profiler.tearDown();
    logger.tearDown();
    delegatingAuditor.tearDown();
  }

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
