package com.fluxtion.learning.declarative.ext.example3.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.learning.declarative.ext.example3.generated.GreaterThanDecorator_4;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.learning.declarative.ext.example3.FlightDelayProcessor.CarrierDelay;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.learning.declarative.ext.example3.FlightDelayProcessor.FlightDetails;

/**
 * generated group by calculation state holder. This class holds thr
 *
 * target class  : CarrierDelay
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_9 implements Wrapper<CarrierDelay>{
    public CarrierDelay target;
    public AggregateAverage aggregateAverage6Function = new AggregateAverage();
    public double aggregateAverage6;
    public int aggregateCount7;
    public double aggregateSum8;

    public CalculationStateGroupBy_9(){
         target = new CarrierDelay();
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
