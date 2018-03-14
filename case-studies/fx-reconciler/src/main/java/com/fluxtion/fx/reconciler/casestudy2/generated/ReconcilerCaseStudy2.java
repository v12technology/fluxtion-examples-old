package com.fluxtion.fx.reconciler.casestudy2.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.fx.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.fx.eventhandler.TimeHandlerSeconds;
import com.fluxtion.fx.eventhandler.TimedNotifier;
import com.fluxtion.fx.reconciler.casestudy2.generated.Reconciler_EBS_LON;
import com.fluxtion.fx.reconciler.casestudy2.generated.Reconciler_HOTSPOT_LD4;
import com.fluxtion.fx.reconciler.casestudy2.generated.Reconciler_REUTERS_LON;
import com.fluxtion.fx.reconciler.nodes.ReconcileCache;
import com.fluxtion.fx.reconciler.nodes.ReportGenerator;
import com.fluxtion.fx.reconciler.nodes.SummaryPublisher;
import com.fluxtion.fx.reconciler.nodes.TradeReconciler;
import com.fluxtion.fx.event.ConfigurationEvent;
import com.fluxtion.fx.event.ControlSignal;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.event.TimingPulseEvent;
import com.fluxtion.fx.reconciler.events.TradeAcknowledgement;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class ReconcilerCaseStudy2 implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final TradeAcknowledgementAuditor auditor = new TradeAcknowledgementAuditor();
  private final TimeHandlerSeconds timeHandler = new TimeHandlerSeconds();
  private final TimedNotifier alarm_1s = new TimedNotifier();
  private final TimedNotifier alarm_2s = new TimedNotifier();
  private final TimedNotifier alarm_6s = new TimedNotifier();
  private final Reconciler_EBS_LON reconciler_EBS_LON = new Reconciler_EBS_LON();
  private final Reconciler_HOTSPOT_LD4 reconciler_HOTSPOT_LD4 = new Reconciler_HOTSPOT_LD4();
  private final Reconciler_REUTERS_LON reconciler_REUTERS_LON = new Reconciler_REUTERS_LON();
  private final ReconcileCache reconcileCache_Global = new ReconcileCache();
  private final ReportGenerator reportGenerator_EBS_LON = new ReportGenerator();
  private final ReportGenerator reportGenerator_HOTSPOT_LD4 = new ReportGenerator();
  private final ReportGenerator reportGenerator_REUTERS_LON = new ReportGenerator();
  private final SummaryPublisher summaryPublisher_EBS_LON = new SummaryPublisher();
  private final SummaryPublisher summaryPublisher_HOTSPOT_LD4 = new SummaryPublisher();
  private final SummaryPublisher summaryPublisher_REUTERS_LON = new SummaryPublisher();
  //Dirty flags
  private boolean isDirty_alarm_1s = false;
  private boolean isDirty_alarm_2s = false;
  private boolean isDirty_alarm_6s = false;
  //Filter constants

  public ReconcilerCaseStudy2() {
    alarm_1s.periodInSeconds = (int) 1;
    alarm_1s.timeHandler = timeHandler;
    alarm_2s.periodInSeconds = (int) 2;
    alarm_2s.timeHandler = timeHandler;
    alarm_6s.periodInSeconds = (int) 6;
    alarm_6s.timeHandler = timeHandler;
    reconciler_EBS_LON.alarmReapExpired = alarm_2s;
    reconciler_EBS_LON.id = "EBS_LON";
    reconciler_EBS_LON.auditor = auditor;
    reconciler_EBS_LON.reconcileTimeout = (int) 10;
    reconciler_HOTSPOT_LD4.alarmReapExpired = alarm_1s;
    reconciler_HOTSPOT_LD4.id = "HOTSPOT_LD4";
    reconciler_HOTSPOT_LD4.auditor = auditor;
    reconciler_HOTSPOT_LD4.reconcileTimeout = (int) 5;
    reconciler_REUTERS_LON.alarmReapExpired = alarm_2s;
    reconciler_REUTERS_LON.id = "REUTERS_LON";
    reconciler_REUTERS_LON.auditor = auditor;
    reconciler_REUTERS_LON.reconcileTimeout = (int) 10;
    reconcileCache_Global.reconcilers = new TradeReconciler[3];
    reconcileCache_Global.reconcilers[0] = reconciler_REUTERS_LON;
    reconcileCache_Global.reconcilers[1] = reconciler_EBS_LON;
    reconcileCache_Global.reconcilers[2] = reconciler_HOTSPOT_LD4;
    reportGenerator_EBS_LON.reconcileStatusCache = reconcileCache_Global;
    reportGenerator_EBS_LON.alarm = alarm_6s;
    reportGenerator_EBS_LON.id = "EBS_LON";
    reportGenerator_HOTSPOT_LD4.reconcileStatusCache = reconcileCache_Global;
    reportGenerator_HOTSPOT_LD4.alarm = alarm_2s;
    reportGenerator_HOTSPOT_LD4.id = "HOTSPOT_LD4";
    reportGenerator_REUTERS_LON.reconcileStatusCache = reconcileCache_Global;
    reportGenerator_REUTERS_LON.alarm = alarm_6s;
    reportGenerator_REUTERS_LON.id = "REUTERS_LON";
    summaryPublisher_EBS_LON.reconciler = reconciler_EBS_LON;
    summaryPublisher_EBS_LON.alarm = alarm_6s;
    summaryPublisher_HOTSPOT_LD4.reconciler = reconciler_HOTSPOT_LD4;
    summaryPublisher_HOTSPOT_LD4.alarm = alarm_2s;
    summaryPublisher_REUTERS_LON.reconciler = reconciler_REUTERS_LON;
    summaryPublisher_REUTERS_LON.alarm = alarm_6s;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (ConfigurationEvent.ID):
        {
          ConfigurationEvent typedEvent = (ConfigurationEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case (TimingPulseEvent.ID):
        {
          TimingPulseEvent typedEvent = (TimingPulseEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
    switch (event.getClass().getName()) {
      case ("com.fluxtion.fx.event.ControlSignal"):
        {
          ControlSignal typedEvent = (ControlSignal) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.fx.event.ListenerRegisration"):
        {
          ListenerRegisration typedEvent = (ListenerRegisration) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.fx.reconciler.events.TradeAcknowledgement"):
        {
          TradeAcknowledgement typedEvent = (TradeAcknowledgement) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(ConfigurationEvent typedEvent) {
    switch (typedEvent.filterString()) {
      case ("com.fluxtion.fx.reconciler.publishResults.config"):
        reportGenerator_EBS_LON.configurePublisher(typedEvent);
        reportGenerator_HOTSPOT_LD4.configurePublisher(typedEvent);
        reportGenerator_REUTERS_LON.configurePublisher(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(ControlSignal typedEvent) {
    FilteredHandlerInvoker invoker = dispatchStringMapControlSignal.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  public void handleEvent(ListenerRegisration typedEvent) {
    FilteredHandlerInvoker invoker =
        dispatchStringMapListenerRegisration.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  public void handleEvent(TimingPulseEvent typedEvent) {
    switch (typedEvent.filterId()) {
        //Event Class:[com.fluxtion.fx.event.TimingPulseEvent] filterId:[1]
      case (1):
        timeHandler.onTimingPulse(typedEvent);
        isDirty_alarm_1s = alarm_1s.processTimePulse();
        if (isDirty_alarm_1s) {
          reconciler_HOTSPOT_LD4.expireTimedOutReconciles(alarm_1s);
        }
        isDirty_alarm_2s = alarm_2s.processTimePulse();
        if (isDirty_alarm_2s) {
          reconciler_EBS_LON.expireTimedOutReconciles(alarm_2s);
          reconciler_REUTERS_LON.expireTimedOutReconciles(alarm_2s);
          reportGenerator_HOTSPOT_LD4.publishTimeout(alarm_2s);
          summaryPublisher_HOTSPOT_LD4.publishReconcileDelta(alarm_2s);
        }
        isDirty_alarm_6s = alarm_6s.processTimePulse();
        if (isDirty_alarm_6s) {
          reportGenerator_EBS_LON.publishTimeout(alarm_6s);
          reportGenerator_REUTERS_LON.publishTimeout(alarm_6s);
          summaryPublisher_EBS_LON.publishReconcileDelta(alarm_6s);
          summaryPublisher_REUTERS_LON.publishReconcileDelta(alarm_6s);
        }
        reconcileCache_Global.cacheExpiryUpdates(typedEvent);
        if (isDirty_alarm_6s) {
          reportGenerator_EBS_LON.publishReport();
        }
        if (isDirty_alarm_2s) {
          reportGenerator_HOTSPOT_LD4.publishReport();
        }
        if (isDirty_alarm_6s) {
          reportGenerator_REUTERS_LON.publishReport();
        }
        if (isDirty_alarm_6s) {
          summaryPublisher_EBS_LON.pushNotifications();
        }
        if (isDirty_alarm_2s) {
          summaryPublisher_HOTSPOT_LD4.pushNotifications();
        }
        if (isDirty_alarm_6s) {
          summaryPublisher_REUTERS_LON.pushNotifications();
        }
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(TradeAcknowledgement typedEvent) {
    FilteredHandlerInvoker invoker =
        dispatchStringMapTradeAcknowledgement.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    //Default, no filter methods
    auditor.auditAcknowledgemt(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  //int filter maps
  private final Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchIntMapTradeAcknowledgement =
      initdispatchIntMapTradeAcknowledgement();

  //String filter maps
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapControlSignal =
      initdispatchStringMapControlSignal();

  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapListenerRegisration =
      initdispatchStringMapListenerRegisration();

  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapTradeAcknowledgement =
      initdispatchStringMapTradeAcknowledgement();

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapControlSignal() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "com.fluxtion.fx.reconciler.clearReconcileState",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ControlSignal_com_fluxtion_fx_reconciler_clearReconcileState(
                (com.fluxtion.fx.event.ControlSignal) event);
          }
        });
    dispatchMap.put(
        "com.fluxtion.fx.reconciler.publishResults",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ControlSignal_com_fluxtion_fx_reconciler_publishResults(
                (com.fluxtion.fx.event.ControlSignal) event);
          }
        });
    dispatchMap.put(
        "com.fluxtion.fx.reconciler.publishSummary",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ControlSignal_com_fluxtion_fx_reconciler_publishSummary(
                (com.fluxtion.fx.event.ControlSignal) event);
          }
        });
    return dispatchMap;
  }

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapListenerRegisration() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "com.fluxtion.fx.reconciler.extensions.ReconcileReportPublisher",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_ReconcileReportPublisher(
                (com.fluxtion.fx.event.ListenerRegisration) event);
          }
        });
    dispatchMap.put(
        "com.fluxtion.fx.reconciler.extensions.ReconcileStatusCache",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_ReconcileStatusCache(
                (com.fluxtion.fx.event.ListenerRegisration) event);
          }
        });
    dispatchMap.put(
        "com.fluxtion.fx.reconciler.extensions.ReconcileSummaryListener",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_ReconcileSummaryListener(
                (com.fluxtion.fx.event.ListenerRegisration) event);
          }
        });
    dispatchMap.put(
        "com.fluxtion.fx.reconciler.extensions.TradeAcknowledgementListener",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_TradeAcknowledgementListener(
                (com.fluxtion.fx.event.ListenerRegisration) event);
          }
        });
    return dispatchMap;
  }

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapTradeAcknowledgement() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "MiddleOffice_HS_LD4",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_MiddleOffice_HS_LD4(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    dispatchMap.put(
        "MiddleOffice_ebs_lon",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_MiddleOffice_ebs_lon(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    dispatchMap.put(
        "MiddleOffice_reuters_lon",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_MiddleOffice_reuters_lon(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    dispatchMap.put(
        "ebs_lon",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_ebs_lon(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    dispatchMap.put(
        "hotspot_ld4",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_hotspot_ld4(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    dispatchMap.put(
        "reuter_lon",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_reuter_lon(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    dispatchMap.put(
        "traiana",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_traiana(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    dispatchMap.put(
        "triana_hspot_LD4",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_triana_hspot_LD4(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    return dispatchMap;
  }

  private Int2ObjectOpenHashMap<FilteredHandlerInvoker> initdispatchIntMapTradeAcknowledgement() {
    Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchMap = new Int2ObjectOpenHashMap<>();
    dispatchMap.put(
        0,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_TradeAcknowledgement_NoFilter(
                (com.fluxtion.fx.reconciler.events.TradeAcknowledgement) event);
          }
        });
    return dispatchMap;
  }

  private void handle_ControlSignal_com_fluxtion_fx_reconciler_clearReconcileState(
      com.fluxtion.fx.event.ControlSignal typedEvent) {
    //method body - invoke call tree
    reconciler_EBS_LON.clearReconcileState(typedEvent);
    reconciler_HOTSPOT_LD4.clearReconcileState(typedEvent);
    reconciler_REUTERS_LON.clearReconcileState(typedEvent);
    reconcileCache_Global.clearCache(typedEvent);
  }

  private void handle_ControlSignal_com_fluxtion_fx_reconciler_publishResults(
      com.fluxtion.fx.event.ControlSignal typedEvent) {
    //method body - invoke call tree
    reportGenerator_EBS_LON.publishResults(typedEvent);
    reportGenerator_HOTSPOT_LD4.publishResults(typedEvent);
    reportGenerator_REUTERS_LON.publishResults(typedEvent);
  }

  private void handle_ControlSignal_com_fluxtion_fx_reconciler_publishSummary(
      com.fluxtion.fx.event.ControlSignal typedEvent) {
    //method body - invoke call tree
    summaryPublisher_EBS_LON.publishResults(typedEvent);
    summaryPublisher_HOTSPOT_LD4.publishResults(typedEvent);
    summaryPublisher_REUTERS_LON.publishResults(typedEvent);
  }

  private void
      handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_ReconcileReportPublisher(
          com.fluxtion.fx.event.ListenerRegisration typedEvent) {
    //method body - invoke call tree
    reportGenerator_EBS_LON.registerPublisher(typedEvent);
    reportGenerator_HOTSPOT_LD4.registerPublisher(typedEvent);
    reportGenerator_REUTERS_LON.registerPublisher(typedEvent);
  }

  private void
      handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_ReconcileStatusCache(
          com.fluxtion.fx.event.ListenerRegisration typedEvent) {
    //method body - invoke call tree
    reconcileCache_Global.registerReconcileCache(typedEvent);
  }

  private void
      handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_ReconcileSummaryListener(
          com.fluxtion.fx.event.ListenerRegisration typedEvent) {
    //method body - invoke call tree
    summaryPublisher_EBS_LON.registerReconcileListerner(typedEvent);
    summaryPublisher_HOTSPOT_LD4.registerReconcileListerner(typedEvent);
    summaryPublisher_REUTERS_LON.registerReconcileListerner(typedEvent);
  }

  private void
      handle_ListenerRegisration_com_fluxtion_fx_reconciler_extensions_TradeAcknowledgementListener(
          com.fluxtion.fx.event.ListenerRegisration typedEvent) {
    //method body - invoke call tree
    auditor.registerAuditor(typedEvent);
  }

  private void handle_TradeAcknowledgement_MiddleOffice_HS_LD4(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_HOTSPOT_LD4.tradeAckFrom_MiddleOffice_HS_LD4(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_HOTSPOT_LD4);
  }

  private void handle_TradeAcknowledgement_MiddleOffice_ebs_lon(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_EBS_LON.tradeAckFrom_MiddleOffice_ebs_lon(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_EBS_LON);
  }

  private void handle_TradeAcknowledgement_MiddleOffice_reuters_lon(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_REUTERS_LON.tradeAckFrom_MiddleOffice_reuters_lon(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_REUTERS_LON);
  }

  private void handle_TradeAcknowledgement_ebs_lon(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_EBS_LON.tradeAckFrom_ebs_lon(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_EBS_LON);
  }

  private void handle_TradeAcknowledgement_hotspot_ld4(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_HOTSPOT_LD4.tradeAckFrom_hotspot_ld4(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_HOTSPOT_LD4);
  }

  private void handle_TradeAcknowledgement_reuter_lon(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_REUTERS_LON.tradeAckFrom_reuter_lon(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_REUTERS_LON);
  }

  private void handle_TradeAcknowledgement_traiana(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_EBS_LON.tradeAckFrom_traiana(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_EBS_LON);
  }

  private void handle_TradeAcknowledgement_triana_hspot_LD4(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    reconciler_HOTSPOT_LD4.tradeAckFrom_triana_hspot_LD4(typedEvent);
    reconcileCache_Global.updateReconcileCache(reconciler_HOTSPOT_LD4);
  }

  private void handle_TradeAcknowledgement_NoFilter(
      com.fluxtion.fx.reconciler.events.TradeAcknowledgement typedEvent) {
    //method body - invoke call tree
    auditor.auditAcknowledgemt(typedEvent);
    //event stack unwind callbacks
  }

  @Override
  public void afterEvent() {
    summaryPublisher_REUTERS_LON.resetNotificationFlag();
    summaryPublisher_HOTSPOT_LD4.resetNotificationFlag();
    summaryPublisher_EBS_LON.resetNotificationFlag();
    reportGenerator_REUTERS_LON.resetPublishFlag();
    reportGenerator_HOTSPOT_LD4.resetPublishFlag();
    reportGenerator_EBS_LON.resetPublishFlag();
    reconciler_REUTERS_LON.resetAfterUpdate();
    reconciler_HOTSPOT_LD4.resetAfterUpdate();
    reconciler_EBS_LON.resetAfterUpdate();
    alarm_6s.resetFiredFlag();
    alarm_2s.resetFiredFlag();
    alarm_1s.resetFiredFlag();
    isDirty_alarm_1s = false;
    isDirty_alarm_2s = false;
    isDirty_alarm_6s = false;
  }

  @Override
  public void init() {
    alarm_1s.init();
    alarm_2s.init();
    alarm_6s.init();
    reconciler_EBS_LON.init();
    reconciler_HOTSPOT_LD4.init();
    reconciler_REUTERS_LON.init();
    reconcileCache_Global.init();
    reportGenerator_EBS_LON.init();
    reportGenerator_HOTSPOT_LD4.init();
    reportGenerator_REUTERS_LON.init();
    summaryPublisher_EBS_LON.init();
    summaryPublisher_HOTSPOT_LD4.init();
    summaryPublisher_REUTERS_LON.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
