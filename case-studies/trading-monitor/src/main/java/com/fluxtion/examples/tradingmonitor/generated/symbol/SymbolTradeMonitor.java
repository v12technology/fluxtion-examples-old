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
import com.fluxtion.ext.streaming.api.stream.NumericPredicates;
import com.fluxtion.ext.streaming.api.stream.StreamFunctions.Count;
import com.fluxtion.ext.streaming.api.stream.StreamFunctions.Sum;

public class SymbolTradeMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final Count count_11 = new Count();
  private final Count count_17 = new Count();
  public final ReusableEventHandler deals = new ReusableEventHandler(2147483647, Deal.class);
  private final Map_getSize_By_multiply0 map_getSize_By_multiply0_2 =
      new Map_getSize_By_multiply0();
  private final NumericPredicates numericPredicates_9 = new NumericPredicates();
  private final NumericPredicates numericPredicates_15 = new NumericPredicates();
  public final ReusableEventHandler prices = new ReusableEventHandler(2147483647, AssetPrice.class);
  private final Sum sum_3 = new Sum();
  public final Map_Number_By_addValue0 cost = new Map_Number_By_addValue0();
  private final Push_doubleValue_To_setCashPos0 push_doubleValue_To_setCashPos0_20 =
      new Push_doubleValue_To_setCashPos0();
  private final Sum sum_5 = new Sum();
  public final Map_getSize_By_addValue0 pos = new Map_getSize_By_addValue0();
  private final Filter_Number_By_outsideRange0 filter_Number_By_outsideRange0_16 =
      new Filter_Number_By_outsideRange0();
  private final Map_Number_By_increment1 map_Number_By_increment1_18 =
      new Map_Number_By_increment1();
  public final Map_doubleValue_By_multiply0 mtm = new Map_doubleValue_By_multiply0();
  public final Map_doubleValue_By_subtract0 pnl = new Map_doubleValue_By_subtract0();
  private final Filter_Number_By_lessThan0 filter_Number_By_lessThan0_10 =
      new Filter_Number_By_lessThan0();
  private final Map_Number_By_increment0 map_Number_By_increment0_12 =
      new Map_Number_By_increment0();
  private final Push_doubleValue_To_setAssetPos0 push_doubleValue_To_setAssetPos0_21 =
      new Push_doubleValue_To_setAssetPos0();
  private final Push_doubleValue_To_setMtm0 push_doubleValue_To_setMtm0_22 =
      new Push_doubleValue_To_setMtm0();
  private final Push_doubleValue_To_setPnl0 push_doubleValue_To_setPnl0_23 =
      new Push_doubleValue_To_setPnl0();
  private final Push_intValue_To_setPnlBreaches0 push_intValue_To_setPnlBreaches0_14 =
      new Push_intValue_To_setPnlBreaches0();
  private final Push_intValue_To_setPositionBreaches0 push_intValue_To_setPositionBreaches0_19 =
      new Push_intValue_To_setPositionBreaches0();
  public final AssetTradePos assetTradePos = new AssetTradePos();
  private final EventPublsher eventPublsher_1 = new EventPublsher();
  //Dirty flags
  private boolean isDirty_assetTradePos = false;
  private boolean isDirty_cost = false;
  private boolean isDirty_deals = false;
  private boolean isDirty_eventPublsher_1 = false;
  private boolean isDirty_filter_Number_By_lessThan0_10 = false;
  private boolean isDirty_filter_Number_By_outsideRange0_16 = false;
  private boolean isDirty_map_Number_By_increment1_18 = false;
  private boolean isDirty_map_Number_By_increment0_12 = false;
  private boolean isDirty_map_getSize_By_multiply0_2 = false;
  private boolean isDirty_mtm = false;
  private boolean isDirty_pnl = false;
  private boolean isDirty_pos = false;
  private boolean isDirty_prices = false;
  private boolean isDirty_push_doubleValue_To_setAssetPos0_21 = false;
  private boolean isDirty_push_doubleValue_To_setCashPos0_20 = false;
  private boolean isDirty_push_doubleValue_To_setMtm0_22 = false;
  private boolean isDirty_push_doubleValue_To_setPnl0_23 = false;
  private boolean isDirty_push_intValue_To_setPnlBreaches0_14 = false;
  private boolean isDirty_push_intValue_To_setPositionBreaches0_19 = false;
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
    filter_Number_By_lessThan0_10.setAlwaysReset(false);
    filter_Number_By_lessThan0_10.setNotifyOnChangeOnly(true);
    filter_Number_By_lessThan0_10.setResetImmediate(true);
    filter_Number_By_lessThan0_10.filterSubject = pnl;
    filter_Number_By_lessThan0_10.source_0 = pnl;
    filter_Number_By_lessThan0_10.f = numericPredicates_9;
    filter_Number_By_outsideRange0_16.setAlwaysReset(false);
    filter_Number_By_outsideRange0_16.setNotifyOnChangeOnly(true);
    filter_Number_By_outsideRange0_16.setResetImmediate(true);
    filter_Number_By_outsideRange0_16.filterSubject = pos;
    filter_Number_By_outsideRange0_16.source_0 = pos;
    filter_Number_By_outsideRange0_16.f = numericPredicates_15;
    cost.setAlwaysReset(false);
    cost.setNotifyOnChangeOnly(false);
    cost.setResetImmediate(true);
    cost.filterSubject = map_getSize_By_multiply0_2;
    cost.f = sum_3;
    map_Number_By_increment1_18.setAlwaysReset(false);
    map_Number_By_increment1_18.setNotifyOnChangeOnly(false);
    map_Number_By_increment1_18.setResetImmediate(true);
    map_Number_By_increment1_18.filterSubject = filter_Number_By_outsideRange0_16;
    map_Number_By_increment1_18.f = count_17;
    map_Number_By_increment0_12.setAlwaysReset(false);
    map_Number_By_increment0_12.setNotifyOnChangeOnly(false);
    map_Number_By_increment0_12.setResetImmediate(true);
    map_Number_By_increment0_12.filterSubject = filter_Number_By_lessThan0_10;
    map_Number_By_increment0_12.f = count_11;
    mtm.setAlwaysReset(false);
    mtm.setNotifyOnChangeOnly(false);
    mtm.setResetImmediate(true);
    mtm.filterSubject = pos;
    mtm.source_0 = prices;
    pnl.setAlwaysReset(false);
    pnl.setNotifyOnChangeOnly(false);
    pnl.setResetImmediate(true);
    pnl.filterSubject = mtm;
    pnl.source_0 = cost;
    pos.setAlwaysReset(false);
    pos.setNotifyOnChangeOnly(false);
    pos.setResetImmediate(true);
    pos.filterSubject = deals;
    pos.f = sum_5;
    map_getSize_By_multiply0_2.setAlwaysReset(false);
    map_getSize_By_multiply0_2.setNotifyOnChangeOnly(false);
    map_getSize_By_multiply0_2.setResetImmediate(true);
    map_getSize_By_multiply0_2.filterSubject = deals;
    map_getSize_By_multiply0_2.source_0 = deals;
    push_doubleValue_To_setAssetPos0_21.filterSubject = pos;
    push_doubleValue_To_setAssetPos0_21.f = assetTradePos;
    push_doubleValue_To_setCashPos0_20.filterSubject = cost;
    push_doubleValue_To_setCashPos0_20.f = assetTradePos;
    push_doubleValue_To_setMtm0_22.filterSubject = mtm;
    push_doubleValue_To_setMtm0_22.f = assetTradePos;
    push_doubleValue_To_setPnl0_23.filterSubject = pnl;
    push_doubleValue_To_setPnl0_23.f = assetTradePos;
    push_intValue_To_setPnlBreaches0_14.filterSubject = map_Number_By_increment0_12;
    push_intValue_To_setPnlBreaches0_14.f = assetTradePos;
    push_intValue_To_setPositionBreaches0_19.filterSubject = map_Number_By_increment1_18;
    push_intValue_To_setPositionBreaches0_19.f = assetTradePos;
    numericPredicates_9.doubleLimit_0 = (double) -2000.0;
    numericPredicates_9.doubleLimit_1 = (double) Double.NaN;
    numericPredicates_15.doubleLimit_0 = (double) -200.0;
    numericPredicates_15.doubleLimit_1 = (double) 200.0;
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
    if (isDirty_pos | isDirty_prices) {
      isDirty_mtm = mtm.onEvent();
      if (isDirty_mtm) {
        pnl.updated_filterSubject(mtm);
      }
    }
    if (isDirty_cost | isDirty_mtm) {
      isDirty_pnl = pnl.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_filter_Number_By_lessThan0_10 = filter_Number_By_lessThan0_10.onEvent();
      if (isDirty_filter_Number_By_lessThan0_10) {
        map_Number_By_increment0_12.updated_filterSubject(filter_Number_By_lessThan0_10);
      }
    }
    if (isDirty_filter_Number_By_lessThan0_10) {
      isDirty_map_Number_By_increment0_12 = map_Number_By_increment0_12.onEvent();
    }
    if (isDirty_mtm) {
      isDirty_push_doubleValue_To_setMtm0_22 = push_doubleValue_To_setMtm0_22.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_push_doubleValue_To_setPnl0_23 = push_doubleValue_To_setPnl0_23.onEvent();
    }
    if (isDirty_map_Number_By_increment0_12) {
      isDirty_push_intValue_To_setPnlBreaches0_14 = push_intValue_To_setPnlBreaches0_14.onEvent();
    }
    if (isDirty_push_doubleValue_To_setAssetPos0_21
        | isDirty_push_doubleValue_To_setCashPos0_20
        | isDirty_push_doubleValue_To_setMtm0_22
        | isDirty_push_doubleValue_To_setPnl0_23
        | isDirty_push_intValue_To_setPnlBreaches0_14
        | isDirty_push_intValue_To_setPositionBreaches0_19) {
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
      pos.updated_filterSubject(deals);
    }
    if (isDirty_deals) {
      isDirty_map_getSize_By_multiply0_2 = map_getSize_By_multiply0_2.onEvent();
      if (isDirty_map_getSize_By_multiply0_2) {
        cost.updated_filterSubject(map_getSize_By_multiply0_2);
      }
    }
    if (isDirty_map_getSize_By_multiply0_2) {
      isDirty_cost = cost.onEvent();
      if (isDirty_cost) {
        pnl.updated_source_0(cost);
      }
    }
    if (isDirty_cost) {
      isDirty_push_doubleValue_To_setCashPos0_20 = push_doubleValue_To_setCashPos0_20.onEvent();
    }
    if (isDirty_deals) {
      isDirty_pos = pos.onEvent();
      if (isDirty_pos) {
        mtm.updated_filterSubject(pos);
      }
    }
    if (isDirty_pos) {
      isDirty_filter_Number_By_outsideRange0_16 = filter_Number_By_outsideRange0_16.onEvent();
      if (isDirty_filter_Number_By_outsideRange0_16) {
        map_Number_By_increment1_18.updated_filterSubject(filter_Number_By_outsideRange0_16);
      }
    }
    if (isDirty_filter_Number_By_outsideRange0_16) {
      isDirty_map_Number_By_increment1_18 = map_Number_By_increment1_18.onEvent();
    }
    if (isDirty_pos | isDirty_prices) {
      isDirty_mtm = mtm.onEvent();
      if (isDirty_mtm) {
        pnl.updated_filterSubject(mtm);
      }
    }
    if (isDirty_cost | isDirty_mtm) {
      isDirty_pnl = pnl.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_filter_Number_By_lessThan0_10 = filter_Number_By_lessThan0_10.onEvent();
      if (isDirty_filter_Number_By_lessThan0_10) {
        map_Number_By_increment0_12.updated_filterSubject(filter_Number_By_lessThan0_10);
      }
    }
    if (isDirty_filter_Number_By_lessThan0_10) {
      isDirty_map_Number_By_increment0_12 = map_Number_By_increment0_12.onEvent();
    }
    if (isDirty_pos) {
      isDirty_push_doubleValue_To_setAssetPos0_21 = push_doubleValue_To_setAssetPos0_21.onEvent();
    }
    if (isDirty_mtm) {
      isDirty_push_doubleValue_To_setMtm0_22 = push_doubleValue_To_setMtm0_22.onEvent();
    }
    if (isDirty_pnl) {
      isDirty_push_doubleValue_To_setPnl0_23 = push_doubleValue_To_setPnl0_23.onEvent();
    }
    if (isDirty_map_Number_By_increment0_12) {
      isDirty_push_intValue_To_setPnlBreaches0_14 = push_intValue_To_setPnlBreaches0_14.onEvent();
    }
    if (isDirty_map_Number_By_increment1_18) {
      isDirty_push_intValue_To_setPositionBreaches0_19 =
          push_intValue_To_setPositionBreaches0_19.onEvent();
    }
    if (isDirty_push_doubleValue_To_setAssetPos0_21
        | isDirty_push_doubleValue_To_setCashPos0_20
        | isDirty_push_doubleValue_To_setMtm0_22
        | isDirty_push_doubleValue_To_setPnl0_23
        | isDirty_push_intValue_To_setPnlBreaches0_14
        | isDirty_push_intValue_To_setPositionBreaches0_19) {
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
    map_Number_By_increment0_12.resetAfterEvent();
    filter_Number_By_lessThan0_10.resetAfterEvent();
    map_Number_By_increment1_18.resetAfterEvent();
    filter_Number_By_outsideRange0_16.resetAfterEvent();
    pos.resetAfterEvent();
    cost.resetAfterEvent();
    isDirty_assetTradePos = false;
    isDirty_cost = false;
    isDirty_deals = false;
    isDirty_eventPublsher_1 = false;
    isDirty_filter_Number_By_lessThan0_10 = false;
    isDirty_filter_Number_By_outsideRange0_16 = false;
    isDirty_map_Number_By_increment1_18 = false;
    isDirty_map_Number_By_increment0_12 = false;
    isDirty_map_getSize_By_multiply0_2 = false;
    isDirty_mtm = false;
    isDirty_pnl = false;
    isDirty_pos = false;
    isDirty_prices = false;
    isDirty_push_doubleValue_To_setAssetPos0_21 = false;
    isDirty_push_doubleValue_To_setCashPos0_20 = false;
    isDirty_push_doubleValue_To_setMtm0_22 = false;
    isDirty_push_doubleValue_To_setPnl0_23 = false;
    isDirty_push_intValue_To_setPnlBreaches0_14 = false;
    isDirty_push_intValue_To_setPositionBreaches0_19 = false;
  }

  @Override
  public void init() {
    map_getSize_By_multiply0_2.init();
    cost.init();
    pos.init();
    filter_Number_By_outsideRange0_16.init();
    map_Number_By_increment1_18.init();
    mtm.init();
    pnl.init();
    filter_Number_By_lessThan0_10.init();
    map_Number_By_increment0_12.init();
    eventPublsher_1.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
