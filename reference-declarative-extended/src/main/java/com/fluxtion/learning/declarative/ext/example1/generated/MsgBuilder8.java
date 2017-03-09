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
/**
 * Generated notificationToLogger. 
 *
 * @author Greg Higgins
 */
public class MsgBuilder8 extends MsgBuilder{

    //source operand inputs
    public com.fluxtion.learning.declarative.ext.example1.generated.FxTradeHandler source_FxTradeHandler_7;

    @OnEvent
    public boolean buildMessage() {
        if(!isGoodToLog())
            return false;
        msgSink.append("-> Trade recived:'");
        msgSink.append(((com.fluxtion.learning.declarative.ext.helpers.FxTrade)source_FxTradeHandler_7.event()).ccyPair());
        msgSink.append("'@dealt:'");
        msgSink.append(((com.fluxtion.learning.declarative.ext.helpers.FxTrade)source_FxTradeHandler_7.event()).dealt());
        msgSink.append("' contra:'");
        msgSink.append(((com.fluxtion.learning.declarative.ext.helpers.FxTrade)source_FxTradeHandler_7.event()).contra());
        msgSink.append("'");
        msgSink.append('\n');
        return true;
    }
}

