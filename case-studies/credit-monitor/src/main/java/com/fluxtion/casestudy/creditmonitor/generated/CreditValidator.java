package com.fluxtion.casestudy.creditmonitor.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.creditmonitor.Rules;
import com.fluxtion.casestudy.creditmonitor.volatility.CreditRisk;
import com.fluxtion.casestudy.creditmonitor.volatility.MarketSentiment;
import com.fluxtion.casestudy.creditmonitor.UserContext;
import com.fluxtion.casestudy.creditmonitor.Rules.LocationRule;
import com.fluxtion.casestudy.creditmonitor.Rules.OrderRateRule;
import com.fluxtion.casestudy.creditmonitor.volatility.VolatilityCalc;
import com.fluxtion.casestudy.creditmonitor.Rules.MaxOrderSizeRule;
import com.fluxtion.casestudy.creditmonitor.CreditFailReporter;
import com.fluxtion.casestudy.creditmonitor.TransactionPublisher;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder;
import com.fluxtion.casestudy.creditmonitor.events.RejectAll;
import com.fluxtion.casestudy.creditmonitor.volatility.events.CreditRiskUpdate;
import com.fluxtion.casestudy.creditmonitor.volatility.events.InterestRateEvent;
import com.fluxtion.casestudy.creditmonitor.volatility.events.MarketTrades;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ConfigurationEvent;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.events.TimingPulseEvent;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;

