package com.fluxtion.learning.utils.monitoring.heating.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.runtime.plugin.nodes.BetweenHoursTest;
import com.fluxtion.learning.utils.monitoring.heating.TimerController;
import com.fluxtion.learning.utils.monitoring.heating.PumpController;
import com.fluxtion.learning.utils.monitoring.heating.BoilerController;
import com.fluxtion.learning.utils.monitoring.heating.ControllerDisplay;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.BooleanSignal;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.events.TimingPulseEvent;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class HeatingSystem implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final BetweenHoursTest betweenHoursTest_1 = new BetweenHoursTest(7, 22);
  private final TimerController timerController_3 = new TimerController(betweenHoursTest_1);
  private final PumpController pumpController_5 = new PumpController(timerController_3);
  public final BoilerController boiler = new BoilerController(timerController_3);
  public final ControllerDisplay display = new ControllerDisplay(timerController_3);
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  public final HdrProfiler profiler = new HdrProfiler();
  public final Tracer propertyTracer = new Tracer();
  //Dirty flags
  private boolean isDirty_betweenHoursTest_1 = false;
  private boolean isDirty_pumpController_5 = false;
  private boolean isDirty_timerController_3 = false;
  //Filter constants

  public HeatingSystem() {
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
      case ("com.fluxtion.runtime.plugin.auditing.DelegatingAuditor$AuditorRegistration"):
        {
          AuditorRegistration typedEvent = (AuditorRegistration) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.events.BooleanSignal"):
        {
          BooleanSignal typedEvent = (BooleanSignal) event;
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

  public void handleEvent(AuditorRegistration typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(delegatingAuditor, "delegatingAuditor", "auditorRegistration", typedEvent);
    delegatingAuditor.auditorRegistration(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(BooleanSignal typedEvent) {
    auditEvent(typedEvent);
    FilteredHandlerInvoker invoker = dispatchStringMapBooleanSignal.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
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
      case ("flowTemperature"):
        auditInvocation(boiler, "boiler", "waterFlowTemperatureSensor", typedEvent);
        boiler.waterFlowTemperatureSensor(typedEvent);
        afterEvent();
        return;
      case ("returnTemperature"):
        auditInvocation(boiler, "boiler", "waterReturnTemperatureSensor", typedEvent);
        boiler.waterReturnTemperatureSensor(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(TimingPulseEvent typedEvent) {
    auditEvent(typedEvent);
    //Default, no filter methods
    auditInvocation(betweenHoursTest_1, "betweenHoursTest_1", "timeUpdate", typedEvent);
    isDirty_betweenHoursTest_1 = betweenHoursTest_1.timeUpdate(typedEvent);
    if (isDirty_betweenHoursTest_1) {
      auditInvocation(timerController_3, "timerController_3", "signalChanged", typedEvent);
      isDirty_timerController_3 = timerController_3.signalChanged();
    }
    if (isDirty_timerController_3) {
      auditInvocation(pumpController_5, "pumpController_5", "changedState", typedEvent);
      isDirty_pumpController_5 = pumpController_5.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(boiler, "boiler", "changedState", typedEvent);
      boiler.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(display, "display", "updateDisplay", typedEvent);
      display.updateDisplay();
    }
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
  //int filter maps
  //String filter maps
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapBooleanSignal =
      initdispatchStringMapBooleanSignal();

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapBooleanSignal() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "burnerSignal",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_BooleanSignal_burnerSignal(
                (com.fluxtion.runtime.plugin.events.BooleanSignal) event);
          }
        });
    dispatchMap.put(
        "flowSignal",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_BooleanSignal_flowSignal(
                (com.fluxtion.runtime.plugin.events.BooleanSignal) event);
          }
        });
    dispatchMap.put(
        "heatingOff",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_BooleanSignal_heatingOff(
                (com.fluxtion.runtime.plugin.events.BooleanSignal) event);
          }
        });
    dispatchMap.put(
        "heatingOn",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_BooleanSignal_heatingOn(
                (com.fluxtion.runtime.plugin.events.BooleanSignal) event);
          }
        });
    dispatchMap.put(
        "heatingTimer",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_BooleanSignal_heatingTimer(
                (com.fluxtion.runtime.plugin.events.BooleanSignal) event);
          }
        });
    return dispatchMap;
  }

  private void handle_BooleanSignal_burnerSignal(
      com.fluxtion.runtime.plugin.events.BooleanSignal typedEvent) {
    //method body - invoke call tree
    auditInvocation(pumpController_5, "pumpController_5", "burnerSensor", typedEvent);
    pumpController_5.burnerSensor(typedEvent);
    if (isDirty_timerController_3) {
      auditInvocation(pumpController_5, "pumpController_5", "changedState", typedEvent);
      isDirty_pumpController_5 = pumpController_5.changedState();
    }
    auditInvocation(display, "display", "burnerSensor", typedEvent);
    display.burnerSensor(typedEvent);
    if (isDirty_timerController_3) {
      auditInvocation(display, "display", "updateDisplay", typedEvent);
      display.updateDisplay();
    }
  }

  private void handle_BooleanSignal_flowSignal(
      com.fluxtion.runtime.plugin.events.BooleanSignal typedEvent) {
    //method body - invoke call tree
    auditInvocation(boiler, "boiler", "waterFlowSensor", typedEvent);
    boiler.waterFlowSensor(typedEvent);
  }

  private void handle_BooleanSignal_heatingOff(
      com.fluxtion.runtime.plugin.events.BooleanSignal typedEvent) {
    //method body - invoke call tree
    auditInvocation(timerController_3, "timerController_3", "heatingOff", typedEvent);
    isDirty_timerController_3 = timerController_3.heatingOff(typedEvent);
    if (isDirty_betweenHoursTest_1) {
      auditInvocation(timerController_3, "timerController_3", "signalChanged", typedEvent);
      isDirty_timerController_3 = timerController_3.signalChanged();
    }
    if (isDirty_timerController_3) {
      auditInvocation(pumpController_5, "pumpController_5", "changedState", typedEvent);
      isDirty_pumpController_5 = pumpController_5.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(boiler, "boiler", "changedState", typedEvent);
      boiler.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(display, "display", "updateDisplay", typedEvent);
      display.updateDisplay();
    }
  }

  private void handle_BooleanSignal_heatingOn(
      com.fluxtion.runtime.plugin.events.BooleanSignal typedEvent) {
    //method body - invoke call tree
    auditInvocation(timerController_3, "timerController_3", "heatingOn", typedEvent);
    isDirty_timerController_3 = timerController_3.heatingOn(typedEvent);
    if (isDirty_betweenHoursTest_1) {
      auditInvocation(timerController_3, "timerController_3", "signalChanged", typedEvent);
      isDirty_timerController_3 = timerController_3.signalChanged();
    }
    if (isDirty_timerController_3) {
      auditInvocation(pumpController_5, "pumpController_5", "changedState", typedEvent);
      isDirty_pumpController_5 = pumpController_5.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(boiler, "boiler", "changedState", typedEvent);
      boiler.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(display, "display", "updateDisplay", typedEvent);
      display.updateDisplay();
    }
  }

  private void handle_BooleanSignal_heatingTimer(
      com.fluxtion.runtime.plugin.events.BooleanSignal typedEvent) {
    //method body - invoke call tree
    auditInvocation(timerController_3, "timerController_3", "heatingTimerControlled", typedEvent);
    isDirty_timerController_3 = timerController_3.heatingTimerControlled(typedEvent);
    if (isDirty_betweenHoursTest_1) {
      auditInvocation(timerController_3, "timerController_3", "signalChanged", typedEvent);
      isDirty_timerController_3 = timerController_3.signalChanged();
    }
    if (isDirty_timerController_3) {
      auditInvocation(pumpController_5, "pumpController_5", "changedState", typedEvent);
      isDirty_pumpController_5 = pumpController_5.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(boiler, "boiler", "changedState", typedEvent);
      boiler.changedState();
    }
    if (isDirty_timerController_3) {
      auditInvocation(display, "display", "updateDisplay", typedEvent);
      display.updateDisplay();
    }
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
    auditor.nodeRegistered(boiler, "boiler");
    auditor.nodeRegistered(display, "display");
    auditor.nodeRegistered(pumpController_5, "pumpController_5");
    auditor.nodeRegistered(timerController_3, "timerController_3");
    auditor.nodeRegistered(betweenHoursTest_1, "betweenHoursTest_1");
  }

  @Override
  public void afterEvent() {
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_betweenHoursTest_1 = false;
    isDirty_pumpController_5 = false;
    isDirty_timerController_3 = false;
  }

  @Override
  public void init() {
    betweenHoursTest_1.init();
    timerController_3.init();
    pumpController_5.init();
    boiler.init();
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
