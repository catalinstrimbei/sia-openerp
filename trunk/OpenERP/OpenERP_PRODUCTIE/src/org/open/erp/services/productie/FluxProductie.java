package org.open.erp.services.productie;

import java.util.ArrayList;
import java.util.List;

public class FluxProductie {
	private Integer idflux;
	private String denumireflux;
	private Lot lot;
	private List<FazaProductie> fazaproductie = new ArrayList<FazaProductie>();
	
	public Integer getIdflux() {
		return idflux;
	}
	public void setIdflux(Integer idflux) {
		this.idflux = idflux;
	}
	public String getDenumireflux() {
		return denumireflux;
	}
	public void setDenumireflux(String denumireflux) {
		this.denumireflux = denumireflux;
	}
	public List<FazaProductie> getFazaproductie() {
		return fazaproductie;
	}
	public void setFazaproductie(List<FazaProductie> fazaproductie) {
		this.fazaproductie = fazaproductie;
	}
	public FluxProductie(Integer idflux, String denumireflux,
			List<FazaProductie> fazaproductie) {
		super();
		this.idflux = idflux;
		this.denumireflux = denumireflux;
		this.fazaproductie = fazaproductie;
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
				+ ((denumireflux == null) ? 0 : denumireflux.hashCode());
		result = prime * result
				+ ((fazaproductie == null) ? 0 : fazaproductie.hashCode());
		result = prime * result + ((idflux == null) ? 0 : idflux.hashCode());
		result = prime * result + ((lot == null) ? 0 : lot.hashCode());
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
		if (denumireflux == null) {
			if (other.denumireflux != null)
				return false;
		} else if (!denumireflux.equals(other.denumireflux))
			return false;
		if (fazaproductie == null) {
			if (other.fazaproductie != null)
				return false;
		} else if (!fazaproductie.equals(other.fazaproductie))
			return false;
		if (idflux == null) {
			if (other.idflux != null)
				return false;
		} else if (!idflux.equals(other.idflux))
			return false;
		if (lot == null) {
			if (other.lot != null)
				return false;
		} else if (!lot.equals(other.lot))
			return false;
		return true;
	}
	public Lot getLot() {
		return lot;
	}
	public void setLot(Lot lot) {
		this.lot = lot;
		
	}
	public FluxProductie(Lot lot) {
		super();
		this.lot = lot;
		
	}
	
	
	
	
	
	
}
	
	
	
	