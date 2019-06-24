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

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import java.util.ArrayList;

/**
 *
 * @author gregp
 */
public class TrackPublisher {
    
    private final Wrapper<TrackStream> trackSource;
    private ArrayList<EventHandler> sortedTracks;
    
    public TrackPublisher(Wrapper<TrackStream> trackSource) {
        this.trackSource = trackSource;
        sortedTracks = new ArrayList<>();
    }
    
    @OnEvent
    public void newTrackStream(){
        for (int i = 0; i < sortedTracks.size(); i++) {
            EventHandler get = sortedTracks.get(i);
            get.onEvent(trackSource.event());
        }
    }
    
    public void addEventHandler(EventHandler handler){
        if(handler instanceof Lifecycle){
            ((Lifecycle)handler).init();
        }
        sortedTracks.add(handler);
    }
    
}
