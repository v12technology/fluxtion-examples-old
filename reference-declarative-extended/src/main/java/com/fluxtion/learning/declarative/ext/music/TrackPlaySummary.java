/*
 * Copyright (C) 2018 greg
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
package com.fluxtion.learning.declarative.ext.music;

/**
 *
 * @author greg
 */
public class TrackPlaySummary {
    
    int totalPlays;
    int avgDailyPlays;
    String isrc;
    String trackName;

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }

    public int getAvgDailyPlays() {
        return avgDailyPlays;
    }

    public void setAvgDailyPlays(int avgDailyPlays) {
        this.avgDailyPlays = avgDailyPlays;
    }

    @Override
    public String toString() {
        return "TrackPlaySummary{" + "totalPlays=" + totalPlays + ", avgDailyPlays=" + avgDailyPlays + ", isrc=" + isrc + ", trackName=" + trackName + '}';
    }
    
}
