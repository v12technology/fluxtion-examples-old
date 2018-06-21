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
public final class MultiKeyFor_TrackPlaySummary_9 implements MultiKey<MultiKeyFor_TrackPlaySummary_9> {

    private String getIsrc7;
    private String getTerritory8;

    public void setKey(TrackStream source){
        getIsrc7 = source.getIsrc();
        getTerritory8 = source.getTerritory();
    }

    @Override
    public void reset(){
        getIsrc7 = null;
        getTerritory8 = null;
    }

    @Override
    public MultiKeyFor_TrackPlaySummary_9 copyInto(MultiKeyFor_TrackPlaySummary_9 copy){
        copy.getIsrc7 = getIsrc7;
        copy.getTerritory8 = getTerritory8;
        return copy;
    }

    @Override
    public MultiKeyFor_TrackPlaySummary_9 copyKey(){
        return copyInto(new MultiKeyFor_TrackPlaySummary_9());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getIsrc7 == null ? 0 : getIsrc7.hashCode());
        result = 31 * result + (getTerritory8 == null ? 0 : getTerritory8.hashCode());
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
        final MultiKeyFor_TrackPlaySummary_9 other = (MultiKeyFor_TrackPlaySummary_9) obj;
        if(!((this.getIsrc7 == other.getIsrc7) 
            || (this.getIsrc7 != null && this.getIsrc7.equals(other.getIsrc7)))){
            return false;
        }
        if(!((this.getTerritory8 == other.getTerritory8) 
            || (this.getTerritory8 != null && this.getTerritory8.equals(other.getTerritory8)))){
            return false;
        }
        return true;
    }
}
