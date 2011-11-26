package org.open.erp.services.nomgen;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Persoana {
	private Integer id;
	private String  adresa;
	private Integer idContact;
	
	
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
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	/**
	 * @return the idContact
	 */
	public Integer getIdContact() {
		return idContact;
	}

	/**
	 * @param idContact the idContact to set
	 */
	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}


	public Persoana(Integer id, String adresa, Integer idContact) {
		super();
		
		this.id = id;
		this.adresa = adresa;
		this.idContact = idContact;
	}
	
	

	
	public Persoana() {
		super();
	}
	
}