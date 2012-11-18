package org.open.erp.services.finincasari.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.StareDocument;
import org.open.erp.services.contabgen.TipIncasare;
import org.open.erp.services.contagen.exception.ContaException;
import org.open.erp.services.finincasari.BiletLaOrdine;
import org.open.erp.services.finincasari.CEC;
import org.open.erp.services.finincasari.Chitanta;
import org.open.erp.services.finincasari.ExtrasCont;
import org.open.erp.services.finincasari.FinIncasari;
import org.open.erp.services.finincasari.FinanciarIncasariSrvLocal;
import org.open.erp.services.finincasari.FinanciarIncasariSrvRemote;
import org.open.erp.services.finincasari.exception.FinanciarIncasariException;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;
import org.open.erp.services.vanzari.VanzariSrv;


public  class FinanciarIncasariImpl implements FinanciarIncasariSrvLocal,FinanciarIncasariSrvRemote {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(FinanciarIncasariImpl.class.getName());

	private VanzariSrv vanzariSrv;
	private ContabilitateGeneralaSrv contaSrv;
	private EntityManager entityManager;
	
	public void init() {
		
		logger.debug("PersonalSrv" + vanzariSrv);
		logger.debug("ContabilitateaGeneralaSrv" + contaSrv);
		logger.debug("EntityManager: " + entityManager);

		if (this.registru == null)
			registru = new RegistruIncasari(entityManager);
	}
		
	private RegistruIncasari registru = new RegistruIncasari();

	private Object sessionContext;
	
	public VanzariSrv getVanzariSrv() {
		return vanzariSrv;
	}
	public void setVanzariSrv(VanzariSrv vanzariSrv) {
		this.vanzariSrv = vanzariSrv;
	}
	public ContabilitateGeneralaSrv getContaSrv() {
		return contaSrv;
	}
	public void setContaSrv(ContabilitateGeneralaSrv contaSrv) {
		this.contaSrv = contaSrv;
	}
	
