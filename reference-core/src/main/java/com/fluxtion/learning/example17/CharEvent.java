/* 
 * Copyright (C) 2016 Greg Higgins (greg.higgins@v12technology.com)
 *
 * This file is part of Fluxtion.
 *
 * Fluxtion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example17;

import com.fluxtion.runtime.event.Event;

/**
 * 
 * @author Greg Higgins
 */
public class CharEvent extends Event {

	public CharEvent(char id) {
		super(Event.NO_ID, id);
		filterId = id;
	}

	public char getCharacter() {
		return (char) filterId;
	}

	public void setCharacter(char character) {
		filterId = character;
	}

}
