package org.open.erp.services.contabgest;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @BusinessObject(Entity)
 * 
 */

public class CosturiPrimare {

	private Integer idCostPrimar;
	private String tipCost; //de tip comanda sau din stocuri
	private Double valoareCost;
	
	///luam din comenzi si stocuri
	
	
	
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
