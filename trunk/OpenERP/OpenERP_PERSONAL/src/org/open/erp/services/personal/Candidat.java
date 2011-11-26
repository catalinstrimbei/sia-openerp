package org.open.erp.services.personal;

import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Candidat extends Persoana{
	
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
	
	
	public Candidat(Integer idPersoana, String nume, String prenume,
			Integer idCandidat, String tipCandidat) {
		super(idPersoana, nume, prenume);
		this.idCandidat = idCandidat;
		this.tipCandidat = tipCandidat;
	}
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidat(Integer idPersoana, String nume, String prenume) {
		super(idPersoana, nume, prenume);
		// TODO Auto-generated constructor stub
	}
	
	
}
