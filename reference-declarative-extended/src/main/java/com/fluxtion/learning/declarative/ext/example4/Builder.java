/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.declarative.ext.example4;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import static com.fluxtion.extension.declarative.builder.group.Group.groupBy;
import com.fluxtion.extension.declarative.builder.group.GroupByBuilder;
import static com.fluxtion.extension.declarative.funclib.builder.csv.CsvMarshallerBuilder.csvMarshaller;

/**
 * Calculate the league statistics for a set of teams, including:
 * <ul>
 * <li>eamName;
 * <li>homeGamesPlayed;
 * <li>homeWins;
 * <li>homeLosses;
 * <li>homeDraws;
 * <li>homeGoalsFor;
 * <li>homeGoalsAgainst;
 * <li>awayGamesPlayed;
 * <li>awayWins;
 * <li>awayLosses;
 * <li>awayDraws;
 * <li>awayGoalsFor;
 * <li>awayGoalsAgainst;
 * </ul>
 *
 *  The league is maintained by a matchday processor procesing a result presented as a CSV record.
 * 
 * The example demonstrates the use of joins, csv parsing, aggregate functions, initialising a group record and
 * public nodes.
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class Builder extends SEPConfig {

    public Builder() {

        //add csv parser
        Wrapper<MatchResult> matchResult = csvMarshaller(MatchResult.class, 1)
                .mapString(0, MatchResult::setHomeTeam).map(1, MatchResult::setHomeGoals)
                .mapString(3, MatchResult::setAwayTeam).map(2, MatchResult::setAwayGoals)
                .build();
        //groupby team name, self-referntial join on team name, for hone and away team
        GroupByBuilder<MatchResult, LeaguePosition> home = groupBy(matchResult, MatchResult::getHomeTeam, LeaguePosition.class);
        GroupByBuilder<MatchResult, LeaguePosition> away = home.join(matchResult, MatchResult::getAwayTeam);
        //init a grouped record with human readable name
        home.init(MatchResult::getHomeTeam, LeaguePosition::setTeamName);
        away.init(MatchResult::getAwayTeam, LeaguePosition::setTeamName);
        //calculate aggregate values for away games
        away.count(MatchResult::getHomeGoals, LeaguePosition::setAwayGamesPlayed);
        away.sum(MatchResult::getAwayGoals, LeaguePosition::setAwayGoalsFor);
        away.sum(MatchResult::getHomeGoals, LeaguePosition::setAwayGoalsAgainst);
        away.sum(MatchResult::getAwayWin, LeaguePosition::setAwayWins);
        away.sum(MatchResult::getAwayLoss, LeaguePosition::setAwayLosses);
        away.sum(MatchResult::getDraw, LeaguePosition::setAwayDraws);
        //calculate aggregate values for home games
        home.count(MatchResult::getHomeGoals, LeaguePosition::setHomeGamesPlayed);
        home.sum(MatchResult::getHomeGoals, LeaguePosition::setHomeGoalsFor);
        home.sum(MatchResult::getHomeWin, LeaguePosition::setHomeWins);
        home.sum(MatchResult::getHomeLoss, LeaguePosition::setHomeLosses);
        home.sum(MatchResult::getDraw, LeaguePosition::setHomeDraws);
        home.sum(MatchResult::getAwayGoals, LeaguePosition::setHomeGoalsAgainst);
        //
        GroupBy<LeaguePosition> league = home.build();
        addPublicNode(league, "leagueSummary");
    }

}
