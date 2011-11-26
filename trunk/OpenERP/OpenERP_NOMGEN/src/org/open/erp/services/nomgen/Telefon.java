/**
 * 
 */
package org.open.erp.services.nomgen;

/**
 * @author Suzy
 *
 */
public class Telefon {
	public Integer id;
	public String numar;
	public Persoana idContact;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the numar
	 */
	public String getNumar() {
		return numar;
	}
	/**
	 * @param numar the numar to set
	 */
	public void setNumar(String numar) {
		this.numar = numar;
	}
	/**
	 * @return the idContact
	 */
	public Persoana getIdContact() {
		return idContact;
	}
	/**
	 * @param idContact the idContact to set
	 */
	public void setIdContact(Persoana idContact) {
		this.idContact = idContact;
	}
	
	public Telefon(Integer id,String numar, Persoana idContact) {
		super();
		this.id = id;
		this.numar = numar;
		this.idContact = idContact;
	}
	
	
	public Telefon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
