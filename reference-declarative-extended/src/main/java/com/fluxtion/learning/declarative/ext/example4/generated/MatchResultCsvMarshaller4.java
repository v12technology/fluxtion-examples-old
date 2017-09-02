package com.fluxtion.learning.declarative.ext.example4.generated;

import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.extension.declarative.funclib.api.event.CharEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2ByteBuffer;
import com.fluxtion.extension.declarative.funclib.api.ascii.Csv2Double;
import com.fluxtion.learning.declarative.ext.example4.MatchResult;

/**
 * generated Test wrapper.
 *
 * target class  : MatchResult
 * 
 * @author Greg Higgins
 */

public class MatchResultCsvMarshaller4 implements Wrapper<MatchResult> {

    private MatchResult target;
    public Csv2ByteBuffer csvSrc_0;
    public Csv2Double csvSrc_1;
    public Csv2ByteBuffer csvSrc_2;
    public Csv2Double csvSrc_3;
    private int headerLines = 1;

    @EventHandler(filterId = '\n')
    public boolean onEol(CharEvent event) {
        target.setHomeTeam((java.lang.String) csvSrc_0.asString());
        target.setHomeGoals((int) csvSrc_1.doubleValue());
        target.setAwayTeam((java.lang.String) csvSrc_2.asString());
        target.setAwayGoals((int) csvSrc_3.doubleValue());
    headerLines--;
    return headerLines < 0;
    }

    @Override
    public MatchResult event() {
        return target;
    }

    @Override
    public Class<MatchResult> eventClass() {
        return MatchResult.class;
    }

    @Initialise
    public void init(){
        target = new MatchResult();
    }

}


