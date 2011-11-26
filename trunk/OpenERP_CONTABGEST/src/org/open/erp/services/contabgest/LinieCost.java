package org.open.erp.services.contabgest;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @BusinessObject(Entity)
 * 
 */

public class LinieCost {
	
	private Integer idLinieCost;
	private CosturiPrimare costuriPrimare;
	private Double valoareAprovizionareExterna; //comanda
	private Double valoareAprovizionareInterna; //val consumata--consum
	
	
	
	
	
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
	public  Double getValoareAprovizionareExterna() {
		return valoareAprovizionareExterna;
	}
	public void setValoareAprovizionareExterna(Double valoareAprovizionareExterna) {
		this.valoareAprovizionareExterna = valoareAprovizionareExterna;
	}
	public Double getValoareAprovizionareInterna() {
		return valoareAprovizionareInterna;
	}
	public void setValoareAprovizionareInterna(Double valoareAprovizionareInterna) {
		this.valoareAprovizionareInterna = valoareAprovizionareInterna;
	}
	
	

}
