package com.fluxtion.learning.utils.diamond.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.utils.diamond.DefaultNumeric;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class Calculator implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final NumericSignalHandler numericSignalHandler_0 = new NumericSignalHandler();
  private final GreaterThanDecorator_1 greaterThanDecorator_1_1 = new GreaterThanDecorator_1();
  private final MultiplyInvoker_3 multiplyInvoker_3_2 = new MultiplyInvoker_3();
  private final DefaultNumeric defaultNumeric_3 = new DefaultNumeric(0.0, multiplyInvoker_3_2);
  public final AddInvoker_6 merged = new AddInvoker_6();
  private final MsgBuilder8 msgBuilder8_5 = new MsgBuilder8();
  private final MsgBuilder10 msgBuilder10_7 = new MsgBuilder10();
  private final AsciiConsoleLogger asciiConsoleLogger_6 = new AsciiConsoleLogger();
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  public final HdrProfiler profiler = new HdrProfiler();
  public final Tracer propertyTracer = new Tracer();
  //Dirty flags
  private boolean isDirty_greaterThanDecorator_1_1 = false;
  private boolean isDirty_msgBuilder10_7 = false;
  private boolean isDirty_numericSignalHandler_0 = false;
  private boolean isDirty_multiplyInvoker_3_2 = false;
  private boolean isDirty_msgBuilder8_5 = false;
  private boolean isDirty_merged = false;
  private boolean isDirty_defaultNumeric_3 = false;
  //Filter constants

  public Calculator() {
    greaterThanDecorator_1_1.filterSubject = numericSignalHandler_0;
    greaterThanDecorator_1_1.source_NumericSignalHandler_0 = numericSignalHandler_0;
    multiplyInvoker_3_2.source_GreaterThanDecorator_1_2 = greaterThanDecorator_1_1;
    defaultNumeric_3.intValue = (int) 0;
    defaultNumeric_3.longValue = (long) 0;
    defaultNumeric_3.doubleValue = (double) 0.0;
    merged.source_DefaultNumeric_5 = defaultNumeric_3;
    merged.source_NumericSignalHandler_4 = numericSignalHandler_0;
    msgBuilder8_5.source_DefaultNumeric_7 = defaultNumeric_3;
    msgBuilder8_5.logLevel = (int) 3;
    msgBuilder8_5.initCapacity = (int) 256;
    msgBuilder10_7.source_AddInvoker_6_9 = merged;
    msgBuilder10_7.logLevel = (int) 3;
    msgBuilder10_7.initCapacity = (int) 256;
    asciiConsoleLogger_6.initCapacity = (int) 512;
    asciiConsoleLogger_6.msgBuilders = new MsgBuilder[2];
    asciiConsoleLogger_6.msgBuilders[0] = msgBuilder8_5;
    asciiConsoleLogger_6.msgBuilders[1] = msgBuilder10_7;
    //node auditors
    initialiseAuditor(delegatingAuditor);
    initialiseAuditor(logger);
    initialiseAuditor(profiler);
    initialiseAuditor(propertyTracer);
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
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
      case ("com.fluxtion.runtime.plugin.events.NumericSignal"):
        {
          NumericSignal typedEvent = (NumericSignal) event;
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

  public void handleEvent(NumericSignal typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(
        numericSignalHandler_0, "numericSignalHandler_0", "handleNumericSignal", typedEvent);
    isDirty_numericSignalHandler_0 = numericSignalHandler_0.handleNumericSignal(typedEvent);
    if (isDirty_numericSignalHandler_0) {
      merged.sourceChange_source_NumericSignalHandler_4(numericSignalHandler_0);
    }
    if (isDirty_numericSignalHandler_0) {
      auditInvocation(greaterThanDecorator_1_1, "greaterThanDecorator_1_1", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_1_1 = greaterThanDecorator_1_1.onEvent();
      if (isDirty_greaterThanDecorator_1_1) {
        multiplyInvoker_3_2.sourceChange_source_GreaterThanDecorator_1_2(greaterThanDecorator_1_1);
      }
    }
    if (isDirty_greaterThanDecorator_1_1) {
      auditInvocation(multiplyInvoker_3_2, "multiplyInvoker_3_2", "onEvent", typedEvent);
      isDirty_multiplyInvoker_3_2 = multiplyInvoker_3_2.onEvent();
    }
    if (isDirty_multiplyInvoker_3_2) {
      auditInvocation(defaultNumeric_3, "defaultNumeric_3", "update", typedEvent);
      isDirty_defaultNumeric_3 = defaultNumeric_3.update();
      if (isDirty_defaultNumeric_3) {
        merged.sourceChange_source_DefaultNumeric_5(defaultNumeric_3);
      }
    }
    if (isDirty_numericSignalHandler_0 | isDirty_defaultNumeric_3) {
      auditInvocation(merged, "merged", "onEvent", typedEvent);
      isDirty_merged = merged.onEvent();
    }
    if (isDirty_defaultNumeric_3) {
      auditInvocation(msgBuilder8_5, "msgBuilder8_5", "buildMessage", typedEvent);
      isDirty_msgBuilder8_5 = msgBuilder8_5.buildMessage();
      if (isDirty_msgBuilder8_5) {
        asciiConsoleLogger_6.publishMessage(msgBuilder8_5);
      }
    }
    if (isDirty_merged) {
      auditInvocation(msgBuilder10_7, "msgBuilder10_7", "buildMessage", typedEvent);
      isDirty_msgBuilder10_7 = msgBuilder10_7.buildMessage();
      if (isDirty_msgBuilder10_7) {
        asciiConsoleLogger_6.publishMessage(msgBuilder10_7);
      }
    }
    //event stack unwind callbacks
    if (isDirty_greaterThanDecorator_1_1) {
      multiplyInvoker_3_2.afterCalculate();
    }
    if (isDirty_numericSignalHandler_0 | isDirty_defaultNumeric_3) {
      merged.afterCalculate();
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
    auditInvocation(msgBuilder8_5, "msgBuilder8_5", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder8_5 = msgBuilder8_5.controlLogIdFilter(typedEvent);
    auditInvocation(msgBuilder10_7, "msgBuilder10_7", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder10_7 = msgBuilder10_7.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(msgBuilder8_5, "msgBuilder8_5", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder8_5 = msgBuilder8_5.controlLogLevelFilter(typedEvent);
    auditInvocation(msgBuilder10_7, "msgBuilder10_7", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder10_7 = msgBuilder10_7.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(
        asciiConsoleLogger_6, "asciiConsoleLogger_6", "controlLevelLogging", typedEvent);
    asciiConsoleLogger_6.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(asciiConsoleLogger_6, "asciiConsoleLogger_6", "controlIdLogging", typedEvent);
    asciiConsoleLogger_6.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(asciiConsoleLogger_6, "asciiConsoleLogger_6", "controlTimeLogging", typedEvent);
    asciiConsoleLogger_6.controlTimeLogging(typedEvent);
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
    auditor.nodeRegistered(numericSignalHandler_0, "numericSignalHandler_0");
    auditor.nodeRegistered(greaterThanDecorator_1_1, "greaterThanDecorator_1_1");
    auditor.nodeRegistered(multiplyInvoker_3_2, "multiplyInvoker_3_2");
    auditor.nodeRegistered(defaultNumeric_3, "defaultNumeric_3");
    auditor.nodeRegistered(merged, "merged");
    auditor.nodeRegistered(msgBuilder8_5, "msgBuilder8_5");
    auditor.nodeRegistered(msgBuilder10_7, "msgBuilder10_7");
    auditor.nodeRegistered(asciiConsoleLogger_6, "asciiConsoleLogger_6");
  }

  @Override
  public void afterEvent() {
    msgBuilder10_7.afterEvent();
    msgBuilder8_5.afterEvent();
    defaultNumeric_3.afterEvent();
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_greaterThanDecorator_1_1 = false;
    isDirty_msgBuilder10_7 = false;
    isDirty_numericSignalHandler_0 = false;
    isDirty_multiplyInvoker_3_2 = false;
    isDirty_msgBuilder8_5 = false;
    isDirty_merged = false;
    isDirty_defaultNumeric_3 = false;
  }

  @Override
  public void init() {
    greaterThanDecorator_1_1.init();
    multiplyInvoker_3_2.init();
    merged.init();
    msgBuilder8_5.init();
    msgBuilder10_7.init();
    asciiConsoleLogger_6.init();
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
