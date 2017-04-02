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
import com.fluxtion.fx.util.CcyPair;
import static com.fluxtion.fx.util.CcyPair.AUDUSD;
import static com.fluxtion.fx.util.CcyPair.EURCHF;
import static com.fluxtion.fx.util.CcyPair.EURDKK;
import static com.fluxtion.fx.util.CcyPair.EURHUF;
import static com.fluxtion.fx.util.CcyPair.EURJPY;
import static com.fluxtion.fx.util.CcyPair.EURNOK;
import static com.fluxtion.fx.util.CcyPair.EURUSD;
import static com.fluxtion.fx.util.CcyPair.GBPUSD;
import static com.fluxtion.fx.util.CcyPair.USDCHF;
import static com.fluxtion.fx.util.CcyPair.USDJPY;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public PriceOrderGenerator(BiasProcessor biasCheck) {
        this.biasCheck = biasCheck;
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    }

    public void runMarketForPeriod(int secondsRunning, int millisSleepBetweenTicks) {
        if (millisSleepBetweenTicks < 1) {
            runWithoutPause(secondsRunning);
        } else {
            try {
                System.out.println("starting order generator run for:" + secondsRunning + " seconds");
                startMarket(millisSleepBetweenTicks);
                Thread.sleep(secondsRunning * 1000);
                System.out.println("stopping order generator");
                stopMarket();
            } catch (InterruptedException ex) {
                Logger.getLogger(PriceOrderGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void runWithoutPause(int secondsRunning) {
        init();
        System.out.println("starting order generator run for:" + secondsRunning + " seconds");
        long now = System.currentTimeMillis();
        long finish = now + secondsRunning * 1000;
        long next_pulse = now + 500;
        pushTImingPulse();
        do {
            generate();
            now = System.currentTimeMillis();
            if (now > next_pulse) {
                next_pulse = now + 500;
                pushTImingPulse();
            }

        } while (now < finish);
        System.out.println("stopping order generator");

    }

    public void startMarket(int sleepPeriod) {
        init();
        run.set(true);
        timingPulseExecutor = scheduledExecutor.scheduleAtFixedRate(() -> pushTImingPulse(), 0, 500, TimeUnit.MILLISECONDS);
        marketExecutor = scheduledExecutor.scheduleAtFixedRate(() -> generate(), 20, sleepPeriod, TimeUnit.MILLISECONDS);
    }

    public void stopMarket() throws InterruptedException {
        marketExecutor.cancel(true);
        timingPulseExecutor.cancel(true);
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

        addCcy(EURUSD);
        addCcy(GBPUSD);
        addCcy(EURCHF);
        addCcy(USDCHF);
        addCcy(EURJPY);
        addCcy(USDJPY);
        addCcy(EURHUF);
        addCcy(EURDKK);
        addCcy(EURNOK);
        addCcy(AUDUSD);

    }

    private Random _random;

    private void getNextPrice(CcyConfig ccyConfig) {
        double oldPrice = ccyConfig.price.getBid();
        double MIN_PRICE = ccyConfig.minPrice;
        double MAX_PRICE = ccyConfig.maxPrice;
        // Instead of a fixed volatility, pick a random volatility
        // each time, between 2 and 10.
        float volatility = _random.nextFloat() * 10 + 2;

        float rnd = _random.nextFloat();

        float changePercent = 2 * volatility * rnd;

        if (changePercent > volatility) {
            changePercent -= (2 * volatility);
        }
        double changeAmount = oldPrice * changePercent / 100;
        double newPrice = oldPrice + changeAmount;

        // Add a ceiling and floor.
        if (newPrice < MIN_PRICE) {
            newPrice += Math.abs(changeAmount) * 2;
        } else if (newPrice > MAX_PRICE) {
            newPrice -= Math.abs(changeAmount) * 2;
        }
        newPrice = ((double) Math.round(newPrice * 10000)) / 10000.0;
        double offerNew = ((double) Math.round((newPrice + ccyConfig.spread) * 10000)) / 10000.0;
        ccyConfig.price.setBidOffer(newPrice, offerNew);
    }

    private static class CcyConfig {

        public CcyConfig(CcyPair pair) {
            this.pair = pair;
            price = new FxPrice(pair);
            minPrice = 0.6;
            maxPrice = 1.4;
            spread = 0.0002;
            switch (pair) {
                case EURUSD:
                    price.setBidOffer(1.1025, 1.1027);
                    minPrice = 1.0934;
                    maxPrice = 1.2234;
                    orderRate = 0.12;
                    break;
                case EURCHF:
                    price.setBidOffer(1.0702, 1.0703);
                    minPrice = 1.0233;
                    maxPrice = 1.1134;
                    orderRate = 0.02;
                    break;
                case AUDUSD:
                    price.setBidOffer(0.702, 0.7022);
                    minPrice = 0.68;
                    maxPrice = 0.82;
                    orderRate = 0.075;
                    break;
                case EURJPY:
                    price.setBidOffer(120.25, 120.46);
                    minPrice = 118.25;
                    maxPrice = 132.56;
                    spread = 0.02;
                    break;
                case USDJPY:
                    price.setBidOffer(120.25, 120.46);
                    minPrice = 106.08;
                    maxPrice = 121.32;
                    spread = 0.02;
                    orderRate = 0.08;
                    break;
                case GBPUSD:
                    price.setBidOffer(1.2500, 1.2501);
                    minPrice = 1.1867;
                    maxPrice = 1.5733;
                    orderRate = 0.1;
                    break;
                case EURHUF:
                    price.setBidOffer(305.25, 305.75);
                    minPrice = 300;
                    maxPrice = 325;
                    orderRate = 0.01;
                    break;
                case EURDKK:
                    price.setBidOffer(7.5, 5002);
                    minPrice = 7.2545;
                    maxPrice = 7.5987;
                    orderRate = 0.025;
                    break;
                case EURNOK:
                    price.setBidOffer(9.4, 9.45);
                    minPrice = 9;
                    maxPrice = 9.9;
                    orderRate = 0.015;
                    break;
                default:
                    price.setBidOffer(0.9999, 1.0001);
                    minPrice = 0.75;
                    maxPrice = 1.22;
            }

        }

        private double spread = 0.0002;
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
