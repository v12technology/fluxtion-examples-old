/*
 * Copyright (C) 2018 gregp
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
package com.fluxtion.casestudy.worldcity;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;

/**
 *
 * @author gregp
 */
public class MyBuffer implements Wrapper<WorldCity> {

    //buffer management
    private final char[] chars = new char[4096];
    private int[] delimIndex = new int[1024];
    private int writeIndex = 0;
    private int fieldIndex = 0;
    
    //col 0
    private final StringBuilder country = new StringBuilder();
    //col 1
    private final StringBuilder city = new StringBuilder();
    //col 2
    private final StringBuilder accentCity = new StringBuilder();
    //col 3
    private final StringBuilder region = new StringBuilder();
    //col 4
    private final StringBuilder population = new StringBuilder();
    //col 5
    private final StringBuilder latitude = new StringBuilder();
    //col 6
    private final StringBuilder longitude = new StringBuilder();
    
    //target
    private WorldCity target;

    @EventHandler
    public boolean charEvent(CharEvent event) {
        final char character = event.getCharacter();
        if (character == '\n') {
            return updateTarget();
        }
        if (character == ',') {
            updateFieldIndex();
        }
        chars[writeIndex++] = character;
        return false;
    }

    private void updateFieldIndex() {
        fieldIndex++;
        delimIndex[fieldIndex] = writeIndex + 1;
    }

    private boolean updateTarget() {
        updateFieldIndex();
        writeIndex = 0;
        fieldIndex = 0;
        extractCharSequence(country, 0);
        extractCharSequence(city, 1);
        extractCharSequence(accentCity, 2);
        extractCharSequence(region, 3);
        extractCharSequence(population, 4);
        extractCharSequence(latitude, 5);
        extractCharSequence(longitude, 6);
        //target
        pushData();
        return true;
    }
    
    private void extractCharSequence(StringBuilder source, int fieldIndex){
        source.setLength(0);
        source.append(chars, delimIndex[fieldIndex], delimIndex[fieldIndex+1] - delimIndex[fieldIndex] - 1);
    }
    
    private void pushData(){
        target.setCountry(country);
        target.setCity(city);
        target.setAccentCity(accentCity);
        target.setRegion(region);
        target.setPopulation(region);
        target.setLatitude(latitude);
        target.setLongitude(longitude);
    }

    @Override
    public WorldCity event() {
        return target;
    }

    @Override
    public Class<WorldCity> eventClass() {
        return WorldCity.class;
    }

    @Initialise
    public void init() {
        target = new WorldCity();
    }
}
