package com.fluxtion.learning.example16.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example16.SalesProcessor;
import com.fluxtion.learning.example16.SaleEvent;

public class SalesProcessorSEP implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final SalesProcessor salesProcessor_1 = new SalesProcessor();
  private final SalesProcessor salesProcessor_3 = new SalesProcessor();
  private final SalesProcessor salesProcessor_5 = new SalesProcessor();
  //Dirty flags

  //Filter constants

  public SalesProcessorSEP() {
    //salesProcessor_1
    salesProcessor_1.salesPerson = "bill murray";
    //salesProcessor_3
    salesProcessor_3.salesPerson = "jennifer aniston";
    //salesProcessor_5
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
    switch (typedEvent.filterString()) {
      case ("bill murray"):
        salesProcessor_1.handleSale(typedEvent);
        afterEvent();
        return;
      case ("daniel craig"):
        salesProcessor_5.handleSale(typedEvent);
        afterEvent();
        return;
      case ("jennifer aniston"):
        salesProcessor_3.handleSale(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
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
