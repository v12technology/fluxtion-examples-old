package com.fluxtion.learning.example9.generated;

import java.util.HashMap;

import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.FilteredHandlerInvoker;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import com.fluxtion.learning.example9.NewsAnalyser;
import java.lang.String;
import com.fluxtion.learning.example9.WordEvent;

public class NewsProcessor implements EventHandler, BatchHandler, Lifecycle {

  //Node declarations
  private final NewsAnalyser newsAnalyser_1 = new NewsAnalyser();
  //Dirty flags

  //Filter constants

  public NewsProcessor() {
    //newsAnalyser_1
    newsAnalyser_1.positieImpactMatch = new String[3];
    newsAnalyser_1.positieImpactMatch[0] = "IT";
    newsAnalyser_1.positieImpactMatch[1] = "ram";
    newsAnalyser_1.positieImpactMatch[2] = "CEP";
    newsAnalyser_1.negativeImpactMatch = new String[2];
    newsAnalyser_1.negativeImpactMatch[0] = "picasso";
    newsAnalyser_1.negativeImpactMatch[1] = "escapoligist";
    newsAnalyser_1.subject = "computing";
    newsAnalyser_1.weights = new int[2];
    newsAnalyser_1.weights[0] = 33;
    newsAnalyser_1.weights[1] = 68;
    newsAnalyser_1.barrier = (int) 400;
  }

  @Override
  public void onEvent(com.fluxtion.runtime.event.Event event) {
    switch (event.getClass().getName()) {
      case ("com.fluxtion.learning.example9.WordEvent"):
        {
          WordEvent typedEvent = (WordEvent) event;
          handleEvent(typedEvent);
          break;
        }
    }
  }

  public void handleEvent(WordEvent typedEvent) {
    //Default, no filter methods
    newsAnalyser_1.processWord(typedEvent);
    //event stack unwind callbacks
    afterEvent();
  }

  @Override
  public void afterEvent() {}

  @Override
  public void init() {
    newsAnalyser_1.initMatchSets();
  }

  @Override
  public void tearDown() {
    newsAnalyser_1.outputSemanticRating();
  }

  @Override
  public void batchPause() {}

  @Override
  public void batchEnd() {}
}
