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
package com.fluxtion.learning.declarative.ext.example1.generated;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.log.MsgBuilder;
import com.fluxtion.api.annotations.NoEventReference;
import com.fluxtion.api.annotations.OnParentUpdate;
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder12 extends MsgBuilder{

    //source operand inputs
    @NoEventReference
    public com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_3 source_CumSumInvoker_3_11;
    @NoEventReference
    public com.fluxtion.learning.declarative.ext.example1.generated.CumSumInvoker_1 source_CumSumInvoker_1_10;
    @NoEventReference
    public com.fluxtion.learning.declarative.ext.example1.generated.SubtractInvoker_6 source_SubtractInvoker_6_9;
    public Object logNotifier;
    private boolean notificationToLog;
    
    @OnParentUpdate(value = "logNotifier")
    public void postLog(Object logNotifier){
        notificationToLog = true;
    }

    @OnEvent
    public boolean buildMessage() {
        if(notificationToLog & isGoodToLog()){
            msgSink.append("<- Position update: EUR net:'");
            msgSink.append(source_SubtractInvoker_6_9.intValue());
            msgSink.append("' dealt:'");
            msgSink.append(source_CumSumInvoker_1_10.intValue());
            msgSink.append("' contra:'");
            msgSink.append(source_CumSumInvoker_3_11.intValue());
            msgSink.append("'");
            msgSink.append('\n');
            notificationToLog = false;
            return true;
        }
        notificationToLog = false;
        return false;
    }
}

