package org.open.erp.services.conturi;

public class Cont {
	
	private Integer idCont;
	private Integer codCont;
	private String denumireCont;
	private String tipCont;
	
	public Integer getIdCont() {
		return idCont;
	}
	public void setIdCont(Integer idCont) {
		this.idCont = idCont;
	}
	public Integer getCodCont() {
		return codCont;
	}
	public void setCodCont(Integer codCont) {
		this.codCont = codCont;
	}
	public String getDenumireCont() {
		return denumireCont;
	}
	public void setDenumireCont(String denumireCont) {
		this.denumireCont = denumireCont;
	}
	public String getTipCont() {
		return tipCont;
	}
	public void setTipCont(String tipCont) {
		this.tipCont = tipCont;
	}
	public Cont(Integer idCont, Integer codCont, String denumireCont,
			String tipCont) {
		super();
		this.idCont = idCont;
		this.codCont = codCont;
		this.denumireCont = denumireCont;
		this.tipCont = tipCont;
	}
}
