package com.fluxtion.learning.fx.example1;


import com.fluxtion.fx.BiasProcessor;
import com.fluxtion.fx.EventAuditor;
import com.fluxtion.fx.node.biascheck.NotificationHandler;
import com.fluxtion.fx.node.biascheck.OrderBiasResultHandler;

import com.fluxtion.fx.eventhandler.TimeHandlerSeconds;
import com.fluxtion.fx.node.biascheck.BiasNotifier;
import com.fluxtion.fx.node.biascheck.BiasSummaryBroadcaster;
import com.fluxtion.fx.node.biascheck.CustomerOrderCacheGlobal;
import com.fluxtion.fx.node.biascheck.EventAuditDelegator;
import com.fluxtion.fx.node.biascheck.PricingBiasCheck;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.fx.event.ControlSignal;
import com.fluxtion.fx.event.CustomerOrder;
import com.fluxtion.fx.event.CustomerOrderAccept;
import com.fluxtion.fx.event.CustomerOrderReject;
import com.fluxtion.fx.event.FxPrice;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.fx.event.TimingPulseEvent;

public class G10Monitor implements BiasProcessor {

  //Node declarations
  private final TimeHandlerSeconds timeHandlerSeconds_2 = new TimeHandlerSeconds();
  public final BiasNotifier breachNotifier = new BiasNotifier();
  public final BiasSummaryBroadcaster summaryBroadcaster = new BiasSummaryBroadcaster();
  public final CustomerOrderCacheGlobal orderCache = new CustomerOrderCacheGlobal();
  private final EventAuditDelegator eventAuditDelegator_5 = new EventAuditDelegator();
  private final PricingBiasCheck biasChecker_AUDUSD60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_AUDUSD600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURCHF60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURCHF600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURGBP60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURGBP600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURJPY60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURJPY600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURUSD60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURUSD600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_GBPUSD60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_GBPUSD600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDCHF60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDCHF600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDJPY60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDJPY600s = new PricingBiasCheck();
  private final TimedNotifier alarm_1s = new TimedNotifier();
  private final TimedNotifier alarm_60s = new TimedNotifier();
  private final TimedNotifier alarm_600s = new TimedNotifier();
  //Dirty flags
  private boolean isDirty_biasChecker_EURCHF60s = false;
  private boolean isDirty_biasChecker_EURCHF600s = false;
  private boolean isDirty_biasChecker_EURJPY60s = false;
  private boolean isDirty_biasChecker_EURJPY600s = false;
  private boolean isDirty_biasChecker_GBPUSD60s = false;
  private boolean isDirty_biasChecker_GBPUSD600s = false;
  private boolean isDirty_biasChecker_USDJPY60s = false;
  private boolean isDirty_biasChecker_USDJPY600s = false;
  private boolean isDirty_alarm_1s = false;
  private boolean isDirty_alarm_600s = false;
  private boolean isDirty_biasChecker_AUDUSD60s = false;
  private boolean isDirty_biasChecker_AUDUSD600s = false;
  private boolean isDirty_biasChecker_EURGBP60s = false;
  private boolean isDirty_biasChecker_EURGBP600s = false;
  private boolean isDirty_biasChecker_EURUSD60s = false;
  private boolean isDirty_biasChecker_EURUSD600s = false;
  private boolean isDirty_biasChecker_USDCHF60s = false;
  private boolean isDirty_biasChecker_USDCHF600s = false;
  private boolean isDirty_alarm_60s = false;
  //Filter constants
  public static final int AUDUSD = 16;
  public static final int EURCHF = 71;
  public static final int EURGBP = 73;
  public static final int EURJPY = 76;
  public static final int EURUSD = 84;
  public static final int GBPUSD = 101;
  public static final int USDCHF = 275;
  public static final int USDJPY = 281;
  private TimingPulseEvent tick = new TimingPulseEvent(1);

