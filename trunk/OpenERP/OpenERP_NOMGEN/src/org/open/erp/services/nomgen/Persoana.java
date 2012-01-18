package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
public class Persoana implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer id;
	 @ManyToOne @JoinColumn(name = "pers")
	private Departament  dep;
	 
	private String  adresa;
	@SuppressWarnings("unused")
	protected static String telefoane;
	@SuppressWarnings("unused")
	protected static String emailuri;
	

	
	
	public Persoana(Integer id, Departament dep, String adresa,
			String telefoane, String emailuri) {
		super();
		this.id = id;
		this.dep = dep;
		this.adresa = adresa;
		this.telefoane = telefoane;
		this.emailuri = emailuri;
		
	
	}

	public Departament getDep() {
		return dep;
	}

	public void setDep(Departament dep) {
		this.dep = dep;
	}
	
	
	
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



	@Transient 
	public String getTelefoane() {
		return telefoane;
	}

	public void setTelefoane(String telefoane) {
		this.telefoane = telefoane;
	}
	@Transient 
	public String getEmailuri() {
		return emailuri;
	}

	public void setEmailuri(String emailuri) {
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