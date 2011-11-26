package org.open.erp.services.nomenclatoare;

import java.util.Date;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class MaterialPrim extends Material {
	
	private Date dataExp;
	private String termenValabilitate;
	
	
	
	
	public MaterialPrim(Integer codMijlocCirculant, String denumire, String uM,
			Date dataExp, String termenValabilitate) {
		super(codMijlocCirculant, denumire, uM);
		this.dataExp = dataExp;
		this.termenValabilitate = termenValabilitate;
	}
	public MaterialPrim() {
		super();
	}
	public Date getDataExp() {
		return dataExp;
	}
	public void setDataExp(Date dataExp) {
		this.dataExp = dataExp;
	}
	public String getTermenValabilitate() {
		return termenValabilitate;
	}
	public void setTermenValabilitate(String termenValabilitate) {
		this.termenValabilitate = termenValabilitate;
	}
	
	
	
	

}
