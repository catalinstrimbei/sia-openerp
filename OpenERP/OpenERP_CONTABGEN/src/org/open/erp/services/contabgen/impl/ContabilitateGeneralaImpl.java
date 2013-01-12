package org.open.erp.services.contabgen.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.exceptii.ExceptieTipContInvalid;
import org.open.erp.services.contabgen.ContabilitateGeneralaLocalSrv;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.conturi.Clasa;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.Cont.Tip;
import org.open.erp.services.contabgen.conturi.ContActiv;
import org.open.erp.services.contabgen.conturi.ContCheltuieli;
import org.open.erp.services.contabgen.conturi.ContPasiv;
import org.open.erp.services.contabgen.conturi.ContVenituri;
import org.open.erp.services.contabgen.conturi.PlanConturi;
import org.open.erp.services.contabgen.rapoarte.BilantContabil;
import org.open.erp.services.contabgen.sabloane.Sablon;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.OperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.Tranzactie;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContabilitateGeneralaImpl implements ContabilitateGeneralaLocalSrv, ContabilitateGeneralaSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ContabilitateGeneralaImpl.class.getName());

	@PersistenceContext(unitName = "OpenERP_CONTABGEN")
	private EntityManager em;
	
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
	public Sablon creareSablon(String denumire, OperatiuneContabila opCont) {
		logger.info("3.1 Creare sablon: " + denumire);	
		logger.info("3.2. Selectare operatiune contabila: " + opCont.getDescriereOperatiune());
		
		logger.info("3.3. Specificare inregistrari: ");
		
		for(InregistrareOperatiuneContabila op : opCont.getInregistrari())
		{
			logger.info("3.3.1 Cont debitor: " + op.getDebitCont().getDenumireCont());
			logger.info("3.3.2 Cont creditor: " + op.getContCredit().getDenumireCont());
		}
		
		logger.info("3.4 Salvare sablon");
		return new Sablon(denumire, opCont);
	}

	@Override
	public BilantContabil creareBilantContabil(ArrayList<Cont> conturi) {
		BilantContabil bilant = new BilantContabil(conturi);
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
