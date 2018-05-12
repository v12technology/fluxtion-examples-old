package com.fluxtion.casestudy.flightdelay.generated.csv2;

import com.fluxtion.extension.declarative.funclib.api.csv.RowProcessor;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import java.util.HashMap;
import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.extension.declarative.api.Wrapper;

/**
 * generated CSV marshaller wrapper.
 *
 * target class  : FlightDetails
 * 
 * @author Greg Higgins
 */

public class FlightDetailsCsvMarshaller0 implements RowProcessor<FlightDetails> {

    //buffer management
    private final char[] chars = new char[4096];
    private final int[] delimIndex = new int[1024];
    private int writeIndex = 0;
    private int fieldIndex = 0;
    //target
    private FlightDetails target;
    //source field index: 14
    private final StringBuilder setDelayString = new StringBuilder();
    private final int fieldIndex_14 = 14;
    //source field index: 8
    private final StringBuilder setCarrier = new StringBuilder();
    private final int fieldIndex_8 = 8;
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
        extractCharSequence(setDelayString, fieldIndex_14);
        extractCharSequence(setCarrier, fieldIndex_8);
        //target
        return pushData();
    }

    private void updateFieldIndex() {
        fieldIndex++;
        delimIndex[fieldIndex] = writeIndex + 1;
    }

    private boolean pushData(){
        try{
            fieldIndex = fieldIndex_14;
            target.setDelayString(setDelayString);
            fieldIndex = fieldIndex_8;
            target.setCarrier(setCarrier.toString());
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
    public FlightDetails event() {
        return target;
    }

    @Override
    public Class<FlightDetails> eventClass() {
        return FlightDetails.class;
    }

    @Initialise
    public void init(){
        target = new FlightDetails();
        fieldMap.put(fieldIndex_14, "setDelayString");
        fieldMap.put(fieldIndex_8, "setCarrier");
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


