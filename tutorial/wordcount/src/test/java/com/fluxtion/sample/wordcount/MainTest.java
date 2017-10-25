/*
 * Copyright (C) 2017 gregp
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
package com.fluxtion.sample.wordcount;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Greg Higgins
 */
public class MainTest {

    @Test
    public void testOneLine() throws IOException {
        wcTest("oneLine.txt", 9, 1, 4);
    }
    
    @Test
    public void testEmptyLines() throws IOException {
        wcTest("emptyLines.txt", 26, 3, 4);
    }
    
    @Test
    public void testOneWord() throws IOException {
        wcTest("oneWord.txt", 1, 1, 0);
    }

    @Test
    public void testSampleText() throws IOException {
        wcTest("sampleText.txt", 746, 126, 4);
    }

    private void wcTest(String fileName, int charCount, int wordCount, int lineCount) throws IOException{
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        WordCounter wc = Main.streamFromFile(file).result;
        Assert.assertEquals("mismatched char count", charCount, wc.charCount);
        Assert.assertEquals("mismatched line count", lineCount, wc.lineCount);
        Assert.assertEquals("mismatched word count", wordCount, wc.wordCount);
    }
}
