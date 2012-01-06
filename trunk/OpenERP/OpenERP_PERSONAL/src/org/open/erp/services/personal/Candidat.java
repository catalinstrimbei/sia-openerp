package org.open.erp.services.personal;

import java.io.Serializable;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.PersoanaFizica;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
//TODO    adauga Jar si clasa PersoanaFizica in persistence.xml
@Entity
public class Candidat extends PersoanaFizica implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer		idCandidat;
	private String 		tipCandidat;
	
	public Integer getIdCandidat() {
		return idCandidat;
	}
	public void setIdCandidat(Integer idCandidat) {
		this.idCandidat = idCandidat;
	}
	public String getTipCandidat() {
		return tipCandidat;
	}
	public void setTipCandidat(String tipCandidat) {
		this.tipCandidat = tipCandidat;
	}
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidat(Integer id, String adresa, String nume,
			String prenume, String formaAdresare, char gen, String cnp) {
		super(id, adresa, nume, prenume, formaAdresare, gen, cnp);
		// TODO Auto-generated constructor stub
	}
	public Candidat(Integer id, String adresa,  String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Integer idCandidat, String tipCandidat) {
		super(id, adresa, nume, prenume, formaAdresare, gen, cnp);
		this.idCandidat = idCandidat;
		this.tipCandidat = tipCandidat;
	}
	
	public Candidat(Integer id, String nume,
			String prenume,	Integer idCandidat, String tipCandidat) {
		super(id, null,  nume, prenume, null, 'M', null);
		this.idCandidat = idCandidat;
		this.tipCandidat = null;
	}
	
	
	
	
}
