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
package com.fluxtion.casestudy.worldcity;

import com.fluxtion.api.annotations.OnEvent;
import com.fluxtion.extension.declarative.api.Wrapper;
import java.util.function.Consumer;

/**
 *
 * @author gregp
 */
public class RowDispatcher {

    private final Wrapper wrapper;
    private Consumer consumer;

    public RowDispatcher(Wrapper wrapper) {
        this.wrapper = wrapper;
        consumer = (o) ->{};
    }

    @OnEvent
    public void publishRow() {
        consumer.accept(wrapper.event());
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

}
