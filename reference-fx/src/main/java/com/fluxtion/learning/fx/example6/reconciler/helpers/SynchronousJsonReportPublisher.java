/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
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
package com.fluxtion.learning.fx.example6.reconciler.helpers;

import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileReportPublisher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Writes reconcile reports to the local file system formatted as JSON encoded
 * as 8-bit ASCII.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class SynchronousJsonReportPublisher implements ReconcileReportPublisher {

    private final AtomicBoolean updated = new AtomicBoolean(false);
    public File reportDirectory;
    private File tmpFile;
    private RandomAccessFile tmpRanAccFile;

    private static final int PAGE_SIZE = 1024 * 4;
    private static final int STRING_BUFFER_SIZE = 512;
    private ByteBuffer buffer;
    private StringBuilder sb;

    @Override
    public void publishReport(ReconcileCacheQuery reconcileResultcCche, String reconcilerId) {
        updated.lazySet(false);
        reconcileResultcCche.stream((ReconcileStatus s) -> {
            if (updated.get()) {
                sb.append(",\n");
            } else {
                tmpRanAccFile = null;
                try {
                    tmpFile = Files.createTempFile(reportDirectory.toPath(), "reconcilerReport", "_" + reconcilerId + ".json").toFile();
                    tmpRanAccFile = new RandomAccessFile(tmpFile, "rw");
                } catch (FileNotFoundException e1) {
                } catch (IOException ex) {
                    Logger.getLogger(SynchronousJsonReportPublisher.class.getName()).log(Level.SEVERE, null, ex);
                }
                sb.append("{\"reconciler\": \"").append(reconcilerId).append("\", \"records\":[\n");
            }
            updated.lazySet(true);
            s.appendAsJson(sb);

            while (sb.length() > buffer.remaining()) {
                buffer = ByteBuffer.allocate(buffer.limit() * 2);
            }

            //dump to file clear buffer
            int i = sb.length();
            for (int j = 0; j < i; j++) {
                buffer.put((byte) sb.charAt(j));
            }
            try {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    tmpRanAccFile.getChannel().write(buffer);
                }
                buffer.clear();
                sb.setLength(0);
            } catch (Exception ex) {
                Logger.getLogger(SynchronousJsonReportPublisher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, reconcilerId);

        if (updated.get()) {
            try {
                tmpRanAccFile.writeByte('\n');
                tmpRanAccFile.writeByte(']');
                tmpRanAccFile.writeByte('}');
                tmpRanAccFile.close();
                //delet and move to final report
                Path finalReportPath = Paths.get(reportDirectory.getAbsolutePath(), "reconcilerReport_" + reconcilerId + ".json");
                Files.move(tmpFile.toPath(), finalReportPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(SynchronousJsonReportPublisher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sb.setLength(0);
    }

    @Override
    public void init() {
        sb = new StringBuilder(STRING_BUFFER_SIZE);
        buffer = ByteBuffer.allocate(PAGE_SIZE);
        reportDirectory = new File("public/reports/reconcile/");
        reportDirectory.mkdirs();
    }

    @Override
    public void tearDown() {
    }

}