  public G10Monitor() {
    //timeHandlerSeconds_2
    //breachNotifier
    breachNotifier.biasChecks = new PricingBiasCheck[16];
    breachNotifier.biasChecks[0] = biasChecker_AUDUSD60s;
    breachNotifier.biasChecks[1] = biasChecker_AUDUSD600s;
    breachNotifier.biasChecks[2] = biasChecker_EURCHF60s;
    breachNotifier.biasChecks[3] = biasChecker_EURCHF600s;
    breachNotifier.biasChecks[4] = biasChecker_EURGBP60s;
    breachNotifier.biasChecks[5] = biasChecker_EURGBP600s;
    breachNotifier.biasChecks[6] = biasChecker_EURJPY60s;
    breachNotifier.biasChecks[7] = biasChecker_EURJPY600s;
    breachNotifier.biasChecks[8] = biasChecker_EURUSD60s;
    breachNotifier.biasChecks[9] = biasChecker_EURUSD600s;
    breachNotifier.biasChecks[10] = biasChecker_GBPUSD60s;
    breachNotifier.biasChecks[11] = biasChecker_GBPUSD600s;
    breachNotifier.biasChecks[12] = biasChecker_USDCHF60s;
    breachNotifier.biasChecks[13] = biasChecker_USDCHF600s;
    breachNotifier.biasChecks[14] = biasChecker_USDJPY60s;
    breachNotifier.biasChecks[15] = biasChecker_USDJPY600s;
    //summaryBroadcaster
    summaryBroadcaster.biasChecks = new PricingBiasCheck[16];
    summaryBroadcaster.biasChecks[0] = biasChecker_AUDUSD60s;
    summaryBroadcaster.biasChecks[1] = biasChecker_AUDUSD600s;
    summaryBroadcaster.biasChecks[2] = biasChecker_EURCHF60s;
    summaryBroadcaster.biasChecks[3] = biasChecker_EURCHF600s;
    summaryBroadcaster.biasChecks[4] = biasChecker_EURGBP60s;
    summaryBroadcaster.biasChecks[5] = biasChecker_EURGBP600s;
    summaryBroadcaster.biasChecks[6] = biasChecker_EURJPY60s;
    summaryBroadcaster.biasChecks[7] = biasChecker_EURJPY600s;
    summaryBroadcaster.biasChecks[8] = biasChecker_EURUSD60s;
    summaryBroadcaster.biasChecks[9] = biasChecker_EURUSD600s;
    summaryBroadcaster.biasChecks[10] = biasChecker_GBPUSD60s;
    summaryBroadcaster.biasChecks[11] = biasChecker_GBPUSD600s;
    summaryBroadcaster.biasChecks[12] = biasChecker_USDCHF60s;
    summaryBroadcaster.biasChecks[13] = biasChecker_USDCHF600s;
    summaryBroadcaster.biasChecks[14] = biasChecker_USDJPY60s;
    summaryBroadcaster.biasChecks[15] = biasChecker_USDJPY600s;
    summaryBroadcaster.broadcastNotifer = alarm_1s;
    //orderCache
    //eventAuditDelegator_5
    //biasChecker_AUDUSD60s
    biasChecker_AUDUSD60s.orderCache = orderCache;
    biasChecker_AUDUSD60s.resetNotifer = alarm_60s;
    biasChecker_AUDUSD60s.pair = com.fluxtion.fx.util.CcyPair.AUDUSD;
    biasChecker_AUDUSD60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_AUDUSD600s
    biasChecker_AUDUSD600s.orderCache = orderCache;
    biasChecker_AUDUSD600s.resetNotifer = alarm_600s;
    biasChecker_AUDUSD600s.pair = com.fluxtion.fx.util.CcyPair.AUDUSD;
    biasChecker_AUDUSD600s.avgBiasNotificationLimit = (double) 0.001;
    //biasChecker_EURCHF60s
    biasChecker_EURCHF60s.orderCache = orderCache;
    biasChecker_EURCHF60s.resetNotifer = alarm_60s;
    biasChecker_EURCHF60s.pair = com.fluxtion.fx.util.CcyPair.EURCHF;
    biasChecker_EURCHF60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_EURCHF600s
    biasChecker_EURCHF600s.orderCache = orderCache;
    biasChecker_EURCHF600s.resetNotifer = alarm_600s;
    biasChecker_EURCHF600s.pair = com.fluxtion.fx.util.CcyPair.EURCHF;
    biasChecker_EURCHF600s.avgBiasNotificationLimit = (double) 0.001;
    //biasChecker_EURGBP60s
    biasChecker_EURGBP60s.orderCache = orderCache;
    biasChecker_EURGBP60s.resetNotifer = alarm_60s;
    biasChecker_EURGBP60s.pair = com.fluxtion.fx.util.CcyPair.EURGBP;
    biasChecker_EURGBP60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_EURGBP600s
    biasChecker_EURGBP600s.orderCache = orderCache;
    biasChecker_EURGBP600s.resetNotifer = alarm_600s;
    biasChecker_EURGBP600s.pair = com.fluxtion.fx.util.CcyPair.EURGBP;
    biasChecker_EURGBP600s.avgBiasNotificationLimit = (double) 0.001;
    //biasChecker_EURJPY60s
    biasChecker_EURJPY60s.orderCache = orderCache;
    biasChecker_EURJPY60s.resetNotifer = alarm_60s;
    biasChecker_EURJPY60s.pair = com.fluxtion.fx.util.CcyPair.EURJPY;
    biasChecker_EURJPY60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_EURJPY600s
    biasChecker_EURJPY600s.orderCache = orderCache;
    biasChecker_EURJPY600s.resetNotifer = alarm_600s;
    biasChecker_EURJPY600s.pair = com.fluxtion.fx.util.CcyPair.EURJPY;
    biasChecker_EURJPY600s.avgBiasNotificationLimit = (double) 0.001;
    //biasChecker_EURUSD60s
    biasChecker_EURUSD60s.orderCache = orderCache;
    biasChecker_EURUSD60s.resetNotifer = alarm_60s;
    biasChecker_EURUSD60s.pair = com.fluxtion.fx.util.CcyPair.EURUSD;
    biasChecker_EURUSD60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_EURUSD600s
    biasChecker_EURUSD600s.orderCache = orderCache;
    biasChecker_EURUSD600s.resetNotifer = alarm_600s;
    biasChecker_EURUSD600s.pair = com.fluxtion.fx.util.CcyPair.EURUSD;
    biasChecker_EURUSD600s.avgBiasNotificationLimit = (double) 0.001;
    //biasChecker_GBPUSD60s
    biasChecker_GBPUSD60s.orderCache = orderCache;
    biasChecker_GBPUSD60s.resetNotifer = alarm_60s;
    biasChecker_GBPUSD60s.pair = com.fluxtion.fx.util.CcyPair.GBPUSD;
    biasChecker_GBPUSD60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_GBPUSD600s
    biasChecker_GBPUSD600s.orderCache = orderCache;
    biasChecker_GBPUSD600s.resetNotifer = alarm_600s;
    biasChecker_GBPUSD600s.pair = com.fluxtion.fx.util.CcyPair.GBPUSD;
    biasChecker_GBPUSD600s.avgBiasNotificationLimit = (double) 0.001;
    //biasChecker_USDCHF60s
    biasChecker_USDCHF60s.orderCache = orderCache;
    biasChecker_USDCHF60s.resetNotifer = alarm_60s;
    biasChecker_USDCHF60s.pair = com.fluxtion.fx.util.CcyPair.USDCHF;
    biasChecker_USDCHF60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_USDCHF600s
    biasChecker_USDCHF600s.orderCache = orderCache;
    biasChecker_USDCHF600s.resetNotifer = alarm_600s;
    biasChecker_USDCHF600s.pair = com.fluxtion.fx.util.CcyPair.USDCHF;
    biasChecker_USDCHF600s.avgBiasNotificationLimit = (double) 0.001;
    //biasChecker_USDJPY60s
    biasChecker_USDJPY60s.orderCache = orderCache;
    biasChecker_USDJPY60s.resetNotifer = alarm_60s;
    biasChecker_USDJPY60s.pair = com.fluxtion.fx.util.CcyPair.USDJPY;
    biasChecker_USDJPY60s.avgBiasNotificationLimit = (double) 0.0015;
    //biasChecker_USDJPY600s
    biasChecker_USDJPY600s.orderCache = orderCache;
    biasChecker_USDJPY600s.resetNotifer = alarm_600s;
    biasChecker_USDJPY600s.pair = com.fluxtion.fx.util.CcyPair.USDJPY;
    biasChecker_USDJPY600s.avgBiasNotificationLimit = (double) 0.001;
    //alarm_1s
    alarm_1s.periodInSeconds = (int) 1;
    alarm_1s.timeHandler = timeHandlerSeconds_2;
    //alarm_60s
    alarm_60s.periodInSeconds = (int) 60;
    alarm_60s.timeHandler = timeHandlerSeconds_2;
    //alarm_600s
    alarm_600s.periodInSeconds = (int) 600;
    alarm_600s.timeHandler = timeHandlerSeconds_2;
    init();
  }

