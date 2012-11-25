package org.open.erp.services.productie;

import org.open.erp.services.nommat.MateriePrima;
import org.open.erp.services.nommat.Produs;

public class Reteta {
	private Integer IdReteta;
	private Produs produs;
	private MateriePrima materiePrima;
	private Semifabricat semifabricat;
	private Double cantitate;
	public Integer getIdReteta() {
		return IdReteta;
	}
	public void setIdReteta(Integer idReteta) {
		IdReteta = idReteta;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public MateriePrima getMateriePrima() {
		return materiePrima;
	}
	public void setMateriePrima(MateriePrima materiePrima) {
		this.materiePrima = materiePrima;
	}
	public Semifabricat getSemifabricat() {
		return semifabricat;
	}
	public void setSemifabricat(Semifabricat semifabricat) {
		this.semifabricat = semifabricat;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Reteta(Integer idReteta, Produs produs, MateriePrima materiePrima,
			Semifabricat semifabricat, Double cantitate) {
		super();
		IdReteta = idReteta;
		this.produs = produs;
		this.materiePrima = materiePrima;
		this.semifabricat = semifabricat;
		this.cantitate = cantitate;
	}
	public Reteta() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdReteta == null) ? 0 : IdReteta.hashCode());
		result = prime * result
				+ ((cantitate == null) ? 0 : cantitate.hashCode());
		result = prime * result
				+ ((materiePrima == null) ? 0 : materiePrima.hashCode());
		result = prime * result + ((produs == null) ? 0 : produs.hashCode());
		result = prime * result
				+ ((semifabricat == null) ? 0 : semifabricat.hashCode());
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
		Reteta other = (Reteta) obj;
		if (IdReteta == null) {
			if (other.IdReteta != null)
				return false;
		} else if (!IdReteta.equals(other.IdReteta))
			return false;
		if (cantitate == null) {
			if (other.cantitate != null)
				return false;
		} else if (!cantitate.equals(other.cantitate))
			return false;
		if (materiePrima == null) {
			if (other.materiePrima != null)
				return false;
		} else if (!materiePrima.equals(other.materiePrima))
			return false;
		if (produs == null) {
			if (other.produs != null)
				return false;
		} else if (!produs.equals(other.produs))
			return false;
		if (semifabricat == null) {
			if (other.semifabricat != null)
				return false;
		} else if (!semifabricat.equals(other.semifabricat))
			return false;
		return true;
	}
	
	
}
