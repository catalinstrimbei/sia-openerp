/**
 * 
 */
package org.open.erp.services.nomgen;

import java.util.List;

/**
 * @author Suzy
 *
 */
public class Departament{

	private Integer Id;
	private String Denumire;
	private String Atributii;
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
