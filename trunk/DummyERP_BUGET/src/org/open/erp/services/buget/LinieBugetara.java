package org.open.erp.services.buget;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class LinieBugetara {
	private Integer idLinieBugetara;
	private Buget buget;
	private Double valoareBugetata;
	private Double valoareConsumata;
	public Integer getIdLinieBugetara() {
		return idLinieBugetara;
	}
	public void setIdLinieBugetara(Integer idLinieBugetara) {
		this.idLinieBugetara = idLinieBugetara;
	}
	public Buget getBuget() {
		return buget;
	}
	public void setBuget(Buget buget) {
		this.buget = buget;
	}
	public Double getValoareBugetata() {
		return valoareBugetata;
	}
	public void setValoareBugetata(Double valoareBugetata) {
		this.valoareBugetata = valoareBugetata;
	}
	public Double getValoareConsumata() {
		return valoareConsumata;
	}
	public void setValoareConsumata(Double valoareConsumata) {
		this.valoareConsumata = valoareConsumata;
	}
	public LinieBugetara(Integer idLinieBugetara, Buget buget,
			Double valoareBugetata) {
		super();
		this.idLinieBugetara = idLinieBugetara;
		this.buget = buget;
		this.valoareBugetata = valoareBugetata;
	}
	public LinieBugetara() {
		super();
	}
	
	
}
