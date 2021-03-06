/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3OutAdapters.adaptOut;

import org.ovirt.engine.api.model.Job;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3Job;
import org.ovirt.engine.api.v3.types.V3Status;

public class V3JobOutAdapter implements V3Adapter<Job, V3Job> {
    @Override
    public V3Job adapt(Job from) {
        V3Job to = new V3Job();
        if (from.isSetLinks()) {
            to.getLinks().addAll(adaptOut(from.getLinks()));
        }
        if (from.isSetActions()) {
            to.setActions(adaptOut(from.getActions()));
        }
        if (from.isSetAutoCleared()) {
            to.setAutoCleared(from.isAutoCleared());
        }
        if (from.isSetComment()) {
            to.setComment(from.getComment());
        }
        if (from.isSetDescription()) {
            to.setDescription(from.getDescription());
        }
        if (from.isSetEndTime()) {
            to.setEndTime(from.getEndTime());
        }
        if (from.isSetExternal()) {
            to.setExternal(from.isExternal());
        }
        if (from.isSetId()) {
            to.setId(from.getId());
        }
        if (from.isSetHref()) {
            to.setHref(from.getHref());
        }
        if (from.isSetLastUpdated()) {
            to.setLastUpdated(from.getLastUpdated());
        }
        if (from.isSetName()) {
            to.setName(from.getName());
        }
        if (from.isSetOwner()) {
            to.setOwner(adaptOut(from.getOwner()));
        }
        if (from.isSetStartTime()) {
            to.setStartTime(from.getStartTime());
        }
        if (from.isSetStatus()) {
            V3Status status = new V3Status();
            status.setState(from.getStatus().value().toUpperCase());
            to.setStatus(status);
        }
        return to;
    }
}
