package org.open.erp.services.contabgest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CosturiExtra implements Serializable{
	
	@Id @GeneratedValue
	private Integer IdCosturi;
	
	@ManyToOne
	private Calculatii calculatie;
	
	private String denumireCost;//utilitati, manopera, utilaje
	private Double valoareCost;
	public Integer getIdCosturi() {
		return IdCosturi;
	}
	public void setIdCosturi(Integer idCosturi) {
		IdCosturi = idCosturi;
	}
	public Calculatii getCalculatie() {
		return calculatie;
	}
	public void setCalculatie(Calculatii calculatie) {
		this.calculatie = calculatie;
	}
	public String getDenumireCost() {
		return denumireCost;
	}
	public void setDenumireCost(String denumireCost) {
		this.denumireCost = denumireCost;
	}
	public Double getValoareCost() {
		return valoareCost;
	}
	public void setValoareCost(Double valoareCost) {
		this.valoareCost = valoareCost;
	}
	public CosturiExtra() {
		super();
	}
	public CosturiExtra(Integer idCosturi, Calculatii calculatie,
			String denumireCost, Double valoareCost) {
		super();
		IdCosturi = idCosturi;
		this.calculatie = calculatie;
		this.denumireCost = denumireCost;
		this.valoareCost = valoareCost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdCosturi == null) ? 0 : IdCosturi.hashCode());
		result = prime * result
				+ ((calculatie == null) ? 0 : calculatie.hashCode());
		result = prime * result
				+ ((denumireCost == null) ? 0 : denumireCost.hashCode());
		result = prime * result
				+ ((valoareCost == null) ? 0 : valoareCost.hashCode());
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
		CosturiExtra other = (CosturiExtra) obj;
		if (IdCosturi == null) {
			if (other.IdCosturi != null)
				return false;
		} else if (!IdCosturi.equals(other.IdCosturi))
			return false;
		if (calculatie == null) {
			if (other.calculatie != null)
				return false;
		} else if (!calculatie.equals(other.calculatie))
			return false;
		if (denumireCost == null) {
			if (other.denumireCost != null)
				return false;
		} else if (!denumireCost.equals(other.denumireCost))
			return false;
		if (valoareCost == null) {
			if (other.valoareCost != null)
				return false;
		} else if (!valoareCost.equals(other.valoareCost))
			return false;
		return true;
	}
}