public class CreditValidator implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final CreditRisk creditRisk_17 = new CreditRisk();
  private final MarketSentiment marketSentiment_16 = new MarketSentiment();
  private final UserContext userContext_2 = new UserContext();
  private final LocationRule locationRule_5 = new LocationRule(userContext_2);
  private final OrderRateRule orderRateRule_11 = new OrderRateRule(userContext_2);
  private final VolatilityCalc volatilityCalc_19 =
      new VolatilityCalc(creditRisk_17, marketSentiment_16);
  private final MaxOrderSizeRule maxOrderSizeRule_8 =
      new MaxOrderSizeRule(volatilityCalc_19, userContext_2);
  private final CreditFailReporter creditFailReporter_14 =
      new CreditFailReporter(new Rules[] {locationRule_5, maxOrderSizeRule_8, orderRateRule_11});
  public final TransactionPublisher txPublisher =
      new TransactionPublisher(creditFailReporter_14, userContext_2);
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  public final HdrProfiler profiler = new HdrProfiler();
  public final Tracer propertyTracer = new Tracer();
  //Dirty flags
  private boolean isDirty_locationRule_5 = false;
  private boolean isDirty_orderRateRule_11 = false;
  private boolean isDirty_maxOrderSizeRule_8 = false;
  //Filter constants

  public CreditValidator() {
    //node auditors
    initialiseAuditor(delegatingAuditor);
    initialiseAuditor(logger);
    initialiseAuditor(profiler);
    initialiseAuditor(propertyTracer);
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (TimingPulseEvent.ID):
        {
          TimingPulseEvent typedEvent = (TimingPulseEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
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
      case ("com.fluxtion.casestudy.creditmonitor.volatility.events.CreditRiskUpdate"):
        {
          CreditRiskUpdate typedEvent = (CreditRiskUpdate) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.casestudy.creditmonitor.volatility.events.InterestRateEvent"):
        {
          InterestRateEvent typedEvent = (InterestRateEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.casestudy.creditmonitor.volatility.events.MarketTrades"):
        {
          MarketTrades typedEvent = (MarketTrades) event;
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
    auditInvocation(userContext_2, "userContext_2", "purchseOrder", typedEvent);
    userContext_2.purchseOrder(typedEvent);
    auditInvocation(locationRule_5, "locationRule_5", "failedValidation", typedEvent);
    isDirty_locationRule_5 = locationRule_5.failedValidation();
    if (isDirty_locationRule_5) {
      creditFailReporter_14.onRuleFailure(locationRule_5);
    }
    auditInvocation(orderRateRule_11, "orderRateRule_11", "failedValidation", typedEvent);
    isDirty_orderRateRule_11 = orderRateRule_11.failedValidation();
    if (isDirty_orderRateRule_11) {
      creditFailReporter_14.onRuleFailure(orderRateRule_11);
    }
    auditInvocation(maxOrderSizeRule_8, "maxOrderSizeRule_8", "failedValidation", typedEvent);
    isDirty_maxOrderSizeRule_8 = maxOrderSizeRule_8.failedValidation();
    if (isDirty_maxOrderSizeRule_8) {
      creditFailReporter_14.onRuleFailure(maxOrderSizeRule_8);
    }
    if (isDirty_orderRateRule_11 | isDirty_maxOrderSizeRule_8 | isDirty_locationRule_5) {
      auditInvocation(
          creditFailReporter_14, "creditFailReporter_14", "processFailedRules", typedEvent);
      creditFailReporter_14.processFailedRules();
      txPublisher.failedCheck(creditFailReporter_14);
    }
    auditInvocation(txPublisher, "txPublisher", "purchaseOrder", typedEvent);
    txPublisher.purchaseOrder(typedEvent);
    auditInvocation(txPublisher, "txPublisher", "publishTransaction", typedEvent);
    txPublisher.publishTransaction();
    //event stack unwind callbacks
    userContext_2.afterEvent();
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

  public void handleEvent(CreditRiskUpdate typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(creditRisk_17, "creditRisk_17", "timePulse", typedEvent);
    creditRisk_17.timePulse(typedEvent);
    auditInvocation(volatilityCalc_19, "volatilityCalc_19", "calcVolatility", typedEvent);
    volatilityCalc_19.calcVolatility();
    auditInvocation(maxOrderSizeRule_8, "maxOrderSizeRule_8", "failedValidation", typedEvent);
    isDirty_maxOrderSizeRule_8 = maxOrderSizeRule_8.failedValidation();
    if (isDirty_maxOrderSizeRule_8) {
      creditFailReporter_14.onRuleFailure(maxOrderSizeRule_8);
    }
    if (isDirty_orderRateRule_11 | isDirty_maxOrderSizeRule_8 | isDirty_locationRule_5) {
      auditInvocation(
          creditFailReporter_14, "creditFailReporter_14", "processFailedRules", typedEvent);
      creditFailReporter_14.processFailedRules();
      txPublisher.failedCheck(creditFailReporter_14);
    }
    auditInvocation(txPublisher, "txPublisher", "publishTransaction", typedEvent);
    txPublisher.publishTransaction();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(InterestRateEvent typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(marketSentiment_16, "marketSentiment_16", "interestRates", typedEvent);
    marketSentiment_16.interestRates(typedEvent);
    auditInvocation(volatilityCalc_19, "volatilityCalc_19", "calcVolatility", typedEvent);
    volatilityCalc_19.calcVolatility();
    auditInvocation(maxOrderSizeRule_8, "maxOrderSizeRule_8", "failedValidation", typedEvent);
    isDirty_maxOrderSizeRule_8 = maxOrderSizeRule_8.failedValidation();
    if (isDirty_maxOrderSizeRule_8) {
      creditFailReporter_14.onRuleFailure(maxOrderSizeRule_8);
    }
    if (isDirty_orderRateRule_11 | isDirty_maxOrderSizeRule_8 | isDirty_locationRule_5) {
      auditInvocation(
          creditFailReporter_14, "creditFailReporter_14", "processFailedRules", typedEvent);
      creditFailReporter_14.processFailedRules();
      txPublisher.failedCheck(creditFailReporter_14);
    }
    auditInvocation(txPublisher, "txPublisher", "publishTransaction", typedEvent);
    txPublisher.publishTransaction();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(MarketTrades typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(marketSentiment_16, "marketSentiment_16", "trades", typedEvent);
    marketSentiment_16.trades(typedEvent);
    auditInvocation(volatilityCalc_19, "volatilityCalc_19", "calcVolatility", typedEvent);
    volatilityCalc_19.calcVolatility();
    auditInvocation(maxOrderSizeRule_8, "maxOrderSizeRule_8", "failedValidation", typedEvent);
    isDirty_maxOrderSizeRule_8 = maxOrderSizeRule_8.failedValidation();
    if (isDirty_maxOrderSizeRule_8) {
      creditFailReporter_14.onRuleFailure(maxOrderSizeRule_8);
    }
    if (isDirty_orderRateRule_11 | isDirty_maxOrderSizeRule_8 | isDirty_locationRule_5) {
      auditInvocation(
          creditFailReporter_14, "creditFailReporter_14", "processFailedRules", typedEvent);
      creditFailReporter_14.processFailedRules();
      txPublisher.failedCheck(creditFailReporter_14);
    }
    auditInvocation(txPublisher, "txPublisher", "publishTransaction", typedEvent);
    txPublisher.publishTransaction();
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
        auditInvocation(locationRule_5, "locationRule_5", "configUpdate", typedEvent);
        isDirty_locationRule_5 = locationRule_5.configUpdate(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.casestudy.creditmonitor.events.UserConfig"):
        auditInvocation(userContext_2, "userContext_2", "configUpdate", typedEvent);
        userContext_2.configUpdate(typedEvent);
        //event stack unwind callbacks
        userContext_2.afterEvent();
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
        auditInvocation(maxOrderSizeRule_8, "maxOrderSizeRule_8", "numericUpdate", typedEvent);
        isDirty_maxOrderSizeRule_8 = maxOrderSizeRule_8.numericUpdate(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(TimingPulseEvent typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(volatilityCalc_19, "volatilityCalc_19", "timePulse", typedEvent);
    volatilityCalc_19.timePulse(typedEvent);
    auditInvocation(volatilityCalc_19, "volatilityCalc_19", "calcVolatility", typedEvent);
    volatilityCalc_19.calcVolatility();
    auditInvocation(maxOrderSizeRule_8, "maxOrderSizeRule_8", "failedValidation", typedEvent);
    isDirty_maxOrderSizeRule_8 = maxOrderSizeRule_8.failedValidation();
    if (isDirty_maxOrderSizeRule_8) {
      creditFailReporter_14.onRuleFailure(maxOrderSizeRule_8);
    }
    if (isDirty_orderRateRule_11 | isDirty_maxOrderSizeRule_8 | isDirty_locationRule_5) {
      auditInvocation(
          creditFailReporter_14, "creditFailReporter_14", "processFailedRules", typedEvent);
      creditFailReporter_14.processFailedRules();
      txPublisher.failedCheck(creditFailReporter_14);
    }
    auditInvocation(txPublisher, "txPublisher", "publishTransaction", typedEvent);
    txPublisher.publishTransaction();
    //event stack unwind callbacks
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
    auditor.nodeRegistered(creditRisk_17, "creditRisk_17");
    auditor.nodeRegistered(marketSentiment_16, "marketSentiment_16");
    auditor.nodeRegistered(userContext_2, "userContext_2");
    auditor.nodeRegistered(locationRule_5, "locationRule_5");
    auditor.nodeRegistered(orderRateRule_11, "orderRateRule_11");
    auditor.nodeRegistered(volatilityCalc_19, "volatilityCalc_19");
    auditor.nodeRegistered(maxOrderSizeRule_8, "maxOrderSizeRule_8");
    auditor.nodeRegistered(creditFailReporter_14, "creditFailReporter_14");
    auditor.nodeRegistered(txPublisher, "txPublisher");
  }

  @Override
  public void afterEvent() {
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_locationRule_5 = false;
    isDirty_orderRateRule_11 = false;
    isDirty_maxOrderSizeRule_8 = false;
  }

  @Override
  public void init() {
    creditFailReporter_14.init();
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
