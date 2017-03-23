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
package com.fluxtion.learning.example14;

import com.fluxtion.api.annotations.EventHandler;
import com.fluxtion.api.annotations.Initialise;
import com.fluxtion.learning.example10.Handlers.StairHandler;
import com.fluxtion.learning.example10.Handlers.StepHandler;
import java.time.LocalDateTime;

/**
 * A prototype activity monitor demonstrating event value filtering. The
 * monitor handles:
 * <pre>
 * •	3-axis accewleration,
 * •	time ticks,
 * •	request to show activity
 * •	request to show time.
 *
 * The following functionality is provided:
 * •	Aggregate steps and stair count separately based on acceleration values.
 * •	Only update display when time ticks – NOT on acceleration events.
 * •	User action selects to display time or activity, update display on next tick.
 *
 * </pre>
 *
 * On a tick the either time or current accumulated activity will be displayed.
 *
 * The EventHandler value filtering allows simple logic to be
 * implemented in the time EventHandler method. If all the logic was carried out
 * in an OnEvent method it would be unclear which button had been pressed
 * without adding additional state and reseting the state at the end of the
 * event cycle. EventPath filtering greatly simplifies the code.
 *
 * @author greg
 */
public class ActivityMonitor {

    public StepHandler stepHandler;
    public StairHandler stairHandler;

    public ActivityMonitor(StepHandler stepHandler, StairHandler stairHandler) {
        this.stepHandler = stepHandler;
        this.stairHandler = stairHandler;
    }

    public ActivityMonitor() {
    }

    private boolean displayActivity;

    @EventHandler(filterString = "showTime")
    public void showTimeRequest(ActionEvent event) {
        displayActivity = false;
    }

    @EventHandler(filterString = "showActivity")
    public void showActivityRequest(ActionEvent event) {
        displayActivity = true;
    }

    @EventHandler(filterString = "tick")
    public void timeTick(ActionEvent tick) {
        if (displayActivity) {
            System.out.printf("Steps:%2d, Stairs:%2d\n", stepHandler.stepCount, stairHandler.stairCount);
        } else {
            System.out.println("current time:" + LocalDateTime.now().toLocalTime());
        }
    }

    @Initialise
    public void init() {
        displayActivity = true;
    }
}
