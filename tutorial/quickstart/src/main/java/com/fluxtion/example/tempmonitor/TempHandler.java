/*
 * Copyright (C) 2016 Greg Higgins (greg.higgins@v12technology.com)
 *
 * This file is part of Fluxtion.
 *
 * Fluxtion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.example.tempmonitor;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.example.tempmonitor.generated.TemperatureAlarm;
import com.fluxtion.extension.declarative.api.Test;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;
import static com.fluxtion.extension.declarative.builder.event.EventSelect.select;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.Log;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.LogOnNotify;
import static com.fluxtion.extension.declarative.funclib.builder.math.AvgFunctions.avg;
import static com.fluxtion.extension.declarative.funclib.builder.math.MaxFunctions.max;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanOnce;
import com.fluxtion.runtime.event.Event;

/**
 * A simple Fluxtion example to monitor the daily maximum and average
 * temperatures, warning when a temperature limit is breached.
 *
 * If a new daily maximum is observed then log the temp to console.
 *
 * If the temperature exceeds a limit then log the breach. Only notify when the
 * temperature breaches, not on subsequent readings that are greater than the
 * limit.
 *
 * At the end of the day print the average temp and reset the maximum value to
 * 0.
 *
 * @author Greg Higgins
 */
public class TempHandler {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        TemperatureAlarm monitor = new TemperatureAlarm();
        monitor.init();
        //uncomment to have only WARNING
//        monitor.handleEvent(LogControlEvent.enableLevelFiltering(3));
        monitor.onEvent(new StartOfDay());
        monitor.onEvent(new TempEvent(10));
        monitor.onEvent(new TempEvent(20));
        monitor.onEvent(new TempEvent(14));
        monitor.onEvent(new TempEvent(16));
        monitor.onEvent(new TempEvent(20));
        monitor.onEvent(new EndOfDay());
        monitor.onEvent(new StartOfDay());
        monitor.onEvent(new TempEvent(6));
        monitor.onEvent(new TempEvent(4));
        // uncomment to remove logging meta data
//        monitor.handleEvent(LogControlEvent.recordMsgBuildTime(false));
//        monitor.handleEvent(LogControlEvent.recordMsgLogLevel(false));
        monitor.onEvent(new TempEvent(26));
        monitor.onEvent(new EndOfDay());
        monitor.onEvent(new StartOfDay());
        monitor.onEvent(new TempEvent(24));
        monitor.onEvent(new TempEvent(26));
        monitor.onEvent(new TempEvent(29));
        monitor.onEvent(new TempEvent(15));
        monitor.onEvent(new TempEvent(28));
        monitor.onEvent(new EndOfDay());
        monitor.onEvent(new StartOfDay());
        monitor.onEvent(new TempEvent(15));
        monitor.onEvent(new TempEvent(24));
        monitor.onEvent(new TempEvent(20));
        monitor.onEvent(new TempEvent(20));
        monitor.onEvent(new EndOfDay());
    }

    public static class TempEvent extends Event {

        private final int temp;

        public TempEvent(int temp) {
            this.temp = temp;
        }

        public int getTemp() {
            return temp;
        }
    }

    public static class StartOfDay extends Event {
    }

    public static class EndOfDay extends Event {
    }

    public static class Builder extends SEPConfig {

        @Override
        public void buildConfig() {
            NumericValue maxDayTemp = max(TempEvent.class, TempEvent::getTemp, select(StartOfDay.class));
            NumericValue avgDayTemp = avg(TempEvent.class, TempEvent::getTemp, select(StartOfDay.class));
            Test tempBreach = greaterThanOnce(TempEvent.class, TempEvent::getTemp, 25);
            //logging
            Log("NEW max temp {}C", maxDayTemp, maxDayTemp::intValue).logLevel = 3;
            LogOnNotify("End of day - avg temp:{}C", select(EndOfDay.class), avgDayTemp, avgDayTemp::intValue).logLevel = 4;
            LogOnNotify("Temp {}C has exceeded limit of 25C", tempBreach, select(TempEvent.class), TempEvent::getTemp).logLevel = 2;
        }
    }

}
