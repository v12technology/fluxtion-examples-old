package com.fluxtion.examples.tradingmonitor.generated.symbol;

import com.fluxtion.examples.tradingmonitor.generated.symbol.*;
import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.api.annotations.PushReference;
import com.fluxtion.examples.tradingmonitor.AssetTradePos;
import com.fluxtion.examples.tradingmonitor.generated.symbol.Map_doubleValue_By_multiply1;
import com.fluxtion.ext.streaming.api.FilterWrapper;
import com.fluxtion.ext.streaming.api.Test;
import com.fluxtion.ext.streaming.api.Wrapper;
import com.fluxtion.ext.streaming.api.stream.AbstractFilterWrapper;

/**
 * Generated push function wrapper.
 *
 * <ul>
 *   <li>input class : {@link Number}
 *   <li>push target : {@link AssetTradePos#setMtm}
 * </ul>
 *
 * @author Greg Higgins
 */
public class Push_doubleValue_To_setMtm0 implements Wrapper<Push_doubleValue_To_setMtm0> {

  public Map_doubleValue_By_multiply1 filterSubject;
  @PushReference public AssetTradePos f;

  @OnEvent
  public boolean onEvent() {
    f.setMtm((double) ((Number) filterSubject.event()).doubleValue());
    return true;
  }

  @Override
  public Push_doubleValue_To_setMtm0 event() {
    return this;
  }

  @Override
  public Class<Push_doubleValue_To_setMtm0> eventClass() {
    return (Class<Push_doubleValue_To_setMtm0>) getClass();
  }
}
