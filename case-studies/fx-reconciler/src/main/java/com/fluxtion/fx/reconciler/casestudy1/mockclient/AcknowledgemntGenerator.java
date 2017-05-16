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
package com.fluxtion.fx.reconciler.casestudy1.mockclient;

import com.fluxtion.fx.event.TimingPulseEvent;
import static com.fluxtion.fx.reconciler.casestudy1.MainByController.QUEUE_PATH;
import com.fluxtion.fx.reconciler.client.ChronicleClient;
import com.fluxtion.fx.reconciler.events.TradeAcknowledgement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class AcknowledgemntGenerator {
    //for testing
    private static final TimingPulseEvent TIMING_PULSE_EVENT = new TimingPulseEvent(1);
    static int countId = (int) System.currentTimeMillis();
    static ChronicleClient client = new ChronicleClient(QUEUE_PATH);
    
    static{
        Calendar cal = new GregorianCalendar();
        final Date date = new Date();
        cal.setTime(date);
        cal.clear(Calendar.MILLISECOND);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.HOUR);
        countId = (int) (date.getTime() - cal.getTimeInMillis());
    }
    
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            try {
                TIMING_PULSE_EVENT.currentTimeMillis = System.currentTimeMillis();
                if (countId < 1) {
                    client.processTradeAcknowledgement(new TradeAcknowledgement("MiddleOffice_NY3_FXALL", countId, TIMING_PULSE_EVENT.currentTimeMillis));
                }
                client.timeUpdate(TIMING_PULSE_EVENT);
                client.processTradeAcknowledgement(new TradeAcknowledgement("NY_3_FXALL", countId, TIMING_PULSE_EVENT.currentTimeMillis));
                client.processTradeAcknowledgement(new TradeAcknowledgement("MiddleOffice_NY3_FXALL", ++countId, TIMING_PULSE_EVENT.currentTimeMillis));
            } catch (Exception e) {
                System.err.println("error:" + e.getMessage());
            }
        }, 2, 2, TimeUnit.SECONDS);
    }
}
