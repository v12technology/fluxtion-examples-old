/*
 * Copyright (C) 2018 V12 Technology Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Server Side License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program.  If not, see
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */
package com.fluxtion.examples.tradingmonitor.generated.fluxCsvDeal;

import com.fluxtion.api.lifecycle.BatchHandler;
import com.fluxtion.api.lifecycle.EventHandler;
import com.fluxtion.api.lifecycle.Lifecycle;
import com.fluxtion.ext.streaming.api.log.LogControlEvent;
import com.fluxtion.ext.text.api.csv.ValidationLogSink;
import com.fluxtion.ext.text.api.csv.ValidationLogger;
import com.fluxtion.ext.text.api.event.CharEvent;
import com.fluxtion.ext.text.api.event.EofEvent;
import com.fluxtion.ext.text.api.event.RegisterEventHandler;
import com.fluxtion.ext.text.api.util.EventPublsher;

public class Csv2Deal implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final DealCsvDecoder0 dealCsvDecoder0_0 = new DealCsvDecoder0();
  private final EventPublsher eventPublsher_1 = new EventPublsher();
  private final ValidationLogger validationLogger_2 = new ValidationLogger("validationLog");
  private final ValidationLogSink validationLogSink_3 = new ValidationLogSink("validationLogSink");
  //Dirty flags
  private boolean isDirty_dealCsvDecoder0_0 = false;
  private boolean isDirty_eventPublsher_1 = false;
  private boolean isDirty_validationLogSink_3 = false;
  //Filter constants

  public Csv2Deal() {
    dealCsvDecoder0_0.errorLog = validationLogger_2;
    validationLogSink_3.setPublishLogImmediately(true);
    validationLogger_2.logSink = validationLogSink_3;
    eventPublsher_1.publishOnValidate = (boolean) false;
  }

  @Override
  public void onEvent(com.fluxtion.api.event.Event event) {
    switch (event.eventId()) {
      case (LogControlEvent.ID):
        {
          LogControlEvent typedEvent = (LogControlEvent) event;
          handleEvent(typedEvent);
          break;
        }
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
      case (RegisterEventHandler.ID):
        {
          RegisterEventHandler typedEvent = (RegisterEventHandler) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(LogControlEvent typedEvent) {
    switch (typedEvent.filterString()) {
        //Event Class:[com.fluxtion.ext.streaming.api.log.LogControlEvent] filterString:[CHANGE_LOG_PROVIDER]
      case ("CHANGE_LOG_PROVIDER"):
        isDirty_validationLogSink_3 = true;
        validationLogSink_3.controlLogProvider(typedEvent);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(CharEvent typedEvent) {
    //Default, no filter methods
    isDirty_dealCsvDecoder0_0 = dealCsvDecoder0_0.charEvent(typedEvent);
    if (isDirty_dealCsvDecoder0_0) {
      eventPublsher_1.wrapperUpdate(dealCsvDecoder0_0);
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(EofEvent typedEvent) {
    //Default, no filter methods
    isDirty_dealCsvDecoder0_0 = dealCsvDecoder0_0.eof(typedEvent);
    if (isDirty_dealCsvDecoder0_0) {
      eventPublsher_1.wrapperUpdate(dealCsvDecoder0_0);
    }
    //event stack unwind callbacks
    afterEvent();
  }

  public void handleEvent(RegisterEventHandler typedEvent) {
    //Default, no filter methods
    isDirty_eventPublsher_1 = true;
    eventPublsher_1.registerEventHandler(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {

    isDirty_dealCsvDecoder0_0 = false;
    isDirty_eventPublsher_1 = false;
    isDirty_validationLogSink_3 = false;
  }

  @Override
  public void init() {
    dealCsvDecoder0_0.init();
    eventPublsher_1.init();
    validationLogSink_3.init();
  }

  @Override
  public void tearDown() {}

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
