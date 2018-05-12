package com.fluxtion.casestudy.flightdelay.generated.csv2;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.casestudy.flightdelay.CarrierDelay;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.casestudy.flightdelay.FlightDetails;

/**
 * generated group by calculation state holder. This class holds the state of
 * a group by calculation.
 *
 * target class  : CarrierDelay
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_7 implements Wrapper<CarrierDelay>{
    public CarrierDelay target;
    public int aggregateCount5;
    public double aggregateSum6;
    public AggregateAverage aggregateAverage4Function = new AggregateAverage();
    public double aggregateAverage4;

    public CalculationStateGroupBy_7(){
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

    @Override
    public String toString() {
        return event().toString();
    }

}
