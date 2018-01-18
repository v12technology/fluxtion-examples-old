package com.fluxtion.learning.declarative.ext.music.indicators;

import com.fluxtion.extension.declarative.api.numeric.MutableNumericValue;
import com.fluxtion.extension.declarative.api.group.MultiKey;
import com.fluxtion.learning.declarative.ext.music.TrackStream;

/**
 * generated multi key class for use with GroupBy functionality
 *
 * source class : TrackStream
 *
 * @author Greg Higgins
 */
public final class MultiKeyFromTrackStream_26 implements MultiKey<MultiKeyFromTrackStream_26, TrackStream> {

    private String getIsrc23;
    private String getVendor_identifier24;
    private String getTerritory25;

    @Override
    public void setKey(TrackStream source) {
        getIsrc23 = source.getIsrc();
        getVendor_identifier24 = source.getVendor_identifier();
        getTerritory25 = source.getTerritory();
    }

    @Override
    public void reset() {
        getIsrc23 = null;
        getVendor_identifier24 = null;
        getTerritory25 = null;
    }

    @Override
    public MultiKeyFromTrackStream_26 copyInto(MultiKeyFromTrackStream_26 copy) {
        copy.getIsrc23 = getIsrc23;
        copy.getVendor_identifier24 = getVendor_identifier24;
        copy.getTerritory25 = getTerritory25;
        return copy;
    }

    @Override
    public MultiKeyFromTrackStream_26 copyKey() {
        return copyInto(new MultiKeyFromTrackStream_26());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getIsrc23 == null ? 0 : getIsrc23.hashCode());
        result = 31 * result + (getVendor_identifier24 == null ? 0 : getVendor_identifier24.hashCode());
        result = 31 * result + (getTerritory25 == null ? 0 : getTerritory25.hashCode());
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
        final MultiKeyFromTrackStream_26 other = (MultiKeyFromTrackStream_26) obj;
        if (!((this.getIsrc23 == other.getIsrc23)
                || (this.getIsrc23 != null && this.getIsrc23.equals(other.getIsrc23)))) {
            return false;
        }
        if (!((this.getVendor_identifier24 == other.getVendor_identifier24)
                || (this.getVendor_identifier24 != null && this.getVendor_identifier24.equals(other.getVendor_identifier24)))) {
            return false;
        }
        if (!((this.getTerritory25 == other.getTerritory25)
                || (this.getTerritory25 != null && this.getTerritory25.equals(other.getTerritory25)))) {
            return false;
        }
        return true;
    }
}
