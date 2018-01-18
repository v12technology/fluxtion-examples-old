/*
 * Copyright (C) 2018 gregp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License; or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful;
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not; see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.declarative.ext.music;

import com.fluxtion.runtime.event.Event;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author gregp
 */
public class TrackStream extends Event {

//    columns 
//    0:date 
//    1:isrc
//    2:track_artists
//    3:track_title 
//    4:territory 
//    5:vendor_identifier
//    6: streams
    Date date;
    String dateString;
    String isrc;
    String track_artists;
    String track_title;
    String territory;
    String vendor_identifier;
    int streams;
    private static HashMap<String, Date> dateCache = new HashMap<>();
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
//                Logger.getLogger(TrackPlaySummary.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        });
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
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

    public int getStreams() {
        return streams;
    }

    public void setStreams(int streams) {
        this.streams = streams;
    }

    @Override
    public String toString() {
        return "TrackStream{" + "date=" + date + ", dateString=" + dateString + ", isrc=" + isrc + ", track_artists=" + track_artists + ", track_title=" + track_title + ", territory=" + territory + ", vendor_identifier=" + vendor_identifier + ", streams=" + streams + '}';
    }

    public TrackStream copy() {
        TrackStream clone = new TrackStream();
        clone.date = date;
        clone.dateString = dateString;
        clone.isrc = isrc;
        clone.track_artists = track_artists;
        clone.track_title = track_title;
        clone.territory = territory;
        clone.vendor_identifier = vendor_identifier;
        clone.streams = streams;
        return clone;
    }

}
