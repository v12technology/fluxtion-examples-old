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
public final class MultiKeyFor_TrackPlaySummary_17 implements MultiKey<MultiKeyFor_TrackPlaySummary_17> {

    private String getIsrc15;
    private String getVendor_identifier16;

    public void setKey(TrackStream source){
        getIsrc15 = source.getIsrc();
        getVendor_identifier16 = source.getVendor_identifier();
    }

    @Override
    public void reset(){
        getIsrc15 = null;
        getVendor_identifier16 = null;
    }

    @Override
    public MultiKeyFor_TrackPlaySummary_17 copyInto(MultiKeyFor_TrackPlaySummary_17 copy){
        copy.getIsrc15 = getIsrc15;
        copy.getVendor_identifier16 = getVendor_identifier16;
        return copy;
    }

    @Override
    public MultiKeyFor_TrackPlaySummary_17 copyKey(){
        return copyInto(new MultiKeyFor_TrackPlaySummary_17());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getIsrc15 == null ? 0 : getIsrc15.hashCode());
        result = 31 * result + (getVendor_identifier16 == null ? 0 : getVendor_identifier16.hashCode());
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
        final MultiKeyFor_TrackPlaySummary_17 other = (MultiKeyFor_TrackPlaySummary_17) obj;
        if(!((this.getIsrc15 == other.getIsrc15) 
            || (this.getIsrc15 != null && this.getIsrc15.equals(other.getIsrc15)))){
            return false;
        }
        if(!((this.getVendor_identifier16 == other.getVendor_identifier16) 
            || (this.getVendor_identifier16 != null && this.getVendor_identifier16.equals(other.getVendor_identifier16)))){
            return false;
        }
        return true;
    }
}
