package com.fluxtion.learning.declarative.ext.music.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.learning.declarative.ext.music.generated.TrackStreamCsvMarshaller7;
import com.fluxtion.learning.declarative.ext.music.TrackPlaySummary;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;

/**
 * generated group by calculation state holder. This class holds thr
 *
 * target class  : TrackPlaySummary
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_11 implements Wrapper<TrackPlaySummary>{
    public TrackPlaySummary target;
    public AggregateAverage aggregateAverage9Function = new AggregateAverage();
    public double aggregateAverage9;
    public int aggregateCount10;

    public CalculationStateGroupBy_11(){
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
