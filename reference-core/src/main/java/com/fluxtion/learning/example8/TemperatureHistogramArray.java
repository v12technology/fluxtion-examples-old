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
package com.fluxtion.learning.example8;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.TearDown;
import com.fluxtion.learning.TemperatureEvent;
import com.fluxtion.learning.example5.TemperatureBucket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author greg
 */
public class TemperatureHistogramArray {

    public TemperatureBucket[] buckets;

    private final int minTemp = -20;
    private final int maxTemp = 60;
    private int belowMinCount = 0;
    private int aboveMaxCount = 0;

    @TearDown
    public void printOutOfRange() {
        System.out.printf("%3d values less than %3d\n", belowMinCount, minTemp);
        System.out.printf("%3d values greater than %3d\n", aboveMaxCount, maxTemp);
    }

    @EventHandler
    public void handleTemp(TemperatureEvent tempRreading) {
        int reading = tempRreading.getTemperature();
        if (reading <= minTemp) {
            belowMinCount++;
        } else if (reading > maxTemp) {
            aboveMaxCount++;
        }
    }

    @Initialise
    public void initHistogram() {
        int bucketCount = buckets.length;
        int delta = maxTemp - minTemp;
        int bucketSize = delta / bucketCount;
        int min = maxTemp - bucketSize;
        int max = maxTemp;
        for (TemperatureBucket bucket : buckets) {
            bucket.setRange(min, max);
            max = min;
            min -= bucketSize;
        }
    }

    public void addBucket(TemperatureBucket bucket) {
        if(buckets==null){
            buckets = new TemperatureBucket[0];
        }
        ArrayList<TemperatureBucket> bucketList = new ArrayList<>(Arrays.asList(buckets));
        bucketList.add(bucket);
        buckets = bucketList.toArray(new TemperatureBucket[0]);
    }
}
