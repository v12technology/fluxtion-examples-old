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
package com.fluxtion.learning.fx.example6;

import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileSummaryListener;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class SummaryListener implements ReconcileSummaryListener {

    public HashMap<String, SummaryDetails> reconciler2Update = new HashMap<>();
    public boolean logToConsole = false;

    @Override
    public void reconcileSummary(String reconcilerId, int matchedTrades, int reconcilingTrades, int unMatchedTrades) {
        if (logToConsole) {
            System.out.printf("reconciler:%s matched:%d matching:%d, expired:%d\n",
                    reconcilerId, matchedTrades, reconcilingTrades, unMatchedTrades);
        }
        reconciler2Update.compute(reconcilerId, (String key, SummaryDetails value) -> {
            if (value == null) {
                return new SummaryDetails(reconcilerId, matchedTrades, reconcilingTrades, unMatchedTrades);
            } else {
                value.reconcilerId = reconcilerId;
                value.matchedTrades = matchedTrades;
                value.reconcilingTrades = reconcilingTrades;
                value.unMatchedTrades = unMatchedTrades;
                return value;
            }
        });
    }

    public static class SummaryDetails {

        public SummaryDetails(String reconcilerId, int matchedTrades, int reconcilingTrades, int unMatchedTrades) {
            this.reconcilerId = reconcilerId;
            this.matchedTrades = matchedTrades;
            this.reconcilingTrades = reconcilingTrades;
            this.unMatchedTrades = unMatchedTrades;
        }

        String reconcilerId;
        int matchedTrades;
        int reconcilingTrades;
        int unMatchedTrades;

        @Override
        public String toString() {
            return "SummaryDetails{" + "reconcilerId=" + reconcilerId
                    + ", matchedTrades=" + matchedTrades
                    + ", reconcilingTrades=" + reconcilingTrades
                    + ", unMatchedTrades=" + unMatchedTrades
                    + '}';
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + Objects.hashCode(this.reconcilerId);
            hash = 97 * hash + this.matchedTrades;
            hash = 97 * hash + this.reconcilingTrades;
            hash = 97 * hash + this.unMatchedTrades;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final SummaryDetails other = (SummaryDetails) obj;
            if (this.matchedTrades != other.matchedTrades) {
                return false;
            }
            if (this.reconcilingTrades != other.reconcilingTrades) {
                return false;
            }
            if (this.unMatchedTrades != other.unMatchedTrades) {
                return false;
            }
            if (!Objects.equals(this.reconcilerId, other.reconcilerId)) {
                return false;
            }
            return true;
        }

    }
}
