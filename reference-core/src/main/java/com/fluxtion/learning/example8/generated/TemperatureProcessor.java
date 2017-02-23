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
package com.fluxtion.learning.example8.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example5.TemperatureBucket;
import com.fluxtion.learning.example8.TemperatureHistogramArray;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final TemperatureBucket temperatureBucket_3 = new TemperatureBucket();
  private final TemperatureBucket temperatureBucket_5 = new TemperatureBucket();
  private final TemperatureBucket temperatureBucket_7 = new TemperatureBucket();
  private final TemperatureBucket temperatureBucket_9 = new TemperatureBucket();
  private final TemperatureHistogramArray temperatureHistogramArray_1 =
      new TemperatureHistogramArray();
  //Dirty flags

  //Filter constants

  public TemperatureProcessor() {
    //temperatureBucket_3
    //temperatureBucket_5
    //temperatureBucket_7
    //temperatureBucket_9
    //temperatureHistogramArray_1
    temperatureHistogramArray_1.buckets = new TemperatureBucket[4];
    temperatureHistogramArray_1.buckets[0] = temperatureBucket_3;
    temperatureHistogramArray_1.buckets[1] = temperatureBucket_5;
    temperatureHistogramArray_1.buckets[2] = temperatureBucket_7;
    temperatureHistogramArray_1.buckets[3] = temperatureBucket_9;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.TemperatureEvent"):
        {
          TemperatureEvent typedEvent = (TemperatureEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(TemperatureEvent typedEvent) {
    //Default, no filter methods
    temperatureBucket_3.handleTemp(typedEvent);
    temperatureBucket_5.handleTemp(typedEvent);
    temperatureBucket_7.handleTemp(typedEvent);
    temperatureBucket_9.handleTemp(typedEvent);
    temperatureHistogramArray_1.handleTemp(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {
    temperatureBucket_3.init();
    temperatureBucket_5.init();
    temperatureBucket_7.init();
    temperatureBucket_9.init();
    temperatureHistogramArray_1.initHistogram();
  }

  @Override
  public void tearDown() {
    temperatureHistogramArray_1.printOutOfRange();
    temperatureBucket_9.dispalyBucketResult();
    temperatureBucket_7.dispalyBucketResult();
    temperatureBucket_5.dispalyBucketResult();
    temperatureBucket_3.dispalyBucketResult();
  }

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
