/*
 * Copyright (C) 2017 Greg Higgins (greg.higgins@V12technology.com)
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
package com.fluxtion.learning.fx.example6;

import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileCache;
import com.fluxtion.learning.fx.example6.reconciler.nodes.TradeReconciler;
import com.fluxtion.runtime.lifecycle.EventHandler;
import com.fluxtion.runtime.lifecycle.Lifecycle;
import java.lang.reflect.Field;
import java.util.Arrays;
import static java.util.Arrays.stream;
import java.util.stream.Collectors;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Tests for 
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class ReconcilerTest {

    private EventHandler reconciler;
    private ReconcileCache cache;

    @Before
    public void beforeTest() throws Exception {
        reconciler = (EventHandler & Lifecycle) Class.forName("com.fluxtion.learning.fx.example6.generated.ReconcilerExample6").newInstance();
        ((Lifecycle) reconciler).init();
        Field field = new Mirror().on(reconciler.getClass()).reflect().field("reconcileCache_Global");
        field.setAccessible(true);
        cache = (ReconcileCache) field.get(reconciler);
    }

    @Test
    public void testReconcilerIds() {
        assertThat(stream(cache.reconcilers).map(i -> i.id).toArray(),
                arrayContainingInAnyOrder("REUTERS_DC1", "EBS_LD4", "EBS_NY2", "FXALL_NY3"));
    }

}