  @Override
  public void newCustomerOrder(CustomerOrder customerOrder) {
    handleEvent(customerOrder);
  }

  @Override
  public void acceptCustomerOrder(CustomerOrderAccept orderAccept) {
    handleEvent(orderAccept);
  }

  @Override
  public void rejectCustomerOrder(CustomerOrderReject orderReject) {
    handleEvent(orderReject);
  }

  @Override
  public void newFxPrice(FxPrice fxPrice) {
    handleEvent(fxPrice);
  }

  @Override
  public void setWallClockTime(long milliseconds) {
    tick.currentTimeMillis = milliseconds;
    handleEvent(tick);
  }

  @Override
  public BiasNotifier getBreachNotifier() {
    return breachNotifier;
  }

  @Override
  public BiasSummaryBroadcaster getSummaryBroadcaster() {
    return summaryBroadcaster;
  }

  @Override
  public CustomerOrderCacheGlobal getOrderCache() {
    return orderCache;
  }

  @Override
  public void enableAudit(boolean enable) {
    if (enable) {
      handleEvent(ControlSignal.AUDIT_ON);
    } else {
      handleEvent(ControlSignal.AUDIT_OFF);
    }
  }

  @Override
  public void enableNotifications(boolean enable) {
    if (enable) {
      handleEvent(ControlSignal.NOTIFICATIONS_ON);
    } else {
      handleEvent(ControlSignal.NOTIFICATIONS_OFF);
    }
  }

