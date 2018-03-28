package com.fluxtion.casestudy.flightdelay.generated.csv;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.casestudy.flightdelay.generated.csv.GreaterThanDecorator_4;
import com.fluxtion.casestudy.flightdelay.CarrierDelay;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.casestudy.flightdelay.FlightDetails;

/**
 * generated group by holder.
 *
 * target class  : CarrierDelay
 * 
 * @author Greg Higgins
 */
public final class GroupBy_9 implements GroupBy<CarrierDelay>{

    public GreaterThanDecorator_4 greaterThanDecorator_40;
    private CarrierDelay target;
    private GroupByTargetMap<CarrierDelay, CalculationStateGroupBy_9> calcState;
    private GroupByIniitialiser<FlightDetails, CarrierDelay> initialisergreaterThanDecorator_40;

    @OnParentUpdate( "greaterThanDecorator_40")
    public boolean updategreaterThanDecorator_40(GreaterThanDecorator_4 eventWrapped){
        FlightDetails event = eventWrapped.event();
        CalculationStateGroupBy_9 instance = calcState.getOrCreateInstance(event.getCarrier(), initialisergreaterThanDecorator_40, event);
        target = instance.target;
        {
			double value = instance.aggregateAverage6;
			value = instance.aggregateAverage6Function.calcAverage((double)event.getDelay(), (double)value);
			target.setAvgDelay((int)value);
			instance.aggregateAverage6 = value;
         }
        {
			int value = instance.aggregateCount7;
			value = AggregateCount.increment((int)event.getDelay(), (int)value);
			target.setTotalFlights((int)value);
			instance.aggregateCount7 = value;
         }
        {
			double value = instance.aggregateSum8;
			value = AggregateSum.calcSum((double)event.getDelay(), (double)value);
			target.setTotalDelayMins((int)value);
			instance.aggregateSum8 = value;
         }
        return true;
    }

    @OnEvent
    public boolean updated(){
        return true;
    }

    @Initialise
    public void init(){
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_9.class);
        initialisergreaterThanDecorator_40 = new GroupByIniitialiser<FlightDetails, CarrierDelay>(){
        
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
