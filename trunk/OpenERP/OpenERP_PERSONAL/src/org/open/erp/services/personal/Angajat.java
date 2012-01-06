package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Angajat extends Candidat implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer			marca;	
	private Boolean			activ;
	private Integer			numarCopii;
	@OneToMany(mappedBy = "angajat", cascade = CascadeType.ALL)
	private List<ContractMunca> contracte;
	
	@OneToMany(mappedBy = "angajat", cascade = CascadeType.ALL)
	private List<RezultatProbaEvaluare> rezultateEval;
	
	@ManyToMany(mappedBy = "responsabili")
	private List<ActivitateTeamBuilding>	activitatiTeamBld;
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


	public Angajat(Integer id, String adresa,  String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Integer idCandidat, String tipCandidat) {
		super(id, adresa,  nume, prenume, formaAdresare, gen, cnp,
				idCandidat, tipCandidat);
		// TODO Auto-generated constructor stub
	}


	public Angajat(Integer id, String adresa,  String nume,
			String prenume, String formaAdresare, char gen, String cnp) {
		super(id, adresa, nume, prenume, formaAdresare, gen, cnp);
		// TODO Auto-generated constructor stub
	}



	public Angajat(Integer id, String nume,
			String prenume, Integer marca, Boolean activ) {
		super(id, null, nume, prenume, null, 'M', null);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = 0;
	}




	public Angajat(Integer id,  String nume,
			String prenume,	Integer idCandidat, String tipCandidat, Integer marca,
			Boolean activ) {
		super(id, null,  nume, prenume, null, 'M', null,
				idCandidat, tipCandidat);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = 0;
	}


	public Angajat(Integer id, String adresa, String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Integer idCandidat, String tipCandidat, Integer marca,
			Boolean activ, Integer numarCopii) {
		super(id, adresa, nume, prenume, formaAdresare, gen, cnp,
				idCandidat, tipCandidat);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = numarCopii;
	}

	public List<ContractMunca> getContracte() {
		return contracte;
	}

	public void setContracte(List<ContractMunca> contracte) {
		this.contracte = contracte;
	}

	public List<RezultatProbaEvaluare> getRezultateEval() {
		return rezultateEval;
	}

	public void setRezultateEval(List<RezultatProbaEvaluare> rezultateEval) {
		this.rezultateEval = rezultateEval;
	}

	public List<ActivitateTeamBuilding> getActivitatiTeamBld() {
		return activitatiTeamBld;
	}

	public void setActivitatiTeamBld(List<ActivitateTeamBuilding> activitatiTeamBld) {
		this.activitatiTeamBld = activitatiTeamBld;
	}
	
	
}
