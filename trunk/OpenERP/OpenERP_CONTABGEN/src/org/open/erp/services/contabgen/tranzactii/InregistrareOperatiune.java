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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InregistrareOperatiune other = (InregistrareOperatiune) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
