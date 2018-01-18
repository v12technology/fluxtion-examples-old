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
public final class MultiKeyFromTrackStream_9 implements MultiKey<MultiKeyFromTrackStream_9, TrackStream> {

    private String getIsrc7;
    private String getTerritory8;

    @Override
    public void setKey(TrackStream source) {
        getIsrc7 = source.getIsrc();
        getTerritory8 = source.getTerritory();
    }

    @Override
    public void reset() {
        getIsrc7 = null;
        getTerritory8 = null;
    }

    @Override
    public MultiKeyFromTrackStream_9 copyInto(MultiKeyFromTrackStream_9 copy) {
        copy.getIsrc7 = getIsrc7;
        copy.getTerritory8 = getTerritory8;
        return copy;
    }

    @Override
    public MultiKeyFromTrackStream_9 copyKey() {
        return copyInto(new MultiKeyFromTrackStream_9());
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
        final MultiKeyFromTrackStream_9 other = (MultiKeyFromTrackStream_9) obj;
        if (!((this.getIsrc7 == other.getIsrc7)
                || (this.getIsrc7 != null && this.getIsrc7.equals(other.getIsrc7)))) {
            return false;
        }
        if (!((this.getTerritory8 == other.getTerritory8)
                || (this.getTerritory8 != null && this.getTerritory8.equals(other.getTerritory8)))) {
            return false;
        }
        return true;
    }
}
