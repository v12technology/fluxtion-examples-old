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
package com.fluxtion.learning.declarative.ext.example5;

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.runtime.event.Event;
import com.fluxtion.runtime.lifecycle.EventHandler;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class DelegatingEventHandler implements EventHandler{

    public EventHandler delegate;

    public DelegatingEventHandler() {
    }

    public DelegatingEventHandler(EventHandler delegate) {
        this.delegate = delegate;
    }
    
    @Override
    @com.fluxtion.api.annotations.EventHandler
    public void onEvent(Event e) {
        delegate.onEvent(e);
    }

    @Override
    @AfterEvent
    public void afterEvent() {
        delegate.afterEvent();
    }

    @Override
    public Class eventClass() {
        return delegate.eventClass();
    }
    
    
    
}
