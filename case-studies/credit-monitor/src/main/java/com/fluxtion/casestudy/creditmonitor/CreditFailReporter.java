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
package com.fluxtion.casestudy.creditmonitor;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.runtime.plugin.nodes.EventLogNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gregp
 */
public class CreditFailReporter extends EventLogNode {

    private final Rules[] ruleSet;
    private List<Rules> failedRules;

    public CreditFailReporter(Rules... ruleSet) {
        this.ruleSet = ruleSet;
    }

    @OnParentUpdate
    public void onRuleFailure(Rules failedRule) {
        log.info("failure", failedRule.getClass().getSimpleName());
        if (!failedRules.contains(failedRule)) {
            failedRules.add(failedRule);
        }else{
            log.warn("doubleFailure", failedRule.getClass().getSimpleName());
        }
    }

    @OnEvent
    public void processFailedRules() {
        log.info("failedRuleCount", failedRules.size());
        failedRules.clear();
    }

    @Initialise
    public void init() {
        failedRules = new ArrayList<>();
    }
}
