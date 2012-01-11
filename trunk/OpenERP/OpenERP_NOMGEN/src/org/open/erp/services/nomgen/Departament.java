/**
 * 
 */
package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity

public class Departament implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
    
	private String Denumire;
	private String Atributii;
	@OneToMany(mappedBy="IdDepartament", cascade = CascadeType.ALL)
	private Collection<Divizie> DivDepartament;
	
	
	@OneToMany(mappedBy="dep", cascade = CascadeType.ALL)
	private Collection<Persoana> pers;
	private static final long serialVersionUID = 1L;
	
	private List<String> Telefoane;
	
	private List<String> Emailuri;
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
	public List<String> getTelefoane() {
		return Telefoane;
	}
	public void setTelefoane(List<String> telefoane) {
		Telefoane = telefoane;
	}
	public List<String> getEmailuri() {
		return Emailuri;
	}
	public void setEmailuri(List<String> emailuri) {
		Emailuri = emailuri;
	}
	/**
	 * @return the idContact
	 */
	
	
	public Departament(Integer id, String denumire, String atributii) {
		super();
		
		Id = id;
		Denumire = denumire;
		Atributii = atributii;
		
	}
	
	public Departament() {
		super();	
	}
}
