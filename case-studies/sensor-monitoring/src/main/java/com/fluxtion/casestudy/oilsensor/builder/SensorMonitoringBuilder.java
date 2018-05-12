/*
 * Copyright (C) 2018 greg
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
package com.fluxtion.casestudy.oilsensor.builder;

import com.fluxtion.api.node.NodeFactory;
import com.fluxtion.api.node.NodeRegistry;
import com.fluxtion.casestudy.oilsensor.nodes.AlarmNotifier;
import com.fluxtion.extension.declarative.api.Wrapper;
import com.fluxtion.extension.declarative.builder.event.EventSelect;
import com.fluxtion.extension.declarative.builder.log.LogBuilder;
import com.fluxtion.extension.declarative.funclib.builder.test.GreaterThanHelper;
import com.fluxtion.extension.declarative.funclib.builder.test.LessThanHelper;
import com.fluxtion.runtime.plugin.events.NumericSignal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author greg
 */
public class SensorMonitoringBuilder implements NodeFactory<AlarmNotifier> {

    private NodeRegistry registry;
    private static int count;

    @Override
    public AlarmNotifier createNode(Map config, NodeRegistry registry) {
        this.registry = registry;
        List<Map> list = (List) config.get("sensors");
        System.out.println("config:" + list);
        for (Map ele : list) {
            //{sensor=WellPressure, name=well 1, max=1000, min=100}
            String sensor = (String) ele.get("sensor");
            String name = (String) ele.get("name");
            int max = (Integer) ele.get("max");
            int min = (Integer) ele.get("min");
//            int min = Integer.parseInt((String) ele.get("min"));
            buildMonitor(min, max, sensor, name);
        }
//        buildMonitor(10, 250, "WellPressure", null);
//        buildMonitor(10, 250, "WellPressure", "well 1");
//        buildMonitor(150, 325, "SoilPressure", "well 1");
//        buildMonitor(100, 655, "SoilPressure", "well XXXX");
        return new AlarmNotifier();
    }

    public void buildMonitor(int criticalMin, final int criticalMax, String eventClassName, String filter) {
        try {
            Class<? extends NumericSignal> clazz;
            clazz = (Class<NumericSignal>) Class.forName("com.fluxtion.casestudy.oilsensor.events." + eventClassName);
            LogBuilder.Log("critical max exceeded:{}", 
                    GreaterThanHelper.greaterThanFilterOnce(clazz, NumericSignal::value, criticalMax), 
                    NumericSignal::value);
            LogBuilder.Log("critical min breached:{}", 
                    LessThanHelper.lessThanFilterOnce(clazz, NumericSignal::value, criticalMax), 
                    NumericSignal::value);

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void buildMonitorOLD(int criticalMin, final int criticalMax, String eventClassName, String filter) {
        Class<? extends NumericSignal> clazz;
        try {
            clazz = (Class<NumericSignal>) Class.forName("com.fluxtion.casestudy.oilsensor.events." + eventClassName);
            if (filter == null || filter.length() < 1) {

                registry.registerNode(EventSelect.select(clazz), name());
                final Wrapper<? extends NumericSignal> criticalMaxTest
                        = GreaterThanHelper.greaterThanFilterOnce(clazz, NumericSignal::value, criticalMax);
                registry.registerNode(criticalMaxTest, null);
                registry.registerNode(LogBuilder.Log("critical max exceeded:{}", criticalMaxTest, NumericSignal::value), null);
                final Wrapper<? extends NumericSignal> criticalMinTest
                        = LessThanHelper.lessThanFilterOnce(clazz, NumericSignal::value, criticalMin);
                registry.registerNode(criticalMinTest, null);
                registry.registerNode(LogBuilder.Log("critical min breached:{}", criticalMinTest, NumericSignal::value), null);
            } else {
                registry.registerNode(EventSelect.select(clazz, filter), name());
                final String[] filterArr = new String[]{filter};
                final Wrapper<? extends NumericSignal> criticalMaxTest
                        = GreaterThanHelper.greaterThanFilterOnce(clazz, NumericSignal::value, filterArr, criticalMax);
                registry.registerNode(criticalMaxTest, null);
                registry.registerNode(LogBuilder.Log("critical max exceeded:{}", criticalMaxTest, NumericSignal::value), null);
                final Wrapper<? extends NumericSignal> criticalMinTest
                        = LessThanHelper.lessThanFilterOnce(clazz, NumericSignal::value, filterArr, criticalMin);
                registry.registerNode(criticalMinTest, null);
                registry.registerNode(LogBuilder.Log("critical min breached:{}", criticalMinTest, NumericSignal::value), null);
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    private String name() {
        return "handler" + count++;
    }

}
