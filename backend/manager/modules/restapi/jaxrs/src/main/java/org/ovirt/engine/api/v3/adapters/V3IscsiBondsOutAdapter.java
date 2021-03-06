/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3OutAdapters.adaptOut;

import org.ovirt.engine.api.model.IscsiBonds;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3IscsiBonds;

public class V3IscsiBondsOutAdapter implements V3Adapter<IscsiBonds, V3IscsiBonds> {
    @Override
    public V3IscsiBonds adapt(IscsiBonds from) {
        V3IscsiBonds to = new V3IscsiBonds();
        if (from.isSetActions()) {
            to.setActions(adaptOut(from.getActions()));
        }
        if (from.isSetActive()) {
            to.setActive(from.getActive());
        }
        if (from.isSetSize()) {
            to.setSize(from.getSize());
        }
        if (from.isSetTotal()) {
            to.setTotal(from.getTotal());
        }
        to.getIscsiBonds().addAll(adaptOut(from.getIscsiBonds()));
        return to;
    }
}
