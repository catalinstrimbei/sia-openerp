package org.open.erp.services.contabgen.conturi;

import java.util.List;

import javax.persistence.Entity;

import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;

@Entity
public class ContActiv extends Cont {

	public ContActiv() {
		super();
		tip = Tip.ACTIV;
	}

	public ContActiv(int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil) {
		super(codCont, denumire, descriere, sold, tranzactionabil);
		tip = Tip.ACTIV;
	}

	public ContActiv(int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil,
			List<InregistrareOperatiune> intrari) {
		super(codCont, denumire, descriere, sold, tranzactionabil, Tip.ACTIV,
				intrari);
	}

	protected void modificaDebit(double suma) {
		sold += suma;
	}

	protected void modificaCredit(double suma) {
		sold -= suma;
	}

}
