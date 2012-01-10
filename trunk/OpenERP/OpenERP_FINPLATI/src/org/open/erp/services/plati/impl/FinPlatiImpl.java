package org.open.erp.services.plati.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;

import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.TipPlata;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.plati.Chitanta;
import org.open.erp.services.plati.exceptions.PlatiExceptions;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.plati.CEC;
import org.open.erp.services.plati.ExtrasCont;
import org.open.erp.services.plati.FacturaPrimita;
import org.open.erp.services.plati.FinPlatiSrvLocal;
import org.open.erp.services.plati.FinPlatiSrvRemote;
import org.open.erp.services.plati.OrdinPlata;
import org.open.erp.services.plati.Plata;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.achizitii.AprovizionareSrv;

@Stateful
public class FinPlatiImpl implements FinPlatiSrvLocal, FinPlatiSrvRemote {

	private VanzariSrv vanzariSrv;
	private ContabilizareSrv ctbSrv;
	private AprovizionareSrv aproSrv;
	
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
	

	@Override
	public void confirmareDepunereLaBanca(Plata doc) {
		// TODO Auto-generated method stub
		if (doc instanceof CEC) {
			((CEC) doc).setStare("depus");

		} else if (doc instanceof OrdinPlata) {
			((OrdinPlata) doc).setStare("depus");
		}
	}

	@Override
	public Double getSumaRON(String moneda, Double suma, Double curs) {
		if (moneda.equals("EURO")) {
			suma = suma * curs;
		}
		return suma;
	}

	@Override
	public Double restPlataFactura(FacturaPrimita factura) {
		return factura.getValoareTotalaFactura() - factura.getSumaPlatita();
	}

