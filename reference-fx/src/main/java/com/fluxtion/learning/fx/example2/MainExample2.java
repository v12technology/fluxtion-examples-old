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
package com.fluxtion.learning.fx.example2;

import com.fluxtion.fx.node.biascheck.OrderBiasResult;
import com.fluxtion.fx.util.ConsoleBreachHandler;
import com.fluxtion.learning.fx.utils.PriceOrderGenerator;

/**
 * Demonstration program, displaying Bias summary's for a range of ccyPairs,
 * Limits and time buckets:
 * <pre>
        pair=AUDUSD, bucket=60, avgBiasNotificationLimit=0.0015
        pair=AUDUSD, bucket=600, avgBiasNotificationLimit=0.001
        pair=EURCHF, bucket=60, avgBiasNotificationLimit=0.0015
        pair=EURCHF, bucket=600, avgBiasNotificationLimit=0.001
        pair=EURDKK, bucket=900, avgBiasNotificationLimit=0.0 
        pair=EURDKK, bucket=36000, avgBiasNotificationLimit=0.0075
        pair=EURGBP, bucket=60, avgBiasNotificationLimit=0.0015
        pair=EURGBP, bucket=600, avgBiasNotificationLimit=0.001
        pair=EURHUF, bucket=900, avgBiasNotificationLimit=0.0 
        pair=EURHUF, bucket=36000, avgBiasNotificationLimit=0.0075
        pair=EURJPY, bucket=45, avgBiasNotificationLimit=0.25 
        pair=EURJPY, bucket=300, avgBiasNotificationLimit=0.12
        pair=EURNOK, bucket=900, avgBiasNotificationLimit=0.0 
        pair=EURNOK, bucket=36000, avgBiasNotificationLimit=0.0075
        pair=EURUSD, bucket=20, avgBiasNotificationLimit=0.0022
        pair=EURUSD, bucket=60, avgBiasNotificationLimit=0.0011
        pair=EURUSD, bucket=600, avgBiasNotificationLimit=8.0E-4
        pair=GBPUSD, bucket=60, avgBiasNotificationLimit=0.0015
        pair=GBPUSD, bucket=600, avgBiasNotificationLimit=0.001
        pair=USDCHF, bucket=60, avgBiasNotificationLimit=0.0015
        pair=USDCHF, bucket=600, avgBiasNotificationLimit=0.001
        pair=USDJPY, bucket=45, avgBiasNotificationLimit=0.25
        pair=USDJPY, bucket=300, avgBiasNotificationLimit=0.12
 * </pre>
 * @author V12 Technology Limited
 */
public class MainExample2 {

    public static void main(String[] args) {
        System.out.println("Example 2 Demonstrate Bias processing in realtime with console logging");
        System.out.println("=================================================================================================");
        PorfolioMonitor monitor = new PorfolioMonitor();
        monitor.registerBreachNotificationHandler(new ConsoleBreachHandler());
        monitor.registerResultsReceiver((long seconds, OrderBiasResult[] results) -> {
            System.out.println("Bias summary at " + seconds + " seconds");
            for (OrderBiasResult result : results) {
                System.out.println("\t" + result.toString());
            }
        });
        //market
        PriceOrderGenerator market = new PriceOrderGenerator(monitor);
        market.runMarketForPeriod(5, 10);
        System.out.println("=================================================================================================");
    }
}
