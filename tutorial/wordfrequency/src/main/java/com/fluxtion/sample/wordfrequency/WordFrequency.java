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
package com.fluxtion.sample.wordfrequency;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.group.GroupBy;
import com.fluxtion.extension.declarative.api.numeric.MutableInt;
import static com.fluxtion.extension.declarative.builder.event.EventSelect.select;
import com.fluxtion.extension.declarative.builder.log.LogBuilder;
import com.fluxtion.extension.declarative.funclib.api.event.EofEvent;
import static com.fluxtion.extension.declarative.funclib.builder.ascii.AsciiHelper.wordSplitter;
import static com.fluxtion.extension.declarative.funclib.builder.math.Frequency.frequency;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import com.fluxtion.sample.wordfrequency.generated.WordFrequencyProcessor;
import java.io.File;

/**
 * Sample program to generate a word frequency calculation from a file.
 *
 * @author greg
 */
public class WordFrequency {

    public static void main(String[] args) throws Exception {
        streamFromFile(new File(args[0]), WordFrequencyProcessor.class);
    }

    /**
     * Definition of the processing logic to generate a Static Event Processor.
     *
     */
    public static class Builder extends SEPConfig {

        @Override
        public void buildConfig() {
            GroupBy<MutableInt> frequency = addPublicNode(frequency(wordSplitter()), "frequency");
            //logging - not required for calcualtion - automatic print at eof
            LogBuilder.LogOnNotify("frequency map: {}",
                    select(EofEvent.class),
                    frequency,
                    frequency::getMap);
        }

    }

}
