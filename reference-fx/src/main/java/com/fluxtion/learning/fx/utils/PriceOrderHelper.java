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
import com.fluxtion.fx.event.CustomerOrder;
import com.fluxtion.fx.event.CustomerOrderAccept;
import com.fluxtion.fx.event.CustomerOrderReject;
import com.fluxtion.fx.event.FxOrder;
import com.fluxtion.fx.event.FxPrice;
import com.fluxtion.fx.node.biascheck.BiasSummaryBroadcaster;
import com.fluxtion.fx.node.biascheck.CustomerOrderCacheGlobal;
import com.fluxtion.fx.node.biascheck.PriceCache;
import com.fluxtion.fx.node.biascheck.PricingBiasCheck;
import com.fluxtion.fx.util.CcyPair;
import java.util.EnumMap;

/**
 *
 * @author Greg Higgins
 */
public class PriceOrderHelper {

    public final BiasProcessor checker;
    private int orderId;
    private final EnumMap<CcyPair, FxPrice> priceCache;
    private final FxOrder orderDetails;
    private final CustomerOrder order;
    private final CustomerOrderReject reject;
    private final CustomerOrderAccept accept;
    private final BiasSummaryBroadcaster summaryBroadcaster;
    private final PriceCache biasPriceCache;
    private final CustomerOrderCacheGlobal orderCache;

    public PriceOrderHelper(BiasProcessor biasChecker) {
        this.checker = biasChecker;
        orderId = 0;
        priceCache = new EnumMap(CcyPair.class);
        orderDetails = new FxOrder();
        order = new CustomerOrder();
        reject = new CustomerOrderReject();
        accept = new CustomerOrderAccept();       
        this.summaryBroadcaster = biasChecker.getSummaryBroadcaster();
        this.biasPriceCache = null;
        this.orderCache = biasChecker.getOrderCache();
    }

    private FxPrice getCachedPrice(CcyPair pair) {
        FxPrice price = priceCache.get(pair);
        if (price == null) {
            price = new FxPrice(pair);
            priceCache.put(pair, price);
            //set default price
            switch (pair) {
                case EURUSD:
                    price.setBidOffer(1.1025, 1.1027);
                    break;
                case EURCHF:
                    price.setBidOffer(1.0702, 1.0703);
                    break;
                case EURJPY:
                    price.setBidOffer(120.25, 120.46);
                    break;
                case GBPUSD:
                    price.setBidOffer(1.2500, 1.2501);
                    break;
                default:
                    price.setBidOffer(0.9999, 1.0001);
            }
        }
        return price;
    }
    
    public FxPrice sendRandomPrice(CcyPair pair){
        FxPrice price = getCachedPrice(pair);
        sendPrice(price.pair, price.bid, price.offer);
        return price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setWallClock(long milliseconds){
        checker.setWallClockTime(milliseconds);
    }
    
    public void acceptOrderWithBias(CcyPair pair, double bias, boolean buy) {
        FxPrice price = sendPrice(pair, 1.0945, 1.0948);
        FxOrder order = sendOrder(price, buy, 1e6);
        sendPrice(pair, 1.0945 + bias, 1.0948 + bias);
        acceptOrder(order);
    }

    public void rejectOrderWithBias(CcyPair pair, double bias, boolean buy) {
        FxPrice price = sendPrice(pair, 1.0945, 1.0948);
        FxOrder order = sendOrder(price, buy, 1e6);
        sendPrice(pair, 1.0945 + bias, 1.0948 + bias);
        rejectOrder(order);
    }

    public FxPrice sendPrice(CcyPair pair, double bid, double offer) {
        FxPrice price = getCachedPrice(pair);
        price.setBidOffer(bid, offer);
        checker.newFxPrice(price);
        return price;
    }

    public FxOrder sendOrder(FxPrice price, boolean customerBuys, double volume) {
        orderDetails.setDetails(price, customerBuys, volume, orderId++);
        order.setOrder(orderDetails);
        checker.newCustomerOrder(order);
        return orderDetails;
    }

    public void rejectOrder(FxOrder order) {
        reject.setOrder(order);
        checker.rejectCustomerOrder(reject);
    }

    public void acceptOrder(FxOrder order) {
        accept.setOrder(order);
        checker.acceptCustomerOrder(accept);
    }

    public FxOrder getOrderFromCache(FxOrder order) {
        return orderCache.getFxOrder(order.orderId);
    }

    public PricingBiasCheck getBiasCheck(CcyPair pair) {
        return summaryBroadcaster.getBiasByCcyPair(pair);
    }

    public PricingBiasCheck getBiasCheck_30s(CcyPair pair) {
        return summaryBroadcaster.getBiasByCcyPairAndBucket(pair, 30);
    }

    public PricingBiasCheck getBiasCheck(CcyPair pair, int bucket) {
        return summaryBroadcaster.getBiasByCcyPairAndBucket(pair, bucket);
    }
}
