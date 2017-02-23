/* 
 * Copyright (C) 2017 V12 Technology Limited
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
package com.fluxtion.learning.example17;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterType;
import com.fluxtion.api.node.SEPConfig;

/**
 * 
 * @author Greg Higgins
 */
public class WordCounter {

	public transient int wordCount;
	public transient int charCount;
	public transient int lineCount;
	private int increment = 1;

	@EventHandler
	public void onAnyChar(CharEvent event) {
		charCount++;
	}

	@EventHandler(filterId = '\t')
	public void onTabDelimiter(CharEvent event) {
		increment = 1;
	}

	@EventHandler(filterId = ' ')
	public void onSpaceDelimiter(CharEvent event) {
		increment = 1;
	}

	@EventHandler(filterId = '\n')
	public void onEol(CharEvent event) {
		lineCount++;
		increment = 1;
	}

	@EventHandler(FilterType.unmatched)
	public void onUnmatchedChar(CharEvent event) {
		wordCount += increment;
		increment = 0;
	}

	@Override
	public String toString() {
		return "wc result" 
                + "\ncharCount:" + charCount 
                + "\nwordCount:" + wordCount
				+ "\nlineCount:" + lineCount;
	}

	public static class Builder extends SEPConfig {
		{
			addPublicNode(new WordCounter(), "result");
		}
	}

}
