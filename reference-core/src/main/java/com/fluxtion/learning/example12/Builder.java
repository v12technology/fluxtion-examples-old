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
package com.fluxtion.learning.example12;

import com.fluxtion.api.node.SEPConfig;
import com.fluxtion.learning.example11.ActivityMonitor;
import com.fluxtion.learning.example12.Handlers.ActionHandler;
import com.fluxtion.learning.example12.Handlers.ShowActivityHandler;
import com.fluxtion.learning.example12.Handlers.ShowTickHandler;
import com.fluxtion.learning.example12.Handlers.ShowTimeHandler;

/**
 *
 * @author greg
 */
public class Builder extends SEPConfig {

    {
        ActionHandler[] handlers = new ActionHandler[]{
        addNode(new ShowTickHandler()),
        addNode(new ShowTimeHandler()),
        addNode(new ShowActivityHandler()),
        };
        
        addNode(new ActionArrayMonitor(handlers));
        
    }
}
