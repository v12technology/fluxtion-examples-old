package com.fluxtion.sample.wordfrequency.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import java.util.Map;
import java.util.BitSet;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.extension.declarative.api.numeric.MutableInt;
import com.fluxtion.extension.declarative.funclib.api.ascii.ByteBufferDelimiter;

/**
 * generated group by calculation state holder. This class holds the state of
 * a group by calculation.
 *
 * target class  : MutableInt
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_2 implements Wrapper<MutableInt>{

    private static final int SOURCE_COUNT = 1;
    private final BitSet updateMap = new BitSet(SOURCE_COUNT);

    public MutableInt target;
    public int aggregateCount1;

    public CalculationStateGroupBy_2(){
        target = new MutableInt();
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
    public MutableInt event() {
        return target;
    }

    @Override
    public Class<MutableInt> eventClass() {
        return MutableInt.class;
    }

    @Override
    public String toString() {
        return event().toString();
    }

}
