/*
 * Copyright (C) 2018 V12 Technology Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Server Side License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program.  If not, see
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */
package com.fluxtion.examples.tradingmonitor.generated.symbol;

import com.fluxtion.api.lifecycle.BatchHandler;
import com.fluxtion.api.lifecycle.EventHandler;
import com.fluxtion.api.lifecycle.Lifecycle;
import com.fluxtion.api.event.Event;
import com.fluxtion.api.event.EventPublsher;
import com.fluxtion.api.event.RegisterEventHandler;
import com.fluxtion.examples.tradingmonitor.AssetPrice;
import com.fluxtion.examples.tradingmonitor.AssetTradePos;
import com.fluxtion.examples.tradingmonitor.Deal;
import com.fluxtion.ext.streaming.api.ReusableEventHandler;
import com.fluxtion.ext.streaming.api.numeric.ConstantNumber;
import com.fluxtion.ext.streaming.api.stream.NumericPredicates;
import com.fluxtion.ext.streaming.api.stream.StreamFunctions.Count;
import com.fluxtion.ext.streaming.api.stream.StreamFunctions.Sum;

public class SymbolTradeMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final ConstantNumber constantNumber_3 = new ConstantNumber(-1.0);
  private final Count count_18 = new Count();
  private final Count count_23 = new Count();
  public final ReusableEventHandler deals = new ReusableEventHandler(2147483647, Deal.class);
  private final Map_getSize_By_multiply0 map_getSize_By_multiply0_2 =
      new Map_getSize_By_multiply0();
  private final Map_Number_By_multiply0 map_Number_By_multiply0_4 = new Map_Number_By_multiply0();
  private final NumericPredicates numericPredicates_16 = new NumericPredicates();
  private final NumericPredicates numericPredicates_21 = new NumericPredicates();
  public final ReusableEventHandler prices = new ReusableEventHandler(2147483647, AssetPrice.class);
  private final Sum sum_5 = new Sum();
  public final Map_Number_By_addValue0 cashPos = new Map_Number_By_addValue0();
  private final Push_Number_To_setCashPos0 push_Number_To_setCashPos0_12 =
      new Push_Number_To_setCashPos0();
  private final Sum sum_7 = new Sum();
  public final Map_getSize_By_addValue0 assetPos = new Map_getSize_By_addValue0();
  private final Filter_Number_By_outsideRange0 filter_Number_By_outsideRange0_22 =
      new Filter_Number_By_outsideRange0();
  private final Map_Number_By_increment1 map_Number_By_increment1_24 =
      new Map_Number_By_increment1();
  public final Map_Number_By_multiply1 mtm = new Map_Number_By_multiply1();
  public final Map_doubleValue_By_add0 pnl = new Map_doubleValue_By_add0();
  private final Filter_Number_By_lessThan0 filter_Number_By_lessThan0_17 =
      new Filter_Number_By_lessThan0();
  private final Map_Number_By_increment0 map_Number_By_increment0_19 =
      new Map_Number_By_increment0();
  private final Push_Number_To_setAssetPos0 push_Number_To_setAssetPos0_13 =
      new Push_Number_To_setAssetPos0();
  private final Push_Number_To_setMtm0 push_Number_To_setMtm0_14 = new Push_Number_To_setMtm0();
  private final Push_Number_To_setPnlBreaches0 push_Number_To_setPnlBreaches0_20 =
      new Push_Number_To_setPnlBreaches0();
  private final Push_Number_To_setPnl0 push_Number_To_setPnl0_15 = new Push_Number_To_setPnl0();
  private final Push_Number_To_setPositionBreaches0 push_Number_To_setPositionBreaches0_25 =
      new Push_Number_To_setPositionBreaches0();
  public final AssetTradePos assetTradePos = new AssetTradePos();
  private final EventPublsher eventPublsher_1 = new EventPublsher();
  //Dirty flags
  private boolean isDirty_assetPos = false;
  private boolean isDirty_assetTradePos = false;
  private boolean isDirty_cashPos = false;
  private boolean isDirty_constantNumber_3 = false;
  private boolean isDirty_deals = false;
  private boolean isDirty_eventPublsher_1 = false;
  private boolean isDirty_filter_Number_By_lessThan0_17 = false;
  private boolean isDirty_filter_Number_By_outsideRange0_22 = false;
  private boolean isDirty_map_Number_By_increment1_24 = false;
  private boolean isDirty_map_Number_By_increment0_19 = false;
  private boolean isDirty_map_Number_By_multiply0_4 = false;
  private boolean isDirty_map_getSize_By_multiply0_2 = false;
  private boolean isDirty_mtm = false;
  private boolean isDirty_pnl = false;
  private boolean isDirty_prices = false;
  private boolean isDirty_push_Number_To_setAssetPos0_13 = false;
  private boolean isDirty_push_Number_To_setCashPos0_12 = false;
  private boolean isDirty_push_Number_To_setMtm0_14 = false;
  private boolean isDirty_push_Number_To_setPnlBreaches0_20 = false;
  private boolean isDirty_push_Number_To_setPnl0_15 = false;
  private boolean isDirty_push_Number_To_setPositionBreaches0_25 = false;
  //Filter constants

  public SymbolTradeMonitor() {
    eventPublsher_1.nodeSource = new Event[1];
    eventPublsher_1.nodeSource[0] = assetTradePos;
    assetTradePos.setAssetPos(0.0);
    assetTradePos.setCashPos(0.0);
    assetTradePos.setMtm(0.0);
    assetTradePos.setPnl(0.0);
    assetTradePos.setPnlBreaches(0);
    assetTradePos.setPositionBreaches(0);
    filter_Number_By_lessThan0_17.setAlwaysReset(false);
    filter_Number_By_lessThan0_17.setNotifyOnChangeOnly(true);
    filter_Number_By_lessThan0_17.setResetImmediate(true);
    filter_Number_By_lessThan0_17.filterSubject = pnl;
    filter_Number_By_lessThan0_17.source_0 = pnl;
    filter_Number_By_lessThan0_17.f = numericPredicates_16;
    filter_Number_By_outsideRange0_22.setAlwaysReset(false);
    filter_Number_By_outsideRange0_22.setNotifyOnChangeOnly(true);
    filter_Number_By_outsideRange0_22.setResetImmediate(true);
    filter_Number_By_outsideRange0_22.filterSubject = assetPos;
    filter_Number_By_outsideRange0_22.source_0 = assetPos;
    filter_Number_By_outsideRange0_22.f = numericPredicates_21;
    cashPos.setAlwaysReset(false);
    cashPos.setNotifyOnChangeOnly(false);
    cashPos.setResetImmediate(true);
    cashPos.filterSubject = map_Number_By_multiply0_4;
    cashPos.f = sum_5;
    map_Number_By_increment1_24.setAlwaysReset(false);
    map_Number_By_increment1_24.setNotifyOnChangeOnly(false);
    map_Number_By_increment1_24.setResetImmediate(true);
    map_Number_By_increment1_24.filterSubject = filter_Number_By_outsideRange0_22;
    map_Number_By_increment1_24.f = count_23;
    map_Number_By_increment0_19.setAlwaysReset(false);
    map_Number_By_increment0_19.setNotifyOnChangeOnly(false);
    map_Number_By_increment0_19.setResetImmediate(true);
    map_Number_By_increment0_19.filterSubject = filter_Number_By_lessThan0_17;
    map_Number_By_increment0_19.f = count_18;
    mtm.setAlwaysReset(false);
    mtm.setNotifyOnChangeOnly(false);
    mtm.setResetImmediate(true);
    mtm.filterSubject = assetPos;
    mtm.source_0 = prices;
    map_Number_By_multiply0_4.setAlwaysReset(false);
    map_Number_By_multiply0_4.setNotifyOnChangeOnly(false);
    map_Number_By_multiply0_4.setResetImmediate(true);
    map_Number_By_multiply0_4.filterSubject = map_getSize_By_multiply0_2;
    map_Number_By_multiply0_4.source_0 = constantNumber_3;
    pnl.setAlwaysReset(false);
    pnl.setNotifyOnChangeOnly(false);
    pnl.setResetImmediate(true);
    pnl.filterSubject = mtm;
    pnl.source_0 = cashPos;
    assetPos.setAlwaysReset(false);
    assetPos.setNotifyOnChangeOnly(false);
    assetPos.setResetImmediate(true);
    assetPos.filterSubject = deals;
    assetPos.f = sum_7;
    map_getSize_By_multiply0_2.setAlwaysReset(false);
    map_getSize_By_multiply0_2.setNotifyOnChangeOnly(false);
    map_getSize_By_multiply0_2.setResetImmediate(true);
    map_getSize_By_multiply0_2.filterSubject = deals;
    map_getSize_By_multiply0_2.source_0 = deals;
    push_Number_To_setAssetPos0_13.filterSubject = assetPos;
    push_Number_To_setAssetPos0_13.f = assetTradePos;
    push_Number_To_setCashPos0_12.filterSubject = cashPos;
    push_Number_To_setCashPos0_12.f = assetTradePos;
    push_Number_To_setMtm0_14.filterSubject = mtm;
    push_Number_To_setMtm0_14.f = assetTradePos;
    push_Number_To_setPnlBreaches0_20.filterSubject = map_Number_By_increment0_19;
    push_Number_To_setPnlBreaches0_20.f = assetTradePos;
    push_Number_To_setPnl0_15.filterSubject = pnl;
    push_Number_To_setPnl0_15.f = assetTradePos;
    push_Number_To_setPositionBreaches0_25.filterSubject = map_Number_By_increment1_24;
    push_Number_To_setPositionBreaches0_25.f = assetTradePos;
    numericPredicates_16.doubleLimit_0 = (double) -200.0;
    numericPredicates_16.doubleLimit_1 = (double) Double.NaN;
    numericPredicates_21.doubleLimit_0 = (double) -200.0;
    numericPredicates_21.doubleLimit_1 = (double) 200.0;
  }

  @Override
  public void onEvent(com.fluxtion.api.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.api.event.RegisterEventHandler"):
        {
          RegisterEventHandler typedEvent = (RegisterEventHandler) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.examples.tradingmonitor.AssetPrice"):
        {
          AssetPrice typedEvent = (AssetPrice) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.examples.tradingmonitor.Deal"):
        {
          Deal typedEvent = (Deal) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(RegisterEventHandler typedEvent) {
    //Default, no filter methods
    isDirty_eventPublsher_1 = true;
    eventPublsher_1.registerEventHandler(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(AssetPrice typedEvent) {
    //Default, no filter methods
    isDirty_prices = true;
    prices.onEvent(typedEvent);
    if (isDirty_prices) {
      mtm.updated_source_0(prices);
    }
    if (isDirty_assetPos | isDirty_prices) {
      isDirty_mtm = mtm.onEvent();
      if (isDirty_mtm) {
        pnl.updated_filterSubject(mtm);
      }
    }
    if (isDirty_cashPos | isDirty_mtm) {
      isDirty_pnl = pnl.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_filter_Number_By_lessThan0_17 = filter_Number_By_lessThan0_17.onEvent();
      if (isDirty_filter_Number_By_lessThan0_17) {
        map_Number_By_increment0_19.updated_filterSubject(filter_Number_By_lessThan0_17);
      }
    }
    if (isDirty_filter_Number_By_lessThan0_17) {
      isDirty_map_Number_By_increment0_19 = map_Number_By_increment0_19.onEvent();
    }
    if (isDirty_mtm) {
      isDirty_push_Number_To_setMtm0_14 = push_Number_To_setMtm0_14.onEvent();
    }
    if (isDirty_map_Number_By_increment0_19) {
      isDirty_push_Number_To_setPnlBreaches0_20 = push_Number_To_setPnlBreaches0_20.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_push_Number_To_setPnl0_15 = push_Number_To_setPnl0_15.onEvent();
    }
    if (isDirty_push_Number_To_setAssetPos0_13
        | isDirty_push_Number_To_setCashPos0_12
        | isDirty_push_Number_To_setMtm0_14
        | isDirty_push_Number_To_setPnlBreaches0_20
        | isDirty_push_Number_To_setPnl0_15
        | isDirty_push_Number_To_setPositionBreaches0_25) {
      isDirty_assetTradePos = assetTradePos.updated();
      if (isDirty_assetTradePos) {
        eventPublsher_1.nodeUpdate(assetTradePos);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(Deal typedEvent) {
    //Default, no filter methods
    isDirty_deals = true;
    deals.onEvent(typedEvent);
    if (isDirty_deals) {
      map_getSize_By_multiply0_2.updated_filterSubject(deals);
      map_getSize_By_multiply0_2.updated_source_0(deals);
      assetPos.updated_filterSubject(deals);
    }
    if (isDirty_deals) {
      isDirty_map_getSize_By_multiply0_2 = map_getSize_By_multiply0_2.onEvent();
      if (isDirty_map_getSize_By_multiply0_2) {
        map_Number_By_multiply0_4.updated_filterSubject(map_getSize_By_multiply0_2);
      }
    }
    if (isDirty_constantNumber_3 | isDirty_map_getSize_By_multiply0_2) {
      isDirty_map_Number_By_multiply0_4 = map_Number_By_multiply0_4.onEvent();
      if (isDirty_map_Number_By_multiply0_4) {
        cashPos.updated_filterSubject(map_Number_By_multiply0_4);
      }
    }
    if (isDirty_map_Number_By_multiply0_4) {
      isDirty_cashPos = cashPos.onEvent();
      if (isDirty_cashPos) {
        pnl.updated_source_0(cashPos);
      }
    }
    if (isDirty_cashPos) {
      isDirty_push_Number_To_setCashPos0_12 = push_Number_To_setCashPos0_12.onEvent();
    }
    if (isDirty_deals) {
      isDirty_assetPos = assetPos.onEvent();
      if (isDirty_assetPos) {
        mtm.updated_filterSubject(assetPos);
      }
    }
    if (isDirty_assetPos) {
      isDirty_filter_Number_By_outsideRange0_22 = filter_Number_By_outsideRange0_22.onEvent();
      if (isDirty_filter_Number_By_outsideRange0_22) {
        map_Number_By_increment1_24.updated_filterSubject(filter_Number_By_outsideRange0_22);
      }
    }
    if (isDirty_filter_Number_By_outsideRange0_22) {
      isDirty_map_Number_By_increment1_24 = map_Number_By_increment1_24.onEvent();
    }
    if (isDirty_assetPos | isDirty_prices) {
      isDirty_mtm = mtm.onEvent();
      if (isDirty_mtm) {
        pnl.updated_filterSubject(mtm);
      }
    }
    if (isDirty_cashPos | isDirty_mtm) {
      isDirty_pnl = pnl.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_filter_Number_By_lessThan0_17 = filter_Number_By_lessThan0_17.onEvent();
      if (isDirty_filter_Number_By_lessThan0_17) {
        map_Number_By_increment0_19.updated_filterSubject(filter_Number_By_lessThan0_17);
      }
    }
    if (isDirty_filter_Number_By_lessThan0_17) {
      isDirty_map_Number_By_increment0_19 = map_Number_By_increment0_19.onEvent();
    }
    if (isDirty_assetPos) {
      isDirty_push_Number_To_setAssetPos0_13 = push_Number_To_setAssetPos0_13.onEvent();
    }
    if (isDirty_mtm) {
      isDirty_push_Number_To_setMtm0_14 = push_Number_To_setMtm0_14.onEvent();
    }
    if (isDirty_map_Number_By_increment0_19) {
      isDirty_push_Number_To_setPnlBreaches0_20 = push_Number_To_setPnlBreaches0_20.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_push_Number_To_setPnl0_15 = push_Number_To_setPnl0_15.onEvent();
    }
    if (isDirty_map_Number_By_increment1_24) {
      isDirty_push_Number_To_setPositionBreaches0_25 =
          push_Number_To_setPositionBreaches0_25.onEvent();
    }
    if (isDirty_push_Number_To_setAssetPos0_13
        | isDirty_push_Number_To_setCashPos0_12
        | isDirty_push_Number_To_setMtm0_14
        | isDirty_push_Number_To_setPnlBreaches0_20
        | isDirty_push_Number_To_setPnl0_15
        | isDirty_push_Number_To_setPositionBreaches0_25) {
      isDirty_assetTradePos = assetTradePos.updated();
      if (isDirty_assetTradePos) {
        eventPublsher_1.nodeUpdate(assetTradePos);
      }
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    map_Number_By_increment0_19.resetAfterEvent();
    filter_Number_By_lessThan0_17.resetAfterEvent();
    map_Number_By_increment1_24.resetAfterEvent();
    filter_Number_By_outsideRange0_22.resetAfterEvent();
    assetPos.resetAfterEvent();
    cashPos.resetAfterEvent();
    isDirty_assetPos = false;
    isDirty_assetTradePos = false;
    isDirty_cashPos = false;
    isDirty_constantNumber_3 = false;
    isDirty_deals = false;
    isDirty_eventPublsher_1 = false;
    isDirty_filter_Number_By_lessThan0_17 = false;
    isDirty_filter_Number_By_outsideRange0_22 = false;
    isDirty_map_Number_By_increment1_24 = false;
    isDirty_map_Number_By_increment0_19 = false;
    isDirty_map_Number_By_multiply0_4 = false;
    isDirty_map_getSize_By_multiply0_2 = false;
    isDirty_mtm = false;
    isDirty_pnl = false;
    isDirty_prices = false;
    isDirty_push_Number_To_setAssetPos0_13 = false;
    isDirty_push_Number_To_setCashPos0_12 = false;
    isDirty_push_Number_To_setMtm0_14 = false;
    isDirty_push_Number_To_setPnlBreaches0_20 = false;
    isDirty_push_Number_To_setPnl0_15 = false;
    isDirty_push_Number_To_setPositionBreaches0_25 = false;
  }

  @Override
  public void init() {
    map_getSize_By_multiply0_2.init();
    map_Number_By_multiply0_4.init();
    cashPos.init();
    assetPos.init();
    filter_Number_By_outsideRange0_22.init();
    map_Number_By_increment1_24.init();
    mtm.init();
    pnl.init();
    filter_Number_By_lessThan0_17.init();
    map_Number_By_increment0_19.init();
    eventPublsher_1.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
