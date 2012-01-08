package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//TODO uncomment this
//import org.open.erp.services.nomgen.Departament;
import javax.persistence.Transient;


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
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer 		idFunctie;
	private String 			numeFunctie;
	private Integer 		pozitiaInCOR; //Clasificarea Ocupatiilor din Romania
	@Transient
	private Collection<String>	obiective;
	@Transient
	private Collection<String>	responsabilitati;
	@Transient
	private Collection<String>	cunostinte;
	@Transient
	private Collection<String>	deprinderi;
	@Transient
	private Collection<String>	aptitudini;
	@OneToMany(mappedBy = "functie", cascade = CascadeType.ALL)
	private Collection<AnuntLocMunca>	anunturi;
	//TODO    adauga Jar si clasa DummyDepartament in persistence.xml
	@ManyToOne @JoinColumn(name="idDepartament") 
	private DummyDepartament		departament;
	@OneToMany(mappedBy = "functie", cascade = CascadeType.ALL)
	private Collection<ContractMunca> contracte;
	@OneToMany(mappedBy = "functieVizata", cascade = CascadeType.ALL)
	private Collection<CV> 	CVuri;
	
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
	public Collection<String> getObiective() {
		return obiective;
	}
	public void setObiective(Collection<String> obiective) {
		this.obiective = obiective;
	}
	public Collection<String> getResponsabilitati() {
		return responsabilitati;
	}
	public void setResponsabilitati(Collection<String> responsabilitati) {
		this.responsabilitati = responsabilitati;
	}
	public Collection<String> getCunostinte() {
		return cunostinte;
	}
	public void setCunostinte(Collection<String> cunostinte) {
		this.cunostinte = cunostinte;
	}
	public Collection<String> getDeprinderi() {
		return deprinderi;
	}
	public void setDeprinderi(Collection<String> deprinderi) {
		this.deprinderi = deprinderi;
	}
	public Collection<String> getAptitudini() {
		return aptitudini;
	}
	public void setAptitudini(Collection<String> aptitudini) {
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
			Collection<String> obiective, Collection<String> responsabilitati,
			Collection<String> cunostinte, Collection<String> deprinderi,
			Collection<String> aptitudini, DummyDepartament departament) {
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
	public DummyDepartament getDepartament() {
		return departament;
	}
	public void setDepartament(DummyDepartament departament) {
		this.departament = departament;
	}
	public Collection<AnuntLocMunca> getAnunturi() {
		return anunturi;
	}
	public void setAnunturi(Collection<AnuntLocMunca> anunturi) {
		this.anunturi = anunturi;
	}
	public Collection<ContractMunca> getContracte() {
		return contracte;
	}
	public void setContracte(Collection<ContractMunca> contracte) {
		this.contracte = contracte;
	}
	public Collection<CV> getCVuri() {
		return CVuri;
	}
	public void setCVuri(Collection<CV> cVuri) {
		CVuri = cVuri;
	}
	
	
}
