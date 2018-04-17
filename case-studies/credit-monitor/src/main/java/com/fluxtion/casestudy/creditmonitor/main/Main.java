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
package com.fluxtion.casestudy.creditmonitor.main;

import com.fluxtion.casestudy.creditmonitor.events.LocationRuleConfig;
import com.fluxtion.casestudy.creditmonitor.events.PurchaseOrder;
import com.fluxtion.casestudy.creditmonitor.events.UserConfig;
import com.fluxtion.casestudy.creditmonitor.generated.CreditValidator;
import com.fluxtion.runtime.plugin.events.ConfigurationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.logging.Log4JLogRecordListener;

/**
 *
 * @author gregp
 */
public class Main {
    public static void main(String[] args) {
        CreditValidator validator = new CreditValidator();
        validator.init();
        validator.logger.setLogSink(new Log4JLogRecordListener());
        validator.onEvent(new ConfigurationEvent<>(new UserConfig()));
        validator.onEvent(new PurchaseOrder());
        validator.onEvent(new ConfigurationEvent<>(new LocationRuleConfig()));
        validator.onEvent(new NumericSignal("maxOrderSize", 20_000));
    }
}
