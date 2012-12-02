package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nommat.Produs;

public class FluxProductie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer idFlux;
	Produs produs;
	private List<FazaProductie> fazaProductie  = new ArrayList<FazaProductie>();
	
	public Integer getIdFlux() {
		return idFlux;
	}
	public void setIdFlux(Integer idFlux) {
		this.idFlux = idFlux;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public List<FazaProductie> getFazaProductie() {
		return fazaProductie;
	}
	public void setFazaProductie(List<FazaProductie> fazaProductie) {
		this.fazaProductie = fazaProductie;
	}
	
	public FluxProductie(Integer idFlux, Produs produs,
			List<FazaProductie> fazaProductie) {
		super();
		this.idFlux = idFlux;
		this.produs = produs;
		this.fazaProductie = fazaProductie;
	}
	
	public FluxProductie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fazaProductie == null) ? 0 : fazaProductie.hashCode());
		result = prime * result + ((idFlux == null) ? 0 : idFlux.hashCode());
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
		FluxProductie other = (FluxProductie) obj;
		if (fazaProductie == null) {
			if (other.fazaProductie != null)
				return false;
		} else if (!fazaProductie.equals(other.fazaProductie))
			return false;
		if (idFlux == null) {
			if (other.idFlux != null)
				return false;
		} else if (!idFlux.equals(other.idFlux))
			return false;
		if (produs == null) {
			if (other.produs != null)
				return false;
		} else if (!produs.equals(other.produs))
			return false;
		return true;
	}
	
	
}
