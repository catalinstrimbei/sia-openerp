package org.open.erp.services.productie;

import org.open.erp.services.nommat.Produs;

public class Articol {
	private Integer IdArticol;
	private Produs produs;
	private Boolean esteProdusFinit;
	private Boolean esteRebut;
	public Integer getIdArticol() {
		return IdArticol;
	}
	public void setIdArticol(Integer idArticol) {
		IdArticol = idArticol;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public Boolean getEsteProdusFinit() {
		return esteProdusFinit;
	}
	public void setEsteProdusFinit(Boolean esteProdusFinit) {
		this.esteProdusFinit = esteProdusFinit;
	}
	public Boolean getEsteRebut() {
		return esteRebut;
	}
	public void setEsteRebut(Boolean esteRebut) {
		this.esteRebut = esteRebut;
	}
	public Articol(Integer idArticol, Produs produs, Boolean esteProdusFinit,
			Boolean esteRebut) {
		super();
		IdArticol = idArticol;
		this.produs = produs;
		this.esteProdusFinit = esteProdusFinit;
		this.esteRebut = esteRebut;
	}
	public Articol() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdArticol == null) ? 0 : IdArticol.hashCode());
		result = prime * result
				+ ((esteProdusFinit == null) ? 0 : esteProdusFinit.hashCode());
		result = prime * result
				+ ((esteRebut == null) ? 0 : esteRebut.hashCode());
		result = prime * result + ((produs == null) ? 0 : produs.hashCode());
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
		Articol other = (Articol) obj;
		if (IdArticol == null) {
			if (other.IdArticol != null)
				return false;
		} else if (!IdArticol.equals(other.IdArticol))
			return false;
		if (esteProdusFinit == null) {
			if (other.esteProdusFinit != null)
				return false;
		} else if (!esteProdusFinit.equals(other.esteProdusFinit))
			return false;
		if (esteRebut == null) {
			if (other.esteRebut != null)
				return false;
		} else if (!esteRebut.equals(other.esteRebut))
			return false;
		if (produs == null) {
			if (other.produs != null)
				return false;
		} else if (!produs.equals(other.produs))
			return false;
		return true;
	}
	
	
}
