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
package com.fluxtion.learning.fx.example5;

import com.fluxtion.fx.BiasProcessor;
import com.fluxtion.fx.replay.CsvAuditReplay;
import com.fluxtion.runtime.event.Event;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Replays BiasProcessor audit events into a BiasProcessor using a chronicle 
 * queue as a source. Events are placed into the queue with a Chronicle Auditor.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ChronicleAuditReplay {

    /**
     * Replays a chronicle file into a BiasProcessor using a supplied class type
     * as meta-data to create the receiving BiasProcessor instance. 
     * 
     * @param <T> The BiasProcessor type
     * @param processorClass the target BiasProcessor class
     * @param replayFile File pointer to the chronicle queue.
     * @return
     */
    public <T extends BiasProcessor> T replay(Class<T> processorClass, File replayFile) {
        try {
            return replay(processorClass.newInstance(), replayFile);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(CsvAuditReplay.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("could not replay audit Log into BiasProcessor", ex.getCause());
        }
    }

    /**
     * Replays a chronicle file into a BiasProcessor.
     * 
     * @param <T> The BiasProcessor type
     * @param processor the BiasProcessor into which events are replayed
     * @param replayFile File pointer to the chronicle queue.
     * @return
     */
    public <T extends BiasProcessor> T replay(T processor, File replayFile) {
        /**
         * read chronicle file and for each event push to the supplied processor
         * the incoming types are: 
         * FxPrice
         * CustomerOrder
         * CustomerOrderReject
         * CustomerOrderAccept
         * TimingPulseEvent
         * 
         * It does not matter if unknown events are passed to the BiasProcessor
         * it will respond in idempotent fashion.
         */

        Event event = null;
        processor.onEvent(event);
        return processor;
    }
}
