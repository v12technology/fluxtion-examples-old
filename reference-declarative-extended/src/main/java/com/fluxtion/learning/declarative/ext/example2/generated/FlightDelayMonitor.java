package com.fluxtion.learning.declarative.ext.example2.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.declarative.ext.example2.generated.FlightDetailsHandler;
import com.fluxtion.learning.declarative.ext.example2.generated.GreaterThanDecorator_1;
import com.fluxtion.learning.declarative.ext.example2.generated.GroupBy_6;
import com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor.FlightDetails;

public class FlightDelayMonitor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final FlightDetailsHandler flightDetailsHandler_2 = new FlightDetailsHandler();
  private final GreaterThanDecorator_1 greaterThanDecorator_1_5 = new GreaterThanDecorator_1();
  public final GroupBy_6 carrierDelayMap = new GroupBy_6();
  //Dirty flags
  private boolean isDirty_flightDetailsHandler_2 = false;
  private boolean isDirty_greaterThanDecorator_1_5 = false;
  private boolean isDirty_carrierDelayMap = false;
  //Filter constants

  public FlightDelayMonitor() {
    //flightDetailsHandler_2
    //greaterThanDecorator_1_5
    greaterThanDecorator_1_5.filterSubject = flightDetailsHandler_2;
    greaterThanDecorator_1_5.source_FlightDetailsHandler_0 = flightDetailsHandler_2;
    //carrierDelayMap
    carrierDelayMap.greaterThanDecorator_10 = greaterThanDecorator_1_5;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.declarative.ext.example2.FlightDelayProcessor$FlightDetails"):
        {
          FlightDetails typedEvent = (FlightDetails) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(FlightDetails typedEvent) {
    //Default, no filter methods
    isDirty_flightDetailsHandler_2 = flightDetailsHandler_2.handleFlightDetails(typedEvent);
    if (isDirty_flightDetailsHandler_2) {
      isDirty_greaterThanDecorator_1_5 = greaterThanDecorator_1_5.onEvent();
      if (isDirty_greaterThanDecorator_1_5) {
        carrierDelayMap.updategreaterThanDecorator_10(greaterThanDecorator_1_5);
      }
    }
    if (isDirty_greaterThanDecorator_1_5) {
      isDirty_carrierDelayMap = carrierDelayMap.updated();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_flightDetailsHandler_2 = false;
    isDirty_greaterThanDecorator_1_5 = false;
    isDirty_carrierDelayMap = false;
  }

  @Override
  public void init() {
    greaterThanDecorator_1_5.init();
    carrierDelayMap.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
