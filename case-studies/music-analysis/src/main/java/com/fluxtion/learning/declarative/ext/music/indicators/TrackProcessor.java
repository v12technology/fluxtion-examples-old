package com.fluxtion.learning.declarative.ext.music.indicators;

import com.fluxtion.learning.declarative.ext.music.indicators.*;
import com.fluxtion.runtime.lifecycle.BatchHandler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import com.fluxtion.learning.declarative.ext.music.util.BollingerPublisher;
import com.fluxtion.learning.declarative.ext.music.TwitterFeed;
import com.fluxtion.learning.declarative.ext.music.SentimentAnalyser;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.learning.declarative.ext.music.Tweet;
import com.fluxtion.learning.declarative.ext.music.util.EodEvent;

public class TrackProcessor implements EventHandler, BatchHandler, Lifecycle {

//Node declarations
    public final GroupBy_14 trackAndTerritoryByDate = new GroupBy_14();
    public final GroupBy_31 trackAndVendorAndTerritoryByDate = new GroupBy_31();
    public final GroupBy_22 trackAndVendorByDate = new GroupBy_22();
    public final GroupBy_6 trackByDate = new GroupBy_6();
    public final BollingerPublisher trackAnalyser = new BollingerPublisher(trackByDate, "track");
    public final BollingerPublisher trackTerritoryAnalyser = new BollingerPublisher(trackAndTerritoryByDate, "track_territory");
    public final BollingerPublisher trackVendorAnalyser = new BollingerPublisher(trackAndVendorByDate, "track_vendor");
    public final BollingerPublisher trackVendorTerritoryAnalyser = new BollingerPublisher(trackAndVendorAndTerritoryByDate, "track_vendor_territory");
    private final TwitterFeed twitterFeed_1 = new TwitterFeed();
    public final SentimentAnalyser sentimentAnalyser = new SentimentAnalyser(twitterFeed_1, trackAnalyser);
//Dirty flags
    private boolean isDirty_trackAndTerritoryByDate = false;
    private boolean isDirty_trackAndVendorAndTerritoryByDate = false;
    private boolean isDirty_trackByDate = false;
    private boolean isDirty_trackAndVendorByDate = false;
//Filter constants

    public TrackProcessor() {
        trackAnalyser.territory = (boolean) false;
        trackAnalyser.vendor = (boolean) false;
        trackTerritoryAnalyser.territory = (boolean) true;
        trackTerritoryAnalyser.vendor = (boolean) false;
        trackVendorAnalyser.territory = (boolean) false;
        trackVendorAnalyser.vendor = (boolean) true;
        trackVendorTerritoryAnalyser.territory = (boolean) true;
        trackVendorTerritoryAnalyser.vendor = (boolean) true;
    }

    @Override
    public void onEvent(com.fluxtion.runtime.event.Event event) {
        switch (event.getClass().getName()) {
            case ("com.fluxtion.learning.declarative.ext.music.TrackStream"): {
                TrackStream typedEvent = (TrackStream) event;
                handleEvent(typedEvent);
                break;
            }
            case ("com.fluxtion.learning.declarative.ext.music.Tweet"): {
                Tweet typedEvent = (Tweet) event;
                handleEvent(typedEvent);
                break;
            }
            case ("com.fluxtion.learning.declarative.ext.music.util.EodEvent"): {
                EodEvent typedEvent = (EodEvent) event;
                handleEvent(typedEvent);
                break;
            }
        }

    }

    public void handleEvent(TrackStream typedEvent) {
        //Default, no filter methods
        isDirty_trackAndTerritoryByDate = trackAndTerritoryByDate.updatetrackStream0(typedEvent);
        isDirty_trackAndVendorAndTerritoryByDate = trackAndVendorAndTerritoryByDate.updatetrackStream0(typedEvent);
        isDirty_trackAndVendorByDate = trackAndVendorByDate.updatetrackStream0(typedEvent);
        isDirty_trackByDate = trackByDate.updatetrackStream0(typedEvent);
        sentimentAnalyser.calculateSentiment();
        //event stack unwind callbacks
        afterEvent();
    }

    public void handleEvent(Tweet typedEvent) {
        //Default, no filter methods
        twitterFeed_1.tweet(typedEvent);
        sentimentAnalyser.calculateSentiment();
        //event stack unwind callbacks
        afterEvent();
    }

    public void handleEvent(EodEvent typedEvent) {
        //Default, no filter methods
        trackAnalyser.eod(typedEvent);
        trackTerritoryAnalyser.eod(typedEvent);
        trackVendorAnalyser.eod(typedEvent);
        trackVendorTerritoryAnalyser.eod(typedEvent);
        sentimentAnalyser.calculateSentiment();
        //event stack unwind callbacks
        afterEvent();
    }

    @Override
    public void afterEvent() {

        isDirty_trackAndTerritoryByDate = false;
        isDirty_trackAndVendorAndTerritoryByDate = false;
        isDirty_trackByDate = false;
        isDirty_trackAndVendorByDate = false;
    }

    @Override
    public void init() {
        trackAndTerritoryByDate.init();
        trackAndVendorAndTerritoryByDate.init();
        trackAndVendorByDate.init();
        trackByDate.init();
    }

    @Override
    public void tearDown() {

    }

    @Override
    public void batchPause() {

    }

    @Override
    public void batchEnd() {

    }

}
