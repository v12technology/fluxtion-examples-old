package com.fluxtion.learning.declarative.ext.music.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.learning.declarative.ext.music.generated.TrackStreamCsvMarshaller7;
import com.fluxtion.learning.declarative.ext.music.TrackPlaySummary;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;

/**
 * generated group by holder.
 *
 * target class  : TrackPlaySummary
 * 
 * @author Greg Higgins
 */
public final class GroupBy_11 implements GroupBy<TrackPlaySummary>{

    public TrackStreamCsvMarshaller7 trackStreamCsvMarshaller70;
    private TrackPlaySummary target;
    private GroupByTargetMap<TrackPlaySummary, CalculationStateGroupBy_11> calcState;
    private GroupByIniitialiser<TrackStream, TrackPlaySummary> initialisertrackStreamCsvMarshaller70;

    @OnParentUpdate( "trackStreamCsvMarshaller70")
    public boolean updatetrackStreamCsvMarshaller70(TrackStreamCsvMarshaller7 eventWrapped){
        TrackStream event = eventWrapped.event();
        CalculationStateGroupBy_11 instance = calcState.getOrCreateInstance(event.getIsrc(), initialisertrackStreamCsvMarshaller70, event);
        target = instance.target;
        {
			double value = instance.aggregateAverage9;
			value = instance.aggregateAverage9Function.calcAverage((double)event.getStreams(), (double)value);
			target.setAvgDailyPlays((int)value);
			instance.aggregateAverage9 = value;
         }
        {
			int value = instance.aggregateCount10;
			value = AggregateCount.increment((int)event.getStreams(), (int)value);
			target.setTotalPlays((int)value);
			instance.aggregateCount10 = value;
         }
        return true;
    }

    @OnEvent
    public boolean updated(){
        return true;
    }

    @Initialise
    public void init(){
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_11.class);
        initialisertrackStreamCsvMarshaller70 = new GroupByIniitialiser<TrackStream, TrackPlaySummary>(){
        
            @Override
            public void apply(TrackStream source, TrackPlaySummary target) {
                target.setIsrc((java.lang.String)source.getIsrc());
                target.setTrackName((java.lang.String)source.getTrack_title());
            }

        };
    }

    @Override
    public TrackPlaySummary value(Object key) {
        return calcState.getInstance(key).target;
    }

    @Override
    public <V extends Wrapper<TrackPlaySummary>> Map<?, V> getMap() {
        return (Map<?, V>) calcState.getInstanceMap();
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
