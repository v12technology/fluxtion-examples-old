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
package com.fluxtion.learning.fx.example6.reconciler.builder;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import com.fluxtion.api.generation.GenerationContext;
import com.fluxtion.extension.declarative.builder.factory.FunctionGeneratorHelper;
import static com.fluxtion.extension.declarative.builder.factory.FunctionKeys.functionClass;
import com.fluxtion.extension.declarative.builder.util.ImportMap;
import com.fluxtion.fx.eventhandler.TimeHandlerSeconds;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReportGenerator;
import com.fluxtion.learning.fx.example6.reconciler.nodes.SummaryPublisher;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileCache;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayDeque;
import java.util.HashMap;
import org.apache.velocity.VelocityContext;

/**
 * A utility for building a trade reconciler as a Static Event Processor.
 *
 * Multiple source venues can be passed as an array, a TradeAcknowkedgement must
 * be received from all venues for a trade to be reconciled. If the time for
 * reconciliation expires before all trade venues acknowledge the trade then the
 * trade is marked as expired.
 *
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcilerBuilder {

    private String[] mandatorySources;
    private final String reconcilerId;
    private final TimedNotifier notifier;
    //globals - shared
    private final static ImportMap importMap;
    private final static TradeAcknowledgementAuditor auditor;
    private final static TimeHandlerSeconds timeHandler;
    private final static ReconcileCache cache;
    private final static HashMap<Integer, TimedNotifier> period2Notifier;
    //templates
    private static final String PACKAGE = "/template/fxreconciler";
    private static final String RECONCILER_TEMPLATE = PACKAGE + "/ReconcilerTemplate.vsl";

    public ReconcilerBuilder(String reconcilerId, int publishPeriod) {
        this.reconcilerId = reconcilerId;
        notifier = period2Notifier.computeIfAbsent(publishPeriod, period -> new TimedNotifier(period, timeHandler));
    }

    public void setMandatorySource(String... sources) {
        for (String source : sources) {
            if (source == null) {
                throw new IllegalArgumentException("source name is null valid name required");
            }
            if (source.length() < 1 && source.length() > 25) {
                throw new IllegalArgumentException("source name must be between 1 and 25 charsacters");
            }
        }
        this.mandatorySources = sources;
    }

    public String[] getMandatorySources() {
        return mandatorySources;
    }

    public String getReconcilerId() {
        return reconcilerId;
    }

    public TradeReconciler build() {
        try {
            //reconciler
            TradeReconciler reconciler = generateTradeReconciler();
            reconciler.auditor = auditor;
            reconciler.id = reconcilerId;
            reconciler.alarm = notifier;
            //cache
            cache.addReconciler(reconciler);
            //update publisher
            SummaryPublisher updatePublisher = new SummaryPublisher();
            updatePublisher.reconciler = reconciler;
            updatePublisher.alarm = notifier;
            //report generator
            ReportGenerator resultsPublisher = new ReportGenerator();
            resultsPublisher.reconcileStatusCache = cache;
            resultsPublisher.alarm = notifier;
            resultsPublisher.id = getReconcilerId();
            //add items to the event graph in any order, Fluxtion will figure 
            //out all the optimal event delegation :)
            GenerationContext.SINGLETON.getNodeList().add(auditor);
            GenerationContext.SINGLETON.getNodeList().add(reconciler);
            GenerationContext.SINGLETON.getNodeList().add(timeHandler);
            GenerationContext.SINGLETON.getNodeList().add(notifier);
            GenerationContext.SINGLETON.getNodeList().add(updatePublisher);
            GenerationContext.SINGLETON.getNodeList().add(cache);
            GenerationContext.SINGLETON.getNodeList().add(resultsPublisher);
            return reconciler;
        } catch (Exception e) {
            throw new RuntimeException("could not build TradeReconciler " + e.getMessage(), e);
        }
    }

    private TradeReconciler generateTradeReconciler() throws Exception {
        VelocityContext ctx = new VelocityContext();
        String genClassName = "TradeReconciler_" + reconcilerId;
        ctx.put(functionClass.name(), genClassName);
        ctx.put("reconcilerBuilder", this);
        ctx.put("imports", importMap.asString());
        ctx.put("matching", "received_" + String.join(" & received_", mandatorySources));
        ctx.put("venues", "\"" + String.join("\", \"", mandatorySources) + "\"");
        Class<TradeReconciler> aggClass = FunctionGeneratorHelper.generateAndCompile(null, RECONCILER_TEMPLATE, GenerationContext.SINGLETON, ctx);
        //reconciler - dynamically generated
        TradeReconciler result = aggClass.newInstance();
//        aggClass.getField("auditor").set(result, auditor);
        return result;
    }

    static {
        auditor = new TradeAcknowledgementAuditor();
        timeHandler = new TimeHandlerSeconds();
        cache = new ReconcileCache();
        period2Notifier = new HashMap<>();
        period2Notifier.put(1, new TimedNotifier(1, timeHandler));
        period2Notifier.put(3, new TimedNotifier(1, timeHandler));
        importMap = ImportMap.newMap();
        importMap.addImport(TradeReconciler.class);
        importMap.addImport(EventHandler.class);
        importMap.addImport(TradeAcknowledgement.class);
        importMap.addImport(TradeReconciler.class);
        importMap.addImport(Int2ObjectOpenHashMap.class);
        importMap.addImport(Initialise.class);
        importMap.addImport(OnEvent.class);
        importMap.addImport(OnParentUpdate.class);
        importMap.addImport(TimedNotifier.class);
        importMap.addImport(TradeAcknowledgementAuditor.class);
        importMap.addImport(ArrayDeque.class);
        importMap.addImport(ReconcileStatus.class);
    }
}
