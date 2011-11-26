/**
 * 
 */
package org.open.erp.services.nomgen;

/**
 * @author Suzy
 *
 */
public class Email {
	   private Integer id;
	   private String adresaEmail;
	   private Persoana idContact;
	
	
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
	 * @return the adresaEmail
	 */
	public String getAdresaEmail() {
		return adresaEmail;
	}
	/**
	 * @param adresaEmail the adresaEmail to set
	 */
	public void setAdresaEmail(String adresaEmail) {
		this.adresaEmail = adresaEmail;
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
	public Email(Integer id, String adresaEmail, Persoana idContact) {
		super();
		this.id = id;
		this.adresaEmail = adresaEmail;
		this.idContact = idContact;
	}
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
	
	   

}
