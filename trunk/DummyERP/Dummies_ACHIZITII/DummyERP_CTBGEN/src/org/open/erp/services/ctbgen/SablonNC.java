package org.open.erp.services.ctbgen;

public class SablonNC {
	private Integer idSablon;
	private Integer nrSablon;
	private Cont contDebit;
	private Cont contCredit;
	public Integer getIdSablon() {
		return idSablon;
	}
	public void setIdSablon(Integer idSablon) {
		this.idSablon = idSablon;
	}
	public Integer getNrSablon() {
		return nrSablon;
	}
	public void setNrSablon(Integer nrSablon) {
		this.nrSablon = nrSablon;
	}
	public Cont getContDebit() {
		return contDebit;
	}
	public void setContDebit(Cont contDebit) {
		this.contDebit = contDebit;
	}
	public Cont getContCredit() {
		return contCredit;
	}
	public void setContCredit(Cont contCredit) {
		this.contCredit = contCredit;
	}
	public SablonNC(Integer idSablon, Integer nrSablon, Cont contDebit,
			Cont contCredit) {
		super();
		this.idSablon = idSablon;
		this.nrSablon = nrSablon;
		this.contDebit = contDebit;
		this.contCredit = contCredit;
	}
	public SablonNC() {
		super();
	}
	
		
}
