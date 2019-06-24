package com.fluxtion.casestudy.worldcity.generated.csv;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.worldcity.RowDispatcher;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.extension.declarative.funclib.api.event.EofEvent;

public class CsvWorldCityDataProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final WorldCityCsvMarshaller0 worldCityCsvMarshaller0_0 = new WorldCityCsvMarshaller0();
  public final RowDispatcher dispatcher = new RowDispatcher(worldCityCsvMarshaller0_0);
  //Dirty flags
  private boolean isDirty_worldCityCsvMarshaller0_0 = false;
  //Filter constants

  public CsvWorldCityDataProcessor() {}

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
    isDirty_worldCityCsvMarshaller0_0 = worldCityCsvMarshaller0_0.charEvent(typedEvent);
    if (isDirty_worldCityCsvMarshaller0_0) {
      dispatcher.publishRow();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(EofEvent typedEvent) {
    //Default, no filter methods
    isDirty_worldCityCsvMarshaller0_0 = worldCityCsvMarshaller0_0.eof(typedEvent);
    if (isDirty_worldCityCsvMarshaller0_0) {
      dispatcher.publishRow();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_worldCityCsvMarshaller0_0 = false;
  }

  @Override
  public void init() {
    worldCityCsvMarshaller0_0.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
