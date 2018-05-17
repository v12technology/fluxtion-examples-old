package com.fluxtion.casestudy.worldcity.generated.csv;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.casestudy.worldcity.WorldCity;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.funclib.api.csv.RowProcessor;
import java.util.HashMap;

/**
 * generated CSV marshaller wrapper.
 *
 * target class  : WorldCity
 * 
 * @author Greg Higgins
 */

public class WorldCityCsvMarshaller0 implements RowProcessor<WorldCity> {

    //buffer management
    private final char[] chars = new char[4096];
    private final int[] delimIndex = new int[1024];
    private int fieldIndex = 0;
    private int writeIndex = 0;
    //target
    private WorldCity target;
    //source field index: 0
    private final StringBuilder setCountry = new StringBuilder();
    private final int fieldIndex_0 = 0;
    //source field index: 1
    private final StringBuilder setCity = new StringBuilder();
    private final int fieldIndex_1 = 1;
    //source field index: 2
    private final StringBuilder setAccentCity = new StringBuilder();
    private final int fieldIndex_2 = 2;
    //source field index: 3
    private final StringBuilder setRegion = new StringBuilder();
    private final int fieldIndex_3 = 3;
    //source field index: 4
    private final StringBuilder setPopulation = new StringBuilder();
    private final int fieldIndex_4 = 4;
    //source field index: 5
    private final StringBuilder setLongitude = new StringBuilder();
    private final int fieldIndex_5 = 5;
    //source field index: 6
    private final StringBuilder setLatitude = new StringBuilder();
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
        extractCharSequence(setCountry, fieldIndex_0);
        extractCharSequence(setCity, fieldIndex_1);
        extractCharSequence(setAccentCity, fieldIndex_2);
        extractCharSequence(setRegion, fieldIndex_3);
        extractCharSequence(setPopulation, fieldIndex_4);
        extractCharSequence(setLongitude, fieldIndex_5);
        extractCharSequence(setLatitude, fieldIndex_6);
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
            target.setCountry(setCountry);
            fieldIndex = fieldIndex_1;
            target.setCity(setCity);
            fieldIndex = fieldIndex_2;
            target.setAccentCity(setAccentCity);
            fieldIndex = fieldIndex_3;
            target.setRegion(setRegion);
            fieldIndex = fieldIndex_4;
            target.setPopulation(setPopulation);
            fieldIndex = fieldIndex_5;
            target.setLongitude(setLongitude);
            fieldIndex = fieldIndex_6;
            target.setLatitude(setLatitude);
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
    public WorldCity event() {
        return target;
    }

    @Override
    public Class<WorldCity> eventClass() {
        return WorldCity.class;
    }

    @Initialise
    public void init(){
        target = new WorldCity();
        fieldMap.put(fieldIndex_0, "setCountry");
        fieldMap.put(fieldIndex_1, "setCity");
        fieldMap.put(fieldIndex_2, "setAccentCity");
        fieldMap.put(fieldIndex_3, "setRegion");
        fieldMap.put(fieldIndex_4, "setPopulation");
        fieldMap.put(fieldIndex_5, "setLongitude");
        fieldMap.put(fieldIndex_6, "setLatitude");
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


