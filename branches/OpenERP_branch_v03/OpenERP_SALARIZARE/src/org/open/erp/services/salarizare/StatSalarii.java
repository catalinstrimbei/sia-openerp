package org.open.erp.services.salarizare;

public class StatSalarii {
	private Pontaj pontaj;
	private Double cas;
	private Double cass;
	private Double somaj;
	private Double alteRetineri;
	private Double alteSporuri;
	private Double salarBrut;
	private Double impozit;
	private Double salarNet;
	public StatSalarii() {
		super();
	}
	public Pontaj getPontaj() {
		return pontaj;
	}
	public void setPontaj(Pontaj pontaj) {
		this.pontaj = pontaj;
	}
	public Double getCas() {
		return cas;
	}
	public void setCas(Double cas) {
		this.cas = cas;
	}
	public Double getCass() {
		return cass;
	}
	public void setCass(Double cass) {
		this.cass = cass;
	}
	public Double getSomaj() {
		return somaj;
	}
	public void setSomaj(Double somaj) {
		this.somaj = somaj;
	}
	public Double getAlteRetineri() {
		return alteRetineri;
	}
	public void setAlteRetineri(Double alteRetineri) {
		this.alteRetineri = alteRetineri;
	}
	public Double getAlteSporuri() {
		return alteSporuri;
	}
	public void setAlteSporuri(Double alteSporuri) {
		this.alteSporuri = alteSporuri;
	}
	public Double getSalarBrut() {
		return salarBrut;
	}
	public void setSalarBrut(Double salarBrut) {
		this.salarBrut = salarBrut;
	}
	public Double getImpozit() {
		return impozit;
	}
	public void setImpozit(Double impozit) {
		this.impozit = impozit;
	}
	public Double getSalarNet() {
		return salarNet;
	}
	public void setSalarNet(Double salarNet) {
		this.salarNet = salarNet;
	}
	
}
