package org.open.erp.services.personal;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Angajat extends Candidat{	
	private Integer			marca;	
	private Boolean			activ;
	
	public Integer getMarca() {
		return marca;
	}
	
	
	public void setMarca(Integer marca) {
		this.marca = marca;
	}
	public Boolean getActiv() {
		return activ;
	}
	public void setActiv(Boolean activ) {
		this.activ = activ;
	}
	public Angajat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Angajat(Integer idPersoana, String nume, String prenume,
			Integer idCandidat, String tipCandidat) {
		super(idPersoana, nume, prenume, idCandidat, tipCandidat);
		// TODO Auto-generated constructor stub
	}
	public Angajat(Integer idPersoana, String nume, String prenume) {
		super(idPersoana, nume, prenume);
		// TODO Auto-generated constructor stub
	}
	public Angajat(Integer idPersoana, String nume, String prenume,
			Integer idCandidat, String tipCandidat, Integer marca, Boolean activ) {
		super(idPersoana, nume, prenume, idCandidat, tipCandidat);
		this.marca = marca;
		this.activ = activ;
	}
	
	
}
