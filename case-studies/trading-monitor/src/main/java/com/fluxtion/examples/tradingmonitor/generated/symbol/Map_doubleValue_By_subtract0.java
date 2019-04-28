package com.fluxtion.examples.tradingmonitor.generated.symbol;

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.examples.tradingmonitor.generated.symbol.Map_Number_By_addValue0;
import com.fluxtion.examples.tradingmonitor.generated.symbol.Map_doubleValue_By_multiply0;
import com.fluxtion.ext.streaming.api.FilterWrapper;
import com.fluxtion.ext.streaming.api.Test;
import com.fluxtion.ext.streaming.api.Wrapper;
import com.fluxtion.ext.streaming.api.numeric.MutableNumber;
import com.fluxtion.ext.streaming.api.stream.AbstractFilterWrapper;
import com.fluxtion.ext.streaming.api.stream.StreamFunctions;

/**
 * generated mapper function wrapper for a numeric primitive.
 *
 * <ul>
 *   <li>output class : {@link Number}
 *   <li>input class : {@link Number}
 *   <li>map function : {@link StreamFunctions#subtract}
 * </ul>
 *
 * @author Greg Higgins
 */
public class Map_doubleValue_By_subtract0 extends AbstractFilterWrapper<Number> {

  public Map_doubleValue_By_multiply0 filterSubject;
  private boolean filterSubjectUpdated;
  public Map_Number_By_addValue0 source_0;
  private boolean source_0Updated;
  private double result;
  private MutableNumber value;
  private MutableNumber oldValue;

  @OnEvent
  public boolean onEvent() {
    oldValue.set(result);
    if (allSourcesUpdated()) {
      result =
          StreamFunctions.subtract(
              (double) ((Number) filterSubject.event()).doubleValue(),
              (double) ((Number) source_0.event()).doubleValue());
    }
    value.set(result);
    return allSourcesUpdated() & !notifyOnChangeOnly | (!oldValue.equals(value));
  }

  private boolean allSourcesUpdated() {
    boolean updated = filterSubjectUpdated;
    updated &= source_0Updated;
    return updated;
  }

  @OnParentUpdate("filterSubject")
  public void updated_filterSubject(Map_doubleValue_By_multiply0 updated) {
    filterSubjectUpdated = true;
  }

  @OnParentUpdate("source_0")
  public void updated_source_0(Map_Number_By_addValue0 updated) {
    source_0Updated = true;
  }

  @Override
  public Number event() {
    return value;
  }

  @Override
  public Class<Number> eventClass() {
    return Number.class;
  }

  @Initialise
  public void init() {
    result = 0;
    value = new MutableNumber();
    oldValue = new MutableNumber();
    filterSubjectUpdated = false;
  }
}
