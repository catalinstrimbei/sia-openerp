package org.open.erp.services.nomgen;

public class Companie{
	private Integer id;
	private String nume;
	private String tipFirma;
	private String CUI;
	private String codFiscal;
	private String adresa;
		 
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNume() {
		return nume;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTipFirma() {
		return tipFirma;
	}
	
	public void setTipFirma(String tipFirma) {
		this.tipFirma = tipFirma;
	}
	
	public String getCUI() {
		return CUI;
	}
	public void setCUI(String cUI) {
		this.CUI = cUI;
	}
	public String getCodFiscal() {
		return codFiscal;
	}
	public void setCodFiscal(String codFiscal) {
		this.codFiscal = codFiscal;
	}

	public Companie(Integer id, String nume, String denumireFirma, String tipFirma, String cUI, String codFiscal, String adresa) {
		super();
		this.id = id;
		this.nume = nume;
		this.tipFirma = tipFirma;
		this.CUI = cUI;
		this.codFiscal = codFiscal;
		this.adresa=adresa;
	}
	
	public Companie(){
		super();
	}
}
