package org.open.erp.services.vanzari;

import java.util.Date;

public class Facturi {

	Integer idFactura;
	Date data;
	Responsabil responsabil;
	Integer avizCorespondent;
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public Integer getAvizCorespondent() {
		return avizCorespondent;
	}
	public void setAvizCorespondent(Integer avizCorespondent) {
		this.avizCorespondent = avizCorespondent;
	}
	public Facturi(Integer idFactura, Date data, Responsabil responsabil,
			Integer avizCorespondent) {
		super();
		this.idFactura = idFactura;
		this.data = data;
		this.responsabil = responsabil;
		this.avizCorespondent = avizCorespondent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFactura == null) ? 0 : idFactura.hashCode());
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
		Facturi other = (Facturi) obj;
		if (idFactura == null) {
			if (other.idFactura != null)
				return false;
		} else if (!idFactura.equals(other.idFactura))
			return false;
		return true;
	}
	
	
}
