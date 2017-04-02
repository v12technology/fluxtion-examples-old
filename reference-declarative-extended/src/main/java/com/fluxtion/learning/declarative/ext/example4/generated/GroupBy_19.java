package com.fluxtion.learning.declarative.ext.example4.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.extension.declarative.api.group.GroupByIniitialiser;
import com.fluxtion.extension.declarative.api.group.GroupByTargetMap;
import java.util.Map;
import com.fluxtion.learning.declarative.ext.example4.LeaguePosition;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateCount;
import com.fluxtion.learning.declarative.ext.example4.MatchResult;
import com.fluxtion.learning.declarative.ext.example4.generated.MatchResultCsvMarshaller4;
import com.fluxtion.extension.declarative.api.group.AggregateFunctions.AggregateSum;

/**
 * generated group by holder.
 *
 * target class  : LeaguePosition
 * 
 * @author Greg Higgins
 */
public final class GroupBy_19 implements GroupBy<LeaguePosition>{

    public MatchResultCsvMarshaller4 matchResultCsvMarshaller40;
    public MatchResultCsvMarshaller4 matchResultCsvMarshaller41;
    private LeaguePosition target;
    private GroupByTargetMap<LeaguePosition, CalculationStateGroupBy_19> calcState;
    private GroupByIniitialiser<MatchResult, LeaguePosition> initialisermatchResultCsvMarshaller40;
    private GroupByIniitialiser<MatchResult, LeaguePosition> initialisermatchResultCsvMarshaller41;

    @OnParentUpdate( "matchResultCsvMarshaller40")
    public boolean updatematchResultCsvMarshaller40(MatchResultCsvMarshaller4 eventWrapped){
        MatchResult event = eventWrapped.event();
        CalculationStateGroupBy_19 instance = calcState.getOrCreateInstance(event.getHomeTeam(), initialisermatchResultCsvMarshaller40, event);
        target = instance.target;
        {
			double value = instance.aggregateSum17;
			value = AggregateSum.calcSum((double)event.getDraw(), (double)value);
			target.setHomeDraws((int)value);
			instance.aggregateSum17 = value;
         }
        {
			double value = instance.aggregateSum18;
			value = AggregateSum.calcSum((double)event.getAwayGoals(), (double)value);
			target.setHomeGoalsAgainst((int)value);
			instance.aggregateSum18 = value;
         }
        {
			int value = instance.aggregateCount13;
			value = AggregateCount.increment((int)event.getHomeGoals(), (int)value);
			target.setHomeGamesPlayed((int)value);
			instance.aggregateCount13 = value;
         }
        {
			double value = instance.aggregateSum14;
			value = AggregateSum.calcSum((double)event.getHomeGoals(), (double)value);
			target.setHomeGoalsFor((int)value);
			instance.aggregateSum14 = value;
         }
        {
			double value = instance.aggregateSum15;
			value = AggregateSum.calcSum((double)event.getHomeWin(), (double)value);
			target.setHomeWins((int)value);
			instance.aggregateSum15 = value;
         }
        {
			double value = instance.aggregateSum16;
			value = AggregateSum.calcSum((double)event.getHomeLoss(), (double)value);
			target.setHomeLosses((int)value);
			instance.aggregateSum16 = value;
         }
        return true;
    }

    @OnParentUpdate( "matchResultCsvMarshaller41")
    public boolean updatematchResultCsvMarshaller41(MatchResultCsvMarshaller4 eventWrapped){
        MatchResult event = eventWrapped.event();
        CalculationStateGroupBy_19 instance = calcState.getOrCreateInstance(event.getAwayTeam(), initialisermatchResultCsvMarshaller41, event);
        target = instance.target;
        {
			double value = instance.aggregateSum11;
			value = AggregateSum.calcSum((double)event.getAwayLoss(), (double)value);
			target.setAwayLosses((int)value);
			instance.aggregateSum11 = value;
         }
        {
			double value = instance.aggregateSum12;
			value = AggregateSum.calcSum((double)event.getDraw(), (double)value);
			target.setAwayDraws((int)value);
			instance.aggregateSum12 = value;
         }
        {
			int value = instance.aggregateCount7;
			value = AggregateCount.increment((int)event.getHomeGoals(), (int)value);
			target.setAwayGamesPlayed((int)value);
			instance.aggregateCount7 = value;
         }
        {
			double value = instance.aggregateSum8;
			value = AggregateSum.calcSum((double)event.getAwayGoals(), (double)value);
			target.setAwayGoalsFor((int)value);
			instance.aggregateSum8 = value;
         }
        {
			double value = instance.aggregateSum9;
			value = AggregateSum.calcSum((double)event.getHomeGoals(), (double)value);
			target.setAwayGoalsAgainst((int)value);
			instance.aggregateSum9 = value;
         }
        {
			double value = instance.aggregateSum10;
			value = AggregateSum.calcSum((double)event.getAwayWin(), (double)value);
			target.setAwayWins((int)value);
			instance.aggregateSum10 = value;
         }
        return true;
    }

    @OnEvent
    public boolean updated(){
        return true;
    }

    @Initialise
    public void init(){
        calcState = new GroupByTargetMap<>(CalculationStateGroupBy_19.class);
        initialisermatchResultCsvMarshaller40 = new GroupByIniitialiser<MatchResult, LeaguePosition>(){
        
            @Override
            public void apply(MatchResult source, LeaguePosition target) {
                target.setTeamName((java.lang.String)source.getHomeTeam());
            }

        };
        initialisermatchResultCsvMarshaller41 = new GroupByIniitialiser<MatchResult, LeaguePosition>(){
        
            @Override
            public void apply(MatchResult source, LeaguePosition target) {
                target.setTeamName((java.lang.String)source.getAwayTeam());
            }

        };
    }

    @Override
    public LeaguePosition value(Object key) {
        return calcState.getInstance(key).target;
    }

    @Override
    public <V extends Wrapper<LeaguePosition>> Map<?, V> getMap() {
        return (Map<?, V>) calcState.getInstanceMap();
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
