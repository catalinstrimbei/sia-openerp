package org.open.erp.services.incasari.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.TipIncasare;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.incasari.BiletLaOrdin;
import org.open.erp.services.incasari.Cec;
import org.open.erp.services.incasari.Chitanta;
import org.open.erp.services.incasari.ExtrasCont;
import org.open.erp.services.incasari.Incasare;
import org.open.erp.services.incasari.IncasariSrvLocal;
import org.open.erp.services.incasari.IncasariSrvRemote;
import org.open.erp.services.incasari.exception.IncasariException;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;
import org.open.erp.services.vanzari.VanzariSrv;

@Stateless(name = "IncasariSrv", mappedName = "IncasariSrv")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class IncasariImpl implements IncasariSrvLocal, IncasariSrvRemote {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(IncasariImpl.class.getName());
	@EJB(mappedName = "VanzariSrvImpl/local")
	private VanzariSrv vanzariSrv;

	@EJB(mappedName = "ContabilizareSrvImpl/local")
	private ContabilizareSrv ctbSrv;

	@PersistenceContext(unitName = "OpenERP_FININCASARI")
	private EntityManager em;

	@Resource
	private SessionContext sessionContext;

	@PostConstruct
	public void init() {
		logger.debug("EntityManager: " + em);
		logger.debug("PersonalSrv: " + vanzariSrv);
		logger.debug("ContabilizareSrv: " + ctbSrv);

	}

	public VanzariSrv getVanzariSrv() {
		return vanzariSrv;
	}

	public void setVanzariSrv(VanzariSrv vanzariSrv) {
		this.vanzariSrv = vanzariSrv;
	}

	public ContabilizareSrv getCtbSrv() {
		return ctbSrv;
	}

	public void setCtbSrv(ContabilizareSrv ctbSrv) {
		this.ctbSrv = ctbSrv;
	}

	/**
	 * @throws CtbException
	 * @throws NumberFormatException
	 * @throws IncasariException
	 * @ApplicationServiceFacade
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaEmisa> facturi, Date dataEmiterii, String seria,
			Integer numar, String locatie, String moneda, Client client,
			Double curs) throws IncasariException {

		if (sumaIncasata == null || sumaIncasata == 0.00) {
			throw new IncasariException("Suma incasarii nu poate fi nula!");
		}
		Chitanta chitanta;

		List<FacturaEmisa> facturiSelectate = new ArrayList<FacturaEmisa>(0);

		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		chitanta = new Chitanta(dataEmiterii, avans, dataInregistrarii,
				sumaIncasata, sumaIncasataLitere, seria, numar, locatie, casier);

		if (facturi.size() == 0) {
			facturi = vanzariSrv.getFacturiClient(client);
		}
		if (!moneda.equals("RON")) {
			sumaIncasata = getSumaRON(moneda, sumaIncasata, curs);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, sumaIncasata);

		chitanta.setFacturi(facturiSelectate);
		try {
			if (avans) {

				ctbSrv.jurnalizareIncasare(dataInregistrarii, sumaIncasata,
						numar, TipIncasare.AVANSC, client.getId(), 401,
						StareDocument.NOU, null);

			}

			else {

				ctbSrv.jurnalizareIncasare(dataInregistrarii, sumaIncasata,
						numar, TipIncasare.CASA, client.getId(), 401,
						StareDocument.NOU, null);

			}

		} catch (Exception e) {
			throw new IncasariException(e.getMessage());
		}

		return chitanta;

	}

	/**
	 * @throws CtbException
	 * @throws NumberFormatException
	 * @ApplicationServiceFacade
	 */

	@Override
	public void confirmareIncasare(Incasare doc) throws CtbException,
			IncasariException {
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();
		if (doc instanceof Cec) {

			((Cec) doc).setStare("incasat");

			ctbSrv.jurnalizareIncasare(dataInregistrarii, doc.getSuma(),
					doc.getNumar(), TipIncasare.CEC, doc.getFacturi().get(0)
							.getClient().getId(), 0, StareDocument.MODIFICAT, 0);

		} else if (doc instanceof BiletLaOrdin) {
			((BiletLaOrdin) doc).setStare("incasat");

			ctbSrv.jurnalizareIncasare(dataInregistrarii, doc.getSuma(),
					doc.getNumar(), TipIncasare.BO, doc.getFacturi().get(0)
							.getClient().getId(), 0, StareDocument.MODIFICAT, 0);
		}
	}

	/**
	 * @ApplicationServiceFacade
	 */

	@Override
	public void confirmareDepunereLaBanca(Incasare doc) {

		if (doc instanceof Cec) {
			((Cec) doc).setStare("depus");

		} else if (doc instanceof BiletLaOrdin) {
			((BiletLaOrdin) doc).setStare("depus");
		}

	}

	/**
	 * @ApplicationServiceFacade
	 */
	private List<FacturaEmisa> compensariIncasariFacturi(
			List<FacturaEmisa> facturi, Double suma) throws IncasariException {

		List<FacturaEmisa> facturiAsociate = new ArrayList<FacturaEmisa>();
		for (FacturaEmisa fact : facturi) {
			if (!fact.getPlatita()) {
				facturiAsociate.add(fact);
				Double restPlata = restIncasareFactura(fact);
				if (suma > restPlata) {
					fact.setSumaIncasata(fact.getValoareTotalaFactura());
					suma -= restPlata;
				} else {
					fact.setSumaIncasata(fact.getSumaIncasata() + suma);
					suma = 0.00;
					break;
				}

			}

		}
		if (suma > 0) {
			throw new IncasariException(
					"Suma incasata depaseste suma de incasat");
		}
		return facturiAsociate;

	}

	/**
	 * @ApplicationServiceFacade
	 */

	@Override
	public void confirmareImposibilitatePlata(Incasare doc) {
		if (doc instanceof Cec) {
			((Cec) doc).setStare("refuzat");
		} else if (doc instanceof BiletLaOrdin) {
			((BiletLaOrdin) doc).setStare("refuzat");
		}

	}

	/**
	 * @ApplicationServiceFacade
	 */

	public Double getSumaRON(String moneda, Double suma, Double curs) {
		if (moneda.equals("EURO")) {
			suma = suma * curs;
		}
		return suma;
	}

	/**
	 * @throws IncasariException
	 * @ApplicationServiceFacade
	 */

	@Override
	public Cec inregistrareCec(Date dataEmiterii, Boolean avans, Client client,
			String seria, Integer numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaEmisa> facturi,
			String moneda, Double curs) throws IncasariException {

		if (suma == null || suma == 0.00) {
			throw new IncasariException("Suma incasarii nu poate fi nula!");
		}
		Cec cec;
		List<FacturaEmisa> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}
		cec = new Cec(dataEmiterii, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie, stare);

		if (facturi.size() == 0) {
			facturi = vanzariSrv.getFacturiClient(client);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, suma);

		cec.setFacturi(facturiSelectate);

		return cec;
	}

	/**
	 * @throws IncasariException
	 * @ApplicationServiceFacade
	 */
	@Override
	public BiletLaOrdin inregistrareBiletLaOrdin(Date dataEmiterii,
			Boolean avans, Client client, String seria, Integer numar,
			String locatie, String stare, List<FacturaEmisa> facturi,
			Persoana garant, Date dataScadenta, Double suma,
			String sumaInLitere, String moneda, Double curs)
			throws IncasariException {

		if (suma == null || suma == 0.00) {
			throw new IncasariException("Suma incasarii nu poate fi nula!");
		}
		BiletLaOrdin bo;
		List<FacturaEmisa> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}

		bo = new BiletLaOrdin(dataEmiterii, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie, dataScadenta, garant,
				stare);

		if (facturi.size() == 0) {
			facturi = vanzariSrv.getFacturiClient(client);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, suma);

		bo.setFacturi(facturiSelectate);

		return bo;
	}

	@Override
	// metoda care ar putea apartine de modulul Vanzari
	public Double restIncasareFactura(FacturaEmisa factura) {
		return factura.getValoareTotalaFactura() - factura.getSumaIncasata();

	}

	@Override
	public ExtrasCont inregistrareExtrasCont(Date dataEmiterii, Boolean avans,
			Client client, String seria, Integer numar, String locatie,
			List<FacturaEmisa> facturi, Double suma, String sumaInLitere,
			String moneda, Double curs) throws IncasariException {

		if (suma == null || suma == 0.00) {
			throw new IncasariException("Suma incasarii nu poate fi nula!");
		}
		ExtrasCont extrasCont;
		List<FacturaEmisa> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}

		extrasCont = new ExtrasCont(dataEmiterii, avans, dataInregistrarii,
				suma, sumaInLitere, seria, numar, locatie);

		if (facturi.size() == 0) {
			facturi = vanzariSrv.getFacturiClient(client);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, suma);

		extrasCont.setFacturi(facturiSelectate);

		return extrasCont;
	}
}
