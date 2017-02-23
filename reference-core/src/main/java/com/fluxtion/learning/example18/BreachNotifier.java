/* 
 * Copyright (C) 2016 Greg Higgins (greg.higgins@v12technology.com)
 *
 * This file is part of Fluxtion.
 *
 * Fluxtion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxtion.learning.example18;

import com.fluxtion.api.annotations.AfterEvent;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.api.annotations.OnParentUpdate;
import java.util.ArrayList;

/**
 *
 * @author Greg Higgins
 */
public class BreachNotifier {

    public AssetEventHandler[] assets;
    private ArrayList<AssetEventHandler> breachedAssets;

    private boolean notification;
    private boolean parentUpdated;

    public BreachNotifier(AssetEventHandler... assets) {
        this.assets = assets;
    }

    public BreachNotifier() {
    }

    @Initialise
    public void init() {
        breachedAssets = new ArrayList();
        notification = false;
        parentUpdated = false;
    }

    @OnParentUpdate
    public void assetBreached(AssetEventHandler assetHandler) {
        System.out.println("breach :" + assetHandler);
        breachedAssets.add(assetHandler);
        parentUpdated = true;
    }

    @OnEvent
    public void onEvent() {
    }

    @AfterEvent
    public void afterEvent() {     
        notification = parentUpdated;
        if (notification) {
            System.out.println("publishing breaches as a batch:");
            for (AssetEventHandler asset : breachedAssets) {
                System.out.println("\tbreached:" + asset);
            }
            System.out.println("------- batch end --------");
        } else {
            System.out.println("no changes");
        }
        breachedAssets.clear();
        parentUpdated = false;
    }

    /**
     * Get the value of notification, used for testing example
     *
     * @return the value of notification
     */
    public boolean isNotification() {
        return notification;
    }
}
