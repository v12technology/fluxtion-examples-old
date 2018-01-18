package com.fluxtion.learning.declarative.ext.music.indicators;

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
import com.fluxtion.learning.declarative.ext.music.TrackPlaySummary;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.learning.declarative.ext.music.util.PassThrough;
import com.fluxtion.learning.declarative.ext.music.indicators.MultiKeyFromTrackStream_17;

/**
 * generated group by holder.
 *
 * target class  : TrackPlaySummary
 * 
 * @author Greg Higgins
 */
public final class GroupBy_22 implements GroupBy<TrackPlaySummary>{

    private TrackPlaySummary target;
    private GroupByTargetMap<TrackPlaySummary, CalculationStateGroupBy_22> calcState;
    private GroupByIniitialiser<TrackStream, TrackPlaySummary> initialisertrackStream0;
    private MultiKeyFromTrackStream_17 multiKeyFromTrackStream_1718;

    @EventHandler
    public boolean updatetrackStream0(TrackStream event){
        multiKeyFromTrackStream_1718.setKey(event);
        CalculationStateGroupBy_22 instance = calcState.getOrCreateInstance(multiKeyFromTrackStream_1718, initialisertrackStream0, event);
        target = instance.target;
        {
			double value = instance.aggregateSum20;
			value = AggregateSum.calcSum((double)event.getStreams(), (double)value);
			target.setTotalPlays((int)value);
			instance.aggregateSum20 = value;
         }
        {
			int value = instance.passThrough21;
			value = PassThrough.passThrough((int)event.getStreams(), (int)value);
			target.addDailyPlays((int)value);
			instance.passThrough21 = value;
         }
        return true;
    }

    @OnEvent
    public boolean updated(){
        return true;
    }

    @Initialise
    public void init(){
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_22.class);
        multiKeyFromTrackStream_1718  = new MultiKeyFromTrackStream_17();
        initialisertrackStream0 = new GroupByIniitialiser<TrackStream, TrackPlaySummary>(){
        
            @Override
            public void apply(TrackStream source, TrackPlaySummary target) {
                target.setVendor_identifier((java.lang.String)source.getVendor_identifier());
                target.setTrackName((java.lang.String)source.getTrack_title());
                target.setTrack_artists((java.lang.String)source.getTrack_artists());
                target.setIsrc((java.lang.String)source.getIsrc());
                target.setDateString((java.lang.String)source.getDateString());
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
