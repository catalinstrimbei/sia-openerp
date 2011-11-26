package org.open.erp.services.incasari.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.open.erp.services.incasari.BiletLaOrdin;
import org.open.erp.services.incasari.Casa;
import org.open.erp.services.incasari.Cec;
import org.open.erp.services.incasari.Chitanta;
import org.open.erp.services.incasari.Incasare;
import org.open.erp.services.incasari.IncasariSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaVanzare;
import org.open.erp.services.vanzari.FacturaVanzareComparator;
import org.open.erp.services.vanzari.VanzariSrv;

public class IncasariImpl implements IncasariSrv {

	private VanzariSrv vanzariSrv;

	public VanzariSrv getVanzariSrv() {
		return vanzariSrv;
	}

	public void setVanzariSrv(VanzariSrv vanzariSrv) {
		this.vanzariSrv = vanzariSrv;
	}

	@Override
	public Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaVanzare> facturi, Date dataEmiterii, String seria,
			String numar, String locatie, String moneda, Client client)
			throws Exception {

		Chitanta chitanta;

		List<FacturaVanzare> facturiSelectate = new ArrayList<FacturaVanzare>(0);
		if (sumaIncasata > 0) {
			Calendar currentDate = Calendar.getInstance();
			Date dataInregistrarii = currentDate.getTime();

			chitanta = new Chitanta(dataEmiterii, avans, dataInregistrarii,
					sumaIncasata, sumaIncasataLitere, seria, numar, locatie,
					casier);
		
			if (facturi.size() == 0) {
				facturi = client.getFacturi();
			}
			facturiSelectate = compensariIncasariFacturi(facturi, sumaIncasata);

			chitanta.setFacturi(facturiSelectate);
		} else {
			chitanta = null;
		}

		if (avans) {
			// apeleaza metoda de inregistrare contabila specifica
		} else {
		}

		// apeleaza metoda de actualizare sold casa din ctb de gestiune

		return chitanta;

	}

	@Override
	public void confirmareIncasare(Incasare doc) throws Exception {
		if (doc instanceof Cec) {
			((Cec) doc).setStare("incasat");
			// apeleaza metoda de inregistrare contabila specifica
		} else if (doc instanceof BiletLaOrdin) {
			((BiletLaOrdin) doc).setStare("incasat");
			// apeleaza metoda de inregistrare contabila specifica
		}

	}

	@Override
	public void confirmareDepunereLaBanca(Incasare doc) {

		if (doc instanceof Cec) {
			((Cec) doc).setStare("depus");
			// apeleaza metoda de inregistrare contabila specifica
		} else if (doc instanceof BiletLaOrdin) {
			((BiletLaOrdin) doc).setStare("depus");
			// apeleaza metoda de inregistrare contabila specifica
		}

	}

	private List<FacturaVanzare> compensariIncasariFacturi(
			List<FacturaVanzare> facturi, Double suma) throws Exception {

		Collections.sort(facturi, new FacturaVanzareComparator());

		List<FacturaVanzare> facturiAsociate = new ArrayList<FacturaVanzare>();
		for (FacturaVanzare fact : facturi) {
			if (!fact.getSuma().equals(fact.getSumaIncasata())) {
				facturiAsociate.add(fact);
				Double restPlata = restIncasareFactura(fact);
				if (suma > restPlata) {
					fact.setSumaIncasata(fact.getSuma());
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

	@Override
	public Double restIncasareFactura(FacturaVanzare factura) {
		Double restPlata = factura.getSuma() - factura.getSumaIncasata();
		return restPlata;
	}

	@Override
	public void confirmareImposibilitatePlata(Incasare doc) {
		if (doc instanceof Cec) {
			((Cec) doc).setStare("refuzat");
			// apeleaza metoda de inregistrare contabila specifica
		} else if (doc instanceof BiletLaOrdin) {
			((BiletLaOrdin) doc).setStare("refuzat");
			// apeleaza metoda de inregistrare contabila specifica
		}

	}

	public Client actualizeazaSoldClient(Double suma, String idClient) {
		Client client = vanzariSrv.getClientDupaID(idClient);
		client.setSoldCurent(client.getSoldCurent() + suma);
		return client;
	}

	public Casa actualizeazaSoldCasa(Double suma) {
		Casa casa = Casa.getCasa();
		casa.setSoldCurent(casa.getSoldCurent() + suma);
		return casa;
	}

	public Double getSumaRON(String moneda, Double suma, Double curs) {
		if (moneda.equals("EURO")) {
			suma = suma * curs;
		}
		return suma;
	}

	@Override
	public Cec inregistrareCec(Date dataEmiterii, Boolean avans, Client client,
			String seria, String numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaVanzare> facturi,
			String moneda) throws Exception {
		
		Cec cec;
		List<FacturaVanzare> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();
		
		cec = new Cec(dataEmiterii, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie, stare);

		if (facturi.size() == 0) {
			facturi = client.getFacturi();
		}
		facturiSelectate = compensariIncasariFacturi(facturi, suma);

		cec.setFacturi(facturiSelectate);
		// apeleaza metoda de inregistrare articol contabil(operatiune) specific
		// apeleaza metoda de actualizare sold cont bancar din ctb de gestiune
		return cec;
	}

	@Override
	public BiletLaOrdin inregistrareBiletLaOrdin(Date dataEmiterii,
			Boolean avans, Client client, String seria, String numar,
			String locatie, String stare, List<FacturaVanzare> facturi,
			Persoana garant, Date dataScadenta, Double suma,
			String sumaInLitere, String moneda) throws Exception {

		BiletLaOrdin bo;
		List<FacturaVanzare> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

	
			bo = new BiletLaOrdin(dataEmiterii, avans, dataInregistrarii, suma,
					sumaInLitere, seria, numar, locatie, dataScadenta, garant,
					stare);

			if (facturi.size() == 0) {
				facturi = client.getFacturi();
			}
			facturiSelectate = compensariIncasariFacturi(facturi, suma);

			bo.setFacturi(facturiSelectate);
	
		// apeleaza metoda de inregistrare contabila specifica
		// apeleaza metoda de actualizare sold cont bancar din ctb de gestiune
		return bo;
	}
}
