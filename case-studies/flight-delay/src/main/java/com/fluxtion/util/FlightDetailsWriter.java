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
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gregp
 */
public class FlightDetailsWriter {

    private DataOutputStream dout;

    public FlightDetailsWriter(File dataFile) {
        try {
            dataFile.createNewFile();
            dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            Logger.getLogger(FlightDetailsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void flightDetails(FlightDetails details) {
        try {
            dout.writeChars(details.getCarrier().substring(0, 2));
            dout.writeInt(details.getDelay());
        } catch (IOException ex) {
        }
    }

    public void close() {
        try {
            dout.close();
        } catch (IOException ex) {
        }
    }

}