	@Override
	public Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			Boolean avans, List<FacturaPrimita> facturi, Date dataEmiterii,
			String seria, Integer numar, String locatie, String moneda,
			Furnizor furnizor, Double curs) throws PlatiExceptions,
			CtbException {
		// TODO Auto-generated method stub
		
		if (sumaIncasata == null ||  sumaIncasata == 0.00 ) {
			throw new PlatiExceptions("Suma incasarii nu poate fi nula!");
		}
		Chitanta chitanta;

		List<FacturaPrimita> facturiSelectate = new ArrayList<FacturaPrimita>(0);
		
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		chitanta = new Chitanta(dataEmiterii, avans, dataInregistrarii,
				sumaIncasata, seria, numar, locatie, casier);

		if (facturi.size() == 0) {
			facturi = getFacturiFurnizor(furnizor);
		}
		if (!moneda.equals("RON")) {
			sumaIncasata = getSumaRON(moneda, sumaIncasata, curs);
		}
		
		facturiSelectate = compensariParteneri(facturi, sumaIncasata);

		chitanta.setFacturi(facturiSelectate);
		try {
			if (avans) {

				ctbSrv.jurnalizarePlata(dataInregistrarii,
						sumaIncasata, numar, TipPlata.AVANSC,
						furnizor.getId(), 401, StareDocument.NOU, null);

			}

			else {

				ctbSrv.jurnalizarePlata(dataInregistrarii,
						sumaIncasata, numar, TipPlata.CASA, furnizor.getId(),
						401, StareDocument.NOU, null);
				
			}

		} catch (Exception e) {
			throw new PlatiExceptions(e.getMessage());
		}

		return chitanta;
	}

	public List<FacturaPrimita> compensariParteneri(
			List<FacturaPrimita> facturi, Double suma) throws PlatiExceptions{
		// TODO Auto-generated method stub

		List<FacturaPrimita> facturiAsociate = new ArrayList<FacturaPrimita>();
		for (FacturaPrimita fact : facturi) {
			if (!fact.getPlatita()) {
				facturiAsociate.add(fact);
				Double restPlata = restPlataFactura(fact);
				if (suma > restPlata) {
					fact.setSumaPlatita(fact.getValoareTotalaFactura());
					suma -= restPlata;
				} else {
					fact.setSumaPlatita(fact.getSumaPlatita() + suma);
					suma = 0.00;
					break;
				}

			}

		}
		if (suma > 0) {
			throw new PlatiExceptions(
					"Suma platita depaseste suma de platit");
		}
		return facturiAsociate;
		
	}

	@Override
	public CEC inregistrareCEC(Date dataEmiterii, Boolean avans,
			Furnizor furnizor, String seria, Integer numar, String locatie,
			String stare, Double suma, List<FacturaPrimita> facturi,
			String moneda, Double curs) throws PlatiExceptions {
		// TODO Auto-generated method stub
		if (suma == null ||  suma == 0.00 ) {
			throw new PlatiExceptions("Suma incasarii nu poate fi nula!");
		}
		CEC cec;
		List<FacturaPrimita> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}
		cec = new CEC(dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie, stare);

		if (facturi.size() == 0) {
			facturi = getFacturiFurnizor(furnizor);
		}
		facturiSelectate = compensariParteneri(facturi, suma);

		cec.setFacturi(facturiSelectate);

		return cec;
	}

	@Override
	public OrdinPlata inregistrareOrdinPlata(Date dataEmiterii, Boolean avans,
			Furnizor furnizor, String seria, Integer numar, String locatie,
			String stare, Double suma, List<FacturaPrimita> facturi,
			String moneda, Double curs) throws PlatiExceptions {
		if (suma == null ||  suma == 0.00 ) {
			throw new PlatiExceptions("Suma incasarii nu poate fi nula!");
		}
		OrdinPlata op;
		List<FacturaPrimita> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}
		op = new OrdinPlata(dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie, stare);

		if (facturi.size() == 0) {
			facturi = getFacturiFurnizor(furnizor);
		}
		facturiSelectate = compensariParteneri(facturi, suma);

		op.setFacturi(facturiSelectate);

		return op;
	}

	@Override
	public ExtrasCont inregistrareExtrasCont(Date dataEmiterii, Boolean avans,
			Furnizor furnizor, String seria, Integer numar, String locatie,
			List<FacturaPrimita> facturi, Double suma, String moneda,
			Double curs) throws PlatiExceptions {
		if (suma == null ||  suma == 0.00 ) {
			throw new PlatiExceptions("Suma incasarii nu poate fi nula!");
		}
		ExtrasCont extrasCont;
		List<FacturaPrimita> facturiSelectate;
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();

		if (!moneda.equals("RON")) {
			suma = getSumaRON(moneda, suma, curs);
		}

		extrasCont = new ExtrasCont(dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);

		if (facturi.size() == 0) {
			facturi = getFacturiFurnizor(furnizor);
		}
		facturiSelectate = compensariParteneri(facturi, suma);

		extrasCont.setFacturi(facturiSelectate);

		return extrasCont;
	}
	

	public AprovizionareSrv getAproSrv() {
		return aproSrv;
	}

	public void setAproSrv(AprovizionareSrv aproSrv) {
		this.aproSrv = aproSrv;
	}
	
	@Override
	public ArrayList<FacturaPrimita> getFacturiFurnizor(Furnizor furnizor) {
		
		FacturaPrimita factura = new FacturaPrimita();
		factura.getIdFactura();
		factura.getFurnizor();
		factura.getPlatita();
		
		ArrayList<FacturaPrimita> facturi = new ArrayList<FacturaPrimita>();
		facturi.add(factura);
		return facturi;
	}
	
	/**
	 * @throws CtbException
	 * @throws NumberFormatException
	 * @ApplicationServiceFacade
	 */

	@Override
	public void confirmarePlata(Plata doc) throws CtbException,
			PlatiExceptions {
		Calendar currentDate = Calendar.getInstance();
		Date dataInregistrarii = currentDate.getTime();
		if (doc instanceof CEC) {

			((CEC) doc).setStare("platit");

			ctbSrv.jurnalizarePlata(dataInregistrarii, doc.getSuma(),
					doc.getNumar(), TipPlata.CEC, doc.getFacturi().get(0)
							.getFurnizor().getId(), 0, StareDocument.MODIFICAT, 0);

		} else if (doc instanceof OrdinPlata) {
			((OrdinPlata) doc).setStare("platit");

			ctbSrv.jurnalizarePlata(dataInregistrarii, doc.getSuma(),
					doc.getNumar(), TipPlata.OrdinPlata, doc.getFacturi().get(0)
							.getFurnizor().getId(), 0, StareDocument.MODIFICAT, 0);
		}
	}
	
	public int acceptaPlataFurnizor(Partener partener,Double valoare, Date data){
		return 1;		
	}
}
