package com.fluxtion.learning.declarative.ext.example4.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;
import com.fluxtion.learning.declarative.ext.example4.MatchResult;
import com.fluxtion.learning.declarative.ext.example4.generated.MatchResultCsvMarshaller4;
import com.fluxtion.learning.declarative.ext.example4.LeaguePosition;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;

/**
 * generated group by calculation state holder. This class holds thr
 *
 * target class  : LeaguePosition
 * 
 * @author Greg Higgins
 */
public final class CalculationStateGroupBy_19 implements Wrapper<LeaguePosition>{
    public LeaguePosition target;
    public int aggregateCount13;
    public double aggregateSum14;
    public double aggregateSum11;
    public double aggregateSum12;
    public double aggregateSum15;
    public double aggregateSum16;
    public double aggregateSum17;
    public double aggregateSum18;
    public int aggregateCount7;
    public double aggregateSum8;
    public double aggregateSum9;
    public double aggregateSum10;

    public CalculationStateGroupBy_19(){
         target = new LeaguePosition();
    }

    @Override
    public LeaguePosition event() {
        return target;
    }

    @Override
    public Class<LeaguePosition> eventClass() {
        return LeaguePosition.class;
    }

}
