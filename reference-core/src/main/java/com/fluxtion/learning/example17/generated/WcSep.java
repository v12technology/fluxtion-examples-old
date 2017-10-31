package com.fluxtion.learning.example17.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example17.WordCounter;
import com.fluxtion.learning.example17.CharEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;

public class WcSep implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  public final WordCounter result = new WordCounter();
  //Dirty flags

  //Filter constants

  public WcSep() {}

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example17.CharEvent"):
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
    result.onUnmatchedChar(typedEvent);
    result.onAnyChar(typedEvent);
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
        9,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_9((com.fluxtion.learning.example17.CharEvent) event);
          }
        });
    dispatchMap.put(
        10,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_10((com.fluxtion.learning.example17.CharEvent) event);
          }
        });
    dispatchMap.put(
        32,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_32((com.fluxtion.learning.example17.CharEvent) event);
          }
        });
    dispatchMap.put(
        0,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharEvent_NoFilter((com.fluxtion.learning.example17.CharEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_CharEvent_9(com.fluxtion.learning.example17.CharEvent typedEvent) {
    //method body - invoke call tree
    result.onTabDelimiter(typedEvent);
    result.onAnyChar(typedEvent);
  }

  private void handle_CharEvent_10(com.fluxtion.learning.example17.CharEvent typedEvent) {
    //method body - invoke call tree
    result.onEol(typedEvent);
    result.onAnyChar(typedEvent);
  }

  private void handle_CharEvent_32(com.fluxtion.learning.example17.CharEvent typedEvent) {
    //method body - invoke call tree
    result.onSpaceDelimiter(typedEvent);
    result.onAnyChar(typedEvent);
  }

  private void handle_CharEvent_NoFilter(com.fluxtion.learning.example17.CharEvent typedEvent) {
    //method body - invoke call tree
    result.onUnmatchedChar(typedEvent);
    result.onAnyChar(typedEvent);
    //event stack unwind callbacks
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {}

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