	public Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaEmisa> facturi, Date dataEmitere, String seria,
			Integer numar, String locatie, String moneda, Client client,
			Double curs) throws FinanciarIncasariException {

		// Se efectueaza inregistrarea platii in contabilitate pe baza chitantei
		// Se specifica, ca suma incasata sa nu fie nula, apoi se instantiaza o
		// noua chitanta pe baza unei sau a mai multor facturi
		if (sumaIncasata == null || sumaIncasata == 0.00) {
			throw new FinanciarIncasariException("Suma incasarii nu poate fi nula!");
		}
		Chitanta chitanta;
		
		List<FacturaEmisa> facturiSelectate = new ArrayList<FacturaEmisa>(0);
		Date dataInregistrarii = new Date();
	

		chitanta = new Chitanta(dataEmitere, avans, dataInregistrarii,
				sumaIncasata, sumaIncasataLitere, seria, numar, locatie, casier);

		if (facturi.size() == 0) {
			 facturi = vanzariSrv.getFacturiClient(client);
		}
		if (!moneda.equals("RON")) {
			sumaIncasata = getSumaRON(moneda, sumaIncasata, curs);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, sumaIncasata);

		chitanta.setFacturi((ArrayList<FacturaEmisa>) facturiSelectate);

		if (((Chitanta) sessionContext).getRollbackOnly() == true) {
			logger.debug("END inregistrareChitanta - FAILED TRANSACTION");
		} else {
			try {
				chitanta = (Chitanta) this.registru.salveazaIncasare(chitanta);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// inregistrarea in contabilitate a platii se face in functie de tipul
		// incasarii
		TipIncasare tipIncasare = TipIncasare.CASA;
		try {
			if (avans) {
				tipIncasare = TipIncasare.AVANS;
			}
			jurnalizareIncasareNoua(chitanta, tipIncasare, 401);

		} catch (Exception e) {
			throw new FinanciarIncasariException(e.getMessage());
		}

		return chitanta;

	}
	
	

	
	
	public void confirmareIncasare(FinIncasari doc) throws ContaException,FinanciarIncasariException {
// Jurnalizeaza notele contabile aferente efectuarii unei plati, in
// functie de
// documentul de plata(cec sau bilet la ordin)

TipIncasare tipIncasare = null;

		if (doc instanceof CEC) {

	      ((CEC) doc).setStare("incasat");
	      tipIncasare = TipIncasare.CEC;
} 
		else if (doc instanceof BiletLaOrdine) {

	
			((BiletLaOrdine) doc).setStare("incasat");
	
			tipIncasare = TipIncasare.BiletOrdine;

		}


		if (((CEC) sessionContext).getRollbackOnly() == true) {
	
			logger.debug("FAILED TRANSACTION");

		} else {
	
			try {
	
				this.registru.salveazaIncasare(doc);
	
			} catch (Exception e) {
	
				e.printStackTrace();
	}
}
		jurnalizareIncasareModificata(doc, tipIncasare, 0);

}
	private void jurnalizareIncasareModificata(FinIncasari doc,
			TipIncasare tipIncasare, int i) {
		// TODO Auto-generated method stub
		
	}
	public void confirmareDepunereLaBanca(FinIncasari doc) {
		// Jurnalizarea depunerii cec-ului sau biletului la ordin

		if (doc instanceof CEC) {

			((CEC) doc).setStare("depus");
		} else if (doc instanceof BiletLaOrdine) {

			((BiletLaOrdine) doc).setStare("depus");
		}
		// Se schimba starea documentului in "depus"

		if (((CEC) sessionContext).getRollbackOnly() == true) {
			logger.debug("FAILED TRANSACTION");
		} else {
			try {
				this.registru.salveazaIncasare(doc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @ApplicationServiceFacade
	 */

	private List<FacturaEmisa> compensariIncasariFacturi(
			List<FacturaEmisa> facturi, Double suma) throws FinanciarIncasariException {
		
		// Verifica achitarea facturilor in ordine cronologica
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
			throw new FinanciarIncasariException(
					"Suma incasata depaseste suma de incasat");
		}
		return facturiAsociate;

	}
	
	
	public void confirmareImposibilitatePlata(FinIncasari doc) {
		// Se constata imposibilitatea de plata a clientului, daca starea
		// cec-ului sau biletului la ordin este "refuzat"
		
		if (doc instanceof CEC) {

			((CEC) doc).setStare("refuzat");
		} else if (doc instanceof BiletLaOrdine) {

			 ((BiletLaOrdine) doc).setStare("refuzat");
		}
		// Se schimba starea documentului in "refuzat"

		if (((BiletLaOrdine) sessionContext).getRollbackOnly() == true) {
			logger.debug("FAILED TRANSACTION");
		} else {
			try {
				this.registru.salveazaIncasare(doc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Double getSumaRON(String moneda, Double suma, Double curs) {
		// Calculeaza suma in functie de moneda in care se efectueaza plata
		
		if (moneda.equals("EURO")) {
			suma = suma * curs;
		}
		return suma;

}
	public CEC inregistrareCEC(Date dataEmitere, Boolean avans, Client client,
			String seria, Integer numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaEmisa> facturi,
			String moneda, Double curs) throws FinanciarIncasariException {
		// Se efectueaza inregistrarea platii in contabilitate pe baza unui cec
		// Se specifica, ca suma incasata sa nu fie nula, apoi se instantiaza o
		// noua inregistrare in baza de date
		if (suma == null || suma == 0.00) {
			throw new FinanciarIncasariException("Suma incasarii nu poate fi nula!");
		}
		CEC cec;
		List<FacturaEmisa> facturiSelectate;
		Date dataInregistrarii = new Date();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}
		cec = new CEC(dataEmitere, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie,stare);

		if (facturi.size() == 0) {
			 facturi = vanzariSrv.getFacturiClient(client);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, suma);

		cec.setFacturi(facturiSelectate);

		if (((CEC) sessionContext).getRollbackOnly() == true) {
			logger.debug("FAILED TRANSACTION");
		} else {
			try {
				cec = (CEC) this.registru.salveazaIncasare(cec);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return cec;
	}
	
	
	public BiletLaOrdine inregistrareBiletLaOrdin(Date dataEmitere,
			Boolean avans, Client client, String seria, Integer numar,
			String locatie, String stare, List<FacturaEmisa> facturi,
			Persoana garant, Date dataScadenta, Double suma,
			String sumaInLitere, String moneda, Double curs)
			throws FinanciarIncasariException {
		// Se efectueaza inregistrarea platii in contabilitate pe baza unui
		// bilet la ordin
		// Se specifica, ca suma incasata sa nu fie nula, apoi se instantiaza o
		// noua inregistrare in baza de date

		if (suma == null || suma == 0.00) {
			throw new FinanciarIncasariException("Suma incasarii nu poate fi nula!");
		}
		BiletLaOrdine biletOrdine;
		List<FacturaEmisa> facturiSelectate;
		Date dataInregistrarii = new Date();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}

		biletOrdine = new BiletLaOrdine(dataEmitere, avans, dataInregistrarii, suma,
				sumaInLitere, seria, numar, locatie, dataScadenta, garant,
				stare);

		if (facturi.size() == 0) {
			 facturi = vanzariSrv.getFacturiClient(client);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, suma);

		biletOrdine.setFacturi(facturiSelectate);

		if (((BiletLaOrdine) sessionContext).getRollbackOnly() == true) {
			logger.debug("FAILED TRANSACTION");
		} else {
			try {
				biletOrdine = (BiletLaOrdine) this.registru.salveazaIncasare(biletOrdine);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return biletOrdine;
	}

	
	public Double restIncasareFactura(FacturaEmisa factura) {
		// Calculeaza diferenta dintre suma totala a facturii si suma incasata
		return factura.getValoareTotalaFactura() - factura.getSumaIncasata();

	}

	
	public ExtrasCont inregistrareExtrasCont(Date dataEmitere, Boolean avans,
			Client client, String seria, Integer numar, String locatie,
			List<FacturaEmisa> facturi, Double suma, String sumaInLitere,
			String moneda, Double curs) throws FinanciarIncasariException {
		// Se efectueaza inregistrarea platii in contabilitate pe baza unui
		// extras de cont
		// Se specifica, ca suma incasata sa nu fie nula, apoi se instantiaza o
		// noua inregistrare in baza de date
		if (suma == null || suma == 0.00) {
			throw new FinanciarIncasariException("Suma incasarii nu poate fi nula!");
		}
		ExtrasCont extrasCont;
		List<FacturaEmisa> facturiSelectate;
		Date dataInregistrarii = new Date();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}

		extrasCont = new ExtrasCont(dataEmitere, avans, dataInregistrarii,
				suma, sumaInLitere, seria, numar, locatie);

		if (facturi.size() == 0) {
			facturi = vanzariSrv.getFacturiClient(client);
		}
		facturiSelectate = compensariIncasariFacturi(facturi, suma);

		extrasCont.setFacturi(facturiSelectate);

		if (((ExtrasCont) sessionContext).getRollbackOnly() == true) {
			logger.debug("FAILED TRANSACTION");
		} else {
			try {
				extrasCont = (ExtrasCont) this.registru.salveazaIncasare(extrasCont);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return extrasCont;
	}
	
	void jurnalizareIncasareNoua(FinIncasari incasare, TipIncasare tipIncasare,
			Integer cont) {
		contaSrv.jurnalizareIncasare(incasare.getDataInregistrarii(),
				incasare.getSuma(), incasare.getNumar(), tipIncasare, incasare.getFacturi().get(0).getClient().getIdClient(), cont,
				StareDocument.NOU, null);
	}

	void jurnalizareIncasareModificata(FinIncasari incasare,
			TipIncasare tipIncasare, Integer cont) {
		contaSrv.jurnalizareIncasare(incasare.getDataInregistrarii(),
				incasare.getSuma(), incasare.getNumar(), tipIncasare, incasare
						.getFacturi().get(0).getClient().getIdClient(), cont,
				StareDocument.MODIFICAT, null);

	}
	@Override
	public Double restIncasareFact(FacturaEmisa factura) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void confiramreImposibilitateplata(FinIncasari doc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Chitanta inregistrareChitanta(Angajat casier, Double valueOf,
			String string, boolean b, List<FacturaEmisa> facturi,
			Date dataEmitere, String string2, int i, String string3,
			String string4, Client client, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CEC inregistrareCEC(Date dataEmitere, boolean b, Client client,
			String string, int i, String string2, String string3,
			Double valueOf, String string4, List<FacturaEmisa> facturi,
			String string5, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BiletLaOrdine inregistrareBiletLaOrdine(Date dataEmitere, boolean b,
			Client client, String string, int i, String string2,
			String string3, List<FacturaEmisa> facturi, Persoana garant,
			Date dataScadenta, Double valueOf, String string4, String string5,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setContabilitateGeneralaSrv(Object contabilitateGeneralaSrv) {
		// TODO Auto-generated method stub
		
	}
}