package com.fluxtion.learning.declarative.ext.music.csv;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;

/**
 * generated Test wrapper.
 *
 * target class  : TrackStream
 * 
 * @author Greg Higgins
 */

public class TrackStreamCsvMarshaller7 implements Wrapper<TrackStream> {

    private TrackStream target;
    public Csv2ByteBuffer csvSrc_0;
    public Csv2ByteBuffer csvSrc_1;
    public Csv2ByteBuffer csvSrc_2;
    public Csv2ByteBuffer csvSrc_3;
    public Csv2ByteBuffer csvSrc_4;
    public Csv2ByteBuffer csvSrc_5;
    public Csv2Double csvSrc_6;

    @EventHandler(filterId = '\n')
    public boolean onEol(CharEvent event) {
        target.setDateString((java.lang.String) csvSrc_0.asString());
        target.setIsrc((java.lang.String) csvSrc_1.asString());
        target.setTrack_artists((java.lang.String) csvSrc_2.asString());
        target.setTrack_title((java.lang.String) csvSrc_3.asString());
        target.setTerritory((java.lang.String) csvSrc_4.asString());
        target.setVendor_identifier((java.lang.String) csvSrc_5.asString());
        target.setStreams((int) csvSrc_6.doubleValue());
        return true;
    }

    @Override
    public TrackStream event() {
        return target;
    }

    @Override
    public Class<TrackStream> eventClass() {
        return TrackStream.class;
    }

    @Initialise
    public void init(){
        target = new TrackStream();
    }

}


