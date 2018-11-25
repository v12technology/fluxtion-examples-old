package com.fluxtion.sample.wordfrequency.generated;

import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.api.numeric.MutableInt;
import static com.fluxtion.extension.declarative.funclib.builder.util.AsciiCharEventFileStreamer.streamFromFile;
import java.io.File;
import java.util.Comparator;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

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
/**
 *
 * @author greg
 */
public class WordFrequencyProcessorTest {

    private WordFrequencyProcessor wordFreq;

    @Test
    public void oneLine() throws Exception {
        testFile("oneLine.txt");
        assertThat(count("go"), is(1));
        assertThat(count("fred"), is(1));
        assertThat(count("hi"), is(4));
        assertThat(count("test"), is(2));
    }

    @Test
    public void emptyLines() throws Exception {
        testFile("emptyLines.txt");
        assertThat(count("daybreak"), is(1));
        assertThat(count("Peter"), is(1));
        assertThat(count("test"), is(2));
    }

    @Test
    public void oneWord() throws Exception {
        testFile("oneWord.txt");
        assertThat(count("test"), is(1));
    }

    @Test
    public void sampleText() throws Exception {
        testFile("sampleText.txt");
        assertThat(count("HIGGINS"), is(1));
//        wordFreq.frequency.getMap().entrySet()
//                .stream()
//                .sorted((o1,  o2) -> o1.getValue().event().getValue() - o2.getValue().event().getValue())
//                .forEach(System.out::println);
    }

    public int count(String key) {
        Wrapper<MutableInt> x = wordFreq.frequency.getMap().get(key);
        return x == null ? 0 : x.event().getValue();
    }

    private final void testFile(String fileName) throws Exception {
        wordFreq = new WordFrequencyProcessor();
        wordFreq.init();
        final File file = new File("src/test/resources", fileName);
        streamFromFile(file, wordFreq);
    }
}