  @Override
  public void enableResultPublication(boolean enable) {
    if (enable) {
      handleEvent(ControlSignal.RESULT_OUTPUT_ON);
    } else {
      handleEvent(ControlSignal.RESULT_OUTPUT_OFF);
    }
  }

  @Override
  public void registerEventAuditor(EventAuditor auditor) {
    handleEvent(new ListenerRegisration(auditor, EventAuditor.class, true));
  }

  @Override
  public void deRegisterEventAuditor(EventAuditor auditor) {
    handleEvent(new ListenerRegisration(auditor, EventAuditor.class, false));
  }

  @Override
  public void registerResultsReceiver(OrderBiasResultHandler handler) {
    handleEvent(new ListenerRegisration(handler, OrderBiasResultHandler.class, true));
  }

  @Override
  public void deRegisterResultsReceiver(OrderBiasResultHandler handler) {
    handleEvent(new ListenerRegisration(handler, OrderBiasResultHandler.class, false));
  }

  @Override
  public void registerBreachNotificationHandler(NotificationHandler handler) {
    handleEvent(new ListenerRegisration(handler, NotificationHandler.class, true));
  }

  @Override
  public void deRegisterBreachNotificationHandler(NotificationHandler handler) {
    handleEvent(new ListenerRegisration(handler, NotificationHandler.class, false));
  }

