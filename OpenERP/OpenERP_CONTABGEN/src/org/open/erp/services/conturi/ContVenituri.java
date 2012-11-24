package org.open.erp.services.conturi;

import java.util.List;

import org.open.erp.services.tranzactii.InregistrareOperatiune;

public class ContVenituri extends Cont {
	public ContVenituri() {
		super();
		tip = Tip.VENITURI;
	}

	public ContVenituri(int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil) {
		super(codCont, denumire, descriere, sold, tranzactionabil);
		tip = Tip.VENITURI;
	}

	public ContVenituri(int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil,
			List<InregistrareOperatiune> intrari) {
		super(codCont, denumire, descriere, sold, tranzactionabil,
				Tip.VENITURI, intrari);
	}

	protected void modificaDebit(double suma) {
		sold += suma;
	}

	protected void modificaCredit(double suma) {
		sold -= suma;
	}

}
