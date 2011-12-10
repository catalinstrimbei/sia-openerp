package org.open.erp.services.nomgen;

import java.util.List;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class PersoanaJuridica extends Persoana {
	private String  denumire;
	private String  codFiscal;
	private String  nrInmatriculareFiscala;
	private String  atributFiscal;
	private List<String> telefoane;
	private List<String> emailuri;
	
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumire;
	}

	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}


	/**
	 * @return the codFiscal
	 */
	public String getCodFiscal() {
		return codFiscal;
	}

	/**
	 * @param codFiscal the codFiscal to set
	 */
	public void setCodFiscal(String codFiscal) {
		this.codFiscal = codFiscal;
	}


	/**
	 * @return the nrInmatriculareFiscala
	 */
	public String getNrInmatriculareFiscala() {
		return nrInmatriculareFiscala;
	}

	/**
	 * @param nrInmatriculareFiscala the nrInmatriculareFiscala to set
	 */
	public void setNrInmatriculareFiscala(String nrInmatriculareFiscala) {
		this.nrInmatriculareFiscala = nrInmatriculareFiscala;
	}


	/**
	 * @return the atributFiscal
	 */
	public String getAtributFiscal() {
		return atributFiscal;
	}

	/**
	 * @param atributFiscal the atributFiscal to set
	 */
	public void setAtributFiscal(String atributFiscal) {
		this.atributFiscal = atributFiscal;
	}
	
	public List<String> getTelefoane() {
		return telefoane;
	}

	public void setTelefoane(List<String> telefoane) {
		this.telefoane = telefoane;
	}

	public List<String> getEmailuri() {
		return emailuri;
	}

	public void setEmailuri(List<String> emailuri) {
		this.emailuri = emailuri;
	}

	public PersoanaJuridica(Integer id, String adresa, String denumire, String codFiscal, String nrInmatriculareFiscala, String atributFiscal) {
		super(id, adresa);
		
		this.denumire = denumire;
		this.codFiscal = codFiscal;
		this.nrInmatriculareFiscala = nrInmatriculareFiscala;
		this.atributFiscal = atributFiscal;
	}
	
	
	public PersoanaJuridica() {
		super();
	}
	
}