  public void handleEvent(ControlSignal typedEvent) {
    switch (typedEvent.filterString()) {
      case ("fxpricebias.audit"):
        eventAuditDelegator_5.controlNotification(typedEvent);
        afterEvent();
        return;
      case ("fxpricebias.notification"):
        breachNotifier.controlNotification(typedEvent);
        afterEvent();
        return;
      case ("fxpricebias.result"):
        summaryBroadcaster.controlNotification(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(CustomerOrder typedEvent) {
    //Default, no filter methods
    orderCache.onCustomerOrderPlaced(typedEvent);
    eventAuditDelegator_5.handleEvent(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(CustomerOrderAccept typedEvent) {
    switch (typedEvent.filterId()) {
      case (AUDUSD):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_AUDUSD60s = biasChecker_AUDUSD60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_AUDUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD60s);
        }
        isDirty_biasChecker_AUDUSD600s = biasChecker_AUDUSD600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_AUDUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURCHF):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURCHF60s = biasChecker_EURCHF60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF60s);
        }
        isDirty_biasChecker_EURCHF600s = biasChecker_EURCHF600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURGBP):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURGBP60s = biasChecker_EURGBP60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURGBP60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP60s);
        }
        isDirty_biasChecker_EURGBP600s = biasChecker_EURGBP600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURGBP600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURJPY):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURJPY60s = biasChecker_EURJPY60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY60s);
        }
        isDirty_biasChecker_EURJPY600s = biasChecker_EURJPY600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURUSD):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURUSD60s = biasChecker_EURUSD60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD60s);
        }
        isDirty_biasChecker_EURUSD600s = biasChecker_EURUSD600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (GBPUSD):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_GBPUSD60s = biasChecker_GBPUSD60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_GBPUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD60s);
        }
        isDirty_biasChecker_GBPUSD600s = biasChecker_GBPUSD600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_GBPUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (USDCHF):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_USDCHF60s = biasChecker_USDCHF60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_USDCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF60s);
        }
        isDirty_biasChecker_USDCHF600s = biasChecker_USDCHF600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_USDCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (USDJPY):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_USDJPY60s = biasChecker_USDJPY60s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY60s);
        }
        isDirty_biasChecker_USDJPY600s = biasChecker_USDJPY600s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
    }
    //Default, no filter methods
    orderCache.acceptedOrder(typedEvent);
    eventAuditDelegator_5.handleEvent(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(CustomerOrderReject typedEvent) {
    switch (typedEvent.filterId()) {
      case (AUDUSD):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_AUDUSD60s = biasChecker_AUDUSD60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_AUDUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD60s);
        }
        isDirty_biasChecker_AUDUSD600s = biasChecker_AUDUSD600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_AUDUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURCHF):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURCHF60s = biasChecker_EURCHF60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF60s);
        }
        isDirty_biasChecker_EURCHF600s = biasChecker_EURCHF600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURGBP):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURGBP60s = biasChecker_EURGBP60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURGBP60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP60s);
        }
        isDirty_biasChecker_EURGBP600s = biasChecker_EURGBP600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURGBP600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURJPY):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURJPY60s = biasChecker_EURJPY60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY60s);
        }
        isDirty_biasChecker_EURJPY600s = biasChecker_EURJPY600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURUSD):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURUSD60s = biasChecker_EURUSD60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD60s);
        }
        isDirty_biasChecker_EURUSD600s = biasChecker_EURUSD600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (GBPUSD):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_GBPUSD60s = biasChecker_GBPUSD60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_GBPUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD60s);
        }
        isDirty_biasChecker_GBPUSD600s = biasChecker_GBPUSD600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_GBPUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (USDCHF):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_USDCHF60s = biasChecker_USDCHF60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_USDCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF60s);
        }
        isDirty_biasChecker_USDCHF600s = biasChecker_USDCHF600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_USDCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (USDJPY):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_USDJPY60s = biasChecker_USDJPY60s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY60s);
        }
        isDirty_biasChecker_USDJPY600s = biasChecker_USDJPY600s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
    }
    //Default, no filter methods
    orderCache.rejectedOrder(typedEvent);
    eventAuditDelegator_5.handleEvent(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(FxPrice typedEvent) {
    switch (typedEvent.filterId()) {
      case (AUDUSD):
        isDirty_biasChecker_AUDUSD60s = biasChecker_AUDUSD60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_AUDUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD60s);
        }
        isDirty_biasChecker_AUDUSD600s = biasChecker_AUDUSD600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_AUDUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURCHF):
        isDirty_biasChecker_EURCHF60s = biasChecker_EURCHF60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF60s);
        }
        isDirty_biasChecker_EURCHF600s = biasChecker_EURCHF600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURGBP):
        isDirty_biasChecker_EURGBP60s = biasChecker_EURGBP60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURGBP60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP60s);
        }
        isDirty_biasChecker_EURGBP600s = biasChecker_EURGBP600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURGBP600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURJPY):
        isDirty_biasChecker_EURJPY60s = biasChecker_EURJPY60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY60s);
        }
        isDirty_biasChecker_EURJPY600s = biasChecker_EURJPY600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURUSD):
        isDirty_biasChecker_EURUSD60s = biasChecker_EURUSD60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD60s);
        }
        isDirty_biasChecker_EURUSD600s = biasChecker_EURUSD600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (GBPUSD):
        isDirty_biasChecker_GBPUSD60s = biasChecker_GBPUSD60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_GBPUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD60s);
        }
        isDirty_biasChecker_GBPUSD600s = biasChecker_GBPUSD600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_GBPUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (USDCHF):
        isDirty_biasChecker_USDCHF60s = biasChecker_USDCHF60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_USDCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF60s);
        }
        isDirty_biasChecker_USDCHF600s = biasChecker_USDCHF600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_USDCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (USDJPY):
        isDirty_biasChecker_USDJPY60s = biasChecker_USDJPY60s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_USDJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY60s);
        }
        isDirty_biasChecker_USDJPY600s = biasChecker_USDJPY600s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_USDJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
    }
    //Default, no filter methods
    eventAuditDelegator_5.handleEvent(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(ListenerRegisration typedEvent) {
    switch (typedEvent.filterString()) {
      case ("com.fluxtion.fx.EventAudit"):
        eventAuditDelegator_5.registerAuditor(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.fx.node.biascheck.NotificationHandler"):
        breachNotifier.registerBiasBreachNotificationListener(typedEvent);
        afterEvent();
        return;
      case ("com.fluxtion.fx.node.biascheck.OrderBiasResultHandler"):
        summaryBroadcaster.registerBiasResultListener(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(TimingPulseEvent typedEvent) {
    switch (typedEvent.filterId()) {
      case (1):
        timeHandlerSeconds_2.onTimingPulse(typedEvent);
        isDirty_alarm_1s = alarm_1s.processTimePulse();
        if (isDirty_alarm_1s) {
          summaryBroadcaster.publishSummary(alarm_1s);
        }
        isDirty_alarm_60s = alarm_60s.processTimePulse();
        isDirty_alarm_600s = alarm_600s.processTimePulse();
        isDirty_biasChecker_AUDUSD60s = biasChecker_AUDUSD60s.processBiasCheck();
        if (isDirty_biasChecker_AUDUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD60s);
        }
        isDirty_biasChecker_EURCHF60s = biasChecker_EURCHF60s.processBiasCheck();
        if (isDirty_biasChecker_EURCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF60s);
        }
        isDirty_biasChecker_EURGBP60s = biasChecker_EURGBP60s.processBiasCheck();
        if (isDirty_biasChecker_EURGBP60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP60s);
        }
        isDirty_biasChecker_EURJPY60s = biasChecker_EURJPY60s.processBiasCheck();
        if (isDirty_biasChecker_EURJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY60s);
        }
        isDirty_biasChecker_EURUSD60s = biasChecker_EURUSD60s.processBiasCheck();
        if (isDirty_biasChecker_EURUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD60s);
        }
        isDirty_biasChecker_GBPUSD60s = biasChecker_GBPUSD60s.processBiasCheck();
        if (isDirty_biasChecker_GBPUSD60s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD60s);
        }
        isDirty_biasChecker_USDCHF60s = biasChecker_USDCHF60s.processBiasCheck();
        if (isDirty_biasChecker_USDCHF60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF60s);
        }
        isDirty_biasChecker_USDJPY60s = biasChecker_USDJPY60s.processBiasCheck();
        if (isDirty_biasChecker_USDJPY60s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY60s);
        }
        isDirty_biasChecker_AUDUSD600s = biasChecker_AUDUSD600s.processBiasCheck();
        if (isDirty_biasChecker_AUDUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_AUDUSD600s);
        }
        isDirty_biasChecker_EURCHF600s = biasChecker_EURCHF600s.processBiasCheck();
        if (isDirty_biasChecker_EURCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURCHF600s);
        }
        isDirty_biasChecker_EURGBP600s = biasChecker_EURGBP600s.processBiasCheck();
        if (isDirty_biasChecker_EURGBP600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURGBP600s);
        }
        isDirty_biasChecker_EURJPY600s = biasChecker_EURJPY600s.processBiasCheck();
        if (isDirty_biasChecker_EURJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY600s);
        }
        isDirty_biasChecker_EURUSD600s = biasChecker_EURUSD600s.processBiasCheck();
        if (isDirty_biasChecker_EURUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD600s);
        }
        isDirty_biasChecker_GBPUSD600s = biasChecker_GBPUSD600s.processBiasCheck();
        if (isDirty_biasChecker_GBPUSD600s) {
          breachNotifier.notifyBiasCheck(biasChecker_GBPUSD600s);
        }
        isDirty_biasChecker_USDCHF600s = biasChecker_USDCHF600s.processBiasCheck();
        if (isDirty_biasChecker_USDCHF600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDCHF600s);
        }
        isDirty_biasChecker_USDJPY600s = biasChecker_USDJPY600s.processBiasCheck();
        if (isDirty_biasChecker_USDJPY600s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY600s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
    }
    //Default, no filter methods
    eventAuditDelegator_5.handleEvent(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  private void afterEvent() {
    biasChecker_USDJPY600s.afterEvent();
    biasChecker_USDCHF600s.afterEvent();
    biasChecker_GBPUSD600s.afterEvent();
    biasChecker_EURUSD600s.afterEvent();
    biasChecker_EURJPY600s.afterEvent();
    biasChecker_EURGBP600s.afterEvent();
    biasChecker_EURCHF600s.afterEvent();
    biasChecker_AUDUSD600s.afterEvent();
    biasChecker_USDJPY60s.afterEvent();
    biasChecker_USDCHF60s.afterEvent();
    biasChecker_GBPUSD60s.afterEvent();
    biasChecker_EURUSD60s.afterEvent();
    biasChecker_EURJPY60s.afterEvent();
    biasChecker_EURGBP60s.afterEvent();
    biasChecker_EURCHF60s.afterEvent();
    biasChecker_AUDUSD60s.afterEvent();
    alarm_600s.resetFiredFlag();
    alarm_60s.resetFiredFlag();
    alarm_1s.resetFiredFlag();
    orderCache.removeProcessedOrders();
    isDirty_biasChecker_EURCHF60s = false;
    isDirty_biasChecker_EURCHF600s = false;
    isDirty_biasChecker_EURJPY60s = false;
    isDirty_biasChecker_EURJPY600s = false;
    isDirty_biasChecker_GBPUSD60s = false;
    isDirty_biasChecker_GBPUSD600s = false;
    isDirty_biasChecker_USDJPY60s = false;
    isDirty_biasChecker_USDJPY600s = false;
    isDirty_alarm_1s = false;
    isDirty_alarm_600s = false;
    isDirty_biasChecker_AUDUSD60s = false;
    isDirty_biasChecker_AUDUSD600s = false;
    isDirty_biasChecker_EURGBP60s = false;
    isDirty_biasChecker_EURGBP600s = false;
    isDirty_biasChecker_EURUSD60s = false;
    isDirty_biasChecker_EURUSD600s = false;
    isDirty_biasChecker_USDCHF60s = false;
    isDirty_biasChecker_USDCHF600s = false;
    isDirty_alarm_60s = false;
  }

  private void init() {
    orderCache.init();
    alarm_1s.init();
    alarm_60s.init();
    alarm_600s.init();
    biasChecker_AUDUSD60s.init();
    biasChecker_EURCHF60s.init();
    biasChecker_EURGBP60s.init();
    biasChecker_EURJPY60s.init();
    biasChecker_EURUSD60s.init();
    biasChecker_GBPUSD60s.init();
    biasChecker_USDCHF60s.init();
    biasChecker_USDJPY60s.init();
    biasChecker_AUDUSD600s.init();
    biasChecker_EURCHF600s.init();
    biasChecker_EURGBP600s.init();
    biasChecker_EURJPY600s.init();
    biasChecker_EURUSD600s.init();
    biasChecker_GBPUSD600s.init();
    biasChecker_USDCHF600s.init();
    biasChecker_USDJPY600s.init();
    summaryBroadcaster.init();
    breachNotifier.init();
  }
}
