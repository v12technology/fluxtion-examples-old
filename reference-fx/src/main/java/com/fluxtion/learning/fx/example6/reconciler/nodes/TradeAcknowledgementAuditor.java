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
package com.fluxtion.learning.fx.example6.reconciler.nodes;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.fx.event.ListenerRegisration;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;
import com.fluxtion.learning.fx.example6.reconciler.extensions.TradeAcknowledgementListener;
import static com.fluxtion.learning.fx.example6.reconciler.extensions.TradeAcknowledgementListener.TA_LISTENER;

/**
 * Receives a TradeAcknowledgement and delegates to the registered auditor to
 * persist all incoming trade messages.
 *
 * A TradeAcknowledgementListener registers with the TradeAcknowledgementAuditor
 * using a ListenerRegisration event and pushing the event to the generated SEP.
 * Only a single auditor can be registered.
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class TradeAcknowledgementAuditor {

    public TradeAcknowledgement acknowledgement;
    private TradeAcknowledgementListener auditor;

    @EventHandler(propogate = false)
    public void auditAcknowledgemt(TradeAcknowledgement acknowledgement) {
        this.acknowledgement = acknowledgement;
        if (auditor != null) {
            auditor.processAcknowledgemnt(acknowledgement);
        }
    }

    @EventHandler(filterString = TA_LISTENER, propogate = false)
    public void registerAuditor(ListenerRegisration<TradeAcknowledgementListener> registration) {
        this.auditor = registration.getListener();
    }

}
