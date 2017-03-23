package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.extension.declarative.api.EventWrapper;
import com.fluxtion.learning.declarative.ext.helpers.FxTrade;

/**
 * Generated EventHandler for FxTrade
 * @author Greg Higgins
 */
public class FxTradeHandler implements EventWrapper<FxTrade>{

    private FxTrade event;

    @EventHandler
    public boolean handleFxTrade(FxTrade event){
        this.event = event;
        return true;
    }

//    @EventHandler
//    public void handleFxTrade(FxTrade event){
//        this.event = event;
//    }
//    
    @Override
    public FxTrade event() {
        return event;
    }

    @Override
    public Class<FxTrade> eventClass() {
        return FxTrade.class;
    }

}
