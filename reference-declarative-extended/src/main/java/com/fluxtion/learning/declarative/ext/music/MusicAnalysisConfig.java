/*
 * Copyright (C) 2018 gregp
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

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import static com.fluxtion.extension.declarative.builder.group.Group.groupBy;
import com.fluxtion.extension.declarative.builder.group.GroupByBuilder;
import com.fluxtion.extension.declarative.builder.log.LogBuilder;
import static com.fluxtion.extension.declarative.funclib.builder.csv.CsvMarshallerBuilder.csvMarshaller;

/**
 *
 * @author gregp
 */
public class MusicAnalysisConfig extends SEPConfig {

//    columns 
//    0:date 
//    1:isrc
//    2:track_artists
//    3:track_title 
//    4:territory 
//    5:vendor_identifier
//    6:streams

    @Override

    public void buildConfig() {
        //map csv
        Wrapper<TrackStream> track = csvMarshaller(TrackStream.class)
                .mapString(0, TrackStream::setDateString)
                .mapString(1, TrackStream::setIsrc)
                .mapString(2, TrackStream::setTrack_artists)
                .mapString(3, TrackStream::setTrack_title)
                .mapString(4, TrackStream::setTerritory)
                .mapString(5, TrackStream::setVendor_identifier)
                .map(6, TrackStream::setStreams)
                .build();
        //group by isrc
        GroupByBuilder<TrackStream, TrackPlaySummary> summary = groupBy(track, TrackStream::getIsrc, TrackPlaySummary.class);
        //init some values
        summary.init(TrackStream::getIsrc, TrackPlaySummary::setIsrc);
        summary.init(TrackStream::getTrack_title, TrackPlaySummary::setTrackName);
        //summary statistics
        summary.avg(TrackStream::getStreams, TrackPlaySummary::setAvgDailyPlays);
        summary.count(TrackStream::getStreams, TrackPlaySummary::setTotalPlays);
        GroupBy<TrackPlaySummary> build = summary.build();
        //log
        LogBuilder.Log("processing track:{}", track, TrackStream::getTrack_title);
        LogBuilder.Log("summary:", build, build::event);
    }

}
