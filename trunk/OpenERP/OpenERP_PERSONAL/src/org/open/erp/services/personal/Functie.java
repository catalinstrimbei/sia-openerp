package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.open.erp.services.nomgen.Departament;


/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Functie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer 		idFunctie;
	private String 			numeFunctie;
	private Integer 		pozitiaInCOR; //Clasificarea Ocupatiilor din Romania
	private List<String>	obiective;
	private List<String>	responsabilitati;
	private List<String>	cunostinte;
	private List<String>	deprinderi;
	private List<String>	aptitudini;
	//TODO    adauga Jar si clasa Departament in persistence.xml
	//ManyToOne
	private Departament		departament;
	
	public Integer getIdFunctie() {
		return idFunctie;
	}
	public void setIdFunctie(Integer idFunctie) {
		this.idFunctie = idFunctie;
	}
	public String getNumeFunctie() {
		return numeFunctie;
	}
	public void setNumeFunctie(String numeFunctie) {
		this.numeFunctie = numeFunctie;
	}
	public Integer getPozitiaInCOR() {
		return pozitiaInCOR;
	}
	public void setPozitiaInCOR(Integer pozitiaInCOR) {
		this.pozitiaInCOR = pozitiaInCOR;
	}
	public List<String> getObiective() {
		return obiective;
	}
	public void setObiective(List<String> obiective) {
		this.obiective = obiective;
	}
	public List<String> getResponsabilitati() {
		return responsabilitati;
	}
	public void setResponsabilitati(List<String> responsabilitati) {
		this.responsabilitati = responsabilitati;
	}
	public List<String> getCunostinte() {
		return cunostinte;
	}
	public void setCunostinte(List<String> cunostinte) {
		this.cunostinte = cunostinte;
	}
	public List<String> getDeprinderi() {
		return deprinderi;
	}
	public void setDeprinderi(List<String> deprinderi) {
		this.deprinderi = deprinderi;
	}
	public List<String> getAptitudini() {
		return aptitudini;
	}
	public void setAptitudini(List<String> aptitudini) {
		this.aptitudini = aptitudini;
	}
	public Functie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Functie(Integer idFunctie, String numeFunctie) {
		super();
		this.idFunctie = idFunctie;
		this.numeFunctie = numeFunctie;
	}
	public Functie(Integer idFunctie, String numeFunctie, Integer pozitiaInCOR,
			List<String> obiective, List<String> responsabilitati,
			List<String> cunostinte, List<String> deprinderi,
			List<String> aptitudini, Departament departament) {
		super();
		this.idFunctie = idFunctie;
		this.numeFunctie = numeFunctie;
		this.pozitiaInCOR = pozitiaInCOR;
		this.obiective = obiective;
		this.responsabilitati = responsabilitati;
		this.cunostinte = cunostinte;
		this.deprinderi = deprinderi;
		this.aptitudini = aptitudini;
		this.departament = departament;
	}
	public Departament getDepartament() {
		return departament;
	}
	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
	
}
