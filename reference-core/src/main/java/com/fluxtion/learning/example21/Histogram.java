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
package com.fluxtion.learning.example21;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.FilterId;
import com.fluxtion.api.node.NodeFactory;
import com.fluxtion.api.node.NodeRegistry;
import com.fluxtion.api.node.SEPConfig;
import java.util.Map;

/**
 *
 * @author greg
 */
public class Histogram {

    @FilterId
    public String filter;
    public HistogramBucket[] buckets;
    public int min;
    public int max;
    private int minCount;
    private int maxCount;

    @EventHandler
    public void processValue(IntValueEvent event) {
        int value = event.value;
        if (value <= min) {
            minCount++;
        }
        if (value > max) {
            maxCount++;
        }
    }

    public void printDistribution(){
        String fil = filter!=null? (" for:" + filter): "";
        System.out.println("Distribution" + fil);
        System.out.printf("%3d values less than %3d\n", minCount, min);
        for (HistogramBucket bucket : buckets) {
            System.out.printf("%3d values %3d -> %3d\n", bucket.getCount(), bucket.min, bucket.max);
        }
        System.out.printf("%3d values greater than %3d\n", maxCount, max); 
    }

    public static class HistogramFactory implements NodeFactory<Histogram> {

        static int count;

        @Override
        public Histogram createNode(Map config, NodeRegistry registry) {
            double min = 0;
            double max = 100;
            int buckets = 10;
            String filter = (String) config.get("filter");
            if (config.containsKey("min") & config.containsKey("max") & config.containsKey("buckets")) {
                min = Integer.parseInt((String) config.get("min"));
                max = Integer.parseInt((String) config.get("max"));
                buckets = Integer.parseInt((String) config.get("buckets"));
            }
            double delta = (max - min) / buckets;
            Histogram histogram = new Histogram();
            histogram.buckets = new HistogramBucket[buckets];
            histogram.filter = filter;
            histogram.min = (int)min;
            histogram.max = (int)max;
            for (int i = 0; i < buckets; i++) {
                final HistogramBucket bucket = new HistogramBucket();
                //Object bucket = buckets[i];
                histogram.buckets[i] = bucket;
                bucket.filter = filter;
                bucket.min = (int)min;
                bucket.max = (int)(min + delta);
                min = min + delta;
                registry.registerNode(bucket, "bucket_" + count++);
            }
            return histogram;
        }

    }

}
