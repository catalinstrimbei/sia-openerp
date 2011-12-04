package org.open.erp.services.personal;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Angajat extends Candidat{	
	private Integer			marca;	
	private Boolean			activ;
	private Integer			numarCopii;
	
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


	public Integer getNumarCopii() {
		return numarCopii;
	}


	public void setNumarCopii(Integer numarCopii) {
		this.numarCopii = numarCopii;
	}


	public Angajat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Angajat(Integer marca, Boolean activ, Integer numarCopii) {
		super();
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = numarCopii;
	}


	public Angajat(Integer id, String adresa, Integer idContact, String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Integer idCandidat, String tipCandidat) {
		super(id, adresa, idContact, nume, prenume, formaAdresare, gen, cnp,
				idCandidat, tipCandidat);
		// TODO Auto-generated constructor stub
	}


	public Angajat(Integer id, String adresa, Integer idContact, String nume,
			String prenume, String formaAdresare, char gen, String cnp) {
		super(id, adresa, idContact, nume, prenume, formaAdresare, gen, cnp);
		// TODO Auto-generated constructor stub
	}



	public Angajat(Integer id, String nume,
			String prenume, Integer marca, Boolean activ) {
		super(id, null, null, nume, prenume, null, 'M', null);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = 0;
	}




	public Angajat(Integer id,  String nume,
			String prenume,	Integer idCandidat, String tipCandidat, Integer marca,
			Boolean activ) {
		super(id, null, null, nume, prenume, null, 'M', null,
				idCandidat, tipCandidat);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = 0;
	}
	
	
}
