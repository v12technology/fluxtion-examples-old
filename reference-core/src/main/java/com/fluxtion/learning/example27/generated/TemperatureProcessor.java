package com.fluxtion.learning.example27.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example27.HighTemperatureTest;
import com.fluxtion.learning.example27.TemperatureAlertLogger;
import com.fluxtion.learning.TemperatureEvent;

public class TemperatureProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  final net.vidageek.mirror.dsl.Mirror constructor = new net.vidageek.mirror.dsl.Mirror();
  private final HighTemperatureTest highTemperatureTest_1 =
      constructor.on(HighTemperatureTest.class).invoke().constructor().bypasser();
  public final TemperatureAlertLogger alertLogger =
      constructor.on(TemperatureAlertLogger.class).invoke().constructor().bypasser();
  //Dirty flags
  private boolean isDirty_highTemperatureTest_1 = false;
  //Filter constants

  public TemperatureProcessor() {
    final net.vidageek.mirror.dsl.Mirror assigner = new net.vidageek.mirror.dsl.Mirror();
    //highTemperatureTest_1
    assigner.on(highTemperatureTest_1).set().field("highLimit").withValue((int) 35);
    //alertLogger
    assigner.on(alertLogger).set().field("tempTest").withValue(highTemperatureTest_1);
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
    isDirty_highTemperatureTest_1 = highTemperatureTest_1.processTemp(typedEvent);
    if (isDirty_highTemperatureTest_1) {
      alertLogger.tempAlert();
    }
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_highTemperatureTest_1 = false;
  }

  @Override
  public void init() {}

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
