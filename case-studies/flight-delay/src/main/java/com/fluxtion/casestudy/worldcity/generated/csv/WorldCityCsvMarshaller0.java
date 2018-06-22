package com.fluxtion.casestudy.worldcity.generated.csv;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import com.fluxtion.extension.declarative.funclib.api.csv.RowProcessor;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.casestudy.worldcity.WorldCity;
import java.util.List;

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
    private final StringBuilder setAccentCity = new StringBuilder();
    private int fieldName_accentCity = 0;
    //source field index: 0
    private final StringBuilder setCity = new StringBuilder();
    private int fieldName_city = 0;
    //source field index: 0
    private final StringBuilder setCountry = new StringBuilder();
    private int fieldName_country = 0;
    //source field index: 0
    private final StringBuilder setLatitude = new StringBuilder();
    private int fieldName_latitude = 0;
    //source field index: 0
    private final StringBuilder setLongitude = new StringBuilder();
    private int fieldName_longitude = 0;
    //source field index: 0
    private final StringBuilder setPopulation = new StringBuilder();
    private int fieldName_population = 0;
    //source field index: 0
    private final StringBuilder setRegion = new StringBuilder();
    private int fieldName_region = 0;
    //processing state and meta-data
    private int rowNumber;
    private final HashMap fieldMap = new HashMap<>();
    private static final int HEADER_ROWS = 1;
    private static final int MAPPING_ROW = 1;
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
        } else if(rowNumber==MAPPING_ROW){
            mapHeader();
        } 
        writeIndex = 0;
        fieldIndex = 0;
        return targetChanged;
    }

    private void mapHeader(){
        String header = new String(chars).trim();
        //List<String> headers = Arrays.asList(header.split(","));

        List<String> headers = new ArrayList();
        for (String colName : header.split(",")) {
            char c[] = colName.trim().toCharArray();
            c[0] = Character.toLowerCase(c[0]);
            headers.add(new String(c));
        }


        fieldName_accentCity = headers.indexOf("accentCity");
        fieldMap.put(fieldName_accentCity, "setAccentCity");
        if (fieldName_accentCity < 0) {
            throw new RuntimeException("problem mapping field:'accentCity' index row:" + rowNumber);
        }
        fieldName_city = headers.indexOf("city");
        fieldMap.put(fieldName_city, "setCity");
        if (fieldName_city < 0) {
            throw new RuntimeException("problem mapping field:'city' index row:" + rowNumber);
        }
        fieldName_country = headers.indexOf("country");
        fieldMap.put(fieldName_country, "setCountry");
        if (fieldName_country < 0) {
            throw new RuntimeException("problem mapping field:'country' index row:" + rowNumber);
        }
        fieldName_latitude = headers.indexOf("latitude");
        fieldMap.put(fieldName_latitude, "setLatitude");
        if (fieldName_latitude < 0) {
            throw new RuntimeException("problem mapping field:'latitude' index row:" + rowNumber);
        }
        fieldName_longitude = headers.indexOf("longitude");
        fieldMap.put(fieldName_longitude, "setLongitude");
        if (fieldName_longitude < 0) {
            throw new RuntimeException("problem mapping field:'longitude' index row:" + rowNumber);
        }
        fieldName_population = headers.indexOf("population");
        fieldMap.put(fieldName_population, "setPopulation");
        if (fieldName_population < 0) {
            throw new RuntimeException("problem mapping field:'population' index row:" + rowNumber);
        }
        fieldName_region = headers.indexOf("region");
        fieldMap.put(fieldName_region, "setRegion");
        if (fieldName_region < 0) {
            throw new RuntimeException("problem mapping field:'region' index row:" + rowNumber);
        }
    }

    private boolean updateTarget() {
        updateFieldIndex();
        extractCharSequence(setAccentCity, fieldName_accentCity);
        extractCharSequence(setCity, fieldName_city);
        extractCharSequence(setCountry, fieldName_country);
        extractCharSequence(setLatitude, fieldName_latitude);
        extractCharSequence(setLongitude, fieldName_longitude);
        extractCharSequence(setPopulation, fieldName_population);
        extractCharSequence(setRegion, fieldName_region);
        //target
        return pushData();
    }

    private void updateFieldIndex() {
        fieldIndex++;
        delimIndex[fieldIndex] = writeIndex + 1;
    }

    private boolean pushData(){
        try{
            fieldIndex = fieldName_accentCity;
            target.setAccentCity(setAccentCity);
            fieldIndex = fieldName_city;
            target.setCity(setCity);
            fieldIndex = fieldName_country;
            target.setCountry(setCountry);
            fieldIndex = fieldName_latitude;
            target.setLatitude(setLatitude);
            fieldIndex = fieldName_longitude;
            target.setLongitude(setLongitude);
            fieldIndex = fieldName_population;
            target.setPopulation(setPopulation);
            fieldIndex = fieldName_region;
            target.setRegion(setRegion);
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
        fieldMap.put(fieldName_accentCity, "setAccentCity");
        fieldMap.put(fieldName_city, "setCity");
        fieldMap.put(fieldName_country, "setCountry");
        fieldMap.put(fieldName_latitude, "setLatitude");
        fieldMap.put(fieldName_longitude, "setLongitude");
        fieldMap.put(fieldName_population, "setPopulation");
        fieldMap.put(fieldName_region, "setRegion");
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


