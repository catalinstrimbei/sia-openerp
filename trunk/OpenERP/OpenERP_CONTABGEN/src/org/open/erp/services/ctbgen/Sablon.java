package org.open.erp.services.ctbgen;



public class Sablon {
	private Cont contDebit;
	private Cont contCredit;
	
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
	public Sablon(Cont contDebit, Cont contCredit) {
		super();
		this.contDebit = contDebit;
		this.contCredit = contCredit;
	}
	public Sablon() {
		super();
	}
	
	
}
