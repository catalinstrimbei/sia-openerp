package org.open.erp.services.achizitii;

import org.open.erp.services.nommat.Materiale;

public class LiniiPlanAprov {
	private Integer nrLiniePlanAprov;
	private PlanAprov planAProv;
	private Materiale material;
	private Double cantitate;
	public Integer getNrLiniePlanAprov() {
		return nrLiniePlanAprov;
	}
	public void setNrLiniePlanAprov(Integer nrLiniePlanAprov) {
		this.nrLiniePlanAprov = nrLiniePlanAprov;
	}
	public PlanAprov getPlanAProv() {
		return planAProv;
	}
	public void setPlanAProv(PlanAprov planAProv) {
		this.planAProv = planAProv;
	}
	public Materiale getMaterial() {
		return material;
	}
	public void setMaterial(Materiale material) {
		this.material = material;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public LiniiPlanAprov(Integer nrLiniePlanAprov, PlanAprov planAProv,
			Materiale material, Double cantitate) {
		super();
		this.nrLiniePlanAprov = nrLiniePlanAprov;
		this.planAProv = planAProv;
		this.material = material;
		this.cantitate = cantitate;
	}
	public LiniiPlanAprov() {
		super();
	}
	
	

}
