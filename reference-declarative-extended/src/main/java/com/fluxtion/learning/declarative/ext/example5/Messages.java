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

import com.fluxtion.runtime.event.Event;
import java.io.File;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class Messages {

    /**
     * End of file message
     */
    public static class EOF extends Event {
    }

    /**
     * Configuration message for output directory
     */
    public static class OutputConifg extends Event {
        public final File outputDir;

        public OutputConifg(File outputDir) {
            this.outputDir = outputDir;
        }

    }

    /**
     * Configuration to turn output notifications on or off. Filtered with String, allows an notifier only to listen to its
     * messages.
     * 
     */
    public static class NotificationConifg extends Event {

        public final boolean notify;
        
        public NotificationConifg(String filter, boolean notify){
            super.filterString = filter;
            this.notify = notify;
        }
        
    }
}
