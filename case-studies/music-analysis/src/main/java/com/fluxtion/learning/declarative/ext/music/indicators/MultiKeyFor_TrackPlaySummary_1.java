package com.fluxtion.learning.declarative.ext.music.indicators;

import com.fluxtion.learning.declarative.ext.music.indicators.*;
import com.fluxtion.extension.declarative.api.numeric.MutableNumericValue;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.extension.declarative.api.group.MultiKey;

/**
 * generated multi key class for use with GroupBy functionality
 *
 * source class  : TrackStream
 * 
 * @author Greg Higgins
 */
public final class MultiKeyFor_TrackPlaySummary_1 implements MultiKey<MultiKeyFor_TrackPlaySummary_1> {

    private String getIsrc0;

    public void setKey(TrackStream source){
        getIsrc0 = source.getIsrc();
    }

    @Override
    public void reset(){
        getIsrc0 = null;
    }

    @Override
    public MultiKeyFor_TrackPlaySummary_1 copyInto(MultiKeyFor_TrackPlaySummary_1 copy){
        copy.getIsrc0 = getIsrc0;
        return copy;
    }

    @Override
    public MultiKeyFor_TrackPlaySummary_1 copyKey(){
        return copyInto(new MultiKeyFor_TrackPlaySummary_1());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getIsrc0 == null ? 0 : getIsrc0.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MultiKeyFor_TrackPlaySummary_1 other = (MultiKeyFor_TrackPlaySummary_1) obj;
        if(!((this.getIsrc0 == other.getIsrc0) 
            || (this.getIsrc0 != null && this.getIsrc0.equals(other.getIsrc0)))){
            return false;
        }
        return true;
    }
}
