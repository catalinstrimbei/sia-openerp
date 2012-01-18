package org.open.erp.services.contabgest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.open.erp.services.productie.ComandaProductie;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class CosturiPrimare extends ComandaProductie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idCostPrimar;
	
	private String tipCost; 
	private Double valoareCost;

	// /luam din comenzi si stocuri

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCostPrimar == null) ? 0 : idCostPrimar.hashCode());
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
		CosturiPrimare other = (CosturiPrimare) obj;
		if (idCostPrimar == null) {
			if (other.idCostPrimar != null)
				return false;
		} else if (!idCostPrimar.equals(other.idCostPrimar))
			return false;
		return true;
	}

	public CosturiPrimare(Integer idCostPrimar, String tipCost,
			Double valoareCost) {
		super();
		this.idCostPrimar = idCostPrimar;
		this.tipCost = tipCost;
		this.valoareCost = valoareCost;
	}

	public CosturiPrimare() {
		super();
	}

	public Integer getIdCostPrimar() {
		return idCostPrimar;
	}

	public void setIdCostPrimar(Integer idCostPrimar) {
		this.idCostPrimar = idCostPrimar;
	}

	public String getTipCost() {
		return tipCost;
	}

	public void setTipCost(String tipCost) {
		this.tipCost = tipCost;
	}

	public Double getValoareCost() {
		return valoareCost;
	}

	public void setValoareCost(Double valoareCost) {
		
		this.valoareCost = valoareCost;
	}

}
