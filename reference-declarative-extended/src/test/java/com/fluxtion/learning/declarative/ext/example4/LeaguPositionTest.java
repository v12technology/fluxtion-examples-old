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

import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.extension.declarative.funclib.builder.util.StringDriver;
import com.fluxtion.learning.declarative.ext.example4.generated.MatchResulProcessor;
import org.junit.Test;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class LeaguPositionTest {

    @Test
    public void testLeagueResults() {
        MatchResulProcessor matchProcessor = new MatchResulProcessor();
        String testString = "liverpool,2,3,everton\n"
                + "arsenal,1,3,everton\n"
                + "liverpool,6,1,tottenham\n"
                + "everton,0,9,west ham\n"
                + "wba,2,9,arsenal\n"
                + "wba,6,9,arsenal\n"
                + "Manchester United,2,1,Manchester city\n"
                + "Manchester United,4,6,arsenal\n"
                + "west ham,6,1,arsenal\n";

        StringDriver.streamChars(testString, matchProcessor, true);
        printLeague(matchProcessor.leagueSummary);
    }

    private static void printLeague(GroupBy<LeaguePosition> league) {
        league.getMap().values().stream().map(w -> w.event())
                .sorted((l1, l2) -> {
                    if ((l2.totalPoints() - l1.totalPoints()) != 0) {
                        return l2.totalPoints() - l1.totalPoints();
                    } else if ((l2.goalDifference() - l1.goalDifference()) != 0) {
                        return l2.goalDifference() - l1.goalDifference();
                    } else if ((l2.awayPoints() - l1.awayPoints()) != 0) {
                        return l2.awayPoints() - l1.awayPoints();
                    }
                    return 0;
                })
                .forEach(l -> System.out.println(l.toString()));
    }
}
