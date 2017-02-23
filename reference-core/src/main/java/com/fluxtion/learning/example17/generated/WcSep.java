/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example17.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example17.WordCounter;
import com.fluxtion.learning.example17.CharEvent;

public class WcSep implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  public final WordCounter result = new WordCounter();
  //Dirty flags

  //Filter constants

  public WcSep() {
    //result
  }

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
    switch (typedEvent.filterId()) {
        //Event Class:[com.fluxtion.learning.example17.CharEvent] filterId:[9]
      case (9):
        result.onTabDelimiter(typedEvent);
        result.onAnyChar(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example17.CharEvent] filterId:[10]
      case (10):
        result.onEol(typedEvent);
        result.onAnyChar(typedEvent);
        afterEvent();
        return;
        //Event Class:[com.fluxtion.learning.example17.CharEvent] filterId:[32]
      case (32):
        result.onSpaceDelimiter(typedEvent);
        result.onAnyChar(typedEvent);
        afterEvent();
        return;
    }
    //Default, no filter methods
    result.onUnmatchedChar(typedEvent);
    result.onAnyChar(typedEvent);
    //event stack unwind callbacks
    afterEvent();
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
