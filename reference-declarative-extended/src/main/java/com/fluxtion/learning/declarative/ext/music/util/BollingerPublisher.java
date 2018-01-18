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
package com.fluxtion.learning.declarative.ext.music.util;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.learning.declarative.ext.music.TrackPlaySummary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author gregp
 */
public class BollingerPublisher {

    private final GroupBy<TrackPlaySummary> tracks;
    private final String name;
    private final Logger LOG_INDICATOR = LogManager.getLogger("indicators");
    private final Logger LOG_NOTIFICATION = LogManager.getLogger("notifications");
    public boolean territory = false;
    public boolean vendor = false;

    public BollingerPublisher(GroupBy<TrackPlaySummary> tracks, String name) {
        this.tracks = tracks;
        this.name = name;
    }

    @EventHandler
    public void eod(EodEvent eod) {
        tracks.getMap().values().forEach(w -> {
            TrackPlaySummary summary = w.event();
            summary.calculateDailyBollinger();
            logIndicators(LOG_INDICATOR, summary, eod);
            if (summary.getBollingerPercentB() > 1.15) {
                logNotification(LOG_NOTIFICATION, summary, eod);
            }
        });
    }

    private void logIndicators(Logger logger, TrackPlaySummary summary, EodEvent eod) {
        logger.info("{\"analysis\":\"{}\", \"date\":\"{}\""
                + ", \"isrc\":\"{}\""
                + ", \"percentB\":\"{}\""
                + ", \"bollinger\":\"{}\""
                + ", \"bollingerLower\":\"{}\""
                + ", \"bollingerUpper\":\"{}\""
                + ", \"territory\":\"{}\""
                + "}",
                name,
                eod.dateString,
                summary.getIsrc(),
                summary.getBollingerPercentB(),
                summary.getBollingerMean(),
                summary.getBollingerLower(),
                summary.getBollingerUpper(),
                territory ? summary.getTerritory() : "ALL"
        );
    }
    private void logNotification(Logger logger, TrackPlaySummary summary, EodEvent eod) {
        logger.info("{\"analysis\":\"{}\", \"date\":\"{}\""
                + ", \"isrc\":\"{}\""
                + ", \"track\":\"{}\""
                + ", \"artist\":\"{}\""
                + ", \"percentB\":\"{}\""
                + ", \"territory\":\"{}\""
                + ", \"vendor\":\"{}\""
                + "}",
                name,
                eod.dateString,
                summary.getIsrc(),
                summary.getTrackName(),
                summary.getTrack_artists(),
                summary.getBollingerPercentB(),
                territory ? summary.getTerritory() : "ALL",
                vendor ? summary.getVendor_identifier(): "ALL"
        );
    }
}
