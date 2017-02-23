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
package com.fluxtion.learning.example15;

import com.fluxtion.runtime.event.Event;

/**
 * 
 * @author Greg Higgins
 */
public class CharEvent extends Event {

	/** mutable char easy to re-use memory for demo **/
	private char character;

	public CharEvent(char id) {
		super(Event.NO_ID, id);
		this.character = id;
		filterId = id;
	}

	public char getCharacter() {
		return character;
	}

	/**
	 * Setting the character will also make the filterId update as well
	 * 
	 * @param character
	 */
	public void setCharacter(char character) {
		this.character = character;
		filterId = character;
	}

}
