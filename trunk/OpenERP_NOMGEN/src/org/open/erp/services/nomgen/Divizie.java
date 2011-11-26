/**
 * 
 */
package org.open.erp.services.nomgen;

/**
 * @author Suzy
 *
 */
public class Divizie {

	public Integer Id;
	public Departament IdDepartament;
	public String denumire;
	public String atributii;
	public Persoana IdContact;
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
	 * @return the idDepartament
	 */
	public Departament getIdDepartament() {
		return IdDepartament;
	}
	/**
	 * @param idDepartament the idDepartament to set
	 */
	public void setIdDepartament(Departament idDepartament) {
		IdDepartament = idDepartament;
	}
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumire;
	}
	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	/**
	 * @return the atributii
	 */
	public String getAtributii() {
		return atributii;
	}
	/**
	 * @param atributii the atributii to set
	 */
	public void setAtributii(String atributii) {
		this.atributii = atributii;
	}
	/**
	 * @return the idContact
	 */
	public Persoana getIdContact() {
		return IdContact;
	}
	/**
	 * @param idContact the idContact to set
	 */
	public void setIdContact(Persoana idContact) {
		IdContact = idContact;
	}

	
	
	public Divizie(Integer id, String denumire, String atributii, Persoana idContact) {
		super();
		
	}
	
	public Divizie(Integer id, Departament idDepartament, String denumire,
			String atributii, Persoana idContact) {
		super();
		Id = id;
		IdDepartament = idDepartament;
		this.denumire = denumire;
		this.atributii = atributii;
		IdContact = idContact;
	}
	
	public Divizie() {
		super();	
	}
}
