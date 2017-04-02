package com.fluxtion.learning.declarative.ext.example2.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.FlightDetails;
import com.fluxtion.learning.declarative.ext.example2.generated.GreaterThanDecorator_1;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.CarrierDelay;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;

/**
 * generated group by calculation state holder. This class holds thr
 *
 * target class  : CarrierDelay
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_6 implements Wrapper<CarrierDelay>{
    public CarrierDelay target;
    public AggregateAverage aggregateAverage3Function = new AggregateAverage();
    public double aggregateAverage3;
    public int aggregateCount4;
    public double aggregateSum5;

    public CalculationStateGroupBy_6(){
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
