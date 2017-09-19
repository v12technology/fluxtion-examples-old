package com.fluxtion.learning.example16.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example16.SalesProcessor;
import com.fluxtion.learning.example16.SaleEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import java.util.HashMap;

public class SalesProcessorSEP implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final SalesProcessor salesProcessor_1 = new SalesProcessor();
  private final SalesProcessor salesProcessor_3 = new SalesProcessor();
  private final SalesProcessor salesProcessor_5 = new SalesProcessor();
  //Dirty flags

  //Filter constants

  public SalesProcessorSEP() {
    salesProcessor_1.salesPerson = "bill murray";
    salesProcessor_3.salesPerson = "jennifer aniston";
    salesProcessor_5.salesPerson = "daniel craig";
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example16.SaleEvent"):
        {
          SaleEvent typedEvent = (SaleEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(SaleEvent typedEvent) {
    FilteredHandlerInvoker invoker = dispatchStringMapSaleEvent.get(typedEvent.filterString());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  //int filter maps
  //String filter maps
  private final HashMap<String, FilteredHandlerInvoker> dispatchStringMapSaleEvent =
      initdispatchStringMapSaleEvent();

  private HashMap<String, FilteredHandlerInvoker> initdispatchStringMapSaleEvent() {
    HashMap<String, FilteredHandlerInvoker> dispatchMap = new HashMap<>();
    dispatchMap.put(
        "bill murray",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_SaleEvent_bill_murray((com.fluxtion.learning.example16.SaleEvent) event);
          }
        });
    dispatchMap.put(
        "daniel craig",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_SaleEvent_daniel_craig((com.fluxtion.learning.example16.SaleEvent) event);
          }
        });
    dispatchMap.put(
        "jennifer aniston",
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_SaleEvent_jennifer_aniston((com.fluxtion.learning.example16.SaleEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_SaleEvent_bill_murray(com.fluxtion.learning.example16.SaleEvent typedEvent) {
    //method body - invoke call tree
    salesProcessor_1.handleSale(typedEvent);
  }

  private void handle_SaleEvent_daniel_craig(com.fluxtion.learning.example16.SaleEvent typedEvent) {
    //method body - invoke call tree
    salesProcessor_5.handleSale(typedEvent);
  }

  private void handle_SaleEvent_jennifer_aniston(
      com.fluxtion.learning.example16.SaleEvent typedEvent) {
    //method body - invoke call tree
    salesProcessor_3.handleSale(typedEvent);
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {}

  @Override
  public void tearDown() {
    salesProcessor_5.complete();
    salesProcessor_3.complete();
    salesProcessor_1.complete();
  }

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
