package org.open.erp.services.nommat;

public class Material {
String codMaterial;
String denumireMaterial;
String cantitateStandard;
String pretStandard;
String procentTVACurent;
String observatii;
ListaCaracteristici listaCaracteristici;

public String getCantitateStandard() {
	return cantitateStandard;
}
public void setCantitateStandard(String cantitateStandard) {
	this.cantitateStandard = cantitateStandard;
}
public ListaCaracteristici getListaCaracteristici() {
	return listaCaracteristici;
}
public void setListaCaracteristici(ListaCaracteristici listaCaracteristici) {
	this.listaCaracteristici = listaCaracteristici;
}
public String getCodMaterial() {
	return codMaterial;
}
public void setCodMaterial(String codMaterial) {
	this.codMaterial = codMaterial;
}
public String getDenumireMaterial() {
	return denumireMaterial;
}
public void setDenumireMaterial(String denumireMaterial) {
	this.denumireMaterial = denumireMaterial;
}
public String getPretStandard() {
	return pretStandard;
}
public void setPretStandard(String pretStandard) {
	this.pretStandard = pretStandard;
}
public String getProcentTVACurent() {
	return procentTVACurent;
}
public void setProcentTVACurent(String procentTVACurent) {
	this.procentTVACurent = procentTVACurent;
}
public String getObservatii() {
	return observatii;
}
public void setObservatii(String observatii) {
	this.observatii = observatii;
}


public Material(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
		String procentTVACurent, String observatii, ListaCaracteristici listaCaracteristici) {
	super();
	this.codMaterial = codMaterial;
	this.denumireMaterial= denumireMaterial;
	this.cantitateStandard= cantitateStandard;
	this.pretStandard= pretStandard;
	this.procentTVACurent= procentTVACurent;
	this.observatii= observatii;
	
}
public Material() {
	super();
}


}
