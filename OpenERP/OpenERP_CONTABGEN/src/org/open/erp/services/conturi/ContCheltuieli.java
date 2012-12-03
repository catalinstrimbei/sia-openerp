package org.open.erp.services.conturi;

import java.util.List;

import org.open.erp.services.tranzactii.InregistrareOperatiune;

public class ContCheltuieli extends Cont{
	public ContCheltuieli() {
		super();
		tip = Tip.CHELTUIELI;
	}

	public ContCheltuieli(int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil) {
		super(codCont, denumire, descriere, sold, tranzactionabil);
		tip = Tip.CHELTUIELI;
	}

	public ContCheltuieli(int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil,
			List<InregistrareOperatiune> intrari) {
		super(codCont, denumire, descriere, sold, tranzactionabil,
				Tip.CHELTUIELI,
				intrari);
	}

	protected void modificaDebit(double suma) {
		sold += suma;
	}

	protected void modificaCredit(double suma) {
		sold -= suma;
	}

}