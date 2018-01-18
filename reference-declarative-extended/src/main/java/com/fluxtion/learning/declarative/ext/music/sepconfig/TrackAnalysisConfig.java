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
package com.fluxtion.learning.declarative.ext.music.sepconfig;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import static com.fluxtion.extension.declarative.builder.group.Group.groupBy;
import com.fluxtion.extension.declarative.builder.group.GroupByBuilder;
import com.fluxtion.learning.declarative.ext.music.TrackPlaySummary;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.learning.declarative.ext.music.util.BollingerPublisher;
import com.fluxtion.learning.declarative.ext.music.util.PassThrough;

/**
 *
 * @author gregp
 */
public class TrackAnalysisConfig extends SEPConfig {

    @Override
    public void buildConfig() {
        //track by date
        GroupByBuilder<TrackStream, TrackPlaySummary> grpByTrack = groupBy(TrackStream.class, TrackPlaySummary.class, TrackStream::getIsrc);
        GroupBy<TrackPlaySummary> group = initGroup(grpByTrack, "trackByDate");
        BollingerPublisher publisher = new BollingerPublisher(group, "track");
        addPublicNode(publisher, "trackAnalyser");
        
        //track and territory
        GroupByBuilder<TrackStream, TrackPlaySummary> grpByTrackAndTerritory = groupBy(TrackStream.class, TrackPlaySummary.class, TrackStream::getIsrc, TrackStream::getTerritory);
        grpByTrackAndTerritory.init(TrackStream::getTerritory, TrackPlaySummary::setTerritory);
        GroupBy<TrackPlaySummary> groupTrackTerr = initGroup(grpByTrackAndTerritory, "trackAndTerritoryByDate");
        BollingerPublisher publisherTerritory = new BollingerPublisher(groupTrackTerr, "track_territory");
        publisherTerritory.territory = true;
        addPublicNode(publisherTerritory, "trackTerritoryAnalyser");
        
        //track and vendor
        GroupByBuilder<TrackStream, TrackPlaySummary> grpByTrackAndVendor = groupBy(TrackStream.class, TrackPlaySummary.class, TrackStream::getIsrc, TrackStream::getVendor_identifier);
        grpByTrackAndVendor.init(TrackStream::getVendor_identifier, TrackPlaySummary::setVendor_identifier);
        GroupBy<TrackPlaySummary> groupTrackVend = initGroup(grpByTrackAndVendor, "trackAndVendorByDate");
        BollingerPublisher publisherVendor= new BollingerPublisher(groupTrackVend, "track_vendor");
        publisherVendor.vendor = true;
        addPublicNode(publisherVendor, "trackVendorAnalyser");
        
        //track and vendor and territory
        GroupByBuilder<TrackStream, TrackPlaySummary> grpByTrackVendorTerr = groupBy(TrackStream.class, TrackPlaySummary.class, TrackStream::getIsrc, TrackStream::getVendor_identifier, TrackStream::getTerritory);
        grpByTrackVendorTerr.init(TrackStream::getVendor_identifier, TrackPlaySummary::setVendor_identifier);
        grpByTrackVendorTerr.init(TrackStream::getTerritory, TrackPlaySummary::setTerritory);
        GroupBy<TrackPlaySummary> groupTrackVendTerr = initGroup(grpByTrackVendorTerr, "trackAndVendorAndTerritoryByDate");
        BollingerPublisher publisherVendorTerr = new BollingerPublisher(groupTrackVendTerr, "track_vendor_territory");
        publisherVendorTerr.vendor = true;
        publisherVendorTerr.territory = true;
        addPublicNode(publisherVendorTerr, "trackVendorTerritoryAnalyser");
    }

    protected GroupBy<TrackPlaySummary> initGroup(GroupByBuilder<TrackStream, TrackPlaySummary> grpBy, String name) {
        //init some values
        grpBy.init(TrackStream::getIsrc, TrackPlaySummary::setIsrc);
        grpBy.init(TrackStream::getTrack_title, TrackPlaySummary::setTrackName);
        grpBy.init(TrackStream::getDateString, TrackPlaySummary::setDateString);
        grpBy.init(TrackStream::getTrack_artists, TrackPlaySummary::setTrack_artists);
        //summary statistics
        grpBy.sum(TrackStream::getStreams, TrackPlaySummary::setTotalPlays);
        grpBy.function(PassThrough.class, TrackStream::getStreams, TrackPlaySummary::addDailyPlays);
        //build
        GroupBy<TrackPlaySummary> build = grpBy.build();
        return addPublicNode(build, name);
    }

}
