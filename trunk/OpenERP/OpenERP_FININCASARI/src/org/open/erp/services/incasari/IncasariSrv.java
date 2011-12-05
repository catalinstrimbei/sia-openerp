package org.open.erp.services.incasari;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;


public interface IncasariSrv {
	
     void confirmareIncasare(Incasare doc) throws Exception;
    
    void confirmareDepunereLaBanca(Incasare doc);

	Double getSumaRON(String moneda, Double suma, Double curs);

	Double restIncasareFactura(FacturaEmisa factura);

	BiletLaOrdin inregistrareBiletLaOrdin(Date dataEmiterii, Boolean avans,
			Client client, String seria, String numar, String locatie,
			String stare, List<FacturaEmisa> facturi, Persoana garant,
			Date dataScadenta, Double suma, String sumaInLitere, String moneda)
			throws Exception;

	Cec inregistrareCec(Date dataEmiterii, Boolean avans, Client client,
			String seria, String numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaEmisa> facturi,
			String moneda) throws Exception;

	Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaEmisa> facturi, Date dataEmiterii, String seria,
			String numar, String locatie, String moneda, Client client)
			throws Exception;
}
