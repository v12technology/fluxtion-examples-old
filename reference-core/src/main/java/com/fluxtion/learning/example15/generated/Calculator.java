package com.fluxtion.learning.example15.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example15.CalcEngine;
import com.fluxtion.learning.example15.CalcInput;
import com.fluxtion.learning.example15.CharEvent;

public class Calculator implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  public final CalcEngine fpu = new CalcEngine();
  private final CalcInput calcInput_1 = new CalcInput();
  //Dirty flags

  //Filter constants

  public Calculator() {
    //fpu
    fpu.input = calcInput_1;
    //calcInput_1
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example15.CharEvent"):
        {
          CharEvent typedEvent = (CharEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(CharEvent typedEvent) {
    switch (typedEvent.filterId()) {
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[42]
      case (42):
        calcInput_1.anyChar(typedEvent);
        fpu.onFunctionMultiply(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[43]
      case (43):
        calcInput_1.anyChar(typedEvent);
        fpu.onFunctionAdd(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[45]
      case (45):
        calcInput_1.anyChar(typedEvent);
        fpu.onFunctionMinus(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[46]
      case (46):
        calcInput_1.onDecimalPoint(typedEvent);
        calcInput_1.anyChar(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[47]
      case (47):
        calcInput_1.anyChar(typedEvent);
        fpu.onFunctionDivide(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[61]
      case (61):
        calcInput_1.anyChar(typedEvent);
        fpu.onCalculate(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[99]
      case (99):
        calcInput_1.onClear(typedEvent);
        calcInput_1.anyChar(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example15.CharEvent] filterId:[114]
      case (114):
        calcInput_1.anyChar(typedEvent);
        fpu.onReset(typedEvent);
        afterEvent();
        return;
    }
    //Default, no filter methods
    calcInput_1.anyChar(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {
    fpu.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
