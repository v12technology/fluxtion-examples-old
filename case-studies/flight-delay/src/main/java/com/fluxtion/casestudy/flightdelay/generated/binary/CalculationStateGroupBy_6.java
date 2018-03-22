package com.fluxtion.casestudy.flightdelay.generated.binary;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.casestudy.flightdelay.generated.binary.GreaterThanDecorator_1;
import com.fluxtion.casestudy.flightdelay.CarrierDelay;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateAverage;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
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
    public double aggregateSum5;
    public AggregateAverage aggregateAverage3Function = new AggregateAverage();
    public double aggregateAverage3;
    public int aggregateCount4;

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
