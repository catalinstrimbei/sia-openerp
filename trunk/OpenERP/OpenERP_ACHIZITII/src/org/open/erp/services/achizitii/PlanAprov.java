package org.open.erp.services.achizitii;

import java.util.ArrayList;
import java.util.List;

public class PlanAprov {
	private Integer nrPlanAprov;
	private Integer an;
	private Integer luna;
	private Integer saptamana;
	private List<LiniiPlanAprov> liniiPlanAprov = new ArrayList<LiniiPlanAprov>();
	
	public void adaugaLinie(LiniiPlanAprov linie){
		this.liniiPlanAprov.add(linie);
	}
	public Integer getNrPlanAprov() {
		return nrPlanAprov;
	}
	public void setNrPlanAprov(Integer nrPlanAprov) {
		this.nrPlanAprov = nrPlanAprov;
	}
	public Integer getAn() {
		return an;
	}
	public void setAn(Integer an) {
		this.an = an;
	}
	public Integer getLuna() {
		return luna;
	}
	public void setLuna(Integer luna) {
		this.luna = luna;
	}
	public Integer getSaptamana() {
		return saptamana;
	}
	public void setSaptamana(Integer saptamana) {
		this.saptamana = saptamana;
	}
	public List<LiniiPlanAprov> getLiniiPlanAprov() {
		return liniiPlanAprov;
	}
	public void setLiniiPlanAprov(List<LiniiPlanAprov> liniiPlanAprov) {
		this.liniiPlanAprov = liniiPlanAprov;
	}
	public PlanAprov(Integer nrPlanAprov, Integer an, Integer luna,
			Integer saptamana)//, List<LiniiPlanAprov> liniiPlanAprov)
			{
		super();
		this.nrPlanAprov = nrPlanAprov;
		this.an = an;
		this.luna = luna;
		this.saptamana = saptamana;
		//this.liniiPlanAprov = liniiPlanAprov;
	}
	public PlanAprov() {
		super();
	}
	

	
}
