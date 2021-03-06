/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.servers;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.ovirt.engine.api.resource.aaa.UserResource;
import org.ovirt.engine.api.v3.V3Server;
import org.ovirt.engine.api.v3.types.V3User;

@Produces({"application/xml", "application/json"})
public class V3UserServer extends V3Server<UserResource> {
    public V3UserServer(UserResource delegate) {
        super(delegate);
    }

    @GET
    public V3User get() {
        return adaptGet(getDelegate()::get);
    }

    @DELETE
    public Response remove() {
        return adaptRemove(getDelegate()::remove);
    }

    @Path("roles")
    public V3AssignedRolesServer getRolesResource() {
        return new V3AssignedRolesServer(getDelegate().getRolesResource());
    }

    @Path("permissions")
    public V3AssignedPermissionsServer getPermissionsResource() {
        return new V3AssignedPermissionsServer(getDelegate().getPermissionsResource());
    }

    @Path("tags")
    public V3AssignedTagsServer getTagsResource() {
        return new V3AssignedTagsServer(getDelegate().getTagsResource());
    }

    @Path("sshpublickeys")
    public V3SshPublicKeysServer getSshPublicKeysResource() {
        return new V3SshPublicKeysServer(getDelegate().getSshPublicKeysResource());
    }
}
