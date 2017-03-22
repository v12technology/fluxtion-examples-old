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
public class MatchResult {

    private int homeGoals;
    private int awayGoals;
    private String homeTeam;
    private String awayTeam;

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeWin() {
        return   getHomeGoals() > getAwayGoals() ? 1 : 0;
    }

    public int getHomeLoss() {
        return getAwayGoals() > getHomeGoals()  ? 1 : 0;
    }

    public int getAwayWin() {
        return getHomeLoss();
    }

    public int getAwayLoss() {
        return getHomeWin();
    }

    public int getDraw() {
        return getHomeGoals() == getAwayGoals() ? 1 : 0;
    }

    @Override
    public String toString() {
        return "MatchResult{" + "homeTeam=" + homeTeam  + ", homeGoals=" + homeGoals + ", awayTeam=" + awayTeam + ", awayGoals=" + awayGoals + '}';
    }

}
