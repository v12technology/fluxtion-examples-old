/*
 * Copyright (C) 2018 greg
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

import java.io.File;
import java.io.IOException;
import org.junit.Test;

/**
 *
 *
 * @author greg
 */
public class MusicAnalysisComplexTest {

    @Test
    public void sample() throws IOException {
        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        TrackStreamAnalyser analyser = new TrackStreamAnalyser();
        analyser.run(new File("src/test/resources/music/sp009_sample_ai_data.csv"));
//        analyser.run(new File("src/test/resources/music/small_data.csv"));
    }
}
