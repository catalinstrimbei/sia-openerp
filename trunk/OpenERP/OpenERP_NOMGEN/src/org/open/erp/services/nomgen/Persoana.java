package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Persoana implements Serializable {
	

	@Id @GeneratedValue
	protected Integer id;
	 @ManyToOne @JoinColumn(name = "Id")
	protected Departament  dep;
	 
    protected String  adresa;
    
    protected ArrayList<String> telefoane=new ArrayList<String>();

	protected ArrayList<String> emailuri=new ArrayList<String>();
	
	protected static final long serialVersionUID = 1L;

	
	
	public Persoana(Integer id, Departament dep, String adresa,
			List<String> telefoane2, List<String> emailuri2) {
		super();
		this.id = id;
		this.dep = dep;
		this.adresa = adresa;
		this.telefoane = (ArrayList<String>) telefoane2;
		this.emailuri = (ArrayList<String>) emailuri2;
		
	
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
	public List<String> getTelefoane() {
		return telefoane;
	}

	public void setTelefoane(ArrayList<String> telefoane) {
		this.telefoane = telefoane;
	}
	@Transient 
	public List<String> getEmailuri() {
		return emailuri;
	}

	public void setEmailuri(ArrayList<String> emailuri) {
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