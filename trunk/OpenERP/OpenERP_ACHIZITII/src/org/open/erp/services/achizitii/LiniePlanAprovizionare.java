package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.Material;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class LiniePlanAprovizionare implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLiniePlanAprovizionare;
	@ManyToOne@JoinColumn(name="idPlanAprovizionare")	
	private PlanAprovizionare planAprovizionare;
	
	@ManyToOne@JoinColumn(name="idMaterial")	
	private Material articol;
	
	private Double cantitate;
	private Integer linie;
	
	public LiniePlanAprovizionare() {
		super();
	}
	
	public long getIdLiniePlanAprovizionare() {
		return idLiniePlanAprovizionare;
	}

	public void setIdLiniePlanAprovizionare(long idLiniePlanAprovizionare) {
		this.idLiniePlanAprovizionare = idLiniePlanAprovizionare;
	}

	public LiniePlanAprovizionare(Material articol, Double cantitate,
			Integer linie) {
		super();
		this.articol = articol;
		this.cantitate = cantitate;
		this.linie = linie;
	}
	public Material getArticol() {
		return articol;
	}
	public void setArticol(Material articol) {
		this.articol = articol;
	}
	private Integer status;
	public static final Integer EXISTA_CERERE_OFERTA = -1;
	public static final Integer CREAT_COMANDA = 2;
	public static final Integer OFERTA_PRIMITA = 0;
	public static final Integer IN_ASTEPTARE = 1;
	
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
