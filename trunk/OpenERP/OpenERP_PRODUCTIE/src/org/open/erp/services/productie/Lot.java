package org.open.erp.services.productie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lot {
	private Integer IdLot;
	private FluxProductie fluxProductie;
	private List<Articol> articol = new ArrayList<Articol>();
	private Date dataCreare;
	public Integer getIdLot() {
		return IdLot;
	}
	public void setIdLot(Integer idLot) {
		IdLot = idLot;
	}
	public FluxProductie getFluxProductie() {
		return fluxProductie;
	}
	public void setFluxProductie(FluxProductie fluxProductie) {
		this.fluxProductie = fluxProductie;
	}
	public List<Articol> getArticol() {
		return articol;
	}
	public void setArticol(List<Articol> articol) {
		this.articol = articol;
	}
	public Date getDataCreare() {
		return dataCreare;
	}
	public void setDataCreare(Date dataCreare) {
		this.dataCreare = dataCreare;
	}
	public Lot(Integer idLot, FluxProductie fluxProductie,
			List<Articol> articol, Date dataCreare) {
		super();
		IdLot = idLot;
		this.fluxProductie = fluxProductie;
		this.articol = articol;
		this.dataCreare = dataCreare;
	}
	public Lot() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdLot == null) ? 0 : IdLot.hashCode());
		result = prime * result + ((articol == null) ? 0 : articol.hashCode());
		result = prime * result
				+ ((dataCreare == null) ? 0 : dataCreare.hashCode());
		result = prime * result
				+ ((fluxProductie == null) ? 0 : fluxProductie.hashCode());
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
		Lot other = (Lot) obj;
		if (IdLot == null) {
			if (other.IdLot != null)
				return false;
		} else if (!IdLot.equals(other.IdLot))
			return false;
		if (articol == null) {
			if (other.articol != null)
				return false;
		} else if (!articol.equals(other.articol))
			return false;
		if (dataCreare == null) {
			if (other.dataCreare != null)
				return false;
		} else if (!dataCreare.equals(other.dataCreare))
			return false;
		if (fluxProductie == null) {
			if (other.fluxProductie != null)
				return false;
		} else if (!fluxProductie.equals(other.fluxProductie))
			return false;
		return true;
	}
	
	
}
