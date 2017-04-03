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

import com.fluxtion.fx.builder.BucketConfig;
import com.fluxtion.fx.builder.PriceBiasConfig;
import com.fluxtion.fx.builder.PriceCheckConfig;
import com.fluxtion.fx.util.CcyPair;
import static com.fluxtion.fx.util.CcyPair.*;
import java.util.Arrays;
import java.util.List;

/**
 * A BaisPrice monitoring config for heterogeneous limits and time buckets based
 * on currency pair.
 *
 * Usually there would be different definitions for a time of day, and the
 * active monitoring set swapped in.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class PortfolioMonitorBiasConfig implements PriceBiasConfig {

    @Override
    public List<PriceCheckConfig> configs() {
        //JPY buckets - different limits
        CcyPair[] jpyPairs = new CcyPair[]{EURJPY, USDJPY};
        BucketConfig[] jpyBuckets = new BucketConfig[]{new BucketConfig(45, 0.25), new BucketConfig(30 * 10, 0.12)};
        PriceCheckConfig jpyCfg = new PriceCheckConfig(jpyPairs, jpyBuckets);

        //active currencies have smaller buckets
        CcyPair[] g6Pairs = new CcyPair[]{EURCHF, USDCHF, GBPUSD, EURGBP, AUDUSD};
        BucketConfig[] buckets = new BucketConfig[]{new BucketConfig(60, 0.0015), new BucketConfig(60 * 10, 0.0010)};
        PriceCheckConfig cfg = new PriceCheckConfig(g6Pairs, buckets);

        //more monitoring for EURUSD
        PriceCheckConfig eurusdCfg = new PriceCheckConfig(EURUSD, new BucketConfig(20, 0.0022),new BucketConfig(60, 0.0011), new BucketConfig(60 * 10, 0.0008));

        //quieter currencies have larger buckets as the may trade infrequently 
        //and one genuine reject could create a false positive, monitor 1 minute
        //but no warning - wider limit for 
        CcyPair[] scandiPairs = new CcyPair[]{EURHUF, EURDKK, EURNOK};
        BucketConfig[] scandiBuckets = new BucketConfig[]{new BucketConfig(15 * 60), new BucketConfig(60 * 60 * 10, 0.0075)};
        PriceCheckConfig scandiCfg = new PriceCheckConfig(scandiPairs, scandiBuckets);

        return Arrays.asList(jpyCfg, cfg, eurusdCfg, scandiCfg);
    }

}
