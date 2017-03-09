/*
 * Copyright (C) 2017 Greg Higgins
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
package com.fluxtion.learning.declarative.ext.example1;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.extension.declarative.api.numeric.NumericValue;
import com.fluxtion.extension.declarative.builder.event.EventSelect;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.Log;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.LogOnNotify;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.buildLog;
import com.fluxtion.extension.declarative.builder.util.LambdaReflection;
import static com.fluxtion.extension.declarative.funclib.builder.math.CumSumFunctions.cumSum;
import static com.fluxtion.extension.declarative.funclib.builder.math.SubtractFunctions.subtract;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanOnce;
import static com.fluxtion.extension.declarative.funclib.builder.test.LessThanHelper.lessThanOnce;
import com.fluxtion.learning.DataEvent;

/**
 *
 * @author Greg Higgins
 */
public class FxMonitorBuilder extends SEPConfig {

        /**
         * WARN message when EUR position > 10 No repeated warnings for
         * subsequent trades Remove WARN when EUR pos < 10
         *
         * @throws Exception
         */
        public FxMonitorBuilder() throws Exception {
            //calculations
            EventWrapper<DataEvent> tradeEventHandler = EventSelect.select(DataEvent.class);
            NumericValue eurDealtPos = cumSum(DataEvent.class, DataEvent::getValue, "EU", "EC", "EG", "EY");
            NumericValue eurContraPos = cumSum(DataEvent.class, DataEvent::getValue, "UE", "CE", "GE", "YE");
            NumericValue eurNetPos = subtract(eurDealtPos, eurContraPos);
            //logging and reporting
            Log("-> Trade recived:'{}'@'{}' ", tradeEventHandler,
                    DataEvent::getStringValue, DataEvent::getValue);

            buildLog("<- Position update: EUR net:{} dealt:{} contra:{}", tradeEventHandler)
                    .input(eurNetPos, eurNetPos::intValue)
                    .input(eurDealtPos, eurDealtPos::intValue)
                    .input(eurContraPos, eurContraPos::intValue)
                    .build();

            //condtional alerts
            LambdaReflection.SerializableSupplier eurPosInt = eurNetPos::intValue;
            LogOnNotify("NEW 1 <- *  POS WARNING  * create    : -> EUR position:'{}' breached warn limit of 10", greaterThanOnce(eurNetPos, 10), eurNetPos, eurPosInt);
            LogOnNotify("NEW 2 <- *  POS WARNING  * delete : X  EUR position:'{}' dropped below warn limit of 10", lessThanOnce(eurNetPos, 10), eurNetPos, eurPosInt);
            LogOnNotify("NEW 3 <- ** POS CRITICAL ** create   : -> EUR position:'{}' breached critical limit of 1000", greaterThanOnce(eurNetPos, 1000), eurNetPos, eurPosInt);
            LogOnNotify("NEW 4 <- ** POS CRITICAL ** delete: X  EUR position:'{}' dropped below critical limit of 1000", lessThanOnce(eurNetPos, 1000), eurNetPos, eurPosInt);

        }
    }