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
import static com.fluxtion.extension.declarative.funclib.builder.math.AbsFunctions.abs;
import static com.fluxtion.extension.declarative.funclib.builder.math.SubtractFunctions.subtract;
import static com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper.greaterThanOnce;
import static com.fluxtion.extension.declarative.funclib.builder.test.LessThanHelper.lessThanOnce;
import com.fluxtion.learning.declarative.ext.helpers.FxTrade;

/**
 * Process FxTrade events from multiple currency pairs and maintain the net
 * position of euros. Handle buys and sells, euro can be base or terms ccy on a
 * trade.
 * <br>
 * Process the following euro currency pairs:
 * <pre>
 * "EU", "EC", "EG", "EY", "UE", "CE", "GE", "YE"
 * </pre>
 *
 * <ul>
 * Warning notifications
 * <ul>
 * <li>log "ADD WARN" message whenever abs(EUR pos) breaches 10M
 * <li>No repeated warning log for subsequent trades while abs(EUR pos) > 10M.
 * <li>log "REMOVE WARN" when absolute(EUR pos) drops below 10M.
 * </ul>
 * Critical notifications
 * <ul>
 * <li>log "ADD CRITICAL" message when abs(EUR pos) breaches 250M
 * <li>No repeated error log for subsequent trades while abs(EUR pos) > 250M.
 * <li>log "REMOVE CRITICAL" when abs(EUR pos) drops below 250M.
 * </ul>
 * </ul>
 *
 * @author Greg Higgins
 */
public class FxMonitorBuilder extends SEPConfig {

    public FxMonitorBuilder() throws Exception {
        //calculations
        EventWrapper<FxTrade> tradeEventHandler = EventSelect.select(FxTrade.class);
        NumericValue eurDealtPos = cumSum(FxTrade.class, FxTrade::dealt, "EU", "EC", "EG", "EY");
        NumericValue eurContraPos = cumSum(FxTrade.class, FxTrade::contra, "UE", "CE", "GE", "YE");
        NumericValue eurNetPos = subtract(eurDealtPos, eurContraPos);
        //add public node for testing
        addPublicNode(eurNetPos, "eurNetPos");
        //info logging
        Log("-> Trade recived:'{}'@dealt:'{}' contra:'{}'", tradeEventHandler,
                FxTrade::ccyPair, FxTrade::dealt, FxTrade::contra);

        buildLog("<- Position update: EUR net:'{}' dealt:'{}' contra:'{}'", tradeEventHandler)
                .input(eurNetPos, eurNetPos::intValue)
                .input(eurDealtPos, eurDealtPos::intValue)
                .input(eurContraPos, eurContraPos::intValue)
                .build();
        //condtional alerts
        NumericValue absEurPos = abs(eurNetPos);
        LambdaReflection.SerializableSupplier eurPosInt = eurNetPos::intValue;
        LogOnNotify("<- *  ADD POS WARNING      * : EUR position:'{}' breached warn limit of 10M", greaterThanOnce(absEurPos, 10e6), eurNetPos, eurPosInt).logLevel = 2;
        LogOnNotify("<- *  REMOVE POS WARNING   * : EUR position:'{}' dropped below warn limit of 10M", lessThanOnce(absEurPos, 10e6), eurNetPos, eurPosInt).logLevel = 2;
        LogOnNotify("<- ** NEW POS CRITICAL    ** : EUR position:'{}' breached critical limit of 250M", greaterThanOnce(absEurPos, 250e6), eurNetPos, eurPosInt).logLevel = 1;
        LogOnNotify("<- ** REMOVE POS CRITICAL ** : EUR position:'{}' dropped below critical limit of 250M", lessThanOnce(absEurPos, 250e6), eurNetPos, eurPosInt).logLevel = 1;
    }
}
