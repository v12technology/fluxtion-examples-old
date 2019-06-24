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

import static com.fluxtion.learning.utils.events.AlarmClock.ALARM_ONOFF;
import static com.fluxtion.learning.utils.events.AlarmClock.ALARM_TIME;
import com.fluxtion.learning.utils.events.generated.AlarmProcessor;
import com.fluxtion.runtime.plugin.events.BooleanSignal;
import com.fluxtion.runtime.plugin.events.ListenerRegistrationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.events.TimingPulseEvent;
import java.util.Calendar;
import org.junit.Test;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class AlarmTest {

    @Test
    public void testAlarm() {
        AlarmProcessor alarm = new AlarmProcessor();
        alarm.init();
        //set alarm time and listener
        alarm.handleEvent(new NumericSignal(ALARM_TIME, 7));
        
        //lets tick -  alarm off so nothing should happen
        tickHour(alarm, 5);
        tickHour(alarm, 6);
        tickHour(alarm, 7);
        tickHour(alarm, 8);
        
        //enable alarm
        alarm.handleEvent(new BooleanSignal(ALARM_ONOFF, true));
        //lets tick -  alarm on so something should happen
        tickHour(alarm, 5);
        tickHour(alarm, 6);
        tickHour(alarm, 7);
        tickHour(alarm, 8);

        //add a listener and tick
        alarm.handleEvent(new ListenerRegistrationEvent(AlarmListener.class, new TeasMade(), true));
        tickHour(alarm, 5);
        tickHour(alarm, 6);
        tickHour(alarm, 7);
        tickHour(alarm, 8);
    }
    
    private void tickHour(AlarmProcessor alarm, int hour){
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY, hour);
        alarm.handleEvent(new TimingPulseEvent(alarmTime.getTimeInMillis()));
        
    }
}
