package org.open.erp.services.stocuri;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Depozit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDepozit;
	private String Locatie;
	private String suprafata;

	public Depozit() {
		super();
	}

	public Depozit(Integer idDepozit, String locatie, String suprafata) {
		super();
		this.idDepozit = idDepozit;
		Locatie = locatie;
		this.suprafata = suprafata;
	}

	public Integer getIdDepozit() {
		return idDepozit;
	}

	public void setIdDepozit(Integer idDepozit) {
		this.idDepozit = idDepozit;
	}

	public String getLocatie() {
		return Locatie;
	}

	public void setLocatie(String locatie) {
		Locatie = locatie;
	}

	public String getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(String suprafata) {
		this.suprafata = suprafata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDepozit == null) ? 0 : idDepozit.hashCode());
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
		Depozit other = (Depozit) obj;
		if (idDepozit == null) {
			if (other.idDepozit != null)
				return false;
		} else if (!idDepozit.equals(other.idDepozit))
			return false;
		return true;
	}

}
