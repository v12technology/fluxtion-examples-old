package com.fluxtion.learning.declarative.ext.music.indicators;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.learning.declarative.ext.music.TrackPlaySummary;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.learning.declarative.ext.music.util.PassThrough;
import com.fluxtion.learning.declarative.ext.music.indicators.MultiKeyFromTrackStream_26;

/**
 * generated group by calculation state holder. This class holds thr
 *
 * target class  : TrackPlaySummary
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_31 implements Wrapper<TrackPlaySummary>{
    public TrackPlaySummary target;
    public double aggregateSum29;
    public int passThrough30;

    public CalculationStateGroupBy_31(){
         target = new TrackPlaySummary();
    }

    @Override
    public TrackPlaySummary event() {
        return target;
    }

    @Override
    public Class<TrackPlaySummary> eventClass() {
        return TrackPlaySummary.class;
    }

}
