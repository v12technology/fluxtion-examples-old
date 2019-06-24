package com.fluxtion.examples.tradingmonitor.generated.portfolio;

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.examples.tradingmonitor.PortfolioTradePos;
import com.fluxtion.ext.streaming.api.FilterWrapper;
import com.fluxtion.ext.streaming.api.Test;
import com.fluxtion.ext.streaming.api.Wrapper;
import com.fluxtion.ext.streaming.api.stream.AbstractFilterWrapper;
import com.fluxtion.ext.streaming.api.stream.NodeWrapper;
import com.fluxtion.ext.streaming.api.stream.NumericPredicates;

/**
 * generated filter function wrapper.
 *
 * <ul>
 *   <li>input class : {@link PortfolioTradePos}
 *   <li>filter function : {@link NumericPredicates#lessThan}
 * </ul>
 *
 * @author Greg Higgins
 */
public class Filter_getPnl_By_lessThan0 extends AbstractFilterWrapper<PortfolioTradePos> {

  //source operand inputs
  public NodeWrapper filterSubject;
  public NodeWrapper source_0;
  @NoEventReference public NumericPredicates f;
  @NoEventReference public Object resetNotifier;
  private boolean parentReset = false;

  @Initialise
  public void init() {
    result = false;
  }

  @OnEvent
  public boolean onEvent() {
    boolean oldValue = result;
    result = f.lessThan((double) ((PortfolioTradePos) source_0.event()).getPnl());
    //this is probably right - to be tested
    //return (!notifyOnChangeOnly | !oldValue) & result;
    return (!notifyOnChangeOnly & result) | ((!oldValue) & result);
  }

  @OnParentUpdate("resetNotifier")
  public void resetNotification(Object resetNotifier) {
    parentReset = true;
    if (isResetImmediate()) {
      result = false;
      parentReset = false;
    }
  }

  @AfterEvent
  public void resetAfterEvent() {
    if (parentReset) {
      result = false;
    }
    parentReset = false;
  }

  @Override
  public FilterWrapper<PortfolioTradePos> resetNotifier(Object resetNotifier) {
    this.resetNotifier = resetNotifier;
    return this;
  }

  @Override
  public PortfolioTradePos event() {
    return (PortfolioTradePos) filterSubject.event();
  }

  @Override
  public Class<PortfolioTradePos> eventClass() {
    return PortfolioTradePos.class;
  }
}
