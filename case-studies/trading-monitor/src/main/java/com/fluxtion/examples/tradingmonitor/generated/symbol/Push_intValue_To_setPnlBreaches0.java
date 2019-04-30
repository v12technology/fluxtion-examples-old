package com.fluxtion.examples.tradingmonitor.generated.symbol;

import com.fluxtion.examples.tradingmonitor.generated.symbol.*;
import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.api.annotations.PushReference;
import com.fluxtion.examples.tradingmonitor.AssetTradePos;
import com.fluxtion.examples.tradingmonitor.generated.symbol.Map_Number_By_increment0;
import com.fluxtion.ext.streaming.api.FilterWrapper;
import com.fluxtion.ext.streaming.api.Test;
import com.fluxtion.ext.streaming.api.Wrapper;
import com.fluxtion.ext.streaming.api.stream.AbstractFilterWrapper;

/**
 * Generated push function wrapper.
 *
 * <ul>
 *   <li>input class : {@link Number}
 *   <li>push target : {@link AssetTradePos#setPnlBreaches}
 * </ul>
 *
 * @author Greg Higgins
 */
public class Push_intValue_To_setPnlBreaches0 implements Wrapper<Push_intValue_To_setPnlBreaches0> {

  public Map_Number_By_increment0 filterSubject;
  @PushReference public AssetTradePos f;

  @OnEvent
  public boolean onEvent() {
    f.setPnlBreaches((int) ((Number) filterSubject.event()).intValue());
    return true;
  }

  @Override
  public Push_intValue_To_setPnlBreaches0 event() {
    return this;
  }

  @Override
  public Class<Push_intValue_To_setPnlBreaches0> eventClass() {
    return (Class<Push_intValue_To_setPnlBreaches0>) getClass();
  }
}
