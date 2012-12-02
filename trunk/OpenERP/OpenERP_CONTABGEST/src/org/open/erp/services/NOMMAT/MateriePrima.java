package org.open.erp.services.NOMMAT;

public class MateriePrima {
String codMaterial;
String denumireMaterial;
String cantitateStandard;
Double pretStandard;
String procentTVACurent;
String observatii;
//ListaCaracteristici listaCaracteristici;

public String getCantitateStandard() {
	return cantitateStandard;
}
public void setCantitateStandard(String cantitateStandard) {
	this.cantitateStandard = cantitateStandard;
}
//public ListaCaracteristici getListaCaracteristici() {
//	return listaCaracteristici;
//}
//public void setListaCaracteristici(ListaCaracteristici listaCaracteristici) {
//	this.listaCaracteristici = listaCaracteristici;
//}
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
public Double getPretStandard() {
	return pretStandard;
}
public void setPretStandard(Double pretStandard) {
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


public MateriePrima(String codMaterial, String denumireMaterial, String cantitateStandard, Double pretStandard,
		String procentTVACurent, String observatii) {
	super();
	this.codMaterial = codMaterial;
	this.denumireMaterial= denumireMaterial;
	this.cantitateStandard= cantitateStandard;
	this.pretStandard= pretStandard;
	this.procentTVACurent= procentTVACurent;
	this.observatii= observatii;
	
}
public MateriePrima() {
	super();
}


}
