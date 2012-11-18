package org.open.erp.services.nomgen;

public class PersoanaJuridica extends Persoana {

	String tipFirma;
	String CUI;
	String codFiscal;
	Adresa adresa;
	
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
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
		CUI = cUI;
	}
	public String getCodFiscal() {
		return codFiscal;
	}
	public void setCodFiscal(String codFiscal) {
		this.codFiscal = codFiscal;
	}
	public PersoanaJuridica(Integer id, String nume, 
			String denumireFirma, String tipFirma, String cUI, String codFiscal,Adresa adresa) {
		super(id, nume);
	
		this.tipFirma = tipFirma;
		CUI = cUI;
		this.codFiscal = codFiscal;
		this.adresa=adresa;
	}
	public PersoanaJuridica(Integer id, String nume) {
		super(id, nume);
	}

	
}
