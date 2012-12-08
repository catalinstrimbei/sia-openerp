package org.open.erp.services.nomgen;

import java.io.Serializable;

public class MijlocFix implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  denumire;
	private Integer  termenExploatare;
	private Integer valoare;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Integer getValoare() {
		return valoare;
	}
	public void setValoare(Integer valoare) {
		this.valoare = valoare;
	}	
	public Integer getTermenExploatare() {
		return termenExploatare;
	}
	public void setTermenExploatare(Integer termenExploatare) {
		this.termenExploatare = termenExploatare;
	}
	
	public MijlocFix(Integer id, String denumire, Integer  termenExploatare, Integer valoare) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.termenExploatare = termenExploatare;
		this.valoare = valoare;
	}
	
	public MijlocFix() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((termenExploatare == null) ? 0 : termenExploatare.hashCode());
		result = prime * result
				+ ((denumire == null) ? 0 : denumire.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((valoare == null) ? 0 : valoare.hashCode());
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
		MijlocFix other = (MijlocFix) obj;
		if (termenExploatare == null) {
			if (other.termenExploatare != null)
				return false;
		} else if (!termenExploatare.equals(other.termenExploatare))
			return false;
		if (denumire == null) {
			if (other.denumire != null)
				return false;
		} else if (!denumire.equals(other.denumire))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (valoare == null) {
			if (other.valoare != null)
				return false;
		} else if (!valoare.equals(other.valoare))
			return false;
		return true;
	}
	
	
}
