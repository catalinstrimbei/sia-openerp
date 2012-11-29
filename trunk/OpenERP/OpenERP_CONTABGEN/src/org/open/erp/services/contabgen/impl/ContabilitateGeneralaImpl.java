package org.open.erp.services.contabgen.impl;

import java.util.List;

import org.open.erp.exceptii.ExceptieTipContInvalid;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.conturi.Clasa;
import org.open.erp.services.conturi.Cont;
import org.open.erp.services.conturi.Cont.Tip;
import org.open.erp.services.conturi.ContActiv;
import org.open.erp.services.conturi.ContCheltuieli;
import org.open.erp.services.conturi.ContPasiv;
import org.open.erp.services.conturi.ContVenituri;
import org.open.erp.services.conturi.PlanConturi;
import org.open.erp.services.rapoarte.BilantContabil;
import org.open.erp.services.sabloane.Sablon;
import org.open.erp.services.tranzactii.InregistrareOperatiune;
import org.open.erp.services.tranzactii.OperatiuneContabila;
import org.open.erp.services.tranzactii.Tranzactie;

public class ContabilitateGeneralaImpl implements ContabilitateGeneralaSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ContabilitateGeneralaImpl.class.getName());

	@Override
	public boolean adaugaCont(Cont cont, Integer codClasa) {

		logger.info("1.1 Creare cont: " + cont.getDenumireCont());

		PlanConturi plan = new PlanConturi();

		logger.info("1.2 Verificare existenta clasa de conturi cu codul: "
				+ codClasa);

		Clasa clasa = plan.getClasaByCod(codClasa);

		if (clasa == null)
			return false;

		logger.info("1.3 Verific daca exista contul: " + cont.getDenumireCont()
				+ ", codul: " + cont.getCodCont());

		if (clasa.getContByCod(cont.getCodCont()) != null) {
			logger.info("1.3.1 Contul exista, nu este nevoie sa-l adaugam");
		} else {
			logger.info("1.4 Contul nu exista. Il adaugam");
			clasa.addCont(cont);

			return true;
		}

		return false;
	}

	@Override
	public Tranzactie creareTranzactie() {
		Tranzactie tran = new Tranzactie();
		return tran;
	}

	@Override
	public Sablon creareSablon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BilantContabil creareBilantContabil() {
		BilantContabil bilant = new BilantContabil();
		return bilant;
	}

	@Override
	public Cont creazaCont(Tip tip) throws ExceptieTipContInvalid {
		switch (tip) {
		case ACTIV:
			return (Cont) new ContActiv();
		case CHELTUIELI:
			return (Cont) new ContCheltuieli();
		case VENITURI:
			return (Cont) new ContVenituri();
		case PASIV:
			return (Cont) new ContPasiv();
		default:
			throw new ExceptieTipContInvalid();
		}

	}

	public static Cont creazaCont(int codCont, String denumireCont,
			String descriere, double sold, Tip tip,
			List<InregistrareOperatiune> intrari, boolean tranzactionabil)
			throws ExceptieTipContInvalid {
		Cont cont = null;

		switch (tip) {
		case ACTIV:
			cont = (Cont) new ContActiv();
			break;
		case CHELTUIELI:
			cont = (Cont) new ContCheltuieli();
			break;
		case VENITURI:
			cont = (Cont) new ContVenituri();
			break;
		case PASIV:
			cont = (Cont) new ContPasiv();
			break;
		default:
			throw new ExceptieTipContInvalid();
		}
		if (cont == null)
			throw new ExceptieTipContInvalid();

		cont.adaugaProprietati(codCont, denumireCont, descriere, sold, tip,
				tranzactionabil, intrari);

		return (Cont) cont;
	}

}
