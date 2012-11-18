package org.open.erp.services.tranzactii;

public class TipOperatiune {
	
	Integer idTipOperatiune;
	String tipOperatiune;
	String descriereTipOperatiune;
	public Integer getIdTipOperatiune() {
		return idTipOperatiune;
	}
	public void setIdTipOperatiune(Integer idTipOperatiune) {
		this.idTipOperatiune = idTipOperatiune;
	}
	public String getTipOperatiune() {
		return tipOperatiune;
	}
	public void setTipOperatiune(String tipOperatiune) {
		this.tipOperatiune = tipOperatiune;
	}
	public String getDescriereTipOperatiune() {
		return descriereTipOperatiune;
	}
	public void setDescriereTipOperatiune(String descriereTipOperatiune) {
		this.descriereTipOperatiune = descriereTipOperatiune;
	}
	
	public TipOperatiune(Integer idTipOperatiune, String tipOperatiune,
			String descriereTipOperatiune) {
		super();
		this.idTipOperatiune = idTipOperatiune;
		this.tipOperatiune = tipOperatiune;
		this.descriereTipOperatiune = descriereTipOperatiune;
	}
	
	
}
