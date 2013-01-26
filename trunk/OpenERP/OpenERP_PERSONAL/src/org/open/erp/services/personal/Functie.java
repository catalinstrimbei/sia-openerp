package org.open.erp.services.personal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class Functie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Integer idFunctie;
	private String	numeFunctie;
	
	public Integer getIdFunctie() {
		return idFunctie;
	}
	public void setIdFunctie(Integer idFunctie) {
		this.idFunctie = idFunctie;
	}
	public String getNumeFunctie() {
		return numeFunctie;
	}
	public void setNumeFunctie(String numeFunctie) {
		this.numeFunctie = numeFunctie;
	}
	
	public Functie(Integer idFunctie, String numeFunctie) {
		super();
		this.idFunctie = idFunctie;
		this.numeFunctie = numeFunctie;
	}
	
	public Functie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFunctie == null) ? 0 : idFunctie.hashCode());
		result = prime * result
				+ ((numeFunctie == null) ? 0 : numeFunctie.hashCode());
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
		Functie other = (Functie) obj;
		if (idFunctie == null) {
			if (other.idFunctie != null)
				return false;
		} else if (!idFunctie.equals(other.idFunctie))
			return false;
		if (numeFunctie == null) {
			if (other.numeFunctie != null)
				return false;
		} else if (!numeFunctie.equals(other.numeFunctie))
			return false;
		return true;
	}
	
	
}
