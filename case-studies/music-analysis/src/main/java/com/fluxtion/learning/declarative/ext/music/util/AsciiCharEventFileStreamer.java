/* 
 *  Copyright (C) 2016-2017 V12 Technology Limited
 *  
 *  This software is subject to the terms and conditions of its EULA, defined in the
 *  file "LICENCE.txt" and distributed with this software. All information contained
 *  herein is, and remains the property of V12 Technology Limited and its licensors, 
 *  if any. This source code may be protected by patents and patents pending and is 
 *  also protected by trade secret and copyright law. Dissemination or reproduction 
 *  of this material is strictly forbidden unless prior written permission is 
 *  obtained from V12 Technology Limited.  
 */
package com.fluxtion.learning.declarative.ext.music.util;

import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author Greg Higgins
 */
public class AsciiCharEventFileStreamer {

    public static void streamFromFile(File file, CharSink sink) throws FileNotFoundException, IOException {
        if (file.exists() && file.isFile()) {
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            long size = file.length();
            MappedByteBuffer buffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, size);
            CharEvent charEvent = new CharEvent(' ');
            while (buffer.hasRemaining()) {
                charEvent.setCharacter((char) buffer.get());
                sink.handleCharEvent(charEvent);
            }
        }
    }
    
    public static <E extends EventHandler> E streamFromFile(File file, Class<E> eventHandler) throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException {
        final E handler = eventHandler.newInstance();
        streamFromFile(file, handler, true);
        return handler;
    }
    
    public static void streamFromFile(File file, EventHandler eventHandler) throws FileNotFoundException, IOException {
        streamFromFile(file, eventHandler, false);
    }
    
    public static void streamFromFile(File file, EventHandler eventHandler, boolean callLifeCycleMethods) throws FileNotFoundException, IOException {
        if(callLifeCycleMethods)initSep(eventHandler);
        if (file.exists() && file.isFile()) {
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            long size = file.length();
            MappedByteBuffer buffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, size);
            CharEvent charEvent = new CharEvent(' ');
            while (buffer.hasRemaining()) {
                charEvent.setCharacter((char) buffer.get());
                eventHandler.onEvent(charEvent);
            }
        }
        if(callLifeCycleMethods)tearDownSep(eventHandler);
    }
    
    public static void initSep(EventHandler sep){
        if ( sep instanceof Lifecycle) {
            ((Lifecycle) sep).init();
        }
    }
    
    public static void tearDownSep(EventHandler sep){
        if (sep instanceof Lifecycle) {
            ((Lifecycle) sep).tearDown();
        }
    }
    
    public static interface CharSink {
        public void handleCharEvent(CharEvent event);
    }

}
