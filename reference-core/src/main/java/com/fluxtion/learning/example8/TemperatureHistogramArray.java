/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
