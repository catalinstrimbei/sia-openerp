package org.open.erp.services.vanzari;

import java.util.Date;

public class Avize {

	Integer idAviv;
	Date data;
	Responsabil responsabil;
	public Avize(Integer idAviv, Date data, Responsabil responsabil) {
		super();
		this.idAviv = idAviv;
		this.data = data;
		this.responsabil = responsabil;
	}
	public Integer getIdAviv() {
		return idAviv;
	}
	public void setIdAviv(Integer idAviv) {
		this.idAviv = idAviv;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAviv == null) ? 0 : idAviv.hashCode());
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
		Avize other = (Avize) obj;
		if (idAviv == null) {
			if (other.idAviv != null)
				return false;
		} else if (!idAviv.equals(other.idAviv))
			return false;
		return true;
	}
	
	
	
}
