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
package com.fluxtion.learning.utils.events;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.runtime.plugin.events.BooleanSignal;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.events.TimingPulseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An example alarm clock that only uses events defined in the runtime-plugins
 * module. Re-using pre-defined events removes the need to create additional 
 * events where the requirements are relatively simple. <p>
 * 
 * Over using string based
 * generic events will create a fragile api!!
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class AlarmClock {

    private List<AlarmListener> listener;
    private boolean alarmEnabled;
    private int alarmHour;
    public static final String ALARM_ONOFF = "alarmOnOff";
    public static final String ALARM_TIME = "alarmTime";

    @EventHandler(propagate = false)
    public void setAlarmListener(ListenerRegistrationEvent<AlarmListener> liststener) {
        if (liststener.register) {
            listener.add(liststener.value);
        } else {
            listener.remove(liststener.value);
        }
    }

    @EventHandler(filterString = ALARM_ONOFF, propagate = false)
    public void alarmEnable(BooleanSignal alarmOnOff) {
        alarmEnabled = alarmOnOff.isEnabled();
    }

    @EventHandler(filterString = ALARM_TIME, propagate = false)
    public void alarmTime(NumericSignal numericSignal) {
        double value = numericSignal.value();
        if (value >= 0 & value < 24) {
            alarmHour = (int) value;
        }
    }

    @EventHandler
    public boolean tickTock(TimingPulseEvent tick) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(tick.currentTimeMillis);
        final int currentHour = (int)c.get(Calendar.HOUR_OF_DAY);
        final boolean fireAlarm = currentHour == alarmHour && alarmEnabled;
        if (fireAlarm) {
            System.out.printf("current_hour:%d, alarm_hour:%d,  alarmEnabled:%b, fire:%b %n", currentHour, alarmHour, alarmEnabled, fireAlarm);
            listener.stream().forEach(AlarmListener::wakeUp);
        }
        return fireAlarm;
    }

    @Initialise
    public void init() {
        listener = new ArrayList<>();
    }

}
