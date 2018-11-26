package com.fluxtion.casestudy.flightdelay.generated.csv;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import java.util.Map;
import java.util.BitSet;
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.casestudy.flightdelay.CarrierDelay;

/**
 * generated group by calculation state holder. This class holds the state of
 * a group by calculation.
 *
 * target class  : CarrierDelay
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_7 implements Wrapper<CarrierDelay>{

    private static final int SOURCE_COUNT = 1;
    private final BitSet updateMap = new BitSet(SOURCE_COUNT);

    public CarrierDelay target;
    public double aggregateSum6;
    public AggregateAverage aggregateAverage4Function = new AggregateAverage();
    public double aggregateAverage4;
    public int aggregateCount5;

    public CalculationStateGroupBy_7(){
        target = new CarrierDelay();
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
    public CarrierDelay event() {
        return target;
    }

    @Override
    public Class<CarrierDelay> eventClass() {
        return CarrierDelay.class;
    }

    @Override
    public String toString() {
        return event().toString();
    }

}
