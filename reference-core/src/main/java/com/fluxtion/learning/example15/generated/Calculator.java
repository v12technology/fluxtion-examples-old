package com.fluxtion.learning.example15.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example15.CalcInput;
import com.fluxtion.learning.example15.CalcEngine;
import com.fluxtion.learning.example15.CharEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;

public class Calculator implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final CalcInput calcInput_1 = new CalcInput();
  public final CalcEngine fpu = new CalcEngine();
  //Dirty flags

  //Filter constants

  public Calculator() {
    fpu.input = calcInput_1;
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
    FilteredHandlerInvoker invoker = dispatchIntMapCharEvent.get(typedEvent.filterId());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    //Default, no filter methods
    calcInput_1.anyChar(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  //int filter maps
  private final Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchIntMapCharEvent =
      initdispatchIntMapCharEvent();

  //String filter maps
  private Int2ObjectOpenHashMap<FilteredHandlerInvoker> initdispatchIntMapCharEvent() {
    Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchMap = new Int2ObjectOpenHashMap<>();
    dispatchMap.put(
        42,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_42((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        43,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_43((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        45,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_45((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        46,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_46((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        47,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_47((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        61,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_61((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        99,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_99((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        114,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_114((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    dispatchMap.put(
        0,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_NoFilter((com.fluxtion.learning.example15.CharEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_CharEvent_42(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.anyChar(typedEvent);
    fpu.onFunctionMultiply(typedEvent);
  }

  private void handle_CharEvent_43(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.anyChar(typedEvent);
    fpu.onFunctionAdd(typedEvent);
  }

  private void handle_CharEvent_45(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.anyChar(typedEvent);
    fpu.onFunctionMinus(typedEvent);
  }

  private void handle_CharEvent_46(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.onDecimalPoint(typedEvent);
    calcInput_1.anyChar(typedEvent);
  }

  private void handle_CharEvent_47(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.anyChar(typedEvent);
    fpu.onFunctionDivide(typedEvent);
  }

  private void handle_CharEvent_61(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.anyChar(typedEvent);
    fpu.onCalculate(typedEvent);
  }

  private void handle_CharEvent_99(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.onClear(typedEvent);
    calcInput_1.anyChar(typedEvent);
  }

  private void handle_CharEvent_114(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.anyChar(typedEvent);
    fpu.onReset(typedEvent);
  }

  private void handle_CharEvent_NoFilter(com.fluxtion.learning.example15.CharEvent typedEvent) {
    //method body - invoke call tree
    calcInput_1.anyChar(typedEvent);
    //event stack unwind callbacks
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
