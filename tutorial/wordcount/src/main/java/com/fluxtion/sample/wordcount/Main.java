/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.sample.wordcount;

import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.sample.wordcount.generated.WcProcessor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author greg
 */
public class Main {

    public static void main(String[] args) {
        File f = new File(args[0]);
        try {
            streamFromFile(f);
        } catch (IOException ex) {
            System.out.println("error processing file:" + ex.getMessage());
        }
    }

    public static void streamFromFile(File file) throws FileNotFoundException, IOException {
        if (file.exists() && file.isFile()) {
            WcProcessor processor = new WcProcessor();
            processor.init();
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            long size = file.length();
            MappedByteBuffer buffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, size);
            CharEvent charEvent = new CharEvent(' ');
            while (buffer.hasRemaining()) {
                charEvent.setCharacter((char) buffer.get());
                processor.handleEvent(charEvent);
            }
            processor.tearDown();
            System.out.println(processor.result.toString());
        }else{
            System.out.println("cannot process file file:" + file.getAbsolutePath());
        }
    }


}
