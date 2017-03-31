/* 
 * Copyright (C) 2017 V12 Technology Limited
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
package com.fluxtion.learning.fx.utils;

import com.fluxtion.fx.BiasProcessor;
import com.fluxtion.fx.event.FxOrder;
import com.fluxtion.fx.event.FxPrice;
import com.fluxtion.fx.event.TimingPulseEvent;
import com.fluxtion.fx.util.CcyPair;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang.ArrayUtils;

/**
 * Generates prices and orders for a notional market.
 *
 * @author Greg Higgins
 */
public class PriceOrderGenerator {

    private AtomicBoolean run;
    private final BiasProcessor biasCheck;
    private CcyConfig[] configArray;
    private CcyConfig configToAdd;
    private PriceOrderHelper orderHelper;
    private final ScheduledExecutorService scheduledExecutor;
    private ScheduledFuture<?> marketExecutor;
    private ScheduledFuture<?> timingPulseExecutor;
    private TimingPulseEvent timingPulse;

    public PriceOrderGenerator(BiasProcessor biasCheck) {
        this.biasCheck = biasCheck;
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startMarket(int sleepPeriod) {
        //timing pulse
        timingPulse = new TimingPulseEvent(1);
        run.set(true);
        timingPulseExecutor = scheduledExecutor.scheduleAtFixedRate(() -> pushTImingPulse(), 0, 500, TimeUnit.MILLISECONDS);
        marketExecutor = scheduledExecutor.scheduleAtFixedRate(() -> generate(), 100, sleepPeriod, TimeUnit.MILLISECONDS);
    }

    public void stopMarket() throws InterruptedException {
        marketExecutor.cancel(true);
        scheduledExecutor.shutdownNow();
        scheduledExecutor.awaitTermination(2, TimeUnit.SECONDS);
    }

    public void addCcy(CcyPair pair) {
        configToAdd = new CcyConfig(pair);
        if (run.get()) {

        } else {
            addCcy_();
        }
    }

    /**
     * Adds the cached currency to the array
     */
    private void addCcy_() {
        CcyPair pair = configToAdd.pair;
        for (CcyConfig ccyConfig : configArray) {
            if (pair == ccyConfig.pair) {
                ccyConfig.bias = configToAdd.bias;
                ccyConfig.delayMircos = configToAdd.delayMircos;
                ccyConfig.orderRate = configToAdd.orderRate;
                ccyConfig.rejectRate = configToAdd.rejectRate;
                return;
            }
        }
        configArray = (CcyConfig[]) ArrayUtils.add(configArray, configToAdd);
    }

    private void pushTImingPulse() {
        biasCheck.setWallClockTime(System.currentTimeMillis());
    }

    private void generate() {
        try {
            for (int i = 0; i < configArray.length; i++) {
                CcyConfig ccyConfig = configArray[i];
                getNextPrice(ccyConfig);
                biasCheck.newFxPrice(ccyConfig.price);
                ccyConfig.incrementPriceCount();
                if (ccyConfig.sendOrder()) {
                    FxOrder order = orderHelper.sendOrder(ccyConfig.price, true, 1e6);
                    ccyConfig.incrementOrderCount();
                    //move the market
                    getNextPrice(ccyConfig);
                    biasCheck.newFxPrice(ccyConfig.price);
                    ccyConfig.incrementPriceCount();
                    if (ccyConfig.rejectOrder()) {
                        orderHelper.rejectOrder(order);
                        ccyConfig.incrementRejectCount();
                    } else {
                        orderHelper.acceptOrder(order);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error:" + e.getMessage());
        }
    }

    public void init() {
        run = new AtomicBoolean(false);
        configArray = new CcyConfig[0];
        _random = new Random(2000);
        orderHelper = new PriceOrderHelper(biasCheck);
    }

    private Random _random;

    private void getNextPrice(CcyConfig ccyConfig) {
        float oldPrice = (float) ccyConfig.price.getBid();
        float MIN_PRICE = (float) ccyConfig.minPrice;
        float MAX_PRICE = (float) ccyConfig.maxPrice;
        // Instead of a fixed volatility, pick a random volatility
        // each time, between 2 and 10.
        float volatility = _random.nextFloat() * 10 + 2;

        float rnd = _random.nextFloat();

        float changePercent = 2 * volatility * rnd;

        if (changePercent > volatility) {
            changePercent -= (2 * volatility);
        }
        float changeAmount = oldPrice * changePercent / 100;
        float newPrice = oldPrice + changeAmount;

        // Add a ceiling and floor.
        if (newPrice < MIN_PRICE) {
            newPrice += Math.abs(changeAmount) * 2;
        } else if (newPrice > MAX_PRICE) {
            newPrice -= Math.abs(changeAmount) * 2;
        }
        ccyConfig.price.setBidOffer(newPrice, newPrice + ccyConfig.spread);
    }

    private static class CcyConfig {

        public CcyConfig(CcyPair pair) {
            this.pair = pair;
            price = new FxPrice(pair);
            minPrice = 0.6;
            maxPrice = 1.4;
            switch (pair) {
                case EURUSD:
                    price.setBidOffer(1.1025, 1.1027);
                    minPrice = 1.0934;
                    maxPrice = 1.2234;
                    break;
                case EURCHF:
                    price.setBidOffer(1.0702, 1.0703);
                    minPrice = 1.0233;
                    maxPrice = 1.1134;
                    break;
                case EURJPY:
                    price.setBidOffer(120.25, 120.46);
                    minPrice = 118.25;
                    maxPrice = 132.56;
                    break;
                case GBPUSD:
                    price.setBidOffer(1.2500, 1.2501);
                    minPrice = 1.1867;
                    maxPrice = 1.5733;
                    break;
                default:
                    price.setBidOffer(0.9999, 1.0001);
                    minPrice = 0.75;
                    maxPrice = 1.22;
            }
            
        }
        
        private float spread = (float) 0.0002;
        CcyPair pair;
        int delayMircos = 1000;
        double bias = 0.0;
        double orderRate = 0.05;
        double rejectRate = 0.1;
        double minPrice;
        double maxPrice;
        int priceCount = 0;
        int orderCount = 0;
        int rejectCount = 0;
        FxPrice price;

        private boolean sendOrder() {
            return (orderCount / (float) priceCount) < orderRate;
        }

        private boolean rejectOrder() {
            return (rejectCount / (float) orderCount) < rejectRate;
        }

        private void incrementPriceCount() {
            priceCount++;
        }

        private void incrementOrderCount() {
            orderCount++;
        }

        private void incrementRejectCount() {
            rejectCount++;
        }

    }

}
