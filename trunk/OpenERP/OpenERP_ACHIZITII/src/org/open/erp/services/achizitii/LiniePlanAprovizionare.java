package org.open.erp.services.achizitii;

public class LiniePlanAprovizionare {
	public PlanAprovizionare planAprovizionare;
	public Articol articol;
	public Double cantitate;
	public Integer linie;
	public LiniePlanAprovizionare(Articol articol, Double cantitate, Integer linie) {
		super();
		this.planAprovizionare = planAprovizionare;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
	}
	public PlanAprovizionare getPlanAprovizionare() {
		return planAprovizionare;
	}
	public void setPlanAprovizionare(PlanAprovizionare planAprovizionare) {
		this.planAprovizionare = planAprovizionare;
	}
	public Articol getArticol() {
		return articol;
	}
	public void setArticol(Articol articol) {
		this.articol = articol;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Integer getLinie() {
		return linie;
	}
	public void setLinie(Integer linie) {
		this.linie = linie;
	}
	

}
