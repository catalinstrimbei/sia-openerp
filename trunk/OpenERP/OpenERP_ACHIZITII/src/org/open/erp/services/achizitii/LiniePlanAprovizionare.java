package org.open.erp.services.achizitii;

public class LiniePlanAprovizionare {
	private PlanAprovizionare planAprovizionare;
	private Articol articol;
	private Double cantitate;
	private Integer linie;
	private Integer status;
	public static final Integer EXISTA_CERERE_OFERTA = -1;
	public static final Integer CREAT_COMANDA = 2;
	public static final Integer OFERTA_PRIMITA = 0;
	public static final Integer IN_ASTEPTARE = 1;
	public LiniePlanAprovizionare(Articol articol, Double cantitate, Integer linie) {
		super();
		this.planAprovizionare = planAprovizionare;
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
