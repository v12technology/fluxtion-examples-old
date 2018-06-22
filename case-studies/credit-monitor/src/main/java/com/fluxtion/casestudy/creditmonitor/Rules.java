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
import com.fluxtion.api.annotations.Inject;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.casestudy.creditmonitor.events.LocationRuleConfig;
import com.fluxtion.casestudy.creditmonitor.volatility.VolatilityCalc;
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

    protected UserContext userCtx() {
        return userCtx;
    }

    public abstract boolean failedValidation();

    public static class LocationRule extends Rules {

        private LocationRuleConfig cfg;

        public LocationRule(UserContext userCtx) {
            super(userCtx);
        }

        @Override
        @OnEvent
        public boolean failedValidation() {
            boolean failed = false;
            if (cfg == null) {
                log.info("noLocationCheck", true);
            } else if(userCtx().previousPurchaseOrder!=null){
                int deltaX = Math.abs(userCtx().currentPurchaseOrder.x - userCtx().previousPurchaseOrder.x);
                int deltaY = Math.abs(userCtx().currentPurchaseOrder.y - userCtx().previousPurchaseOrder.y);
                if(deltaX > cfg.maxDeltaX || deltaY > cfg.maxDeltaY){
                    failed = true;
                    log.info("exceededMovement", true);
                    log.info("maxDeltaX", cfg.maxDeltaX);
                    log.info("actualDeltaX", deltaX );
                    log.info("maxDeltaY", cfg.maxDeltaY);
                    log.info("actualDeltaY", deltaY );
                }
            }
            log.info("validateLocation", !failed);
            return failed;
        }

        @EventHandler(propagate = false)
        public boolean configUpdate(ConfigurationEvent<LocationRuleConfig> configUpdate) {
            log.info("updateCfg", configUpdate.value.toString());
            this.cfg = configUpdate.value;
            return false;
        }

    }

    public static class OrderRateRule extends Rules {

        public OrderRateRule(UserContext userCtx) {
            super(userCtx);
        }

        @Override
        @OnEvent
        public boolean failedValidation() {
            boolean failed = false;
            log.info("validateOrderRate", !failed);
            return failed;
        }

    }

    public static class MaxOrderSizeRule extends Rules {

        private double maxSize = 1000;
        
//        @Inject
        private final VolatilityCalc volatilityCalc;

        public MaxOrderSizeRule(VolatilityCalc volatilityCalc, UserContext userCtx) {
            super(userCtx);
            this.volatilityCalc = volatilityCalc;
        }
        
        public MaxOrderSizeRule(UserContext userCtx) {
            this(null, userCtx);
        }

        @EventHandler(filterString = "maxOrderSize", propagate = false)
        public boolean numericUpdate(NumericSignal numericSignal) {
            maxSize = numericSignal.value();
            log.info("maxSize", maxSize);
            return false;
        }

        @Override
        @OnEvent
        public boolean failedValidation() {
            boolean failed = false;
            double amount = userCtx().currentPurchaseOrder.amount;
            if(volatilityCalc!=null){
                amount *= volatilityCalc.volatilityMultiplier();
                log.info("volMultiplier", volatilityCalc.volatilityMultiplier());
            }
            if (amount > maxSize) {
                failed = true;
                log.info("maxSize", maxSize);
                log.info("actualSize", userCtx().currentPurchaseOrder.amount);
            }
            log.info("validateMaxOrderSize", !failed);
            return failed;
        }

    }
}
