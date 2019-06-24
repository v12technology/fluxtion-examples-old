package com.fluxtion.learning.declarative.ext.music.csv;

import com.fluxtion.learning.declarative.ext.music.csv.*;
import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.declarative.ext.music.util.TrackPublisher;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;

public class CsvTrackMarshaller implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final TrackStreamCsvMarshaller0 trackStreamCsvMarshaller0_0 =
      new TrackStreamCsvMarshaller0();
  public final TrackPublisher tracks = new TrackPublisher(trackStreamCsvMarshaller0_0);
  //Dirty flags
  private boolean isDirty_trackStreamCsvMarshaller0_0 = false;
  //Filter constants

  public CsvTrackMarshaller() {}

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
    isDirty_trackStreamCsvMarshaller0_0 = trackStreamCsvMarshaller0_0.charEvent(typedEvent);
    if (isDirty_trackStreamCsvMarshaller0_0) {
      tracks.newTrackStream();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_trackStreamCsvMarshaller0_0 = false;
  }

  @Override
  public void init() {
    trackStreamCsvMarshaller0_0.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
