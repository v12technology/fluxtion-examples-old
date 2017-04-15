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
package com.fluxtion.learning.fx.example6;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.fx.example6.reconciler.builder.ReconcilerBuilder;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcilerSEP extends SEPConfig {

        public ReconcilerSEP() {
            //EBS reconciliation
            ReconcilerBuilder builder = new ReconcilerBuilder("EBS_LD4", 2, 5, 1);
            builder.setMandatorySource("EBS", "LD4", "TRIANA");
            builder.build();
            //Reuters reconciliation
            ReconcilerBuilder reuters_LD4 = new ReconcilerBuilder("REUTERS_COLO_1", 2, 10, 1);
            reuters_LD4.setMandatorySource("REUTERS", "COLO_1", "TRIANA");
            reuters_LD4.build();
        }

    }
