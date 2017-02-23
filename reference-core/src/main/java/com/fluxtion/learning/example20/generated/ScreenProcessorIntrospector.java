/* 
 * Copyright (C) 2017 V12 Technology Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example20.generated;

import com.fluxtion.api.debug.SepDebugger;
import com.fluxtion.api.debug.SepIntrospector;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ScreenProcessorIntrospector
    implements SepIntrospector<ScreenProcessor, ScreenProcessorDebug> {

  @Override
  public Document graphMLDocument() {
    Document document = null;
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = factory.newDocumentBuilder();
      InputStream in = this.getClass().getResourceAsStream("ScreenProcessor.graphml");
      InputSource inputSource = new InputSource(in);
      document = parser.parse(inputSource);
    } catch (SAXException | IOException | ParserConfigurationException ex) {
      Logger.getLogger(ScreenProcessorIntrospector.class.getName()).log(Level.SEVERE, null, ex);
    }
    return document;
  }

  @Override
  public Class<ScreenProcessor> sepClass() {
    return ScreenProcessor.class;
  }

  @Override
  public Class<ScreenProcessorDebug> sepDebugClass() {
    return ScreenProcessorDebug.class;
  }

  @Override
  public ScreenProcessor newSepInstance() {
    return new ScreenProcessor();
  }

  @Override
  public ScreenProcessorDebug newDebugSepInstance(SepDebugger sepDebugger) {
    return new ScreenProcessorDebug(sepDebugger);
  }
}
