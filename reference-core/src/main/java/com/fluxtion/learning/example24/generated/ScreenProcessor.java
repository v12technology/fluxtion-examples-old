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
package com.fluxtion.learning.example24.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example20.CharClassifierConfigProcessor;
import com.fluxtion.learning.example20.CharacterClassifier;
import com.fluxtion.learning.example20.CharacterMatrixFeature;
import com.fluxtion.learning.example20.CharClassifierConfigEvent;
import com.fluxtion.learning.example20.PixelActivationEvent;

public class ScreenProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final CharClassifierConfigProcessor configProcessor_0 =
      new CharClassifierConfigProcessor();
  private final CharClassifierConfigProcessor configProcessor_7 =
      new CharClassifierConfigProcessor();
  private final CharClassifierConfigProcessor configProcessor_8 =
      new CharClassifierConfigProcessor();
  private final CharClassifierConfigProcessor configProcessor_a =
      new CharClassifierConfigProcessor();
  private final CharClassifierConfigProcessor configProcessor_b =
      new CharClassifierConfigProcessor();
  private final CharClassifierConfigProcessor configProcessor_c =
      new CharClassifierConfigProcessor();
  public final CharacterClassifier classifier = new CharacterClassifier();
  private final CharacterMatrixFeature charFeature_0 = new CharacterMatrixFeature();
  private final CharacterMatrixFeature charFeature_7 = new CharacterMatrixFeature();
  private final CharacterMatrixFeature charFeature_8 = new CharacterMatrixFeature();
  private final CharacterMatrixFeature charFeature_a = new CharacterMatrixFeature();
  private final CharacterMatrixFeature charFeature_b = new CharacterMatrixFeature();
  private final CharacterMatrixFeature charFeature_c = new CharacterMatrixFeature();
  //Dirty flags

  //Filter constants
  public static final int char_0 = 48;
  public static final int char_7 = 55;
  public static final int char_8 = 56;
  public static final int char_a = 97;
  public static final int char_b = 98;
  public static final int char_c = 99;

  public ScreenProcessor() {
    //configProcessor_0
    //configProcessor_7
    //configProcessor_8
    //configProcessor_a
    //configProcessor_b
    //configProcessor_c
    //classifier
    classifier.charMatchSet = new CharacterMatrixFeature[6];
    classifier.charMatchSet[0] = charFeature_a;
    classifier.charMatchSet[1] = charFeature_b;
    classifier.charMatchSet[2] = charFeature_c;
    classifier.charMatchSet[3] = charFeature_0;
    classifier.charMatchSet[4] = charFeature_7;
    classifier.charMatchSet[5] = charFeature_8;
    //charFeature_0
    charFeature_0.config = configProcessor_0;
    charFeature_0.matchingChar = '0';
    //charFeature_7
    charFeature_7.config = configProcessor_7;
    charFeature_7.matchingChar = '7';
    //charFeature_8
    charFeature_8.config = configProcessor_8;
    charFeature_8.matchingChar = '8';
    //charFeature_a
    charFeature_a.config = configProcessor_a;
    charFeature_a.matchingChar = 'a';
    //charFeature_b
    charFeature_b.config = configProcessor_b;
    charFeature_b.matchingChar = 'b';
    //charFeature_c
    charFeature_c.config = configProcessor_c;
    charFeature_c.matchingChar = 'c';
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example20.CharClassifierConfigEvent"):
        {
          CharClassifierConfigEvent typedEvent = (CharClassifierConfigEvent) event;
          handleEvent(typedEvent);
          break;
        }
      case ("com.fluxtion.learning.example20.PixelActivationEvent"):
        {
          PixelActivationEvent typedEvent = (PixelActivationEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(CharClassifierConfigEvent typedEvent) {
    switch (typedEvent.filterId()) {
        // matching char = '0'
      case (char_0):
        configProcessor_0.configureValues(typedEvent);
        charFeature_0.configUpdate(configProcessor_0);
        afterEvent();
        return;
        // matching char = '7'
      case (char_7):
        configProcessor_7.configureValues(typedEvent);
        charFeature_7.configUpdate(configProcessor_7);
        afterEvent();
        return;
        // matching char = '8'
      case (char_8):
        configProcessor_8.configureValues(typedEvent);
        charFeature_8.configUpdate(configProcessor_8);
        afterEvent();
        return;
        // matching char = 'a'
      case (char_a):
        configProcessor_a.configureValues(typedEvent);
        charFeature_a.configUpdate(configProcessor_a);
        afterEvent();
        return;
        // matching char = 'b'
      case (char_b):
        configProcessor_b.configureValues(typedEvent);
        charFeature_b.configUpdate(configProcessor_b);
        afterEvent();
        return;
        // matching char = 'c'
      case (char_c):
        configProcessor_c.configureValues(typedEvent);
        charFeature_c.configUpdate(configProcessor_c);
        afterEvent();
        return;
    }
    afterEvent();
  }

  public void handleEvent(PixelActivationEvent typedEvent) {
    //Default, no filter methods
    charFeature_a.handlePixelActivated(typedEvent);
    charFeature_b.handlePixelActivated(typedEvent);
    charFeature_c.handlePixelActivated(typedEvent);
    charFeature_0.handlePixelActivated(typedEvent);
    charFeature_7.handlePixelActivated(typedEvent);
    charFeature_8.handlePixelActivated(typedEvent);
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
  public void batchEnd() {
    classifier.findBestMatch();
    charFeature_8.endOfBatch();
    charFeature_7.endOfBatch();
    charFeature_0.endOfBatch();
    charFeature_c.endOfBatch();
    charFeature_b.endOfBatch();
    charFeature_a.endOfBatch();
  }
}
