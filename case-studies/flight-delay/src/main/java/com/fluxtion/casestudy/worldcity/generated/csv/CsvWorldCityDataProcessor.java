package com.fluxtion.casestudy.worldcity.generated.csv;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.casestudy.worldcity.RowDispatcher;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;

public class CsvWorldCityDataProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final WorldCityCsvMarshaller0 worldCityCsvMarshaller0_2 = new WorldCityCsvMarshaller0();
  public final RowDispatcher dispatcher = new RowDispatcher(worldCityCsvMarshaller0_2);
  //Dirty flags
  private boolean isDirty_worldCityCsvMarshaller0_2 = false;
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
    }
  }

  public void handleEvent(CharEvent typedEvent) {
    //Default, no filter methods
    isDirty_worldCityCsvMarshaller0_2 = worldCityCsvMarshaller0_2.charEvent(typedEvent);
    if (isDirty_worldCityCsvMarshaller0_2) {
      dispatcher.publishRow();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_worldCityCsvMarshaller0_2 = false;
  }

  @Override
  public void init() {
    worldCityCsvMarshaller0_2.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
