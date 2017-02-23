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
package com.fluxtion.learning.example19.generated;

import com.fluxtion.learning.example19.generated.*;
import com.fluxtion.learning.example18.AssetEvent;
import com.fluxtion.learning.example18.BreachNotifier;
import com.fluxtion.learning.example19.BatchingBreachNotifier;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Greg Higgins
 */
public class AssetMonitorTest {

	public AssetMonitorTest() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testOnEvent() {
		System.out.println("onEvent");
		// prepare events
		AssetEvent eventFX = new AssetEvent();
		eventFX.setPortfolioName("FX");
		eventFX.setValuation(100);
		AssetEvent eventCommodities = new AssetEvent();
		eventCommodities.setPortfolioName("Commodities");
		eventCommodities.setValuation(250);
		// prepare SEP
		BatchingAssetMonitor instance = new BatchingAssetMonitor();
		instance.init();
		BatchingBreachNotifier notifier = instance.notifier;
		// notification = false
		assertFalse(notifier.isNotification());
		// fire events
		instance.onEvent(eventFX);
		assertFalse(notifier.isNotification());
		eventFX.setValuation(101);
		instance.onEvent(eventFX);
		assertFalse(notifier.isNotification());
		eventFX.setValuation(135);
		instance.onEvent(eventFX);
		assertFalse(notifier.isNotification());
        instance.onEvent(eventCommodities);
		assertFalse(notifier.isNotification());
        eventCommodities.setValuation(500);
        instance.onEvent(eventCommodities);
		assertFalse(notifier.isNotification());
        //eob
        instance.batchEnd();
		assertTrue(notifier.isNotification());
	}

}