/*
 * Copyright (C) 2018 gregp
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
package com.fluxtion.casestudy.creditmonitor.events;

import com.fluxtion.runtime.event.Event;

/**
 *
 * @author gregp
 */
public class PurchaseOrder extends Event{
    public long time;
    public double amount;
    public String id;

    @Override
    public String toString() {
        return "PurchaseOrder{" + "time=" + time + ", amount=" + amount + ", id=" + id + '}';
    }
    
}
