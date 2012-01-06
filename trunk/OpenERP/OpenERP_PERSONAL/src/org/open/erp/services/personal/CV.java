package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class CV implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String   	nrCV;
	@ManyToOne @JoinColumn(name = "idCandidat")
	private Candidat 	candidat;
	@ManyToOne @JoinColumn(name = "idFunctie")
	private Functie		functieVizata;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date		dataDepunere;	
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date		ultimaModificare;
	private String   	domeniu;
	private Integer  	aniExperienta; 
	private String   	nationalitate;
	private String   	studiiAbsolvite;
	private String   	institutieAbsolvita;
	private String   	studiiInCurs;
	private String   	institutieInCurs;
	private String[] 	limbiCunoscute = {"Engleza", "Franceza", "Italiana", "Spaniola", "Germana", "Altele"};
	public String getNrCV() {
		return nrCV;
	}
	public void setNrCV(String nrCV) {
		this.nrCV = nrCV;
	}
	public Candidat getCandidat() {
		return candidat;
	}
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	public Functie getFunctieVizata() {
		return functieVizata;
	}
	public void setFunctieVizata(Functie functieVizata) {
		this.functieVizata = functieVizata;
	}
	public Date getDataDepunere() {
		return dataDepunere;
	}
	public void setDataDepunere(Date dataDepunere) {
		this.dataDepunere = dataDepunere;
	}
	public Date getUltimaModificare() {
		return ultimaModificare;
	}
	public void setUltimaModificare(Date ultimaModificare) {
		this.ultimaModificare = ultimaModificare;
	}
	public String getDomeniu() {
		return domeniu;
	}
	public void setDomeniu(String domeniu) {
		this.domeniu = domeniu;
	}
	public Integer getAniExperienta() {
		return aniExperienta;
	}
	public void setAniExperienta(Integer aniExperienta) {
		this.aniExperienta = aniExperienta;
	}
	public String getNationalitate() {
		return nationalitate;
	}
	public void setNationalitate(String nationalitate) {
		this.nationalitate = nationalitate;
	}
	public String getStudiiAbsolvite() {
		return studiiAbsolvite;
	}
	public void setStudiiAbsolvite(String studiiAbsolvite) {
		this.studiiAbsolvite = studiiAbsolvite;
	}
	public String getInstitutieAbsolvita() {
		return institutieAbsolvita;
	}
	public void setInstitutieAbsolvita(String institutieAbsolvita) {
		this.institutieAbsolvita = institutieAbsolvita;
	}
	public String getStudiiInCurs() {
		return studiiInCurs;
	}
	public void setStudiiInCurs(String studiiInCurs) {
		this.studiiInCurs = studiiInCurs;
	}
	public String getInstitutieInCurs() {
		return institutieInCurs;
	}
	public void setInstitutieInCurs(String institutieInCurs) {
		this.institutieInCurs = institutieInCurs;
	}
	public String[] getLimbiCunoscute() {
		return limbiCunoscute;
	}
	public void setLimbiCunoscute(String[] limbiCunoscute) {
		this.limbiCunoscute = limbiCunoscute;
	}
	public CV(String nrCV, Candidat candidat, Functie functieVizata,
			Date dataDepunere, Date ultimaModificare, String domeniu,
			Integer aniExperienta, String nationalitate,
			String studiiAbsolvite, String institutieAbsolvita,
			String studiiInCurs, String institutieInCurs,
			String[] limbiCunoscute) {
		super();
		this.nrCV = nrCV;
		this.candidat = candidat;
		this.functieVizata = functieVizata;
		this.dataDepunere = dataDepunere;
		this.ultimaModificare = ultimaModificare;
		this.domeniu = domeniu;
		this.aniExperienta = aniExperienta;
		this.nationalitate = nationalitate;
		this.studiiAbsolvite = studiiAbsolvite;
		this.institutieAbsolvita = institutieAbsolvita;
		this.studiiInCurs = studiiInCurs;
		this.institutieInCurs = institutieInCurs;
		this.limbiCunoscute = limbiCunoscute;
	}
	public CV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CV(String nrCV, Candidat candidat, Functie functieVizata,
			Date dataDepunere, Date ultimaModificare) {
		super();
		this.nrCV = nrCV;
		this.candidat = candidat;
		this.functieVizata = functieVizata;
		this.dataDepunere = dataDepunere;
		this.ultimaModificare = ultimaModificare;
		this.domeniu = null;
		this.aniExperienta = null;
		this.nationalitate = null;
		this.studiiAbsolvite = null;
		this.institutieAbsolvita = null;
		this.studiiInCurs = null;
		this.institutieInCurs = null;
		this.limbiCunoscute = null;
	}
	public CV(String nrCV, Candidat candidat, Functie functieVizata,
			Date dataDepunere) {
		super();
		this.nrCV = nrCV;
		this.candidat = candidat;
		this.functieVizata = functieVizata;
		this.dataDepunere = dataDepunere;
		this.ultimaModificare = dataDepunere;
		this.domeniu = null;
		this.aniExperienta = null;
		this.nationalitate = null;
		this.studiiAbsolvite = null;
		this.institutieAbsolvita = null;
		this.studiiInCurs = null;
		this.institutieInCurs = null;
		this.limbiCunoscute = null;
	}
	
}
