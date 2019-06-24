package com.fluxtion.learning.declarative.ext.music.csv;

import com.fluxtion.learning.declarative.ext.music.csv.*;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.learning.declarative.ext.music.TrackStream;
import com.fluxtion.extension.declarative.funclib.api.csv.RowProcessor;
import java.util.HashMap;
import com.fluxtion.api.annotations.EventHandler;
import static com.fluxtion.extension.declarative.funclib.api.ascii.Conversion.*;

/**
 * generated CSV marshaller wrapper.
 *
 * target class  : TrackStream
 * 
 * @author Greg Higgins
 */

public class TrackStreamCsvMarshaller0 implements RowProcessor<TrackStream> {

    //buffer management
    private final char[] chars = new char[4096];
    private final int[] delimIndex = new int[1024];
    private int fieldIndex = 0;
    private int writeIndex = 0;
    //target
    private TrackStream target;
    //source field index: 0
    private final StringBuilder setDateString = new StringBuilder();
    private final int fieldIndex_0 = 0;
    //source field index: 1
    private final StringBuilder setIsrc = new StringBuilder();
    private final int fieldIndex_1 = 1;
    //source field index: 2
    private final StringBuilder setTrack_artists = new StringBuilder();
    private final int fieldIndex_2 = 2;
    //source field index: 3
    private final StringBuilder setTrack_title = new StringBuilder();
    private final int fieldIndex_3 = 3;
    //source field index: 4
    private final StringBuilder setTerritory = new StringBuilder();
    private final int fieldIndex_4 = 4;
    //source field index: 5
    private final StringBuilder setVendor_identifier = new StringBuilder();
    private final int fieldIndex_5 = 5;
    //source field index: 6
    private final StringBuilder setStreams = new StringBuilder();
    private final int fieldIndex_6 = 6;
    //processing state and meta-data
    private int rowNumber;
    private final HashMap fieldMap = new HashMap<>();
    private static final int HEADER_ROWS = 1;
    private boolean passedValidation;

    @EventHandler
    public boolean charEvent(CharEvent event) {
        final char character = event.getCharacter();
        passedValidation = true;
        if (character == '\n') {
            return processRow();
        }
        if (character == ',') {
            updateFieldIndex();
        }
        chars[writeIndex++] = character;
        return false;
    }

    private boolean processRow() {
        boolean targetChanged = false;
        rowNumber++;
        if (HEADER_ROWS < rowNumber) {
            //updateTarget();
            targetChanged = updateTarget();
        } 
        writeIndex = 0;
        fieldIndex = 0;
        return targetChanged;
    }

    private boolean updateTarget() {
        updateFieldIndex();
        extractCharSequence(setDateString, fieldIndex_0);
        extractCharSequence(setIsrc, fieldIndex_1);
        extractCharSequence(setTrack_artists, fieldIndex_2);
        extractCharSequence(setTrack_title, fieldIndex_3);
        extractCharSequence(setTerritory, fieldIndex_4);
        extractCharSequence(setVendor_identifier, fieldIndex_5);
        extractCharSequence(setStreams, fieldIndex_6);
        //target
        return pushData();
    }

    private void updateFieldIndex() {
        fieldIndex++;
        delimIndex[fieldIndex] = writeIndex + 1;
    }

    private boolean pushData(){
        try{
            fieldIndex = fieldIndex_0;
            target.setDateString(setDateString.toString());
            fieldIndex = fieldIndex_1;
            target.setIsrc(setIsrc.toString());
            fieldIndex = fieldIndex_2;
            target.setTrack_artists(setTrack_artists.toString());
            fieldIndex = fieldIndex_3;
            target.setTrack_title(setTrack_title.toString());
            fieldIndex = fieldIndex_4;
            target.setTerritory(setTerritory.toString());
            fieldIndex = fieldIndex_5;
            target.setVendor_identifier(setVendor_identifier.toString());
            fieldIndex = fieldIndex_6;
            target.setStreams(atoi(setStreams));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("problem pushing data from row:" + rowNumber 
                                        + " fieldIndex:" + fieldIndex 
                                        + " targetMethod:" + fieldMap.get(fieldIndex), e);
        } finally {
            fieldIndex = 0;
        }
    }

    private final void extractCharSequence(StringBuilder source, int fieldIndex){
        try {
            source.setLength(0);
            source.append(chars, delimIndex[fieldIndex], delimIndex[fieldIndex + 1] - delimIndex[fieldIndex] - 1);
        } catch (Exception e) {
            throw new RuntimeException("problem extracting value from row:" + rowNumber
                    + " fieldIndex:" + fieldIndex
                    + " targetMethod:" + fieldMap.get(fieldIndex), e);
        }
    }

    private final void extractTrimmedCharSequence(StringBuilder source, int fieldIndex) {
        try {
            source.setLength(0);
            int len = delimIndex[fieldIndex + 1] - delimIndex[fieldIndex] - 1;
            int st = delimIndex[fieldIndex];
            char[] val = chars;
            while ((st < len) && (val[st] <= ' ')) {
                st++;
            }
            while ((st < len) && (val[len - 1] <= ' ')) {
                len--;
            }
            if (st != delimIndex[fieldIndex]) {
                len -= st;
            }
            source.append(chars, st, len);
        } catch (Exception e) {
            throw new RuntimeException("problem extracting value from row:" + rowNumber
                    + " fieldIndex:" + fieldIndex
                    + " targetMethod:" + fieldMap.get(fieldIndex), e);
        }
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
        fieldMap.put(fieldIndex_0, "setDateString");
        fieldMap.put(fieldIndex_1, "setIsrc");
        fieldMap.put(fieldIndex_2, "setTrack_artists");
        fieldMap.put(fieldIndex_3, "setTrack_title");
        fieldMap.put(fieldIndex_4, "setTerritory");
        fieldMap.put(fieldIndex_5, "setVendor_identifier");
        fieldMap.put(fieldIndex_6, "setStreams");
    }

    @Override
    public int rowCount() {
        return rowNumber;
    }

    @Override
    public boolean passedValidation() {
        return passedValidation;
    }

    @Override
    public char eolChar() {
        return '\n';
    }
}


