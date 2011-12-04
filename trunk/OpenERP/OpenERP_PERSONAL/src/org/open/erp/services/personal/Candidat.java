package org.open.erp.services.personal;

import org.open.erp.services.nomgen.PersoanaFizica;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Candidat extends PersoanaFizica{
	
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
	public Candidat(Integer id, String adresa, Integer idContact, String nume,
			String prenume, String formaAdresare, char gen, String cnp) {
		super(id, adresa, idContact, nume, prenume, formaAdresare, gen, cnp);
		// TODO Auto-generated constructor stub
	}
	public Candidat(Integer id, String adresa, Integer idContact, String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Integer idCandidat, String tipCandidat) {
		super(id, adresa, idContact, nume, prenume, formaAdresare, gen, cnp);
		this.idCandidat = idCandidat;
		this.tipCandidat = tipCandidat;
	}
	
	public Candidat(Integer id, String nume,
			String prenume,	Integer idCandidat, String tipCandidat) {
		super(id, null, null, nume, prenume, null, 'M', null);
		this.idCandidat = idCandidat;
		this.tipCandidat = null;
	}
	
	
	
	
}
