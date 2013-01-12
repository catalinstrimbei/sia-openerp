package org.open.erp.services.contabgen.tranzactii;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.open.erp.services.contabgen.conturi.Cont;

@Entity
public class InregistrareOperatiune implements Serializable{

	
	@Id
	@GeneratedValue
	private Integer id;
	public static enum Tip {
		DEBIT, CREDIT
	};

	/**
	 * celalalt cont folosit in cadrul operatiunii
	 */
	@OneToOne(cascade=CascadeType.ALL)
	private Cont transferCont;

	@OneToOne(cascade=CascadeType.ALL)
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
