package com.fluxtion.learning.declarative.ext.music.indicators;

import com.fluxtion.learning.declarative.ext.music.indicators.*;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import java.util.Map;
import java.util.BitSet;
import com.fluxtion.learning.declarative.ext.music.TrackPlaySummary;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.learning.declarative.ext.music.util.PassThrough;

/**
 * generated group by calculation state holder. This class holds the state of
 * a group by calculation.
 *
 * target class  : TrackPlaySummary
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_14 implements Wrapper<TrackPlaySummary>{

    private static final int SOURCE_COUNT = 1;
    private final BitSet updateMap = new BitSet(SOURCE_COUNT);

    public TrackPlaySummary target;
    public int passThrough13;
    public double aggregateSum12;

    public CalculationStateGroupBy_14(){
        target = new TrackPlaySummary();
    }

    public boolean allMatched(){
        return SOURCE_COUNT == updateMap.cardinality();
    }

    public boolean processSource(int index, GroupByIniitialiser initialiser, Object source) {
        if (!updateMap.get(index)) {
            initialiser.apply(source, target);
        }
        updateMap.set(index);
        return allMatched();
    }

    public boolean processSource(int index, Object source) {
        updateMap.set(index);
        return allMatched();
    }

    @Override
    public TrackPlaySummary event() {
        return target;
    }

    @Override
    public Class<TrackPlaySummary> eventClass() {
        return TrackPlaySummary.class;
    }

    @Override
    public String toString() {
        return event().toString();
    }

}
