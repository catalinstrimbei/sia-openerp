package org.open.erp.services.nomgen;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@OneToMany (mappedBy = "p", targetEntity = PersoanaFizica.class, cascade = ALL, fetch = EAGER)
	List<PF> pfe = new ArrayList<PF>();
	
	public Persoana(Integer id, Departament dep, String adresa,
			List<String> telefoane2, List<String> emailuri2) {
		super();
		this.id = id;
		this.dep = dep;
		this.adresa = adresa;
		this.telefoane = (ArrayList<String>) telefoane2;
		this.emailuri = (ArrayList<String>) emailuri2;
		
		
	
	
	}
	
	public void adaugaPF(PF pf){
		this.pfe.add(pf);
	}	

	public List<PF> getPfe() {
		return pfe;
	}



	public void setPfe(List<PF> pfe) {
		this.pfe = pfe;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresa == null) ? 0 : adresa.hashCode());
		result = prime * result + ((dep == null) ? 0 : dep.hashCode());
		result = prime * result
				+ ((emailuri == null) ? 0 : emailuri.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((telefoane == null) ? 0 : telefoane.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoana other = (Persoana) obj;
		if (adresa == null) {
			if (other.adresa != null)
				return false;
		} else if (!adresa.equals(other.adresa))
			return false;
		if (dep == null) {
			if (other.dep != null)
				return false;
		} else if (!dep.equals(other.dep))
			return false;
		if (emailuri == null) {
			if (other.emailuri != null)
				return false;
		} else if (!emailuri.equals(other.emailuri))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (telefoane == null) {
			if (other.telefoane != null)
				return false;
		} else if (!telefoane.equals(other.telefoane))
			return false;
		return true;
	}

	
}