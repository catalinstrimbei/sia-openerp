package org.open.erp.services.plati;

import java.util.Date;

public class DocumentPlata {
	private Integer idDocumentPlata;
	private String tip;
	private Date data;
	private String seria;
	private Integer nr;
	public Integer getIdDocumentPlata() {
		return idDocumentPlata;
	}
	public void setIdDocumentPlata(Integer idDocumentPlata) {
		this.idDocumentPlata = idDocumentPlata;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getSeria() {
		return seria;
	}
	public void setSeria(String seria) {
		this.seria = seria;
	}
	public Integer getNr() {
		return nr;
	}
	public void setNr(Integer nr) {
		this.nr = nr;
	}
	
}
