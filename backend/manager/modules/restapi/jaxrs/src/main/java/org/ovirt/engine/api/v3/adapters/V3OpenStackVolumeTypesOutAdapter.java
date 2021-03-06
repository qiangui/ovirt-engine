/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3OutAdapters.adaptOut;

import org.ovirt.engine.api.model.OpenStackVolumeTypes;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3OpenStackVolumeTypes;

public class V3OpenStackVolumeTypesOutAdapter implements V3Adapter<OpenStackVolumeTypes, V3OpenStackVolumeTypes> {
    @Override
    public V3OpenStackVolumeTypes adapt(OpenStackVolumeTypes from) {
        V3OpenStackVolumeTypes to = new V3OpenStackVolumeTypes();
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
        to.getOpenStackVolumeTypes().addAll(adaptOut(from.getOpenStackVolumeTypes()));
        return to;
    }
}
