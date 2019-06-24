package com.fluxtion.casestudy.flightdelay.generated.csv;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.extension.declarative.funclib.builder.math.CountFunction;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.extension.declarative.funclib.api.event.EofEvent;

public class CsvFlightDataProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final FlightDetailsCsvMarshaller0 flightDetailsCsvMarshaller0_0 =
      new FlightDetailsCsvMarshaller0();
  private final GreaterThanDecorator_2 greaterThanDecorator_2_1 = new GreaterThanDecorator_2();
  public final GroupBy_7 carrierDelayMap = new GroupBy_7();
  public final CountFunction totalFlights = new CountFunction();
  //Dirty flags
  private boolean isDirty_flightDetailsCsvMarshaller0_0 = false;
  private boolean isDirty_greaterThanDecorator_2_1 = false;
  //Filter constants

  public CsvFlightDataProcessor() {
    greaterThanDecorator_2_1.filterSubject = flightDetailsCsvMarshaller0_0;
    greaterThanDecorator_2_1.source_FlightDetailsCsvMarshaller0_1 = flightDetailsCsvMarshaller0_0;
    carrierDelayMap.greaterThanDecorator_20 = greaterThanDecorator_2_1;
    totalFlights.tracked = flightDetailsCsvMarshaller0_0;
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
      case (EofEvent.ID):
        {
          EofEvent typedEvent = (EofEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(CharEvent typedEvent) {
    //Default, no filter methods
    isDirty_flightDetailsCsvMarshaller0_0 = flightDetailsCsvMarshaller0_0.charEvent(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller0_0) {
      isDirty_greaterThanDecorator_2_1 = greaterThanDecorator_2_1.onEvent();
      if (isDirty_greaterThanDecorator_2_1) {
        carrierDelayMap.updategreaterThanDecorator_20(greaterThanDecorator_2_1);
      }
    }
    if (isDirty_flightDetailsCsvMarshaller0_0) {
      totalFlights.increment();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(EofEvent typedEvent) {
    //Default, no filter methods
    isDirty_flightDetailsCsvMarshaller0_0 = flightDetailsCsvMarshaller0_0.eof(typedEvent);
    if (isDirty_flightDetailsCsvMarshaller0_0) {
      isDirty_greaterThanDecorator_2_1 = greaterThanDecorator_2_1.onEvent();
      if (isDirty_greaterThanDecorator_2_1) {
        carrierDelayMap.updategreaterThanDecorator_20(greaterThanDecorator_2_1);
      }
    }
    if (isDirty_flightDetailsCsvMarshaller0_0) {
      totalFlights.increment();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_flightDetailsCsvMarshaller0_0 = false;
    isDirty_greaterThanDecorator_2_1 = false;
  }

  @Override
  public void init() {
    flightDetailsCsvMarshaller0_0.init();
    greaterThanDecorator_2_1.init();
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
