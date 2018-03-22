package com.fluxtion.casestudy.flightdelay.generated.binary;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.flightdelay.generated.binary.FlightDetailsHandler;
import com.fluxtion.casestudy.flightdelay.generated.binary.GreaterThanDecorator_1;
import com.fluxtion.casestudy.flightdelay.generated.binary.GroupBy_6;
import com.fluxtion.extension.declarative.funclib.builder.math.CountFunction;
import com.fluxtion.casestudy.flightdelay.FlightDetails;

public class BinaryFlightDataProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final FlightDetailsHandler flightDetailsHandler_2 = new FlightDetailsHandler();
  private final FlightDetailsHandler flightDetailsHandler_11 = new FlightDetailsHandler();
  private final GreaterThanDecorator_1 greaterThanDecorator_1_5 = new GreaterThanDecorator_1();
  public final GroupBy_6 carrierDelayMap = new GroupBy_6();
  public final CountFunction totalFlights = new CountFunction();
  //Dirty flags
  private boolean isDirty_flightDetailsHandler_2 = false;
  private boolean isDirty_flightDetailsHandler_11 = false;
  private boolean isDirty_greaterThanDecorator_1_5 = false;
  private boolean isDirty_carrierDelayMap = false;
  //Filter constants

  public BinaryFlightDataProcessor() {
    greaterThanDecorator_1_5.filterSubject = flightDetailsHandler_2;
    greaterThanDecorator_1_5.source_FlightDetailsHandler_0 = flightDetailsHandler_2;
    carrierDelayMap.greaterThanDecorator_10 = greaterThanDecorator_1_5;
    totalFlights.tracked = flightDetailsHandler_11;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.casestudy.flightdelay.FlightDetails"):
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
    isDirty_flightDetailsHandler_11 = flightDetailsHandler_11.handleFlightDetails(typedEvent);
    if (isDirty_flightDetailsHandler_2) {
      isDirty_greaterThanDecorator_1_5 = greaterThanDecorator_1_5.onEvent();
      if (isDirty_greaterThanDecorator_1_5) {
        carrierDelayMap.updategreaterThanDecorator_10(greaterThanDecorator_1_5);
      }
    }
    if (isDirty_greaterThanDecorator_1_5) {
      isDirty_carrierDelayMap = carrierDelayMap.updated();
    }
    if (isDirty_flightDetailsHandler_11) {
      totalFlights.increment();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_flightDetailsHandler_2 = false;
    isDirty_flightDetailsHandler_11 = false;
    isDirty_greaterThanDecorator_1_5 = false;
    isDirty_carrierDelayMap = false;
  }

  @Override
  public void init() {
    greaterThanDecorator_1_5.init();
    carrierDelayMap.init();
    totalFlights.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
