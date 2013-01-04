package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.open.erp.services.nommat.Material;

@Entity
public class LiniiPlanAprov implements Serializable{	
	@Id @GeneratedValue
	private Integer nrLiniePlanAprov;
	
	@ManyToOne
	private PlanAprov planAProv;
	
	@OneToOne
	private Material material;
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
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public LiniiPlanAprov(Integer nrLiniePlanAprov, PlanAprov planAProv,
			Material material, Double cantitate) {
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
