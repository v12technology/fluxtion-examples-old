package com.fluxtion.casestudy.flightdelay.generated.binary;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.flightdelay.generated.binary.FlightDetailsHandler;
import com.fluxtion.casestudy.flightdelay.generated.binary.GreaterThanDecorator_1;
import com.fluxtion.casestudy.flightdelay.generated.binary.GroupBy_6;
import com.fluxtion.casestudy.flightdelay.FlightDetails;

public class BinaryFlightDataProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final FlightDetailsHandler flightDetailsHandler_1 = new FlightDetailsHandler();
  private final GreaterThanDecorator_1 greaterThanDecorator_1_3 = new GreaterThanDecorator_1();
  public final GroupBy_6 carrierDelayMap = new GroupBy_6();
  //Dirty flags
  private boolean isDirty_flightDetailsHandler_1 = false;
  private boolean isDirty_greaterThanDecorator_1_3 = false;
  private boolean isDirty_carrierDelayMap = false;
  //Filter constants

  public BinaryFlightDataProcessor() {
    greaterThanDecorator_1_3.filterSubject = flightDetailsHandler_1;
    greaterThanDecorator_1_3.source_FlightDetailsHandler_0 = flightDetailsHandler_1;
    carrierDelayMap.greaterThanDecorator_10 = greaterThanDecorator_1_3;
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
    isDirty_flightDetailsHandler_1 = flightDetailsHandler_1.handleFlightDetails(typedEvent);
    if (isDirty_flightDetailsHandler_1) {
      isDirty_greaterThanDecorator_1_3 = greaterThanDecorator_1_3.onEvent();
      if (isDirty_greaterThanDecorator_1_3) {
        carrierDelayMap.updategreaterThanDecorator_10(greaterThanDecorator_1_3);
      }
    }
    if (isDirty_greaterThanDecorator_1_3) {
      isDirty_carrierDelayMap = carrierDelayMap.updated();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_flightDetailsHandler_1 = false;
    isDirty_greaterThanDecorator_1_3 = false;
    isDirty_carrierDelayMap = false;
  }

  @Override
  public void init() {
    greaterThanDecorator_1_3.init();
    carrierDelayMap.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
