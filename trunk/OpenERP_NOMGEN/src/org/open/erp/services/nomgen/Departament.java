/**
 * 
 */
package org.open.erp.services.nomgen;

/**
 * @author Suzy
 *
 */
public class Departament {

	private Integer Id;
	private String Denumire;
	private String Atributii;
	private Persoana IdContact;
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
	
	public Departament(Integer id, String denumire, String atributii,Persoana idContact) {
		super();
		
		Id = id;
		Denumire = denumire;
		Atributii = atributii;
		IdContact = idContact;
	}
	
	public Departament() {
		super();	
	}
}
