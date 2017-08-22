package com.fluxtion.learning.utils.logging.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.Pump;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.Boiler;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.ControlDisplay;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.FlowSensorOff;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.FlowSensorOn;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.HeatOff;
import com.fluxtion.learning.utils.logging.HeatingSystemConfig.HeatOn;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;

public class HeatingSystem implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  public final Pump pump = new Pump();
  public final Boiler boiler = new Boiler(pump);
  public final ControlDisplay display = new ControlDisplay(boiler, pump);
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  //Dirty flags

  //Filter constants

  public HeatingSystem() {
    //node auditors
    initialiseAuditor(delegatingAuditor);
    initialiseAuditor(logger);
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.utils.logging.HeatingSystemConfig$FlowSensorOff"):
        {
          FlowSensorOff typedEvent = (FlowSensorOff) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.utils.logging.HeatingSystemConfig$FlowSensorOn"):
        {
          FlowSensorOn typedEvent = (FlowSensorOn) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.utils.logging.HeatingSystemConfig$HeatOff"):
        {
          HeatOff typedEvent = (HeatOff) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.utils.logging.HeatingSystemConfig$HeatOn"):
        {
          HeatOn typedEvent = (HeatOn) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.auditing.DelegatingAuditor$AuditorRegistration"):
        {
          AuditorRegistration typedEvent = (AuditorRegistration) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.logging.EventLogConfig"):
        {
          EventLogConfig typedEvent = (EventLogConfig) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(FlowSensorOff typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(boiler, "boiler", "waterFlowOn", typedEvent);
    boiler.waterFlowOn(typedEvent);
    auditInvocation(display, "display", "boilerUpdate", typedEvent);
    display.boilerUpdate();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(FlowSensorOn typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(boiler, "boiler", "waterFlowOn", typedEvent);
    boiler.waterFlowOn(typedEvent);
    auditInvocation(display, "display", "boilerUpdate", typedEvent);
    display.boilerUpdate();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(HeatOff typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(pump, "pump", "heatingOff", typedEvent);
    pump.heatingOff(typedEvent);
    auditInvocation(boiler, "boiler", "heatingOff", typedEvent);
    boiler.heatingOff(typedEvent);
    auditInvocation(display, "display", "boilerUpdate", typedEvent);
    display.boilerUpdate();
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(HeatOn typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(pump, "pump", "heatingOn", typedEvent);
    pump.heatingOn(typedEvent);
    auditInvocation(boiler, "boiler", "heatingOn", typedEvent);
    boiler.heatingOn(typedEvent);
    auditInvocation(display, "display", "boilerUpdate", typedEvent);
    display.boilerUpdate();
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

  public void handleEvent(EventLogConfig typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(logger, "logger", "calculationLogConfig", typedEvent);
    logger.calculationLogConfig(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  private void auditEvent(Object typedEvent) {
    delegatingAuditor.eventReceived(typedEvent);
    logger.eventReceived(typedEvent);
  }

  private void auditInvocation(Object node, String nodeName, String methodName, Object typedEvent) {
    delegatingAuditor.nodeInvoked(node, nodeName, methodName, typedEvent);
  }

  private void initialiseAuditor(Auditor auditor) {
    auditor.init();
    auditor.nodeRegistered(boiler, "boiler");
    auditor.nodeRegistered(display, "display");
    auditor.nodeRegistered(pump, "pump");
  }

  @Override
  public void afterEvent() {
    delegatingAuditor.processingComplete();
    logger.processingComplete();
  }

  @Override
  public void init() {}

  @Override
  public void tearDown() {
    logger.tearDown();
    delegatingAuditor.tearDown();
  }

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
