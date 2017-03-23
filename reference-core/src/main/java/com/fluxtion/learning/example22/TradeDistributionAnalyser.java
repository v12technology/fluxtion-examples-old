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
package com.fluxtion.learning.example22;

import com.fluxtion.api.annotations.Config;
import com.fluxtion.api.annotations.ConfigVariable;
import com.fluxtion.learning.example21.*;
import com.fluxtion.api.annotations.Inject;

/**
 *
 * @author greg
 */
public class TradeDistributionAnalyser {
    
    @Inject
    @Config(key = "min", value = "30")
    @Config(key = "max", value = "70")
    @Config(key = "buckets", value = "3")
    @Config(key = "filter", value = "trades")
    public Histogram tradeDistribution;    
    
    @Inject
//    @Config(key = "min", value = "10")
    @Config(key = "max", value = "120")
    @Config(key = "buckets", value = "10")
    @Config(key = "filter", value = "orders")
    public Histogram orderDistribution;    
    
    @ConfigVariable(field = "orderDistribution", key = "min")
    public String orderDistributionMinBucket;
    
}
