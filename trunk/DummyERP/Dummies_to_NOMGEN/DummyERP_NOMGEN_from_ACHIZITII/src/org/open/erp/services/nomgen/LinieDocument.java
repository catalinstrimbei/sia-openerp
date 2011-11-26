package org.open.erp.services.nomgen;

public class LinieDocument {
public Integer linieDoc;
public Document document;
public Material material;
public Double cantitate;
public Double pret;
public Double TVA;
public LinieDocument(Integer linieDoc, Document document, Material material,
		Double cantitate, Double pret, Double tVA) {
	super();
	this.linieDoc = linieDoc;
	this.document = document;
	this.material = material;
	this.cantitate = cantitate;
	this.pret = pret;
	TVA = tVA;
}
public LinieDocument() {	
}
public Integer getLinieDoc() {
	return linieDoc;
}
public void setLinieDoc(Integer linieDoc) {
	this.linieDoc = linieDoc;
}
public Document getDocument() {
	return document;
}
public void setDocument(Document document) {
	this.document = document;
}
public Material getMaterial() {
	return material;
}
public void setMaterial(Material material) {
	this.material = material;
}
public Double getCantitate() {
	return cantitate;
}
public void setCantitate(Double cantitate) {
	this.cantitate = cantitate;
}
public Double getPret() {
	return pret;
}
public void setPret(Double pret) {
	this.pret = pret;
}
public Double getTVA() {
	return TVA;
}
public void setTVA(Double tVA) {
	TVA = tVA;
}
}
