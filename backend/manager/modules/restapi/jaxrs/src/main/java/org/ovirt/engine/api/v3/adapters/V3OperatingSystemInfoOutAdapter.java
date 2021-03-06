/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3OutAdapters.adaptOut;

import org.ovirt.engine.api.model.OperatingSystemInfo;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3OperatingSystemInfo;

public class V3OperatingSystemInfoOutAdapter implements V3Adapter<OperatingSystemInfo, V3OperatingSystemInfo> {
    @Override
    public V3OperatingSystemInfo adapt(OperatingSystemInfo from) {
        V3OperatingSystemInfo to = new V3OperatingSystemInfo();
        if (from.isSetLinks()) {
            to.getLinks().addAll(adaptOut(from.getLinks()));
        }
        if (from.isSetActions()) {
            to.setActions(adaptOut(from.getActions()));
        }
        if (from.isSetComment()) {
            to.setComment(from.getComment());
        }
        if (from.isSetDescription()) {
            to.setDescription(from.getDescription());
        }
        if (from.isSetId()) {
            to.setId(from.getId());
        }
        if (from.isSetHref()) {
            to.setHref(from.getHref());
        }
        if (from.isSetLargeIcon()) {
            to.setLargeIcon(adaptOut(from.getLargeIcon()));
        }
        if (from.isSetName()) {
            to.setName(from.getName());
        }
        if (from.isSetSmallIcon()) {
            to.setSmallIcon(adaptOut(from.getSmallIcon()));
        }
        return to;
    }
}
