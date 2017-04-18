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

import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileReportPublisher;
import com.fluxtion.learning.fx.example6.reconciler.extensions.ReconcileStatusCache.ReconcileKey;
import com.fluxtion.learning.fx.example6.reconciler.helpers.ReconcileStatus;
import com.fluxtion.learning.fx.example6.reconciler.nodes.ReconcileCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 *
 * @author Greg Higgins (greg.higgins@V12technology.com)
 */
public class TestReportPublisher implements ReconcileReportPublisher {

    @Override
    public void publishReport(ReconcileCache reconcileResultcCche, String reconcilerId) {
        final StringBuilder sb = new StringBuilder("{reconciler: " + reconcilerId + ", records:[\n");
        boolean[] ans = new boolean[]{false};
        reconcileResultcCche.stream((ReconcileKey t, ReconcileStatus u) -> {
            if (t.reconcileId.equals(reconcilerId)) {
                u.appendAsJson(sb);
                sb.append(",\n");
                ans[0] = true;
            }
        });
        sb.setLength(sb.lastIndexOf(","));
        sb.append("\n]}");
        if(ans[0]){
            System.out.println("AS JSON:\n" + sb.toString());
        }
    }

}
