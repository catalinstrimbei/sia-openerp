/**
 * 
 */
package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity
public class DummyDepartament implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer Id;
    
	private String Denumire;
	private String Atributii;
	@Transient
	private Collection<String> Telefoane;
	@Transient
	private Collection<String> Emailuri;
	@OneToMany(mappedBy = "departament", cascade = CascadeType.ALL)
	private Collection<Functie> functii;
	@OneToMany(mappedBy = "departament", cascade = CascadeType.ALL)
	private Collection<ProbaEvaluare> probeEvaluare;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return Denumire;
	}
	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		Denumire = denumire;
	}
	/**
	 * @return the atributii
	 */
	public String getAtributii() {
		return Atributii;
	}
	/**
	 * @param atributii the atributii to set
	 */
	public void setAtributii(String atributii) {
		Atributii = atributii;
	}
	public Collection<String> getTelefoane() {
		return Telefoane;
	}
	public void setTelefoane(Collection<String> telefoane) {
		Telefoane = telefoane;
	}
	public Collection<String> getEmailuri() {
		return Emailuri;
	}
	public void setEmailuri(Collection<String> emailuri) {
		Emailuri = emailuri;
	}
	/**
	 * @return the idContact
	 */
	
	
	public DummyDepartament(Integer id, String denumire, String atributii) {
		super();
		
		Id = id;
		Denumire = denumire;
		Atributii = atributii;
		
	}
	
	public DummyDepartament() {
		super();	
	}
	public Collection<Functie> getFunctii() {
		return functii;
	}
	public void setFunctii(Collection<Functie> functii) {
		this.functii = functii;
	}
	public Collection<ProbaEvaluare> getProbeEvaluare() {
		return probeEvaluare;
	}
	public void setProbeEvaluare(Collection<ProbaEvaluare> probeEvaluare) {
		this.probeEvaluare = probeEvaluare;
	}
}
