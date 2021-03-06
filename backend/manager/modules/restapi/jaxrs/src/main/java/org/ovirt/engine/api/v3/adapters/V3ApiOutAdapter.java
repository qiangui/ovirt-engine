/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static java.util.stream.Collectors.toList;
import static org.ovirt.engine.api.v3.adapters.V3OutAdapters.adaptOut;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ovirt.engine.api.model.Api;
import org.ovirt.engine.api.model.Link;
import org.ovirt.engine.api.restapi.invocation.Current;
import org.ovirt.engine.api.restapi.invocation.CurrentManager;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3API;
import org.ovirt.engine.api.v3.types.V3Link;

public class V3ApiOutAdapter implements V3Adapter<Api, V3API> {
    // The list of "rels" that should be removed from the set of links created by version 4 of the API, as they are
    // new and shouldn't appear in version 3 of the API:
    private static final Set<String> RELS_TO_REMOVE = new HashSet<>();

    static {
        RELS_TO_REMOVE.add("affinitylabels");
        RELS_TO_REMOVE.add("clusterlevels");
        RELS_TO_REMOVE.add("networkfilters");
        RELS_TO_REMOVE.add("imagetransfers");
    }

    @Override
    public V3API adapt(Api from) {
        V3API to = new V3API();
        if (from.isSetActions()) {
            to.setActions(adaptOut(from.getActions()));
        }

        // Remove the links for "rels" that are new in version 4 of the API:
        if (from.isSetLinks()) {
            List<Link> links = from.getLinks().stream()
                .filter(link -> !RELS_TO_REMOVE.contains(link.getRel()))
                .collect(toList());
            to.getLinks().addAll(adaptOut(links));
        }

        // In version 4 of the API the "capabilities" resource was removed, but it still exists in version 3, so we
        // need to explicitly add a the link:
        to.getLinks().add(0, makeCapabilitiesLink());

        if (from.isSetSpecialObjects()) {
            to.setSpecialObjects(adaptOut(from.getSpecialObjects()));
        }
        if (from.isSetProductInfo()) {
            to.setProductInfo(adaptOut(from.getProductInfo()));
        }
        if (from.isSetSummary()) {
            to.setSummary(adaptOut(from.getSummary()));
        }
        if (from.isSetTime()) {
            to.setTime(from.getTime());
        }
        return to;
    }

    private V3Link makeCapabilitiesLink() {
        // Calculate the href:
        Current current = CurrentManager.get();
        String href = current.getAbsolutePath("capabilities");

        // Make the link:
        V3Link link = new V3Link();
        link.setRel("capabilities");
        link.setHref(href);

        return link;
    }
}
