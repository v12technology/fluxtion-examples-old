/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.fx.example2;


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

public class PorfolioMonitor implements BiasProcessor {

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
  private final PricingBiasCheck biasChecker_EURDKK900s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURDKK36000s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURGBP60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURGBP600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURHUF900s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURHUF36000s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURJPY45s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURJPY300s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURNOK900s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURNOK36000s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURUSD20s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURUSD60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_EURUSD600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_GBPUSD60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_GBPUSD600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDCHF60s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDCHF600s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDJPY45s = new PricingBiasCheck();
  private final PricingBiasCheck biasChecker_USDJPY300s = new PricingBiasCheck();
  private final TimedNotifier alarm_1s = new TimedNotifier();
  private final TimedNotifier alarm_20s = new TimedNotifier();
  private final TimedNotifier alarm_45s = new TimedNotifier();
  private final TimedNotifier alarm_60s = new TimedNotifier();
  private final TimedNotifier alarm_300s = new TimedNotifier();
  private final TimedNotifier alarm_600s = new TimedNotifier();
  private final TimedNotifier alarm_900s = new TimedNotifier();
  private final TimedNotifier alarm_36000s = new TimedNotifier();
  //Dirty flags
  private boolean isDirty_biasChecker_EURDKK900s = false;
  private boolean isDirty_biasChecker_AUDUSD60s = false;
  private boolean isDirty_biasChecker_AUDUSD600s = false;
  private boolean isDirty_biasChecker_GBPUSD60s = false;
  private boolean isDirty_biasChecker_EURGBP60s = false;
  private boolean isDirty_biasChecker_EURGBP600s = false;
  private boolean isDirty_biasChecker_EURHUF36000s = false;
  private boolean isDirty_biasChecker_EURJPY45s = false;
  private boolean isDirty_alarm_36000s = false;
  private boolean isDirty_alarm_1s = false;
  private boolean isDirty_alarm_600s = false;
  private boolean isDirty_alarm_300s = false;
  private boolean isDirty_biasChecker_EURJPY300s = false;
  private boolean isDirty_biasChecker_GBPUSD600s = false;
  private boolean isDirty_biasChecker_EURUSD20s = false;
  private boolean isDirty_biasChecker_EURNOK900s = false;
  private boolean isDirty_biasChecker_EURDKK36000s = false;
  private boolean isDirty_biasChecker_EURCHF60s = false;
  private boolean isDirty_biasChecker_EURCHF600s = false;
  private boolean isDirty_biasChecker_EURHUF900s = false;
  private boolean isDirty_biasChecker_EURNOK36000s = false;
  private boolean isDirty_biasChecker_USDJPY300s = false;
  private boolean isDirty_biasChecker_USDJPY45s = false;
  private boolean isDirty_alarm_20s = false;
  private boolean isDirty_alarm_60s = false;
  private boolean isDirty_alarm_900s = false;
  private boolean isDirty_alarm_45s = false;
  private boolean isDirty_biasChecker_EURUSD60s = false;
  private boolean isDirty_biasChecker_EURUSD600s = false;
  private boolean isDirty_biasChecker_USDCHF60s = false;
  private boolean isDirty_biasChecker_USDCHF600s = false;
  //Filter constants
  public static final int AUDUSD = 16;
  public static final int EURCHF = 71;
  public static final int EURDKK = 72;
  public static final int EURGBP = 73;
  public static final int EURHUF = 75;
  public static final int EURJPY = 76;
  public static final int EURNOK = 77;
  public static final int EURUSD = 84;
  public static final int GBPUSD = 101;
  public static final int USDCHF = 275;
  public static final int USDJPY = 281;
  private TimingPulseEvent tick = new TimingPulseEvent(1);

