/**
 * 
 */
package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity

public class Departament implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer Idd;
    
	private String Denumire;
	private String Atributii;
	@OneToMany(mappedBy="IdDepartament", cascade = CascadeType.ALL)
	//@JoinColumn(referencedColumnName="Idd")
	private Collection<Divizie> DivDepartament;
	
	
	@OneToMany(mappedBy="dep", cascade = CascadeType.ALL)
	private Collection<Persoana> pers;
	
	@SuppressWarnings("unused")
	private String Telefoane;
	//@SuppressWarnings("unused")
	//private List<String> Emailuri;
	/**
	 * @return the id
	 */
	
	public Integer getId() {
		return Idd;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Idd = id;
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
	public String getTelefoane() {
		return Telefoane;
	}
	public void setTelefoane(String telefoane) {
		Telefoane = telefoane;
	}
	/*public List<String> getEmailuri() {
		return Emailuri;
	}
	public void setEmailuri(List<String> emailuri) {
		Emailuri = emailuri;
	}*/
	/**
	 * @return the idContact
	 */
	
	
	public Departament(Integer id, String denumire, String atributii) {
		super();
		
		Idd = id;
		Denumire = denumire;
		Atributii = atributii;
		
	}
	
	public Departament() {
		super();	
	}
	public Departament(Integer id, String denumire, String atributii,
			Collection<Divizie> divDepartament, Collection<Persoana> pers,
			String telefoane) {
		super();     //List<String> emailuri
		Idd = id;
		Denumire = denumire;
		Atributii = atributii;
		setDivDepartament(divDepartament);
		this.setPers(pers);
		Telefoane = telefoane;
		//Emailuri = emailuri;
	}
	public Collection<Persoana> getPers() {
		return pers;
	}
	public void setPers(Collection<Persoana> pers) {
		this.pers = pers;
	}
	public Collection<Divizie> getDivDepartament() {
		return DivDepartament;
	}
	public void setDivDepartament(Collection<Divizie> divDepartament) {
		DivDepartament = divDepartament;
	}
	
}
