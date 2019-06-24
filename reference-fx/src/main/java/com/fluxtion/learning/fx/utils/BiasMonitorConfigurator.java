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
package com.fluxtion.learning.fx.utils;

import com.fluxtion.fx.BiasProcessor;
import com.fluxtion.fx.node.biascheck.NotificationHandler;
import com.fluxtion.fx.node.biascheck.OrderBiasResultHandler;
import com.fluxtion.fx.util.ConsoleAuditor;
import com.fluxtion.fx.util.ConsoleBiasResultHandler;
import com.fluxtion.fx.util.ConsoleBreachHandler;

/**
 *
 * @author V12 Technology Limited
 */
public interface BiasMonitorConfigurator {
    
    public static void register(BiasProcessor processor, ConsoleAuditor auditor, NotificationHandler notifier, OrderBiasResultHandler broadcaster){
        processor.registerBreachNotificationHandler(notifier);
        processor.registerEventAuditor(auditor);
        processor.registerResultsReceiver(broadcaster);
    }
    
    public static void registerConsoleHandlers(BiasProcessor processor){
        processor.registerBreachNotificationHandler(new ConsoleBreachHandler());
        processor.registerEventAuditor(new ConsoleAuditor());
        processor.registerResultsReceiver(new ConsoleBiasResultHandler());
    }
    
    
    
}
