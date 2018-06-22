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

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.Wrapper;
import static com.fluxtion.extension.declarative.funclib.builder.csv.CsvMarshallerBuilder.csvMarshaller;

/**
 *
 * @author gregp
 */
public class WorldCity {

    
    public static class CsvCfg extends SEPConfig{{
        Wrapper<WorldCity> cityDetails = csvMarshaller(WorldCity.class).build();
        addPublicNode(new RowDispatcher(cityDetails), "dispatcher");
    }}
    
    private CharSequence country;//col 0
    private CharSequence City;//col 1
    private CharSequence AccentCity;//col 2
    private CharSequence Region;//col 3
    private CharSequence population;//col 4
    private CharSequence longitude;//col 5
    private CharSequence latitude;//col 6

    public CharSequence getCountry() {
        return country;
    }

    public void setCountry(CharSequence country) {
        this.country = country;
    }

    public CharSequence getCity() {
        return City;
    }

    public void setCity(CharSequence City) {
        this.City = City;
    }

    public CharSequence getAccentCity() {
        return AccentCity;
    }

    public void setAccentCity(CharSequence AccentCity) {
        this.AccentCity = AccentCity;
    }

    public CharSequence getRegion() {
        return Region;
    }

    public void setRegion(CharSequence Region) {
        this.Region = Region;
    }

    public CharSequence getLongitude() {
        return longitude;
    }

    public void setLongitude(CharSequence longitude) {
        this.longitude = longitude;
    }

    public CharSequence getLatitude() {
        return latitude;
    }

    public void setLatitude(CharSequence latitude) {
        this.latitude = latitude;
    }

    public CharSequence getPopulation() {
        return population;
    }

    public void setPopulation(CharSequence population) {
        this.population = population;
    }

}
