package org.open.erp.services.personal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
public class DummyPersoana implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String  adresa;
	
	
	
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


	



	public DummyPersoana(Integer id, String adresa) {
		super();
		
		this.id = id;
		this.adresa = adresa;
		
		
	}
	
	
	 public void afiseazaInformatii(String p) {
		 
	      System.out.println("- Date despre persoana - "+p);
	      System.out.println("Id persoana: " + getId());
	      System.out.println("Adresa: " + adresa);
	   }
	
	public DummyPersoana() {
		super();
	}
	
}