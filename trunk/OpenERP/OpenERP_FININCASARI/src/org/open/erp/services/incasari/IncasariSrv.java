package org.open.erp.services.incasari;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaVanzare;

public interface IncasariSrv {
	
	 void confirmareImposibilitatePlata(Incasare doc);
	
     void confirmareIncasare(Incasare doc) throws Exception;
    
    void confirmareDepunereLaBanca(Incasare doc);
        
	Client actualizeazaSoldClient(Double suma, String idClient);
	Casa actualizeazaSoldCasa(Double suma);
	Double getSumaRON(String moneda, Double suma, Double curs);

	Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaVanzare> facturi, Date dataEmiterii, String seria,
			String numar, String locatie, String moneda, Client client)
			throws Exception;

	Double restIncasareFactura(FacturaVanzare factura);

	BiletLaOrdin inregistrareBiletLaOrdin(Date dataEmiterii, Boolean avans,
			Client client, String seria, String numar, String locatie,
			String stare, List<FacturaVanzare> facturi, Persoana garant,
			Date dataScadenta, Double suma, String sumaInLitere, String moneda)
			throws ParseException, Exception;

	Cec inregistrareCec(Date dataEmiterii, Boolean avans, Client client,
			String seria, String numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaVanzare> facturi,
			String moneda) throws ParseException, Exception;
}
