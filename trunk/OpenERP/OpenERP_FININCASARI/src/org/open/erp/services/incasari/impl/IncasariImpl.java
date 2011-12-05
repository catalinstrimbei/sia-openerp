package org.open.erp.services.incasari.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.TipIncasare;
import org.open.erp.services.incasari.BiletLaOrdin;
import org.open.erp.services.incasari.Cec;
import org.open.erp.services.incasari.Chitanta;
import org.open.erp.services.incasari.Incasare;
import org.open.erp.services.incasari.IncasariSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;
import org.open.erp.services.vanzari.VanzariSrv;

public class IncasariImpl implements IncasariSrv {

	private VanzariSrv vanzariSrv;
	private ContabilizareSrv ctbSrv;

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
	 * @ApplicationServiceFacade
	 */

	@Override
	public Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaEmisa> facturi, Date dataEmiterii, String seria,
			String numar, String locatie, String moneda, Client client)
			throws Exception {

		Chitanta chitanta;
		Integer idCont = 0;
		Integer idInreg = 0;
		List<FacturaEmisa> facturiSelectate = new ArrayList<FacturaEmisa>(0);
		if (sumaIncasata > 0) {
			Calendar currentDate = Calendar.getInstance();
			Date dataInregistrarii = currentDate.getTime();

			chitanta = new Chitanta(dataEmiterii, avans, dataInregistrarii,
					sumaIncasata, sumaIncasataLitere, seria, numar, locatie,
					casier);

			if (facturi.size() == 0) {
				facturi = vanzariSrv.getFacturiClient(client);
			}
			facturiSelectate = compensariIncasariFacturi(facturi, sumaIncasata);

			chitanta.setFacturi(facturiSelectate);
			if (avans) {

				ctbSrv.jurnalizareIncasare(dataInregistrarii, sumaIncasata,
						Integer.valueOf(numar), TipIncasare.AVANSC,
						client.getId(), idCont, StareDocument.NOU, idInreg);

			}

			else {

				ctbSrv.jurnalizareIncasare(dataInregistrarii, sumaIncasata,
						Integer.valueOf(numar), TipIncasare.CASA,
						client.getId(), idCont, StareDocument.NOU, idInreg);
			}

		} else {
			chitanta = null;
		}

		return chitanta;

	}

	/**
	 * @ApplicationServiceFacade
	 */

	@Override
	public void confirmareIncasare(Incasare doc) throws Exception {
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();
		if (doc instanceof Cec) {

			((Cec) doc).setStare("incasat");

			ctbSrv.jurnalizareIncasare(dataInregistrarii, doc.getSuma(),
					Integer.valueOf(doc.getNumar()), TipIncasare.CEC, doc
							.getFacturi().get(0).getClient().getId(), 0,
					StareDocument.MODIFICAT, 0);

		} else if (doc instanceof BiletLaOrdin) {
			((BiletLaOrdin) doc).setStare("incasat");

			ctbSrv.jurnalizareIncasare(dataInregistrarii, doc.getSuma(),
					Integer.valueOf(doc.getNumar()), TipIncasare.BO, doc
							.getFacturi().get(0).getClient().getId(), 0,
					StareDocument.MODIFICAT, 0);
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
			List<FacturaEmisa> facturi, Double suma) throws Exception {

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
			throw new Exception("Suma incasata depaseste suma de incasat");
		}
		return facturiAsociate;

	}

	/**
	 * @ApplicationServiceFacade
	 */

	// respingerea nu se inregistreaza in contabilitate
	/*
	 * @Override public void confirmareImposibilitatePlata(Incasare doc) { if
	 * (doc instanceof Cec) { ((Cec) doc).setStare("refuzat"); // apeleaza
	 * metoda de inregistrare contabila specifica } else if (doc instanceof
	 * BiletLaOrdin) { ((BiletLaOrdin) doc).setStare("refuzat"); // apeleaza
	 * metoda de inregistrare contabila specifica }
	 * 
	 * }
	 */

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
	 * @ApplicationServiceFacade
	 */

	@Override
	public Cec inregistrareCec(Date dataEmiterii, Boolean avans, Client client,
			String seria, String numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaEmisa> facturi,
			String moneda) throws Exception {

		Cec cec;
		List<FacturaEmisa> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

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
	 * @ApplicationServiceFacade
	 */
	@Override
	public BiletLaOrdin inregistrareBiletLaOrdin(Date dataEmiterii,
			Boolean avans, Client client, String seria, String numar,
			String locatie, String stare, List<FacturaEmisa> facturi,
			Persoana garant, Date dataScadenta, Double suma,
			String sumaInLitere, String moneda) throws Exception {

		BiletLaOrdin bo;
		List<FacturaEmisa> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

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
	//metoda care ar putea apartine de modulul Vanzari
	public Double restIncasareFactura(FacturaEmisa factura) {
		return factura.getValoareTotalaFactura() - factura.getSumaIncasata();

	}
}
