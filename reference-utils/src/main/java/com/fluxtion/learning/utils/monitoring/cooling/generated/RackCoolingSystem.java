package com.fluxtion.learning.utils.monitoring.cooling.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import java.util.Arrays;
import com.fluxtion.learning.utils.monitoring.cooling.ServerTempMonitor;
import com.fluxtion.learning.utils.monitoring.cooling.RackMonitor;
import com.fluxtion.learning.utils.monitoring.cooling.CoolingController;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor;
import com.fluxtion.runtime.plugin.logging.EventLogManager;
import com.fluxtion.runtime.plugin.profiler.HdrProfiler;
import com.fluxtion.runtime.plugin.tracing.Tracer;
import com.fluxtion.runtime.audit.Auditor;
import com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent;
import com.fluxtion.runtime.plugin.auditing.DelegatingAuditor.AuditorRegistration;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.logging.EventLogConfig;
import com.fluxtion.runtime.plugin.tracing.TraceEvents.PublishProperties;
import com.fluxtion.runtime.plugin.tracing.TracerConfigEvent;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class RackCoolingSystem implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  public final ServerTempMonitor server1 = new ServerTempMonitor("server1", 45.0);
  public final ServerTempMonitor server2 = new ServerTempMonitor("server2", 45.0);
  public final ServerTempMonitor svrNy = new ServerTempMonitor("svrNy", 55.0);
  public final ServerTempMonitor svrLD = new ServerTempMonitor("svrLD", 40.0);
  public final ServerTempMonitor svrTky = new ServerTempMonitor("svrTky", 67.0);
  public final RackMonitor rackMonitor =
      new RackMonitor(Arrays.asList(server1, server2, svrNy, svrLD, svrTky));
  public final CoolingController coolingContol = new CoolingController(rackMonitor);
  public final DelegatingAuditor delegatingAuditor = new DelegatingAuditor();
  public final EventLogManager logger = new EventLogManager();
  public final HdrProfiler profiler = new HdrProfiler();
  public final Tracer propertyTracer = new Tracer();
  //Dirty flags
  private boolean isDirty_rackMonitor = false;
  private boolean isDirty_server1 = false;
  private boolean isDirty_server2 = false;
  private boolean isDirty_svrLD = false;
  private boolean isDirty_svrNy = false;
  private boolean isDirty_svrTky = false;
  //Filter constants

  public RackCoolingSystem() {
    //node auditors
    initialiseAuditor(delegatingAuditor);
    initialiseAuditor(logger);
    initialiseAuditor(profiler);
    initialiseAuditor(propertyTracer);
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent"):
        {
          TemperatureEvent typedEvent = (TemperatureEvent) event;
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

  public void handleEvent(TemperatureEvent typedEvent) {
    auditEvent(typedEvent);
    FilteredHandlerInvoker invoker =
        dispatchStringMapTemperatureEvent.get(typedEvent.filterString());
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
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapTemperatureEvent =
      initdispatchStringMapTemperatureEvent();

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapTemperatureEvent() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "external",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TemperatureEvent_external(
                (com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent) event);
          }
        });
    dispatchMap.put(
        "server1",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TemperatureEvent_server1(
                (com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent) event);
          }
        });
    dispatchMap.put(
        "server2",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TemperatureEvent_server2(
                (com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent) event);
          }
        });
    dispatchMap.put(
        "svrLD",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TemperatureEvent_svrLD(
                (com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent) event);
          }
        });
    dispatchMap.put(
        "svrNy",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TemperatureEvent_svrNy(
                (com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent) event);
          }
        });
    dispatchMap.put(
        "svrTky",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TemperatureEvent_svrTky(
                (com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_TemperatureEvent_external(
      com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(coolingContol, "coolingContol", "temperatureEvent", typedEvent);
    coolingContol.temperatureEvent(typedEvent);
    if (isDirty_rackMonitor) {
      auditInvocation(coolingContol, "coolingContol", "rackWarningLevelChanged", typedEvent);
      coolingContol.rackWarningLevelChanged();
    }
  }

  private void handle_TemperatureEvent_server1(
      com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(server1, "server1", "temperatureEvent", typedEvent);
    isDirty_server1 = server1.temperatureEvent(typedEvent);
    if (isDirty_server1 | isDirty_server2 | isDirty_svrLD | isDirty_svrNy | isDirty_svrTky) {
      auditInvocation(rackMonitor, "rackMonitor", "updateWarningLevels", typedEvent);
      isDirty_rackMonitor = rackMonitor.updateWarningLevels();
    }
    if (isDirty_rackMonitor) {
      auditInvocation(coolingContol, "coolingContol", "rackWarningLevelChanged", typedEvent);
      coolingContol.rackWarningLevelChanged();
    }
  }

  private void handle_TemperatureEvent_server2(
      com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(server2, "server2", "temperatureEvent", typedEvent);
    isDirty_server2 = server2.temperatureEvent(typedEvent);
    if (isDirty_server1 | isDirty_server2 | isDirty_svrLD | isDirty_svrNy | isDirty_svrTky) {
      auditInvocation(rackMonitor, "rackMonitor", "updateWarningLevels", typedEvent);
      isDirty_rackMonitor = rackMonitor.updateWarningLevels();
    }
    if (isDirty_rackMonitor) {
      auditInvocation(coolingContol, "coolingContol", "rackWarningLevelChanged", typedEvent);
      coolingContol.rackWarningLevelChanged();
    }
  }

  private void handle_TemperatureEvent_svrLD(
      com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(svrLD, "svrLD", "temperatureEvent", typedEvent);
    isDirty_svrLD = svrLD.temperatureEvent(typedEvent);
    if (isDirty_server1 | isDirty_server2 | isDirty_svrLD | isDirty_svrNy | isDirty_svrTky) {
      auditInvocation(rackMonitor, "rackMonitor", "updateWarningLevels", typedEvent);
      isDirty_rackMonitor = rackMonitor.updateWarningLevels();
    }
    if (isDirty_rackMonitor) {
      auditInvocation(coolingContol, "coolingContol", "rackWarningLevelChanged", typedEvent);
      coolingContol.rackWarningLevelChanged();
    }
  }

  private void handle_TemperatureEvent_svrNy(
      com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(svrNy, "svrNy", "temperatureEvent", typedEvent);
    isDirty_svrNy = svrNy.temperatureEvent(typedEvent);
    if (isDirty_server1 | isDirty_server2 | isDirty_svrLD | isDirty_svrNy | isDirty_svrTky) {
      auditInvocation(rackMonitor, "rackMonitor", "updateWarningLevels", typedEvent);
      isDirty_rackMonitor = rackMonitor.updateWarningLevels();
    }
    if (isDirty_rackMonitor) {
      auditInvocation(coolingContol, "coolingContol", "rackWarningLevelChanged", typedEvent);
      coolingContol.rackWarningLevelChanged();
    }
  }

  private void handle_TemperatureEvent_svrTky(
      com.fluxtion.learning.utils.monitoring.cooling.TemperatureEvent typedEvent) {
    //method body - invoke call tree
    auditInvocation(svrTky, "svrTky", "temperatureEvent", typedEvent);
    isDirty_svrTky = svrTky.temperatureEvent(typedEvent);
    if (isDirty_server1 | isDirty_server2 | isDirty_svrLD | isDirty_svrNy | isDirty_svrTky) {
      auditInvocation(rackMonitor, "rackMonitor", "updateWarningLevels", typedEvent);
      isDirty_rackMonitor = rackMonitor.updateWarningLevels();
    }
    if (isDirty_rackMonitor) {
      auditInvocation(coolingContol, "coolingContol", "rackWarningLevelChanged", typedEvent);
      coolingContol.rackWarningLevelChanged();
    }
  }

  private void auditEvent(Object typedEvent) {
    delegatingAuditor.eventReceived(typedEvent);
    profiler.eventReceived(typedEvent);
    propertyTracer.eventReceived(typedEvent);
    logger.eventReceived(typedEvent);
  }

  private void auditInvocation(Object node, String nodeName, String methodName, Object typedEvent) {
    delegatingAuditor.nodeInvoked(node, nodeName, methodName, typedEvent);
    profiler.nodeInvoked(node, nodeName, methodName, typedEvent);
  }

  private void initialiseAuditor(Auditor auditor) {
    auditor.init();
    auditor.nodeRegistered(coolingContol, "coolingContol");
    auditor.nodeRegistered(rackMonitor, "rackMonitor");
    auditor.nodeRegistered(server1, "server1");
    auditor.nodeRegistered(server2, "server2");
    auditor.nodeRegistered(svrLD, "svrLD");
    auditor.nodeRegistered(svrNy, "svrNy");
    auditor.nodeRegistered(svrTky, "svrTky");
  }

  @Override
  public void afterEvent() {
    delegatingAuditor.processingComplete();
    logger.processingComplete();
    profiler.processingComplete();
    propertyTracer.processingComplete();
    isDirty_rackMonitor = false;
    isDirty_server1 = false;
    isDirty_server2 = false;
    isDirty_svrLD = false;
    isDirty_svrNy = false;
    isDirty_svrTky = false;
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
