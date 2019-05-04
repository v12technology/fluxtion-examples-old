package com.fluxtion.examples.tradingmonitor.generated.fluxCsvAssetPrice;

import com.fluxtion.api.annotations.Config;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.Inject;
import com.fluxtion.api.annotations.PushReference;
import com.fluxtion.examples.tradingmonitor.AssetPrice;
import com.fluxtion.ext.streaming.api.util.CharArrayCharSequence;
import com.fluxtion.ext.streaming.api.util.CharArrayCharSequence.CharSequenceView;
import com.fluxtion.ext.text.api.csv.RowProcessor;
import com.fluxtion.ext.text.api.csv.ValidationLogger;
import com.fluxtion.ext.text.api.event.CharEvent;
import com.fluxtion.ext.text.api.event.EofEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static com.fluxtion.ext.text.api.ascii.Conversion.*;

/**
 * Fluxtion generated CSV decoder.
 *
 * <p>target class : AssetPrice
 *
 * @author Greg Higgins
 */
public class AssetPriceCsvDecoder0 implements RowProcessor<AssetPrice> {

  @Inject
  @Config(key = "id", value = "validationLog")
  @PushReference
  public ValidationLogger errorLog;
  //buffer management
  private final char[] chars = new char[4096];
  private final int[] delimIndex = new int[1024];
  private final CharArrayCharSequence seq = new CharArrayCharSequence(chars);
  private int fieldIndex = 0;
  private int writeIndex = 0;
  //target
  private AssetPrice target;
  //source field index: 0
  private final CharSequenceView setPrice = seq.view();
  private int fieldName_price = 0;
  //source field index: 0
  private final CharSequenceView setSymbol = seq.view();
  private int fieldName_symbol = 0;
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
    if (character == '\r') {
      return false;
    }
    if (character == '\n') {
      return processRow();
    }
    if (character == ',') {
      updateFieldIndex();
    }
    chars[writeIndex++] = character;
    return false;
  }

  @EventHandler
  public boolean eof(EofEvent eof) {
    return writeIndex == 0 ? false : processRow();
  }

  private boolean processRow() {
    boolean targetChanged = false;
    rowNumber++;
    if (HEADER_ROWS < rowNumber) {
      targetChanged = updateTarget();
    } else if (rowNumber == MAPPING_ROW) {
      mapHeader();
    }
    writeIndex = 0;
    fieldIndex = 0;
    return targetChanged;
  }

  private void mapHeader() {
    String header = new String(chars).trim();
    header = header.replace("\"", "");
    List<String> headers = new ArrayList();
    for (String colName : header.split(",")) {
      char c[] = colName.trim().replace(" ", "").toCharArray();
      c[0] = Character.toLowerCase(c[0]);
      headers.add(new String(c));
    }
    fieldName_price = headers.indexOf("price");
    fieldMap.put(fieldName_price, "setPrice");
    if (fieldName_price < 0) {
      logHeaderProblem(
          "problem mapping field:'price' missing column header, index row:", true, null);
    }
    fieldName_symbol = headers.indexOf("symbol");
    fieldMap.put(fieldName_symbol, "setSymbol");
    if (fieldName_symbol < 0) {
      logHeaderProblem(
          "problem mapping field:'symbol' missing column header, index row:", true, null);
    }
  }

  private boolean updateTarget() {
    try {
      updateFieldIndex();
      fieldIndex = fieldName_price;
      setPrice.subSequence(delimIndex[fieldName_price], delimIndex[fieldName_price + 1] - 1);
      target.setPrice(atod(setPrice));

      fieldIndex = fieldName_symbol;
      setSymbol.subSequence(delimIndex[fieldName_symbol], delimIndex[fieldName_symbol + 1] - 1);
      target.setSymbol(setSymbol);

    } catch (Exception e) {
      logException("problem pushing data from row:", false, e);
      passedValidation = false;
      return false;
    } finally {
      fieldIndex = 0;
    }
    return true;
  }

  private void updateFieldIndex() {
    fieldIndex++;
    delimIndex[fieldIndex] = writeIndex + 1;
  }

  private void logException(String prefix, boolean fatal, Exception e) {
    errorLog
        .getSb()
        .append(prefix)
        .append(rowNumber)
        .append(" fieldIndex:")
        .append(fieldIndex)
        .append(" targetMethod:")
        .append(fieldMap.get(fieldIndex));
    if (fatal) {
      errorLog.logFatal("");
      throw new RuntimeException(errorLog.getSb().toString(), e);
    }
    errorLog.logError("");
  }

  private void logHeaderProblem(String prefix, boolean fatal, Exception e) {
    errorLog.getSb().append(prefix).append(rowNumber);
    if (fatal) {
      errorLog.logFatal("");
      throw new RuntimeException(errorLog.getSb().toString(), e);
    }
    errorLog.logError("");
  }

  @Override
  public AssetPrice event() {
    return target;
  }

  @Override
  public Class<AssetPrice> eventClass() {
    return AssetPrice.class;
  }

  @Initialise
  public void init() {
    target = new AssetPrice();
    fieldMap.put(fieldName_price, "setPrice");
    fieldMap.put(fieldName_symbol, "setSymbol");
  }

  @Override
  public boolean passedValidation() {
    return passedValidation;
  }

  @Override
  public int getRowNumber() {
    return rowNumber;
  }
}
