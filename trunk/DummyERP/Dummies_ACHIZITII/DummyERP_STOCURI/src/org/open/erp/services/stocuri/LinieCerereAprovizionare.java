package org.open.erp.services.stocuri;

public class LinieCerereAprovizionare {
public Integer nrLinie;
public CerereAprovizionare cerereAprovizionare;
public org.open.erp.services.nomgen.Material Material;
public Integer getNrLinie() {
	return nrLinie;
}
public void setNrLinie(Integer nrLinie) {
	this.nrLinie = nrLinie;
}
public CerereAprovizionare getCerereAprovizionare() {
	return cerereAprovizionare;
}
public void setCerereAprovizionare(CerereAprovizionare cerereAprovizionare) {
	this.cerereAprovizionare = cerereAprovizionare;
}
public org.open.erp.services.nomgen.Material getMaterial() {
	return Material;
}
public void setMaterial(org.open.erp.services.nomgen.Material material) {
	Material = material;
}

}
