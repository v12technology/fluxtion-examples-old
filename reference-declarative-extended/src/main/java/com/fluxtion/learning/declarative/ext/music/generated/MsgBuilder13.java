package com.fluxtion.learning.declarative.ext.music.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder13 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.learning.declarative.ext.music.generated.TrackStreamCsvMarshaller7 source_TrackStreamCsvMarshaller7_12;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("processing track:");
        msgSink.append(((com.fluxtion.learning.declarative.ext.music.TrackStream)source_TrackStreamCsvMarshaller7_12.event()).getTrack_title());
        msgSink.append("");
        msgSink.append('\n');
        return true;
    }
}

