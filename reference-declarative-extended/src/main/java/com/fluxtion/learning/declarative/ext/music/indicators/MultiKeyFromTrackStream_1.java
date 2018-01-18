package com.fluxtion.learning.declarative.ext.music.indicators;

import com.fluxtion.extension.declarative.api.numeric.MutableNumericValue;
import com.fluxtion.extension.declarative.api.group.MultiKey;
import com.fluxtion.learning.declarative.ext.music.TrackStream;

/**
 * generated multi key class for use with GroupBy functionality
 *
 * source class  : TrackStream
 * 
 * @author Greg Higgins
 */
public final class MultiKeyFromTrackStream_1 implements MultiKey<MultiKeyFromTrackStream_1, TrackStream>{

    private String getIsrc0;

    @Override
    public void setKey(TrackStream source){
        getIsrc0 = source.getIsrc();
    }

    @Override
    public void reset(){
        getIsrc0 = null;
    }

    @Override
    public MultiKeyFromTrackStream_1 copyInto(MultiKeyFromTrackStream_1 copy){
        copy.getIsrc0 = getIsrc0;
        return copy;
    }

    @Override
    public MultiKeyFromTrackStream_1 copyKey(){
        return copyInto(new MultiKeyFromTrackStream_1());
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
        final MultiKeyFromTrackStream_1 other = (MultiKeyFromTrackStream_1) obj;
        if(!((this.getIsrc0 == other.getIsrc0) 
            || (this.getIsrc0 != null && this.getIsrc0.equals(other.getIsrc0)))){
            return false;
        }
        return true;
    }
}
