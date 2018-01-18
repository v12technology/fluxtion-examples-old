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

import com.fluxtion.learning.declarative.ext.music.util.PercentBollinger;
import com.fluxtion.runtime.event.Event;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author greg
 */
public class TrackPlaySummary extends Event {

    private static HashMap<String, Date> dateCache = new HashMap<>();
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String trackName;
    String isrc;
    String dateString;
    String track_artists;
    Date date;
    String track_title;
    String territory;
    String vendor_identifier;
    //derived
    int totalPlays;
    int avgDailyPlays;
    int daysPlayed;
    double percentBollinger;
    int totalDayPlays;
    private PercentBollinger bollinger = new PercentBollinger();
    private int prevDayPlays;

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

    public double getPercentBollinger() {
        return percentBollinger;
    }

    public void setPercentBollinger(double percentBollinger) {
        this.percentBollinger = percentBollinger;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
        date = dateCache.computeIfAbsent(dateString, s -> {
            try {
                return df.parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(TrackPlaySummary.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        });
    }

    public Date getDate() {
        return date;
    }

    public String getTrack_artists() {
        return track_artists;
    }

    public void setTrack_artists(String track_artists) {
        this.track_artists = track_artists;
    }

    public String getTrack_title() {
        return track_title;
    }

    public void setTrack_title(String track_title) {
        this.track_title = track_title;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getVendor_identifier() {
        return vendor_identifier;
    }

    public void setVendor_identifier(String vendor_identifier) {
        this.vendor_identifier = vendor_identifier;
    }

    public void addDailyPlays(int playcount) {
        totalDayPlays += playcount;
    }

    public void calculateDailyBollinger() {
        daysPlayed++;
        prevDayPlays = totalDayPlays;
        setAvgDailyPlays(totalPlays / daysPlayed);
        bollinger.calcAverage(totalDayPlays, totalDayPlays);
        totalDayPlays = 0;
    }

    public double getBollingerLower() {
        return bollinger.getLower();
    }

    public double getBollingerMean() {
        return bollinger.getMean();
    }

    public double getBollingerUpper() {
        return bollinger.getUpper();
    }

    public double getBollingerPercentB() {
        return bollinger.getPercentB();
    }

    @Override
    public String toString() {
        return "TrackPlaySummary{" + "trackName=" + trackName
                + ", isrc=" + isrc
                + ", dateString=" + dateString
                + ", track_artists=" + track_artists 
                + ", track_title=" + track_title 
                + ", territory=" + territory 
                + ", vendor_identifier=" + vendor_identifier 
                + ", totalPlays=" + totalPlays 
                + ", avgDailyPlays=" + avgDailyPlays 
                + ", prevDayPlays=" + prevDayPlays 
                + ", getBollingerPercentB=" + getBollingerPercentB() 
                + '}';
    }

}
