package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.open.erp.services.personal.ActivitateTeamBuilding;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.RezultatProbaEvaluare;
/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class DummyAngajat extends Candidat implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer			marca;	
	private Boolean			activ;
	private Integer			numarCopii;
	//@OneToMany(mappedBy = "angajat", cascade = CascadeType.ALL)
	private Collection<ContractMunca> contracte;
	
	//@OneToMany(mappedBy = "angajat", cascade = CascadeType.ALL)
	private Collection<RezultatProbaEvaluare> rezultateEval;
	
	//@ManyToMany(mappedBy = "responsabili")
	private Collection<ActivitateTeamBuilding>	activitatiTeamBld;
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


	public DummyAngajat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DummyAngajat(Integer marca, Boolean activ, Integer numarCopii) {
		super();
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = numarCopii;
	}


	public DummyAngajat(Integer id, String adresa,  String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Integer idCandidat, String tipCandidat) {
		super(id, adresa,  nume, prenume, formaAdresare, gen, cnp,
				idCandidat, tipCandidat);
		// TODO Auto-generated constructor stub
	}


	public DummyAngajat(Integer id, String adresa,  String nume,
			String prenume, String formaAdresare, char gen, String cnp) {
		super(id, adresa, nume, prenume, formaAdresare, gen, cnp);
		// TODO Auto-generated constructor stub
	}



	public DummyAngajat(Integer id, String nume,
			String prenume, Integer marca, Boolean activ) {
		super(id, null, nume, prenume, null, 'M', null);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = 0;
	}




	public DummyAngajat(Integer id,  String nume,
			String prenume,	Integer idCandidat, String tipCandidat, Integer marca,
			Boolean activ) {
		super(id, null,  nume, prenume, null, 'M', null,
				idCandidat, tipCandidat);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = 0;
	}


	public DummyAngajat(Integer id, String adresa, String nume,
			String prenume, String formaAdresare, char gen, String cnp,
			Integer idCandidat, String tipCandidat, Integer marca,
			Boolean activ, Integer numarCopii) {
		super(id, adresa, nume, prenume, formaAdresare, gen, cnp,
				idCandidat, tipCandidat);
		this.marca = marca;
		this.activ = activ;
		this.numarCopii = numarCopii;
	}

	public Collection<ContractMunca> getContracte() {
		return contracte;
	}

	public void setContracte(Collection<ContractMunca> contracte) {
		this.contracte = contracte;
	}

	public Collection<RezultatProbaEvaluare> getRezultateEval() {
		return rezultateEval;
	}

	public void setRezultateEval(Collection<RezultatProbaEvaluare> rezultateEval) {
		this.rezultateEval = rezultateEval;
	}

	public Collection<ActivitateTeamBuilding> getActivitatiTeamBld() {
		return activitatiTeamBld;
	}

	public void setActivitatiTeamBld(Collection<ActivitateTeamBuilding> activitatiTeamBld) {
		this.activitatiTeamBld = activitatiTeamBld;
	}
	
	
}
