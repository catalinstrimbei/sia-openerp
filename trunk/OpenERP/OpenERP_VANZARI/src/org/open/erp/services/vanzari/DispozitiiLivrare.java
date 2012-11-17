package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nomgen.Clienti;

public class DispozitiiLivrare {
	Integer idDispozitieLivrare;
	Date data;
	Responsabil responsabil;
	Clienti client;
	public Integer getIdDispozitieLivrare() {
		return idDispozitieLivrare;
	}
	public void setIdDispozitieLivrare(Integer idDispozitieLivrare) {
		this.idDispozitieLivrare = idDispozitieLivrare;
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
	public Clienti getClient() {
		return client;
	}
	public void setClient(Clienti client) {
		this.client = client;
	}
	public DispozitiiLivrare(Integer idDispozitieLivrare, Date data,
			Responsabil responsabil, Clienti client) {
		super();
		this.idDispozitieLivrare = idDispozitieLivrare;
		this.data = data;
		this.responsabil = responsabil;
		this.client = client;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idDispozitieLivrare == null) ? 0 : idDispozitieLivrare
						.hashCode());
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
		DispozitiiLivrare other = (DispozitiiLivrare) obj;
		if (idDispozitieLivrare == null) {
			if (other.idDispozitieLivrare != null)
				return false;
		} else if (!idDispozitieLivrare.equals(other.idDispozitieLivrare))
			return false;
		return true;
	}
	
	

}
