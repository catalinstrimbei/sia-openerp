/**
 * 
 */
package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;

import javax.persistence.ElementCollection;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity 

public class Departament implements Serializable{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Atributii == null) ? 0 : Atributii.hashCode());
		result = prime * result
				+ ((Denumire == null) ? 0 : Denumire.hashCode());
		result = prime * result
				+ ((DivDepartament == null) ? 0 : DivDepartament.hashCode());
		result = prime * result
				+ ((Emailuri == null) ? 0 : Emailuri.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ ((Telefoane == null) ? 0 : Telefoane.hashCode());
		result = prime * result + ((pers == null) ? 0 : pers.hashCode());
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
		Departament other = (Departament) obj;
		if (Atributii == null) {
			if (other.Atributii != null)
				return false;
		} else if (!Atributii.equals(other.Atributii))
			return false;
		if (Denumire == null) {
			if (other.Denumire != null)
				return false;
		} else if (!Denumire.equals(other.Denumire))
			return false;
		if (DivDepartament == null) {
			if (other.DivDepartament != null)
				return false;
		} else if (!DivDepartament.equals(other.DivDepartament))
			return false;
		if (Emailuri == null) {
			if (other.Emailuri != null)
				return false;
		} else if (!Emailuri.equals(other.Emailuri))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Telefoane == null) {
			if (other.Telefoane != null)
				return false;
		} else if (!Telefoane.equals(other.Telefoane))
			return false;
		if (pers == null) {
			if (other.pers != null)
				return false;
		} else if (!pers.equals(other.pers))
			return false;
		return true;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 6469826877523712262L;
	@Id @GeneratedValue//(strategy = GenerationType.AUTO)
	private Integer Id;
	private String Denumire;
	private String Atributii;
	@OneToMany(mappedBy="IdDepartament", cascade = CascadeType.ALL)
	//@JoinColumn(referencedColumnName="Idd")
	private Collection<Divizie> DivDepartament;	
	@ElementCollection(fetch = FetchType.LAZY,targetClass=String.class)
	private ArrayList<String> Telefoane=new ArrayList<String>();
	@ElementCollection(fetch = FetchType.LAZY,targetClass=String.class)
	private ArrayList<String> Emailuri=new ArrayList<String>();
	@OneToMany(mappedBy="dep", cascade = CascadeType.ALL)
	private Collection<Persoana> pers;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDenumire() {
		return Denumire;
	}

	public void setDenumire(String denumire) {
		Denumire = denumire;
	}

	public String getAtributii() {
		return Atributii;
	}

	public void setAtributii(String atributii) {
		Atributii = atributii;
	}

	public ArrayList<String> getTelefoane() {
		return Telefoane;
	}

	public void setTelefoane(ArrayList<String> telefoane) {
		Telefoane = telefoane;
	}

	public ArrayList<String> getEmailuri() {
		return Emailuri;
	}

	public void setEmailuri(ArrayList<String> emailuri) {
		Emailuri = emailuri;
	}

	



	/**
	 * @return the idContact
	 */
	
	
	public Departament(Integer id, String denumire, String atributii) {
		super();
		
		Id = id;
		Denumire = denumire;
		Atributii = atributii;
		
	}
	
	public Departament() {
		super();	
	}

	public Departament(Integer id, String denumire, String atributii,
			Collection<Divizie> divDepartament, Collection<Persoana> pers,
			ArrayList<String> telefoane) {
		super();     //List<String> emailuri
		Id = id;
		Denumire = denumire;
		Atributii = atributii;
		setDivDepartament(divDepartament);
		this.setPers(pers);
		Telefoane = telefoane;
		//Emailuri = emailuri;
	}
	public Collection<Persoana> getPers() {
		return pers;
	}
	public void setPers(Collection<Persoana> pers) {
		this.pers = pers;
	}
	public Collection<Divizie> getDivDepartament() {
		return DivDepartament;
	}
	public void setDivDepartament(Collection<Divizie> divDepartament) {
		DivDepartament = divDepartament;
	}
	

}
