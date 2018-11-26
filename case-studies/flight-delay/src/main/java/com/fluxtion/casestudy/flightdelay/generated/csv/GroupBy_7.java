package com.fluxtion.casestudy.flightdelay.generated.csv;

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
import com.fluxtion.casestudy.flightdelay.CarrierDelay;
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;

/**
 * generated group by holder.
 *
 * target class  : CarrierDelay
 * 
 * @author Greg Higgins
 */
public final class GroupBy_7 implements GroupBy<CarrierDelay>{

    public GreaterThanDecorator_2 greaterThanDecorator_20;
    private CarrierDelay target;
    private GroupByTargetMap<CarrierDelay, CalculationStateGroupBy_7> calcState;
    private GroupByIniitialiser<FlightDetails, CarrierDelay> initialisergreaterThanDecorator_20;

    @OnParentUpdate( "greaterThanDecorator_20")
    public boolean updategreaterThanDecorator_20(GreaterThanDecorator_2 eventWrapped){
        FlightDetails event = eventWrapped.event();
        CalculationStateGroupBy_7 instance = calcState.getOrCreateInstance(event.getCarrier());
        boolean allMatched = instance.processSource( 1, initialisergreaterThanDecorator_20,  event);
        target = instance.target;
        {
			double value = instance.aggregateAverage4;
			value = instance.aggregateAverage4Function.calcAverage((double)event.getDelay(), (double)value);
			target.setAvgDelay((int)value);
			instance.aggregateAverage4 = value;
         }
        {
			double value = instance.aggregateSum6;
			value = AggregateSum.calcSum((double)event.getDelay(), (double)value);
			target.setTotalDelayMins((int)value);
			instance.aggregateSum6 = value;
         }
        {
			int value = instance.aggregateCount5;
			value = AggregateCount.increment((int)0, (int)value);
			target.setTotalFlights((int)value);
			instance.aggregateCount5 = value;
         }
        return allMatched;
    }

    @Initialise
    public void init(){
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_7.class);
        initialisergreaterThanDecorator_20 = new GroupByIniitialiser<FlightDetails, CarrierDelay>() {
        
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
