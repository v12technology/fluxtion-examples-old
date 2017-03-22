package com.fluxtion.learning.declarative.ext.example2.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.learning.declarative.ext.example2.generated.GreaterThanDecorator_1;
import com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.CarrierDelay;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.FlightDetails;

/**
 * generated group by holder.
 *
 * target class  : CarrierDelay
 * 
 * @author Greg Higgins
 */
public final class GroupBy_6 implements GroupBy<CarrierDelay>{

    public GreaterThanDecorator_1 greaterThanDecorator_10;
    private CarrierDelay target;
    private GroupByTargetMap<CarrierDelay, CalculationStateGroupBy_6> calcState;
    private GroupByIniitialiser<FlightDetails, CarrierDelay> initialisergreaterThanDecorator_10;

    @OnParentUpdate( "greaterThanDecorator_10")
    public boolean updategreaterThanDecorator_10(GreaterThanDecorator_1 eventWrapped){
        FlightDetails event = eventWrapped.event();
        CalculationStateGroupBy_6 instance = calcState.getOrCreateInstance(event.getCarrier(), initialisergreaterThanDecorator_10, event);
        target = instance.target;
        {
			double value = instance.aggregateAverage3;
			value = instance.aggregateAverage3Function.calcAverage((double)event.getDelay(), (double)value);
			target.setAvgDelay((int)value);
			instance.aggregateAverage3 = value;
         }
        {
			int value = instance.aggregateCount4;
			value = AggregateCount.increment((int)event.getDelay(), (int)value);
			target.setTotalFlights((int)value);
			instance.aggregateCount4 = value;
         }
        {
			double value = instance.aggregateSum5;
			value = AggregateSum.calcSum((double)event.getDelay(), (double)value);
			target.setTotalDelayMins((int)value);
			instance.aggregateSum5 = value;
         }
        return true;
    }

    @OnEvent
    public boolean updated(){
        return true;
    }

    @Initialise
    public void init(){
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_6.class);
        initialisergreaterThanDecorator_10 = new GroupByIniitialiser<FlightDetails, CarrierDelay>(){
        
            @Override
            public void apply(FlightDetails source, CarrierDelay target) {
                target.setCarrierId((java.lang.String)source.getCarrier());
            }

        };
    }

    @Override
    public CarrierDelay value(Object key) {
        return calcState.getInstance(key).target;
    }

    @Override
    public <V extends Wrapper<CarrierDelay>> Map<?, V> getMap() {
        return (Map<?, V>) calcState.getInstanceMap();
    }

    @Override
    public CarrierDelay event() {
        return target;
    }

    @Override
    public Class<CarrierDelay> eventClass() {
        return CarrierDelay.class;
    }
}
