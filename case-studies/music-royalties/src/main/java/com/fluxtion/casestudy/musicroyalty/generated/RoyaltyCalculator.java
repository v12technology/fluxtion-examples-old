package com.fluxtion.casestudy.musicroyalty.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.musicroyalty.calcs.LocationRoyaltyFactor;
import com.fluxtion.casestudy.musicroyalty.calcs.RoyaltyLookup;
import com.fluxtion.casestudy.musicroyalty.calcs.RevenueCalculation;
import com.fluxtion.casestudy.musicroyalty.report.ReportGenerator;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.casestudy.musicroyalty.events.StreamedTrack;
import com.fluxtion.casestudy.musicroyalty.events.TrackRoyalty;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;

public class RoyaltyCalculator implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final LocationRoyaltyFactor locationRoyaltyFactor_3 = new LocationRoyaltyFactor();
  private final RoyaltyLookup royaltyLookup_1 = new RoyaltyLookup();
  private final RevenueCalculation revenueCalculation_5 =
      new RevenueCalculation(royaltyLookup_1, locationRoyaltyFactor_3);
  public final ReportGenerator reporter = new ReportGenerator(revenueCalculation_5);
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  public final HdrProfiler profiler = new HdrProfiler();
  public final Tracer propertyTracer = new Tracer();
  //Dirty flags
  private boolean isDirty_royaltyLookup_1 = false;
  private boolean isDirty_revenueCalculation_5 = false;
  //Filter constants

  public RoyaltyCalculator() {
    locationRoyaltyFactor_3.factor = (double) 1.0;
    //node auditors
    initialiseAuditor(delegatingAuditor);
    initialiseAuditor(logger);
    initialiseAuditor(profiler);
    initialiseAuditor(propertyTracer);
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.casestudy.musicroyalty.events.StreamedTrack"):
        {
          StreamedTrack typedEvent = (StreamedTrack) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.casestudy.musicroyalty.events.TrackRoyalty"):
        {
          TrackRoyalty typedEvent = (TrackRoyalty) event;
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

  public void handleEvent(StreamedTrack typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(revenueCalculation_5, "revenueCalculation_5", "trackPlayed", typedEvent);
    isDirty_revenueCalculation_5 = revenueCalculation_5.trackPlayed(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(TrackRoyalty typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(royaltyLookup_1, "royaltyLookup_1", "royaltyData", typedEvent);
    isDirty_royaltyLookup_1 = royaltyLookup_1.royaltyData(typedEvent);
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
      case ("filterString"):
        auditInvocation(
            locationRoyaltyFactor_3, "locationRoyaltyFactor_3", "numericUpdate", typedEvent);
        locationRoyaltyFactor_3.numericUpdate(typedEvent);
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
    auditor.nodeRegistered(locationRoyaltyFactor_3, "locationRoyaltyFactor_3");
    auditor.nodeRegistered(royaltyLookup_1, "royaltyLookup_1");
    auditor.nodeRegistered(revenueCalculation_5, "revenueCalculation_5");
    auditor.nodeRegistered(reporter, "reporter");
  }

  @Override
  public void afterEvent() {
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_royaltyLookup_1 = false;
    isDirty_revenueCalculation_5 = false;
  }

  @Override
  public void init() {}

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
