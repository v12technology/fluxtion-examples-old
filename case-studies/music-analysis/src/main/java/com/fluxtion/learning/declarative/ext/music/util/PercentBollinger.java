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
package com.fluxtion.learning.declarative.ext.music.util;

import com.fluxtion.extension.declarative.api.numeric.NumericFunctionStateful;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * A percentage bollinger band calculation with fixed 20 window size and 2
 * standard deviations
 *
 * @author gregp
 */
public class PercentBollinger implements NumericFunctionStateful {

    private DescriptiveStatistics stats = new DescriptiveStatistics(20);
    private static final int sdCount = 2;
    private double lower;
    private double mean;
    private double upper;
    private double percentB;

    public double calcAverage(double newValue, double oldAverage) {
        stats.addValue(newValue);
        mean = stats.getMean();
        double sd = stats.getStandardDeviation();
        upper = mean + sdCount * sd;
        lower = mean - sdCount * sd;
        percentB = (newValue - lower)/(upper-lower);
        return percentB;
    }

    @Override
    public double reset() {
        stats.clear();
        return 0;
    }

    public double getLower() {
        return lower;
    }

    public double getMean() {
        return mean;
    }

    public double getUpper() {
        return upper;
    }

    public double getPercentB() {
        return percentB;
    }

}
