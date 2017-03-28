/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
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
package com.fluxtion.learning.fx.example1;

import com.fluxtion.fx.builder.BucketConfig;
import com.fluxtion.fx.builder.PriceBiasConfig;
import com.fluxtion.fx.builder.PriceCheckConfig;
import com.fluxtion.fx.util.CcyPair;
import static com.fluxtion.fx.util.CcyPair.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class G10MonitorBiasConfig implements PriceBiasConfig{

    @Override
    public List<PriceCheckConfig> configs() {
        CcyPair[] g10Pairs = new CcyPair[]{EURUSD, EURCHF, USDCHF, GBPUSD, EURGBP, AUDUSD, EURJPY, USDJPY};
        BucketConfig[] buckets = new BucketConfig[]{new BucketConfig(60, 0.0015), new BucketConfig(60*10, 0.0010)};
        PriceCheckConfig cfg = new PriceCheckConfig(g10Pairs, buckets);
        return Arrays.asList(cfg);
    }
    
}
