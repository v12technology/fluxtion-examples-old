/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluxtion.learning.fx.example6.reconciler.builder;


import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.generation.GenerationContext;
import com.fluxtion.extension.declarative.builder.factory.FunctionGeneratorHelper;
import static com.fluxtion.extension.declarative.builder.factory.FunctionKeys.functionClass;
import com.fluxtion.extension.declarative.builder.util.ImportMap;
import com.fluxtion.fx.eventhandler.TimeHandlerSeconds;
import com.fluxtion.fx.node.biascheck.TimedNotifier;
import com.fluxtion.learning.fx.example6.reconciler.events.TradeAcknowledgement;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileReportPublisher;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileUpdatePublisher;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ResultsCache;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeAcknowledgementAuditor;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayDeque;
import org.apache.velocity.VelocityContext;

/**
 * A utility for building a trade reconciler as a Static Event Processor.
 * 
 * Multiple source venues can be passed as an array, a TradeAcknowkedgement
 * must be received from all venues for a trade to be reconciled. If the time
 * for reconciliation expires before all trade venues acknowledge the trade
 * then the trade is marked as expired.
 * 
 * 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcilerBuilder {

    private String[] mandatorySources;
    private final ImportMap importMap;
    private static final String PACKAGE = "/template/fxreconciler";
    private static final String RECONCILER_TEMPLATE = PACKAGE + "/ReconcilerTemplate.vsl";
    
    public ReconcilerBuilder() {
        importMap = ImportMap.newMap();
        importMap.addImport(TradeReconciler.class);
        importMap.addImport(EventHandler.class);
        importMap.addImport(TradeAcknowledgement.class);
        importMap.addImport(TradeReconciler.class);
        importMap.addImport(Int2ObjectOpenHashMap.class);
        importMap.addImport(Initialise.class);
        importMap.addImport(ArrayDeque.class);
        importMap.addImport(TradeAcknowledgementAuditor.class);
        importMap.addImport(ReconcileStatus.class);
    }

    public void setMandatorySource(String[] sources) {
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

    public TradeReconciler build() {
        try {
            VelocityContext ctx = new VelocityContext();
            String genClassName = "TradeReconciler_" + GenerationContext.nextId();
            ctx.put(functionClass.name(), genClassName);
            ctx.put("reconcilerBuilder", this);
            ctx.put("imports", importMap.asString());
            ctx.put("matching", "received_" + String.join(" & received_", mandatorySources));
            ctx.put("venues", "\"" + String.join("\", \"", mandatorySources) + "\"");
            Class<TradeReconciler> aggClass = FunctionGeneratorHelper.generateAndCompile(null, RECONCILER_TEMPLATE, GenerationContext.SINGLETON, ctx);
            //auditor
            TradeAcknowledgementAuditor auditor = new TradeAcknowledgementAuditor();
            //reconciler - dynamically generated
            TradeReconciler result = aggClass.newInstance();
            aggClass.getField("tradeAcknowledgementCache").set(result, auditor);
            //update publisher
            ReconcileUpdatePublisher updatePublisher = new ReconcileUpdatePublisher();
            updatePublisher.reconiler = result;
            //cache
            ResultsCache cache = new ResultsCache();
            cache.reconiler = result;
            //alarm
            TimeHandlerSeconds timeHandler = new TimeHandlerSeconds();
            TimedNotifier notifier = new TimedNotifier(1, timeHandler);
            //report generator
            ReconcileReportPublisher resultsPublisher = new ReconcileReportPublisher();
            resultsPublisher.reconcileResultcCche = cache;
            resultsPublisher.alarm = notifier;
            //add items to the 
            GenerationContext.SINGLETON.getNodeList().add(auditor);
            GenerationContext.SINGLETON.getNodeList().add(result);
            GenerationContext.SINGLETON.getNodeList().add(timeHandler);
            GenerationContext.SINGLETON.getNodeList().add(notifier);
            GenerationContext.SINGLETON.getNodeList().add(updatePublisher);
            GenerationContext.SINGLETON.getNodeList().add(cache);
            GenerationContext.SINGLETON.getNodeList().add(resultsPublisher);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("could not build TradeReconciler " + e.getMessage(), e);
        }
    }
}
