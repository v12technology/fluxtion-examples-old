package com.fluxtion.learning.utils.events.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.utils.events.AlarmClock;
import com.fluxtion.learning.utils.events.AnnoyingNotification;
import com.fluxtion.runtime.plugin.events.BooleanSignal;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.events.TimingPulseEvent;

public class AlarmProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final AlarmClock alarmClock_1 = new AlarmClock();
  private final AnnoyingNotification annoyingNotification_3 =
      new AnnoyingNotification(alarmClock_1);
  //Dirty flags

  //Filter constants

  public AlarmProcessor() {}

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.eventId()) {
      case (TimingPulseEvent.ID):
        {
          TimingPulseEvent typedEvent = (TimingPulseEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
    switch (event.getClass().getName()) {
      case ("com.fluxtion.runtime.plugin.events.BooleanSignal"):
        {
          BooleanSignal typedEvent = (BooleanSignal) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent"):
        {
          ListenerRegistrationEvent typedEvent = (ListenerRegistrationEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.runtime.plugin.events.NumericSignal"):
        {
          NumericSignal typedEvent = (NumericSignal) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(BooleanSignal typedEvent) {
    switch (typedEvent.filterString()) {
      case ("alarmOnOff"):
        alarmClock_1.alarmEnable(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(ListenerRegistrationEvent typedEvent) {
    switch (typedEvent.filterString()) {
      case ("com.fluxtion.learning.utils.events.AlarmListener"):
        alarmClock_1.setAlarmListener(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(NumericSignal typedEvent) {
    switch (typedEvent.filterString()) {
      case ("alarmTime"):
        alarmClock_1.alarmTime(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(TimingPulseEvent typedEvent) {
    //Default, no filter methods
    alarmClock_1.tickTock(typedEvent);
    annoyingNotification_3.annoy();
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {
    alarmClock_1.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
