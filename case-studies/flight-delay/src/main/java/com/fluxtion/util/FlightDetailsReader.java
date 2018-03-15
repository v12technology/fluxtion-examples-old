/*
 * Copyright (C) 2018 gregp
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
package com.fluxtion.util;

import com.fluxtion.casestudy.flightdelay.FlightDetails;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.runtime.lifecycle.EventHandler;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gregp
 */
public class FlightDetailsReader {

    private DataInputStream din;
    private File dataFile;

    public FlightDetailsReader(File dataFile) {
        try {
            dataFile.createNewFile();
            this.dataFile = dataFile;
            din = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            Logger.getLogger(FlightDetailsReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readAll(EventHandler eventHandler) {
        MutableInt mutInt = new MutableInt();
        FlightDetails flightDetails = new FlightDetails();
        HashMap<MutableInt, String> cache = new HashMap<>();

        try {

            FileChannel fileChannel = new FileInputStream(dataFile).getChannel();
            long size = dataFile.length();
            MappedByteBuffer buffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, size);
            while (buffer.hasRemaining()) {
                mutInt.setChar(buffer);
                if (cache.containsKey(mutInt)) {
                    flightDetails.setCarrier(cache.get(mutInt));
                } else {
                    String str = mutInt.asString();
                    flightDetails.setCarrier(str);
                    cache.put(mutInt, str);
                    mutInt = new MutableInt();
                }
                flightDetails.setDelay(buffer.getInt());
                eventHandler.onEvent(flightDetails);
            }
        } catch (IOException ex) {
        }
    }

    private static class MutableInt {

        int hash;
        char c1;
        char c2;

        void setChar(DataInputStream din) throws IOException {
            c1 = din.readChar();
            c2 = din.readChar();
            hash = ((byte) c1) << 1 + (byte) c2;
//            hash = din.readInt();
        }

        void setChar(MappedByteBuffer buffer) throws IOException {
            c1 = buffer.getChar();
            c2 = buffer.getChar();
            hash = ((byte) c1) << 1 + (byte) c2;
//            hash = din.readInt();
        }

        String asString() {
            return new String(new char[]{c1, c2});
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
//            if (this == obj) {
//                return true;
//            }
//            if (obj == null) {
//                return false;
//            }
//            if (getClass() != obj.getClass()) {
//                return false;
//            }
            final MutableInt other = (MutableInt) obj;
            return this.hash == other.hash;
        }

    }

}
