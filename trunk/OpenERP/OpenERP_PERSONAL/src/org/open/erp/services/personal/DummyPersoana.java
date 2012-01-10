package org.open.erp.services.personal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DummyPersoana implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
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