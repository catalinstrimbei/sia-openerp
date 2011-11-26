package org.open.erp.services.plati;

public class Creditori {
	private Integer idCreditor;
	private String denumire;
	private String adresa;
	private Integer CIF;
	private String banca;
	private String IBAN;
	
	public Integer getIdCreditor() {
		return idCreditor;
	}
	public void setIdCreditor(Integer idCreditor) {
		this.idCreditor = idCreditor;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Integer getCIF() {
		return CIF;
	}
	public void setCIF(Integer cIF) {
		CIF = cIF;
	}
	public String getBanca() {
		return banca;
	}
	public void setBanca(String banca) {
		this.banca = banca;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	
}
