package org.open.erp.services.productie;

import java.util.Date;

import org.open.erp.services.nommat.Produs;
import org.open.erp.services.stocuri.ComandaProductie;

public class FisaProductie {
	private Integer IdFisaProductie;
	private ComandaProductie comandaProductie;
	private Produs produs;
	private Date data;
	public Integer getIdFisaProductie() {
		return IdFisaProductie;
	}
	public void setIdFisaProductie(Integer idFisaProductie) {
		IdFisaProductie = idFisaProductie;
	}
	public ComandaProductie getComandaProductie() {
		return comandaProductie;
	}
	public void setComandaProductie(ComandaProductie comandaProductie) {
		this.comandaProductie = comandaProductie;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public FisaProductie(Integer idFisaProductie,
			ComandaProductie comandaProductie, Produs produs, Date data) {
		super();
		IdFisaProductie = idFisaProductie;
		this.comandaProductie = comandaProductie;
		this.produs = produs;
		this.data = data;
	}
	public FisaProductie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdFisaProductie == null) ? 0 : IdFisaProductie.hashCode());
		result = prime
				* result
				+ ((comandaProductie == null) ? 0 : comandaProductie.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		FisaProductie other = (FisaProductie) obj;
		if (IdFisaProductie == null) {
			if (other.IdFisaProductie != null)
				return false;
		} else if (!IdFisaProductie.equals(other.IdFisaProductie))
			return false;
		if (comandaProductie == null) {
			if (other.comandaProductie != null)
				return false;
		} else if (!comandaProductie.equals(other.comandaProductie))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (produs == null) {
			if (other.produs != null)
				return false;
		} else if (!produs.equals(other.produs))
			return false;
		return true;
	}
	
	
}
