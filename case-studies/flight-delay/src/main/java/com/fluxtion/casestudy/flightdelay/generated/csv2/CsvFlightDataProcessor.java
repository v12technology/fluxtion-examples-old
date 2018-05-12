package com.fluxtion.casestudy.flightdelay.generated.csv2;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.extension.declarative.funclib.builder.math.CountFunction;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;

public class CsvFlightDataProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final FlightDetailsCsvMarshaller0 flightDetailsCsvMarshaller0_1 =
      new FlightDetailsCsvMarshaller0();
  private final GreaterThanDecorator_2 greaterThanDecorator_2_3 = new GreaterThanDecorator_2();
  public final GroupBy_7 carrierDelayMap = new GroupBy_7();
  public final CountFunction totalFlights = new CountFunction();
  //Dirty flags
  private boolean isDirty_flightDetailsCsvMarshaller0_1 = false;
  private boolean isDirty_greaterThanDecorator_2_3 = false;
  private boolean isDirty_carrierDelayMap = false;
  //Filter constants

  public CsvFlightDataProcessor() {
    greaterThanDecorator_2_3.filterSubject = flightDetailsCsvMarshaller0_1;
    greaterThanDecorator_2_3.source_FlightDetailsCsvMarshaller0_1 = flightDetailsCsvMarshaller0_1;
    carrierDelayMap.greaterThanDecorator_20 = greaterThanDecorator_2_3;
    totalFlights.tracked = flightDetailsCsvMarshaller0_1;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (CharEvent.ID):
        {
          CharEvent typedEvent = (CharEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(CharEvent typedEvent) {
    //Default, no filter methods
    isDirty_flightDetailsCsvMarshaller0_1 = flightDetailsCsvMarshaller0_1.charEvent(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller0_1) {
      isDirty_greaterThanDecorator_2_3 = greaterThanDecorator_2_3.onEvent();
      if (isDirty_greaterThanDecorator_2_3) {
        carrierDelayMap.updategreaterThanDecorator_20(greaterThanDecorator_2_3);
      }
    }
    if (isDirty_greaterThanDecorator_2_3) {
      isDirty_carrierDelayMap = carrierDelayMap.updated();
    }
    if (isDirty_flightDetailsCsvMarshaller0_1) {
      totalFlights.increment();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_flightDetailsCsvMarshaller0_1 = false;
    isDirty_greaterThanDecorator_2_3 = false;
    isDirty_carrierDelayMap = false;
  }

  @Override
  public void init() {
    flightDetailsCsvMarshaller0_1.init();
    greaterThanDecorator_2_3.init();
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
