package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
public class PersoanaJuridica extends Persoana implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  denumire;
	private String  codFiscal;
	private String  nrInmatriculareFiscala;
	private String  atributFiscal;

	
	@OneToOne @JoinColumn(name= "id")
	private Persoana p;
	
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
	


	public Persoana getP() {
		return p;
	}

	public void setP(Persoana p) {
		this.p = p;
	}

	public PersoanaJuridica(Integer id, String adresa, String denumire, String codFiscal, String nrInmatriculareFiscala, String atributFiscal) {
		super(id, adresa);
		
		this.denumire = denumire;
		this.codFiscal = codFiscal;
		this.nrInmatriculareFiscala = nrInmatriculareFiscala;
		this.atributFiscal = atributFiscal;
	}
	
	


	public PersoanaJuridica(Integer id, Departament dep, String adresa,
			List<String> telefoane2, List<String> emailuri2, String denumire,
			String codFiscal, String nrInmatriculareFiscala,
			String atributFiscal, Persoana p) {
		super();
		this.denumire = denumire;
		this.codFiscal = codFiscal;
		this.nrInmatriculareFiscala = nrInmatriculareFiscala;
		this.atributFiscal = atributFiscal;
		this.p = p;
	}

	public PersoanaJuridica() {
		super();
	}

	public PersoanaJuridica(String denumire, String codFiscal,
			String nrInmatriculareFiscala, String atributFiscal) {
		super();
		this.denumire = denumire;
		this.codFiscal = codFiscal;
		this.nrInmatriculareFiscala = nrInmatriculareFiscala;
		this.atributFiscal = atributFiscal;
	}
	
}