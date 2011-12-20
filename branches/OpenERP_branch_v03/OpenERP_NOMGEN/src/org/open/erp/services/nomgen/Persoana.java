package org.open.erp.services.nomgen;

import java.util.List;

/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class Persoana {
	private Integer id;
	private String  adresa;
	
	private List<String> telefoane;
	private List<String> emailuri;
	
	
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


	


	public List<String> getTelefoane() {
		return telefoane;
	}

	public void setTelefoane(List<String> telefoane) {
		this.telefoane = telefoane;
	}

	public List<String> getEmailuri() {
		return emailuri;
	}

	public void setEmailuri(List<String> emailuri) {
		this.emailuri = emailuri;
	}

	public Persoana(Integer id, String adresa) {
		super();
		
		this.id = id;
		this.adresa = adresa;
		
		
	}
	
	
	 public void afiseazaInformatii(String p) {
		 
	      System.out.println("- Date despre persoana - "+p);
	      System.out.println("Id persoana: " + getId());
	      System.out.println("Adresa: " + adresa);
	      System.out.println("Id contact: " + telefoane);
	      System.out.println("Id contact: " + emailuri);
	   }
	
	public Persoana() {
		super();
	}
	
}