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

import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * receives tracks and orders by date before publishing
 *
 * @author gregp
 */
public class OrderedPublisher implements EventHandler<TrackStream> {

    private EventHandler handler = EventHandler.NULL_EVENTHANDLER;
    private boolean sorted = false;
    private List<TrackStream> tracks = new ArrayList<>();
    private final EodEvent eod = new EodEvent();

    @Override
    public void onEvent(TrackStream e) {
        tracks.add(e.copy());
    }

    public void publish() {
        Collections.sort(tracks, (TrackStream o1, TrackStream o2) -> {
            return o1.getDate().compareTo(o2.getDate());
        });
        if (handler instanceof Lifecycle) {
            ((Lifecycle) handler).init();
        }
        String date = tracks.get(0).getDateString();
        String newDate = date;
        for (int i = 0; i < tracks.size(); i++) {
            final TrackStream track = tracks.get(i);
            newDate = track.getDateString();
            if(!newDate.equals(date)){
                eod.dateString = date;
                handler.onEvent(eod);
                date = newDate;
            }
            handler.onEvent(track);
        }
    }

    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }

}
