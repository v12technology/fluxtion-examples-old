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
import com.fluxtion.learning.declarative.ext.music.indicators.MultiKeyFromTrackStream_1;
import com.fluxtion.learning.declarative.ext.music.util.PassThrough;

/**
 * generated group by holder.
 *
 * target class : TrackPlaySummary
 *
 * @author Greg Higgins
 */
public final class GroupBy_6 implements GroupBy<TrackPlaySummary> {

    private TrackPlaySummary target;
    private GroupByTargetMap<TrackPlaySummary, CalculationStateGroupBy_6> calcState;
    private GroupByIniitialiser<TrackStream, TrackPlaySummary> initialisertrackStream0;
    private MultiKeyFromTrackStream_1 multiKeyFromTrackStream_12;

    @EventHandler
    public boolean updatetrackStream0(TrackStream event) {
        multiKeyFromTrackStream_12.setKey(event);
        CalculationStateGroupBy_6 instance = calcState.getOrCreateInstance(multiKeyFromTrackStream_12, initialisertrackStream0, event);
        target = instance.target;
        {
            double value = instance.aggregateSum4;
            value = AggregateSum.calcSum((double) event.getStreams(), (double) value);
            target.setTotalPlays((int) value);
            instance.aggregateSum4 = value;
        }
        {
            int value = instance.passThrough5;
            value = PassThrough.passThrough((int) event.getStreams(), (int) value);
            target.addDailyPlays((int) value);
            instance.passThrough5 = value;
        }
        return true;
    }

    @OnEvent
    public boolean updated() {
        return true;
    }

    @Initialise
    public void init() {
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_6.class);
        multiKeyFromTrackStream_12 = new MultiKeyFromTrackStream_1();
        initialisertrackStream0 = new GroupByIniitialiser<TrackStream, TrackPlaySummary>() {

            @Override
            public void apply(TrackStream source, TrackPlaySummary target) {
                target.setIsrc((java.lang.String) source.getIsrc());
                target.setDateString((java.lang.String) source.getDateString());
                target.setTrack_artists((java.lang.String) source.getTrack_artists());
                target.setTrackName((java.lang.String) source.getTrack_title());
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
