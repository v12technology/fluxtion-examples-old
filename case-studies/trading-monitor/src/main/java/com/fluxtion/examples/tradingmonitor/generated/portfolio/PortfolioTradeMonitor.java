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
package com.fluxtion.examples.tradingmonitor.generated.portfolio;

import com.fluxtion.api.lifecycle.BatchHandler;
import com.fluxtion.api.lifecycle.EventHandler;
import com.fluxtion.api.lifecycle.Lifecycle;
import com.fluxtion.examples.tradingmonitor.AssetTradePos;
import com.fluxtion.examples.tradingmonitor.PortfolioTradePos;
import com.fluxtion.ext.streaming.api.ReusableEventHandler;
import com.fluxtion.ext.streaming.api.stream.NodeWrapper;
import com.fluxtion.ext.streaming.api.stream.NumericPredicates;
import com.fluxtion.ext.streaming.api.stream.StreamFunctions.Count;
import com.fluxtion.ext.streaming.api.stream.StreamOperator.ConsoleLog;
import com.fluxtion.ext.streaming.api.test.BooleanFilter;
import com.fluxtion.ext.text.api.event.EofEvent;

public class PortfolioTradeMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final Count count_5 = new Count();
  private final ReusableEventHandler handlerEofEvent =
      new ReusableEventHandler(2147483647, EofEvent.class);
  private final NumericPredicates numericPredicates_3 = new NumericPredicates();
  private final PortfolioTradePos portfolioTradePos_1 = new PortfolioTradePos();
  private final NodeWrapper nodeWrapper_2 = new NodeWrapper(portfolioTradePos_1);
  private final Filter_getPnl_By_lessThan0 filter_getPnl_By_lessThan0_4 =
      new Filter_getPnl_By_lessThan0();
  private final Map_PortfolioTradePos_By_increment0 map_PortfolioTradePos_By_increment0_6 =
      new Map_PortfolioTradePos_By_increment0();
  private final BooleanFilter booleanFilter_7 =
      new BooleanFilter(map_PortfolioTradePos_By_increment0_6, handlerEofEvent);
  public final ConsoleLog consoleMsg_1 =
      new ConsoleLog(booleanFilter_7, "portfolio loss gt 10k count -> ");
  //Dirty flags
  private boolean isDirty_booleanFilter_7 = false;
  private boolean isDirty_consoleMsg_1 = false;
  private boolean isDirty_filter_getPnl_By_lessThan0_4 = false;
  private boolean isDirty_handlerEofEvent = false;
  private boolean isDirty_map_PortfolioTradePos_By_increment0_6 = false;
  private boolean isDirty_nodeWrapper_2 = false;
  private boolean isDirty_portfolioTradePos_1 = false;
  //Filter constants

  public PortfolioTradeMonitor() {
    filter_getPnl_By_lessThan0_4.setAlwaysReset(false);
    filter_getPnl_By_lessThan0_4.setNotifyOnChangeOnly(false);
    filter_getPnl_By_lessThan0_4.setResetImmediate(true);
    filter_getPnl_By_lessThan0_4.filterSubject = nodeWrapper_2;
    filter_getPnl_By_lessThan0_4.source_0 = nodeWrapper_2;
    filter_getPnl_By_lessThan0_4.f = numericPredicates_3;
    map_PortfolioTradePos_By_increment0_6.setAlwaysReset(false);
    map_PortfolioTradePos_By_increment0_6.setNotifyOnChangeOnly(false);
    map_PortfolioTradePos_By_increment0_6.setResetImmediate(true);
    map_PortfolioTradePos_By_increment0_6.filterSubject = filter_getPnl_By_lessThan0_4;
    map_PortfolioTradePos_By_increment0_6.f = count_5;
    numericPredicates_3.doubleLimit_0 = (double) -1000.0;
    numericPredicates_3.doubleLimit_1 = (double) Double.NaN;
    consoleMsg_1.setMethodSupplier("doubleValue");
  }

  @Override
  public void onEvent(com.fluxtion.api.event.Event event) {
    switch (event.eventId()) {
      case (EofEvent.ID):
        {
          EofEvent typedEvent = (EofEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
    switch (event.getClass().getName()) {
      case ("com.fluxtion.examples.tradingmonitor.AssetTradePos"):
        {
          AssetTradePos typedEvent = (AssetTradePos) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(AssetTradePos typedEvent) {
    //Default, no filter methods
    isDirty_portfolioTradePos_1 = true;
    portfolioTradePos_1.positionUpdate(typedEvent);
    if (isDirty_portfolioTradePos_1) {
      isDirty_nodeWrapper_2 = nodeWrapper_2.onEvent();
    }
    if (isDirty_nodeWrapper_2) {
      isDirty_filter_getPnl_By_lessThan0_4 = filter_getPnl_By_lessThan0_4.onEvent();
      if (isDirty_filter_getPnl_By_lessThan0_4) {
        map_PortfolioTradePos_By_increment0_6.updated_filterSubject(filter_getPnl_By_lessThan0_4);
      }
    }
    if (isDirty_filter_getPnl_By_lessThan0_4) {
      isDirty_map_PortfolioTradePos_By_increment0_6 =
          map_PortfolioTradePos_By_increment0_6.onEvent();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(EofEvent typedEvent) {
    //Default, no filter methods
    isDirty_handlerEofEvent = true;
    handlerEofEvent.onEvent(typedEvent);
    if (isDirty_handlerEofEvent) {
      isDirty_booleanFilter_7 = booleanFilter_7.updated();
    }
    if (isDirty_booleanFilter_7) {
      isDirty_consoleMsg_1 = consoleMsg_1.log();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {
    map_PortfolioTradePos_By_increment0_6.resetAfterEvent();
    filter_getPnl_By_lessThan0_4.resetAfterEvent();
    isDirty_booleanFilter_7 = false;
    isDirty_consoleMsg_1 = false;
    isDirty_filter_getPnl_By_lessThan0_4 = false;
    isDirty_handlerEofEvent = false;
    isDirty_map_PortfolioTradePos_By_increment0_6 = false;
    isDirty_nodeWrapper_2 = false;
    isDirty_portfolioTradePos_1 = false;
  }

  @Override
  public void init() {
    portfolioTradePos_1.init();
    filter_getPnl_By_lessThan0_4.init();
    map_PortfolioTradePos_By_increment0_6.init();
    consoleMsg_1.init();
  }

  @Override
  public void tearDown() {
    portfolioTradePos_1.publishReport();
  }

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
