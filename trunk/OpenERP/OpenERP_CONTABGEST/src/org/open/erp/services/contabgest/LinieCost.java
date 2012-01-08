package org.open.erp.services.contabgest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class LinieCost implements Serializable {
	@Id
	@GeneratedValue
	private Integer idLinieCost;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idLinieCost == null) ? 0 : idLinieCost.hashCode());
		return result;
	}

	private CosturiPrimare costuriPrimare;
	private Double valoareAprovizionareExterna; // comanda
	private Double valoareAprovizionareInterna; // val consumata--consum

	public LinieCost() {
		super();
	}

	public LinieCost(Integer idLinieCost, CosturiPrimare costuriPrimare,
			Double valoareAprovizionareExterna,
			Double valoareAprovizionareInterna) {
		super();
		this.idLinieCost = idLinieCost;
		this.costuriPrimare = costuriPrimare;
		this.valoareAprovizionareExterna = valoareAprovizionareExterna;
		this.valoareAprovizionareInterna = valoareAprovizionareInterna;
	}

	public Integer getIdLinieCost() {
		return idLinieCost;
	}

	public void setIdLinieCost(Integer idLinieCost) {
		this.idLinieCost = idLinieCost;
	}

	public CosturiPrimare getCosturiPrimare() {
		return costuriPrimare;
	}

	public void setCosturiPrimare(CosturiPrimare costuriPrimare) {
		this.costuriPrimare = costuriPrimare;
	}

	public Double getValoareAprovizionareExterna() {
		return valoareAprovizionareExterna;
	}

	public void setValoareAprovizionareExterna(
			Double valoareAprovizionareExterna) {
		this.valoareAprovizionareExterna = valoareAprovizionareExterna;
	}

	public Double getValoareAprovizionareInterna() {
		return valoareAprovizionareInterna;
	}

	public void setValoareAprovizionareInterna(
			Double valoareAprovizionareInterna) {
		this.valoareAprovizionareInterna = valoareAprovizionareInterna;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinieCost other = (LinieCost) obj;
		if (idLinieCost == null) {
			if (other.idLinieCost != null)
				return false;
		} else if (!idLinieCost.equals(other.idLinieCost))
			return false;
		return true;
	}

}
