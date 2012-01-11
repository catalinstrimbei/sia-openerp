package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */
@Entity
public class Persoana implements Serializable {
	

	@Id @GeneratedValue
	private Integer id;
	 @ManyToOne @JoinColumn(name = "Id")
	private Departament  dep;
	 
	private String  adresa;
	
	private List<String> telefoane;
	
	private List<String> emailuri;
	
	private static final long serialVersionUID = 1L;

	
	
	public Persoana(Integer id, Departament dep, String adresa,
			List<String> telefoane, List<String> emailuri) {
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
	public List<String> getTelefoane() {
		return telefoane;
	}

	public void setTelefoane(List<String> telefoane) {
		this.telefoane = telefoane;
	}
	@Transient 
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