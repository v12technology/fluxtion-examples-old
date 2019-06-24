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
package com.fluxtion.casestudy.musicroyalty.fluxtioncfg;

import com.fluxtion.casestudy.musicroyalty.calcs.LocationRoyaltyFactor;
import com.fluxtion.casestudy.musicroyalty.calcs.RevenueCalculation;
import com.fluxtion.casestudy.musicroyalty.calcs.RoyaltyLookup;
import com.fluxtion.casestudy.musicroyalty.report.ReportGenerator;
import com.fluxtion.runtime.plugin.sep.AuditedSep;

/**
 *
 * @author gregp
 */
public class RoyaltyCalculatorSepCfg extends AuditedSep {

    @Override
    public void buildConfig() {
        RoyaltyLookup lookup = addNode(new RoyaltyLookup());
        RevenueCalculation revenueCalc = addNode(new RevenueCalculation(lookup,
                addNode(new LocationRoyaltyFactor())));
        ReportGenerator reporter = addPublicNode(new ReportGenerator(revenueCalc), "reporter");
    }

}
