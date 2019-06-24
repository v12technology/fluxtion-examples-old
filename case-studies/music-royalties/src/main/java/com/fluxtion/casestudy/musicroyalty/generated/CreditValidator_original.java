package com.fluxtion.casestudy.musicroyalty.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.musicroyalty.Rules;
import com.fluxtion.casestudy.musicroyalty.UserContext;
import com.fluxtion.casestudy.musicroyalty.Rules.LocationRule;
import com.fluxtion.casestudy.musicroyalty.Rules.MaxOrderSizeRule;
import com.fluxtion.casestudy.musicroyalty.Rules.OrderRateRule;
import com.fluxtion.casestudy.musicroyalty.CreditFailReporter;
import com.fluxtion.casestudy.musicroyalty.TransactionPublisher;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.casestudy.musicroyalty.events.PurchaseOrder;
import com.fluxtion.casestudy.musicroyalty.events.RejectAll;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ConfigurationEvent;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;

public class CreditValidator_original implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
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
  private boolean isDirty_locationRule_3 = false;
  private boolean isDirty_maxOrderSizeRule_5 = false;
  private boolean isDirty_orderRateRule_7 = false;
  //Filter constants

  public CreditValidator_original() {
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
    if (isDirty_locationRule_3 | isDirty_maxOrderSizeRule_5 | isDirty_orderRateRule_7) {
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
        locationRule_3.configUpdate(typedEvent);
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
    auditor.nodeRegistered(userContext_1, "userContext_1");
    auditor.nodeRegistered(locationRule_3, "locationRule_3");
    auditor.nodeRegistered(maxOrderSizeRule_5, "maxOrderSizeRule_5");
    auditor.nodeRegistered(orderRateRule_7, "orderRateRule_7");
    auditor.nodeRegistered(creditFailReporter_9, "creditFailReporter_9");
    auditor.nodeRegistered(txPublisher, "txPublisher");
  }

  @Override
  public void afterEvent() {
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_locationRule_3 = false;
    isDirty_maxOrderSizeRule_5 = false;
    isDirty_orderRateRule_7 = false;
  }

  @Override
  public void init() {
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