  public PorfolioMonitor() {
    //timeHandlerSeconds_2
    //breachNotifier
    breachNotifier.biasChecks = new PricingBiasCheck[20];
    breachNotifier.biasChecks[0] = biasChecker_AUDUSD60s;
    breachNotifier.biasChecks[1] = biasChecker_AUDUSD600s;
    breachNotifier.biasChecks[2] = biasChecker_EURCHF60s;
    breachNotifier.biasChecks[3] = biasChecker_EURCHF600s;
    breachNotifier.biasChecks[4] = biasChecker_EURDKK36000s;
    breachNotifier.biasChecks[5] = biasChecker_EURGBP60s;
    breachNotifier.biasChecks[6] = biasChecker_EURGBP600s;
    breachNotifier.biasChecks[7] = biasChecker_EURHUF36000s;
    breachNotifier.biasChecks[8] = biasChecker_EURJPY45s;
    breachNotifier.biasChecks[9] = biasChecker_EURJPY300s;
    breachNotifier.biasChecks[10] = biasChecker_EURNOK36000s;
    breachNotifier.biasChecks[11] = biasChecker_EURUSD20s;
    breachNotifier.biasChecks[12] = biasChecker_EURUSD60s;
    breachNotifier.biasChecks[13] = biasChecker_EURUSD600s;
    breachNotifier.biasChecks[14] = biasChecker_GBPUSD60s;
    breachNotifier.biasChecks[15] = biasChecker_GBPUSD600s;
    breachNotifier.biasChecks[16] = biasChecker_USDCHF60s;
    breachNotifier.biasChecks[17] = biasChecker_USDCHF600s;
    breachNotifier.biasChecks[18] = biasChecker_USDJPY45s;
    breachNotifier.biasChecks[19] = biasChecker_USDJPY300s;
    //summaryBroadcaster
    summaryBroadcaster.biasChecks = new PricingBiasCheck[23];
    summaryBroadcaster.biasChecks[0] = biasChecker_AUDUSD60s;
    summaryBroadcaster.biasChecks[1] = biasChecker_AUDUSD600s;
    summaryBroadcaster.biasChecks[2] = biasChecker_EURCHF60s;
    summaryBroadcaster.biasChecks[3] = biasChecker_EURCHF600s;
    summaryBroadcaster.biasChecks[4] = biasChecker_EURDKK900s;
    summaryBroadcaster.biasChecks[5] = biasChecker_EURDKK36000s;
    summaryBroadcaster.biasChecks[6] = biasChecker_EURGBP60s;
    summaryBroadcaster.biasChecks[7] = biasChecker_EURGBP600s;
    summaryBroadcaster.biasChecks[8] = biasChecker_EURHUF900s;
    summaryBroadcaster.biasChecks[9] = biasChecker_EURHUF36000s;
    summaryBroadcaster.biasChecks[10] = biasChecker_EURJPY45s;
    summaryBroadcaster.biasChecks[11] = biasChecker_EURJPY300s;
    summaryBroadcaster.biasChecks[12] = biasChecker_EURNOK900s;
    summaryBroadcaster.biasChecks[13] = biasChecker_EURNOK36000s;
    summaryBroadcaster.biasChecks[14] = biasChecker_EURUSD20s;
    summaryBroadcaster.biasChecks[15] = biasChecker_EURUSD60s;
    summaryBroadcaster.biasChecks[16] = biasChecker_EURUSD600s;
    summaryBroadcaster.biasChecks[17] = biasChecker_GBPUSD60s;
    summaryBroadcaster.biasChecks[18] = biasChecker_GBPUSD600s;
    summaryBroadcaster.biasChecks[19] = biasChecker_USDCHF60s;
    summaryBroadcaster.biasChecks[20] = biasChecker_USDCHF600s;
    summaryBroadcaster.biasChecks[21] = biasChecker_USDJPY45s;
    summaryBroadcaster.biasChecks[22] = biasChecker_USDJPY300s;
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
    //biasChecker_EURDKK900s
    biasChecker_EURDKK900s.orderCache = orderCache;
    biasChecker_EURDKK900s.resetNotifer = alarm_900s;
    biasChecker_EURDKK900s.pair = com.fluxtion.fx.util.CcyPair.EURDKK;
    biasChecker_EURDKK900s.avgBiasNotificationLimit = (double) 0.0;
    //biasChecker_EURDKK36000s
    biasChecker_EURDKK36000s.orderCache = orderCache;
    biasChecker_EURDKK36000s.resetNotifer = alarm_36000s;
    biasChecker_EURDKK36000s.pair = com.fluxtion.fx.util.CcyPair.EURDKK;
    biasChecker_EURDKK36000s.avgBiasNotificationLimit = (double) 0.0075;
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
    //biasChecker_EURHUF900s
    biasChecker_EURHUF900s.orderCache = orderCache;
    biasChecker_EURHUF900s.resetNotifer = alarm_900s;
    biasChecker_EURHUF900s.pair = com.fluxtion.fx.util.CcyPair.EURHUF;
    biasChecker_EURHUF900s.avgBiasNotificationLimit = (double) 0.0;
    //biasChecker_EURHUF36000s
    biasChecker_EURHUF36000s.orderCache = orderCache;
    biasChecker_EURHUF36000s.resetNotifer = alarm_36000s;
    biasChecker_EURHUF36000s.pair = com.fluxtion.fx.util.CcyPair.EURHUF;
    biasChecker_EURHUF36000s.avgBiasNotificationLimit = (double) 0.0075;
    //biasChecker_EURJPY45s
    biasChecker_EURJPY45s.orderCache = orderCache;
    biasChecker_EURJPY45s.resetNotifer = alarm_45s;
    biasChecker_EURJPY45s.pair = com.fluxtion.fx.util.CcyPair.EURJPY;
    biasChecker_EURJPY45s.avgBiasNotificationLimit = (double) 0.25;
    //biasChecker_EURJPY300s
    biasChecker_EURJPY300s.orderCache = orderCache;
    biasChecker_EURJPY300s.resetNotifer = alarm_300s;
    biasChecker_EURJPY300s.pair = com.fluxtion.fx.util.CcyPair.EURJPY;
    biasChecker_EURJPY300s.avgBiasNotificationLimit = (double) 0.12;
    //biasChecker_EURNOK900s
    biasChecker_EURNOK900s.orderCache = orderCache;
    biasChecker_EURNOK900s.resetNotifer = alarm_900s;
    biasChecker_EURNOK900s.pair = com.fluxtion.fx.util.CcyPair.EURNOK;
    biasChecker_EURNOK900s.avgBiasNotificationLimit = (double) 0.0;
    //biasChecker_EURNOK36000s
    biasChecker_EURNOK36000s.orderCache = orderCache;
    biasChecker_EURNOK36000s.resetNotifer = alarm_36000s;
    biasChecker_EURNOK36000s.pair = com.fluxtion.fx.util.CcyPair.EURNOK;
    biasChecker_EURNOK36000s.avgBiasNotificationLimit = (double) 0.0075;
    //biasChecker_EURUSD20s
    biasChecker_EURUSD20s.orderCache = orderCache;
    biasChecker_EURUSD20s.resetNotifer = alarm_20s;
    biasChecker_EURUSD20s.pair = com.fluxtion.fx.util.CcyPair.EURUSD;
    biasChecker_EURUSD20s.avgBiasNotificationLimit = (double) 0.0022;
    //biasChecker_EURUSD60s
    biasChecker_EURUSD60s.orderCache = orderCache;
    biasChecker_EURUSD60s.resetNotifer = alarm_60s;
    biasChecker_EURUSD60s.pair = com.fluxtion.fx.util.CcyPair.EURUSD;
    biasChecker_EURUSD60s.avgBiasNotificationLimit = (double) 0.0011;
    //biasChecker_EURUSD600s
    biasChecker_EURUSD600s.orderCache = orderCache;
    biasChecker_EURUSD600s.resetNotifer = alarm_600s;
    biasChecker_EURUSD600s.pair = com.fluxtion.fx.util.CcyPair.EURUSD;
    biasChecker_EURUSD600s.avgBiasNotificationLimit = (double) 8.0E-4;
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
    //biasChecker_USDJPY45s
    biasChecker_USDJPY45s.orderCache = orderCache;
    biasChecker_USDJPY45s.resetNotifer = alarm_45s;
    biasChecker_USDJPY45s.pair = com.fluxtion.fx.util.CcyPair.USDJPY;
    biasChecker_USDJPY45s.avgBiasNotificationLimit = (double) 0.25;
    //biasChecker_USDJPY300s
    biasChecker_USDJPY300s.orderCache = orderCache;
    biasChecker_USDJPY300s.resetNotifer = alarm_300s;
    biasChecker_USDJPY300s.pair = com.fluxtion.fx.util.CcyPair.USDJPY;
    biasChecker_USDJPY300s.avgBiasNotificationLimit = (double) 0.12;
    //alarm_1s
    alarm_1s.periodInSeconds = (int) 1;
    alarm_1s.timeHandler = timeHandlerSeconds_2;
    //alarm_20s
    alarm_20s.periodInSeconds = (int) 20;
    alarm_20s.timeHandler = timeHandlerSeconds_2;
    //alarm_45s
    alarm_45s.periodInSeconds = (int) 45;
    alarm_45s.timeHandler = timeHandlerSeconds_2;
    //alarm_60s
    alarm_60s.periodInSeconds = (int) 60;
    alarm_60s.timeHandler = timeHandlerSeconds_2;
    //alarm_300s
    alarm_300s.periodInSeconds = (int) 300;
    alarm_300s.timeHandler = timeHandlerSeconds_2;
    //alarm_600s
    alarm_600s.periodInSeconds = (int) 600;
    alarm_600s.timeHandler = timeHandlerSeconds_2;
    //alarm_900s
    alarm_900s.periodInSeconds = (int) 900;
    alarm_900s.timeHandler = timeHandlerSeconds_2;
    //alarm_36000s
    alarm_36000s.periodInSeconds = (int) 36000;
    alarm_36000s.timeHandler = timeHandlerSeconds_2;
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

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (CustomerOrder.ID):
        {
          CustomerOrder typedEvent = (CustomerOrder) event;
          handleEvent(typedEvent);
          break;
        }
      case (CustomerOrderAccept.ID):
        {
          CustomerOrderAccept typedEvent = (CustomerOrderAccept) event;
          handleEvent(typedEvent);
          break;
        }
      case (CustomerOrderReject.ID):
        {
          CustomerOrderReject typedEvent = (CustomerOrderReject) event;
          handleEvent(typedEvent);
          break;
        }
      case (FxPrice.ID):
        {
          FxPrice typedEvent = (FxPrice) event;
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
    }
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
      case (EURDKK):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURDKK900s = biasChecker_EURDKK900s.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURDKK36000s = biasChecker_EURDKK36000s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURDKK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURDKK36000s);
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
      case (EURHUF):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURHUF900s = biasChecker_EURHUF900s.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURHUF36000s = biasChecker_EURHUF36000s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURHUF36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURHUF36000s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURJPY):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURJPY45s = biasChecker_EURJPY45s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY45s);
        }
        isDirty_biasChecker_EURJPY300s = biasChecker_EURJPY300s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY300s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURNOK):
        orderCache.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURNOK900s = biasChecker_EURNOK900s.acceptedOrder(typedEvent);
        isDirty_biasChecker_EURNOK36000s = biasChecker_EURNOK36000s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURNOK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURNOK36000s);
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
        isDirty_biasChecker_EURUSD20s = biasChecker_EURUSD20s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_EURUSD20s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD20s);
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
        isDirty_biasChecker_USDJPY45s = biasChecker_USDJPY45s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY45s);
        }
        isDirty_biasChecker_USDJPY300s = biasChecker_USDJPY300s.acceptedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY300s);
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
      case (EURDKK):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURDKK900s = biasChecker_EURDKK900s.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURDKK36000s = biasChecker_EURDKK36000s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURDKK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURDKK36000s);
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
      case (EURHUF):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURHUF900s = biasChecker_EURHUF900s.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURHUF36000s = biasChecker_EURHUF36000s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURHUF36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURHUF36000s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURJPY):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURJPY45s = biasChecker_EURJPY45s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY45s);
        }
        isDirty_biasChecker_EURJPY300s = biasChecker_EURJPY300s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY300s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURNOK):
        orderCache.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURNOK900s = biasChecker_EURNOK900s.rejectedOrder(typedEvent);
        isDirty_biasChecker_EURNOK36000s = biasChecker_EURNOK36000s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURNOK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURNOK36000s);
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
        isDirty_biasChecker_EURUSD20s = biasChecker_EURUSD20s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_EURUSD20s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD20s);
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
        isDirty_biasChecker_USDJPY45s = biasChecker_USDJPY45s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY45s);
        }
        isDirty_biasChecker_USDJPY300s = biasChecker_USDJPY300s.rejectedOrder(typedEvent);
        if (isDirty_biasChecker_USDJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY300s);
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
      case (EURDKK):
        isDirty_biasChecker_EURDKK900s = biasChecker_EURDKK900s.customerPriceUpdate(typedEvent);
        isDirty_biasChecker_EURDKK36000s = biasChecker_EURDKK36000s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURDKK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURDKK36000s);
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
      case (EURHUF):
        isDirty_biasChecker_EURHUF900s = biasChecker_EURHUF900s.customerPriceUpdate(typedEvent);
        isDirty_biasChecker_EURHUF36000s = biasChecker_EURHUF36000s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURHUF36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURHUF36000s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURJPY):
        isDirty_biasChecker_EURJPY45s = biasChecker_EURJPY45s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY45s);
        }
        isDirty_biasChecker_EURJPY300s = biasChecker_EURJPY300s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY300s);
        }
        eventAuditDelegator_5.handleEvent(typedEvent);
        afterEvent();
        return;
      case (EURNOK):
        isDirty_biasChecker_EURNOK900s = biasChecker_EURNOK900s.customerPriceUpdate(typedEvent);
        isDirty_biasChecker_EURNOK36000s = biasChecker_EURNOK36000s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURNOK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURNOK36000s);
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
        isDirty_biasChecker_EURUSD20s = biasChecker_EURUSD20s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_EURUSD20s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD20s);
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
        isDirty_biasChecker_USDJPY45s = biasChecker_USDJPY45s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_USDJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY45s);
        }
        isDirty_biasChecker_USDJPY300s = biasChecker_USDJPY300s.customerPriceUpdate(typedEvent);
        if (isDirty_biasChecker_USDJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY300s);
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
      case ("com.fluxtion.fx.EventAuditor"):
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
        isDirty_alarm_900s = alarm_900s.processTimePulse();
        isDirty_alarm_36000s = alarm_36000s.processTimePulse();
        isDirty_alarm_45s = alarm_45s.processTimePulse();
        isDirty_alarm_300s = alarm_300s.processTimePulse();
        isDirty_alarm_20s = alarm_20s.processTimePulse();
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
        isDirty_biasChecker_EURDKK900s = biasChecker_EURDKK900s.processBiasCheck();
        isDirty_biasChecker_EURHUF900s = biasChecker_EURHUF900s.processBiasCheck();
        isDirty_biasChecker_EURNOK900s = biasChecker_EURNOK900s.processBiasCheck();
        isDirty_biasChecker_EURDKK36000s = biasChecker_EURDKK36000s.processBiasCheck();
        if (isDirty_biasChecker_EURDKK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURDKK36000s);
        }
        isDirty_biasChecker_EURHUF36000s = biasChecker_EURHUF36000s.processBiasCheck();
        if (isDirty_biasChecker_EURHUF36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURHUF36000s);
        }
        isDirty_biasChecker_EURNOK36000s = biasChecker_EURNOK36000s.processBiasCheck();
        if (isDirty_biasChecker_EURNOK36000s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURNOK36000s);
        }
        isDirty_biasChecker_EURJPY45s = biasChecker_EURJPY45s.processBiasCheck();
        if (isDirty_biasChecker_EURJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY45s);
        }
        isDirty_biasChecker_USDJPY45s = biasChecker_USDJPY45s.processBiasCheck();
        if (isDirty_biasChecker_USDJPY45s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY45s);
        }
        isDirty_biasChecker_EURJPY300s = biasChecker_EURJPY300s.processBiasCheck();
        if (isDirty_biasChecker_EURJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURJPY300s);
        }
        isDirty_biasChecker_USDJPY300s = biasChecker_USDJPY300s.processBiasCheck();
        if (isDirty_biasChecker_USDJPY300s) {
          breachNotifier.notifyBiasCheck(biasChecker_USDJPY300s);
        }
        isDirty_biasChecker_EURUSD20s = biasChecker_EURUSD20s.processBiasCheck();
        if (isDirty_biasChecker_EURUSD20s) {
          breachNotifier.notifyBiasCheck(biasChecker_EURUSD20s);
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

  public void afterEvent() {
    biasChecker_EURUSD20s.afterEvent();
    biasChecker_USDJPY300s.afterEvent();
    biasChecker_EURJPY300s.afterEvent();
    biasChecker_USDJPY45s.afterEvent();
    biasChecker_EURJPY45s.afterEvent();
    biasChecker_EURNOK36000s.afterEvent();
    biasChecker_EURHUF36000s.afterEvent();
    biasChecker_EURDKK36000s.afterEvent();
    biasChecker_EURNOK900s.afterEvent();
    biasChecker_EURHUF900s.afterEvent();
    biasChecker_EURDKK900s.afterEvent();
    biasChecker_USDCHF600s.afterEvent();
    biasChecker_GBPUSD600s.afterEvent();
    biasChecker_EURUSD600s.afterEvent();
    biasChecker_EURGBP600s.afterEvent();
    biasChecker_EURCHF600s.afterEvent();
    biasChecker_AUDUSD600s.afterEvent();
    biasChecker_USDCHF60s.afterEvent();
    biasChecker_GBPUSD60s.afterEvent();
    biasChecker_EURUSD60s.afterEvent();
    biasChecker_EURGBP60s.afterEvent();
    biasChecker_EURCHF60s.afterEvent();
    biasChecker_AUDUSD60s.afterEvent();
    alarm_20s.resetFiredFlag();
    alarm_300s.resetFiredFlag();
    alarm_45s.resetFiredFlag();
    alarm_36000s.resetFiredFlag();
    alarm_900s.resetFiredFlag();
    alarm_600s.resetFiredFlag();
    alarm_60s.resetFiredFlag();
    alarm_1s.resetFiredFlag();
    orderCache.removeProcessedOrders();
    isDirty_biasChecker_EURDKK900s = false;
    isDirty_biasChecker_AUDUSD60s = false;
    isDirty_biasChecker_AUDUSD600s = false;
    isDirty_biasChecker_GBPUSD60s = false;
    isDirty_biasChecker_EURGBP60s = false;
    isDirty_biasChecker_EURGBP600s = false;
    isDirty_biasChecker_EURHUF36000s = false;
    isDirty_biasChecker_EURJPY45s = false;
    isDirty_alarm_36000s = false;
    isDirty_alarm_1s = false;
    isDirty_alarm_600s = false;
    isDirty_alarm_300s = false;
    isDirty_biasChecker_EURJPY300s = false;
    isDirty_biasChecker_GBPUSD600s = false;
    isDirty_biasChecker_EURUSD20s = false;
    isDirty_biasChecker_EURNOK900s = false;
    isDirty_biasChecker_EURDKK36000s = false;
    isDirty_biasChecker_EURCHF60s = false;
    isDirty_biasChecker_EURCHF600s = false;
    isDirty_biasChecker_EURHUF900s = false;
    isDirty_biasChecker_EURNOK36000s = false;
    isDirty_biasChecker_USDJPY300s = false;
    isDirty_biasChecker_USDJPY45s = false;
    isDirty_alarm_20s = false;
    isDirty_alarm_60s = false;
    isDirty_alarm_900s = false;
    isDirty_alarm_45s = false;
    isDirty_biasChecker_EURUSD60s = false;
    isDirty_biasChecker_EURUSD600s = false;
    isDirty_biasChecker_USDCHF60s = false;
    isDirty_biasChecker_USDCHF600s = false;
  }

  private void init() {
    orderCache.init();
    alarm_1s.init();
    alarm_60s.init();
    alarm_600s.init();
    alarm_900s.init();
    alarm_36000s.init();
    alarm_45s.init();
    alarm_300s.init();
    alarm_20s.init();
    biasChecker_AUDUSD60s.init();
    biasChecker_EURCHF60s.init();
    biasChecker_EURGBP60s.init();
    biasChecker_EURUSD60s.init();
    biasChecker_GBPUSD60s.init();
    biasChecker_USDCHF60s.init();
    biasChecker_AUDUSD600s.init();
    biasChecker_EURCHF600s.init();
    biasChecker_EURGBP600s.init();
    biasChecker_EURUSD600s.init();
    biasChecker_GBPUSD600s.init();
    biasChecker_USDCHF600s.init();
    biasChecker_EURDKK900s.init();
    biasChecker_EURHUF900s.init();
    biasChecker_EURNOK900s.init();
    biasChecker_EURDKK36000s.init();
    biasChecker_EURHUF36000s.init();
    biasChecker_EURNOK36000s.init();
    biasChecker_EURJPY45s.init();
    biasChecker_USDJPY45s.init();
    biasChecker_EURJPY300s.init();
    biasChecker_USDJPY300s.init();
    biasChecker_EURUSD20s.init();
    summaryBroadcaster.init();
    breachNotifier.init();
  }
}
