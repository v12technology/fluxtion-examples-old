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
package com.fluxtion.learning.example5;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.TearDown;
import com.fluxtion.learning.TemperatureEvent;

/**
 *
 * @author greg
 */
public class TemperatureHistogram {

    public TemperatureBucket bucket1;
    public TemperatureBucket bucket2;
    public TemperatureBucket bucket3;
    public TemperatureBucket bucket4;
    public TemperatureBucket bucket5;

    private int bucketCount;
    private int minTemp = -20;
    private int maxTemp = 60;
    private int belowMinCount = 0;
    private int aboveMaxCount = 0;

    @Initialise
    public void initHistogram() {
        countBuckets();
        int delta = maxTemp - minTemp;
        int bucketSize = delta / bucketCount;
        int min = maxTemp - bucketSize;
        int max = maxTemp;
        switch (bucketCount) {
            case 5:
                bucket5.setRange(min, max);
                max = min;
                min -= bucketSize;
            case 4:
                bucket4.setRange(min, max);
                max = min;
                min -= bucketSize;
            case 3:
                bucket3.setRange(min, max);
                max = min;
                min -= bucketSize;
            case 2:
                bucket2.setRange(min, max);
                max = min;
                min -= bucketSize;
            case 1:
                bucket1.setRange(min, max);
                max = min;
                min -= bucketSize;
                break;
            default:
                System.out.println("No Buckets set");
        }
    }
    
    @TearDown
    public void printOutOfRange() {
        System.out.printf("%3d values less than %3d\n", belowMinCount, minTemp);
        System.out.printf("%3d values greater than %3d\n", aboveMaxCount, maxTemp);
    }
    
    @EventHandler
    public void handleTemp(TemperatureEvent tempRreading) {
        int reading = tempRreading.getTemperature();
        if(reading <= minTemp){
            belowMinCount++;
        }else if(reading > maxTemp){
            aboveMaxCount++;
        }
    }

    public void addBucket(TemperatureBucket bucket) {
        bucketCount++;
        switch (bucketCount) {
            case 1:
                bucket1 = bucket;
                break;
            case 2:
                bucket2 = bucket;
                break;
            case 3:
                bucket3 = bucket;
                break;
            case 4:
                bucket4 = bucket;
                break;
            case 5:
                bucket5 = bucket;
                break;
            default:
                System.out.println("too many buckets, max buckets:5");
        }
    }

    private void countBuckets() {
        if (bucket5 != null) {
            bucketCount = 5;
        } else if (bucket4 != null) {
            bucketCount = 4;
        } else if (bucket3 != null) {
            bucketCount = 3;
        } else if (bucket2 != null) {
            bucketCount = 2;
        } else if (bucket1 != null) {
            bucketCount = 4;
        }
    }
}
