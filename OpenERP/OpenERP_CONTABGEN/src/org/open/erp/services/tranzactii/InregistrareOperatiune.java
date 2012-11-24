package org.open.erp.services.tranzactii;

import org.open.erp.services.conturi.Cont;

public class InregistrareOperatiune{

	public static enum Tip {
		DEBIT, CREDIT
	};

	/**
	 * celalalt cont folosit in cadrul operatiunii
	 */
	private Cont transferCont;

	private InregistrareOperatiuneContabila Inregistrare;

	private Tip tip;

	private double soldCont;

	public InregistrareOperatiune() {
	}

	public InregistrareOperatiune(Cont transferCont, InregistrareOperatiuneContabila Inregistrare,
			Tip tip, double soldCont) {
		this.transferCont = transferCont;
		this.Inregistrare = Inregistrare;
		this.tip = tip;
		this.soldCont = soldCont;
	}

	public InregistrareOperatiuneContabila getInregistrare() {
		return Inregistrare;
	}

	public Cont getTransferCont() {
		return transferCont;
	}

	public Tip getTip() {
		return tip;
	}

	public double getSoldCont() {
		return soldCont;
	}

	public void setInregistrare(InregistrareOperatiuneContabila Inregistrare) {
		this.Inregistrare = Inregistrare;
	}

	public void setTransferCont(Cont transferCont) {
		this.transferCont = transferCont;
	}

	public void setSoldCont(double soldCont) {
		this.soldCont = soldCont;
	}

	public void initTransferCont(Cont transferCont) {
		if (this.transferCont == null)
			setTransferCont(transferCont);
	}

}
