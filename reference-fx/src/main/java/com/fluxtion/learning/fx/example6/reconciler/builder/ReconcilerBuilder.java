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

import com.fluxtion.api.annotations.AfterEvent;
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
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    private String[] oneOfSources;
    private final String reconcilerId;
    private final TimedNotifier reconileExpiryNotifier;
    private final TimedNotifier publishNotifier;
    //globals - shared
    private final static ImportMap IMPORT_MAP;
    private final static TradeAcknowledgementAuditor AUDITOR;
    private final static TimeHandlerSeconds TIME_HANDLER;
    private final static ReconcileCache CACHE;
    private final static HashMap<Integer, TimedNotifier> PERIOD_2_NOTIFIER;
    //templates
    private static final String PACKAGE = "/template/fxreconciler";
    private static final String RECONCILER_TEMPLATE = PACKAGE + "/ReconcilerTemplate.vsl";
    private final int reconcileTimeout;

    public ReconcilerBuilder(String reconcilerId,
            int reconcileTimeout,
            int publishFrequency,
            int reapExpiredFrequency) {
        this.reconcilerId = reconcilerId;
        this.reconcileTimeout = reconcileTimeout;
        reconileExpiryNotifier = PERIOD_2_NOTIFIER.computeIfAbsent(reapExpiredFrequency, period -> new TimedNotifier(period, TIME_HANDLER));
        publishNotifier = PERIOD_2_NOTIFIER.computeIfAbsent(publishFrequency, period -> new TimedNotifier(period, TIME_HANDLER));
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

    public String[] getOneOfSources() {
        return oneOfSources;
    }

    public void setOneOfSources(String... oneOfSources) {
        this.oneOfSources = oneOfSources;
    }

    public List<String> getSources() {
        ArrayList<String> l = new ArrayList();
        l.addAll(Arrays.asList(mandatorySources));
        if (oneOfSources != null) {
            l.addAll(Arrays.asList(oneOfSources));
        }
        return l;
    }

    public String getReconcilerId() {
        return reconcilerId;
    }

    public TradeReconciler build(List nodeList) {

        try {
            //reconciler
            TradeReconciler reconciler = generateTradeReconciler();
            reconciler.auditor = AUDITOR;
            reconciler.id = reconcilerId;
            reconciler.reconcileTimeout = reconcileTimeout;
            reconciler.alarmReapExpired = reconileExpiryNotifier;
            //cache
            CACHE.addReconciler(reconciler);
            //update publisher
            SummaryPublisher updatePublisher = new SummaryPublisher();
            updatePublisher.reconciler = reconciler;
            updatePublisher.alarm = publishNotifier;
            //report generator
            ReportGenerator resultsPublisher = new ReportGenerator();
            resultsPublisher.reconcileStatusCache = CACHE;
            resultsPublisher.alarm = publishNotifier;
            resultsPublisher.id = getReconcilerId();
            //add items to the event graph in any order, Fluxtion will figure 
            //out all the optimal event delegation :)
            nodeList.add(AUDITOR);
            nodeList.add(reconciler);
            nodeList.add(TIME_HANDLER);
            nodeList.add(reconileExpiryNotifier);
            nodeList.add(publishNotifier);
            nodeList.add(updatePublisher);
            nodeList.add(CACHE);
            nodeList.add(resultsPublisher);
            return reconciler;
        } catch (Exception e) {
            throw new RuntimeException("could not build TradeReconciler " + e.getMessage(), e);
        }
    }

    public TradeReconciler build() {
        return build(GenerationContext.SINGLETON.getNodeList());
    }

    private TradeReconciler generateTradeReconciler() throws Exception {
        VelocityContext ctx = new VelocityContext();
        String genClassName = "Reconciler_" + reconcilerId;
        ctx.put(functionClass.name(), genClassName);
        ctx.put("reconcilerBuilder", this);
        ctx.put("imports", IMPORT_MAP.asString());
        if (oneOfSources == null) {
            ctx.put("matching", "time_" + String.join(" > 0 & time_", mandatorySources) + " > 0");
        } else {
            ctx.put("matching", "time_" + String.join(" > 0 & time_", mandatorySources) + " > 0 & ( time_"  + String.join(" > 0 | time_", oneOfSources) + " > 0)");
            ctx.put("oneOfSources", "\"" + String.join("\", \"", oneOfSources) + "\"");
        }
        ctx.put("venues", "\"" + String.join("\", \"", mandatorySources) + "\"");
        Class<TradeReconciler> aggClass = FunctionGeneratorHelper.generateAndCompile(null, RECONCILER_TEMPLATE, GenerationContext.SINGLETON, ctx);
        //reconciler - dynamically generated
        TradeReconciler result = aggClass.newInstance();
//        aggClass.getField("auditor").set(result, auditor);
        return result;
    }

    static {
        AUDITOR = new TradeAcknowledgementAuditor();
        TIME_HANDLER = new TimeHandlerSeconds();
        CACHE = new ReconcileCache();
        PERIOD_2_NOTIFIER = new HashMap<>();
        IMPORT_MAP = ImportMap.newMap();
        IMPORT_MAP.addImport(TradeReconciler.class);
        IMPORT_MAP.addImport(EventHandler.class);
        IMPORT_MAP.addImport(TradeAcknowledgement.class);
        IMPORT_MAP.addImport(TradeReconciler.class);
        IMPORT_MAP.addImport(Int2ObjectOpenHashMap.class);
        IMPORT_MAP.addImport(Initialise.class);
        IMPORT_MAP.addImport(OnEvent.class);
        IMPORT_MAP.addImport(OnParentUpdate.class);
        IMPORT_MAP.addImport(TimedNotifier.class);
        IMPORT_MAP.addImport(TradeAcknowledgementAuditor.class);
        IMPORT_MAP.addImport(ArrayDeque.class);
        IMPORT_MAP.addImport(ArrayList.class);
        IMPORT_MAP.addImport(ReconcileStatus.class);
        IMPORT_MAP.addImport(AfterEvent.class);
        IMPORT_MAP.addImport(Int2ObjectMap.class);
        IMPORT_MAP.addImport(ObjectIterator.class);
    }
}
