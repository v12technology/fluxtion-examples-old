package com.fluxtion.learning.example24.generated;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.example20.CharClassifierConfigProcessor;
import com.fluxtion.learning.example20.CharacterMatrixFeature;
import com.fluxtion.learning.example20.CharacterClassifier;
import com.fluxtion.learning.example20.CharClassifierConfigEvent;
import com.fluxtion.learning.example20.PixelActivationEvent;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;

public class ScreenProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final CharClassifierConfigProcessor configProcessor_0 =
      new CharClassifierConfigProcessor();
  private final CharacterMatrixFeature charFeature_0 = new CharacterMatrixFeature();
  private final CharClassifierConfigProcessor configProcessor_7 =
      new CharClassifierConfigProcessor();
  private final CharacterMatrixFeature charFeature_7 = new CharacterMatrixFeature();
  private final CharClassifierConfigProcessor configProcessor_8 =
      new CharClassifierConfigProcessor();
  private final CharacterMatrixFeature charFeature_8 = new CharacterMatrixFeature();
  private final CharClassifierConfigProcessor configProcessor_a =
      new CharClassifierConfigProcessor();
  private final CharacterMatrixFeature charFeature_a = new CharacterMatrixFeature();
  private final CharClassifierConfigProcessor configProcessor_b =
      new CharClassifierConfigProcessor();
  private final CharacterMatrixFeature charFeature_b = new CharacterMatrixFeature();
  private final CharClassifierConfigProcessor configProcessor_c =
      new CharClassifierConfigProcessor();
  private final CharacterMatrixFeature charFeature_c = new CharacterMatrixFeature();
  public final CharacterClassifier classifier = new CharacterClassifier();
  //Dirty flags

  //Filter constants
  public static final int char_0 = 48;
  public static final int char_7 = 55;
  public static final int char_8 = 56;
  public static final int char_a = 97;
  public static final int char_b = 98;
  public static final int char_c = 99;

  public ScreenProcessor() {
    charFeature_0.config = configProcessor_0;
    charFeature_0.matchingChar = '0';
    charFeature_7.config = configProcessor_7;
    charFeature_7.matchingChar = '7';
    charFeature_8.config = configProcessor_8;
    charFeature_8.matchingChar = '8';
    charFeature_a.config = configProcessor_a;
    charFeature_a.matchingChar = 'a';
    charFeature_b.config = configProcessor_b;
    charFeature_b.matchingChar = 'b';
    charFeature_c.config = configProcessor_c;
    charFeature_c.matchingChar = 'c';
    classifier.charMatchSet = new CharacterMatrixFeature[6];
    classifier.charMatchSet[0] = charFeature_a;
    classifier.charMatchSet[1] = charFeature_b;
    classifier.charMatchSet[2] = charFeature_c;
    classifier.charMatchSet[3] = charFeature_0;
    classifier.charMatchSet[4] = charFeature_7;
    classifier.charMatchSet[5] = charFeature_8;
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
    FilteredHandlerInvoker invoker =
        dispatchIntMapCharClassifierConfigEvent.get(typedEvent.filterId());
    if (invoker != null) {
      invoker.invoke(typedEvent);
      afterEvent();
      return;
    }
    afterEvent();
  }

  public void handleEvent(PixelActivationEvent typedEvent) {
    //Default, no filter methods
    charFeature_0.handlePixelActivated(typedEvent);
    charFeature_7.handlePixelActivated(typedEvent);
    charFeature_8.handlePixelActivated(typedEvent);
    charFeature_a.handlePixelActivated(typedEvent);
    charFeature_b.handlePixelActivated(typedEvent);
    charFeature_c.handlePixelActivated(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }
  //int filter maps
  private final Int2ObjectOpenHashMap<FilteredHandlerInvoker>
      dispatchIntMapCharClassifierConfigEvent = initdispatchIntMapCharClassifierConfigEvent();

  //String filter maps
  private Int2ObjectOpenHashMap<FilteredHandlerInvoker>
      initdispatchIntMapCharClassifierConfigEvent() {
    Int2ObjectOpenHashMap<FilteredHandlerInvoker> dispatchMap = new Int2ObjectOpenHashMap<>();
    dispatchMap.put(
        48,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharClassifierConfigEvent_char_0(
                (com.fluxtion.learning.example20.CharClassifierConfigEvent) event);
          }
        });
    dispatchMap.put(
        55,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharClassifierConfigEvent_char_7(
                (com.fluxtion.learning.example20.CharClassifierConfigEvent) event);
          }
        });
    dispatchMap.put(
        56,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharClassifierConfigEvent_char_8(
                (com.fluxtion.learning.example20.CharClassifierConfigEvent) event);
          }
        });
    dispatchMap.put(
        97,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharClassifierConfigEvent_char_a(
                (com.fluxtion.learning.example20.CharClassifierConfigEvent) event);
          }
        });
    dispatchMap.put(
        98,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharClassifierConfigEvent_char_b(
                (com.fluxtion.learning.example20.CharClassifierConfigEvent) event);
          }
        });
    dispatchMap.put(
        99,
        new FilteredHandlerInvoker() {

          @Override
          public void invoke(Object event) {
            handle_CharClassifierConfigEvent_char_c(
                (com.fluxtion.learning.example20.CharClassifierConfigEvent) event);
          }
        });
    return dispatchMap;
  }

  private void handle_CharClassifierConfigEvent_char_0(
      com.fluxtion.learning.example20.CharClassifierConfigEvent typedEvent) {
    //method body - invoke call tree
    configProcessor_0.configureValues(typedEvent);
    charFeature_0.configUpdate(configProcessor_0);
  }

  private void handle_CharClassifierConfigEvent_char_7(
      com.fluxtion.learning.example20.CharClassifierConfigEvent typedEvent) {
    //method body - invoke call tree
    configProcessor_7.configureValues(typedEvent);
    charFeature_7.configUpdate(configProcessor_7);
  }

  private void handle_CharClassifierConfigEvent_char_8(
      com.fluxtion.learning.example20.CharClassifierConfigEvent typedEvent) {
    //method body - invoke call tree
    configProcessor_8.configureValues(typedEvent);
    charFeature_8.configUpdate(configProcessor_8);
  }

  private void handle_CharClassifierConfigEvent_char_a(
      com.fluxtion.learning.example20.CharClassifierConfigEvent typedEvent) {
    //method body - invoke call tree
    configProcessor_a.configureValues(typedEvent);
    charFeature_a.configUpdate(configProcessor_a);
  }

  private void handle_CharClassifierConfigEvent_char_b(
      com.fluxtion.learning.example20.CharClassifierConfigEvent typedEvent) {
    //method body - invoke call tree
    configProcessor_b.configureValues(typedEvent);
    charFeature_b.configUpdate(configProcessor_b);
  }

  private void handle_CharClassifierConfigEvent_char_c(
      com.fluxtion.learning.example20.CharClassifierConfigEvent typedEvent) {
    //method body - invoke call tree
    configProcessor_c.configureValues(typedEvent);
    charFeature_c.configUpdate(configProcessor_c);
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
    charFeature_c.endOfBatch();
    charFeature_b.endOfBatch();
    charFeature_a.endOfBatch();
    charFeature_8.endOfBatch();
    charFeature_7.endOfBatch();
    charFeature_0.endOfBatch();
  }
}
