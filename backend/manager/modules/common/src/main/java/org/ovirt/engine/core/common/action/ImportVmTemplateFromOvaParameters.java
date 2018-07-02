package org.ovirt.engine.core.common.action;

import org.ovirt.engine.core.common.businessentities.VmTemplate;
import org.ovirt.engine.core.compat.Guid;

public class ImportVmTemplateFromOvaParameters extends ImportVmTemplateParameters {

    public enum Phase {
        CREATE_DISKS,
        CONVERT
    }

    private String ovaPath;
    private Guid proxyHostId;
    private Phase importPhase = Phase.CREATE_DISKS;

    public ImportVmTemplateFromOvaParameters() {
    }

    public ImportVmTemplateFromOvaParameters(VmTemplate template, Guid destStorageDomainId, Guid storagePoolId, Guid clusterId) {
        super(storagePoolId, Guid.Empty, destStorageDomainId, clusterId, template);
    }

    public String getOvaPath() {
        return ovaPath;
    }

    public void setOvaPath(String ovaPath) {
        this.ovaPath = ovaPath;
    }

    public Guid getProxyHostId() {
        return proxyHostId;
    }

    public void setProxyHostId(Guid proxyHostId) {
        this.proxyHostId = proxyHostId;
    }

    public Phase getImportPhase() {
        return importPhase;
    }

    public void setImportPhase(Phase importPhase) {
        this.importPhase = importPhase;
    }
}
