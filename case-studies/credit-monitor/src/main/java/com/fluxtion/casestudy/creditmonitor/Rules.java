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
package com.fluxtion.casestudy.creditmonitor;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.casestudy.creditmonitor.events.LocationRuleConfig;
import com.fluxtion.runtime.plugin.events.ConfigurationEvent;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import com.fluxtion.runtime.plugin.nodes.EventLogNode;

/**
 *
 * @author gregp
 */
public abstract class Rules extends EventLogNode {

    private final UserContext userCtx;

    public Rules(UserContext userCtx) {
        this.userCtx = userCtx;
    }

    protected UserContext getUserCtx() {
        return userCtx;
    }

    public abstract boolean failedRule();

    public static class LocationRule extends Rules {

        public LocationRule(UserContext userCtx) {
            super(userCtx);
        }

        @Override
        @OnEvent
        public boolean failedRule() {
            log.info("validateLocation", false);
            return false;
        }

        @EventHandler(propagate = false)
        public void configUpdate(ConfigurationEvent<LocationRuleConfig> configUpdate) {
            log.info("updateCfg", configUpdate.value.toString());
        }

    }

    public static class OrderRateRule extends Rules {

        public OrderRateRule(UserContext userCtx) {
            super(userCtx);
        }

        @Override
        @OnEvent
        public boolean failedRule() {
            log.info("validateOrderRate", false);
            return false;
        }

    }

    public static class MaxOrderSizeRule extends Rules {

        public MaxOrderSizeRule(UserContext userCtx) {
            super(userCtx);
        }
        
        @EventHandler(filterString = "maxOrderSize", propagate = false)
        public void numericUpdate(NumericSignal numericSignal) {
            log.info("orderSize", numericSignal.value());
        }

        @Override
        @OnEvent
        public boolean failedRule() {
            log.info("validateMaxOrderSize", true);
            return true;
        }

    }
}
