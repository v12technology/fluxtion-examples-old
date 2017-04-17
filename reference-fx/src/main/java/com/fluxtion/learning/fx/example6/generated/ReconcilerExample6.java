package com.fluxtion.learning.fx.example6.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.fx.eventhandler.TimeHandlerSeconds;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.generated.Reconciler_EBS_LD4;
import com.fluxtion.learning.fx.example6.generated.Reconciler_EBS_NY2;
import com.fluxtion.learning.fx.example6.generated.Reconciler_FXALL_NY3;
import com.fluxtion.learning.fx.example6.generated.Reconciler_REUTERS_DC1;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileCache;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReportGenerator;
import com.fluxtion.learning.fx.example6.reconciler.nodes.SummaryPublisher;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import com.fluxtion.fx.event.ControlSignal;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.event.TimingPulseEvent;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;

public class ReconcilerExample6 implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final TimeHandlerSeconds timeHandler = new TimeHandlerSeconds();
  private final TimedNotifier alarm_1s = new TimedNotifier();
  private final TimedNotifier alarm_2s = new TimedNotifier();
  private final TimedNotifier alarm_3s = new TimedNotifier();
  private final TimedNotifier alarm_6s = new TimedNotifier();
  private final TimedNotifier alarm_17s = new TimedNotifier();
  private final Reconciler_EBS_LD4 reconciler_EBS_LD4 = new Reconciler_EBS_LD4();
  private final Reconciler_EBS_NY2 reconciler_EBS_NY2 = new Reconciler_EBS_NY2();
  private final Reconciler_FXALL_NY3 reconciler_FXALL_NY3 = new Reconciler_FXALL_NY3();
  private final Reconciler_REUTERS_DC1 reconciler_REUTERS_DC1 = new Reconciler_REUTERS_DC1();
  private final ReconcileCache reconcileCache_Global = new ReconcileCache();
  private final ReportGenerator reportGenerator_EBS_LD4 = new ReportGenerator();
  private final ReportGenerator reportGenerator_EBS_NY2 = new ReportGenerator();
  private final ReportGenerator reportGenerator_FXALL_NY3 = new ReportGenerator();
  private final ReportGenerator reportGenerator_REUTERS_DC1 = new ReportGenerator();
  private final SummaryPublisher summaryPublisher_EBS_LD4 = new SummaryPublisher();
  private final SummaryPublisher summaryPublisher_EBS_NY2 = new SummaryPublisher();
  private final SummaryPublisher summaryPublisher_FXALL_NY3 = new SummaryPublisher();
  private final SummaryPublisher summaryPublisher_REUTERS_DC1 = new SummaryPublisher();
  private final TradeAcknowledgementAuditor auditor = new TradeAcknowledgementAuditor();
  //Dirty flags
  private boolean isDirty_alarm_1s = false;
  private boolean isDirty_alarm_2s = false;
  private boolean isDirty_alarm_3s = false;
  private boolean isDirty_alarm_6s = false;
  private boolean isDirty_alarm_17s = false;
  //Filter constants

  public ReconcilerExample6() {
    //timeHandler
    //alarm_1s
    alarm_1s.periodInSeconds = (int) 1;
    alarm_1s.timeHandler = timeHandler;
    //alarm_2s
    alarm_2s.periodInSeconds = (int) 2;
    alarm_2s.timeHandler = timeHandler;
    //alarm_3s
    alarm_3s.periodInSeconds = (int) 3;
    alarm_3s.timeHandler = timeHandler;
    //alarm_6s
    alarm_6s.periodInSeconds = (int) 6;
    alarm_6s.timeHandler = timeHandler;
    //alarm_17s
    alarm_17s.periodInSeconds = (int) 17;
    alarm_17s.timeHandler = timeHandler;
    //reconciler_EBS_LD4
    reconciler_EBS_LD4.alarmReapExpired = alarm_1s;
    reconciler_EBS_LD4.id = "EBS_LD4";
    reconciler_EBS_LD4.auditor = auditor;
    reconciler_EBS_LD4.reconcileTimeout = (int) 5;
    //reconciler_EBS_NY2
    reconciler_EBS_NY2.alarmReapExpired = alarm_2s;
    reconciler_EBS_NY2.id = "EBS_NY2";
    reconciler_EBS_NY2.auditor = auditor;
    reconciler_EBS_NY2.reconcileTimeout = (int) 10;
    //reconciler_FXALL_NY3
    reconciler_FXALL_NY3.alarmReapExpired = alarm_17s;
    reconciler_FXALL_NY3.id = "FXALL_NY3";
    reconciler_FXALL_NY3.auditor = auditor;
    reconciler_FXALL_NY3.reconcileTimeout = (int) 10;
    //reconciler_REUTERS_DC1
    reconciler_REUTERS_DC1.alarmReapExpired = alarm_2s;
    reconciler_REUTERS_DC1.id = "REUTERS_DC1";
    reconciler_REUTERS_DC1.auditor = auditor;
    reconciler_REUTERS_DC1.reconcileTimeout = (int) 10;
    //reconcileCache_Global
    reconcileCache_Global.reconcilers = new TradeReconciler[4];
    reconcileCache_Global.reconcilers[0] = reconciler_REUTERS_DC1;
    reconcileCache_Global.reconcilers[1] = reconciler_EBS_LD4;
    reconcileCache_Global.reconcilers[2] = reconciler_EBS_NY2;
    reconcileCache_Global.reconcilers[3] = reconciler_FXALL_NY3;
    //reportGenerator_EBS_LD4
    reportGenerator_EBS_LD4.reconcileStatusCache = reconcileCache_Global;
    reportGenerator_EBS_LD4.alarm = alarm_2s;
    reportGenerator_EBS_LD4.id = "EBS_LD4";
    //reportGenerator_EBS_NY2
    reportGenerator_EBS_NY2.reconcileStatusCache = reconcileCache_Global;
    reportGenerator_EBS_NY2.alarm = alarm_3s;
    reportGenerator_EBS_NY2.id = "EBS_NY2";
    //reportGenerator_FXALL_NY3
    reportGenerator_FXALL_NY3.reconcileStatusCache = reconcileCache_Global;
    reportGenerator_FXALL_NY3.alarm = alarm_6s;
    reportGenerator_FXALL_NY3.id = "FXALL_NY3";
    //reportGenerator_REUTERS_DC1
    reportGenerator_REUTERS_DC1.reconcileStatusCache = reconcileCache_Global;
    reportGenerator_REUTERS_DC1.alarm = alarm_6s;
    reportGenerator_REUTERS_DC1.id = "REUTERS_DC1";
    //summaryPublisher_EBS_LD4
    summaryPublisher_EBS_LD4.reconciler = reconciler_EBS_LD4;
    summaryPublisher_EBS_LD4.alarm = alarm_2s;
    //summaryPublisher_EBS_NY2
    summaryPublisher_EBS_NY2.reconciler = reconciler_EBS_NY2;
    summaryPublisher_EBS_NY2.alarm = alarm_3s;
    //summaryPublisher_FXALL_NY3
    summaryPublisher_FXALL_NY3.reconciler = reconciler_FXALL_NY3;
    summaryPublisher_FXALL_NY3.alarm = alarm_6s;
    //summaryPublisher_REUTERS_DC1
    summaryPublisher_REUTERS_DC1.reconciler = reconciler_REUTERS_DC1;
    summaryPublisher_REUTERS_DC1.alarm = alarm_6s;
    //auditor
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
      case ("com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement"):
        {
          TradeAcknowledgement typedEvent = (TradeAcknowledgement) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(ControlSignal typedEvent) {
    switch (typedEvent.filterString()) {
      case ("com.fluxtion.fx.reconciler.clearReconcileState"):
        reconciler_REUTERS_DC1.clearReconcileState(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_REUTERS_DC1);
        reconciler_EBS_NY2.clearReconcileState(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_EBS_NY2);
        reconciler_EBS_LD4.clearReconcileState(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_EBS_LD4);
        reconciler_FXALL_NY3.clearReconcileState(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_FXALL_NY3);
        reconcileCache_Global.clearCache(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.fx.reconciler.publishResults"):
        reportGenerator_REUTERS_DC1.publisResults(typedEvent);
        reportGenerator_EBS_LD4.publisResults(typedEvent);
        reportGenerator_EBS_NY2.publisResults(typedEvent);
        reportGenerator_FXALL_NY3.publisResults(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(ListenerRegisration typedEvent) {
    switch (typedEvent.filterString()) {
      case ("com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache"):
        reconcileCache_Global.registerReconcileCache(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcilerListener"):
        summaryPublisher_REUTERS_DC1.registerReconcileListerner(typedEvent);
        summaryPublisher_EBS_NY2.registerReconcileListerner(typedEvent);
        summaryPublisher_EBS_LD4.registerReconcileListerner(typedEvent);
        summaryPublisher_FXALL_NY3.registerReconcileListerner(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.learning.fx.example6.reconciler.extensions.ReportPublisher"):
        reportGenerator_REUTERS_DC1.registerPublisher(typedEvent);
        reportGenerator_EBS_LD4.registerPublisher(typedEvent);
        reportGenerator_EBS_NY2.registerPublisher(typedEvent);
        reportGenerator_FXALL_NY3.registerPublisher(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.learning.fx.example6.reconciler.extensions.TradeAcknowledgementListener"):
        auditor.registerAuditor(typedEvent);
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
        isDirty_alarm_2s = alarm_2s.processTimePulse();
        if (isDirty_alarm_2s) {
          reconciler_REUTERS_DC1.expireTimedOutReconciles(alarm_2s);
          summaryPublisher_EBS_LD4.publishReconcileDelta(alarm_2s);
          reportGenerator_EBS_LD4.publishTimeout(alarm_2s);
          reconciler_EBS_NY2.expireTimedOutReconciles(alarm_2s);
        }
        isDirty_alarm_6s = alarm_6s.processTimePulse();
        if (isDirty_alarm_6s) {
          summaryPublisher_FXALL_NY3.publishReconcileDelta(alarm_6s);
          reportGenerator_FXALL_NY3.publishTimeout(alarm_6s);
          summaryPublisher_REUTERS_DC1.publishReconcileDelta(alarm_6s);
          reportGenerator_REUTERS_DC1.publishTimeout(alarm_6s);
        }
        isDirty_alarm_1s = alarm_1s.processTimePulse();
        if (isDirty_alarm_1s) {
          reconciler_EBS_LD4.expireTimedOutReconciles(alarm_1s);
        }
        isDirty_alarm_17s = alarm_17s.processTimePulse();
        if (isDirty_alarm_17s) {
          reconciler_FXALL_NY3.expireTimedOutReconciles(alarm_17s);
        }
        isDirty_alarm_3s = alarm_3s.processTimePulse();
        if (isDirty_alarm_3s) {
          summaryPublisher_EBS_NY2.publishReconcileDelta(alarm_3s);
          reportGenerator_EBS_NY2.publishTimeout(alarm_3s);
        }
        summaryPublisher_REUTERS_DC1.pushNotifications();
        summaryPublisher_EBS_NY2.pushNotifications();
        summaryPublisher_EBS_LD4.pushNotifications();
        reconcileCache_Global.cacheExpiryUpdates(typedEvent);
        summaryPublisher_FXALL_NY3.pushNotifications();
        reportGenerator_REUTERS_DC1.publishReport();
        reportGenerator_EBS_LD4.publishReport();
        reportGenerator_EBS_NY2.publishReport();
        reportGenerator_FXALL_NY3.publishReport();
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(TradeAcknowledgement typedEvent) {
    switch (typedEvent.filterString()) {
      case ("LD_4_EBS"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_EBS_LD4.tradeAckFrom_LD_4_EBS(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_EBS_LD4);
        afterEvent();
        return;
      case ("MiddleOffice_EBS_LD4"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_EBS_LD4.tradeAckFrom_MiddleOffice_EBS_LD4(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_EBS_LD4);
        afterEvent();
        return;
      case ("MiddleOffice_NY2"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_EBS_NY2.tradeAckFrom_MiddleOffice_NY2(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_EBS_NY2);
        afterEvent();
        return;
      case ("MiddleOffice_NY3_FXALL"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_FXALL_NY3.tradeAckFrom_MiddleOffice_NY3_FXALL(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_FXALL_NY3);
        afterEvent();
        return;
      case ("MiddleOffice_reuters_dc1"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_REUTERS_DC1.tradeAckFrom_MiddleOffice_reuters_dc1(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_REUTERS_DC1);
        afterEvent();
        return;
      case ("NY_2"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_EBS_NY2.tradeAckFrom_NY_2(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_EBS_NY2);
        afterEvent();
        return;
      case ("NY_3_FXALL"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_FXALL_NY3.tradeAckFrom_NY_3_FXALL(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_FXALL_NY3);
        afterEvent();
        return;
      case ("dcln_1_reuters"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_REUTERS_DC1.tradeAckFrom_dcln_1_reuters(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_REUTERS_DC1);
        afterEvent();
        return;
      case ("triana_EBS_LD4"):
        auditor.auditAcknowledgemt(typedEvent);
        reconciler_EBS_LD4.tradeAckFrom_triana_EBS_LD4(typedEvent);
        reconcileCache_Global.updateReconcileCache(reconciler_EBS_LD4);
        afterEvent();
        return;
    }
    //Default, no filter methods
    auditor.auditAcknowledgemt(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    reportGenerator_FXALL_NY3.resetPublishFlag();
    reportGenerator_EBS_NY2.resetPublishFlag();
    reportGenerator_EBS_LD4.resetPublishFlag();
    reportGenerator_REUTERS_DC1.resetPublishFlag();
    summaryPublisher_FXALL_NY3.resetNotificationFlag();
    summaryPublisher_EBS_LD4.resetNotificationFlag();
    summaryPublisher_EBS_NY2.resetNotificationFlag();
    summaryPublisher_REUTERS_DC1.resetNotificationFlag();
    reconciler_FXALL_NY3.resetAfterUpdate();
    reconciler_EBS_LD4.resetAfterUpdate();
    reconciler_EBS_NY2.resetAfterUpdate();
    reconciler_REUTERS_DC1.resetAfterUpdate();
    alarm_3s.resetFiredFlag();
    alarm_17s.resetFiredFlag();
    alarm_1s.resetFiredFlag();
    alarm_6s.resetFiredFlag();
    alarm_2s.resetFiredFlag();
    isDirty_alarm_1s = false;
    isDirty_alarm_2s = false;
    isDirty_alarm_3s = false;
    isDirty_alarm_6s = false;
    isDirty_alarm_17s = false;
  }

  @Override
  public void init() {
    alarm_2s.init();
    alarm_6s.init();
    alarm_1s.init();
    alarm_17s.init();
    alarm_3s.init();
    reconciler_REUTERS_DC1.init();
    reconciler_EBS_NY2.init();
    reconciler_EBS_LD4.init();
    reconciler_FXALL_NY3.init();
    summaryPublisher_REUTERS_DC1.init();
    summaryPublisher_EBS_NY2.init();
    summaryPublisher_EBS_LD4.init();
    summaryPublisher_FXALL_NY3.init();
    reportGenerator_REUTERS_DC1.init();
    reportGenerator_EBS_LD4.init();
    reportGenerator_EBS_NY2.init();
    reportGenerator_FXALL_NY3.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
