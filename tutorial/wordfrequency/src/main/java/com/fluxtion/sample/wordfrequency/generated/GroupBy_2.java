package com.fluxtion.sample.wordfrequency.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnEventComplete;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.extension.declarative.api.numeric.MutableInt;
import com.fluxtion.extension.declarative.funclib.api.ascii.ByteBufferDelimiter;

/**
 * generated group by holder.
 *
 * target class  : MutableInt
 * 
 * @author Greg Higgins
 */
public final class GroupBy_2 implements GroupBy<MutableInt>{

    public ByteBufferDelimiter byteBufferDelimiter0;
    private MutableInt target;
    private GroupByTargetMap<MutableInt, CalculationStateGroupBy_2> calcState;

    @OnParentUpdate( "byteBufferDelimiter0")
    public boolean updatebyteBufferDelimiter0(ByteBufferDelimiter event){
        CalculationStateGroupBy_2 instance = calcState.getOrCreateInstance(event.asString());
        boolean allMatched = instance.processSource( 1, event);
        target = instance.target;
        {
			int value = instance.aggregateCount1;
			value = AggregateCount.increment((int)0, (int)value);
			target.setValue((int)value);
			instance.aggregateCount1 = value;
         }
        return allMatched;
    }

    @Initialise
    public void init(){
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_2.class);
    }

    @Override
    public MutableInt value(Object key) {
        return calcState.getInstance(key).target;
    }

    @Override
    public <V extends Wrapper<MutableInt>> Map<?, V> getMap() {
        return (Map<?, V>) calcState.getInstanceMap();
    }

    @Override
    public MutableInt event() {
        return target;
    }

    @Override
    public Class<MutableInt> eventClass() {
        return MutableInt.class;
    }
}
