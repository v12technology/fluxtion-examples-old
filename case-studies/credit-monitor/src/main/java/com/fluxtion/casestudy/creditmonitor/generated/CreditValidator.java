package com.fluxtion.casestudy.creditmonitor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.creditmonitor.Rules;
import com.fluxtion.extension.declarative.api.log.AsciiConsoleLogger;
import com.fluxtion.casestudy.creditmonitor.UserContext;
import com.fluxtion.casestudy.creditmonitor.Rules.LocationRule;
import com.fluxtion.casestudy.creditmonitor.Rules.MaxOrderSizeRule;
import com.fluxtion.casestudy.creditmonitor.Rules.OrderRateRule;
import com.fluxtion.casestudy.creditmonitor.CreditFailReporter;
import com.fluxtion.casestudy.creditmonitor.TransactionPublisher;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder;
import com.fluxtion.casestudy.creditmonitor.events.RejectAll;
import com.fluxtion.extension.declarative.api.log.LogControlEvent;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ConfigurationEvent;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class CreditValidator implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final PurchaseOrderHandler purchaseOrderHandler_10 = new PurchaseOrderHandler();
  private final GreaterThanDecorator_1 greaterThanDecorator_1_11 = new GreaterThanDecorator_1();
  private final MsgBuilder3 msgBuilder3_12 = new MsgBuilder3();
  private final AsciiConsoleLogger asciiConsoleLogger_13 = new AsciiConsoleLogger();
  private final UserContext userContext_1 = new UserContext();
  private final LocationRule locationRule_3 = new LocationRule(userContext_1);
  private final MaxOrderSizeRule maxOrderSizeRule_5 = new MaxOrderSizeRule(userContext_1);
  private final OrderRateRule orderRateRule_7 = new OrderRateRule(userContext_1);
  private final CreditFailReporter creditFailReporter_9 =
      new CreditFailReporter(new Rules[] {locationRule_3, maxOrderSizeRule_5, orderRateRule_7});
  public final TransactionPublisher txPublisher =
      new TransactionPublisher(creditFailReporter_9, userContext_1);
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  public final HdrProfiler profiler = new HdrProfiler();
  public final Tracer propertyTracer = new Tracer();
  //Dirty flags
  private boolean isDirty_greaterThanDecorator_1_11 = false;
  private boolean isDirty_msgBuilder3_12 = false;
  private boolean isDirty_purchaseOrderHandler_10 = false;
  private boolean isDirty_locationRule_3 = false;
  private boolean isDirty_orderRateRule_7 = false;
  private boolean isDirty_maxOrderSizeRule_5 = false;
  //Filter constants

  public CreditValidator() {
    greaterThanDecorator_1_11.filterSubject = purchaseOrderHandler_10;
    greaterThanDecorator_1_11.source_PurchaseOrderHandler_0 = purchaseOrderHandler_10;
    msgBuilder3_12.source_GreaterThanDecorator_1_2 = greaterThanDecorator_1_11;
    msgBuilder3_12.logLevel = (int) 3;
    msgBuilder3_12.initCapacity = (int) 256;
    asciiConsoleLogger_13.initCapacity = (int) 512;
    asciiConsoleLogger_13.msgBuilders = new MsgBuilder[1];
    asciiConsoleLogger_13.msgBuilders[0] = msgBuilder3_12;
    logger.trace = (boolean) false;
    //node auditors
    initialiseAuditor(delegatingAuditor);
    initialiseAuditor(logger);
    initialiseAuditor(profiler);
    initialiseAuditor(propertyTracer);
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder"):
        {
          PurchaseOrder typedEvent = (PurchaseOrder) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.casestudy.creditmonitor.events.RejectAll"):
        {
          RejectAll typedEvent = (RejectAll) event;
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
      case ("com.fluxtion.runtime.plugin.events.ConfigurationEvent"):
        {
          ConfigurationEvent typedEvent = (ConfigurationEvent) event;
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

  public void handleEvent(PurchaseOrder typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(
        purchaseOrderHandler_10, "purchaseOrderHandler_10", "handlePurchaseOrder", typedEvent);
    isDirty_purchaseOrderHandler_10 = purchaseOrderHandler_10.handlePurchaseOrder(typedEvent);
    if (isDirty_purchaseOrderHandler_10) {
      auditInvocation(
          greaterThanDecorator_1_11, "greaterThanDecorator_1_11", "onEvent", typedEvent);
      isDirty_greaterThanDecorator_1_11 = greaterThanDecorator_1_11.onEvent();
    }
    if (isDirty_greaterThanDecorator_1_11) {
      auditInvocation(msgBuilder3_12, "msgBuilder3_12", "buildMessage", typedEvent);
      isDirty_msgBuilder3_12 = msgBuilder3_12.buildMessage();
      if (isDirty_msgBuilder3_12) {
        asciiConsoleLogger_13.publishMessage(msgBuilder3_12);
      }
    }
    auditInvocation(userContext_1, "userContext_1", "purchseOrder", typedEvent);
    userContext_1.purchseOrder(typedEvent);
    auditInvocation(locationRule_3, "locationRule_3", "failedValidation", typedEvent);
    isDirty_locationRule_3 = locationRule_3.failedValidation();
    if (isDirty_locationRule_3) {
      creditFailReporter_9.onRuleFailure(locationRule_3);
    }
    auditInvocation(maxOrderSizeRule_5, "maxOrderSizeRule_5", "failedValidation", typedEvent);
    isDirty_maxOrderSizeRule_5 = maxOrderSizeRule_5.failedValidation();
    if (isDirty_maxOrderSizeRule_5) {
      creditFailReporter_9.onRuleFailure(maxOrderSizeRule_5);
    }
    auditInvocation(orderRateRule_7, "orderRateRule_7", "failedValidation", typedEvent);
    isDirty_orderRateRule_7 = orderRateRule_7.failedValidation();
    if (isDirty_orderRateRule_7) {
      creditFailReporter_9.onRuleFailure(orderRateRule_7);
    }
    if (isDirty_maxOrderSizeRule_5 | isDirty_orderRateRule_7 | isDirty_locationRule_3) {
      auditInvocation(
          creditFailReporter_9, "creditFailReporter_9", "processFailedRules", typedEvent);
      creditFailReporter_9.processFailedRules();
      txPublisher.failedCheck(creditFailReporter_9);
    }
    auditInvocation(txPublisher, "txPublisher", "purchaseOrder", typedEvent);
    txPublisher.purchaseOrder(typedEvent);
    auditInvocation(txPublisher, "txPublisher", "publishTransaction", typedEvent);
    txPublisher.publishTransaction();
    //event stack unwind callbacks
    userContext_1.afterEvent();
    afterEvent();
  }

  public void handleEvent(RejectAll typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(txPublisher, "txPublisher", "rejectAll", typedEvent);
    txPublisher.rejectAll(typedEvent);
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

  public void handleEvent(ConfigurationEvent typedEvent) {
    auditEvent(typedEvent);
    switch (typedEvent.filterString()) {
      case ("com.fluxtion.casestudy.creditmonitor.events.LocationRuleConfig"):
        auditInvocation(locationRule_3, "locationRule_3", "configUpdate", typedEvent);
        isDirty_locationRule_3 = locationRule_3.configUpdate(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.casestudy.creditmonitor.events.UserConfig"):
        auditInvocation(userContext_1, "userContext_1", "configUpdate", typedEvent);
        userContext_1.configUpdate(typedEvent);
        //event stack unwind callbacks
        userContext_1.afterEvent();
        afterEvent();
        return;
    }
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
    switch (typedEvent.filterString()) {
      case ("maxOrderSize"):
        auditInvocation(maxOrderSizeRule_5, "maxOrderSizeRule_5", "numericUpdate", typedEvent);
        isDirty_maxOrderSizeRule_5 = maxOrderSizeRule_5.numericUpdate(typedEvent);
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
    auditInvocation(msgBuilder3_12, "msgBuilder3_12", "controlLogIdFilter", typedEvent);
    isDirty_msgBuilder3_12 = msgBuilder3_12.controlLogIdFilter(typedEvent);
  }

  private void handle_LogControlEvent_CHANGE_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(msgBuilder3_12, "msgBuilder3_12", "controlLogLevelFilter", typedEvent);
    isDirty_msgBuilder3_12 = msgBuilder3_12.controlLogLevelFilter(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_LEVEL(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(
        asciiConsoleLogger_13, "asciiConsoleLogger_13", "controlLevelLogging", typedEvent);
    asciiConsoleLogger_13.controlLevelLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_NAME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(asciiConsoleLogger_13, "asciiConsoleLogger_13", "controlIdLogging", typedEvent);
    asciiConsoleLogger_13.controlIdLogging(typedEvent);
  }

  private void handle_LogControlEvent_RECORD_TIME(
      com.fluxtion.extension.declarative.api.log.LogControlEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(
        asciiConsoleLogger_13, "asciiConsoleLogger_13", "controlTimeLogging", typedEvent);
    asciiConsoleLogger_13.controlTimeLogging(typedEvent);
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
    auditor.nodeRegistered(purchaseOrderHandler_10, "purchaseOrderHandler_10");
    auditor.nodeRegistered(greaterThanDecorator_1_11, "greaterThanDecorator_1_11");
    auditor.nodeRegistered(msgBuilder3_12, "msgBuilder3_12");
    auditor.nodeRegistered(asciiConsoleLogger_13, "asciiConsoleLogger_13");
    auditor.nodeRegistered(userContext_1, "userContext_1");
    auditor.nodeRegistered(locationRule_3, "locationRule_3");
    auditor.nodeRegistered(maxOrderSizeRule_5, "maxOrderSizeRule_5");
    auditor.nodeRegistered(orderRateRule_7, "orderRateRule_7");
    auditor.nodeRegistered(creditFailReporter_9, "creditFailReporter_9");
    auditor.nodeRegistered(txPublisher, "txPublisher");
  }

  @Override
  public void afterEvent() {
    msgBuilder3_12.afterEvent();
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_greaterThanDecorator_1_11 = false;
    isDirty_msgBuilder3_12 = false;
    isDirty_purchaseOrderHandler_10 = false;
    isDirty_locationRule_3 = false;
    isDirty_orderRateRule_7 = false;
    isDirty_maxOrderSizeRule_5 = false;
  }

  @Override
  public void init() {
    greaterThanDecorator_1_11.init();
    msgBuilder3_12.init();
    asciiConsoleLogger_13.init();
    creditFailReporter_9.init();
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
