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

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class LeaguePosition {

    public static final int WIN_POINTS = 3;
    public static final int DRAW_POINTS = 1;

    private String teamName;
    private int homeGamesPlayed;
    private int homeWins;
    private int homeLosses;
    private int homeDraws;
    private int homeGoalsFor;
    private int homeGoalsAgainst;
    private int awayGamesPlayed;
    private int awayWins;
    private int awayLosses;
    private int awayDraws;
    private int awayGoalsFor;
    private int awayGoalsAgainst;

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setHomeGoalsFor(int homeGoalsFor) {
        this.homeGoalsFor = homeGoalsFor;
    }

    public void setHomeGoalsAgainst(int homeGoalsAgainst) {
        this.homeGoalsAgainst = homeGoalsAgainst;
    }

    public void setAwayGoalsFor(int awayGoalsFor) {
        this.awayGoalsFor = awayGoalsFor;
    }

    public void setAwayGoalsAgainst(int awayGoalsAgainst) {
        this.awayGoalsAgainst = awayGoalsAgainst;
    }

    public void setHomeGamesPlayed(int homeGamesPlayed) {
        this.homeGamesPlayed = homeGamesPlayed;
    }

    public void setAwayGamesPlayed(int awayGamesPlayed) {
        this.awayGamesPlayed = awayGamesPlayed;
    }

    public void setHomeWins(int homeWins) {
        this.homeWins = homeWins;
    }

    public void setHomeLosses(int homeLosses) {
        this.homeLosses = homeLosses;
    }

    public void setHomeDraws(int homeDraws) {
        this.homeDraws = homeDraws;
    }

    public void setAwayWins(int awayWins) {
        this.awayWins = awayWins;
    }

    public void setAwayLosses(int awayLosses) {
        this.awayLosses = awayLosses;
    }

    public void setAwayDraws(int awayDraws) {
        this.awayDraws = awayDraws;
    }

    //Derived properties
    public int goalDifference() {
        return homeGoalsFor + awayGoalsFor - homeGoalsAgainst - awayGoalsAgainst;
    }

    public int gamesPlayed() {
        return (homeGamesPlayed + awayGamesPlayed);
    }

    public int homePoints() {
        return WIN_POINTS * homeWins + DRAW_POINTS * homeDraws;
    }

    public int awayPoints() {
        return WIN_POINTS * awayWins + DRAW_POINTS * awayDraws;
    }

    public int totalPoints() {
        return homePoints() + awayPoints();
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return "LeaguePosition{"
                + "teamName=" + teamName
                + ", totalPoints=" + totalPoints()
                + ", gamesPlayed=" + gamesPlayed()
                + ", goalDifference=" + goalDifference()
                + ", homeGamesPlayed=" + homeGamesPlayed
                + ", homeWins=" + homeWins
                + ", homeLosses=" + homeLosses
                + ", homeDraws=" + homeDraws
                + ", homeGoalsFor=" + homeGoalsFor
                + ", homeGoalsAgainst=" + homeGoalsAgainst
                + ", homePoints=" + homePoints()
                + ", awayGamesPlayed=" + awayGamesPlayed
                + ", awayWins=" + awayWins
                + ", awayLosses=" + awayLosses
                + ", awayDraws=" + awayDraws
                + ", awayGoalsFor=" + awayGoalsFor
                + ", awayGoalsAgainst=" + awayGoalsAgainst
                + ", awayPoints=" + awayPoints()
                + '}';
    }

}
