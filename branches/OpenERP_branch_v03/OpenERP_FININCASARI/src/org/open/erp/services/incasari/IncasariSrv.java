package org.open.erp.services.incasari;

import java.util.Date;

import java.util.List;

import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.incasari.exception.IncasariException;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;

public interface IncasariSrv {

	void confirmareIncasare(Incasare doc) throws IncasariException,
			NumberFormatException, CtbException;

	void confirmareDepunereLaBanca(Incasare doc);

	Double getSumaRON(String moneda, Double suma, Double curs);

	Double restIncasareFactura(FacturaEmisa factura);

	Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaEmisa> facturi, Date dataEmiterii, String seria,
			Integer numar, String locatie, String moneda, Client client,
			Double curs) throws IncasariException, CtbException;

	Cec inregistrareCec(Date dataEmiterii, Boolean avans, Client client,
			String seria, Integer numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaEmisa> facturi,
			String moneda, Double curs) throws IncasariException;

	BiletLaOrdin inregistrareBiletLaOrdin(Date dataEmiterii, Boolean avans,
			Client client, String seria, Integer numar, String locatie,
			String stare, List<FacturaEmisa> facturi, Persoana garant,
			Date dataScadenta, Double suma, String sumaInLitere, String moneda,
			Double curs) throws IncasariException;

	void confirmareImposibilitatePlata(Incasare doc);

	ExtrasCont inregistrareExtrasCont(Date dataEmiterii, Boolean avans,
			Client client, String seria, Integer numar, String locatie,
			List<FacturaEmisa> facturi, Double suma, String sumaInLitere,
			String moneda, Double curs) throws IncasariException;
}
