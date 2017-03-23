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
package com.fluxtion.learning.functional.example1;

import com.fluxtion.api.node.SEPConfig;
import static com.fluxtion.extension.declarative.builder.log.LogBuilder.Log;
import com.fluxtion.learning.functional.TemperatureEvent;

/**
 * Log to console the temperature reading on receipt of a temperature event.
 * 
 * The user declares the desired behaviour and functional plugins create an
 * implementation to meet the requirements.
 * 
 * The static helper methods Log and select generate helper classes, 
 * create instances, set references and register instances with Fluxtion.
 * 
 * @author greg
 */
public class TempHandlerBuilder extends SEPConfig {{
        Log("-> received temp: {}degC", TemperatureEvent.class, TemperatureEvent::getTemperature);
}}
