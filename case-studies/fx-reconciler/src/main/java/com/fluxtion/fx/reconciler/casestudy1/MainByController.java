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
package com.fluxtion.fx.reconciler.casestudy1;

import com.fluxtion.fx.reconciler.input.ChronicleQueueSource.ChronicleQueueSourceBuilder;
import com.fluxtion.fx.reconciler.casestudy1.generated.ReconcilerCaseStudy1;
import com.fluxtion.fx.reconciler.input.ChronicleQueueSource;
import com.fluxtion.fx.reconciler.webapp.SparkInitialiserFromController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class MainByController {

    
    public static void main(String[] args) throws InterruptedException {
        ChronicleQueueSource queue = new ChronicleQueueSourceBuilder()
                .eventHandler(new ReconcilerCaseStudy1())
                .batchReadDelay(250)
                .chronicleFile(QUEUE_PATH)
                .build();
        queue.run();
        SparkInitialiserFromController spark = new SparkInitialiserFromController(queue);
        spark.init();
    }

    public static final String QUEUE_PATH = "private/chroncile/messageQueue";

}
